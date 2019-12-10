/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
    private:
        bool isMatched = false;
public:
    bool hasPathSum(TreeNode* root, int sum) {
        dfs(root, 0, sum);
        return isMatched;
    }
    
    void dfs(TreeNode* node, int sum_curr, int sum_target){
        if (node == NULL) return;
        sum_curr += node->val;
        if (!node->left && !node->right){
            if (sum_curr == sum_target){
                cout << "matched" <<endl;
                isMatched = true;
                return;
            }
        }
        dfs(node->left, sum_curr, sum_target);
        dfs(node->right, sum_curr, sum_target);
    }
};
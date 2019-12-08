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
        int max_level = 0;
public:
    int maxDepth(TreeNode* root) {
        dfs(root, 0);
        return max_level;
    }
    
    void dfs(TreeNode* node, int current_level){
        if (node == NULL){
            if (current_level > max_level){
                max_level = current_level;
            }
            return;
        }
        dfs(node->left, current_level + 1);
        dfs(node->right, current_level + 1);
    }
};
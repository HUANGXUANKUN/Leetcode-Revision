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
    int getHeight (TreeNode* node){
        if (node == NULL){ // if root is null, height is 0
            return 0;
        }
        return 1 + max(getHeight(node->left), getHeight(node->right));
    }
public:
    bool isBalanced(TreeNode* root) {
        if (root == NULL) return true;
        return abs(getHeight(root->left) - getHeight(root->right)) < 2 && isBalanced(root->left) && isBalanced(root->right);
    }
};
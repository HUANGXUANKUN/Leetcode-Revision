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
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return inorder_build(nums, 0, nums.size()-1);
    }
    
    TreeNode* inorder_build(vector<int>&nums, int left, int right){
        if (left > right) return NULL;
        int p = (left + right) / 2;
        TreeNode* node = new TreeNode(nums[p]);
        node->left = inorder_build(nums, left, p-1);
        node->right = inorder_build(nums, p+1, right);
        return node;
    }
};
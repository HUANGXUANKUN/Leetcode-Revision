// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int[] inorder_1;
    int[] preorder_1;
    int preorder_idx = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        preorder_1 = preorder;
        inorder_1 = inorder;
        int idx = 0;
        for (int x : inorder)
            map.put(x, idx++);
        return build(0, preorder.length-1);
    }
    
    TreeNode build(int start, int end){
        if(start > end) return null;
        int root_value = preorder_1[preorder_idx];
        preorder_idx++;
        int root_index = map.get(root_value);
        TreeNode root = new TreeNode(root_value);
        // left
        root.left = build(start, root_index-1);
        //right
        root.right = build(root_index+1, end);
        return root;
    }
}

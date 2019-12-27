// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
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
    int post_idx;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        post_idx = postorder.length;
        return build(0, postorder.length-1, postorder);
    }
    
    TreeNode build(int start, int end, int[] postorder){
        if (start > end) return null;
        post_idx--;
        int root_value = postorder[post_idx];
        int root_index = map.get(root_value);
        TreeNode root = new TreeNode(root_value);
        // right sub [root index+1, end]
        root.right = build(root_index+1, end, postorder);
        // left sub [start, root index-1]
        root.left = build(start, root_index-1, postorder);        
        
        return root;
    }
}

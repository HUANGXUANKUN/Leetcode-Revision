// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
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
    final List<List<Integer>> final_list = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 1);
        return final_list;
    }
    
    void traverse(TreeNode root, int level){
        if(root == null) return;
        if (level > final_list.size()){
            final_list.add(new ArrayList<Integer>());
        }
        final_list.get(level-1).add(root.val);            
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}

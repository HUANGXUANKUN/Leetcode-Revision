// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
// Note:
//
//
// 	Given target value is a floating point.
// 	You are guaranteed to have only one unique value in the BST that is closest to the target.
//
//
// Example:
//
//
// Input: root = [4,2,5,1,3], target = 3.714286
//
//     4
//    / \
//   2   5
//  / \
// 1   3
//
// Output: 4
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
    int prev = Integer.MIN_VALUE;
    int curr = Integer.MIN_VALUE;
    Integer curr_found = null;
    Integer prev_found = null;
    public int closestValue(TreeNode root, double target) {
        if(root.left == null && root.right == null) return root.val;
        inorder_search(root, target);
        if(curr_found != null){
            if(prev_found == Integer.MIN_VALUE || Math.abs(curr_found-target) < Math.abs(prev_found - target)){
                return curr_found;
            }
            return prev_found;
        }
        return curr;
    }
    
    void inorder_search(TreeNode root, double target){
        if(root == null) return;
        inorder_search(root.left, target);
        prev = curr;
        curr = root.val;
        System.out.println("curr: " + curr);
        if(curr_found == null && (double)curr >= target){
            System.out.println("found " + curr);
            prev_found = prev;
            curr_found = curr;
            return;
        }
        inorder_search(root.right, target);
    }
}

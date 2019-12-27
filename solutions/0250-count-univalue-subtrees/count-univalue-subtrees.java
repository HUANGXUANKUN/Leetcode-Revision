// Given a binary tree, count the number of uni-value subtrees.
//
// A Uni-value subtree means all nodes of the subtree have the same value.
//
// Example :
//
//
// Input:  root = [5,1,5,5,5,null,5]
//
//               5
//              / \
//             1   5
//            / \   \
//           5   5   5
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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        traverse(root, 0);
        return count;
    }
    
    boolean traverse(TreeNode root, int parentVal){
        if (root == null) return true;
        
        // if childs are same, count++
        if (traverse(root.left, root.val) & traverse(root.right, root.val)){
            count++;
        }
        
        else return false;
        
        return root.val == parentVal;
    }
}

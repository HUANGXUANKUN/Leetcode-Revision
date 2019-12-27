// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
// Example:
//
//
// Input: 3
// Output:
// [
//   [1,null,3,2],
//   [3,2,null,1],
//   [3,1,null,null,2],
//   [2,1,3],
//   [1,null,2,null,3]
// ]
// Explanation:
// The above output corresponds to the 5 unique BST's shown below:
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> trees = new LinkedList<TreeNode>(); 
        // only 1 node
        if (start == end){
            trees.add(new TreeNode(start));
            return trees;
        }
        
        else if (start > end){
            trees.add(null);
            return trees;
        }
        List<TreeNode> left_trees = new LinkedList<TreeNode>(); 
        List<TreeNode> right_trees = new LinkedList<TreeNode>(); 
        for (int i = start; i <= end; i++){
            left_trees = helper(start,i-1);
            right_trees = helper(i+1, end);
            // combine left branch and right branch
            for (TreeNode left : left_trees){
                for(TreeNode right: right_trees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}

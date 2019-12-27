// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
//
//
//  
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//     1
//    / \
//   2   2
//    \   \
//    3    3
//
//
//  
//
// Note:
// Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        // use bfs level order traversal
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode left = q.poll();                
                TreeNode right = q.poll();            
                if (left == null && right == null) continue;
                if (left == null || right == null || left.val != right.val) return false;
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }
        }
        return true;
    }
}

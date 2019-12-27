// Two elements of a binary search tree (BST) are swapped by mistake.
//
// Recover the tree without changing its structure.
//
// Example 1:
//
//
// Input: [1,3,null,null,2]
//
//    1
//   /
//  3
//   \
//    2
//
// Output: [3,1,null,null,2]
//
//    3
//   /
//  1
//   \
//    2
//
//
// Example 2:
//
//
// Input: [3,1,4,null,null,2]
//
//   3
//  / \
// 1   4
//    /
//   2
//
// Output: [2,1,4,null,null,3]
//
//   2
//  / \
// 1   4
//    /
//   3
//
//
// Follow up:
//
//
// 	A solution using O(n) space is pretty straight forward.
// 	Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = find_two_swapped_element(nums);
        recover(root, swapped[0], swapped[1]);
    }
    
    private void inorder(TreeNode root, List<Integer> nums){
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
    
    private int[] find_two_swapped_element(List<Integer> nums){
        Integer x = null;
        Integer y = null;
        // iterate 0...n-1
        for(int i = 0; i < nums.size()-1; i++){
            if (nums.get(i) > nums.get(i+1)){
                y = nums.get(i+1);
                if(x == null){
                    x = nums.get(i);
                }
                else break; //Break after second swapped element being searched. 
            }
        }
        return new int[]{x, y};
    }
    
    private void recover(TreeNode root, int x, int y){
        if (root==null) return;
        recover(root.left, x, y);
        if (x == root.val || y == root.val){
            root.val = root.val == x ? y : x;
        }
        recover(root.right,x ,y);
    }
}

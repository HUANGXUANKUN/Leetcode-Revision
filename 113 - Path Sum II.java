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
    private List<List<Integer>> lists = new LinkedList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new LinkedList<>();
        traverse(root, sum, list);
        return lists;
    }
    void traverse(TreeNode root, int sum, List<Integer> list){
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == root.val){
                lists.add(new ArrayList<>(list));
            }
        }
        traverse(root.left, sum-root.val, list);
        traverse(root.right, sum-root.val, list);
        list.remove(list.size()-1);
    }
}
# Menu

- [Menu](#menu)
- [Main](#main)
  * [1. Two sums](#1-two-sums)





# Main

## 1. Two sums

Use map to achieve O(N) time complexity

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int complement = target - num;
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[]{i, map.get(complement)};
            }
        }
        return nums;
    }
}
```

Time: O(N)

Space: O(N) 



## 94. Binary Tree Inorder Traversal

1. Return if root is null
2. DFS root.left
3. Add root.val to List
4. DFS root.right

```java
class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return list;
    }
    
    void traverse(TreeNode root){
        if (root == null) return;
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
```



## 95. Unique Binray Seach Trees II

> **Approach 1: Recursion**
>
> Let's pick up number `i` out of the sequence `1 ..n` and use it as the root of the current tree. Then there are `i - 1` elements available for the construction of the left subtree and `n - i` elements available for the right subtree. As we [already discussed](https://leetcode.com/articles/unique-binary-search-trees/) that results in `G(i - 1)` different left subtrees and `G(n - i)` different right subtrees, where `G` is a Catalan number.
>
> ![BST](https://leetcode.com/problems/unique-binary-search-trees-ii/Figures/96_BST.png)
>
> Now let's repeat the step above for the sequence `1 ... i - 1` to construct all left subtrees, and then for the sequence `i + 1 ... n` to construct all right subtrees.
>
> This way we have a root `i` and two lists for the possible left and right subtrees. The final step is to loop over both lists to link left and right subtrees to the root.

```java
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
        return generate(1, n);
    }
    
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> all_trees = new LinkedList<>();
        if (start > end){
            all_trees.add(null);
        }
        for (int i = start; i <= end; i++){
            // left sub-branches
            List<TreeNode> left_trees = generate(start, i-1);
            // right sub-branches
            List<TreeNode> right_trees = generate(i+1, end);
            
            // combine left branches and right branches by G(start, i-1) * G(i+1, 					end)
            // if start == end, G(start, start-1) return [null], G(start+1, end) 				return [null]. It will only loop once
            for (TreeNode left : left_trees){
                for(TreeNode right: right_trees){
                    TreeNode current_root = new TreeNode(i);
                    current_root.left = left;
                    current_root.right = right;
                    all_trees.add(current_root);
                }
            }
        }
        return all_trees;
    }
}
```



## 96. Unique Binary Search Trees

1. Iterate from 0 to n, return G(0, 0, n) 
   1. Base case: If n = 1, return 1.  if n = 2, return 2
   2. Let G(i, start, end) denotes root = array[i]
   3. count = G(i, start, i-1) * G(i+1, end) //left * right





```java
class Solution {
    private int[] nums = {1,1};
    public int numTrees(int n) {
        if(nums.length-1 < n){
            nums = new int[n+1];
            nums[0] = 1;
            nums[1] = 1;
        }
        if (nums[n] != 0) return nums[n];
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += numTrees(i-1) * numTrees(n-i); //sum = left sub * right sub
        }
        nums[n] = sum;
        return sum;
    }
}
```


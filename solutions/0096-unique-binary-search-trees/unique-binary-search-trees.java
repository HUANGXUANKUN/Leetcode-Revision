// Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
// Example:
//
//
// Input: 3
// Output: 5
// Explanation:
// Given n = 3, there are a total of 5 unique BST's:
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
//
//


class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    

    
    public int numTrees(int n) {
        if (n <= 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += numTrees(i-1) * numTrees(n-i);
        }
        map.put(n, sum);
        return sum;
    }
}

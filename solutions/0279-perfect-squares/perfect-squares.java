// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
// Example 1:
//
//
// Input: n = 12
// Output: 3 
// Explanation: 12 = 4 + 4 + 4.
//
// Example 2:
//
//
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.


class Solution {
    public int numSquares(int n) {
        // use dp, finally return dp[n]
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            // find dp[i]
            // dp[i] = mins(dp[i-first ps], dp[i - second ps].... until i-ps < 0)
            int min = Integer.MAX_VALUE;
            for(int sqr_idx = 1; i - sqr_idx*sqr_idx >= 0; sqr_idx++){
                min = Math.min(min, dp[i-sqr_idx*sqr_idx]+1); // 1 stands for the count of perfect square(sqr^2)
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

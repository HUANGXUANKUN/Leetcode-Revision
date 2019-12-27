// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
// Example: 
//
//
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
//


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0; 
        int min_len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int window_sum = 0;
        while(right < nums.length){
            window_sum += nums[right];
            while(window_sum >= s && left <= right){
                min_len = Math.min(right - left + 1, min_len);
                window_sum -= nums[left];
                left++;
            }
            right++;
        }
        if(min_len != Integer.MAX_VALUE){
            return min_len;
        }
        return 0;
    }
}

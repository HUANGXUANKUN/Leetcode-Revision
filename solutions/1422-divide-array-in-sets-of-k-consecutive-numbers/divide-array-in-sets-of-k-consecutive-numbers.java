// Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
// Return True if its possible otherwise return False.
//
//  
// Example 1:
//
//
// Input: nums = [1,2,3,3,4,4,5,6], k = 4
// Output: true
// Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
//
//
// Example 2:
//
//
// Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
// Output: true
// Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
//
//
// Example 3:
//
//
// Input: nums = [3,3,2,2,1,1], k = 3
// Output: true
//
//
// Example 4:
//
//
// Input: nums = [1,2,3,4], k = 3
// Output: false
// Explanation: Each array should be divided in subarrays of size 3.
//
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 10^5
// 	1 <= nums[i] <= 10^9
// 	1 <= k <= nums.length
//


class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int curr = nums[i];
            map.put(curr, map.getOrDefault(curr,0)+1);
        }
        Arrays.sort(nums);
        for(int num: nums){
            // System.out.println("nums: " + num);
            if(map.get(num) > 0){
                for(int i = 0; i < k; i++){
                    // System.out.println("num: " + (int)(num+i) + " count: " + map.get(num+i));
                    if((i != k-1) && (!map.containsKey(num+i+1) || map.get(num+i+1) == 0)){
                        return false;
                    }
                    map.put(num+i, map.get(num+i)-1);
                }
            }
        }
        return true;
    }
}

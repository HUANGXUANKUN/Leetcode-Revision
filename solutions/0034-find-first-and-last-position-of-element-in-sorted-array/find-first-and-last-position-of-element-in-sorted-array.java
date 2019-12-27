// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// Example 1:
//
//
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
//
// Example 2:
//
//
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
//


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return output;
        if(nums.length == 1){
            if(nums[0] == target){
                return new int[]{0,0};
            }
            else return output;
        }
        
        // find lower bound(the first element bigger or equal to the element)
        int left = 0, right = nums.length -1;
        while(left < right){
            int mid = left+(right -left)/2;
            if(nums[mid] >= target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        
        if(nums[left] != target){
            return new int[]{-1,-1};
        }
        else{
            output[0] = left;
        }
        
        
        // left no change
        // find upper bound(the last element smaller or equal to the target)
        right = nums.length-1;
        while(left < right){
            int mid = left + (right-left)/2 +1;
            if (nums[mid] <= target){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }

        output[1] = right;
        return output;
    }
}

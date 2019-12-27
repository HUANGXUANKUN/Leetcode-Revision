// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// Example 1:
//
//
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
//
//
// Example 2:
//
//
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
//


class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        // find rotate index
        int rotateIdx = rotateIndex(nums, 0, nums.length-1);
        System.out.println("rotate: "+ rotateIdx);
        if(rotateIdx == -1){
            //perfectly sorted
            return bs(nums, 0, nums.length-1, target);
        } 
        int left = bs(nums,0,rotateIdx -1, target);
        int right = bs(nums, rotateIdx, nums.length-1, target);
        if(left == -1 && right == -1) return -1;
        else if(left == -1) return right;
        else return left;
    }
    
    public int bs(int[] nums, int left, int right, int target){
        while(left<= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    
    public int rotateIndex(int[] nums, int start, int end){
        while(start <= end){
            int mid = start+(end - start)/2;
            System.out.println("start: "+ start);
            System.out.println("end: "+ end);
            System.out.println("mid: "+ mid);
            if (mid+1 <= nums.length-1 && nums[mid] > nums[mid+1]){
                return mid+1;
            }
            if(mid-1 >= 0 && nums[mid-1] > nums[mid]){
                return mid;
            }
            if(nums[mid] > nums[end]) start = mid + 1;
            else end = mid-1;
        }
        return -1;
    }
}

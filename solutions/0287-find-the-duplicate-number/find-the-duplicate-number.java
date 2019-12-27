// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
// Example 1:
//
//
// Input: [1,3,4,2,2]
// Output: 2
//
//
// Example 2:
//
//
// Input: [3,1,3,4,2]
// Output: 3
//
// Note:
//
//
// 	You must not modify the array (assume the array is read only).
// 	You must use only constant, O(1) extra space.
// 	Your runtime complexity should be less than O(n2).
// 	There is only one duplicate number in the array, but it could be repeated more than once.
//
//


class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        while(slow != fast);
        
        // intersect at fast
        int point1 = fast;
        int point2 = nums[0];
        while(point1 != point2){
            point1 = nums[point1];
            point2 = nums[point2];
        }
        return point1;
        
    }
}

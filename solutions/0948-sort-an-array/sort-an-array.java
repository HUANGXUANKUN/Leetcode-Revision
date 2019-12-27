// Given an array of integers nums, sort the array in ascending order.
//
//  
// Example 1:
// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Example 2:
// Input: nums = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
//
//  
// Constraints:
//
//
// 	1 <= nums.length <= 50000
// 	-50000 <= nums[i] <= 50000
//
//


class Solution {
    public List<Integer> sortArray(int[] nums) {
        return mergeSort(nums);
    }
    
     List<Integer> mergeSort(int nums[]){
        List<Integer> output = new ArrayList<Integer>();
        if(nums.length <= 1){
            output.add(nums[0]);
            return output;
        }
        
        int pivot = nums.length/2;
        List<Integer> left_list = mergeSort(Arrays.copyOfRange(nums, 0, pivot));
        List<Integer> right_list = mergeSort(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left_list, right_list);
    }
    
     List<Integer> merge(List<Integer> left_list, List<Integer> right_list){
        int total_length = left_list.size() + right_list.size();
        List<Integer> output = new ArrayList<>();
        int left_cursor = 0, right_cursor = 0;
        while(left_cursor < left_list.size() && right_cursor < right_list.size()){
            if(left_list.get(left_cursor) < right_list.get(right_cursor)){
                output.add(left_list.get(left_cursor++));
            }
            else{
                output.add(right_list.get(right_cursor++));
            }
        }
        while(left_cursor < left_list.size()){
            output.add(left_list.get(left_cursor++));
        }
        while(right_cursor < right_list.size()){
            output.add(right_list.get(right_cursor++));
        }
        return output;
    }
    
}

// Given two arrays, write a function to compute their intersection.
//
// Example 1:
//
//
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
//
//
//
// Example 2:
//
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
//
//
// Note:
//
//
// 	Each element in the result must be unique.
// 	The result can be in any order.
//
//
//  
//


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int a : nums1) set1.add(a);
        for(int b : nums2) set2.add(b);
        set1.retainAll(set2);
        int[] output = new int[set1.size()];
        int idx = 0;
        for(int a:set1) output[idx++] = a;
        return output;
        
    }
}

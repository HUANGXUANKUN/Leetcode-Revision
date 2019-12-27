// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
// Note:
//
//
// 	The number of elements initialized in nums1 and nums2 are m and n respectively.
// 	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//
//
// Example:
//
//
// Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3
//
// Output: [1,2,2,3,5,6]
//


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        for(int i = 0; i < m; i++){
            nums1_copy[i] = nums1[i];
        }
        int idx_1 = 0, idx_2 = 0;
        for(int i = 0; i < m+n; i++){
            //nums1copy exceeded
            if(idx_2 >= n){
                nums1[i] = nums1_copy[idx_1++];
                continue;
            }
            else if(idx_1 >= m){
                nums1[i] = nums2[idx_2++];
                continue;
            }
            if(nums1_copy[idx_1] > nums2[idx_2]){
                nums1[i] = nums2[idx_2++];
            }
            else{
                nums1[i] = nums1_copy[idx_1++];
            }
        }
    }
}

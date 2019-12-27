// Given two arrays, write a function to compute their intersection.
//
// Example 1:
//
//
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
//
//
//
// Example 2:
//
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
//
//
// Note:
//
//
// 	Each element in the result should appear as many times as it shows in both arrays.
// 	The result can be in any order.
//
//
// Follow up:
//
//
// 	What if the given array is already sorted? How would you optimize your algorithm?
// 	What if nums1's size is small compared to nums2's size? Which algorithm is better?
// 	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
//
//


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //assume n1 > n2
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 > n1) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> ds = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int a : nums1){
            ds.put(a, ds.getOrDefault(a, 0)+1);
        }
        
        int idx = 0;
        for(int a : nums2){
            if(ds.containsKey(a) && ds.get(a) > 0){
                nums1[idx++] = a; 
                ds.put(a, ds.get(a)-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, idx);
    }
}

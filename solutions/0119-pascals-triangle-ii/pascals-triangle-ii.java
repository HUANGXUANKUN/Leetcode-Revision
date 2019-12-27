// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//
// Note that the row index starts from 0.
//
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
//
// Input: 3
// Output: [1,3,3,1]
//
//
// Follow up:
//
// Could you optimize your algorithm to use only O(k) extra space?
//


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++){
            list.add(1);
            for(int k = i-1; k >= 1; k--){
                list.set(k, list.get(k-1) + list.get(k));
            }
        } 
        return list;
    }
}

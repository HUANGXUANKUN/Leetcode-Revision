// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// Example:
//
//
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
//
//


class Solution {
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new LinkedList<Integer>());
        return output;
    }
    
    void backtrack(int first, int n, int k, List<Integer> list){
        for(int i = first; i <= n; i++){
            //add int
            list.add(i);
            
            if(list.size() == k){
                output.add(new ArrayList<>(list));
            }
            else{
                backtrack(i+1, n, k, list);
            }
            list.remove(list.size()-1);
        }
    }
}

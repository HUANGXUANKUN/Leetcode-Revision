// Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
//
//


class Solution {
    List<List<Integer>> output = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if(n == 0) return output;
        int[] visited = new int[n+1];
        backtrack(0, n, new LinkedList<Integer>(), nums, visited);
        return output;
    }
    
    void backtrack(int start, int end, LinkedList<Integer> list, int[] nums, int[] visited){
        if(list.size() == end){
            output.add(new ArrayList<>(list));
        }        
        
        for(int i = start; i < end; i++){
            if(visited[i] == 0){
                list.addLast(nums[i]);
                visited[i] = 1;
                backtrack(0, end, list, nums, visited);
                list.removeLast();
                visited[i] = 0;
            }
        }
    }
}

// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
//
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
//
//


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows== 0) return list;
        
        int[][] visited = new int[numRows+1][numRows+1]; 
        
        visited[1][1] = 1;
        
        for(int i = 1; i <= numRows; i++){
            List<Integer> list_temp = new ArrayList<Integer>();
            for(int k = 1; k <= i; k++){
                if(k == 1 || k == i){
                    visited[i][k] = 1;
                    list_temp.add(1);
                    continue;
                }
                visited[i][k] =visited[i-1][k-1] + visited[i-1][k];
                list_temp.add(visited[i][k]);
            }
            list.add(list_temp);
        }
        return list;
    }
}

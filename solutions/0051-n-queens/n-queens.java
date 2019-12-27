// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
//
// Input: 4
// Output: [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
//
//


class Solution {
    private List<List<String>> output = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[] hills = new int[2*n];
        int[] dales = new int[3*n];
        int[] cols = new int[n];
        LinkedList<String> temp_list = new LinkedList<>();
        backtrack(0, n, hills, dales, cols, temp_list);
        return output;
    }
    private boolean isAllowed(int row, int col, int n, int[] hills, int[] dales, int[] cols){
        int result = hills[row+col] + dales[row-col+2*n] + cols[col];
        return result == 0 ? true :false;
    }
    private void backtrack(int row, int n, int[] hills, int[] dales, int[] cols, LinkedList<String> temp_list){
        for(int col = 0; col < n; col++){
            // if put queen
            if(isAllowed(row, col, n, hills, dales, cols)){
                // put
                hills[row + col] = 1;
                dales[row - col + 2*n] = 1;
                cols[col] = 1;
                StringBuilder sb = new StringBuilder("");
                for(int i = 0; i < col; i++) sb.append('.');
                sb.append('Q');
                for(int i = col+1; i < n; i++) sb.append('.');
                temp_list.addLast(sb.toString());
                // update string
                
                if(row == n-1){
                    //update output lists
                    output.add(new LinkedList<>(temp_list));  
                    // System.out.println(temp_list.toString());
                }
                // backtrack
                else backtrack(row+1, n, hills, dales, cols, temp_list);
                hills[row + col] = 0;
                dales[row - col + 2*n] = 0;
                cols[col] = 0;
                temp_list.removeLast(); // remove last string
            }
        }
        
    }
}

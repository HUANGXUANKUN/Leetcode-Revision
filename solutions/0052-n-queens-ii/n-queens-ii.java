// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//
// Example:
//
//
// Input: 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
//
//


class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        int[] cols = new int[n];
        int[] hills = new int[2*n];
        int[] dales = new int[4*n];
        
        backtrack(0, n, hills,dales, cols); 
        return count;
    }
    
    boolean isUnderAttack(int row, int col, int n, int[] hills, int[] dales, int[] cols){
        int res = cols[col] + hills[row+col] + dales[col-row+ 2*n];
        return res == 0 ? false : true;
    }
    
    void backtrack(int row, int n, int[] hills, int[] dales, int[] cols){
        for(int col = 0; col < n; col++){
            if(isUnderAttack(row, col, n, hills, dales, cols)){
                continue;
            }
            else{
                //place queen
                hills[col+row] = 1;
                dales[col-row+2*n] =1;
                cols[col] = 1;
                if (row == n-1) count++;
                else backtrack(row+1, n, hills,dales, cols);
                
                // remove queen
                hills[col+row] = 0;
                dales[col-row+2*n] =0;
                cols[col] = 0;
            }
        }
        // System.out.println(count);
    }
}

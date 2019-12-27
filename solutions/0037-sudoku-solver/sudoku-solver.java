// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// A sudoku solution must satisfy all of the following rules:
//
//
// 	Each of the digits 1-9 must occur exactly once in each row.
// 	Each of the digits 1-9 must occur exactly once in each column.
// 	Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//
//
// Empty cells are indicated by the character '.'.
//
//
// A sudoku puzzle...
//
//
// ...and its solution numbers marked in red.
//
// Note:
//
//
// 	The given board contain only digits 1-9 and the character '.'.
// 	You may assume that the given Sudoku puzzle will have a single unique solution.
// 	The given board size is always 9x9.
//
//


class Solution {
    public void solveSudoku(char[][] board) {
        int N = 9;
        int[][] boxes = new int[N+1][N+1];
        int[][] rows = new int[N][N+1];
        int[][] cols = new int[N][N+1];
        for (int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                if(board[row][col] != '.'){
                    int digit = board[row][col] - '0';
                    placeNumber(row,col,digit,boxes,rows,cols, board);
                }
            }
        }
        backtrack(0, 0, boxes, rows, cols, board);
    }
    
    boolean allowed(int row, int col, int digit, int[][] boxes, int[][] rows, int[][]cols, char[][] board){
        int box_idx = (row / 3) * 3 + col/3;
        int result = cols[col][digit] + rows[row][digit] + boxes[box_idx][digit];
        return result == 0;
    }
    
    void placeNumber(int row, int col, int digit, int[][] boxes, int[][] rows, int[][]cols, char[][] board){
        int box_idx = (row / 3) * 3 + col/3;
        cols[col][digit] = 1;
        rows[row][digit] = 1;
        boxes[box_idx][digit] = 1;
        board[row][col] = (char)(digit + '0');
    }
    
    void removeNumber(int row, int col, int digit, int[][] boxes, int[][] rows, int[][]cols, char[][] board){
        int box_idx = (row / 3) * 3 + col/3;
        cols[col][digit] = 0;
        rows[row][digit] = 0;
        boxes[box_idx][digit] = 0;
        board[row][col] = '.';
    }
        
    boolean backtrack(int row, int col, int[][] boxes, int[][] rows, int[][]cols, char[][] board){
        boolean isSolved = false;
        if(board[row][col] == '.'){
            for(int digit = 1; digit <= 9; digit++){
                if (allowed(row,col, digit, boxes,rows,cols, board)){
                    placeNumber(row,col,digit, boxes,rows,cols, board);

                    if(row == 8 && col == 8) return true;
                    //check next cell
                    if(col == 8 && row <= 8){
                        isSolved = backtrack(row+1, 0, boxes, rows, cols, board);
                    }
                    else if (col < 8){
                        isSolved = backtrack(row, col+1, boxes, rows, cols, board);
                    }
                    if (isSolved){
                        return true;
                    }
                    else{
                        removeNumber(row,col,digit,boxes,rows,cols, board);
                    }
                }
            }
        }
        else{
            if(row == 8 && col == 8) return true;
            //check next cell
            if(col == 8 && row <= 8){
                isSolved = backtrack(row+1, 0, boxes, rows, cols, board);
            }
            else if (col < 8){
                isSolved = backtrack(row, col+1, boxes, rows, cols, board);
            }
            if (isSolved){
                return true;
            }
        }
        return isSolved;
    }
}

// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//
// 	Integers in each row are sorted from left to right.
// 	The first integer of each row is greater than the last integer of the previous row.
//
//
// Example 1:
//
//
// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 3
// Output: true
//
//
// Example 2:
//
//
// Input:
// matrix = [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// target = 13
// Output: false
//


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        
        // find row
        int row_lo = 0, row_hi = rows;
        while(row_hi - row_lo != 1){
            int mid = (row_lo + row_hi)/2;
            if(matrix[mid][0] == target) return true;
            else if(target < matrix[mid][0]){
                row_hi = mid;
            }
            else{
                row_lo = mid;
            }
        }
        
        for(int i = 0; i < cols; i++){
            if(matrix[row_lo][i] == target)return true;
            else if(matrix[row_lo][i] > target) return false;
        }
        return false;
    }
}

// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// Example 1:
//
//
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
//
//
// Example 2:
//
// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<Integer>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        int[] dir_row = {0, 1, 0, -1}; //row direction: right down left up
        int[] dir_col = {1, 0, -1, 0}; //col direction: right down left up
        int d = 0;
        int col = 0, row = 0;
        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < rows*cols; i++){
            output.add(matrix[row][col]);
            visited[row][col] = 1;
            int newRow = row + dir_row[d];
            int newCol = col + dir_col[d];
            if(newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols || visited[newRow][newCol] == 1){
                // change direction
                d = (d+1)%4;
                newRow = row + dir_row[d];
                newCol = col + dir_col[d];
            }
            row = newRow;
            col = newCol;
        }
        return output;
    }
}

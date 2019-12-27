// Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
//
//  
//
// Example:
//
//
// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
//
// Output:  [1,2,4,7,5,3,6,8,9]
//
// Explanation:
//
//
//
//  
//
// Note:
//
// The total number of elements of the given matrix will not exceed 10,000.
//


class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return new int[0];
        int cols = matrix[0].length;
        int up = 1;
        int[] output = new int[rows*cols];
        int idx = 0;
        int diag = rows + cols -1;
        for(int i = 0; i < diag; i++){
            LinkedList<Integer> list = new LinkedList<>();
            int row,col;
            if(i <cols){
                row = 0;
                col = i;
            }
            else{
                row = i - cols + 1;
                col = cols-1;
            }
            // System.out.println("row: " + row + " col: " + col);
            
            while(row >= 0 && col>= 0 && row < rows && col < cols){
                list.addLast(matrix[row][col]);
                row += 1;
                col -= 1;
            }
            
            while(list.size() != 0){
                if(up == 1){
                    output[idx++] = list.removeLast();
                }
                else{
                    output[idx++] = list.removeFirst();
                }
            }
            up = 1-up;
        }
        return output;
    }
}

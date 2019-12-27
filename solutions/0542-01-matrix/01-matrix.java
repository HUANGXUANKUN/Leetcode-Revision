// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//
// The distance between two adjacent cells is 1.
//
//  
//
// Example 1: 
//
//
// Input:
// [[0,0,0],
//  [0,1,0],
//  [0,0,0]]
//
// Output:
// [[0,0,0],
//  [0,1,0],
//  [0,0,0]]
//
//
// Example 2: 
//
//
// Input:
// [[0,0,0],
//  [0,1,0],
//  [1,1,1]]
//
// Output:
// [[0,0,0],
//  [0,1,0],
//  [1,2,1]]
//
//
//  
//
// Note:
//
//
// 	The number of elements of the given matrix will not exceed 10,000.
// 	There are at least one 0 in the given matrix.
// 	The cells are adjacent in only four directions: up, down, left and right.
//
//


class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0)return matrix;
        
        Queue<int[]> q = new LinkedList<>();
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        for(int[] a:dist){
            Arrays.fill(a, 10001);
        } 
            
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if(matrix[row][col] == 0){
                    dist[row][col] = 0;
                    q.add(new int[]{row,col});
                }
            }
        }
        
        while (!q.isEmpty()){
            int[] node = q.remove();
            int row = node[0];
            int col = node[1];
            
            for (int i = 0; i < 4; i++){
                int row_new = row+directions[i][0];
                int col_new = col+directions[i][1];
                if(row_new <0 || col_new<0 || row_new >= rows || col_new >= cols){
                    continue;
                }
                if(dist[row][col] + 1 < dist[row_new][col_new]){
                    dist[row_new][col_new] = dist[row][col] + 1;
                    q.add(new int[]{row_new, col_new});
                }
            }
        }
        
        return dist;
    }
}

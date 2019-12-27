// You are given a m x n 2D grid initialized with these three possible values.
//
//
// 	-1 - A wall or an obstacle.
// 	0 - A gate.
// 	INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//
//
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
// Example: 
//
// Given the 2D grid:
//
//
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
//
//
// After running your function, the 2D grid should be:
//
//
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
//
//


class Solution {
    
    public void wallsAndGates(int[][] rooms) {
        int empty = Integer.MAX_VALUE;
        int gate = 0;
        int rows = rooms.length;
        if (rows == 0) return;
        int cols = rooms[0].length;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (rooms[row][col] == gate){
                    int[] temp = {row, col};
                    q.add(temp);
                }
            }
        }
        
        System.out.println("break 1");
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int row = curr[0];
            int col = curr[1];
            System.out.println("row: " + row + " col: " + col);
            for(int[] temp : directions){
                int row_new = row + temp[0];
                int col_new = col + temp[1];
                if(row_new < 0 || col_new < 0 || row_new >= rows 
                   || col_new >= cols || rooms[row_new][col_new] != empty){
                    continue;
                }
                rooms[row_new][col_new] = rooms[row][col] + 1;
                q.add(new int[]{row_new, col_new});
            }
        }
    }
}

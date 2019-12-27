// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
// Input:
// 11110
// 11010
// 11000
// 00000
//
// Output: 1
//
//
// Example 2:
//
//
// Input:
// 11000
// 11000
// 00100
// 00011
//
// Output: 3
//


class Solution {
    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
    int rows, cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        int count = 0;
        for(int row  = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == '1'){
                    count++;
                    dfs(grid, row, col);
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int curr_row, int curr_col){
        grid[curr_row][curr_col] = '0';
        for(int[] dir : directions){
            int new_row = curr_row + dir[0];
            int new_col = curr_col + dir[1];
            if (new_row < 0 || new_col < 0 || new_row >= rows || new_col >= cols
                || grid[new_row][new_col] == '0'){
                continue;
            }
            dfs(grid, new_row, new_col);
        }
    }
}

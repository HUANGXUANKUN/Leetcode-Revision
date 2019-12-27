// On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
//
// Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.
//
// Now, we walk in a clockwise spiral shape to visit every position in this grid. 
//
// Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.) 
//
// Eventually, we reach all R * C spaces of the grid.
//
// Return a list of coordinates representing the positions of the grid in the order they were visited.
//
//  
//
// Example 1:
//
//
// Input: R = 1, C = 4, r0 = 0, c0 = 0
// Output: [[0,0],[0,1],[0,2],[0,3]]
//
//
//
//
//  
//
// Example 2:
//
//
// Input: R = 5, C = 6, r0 = 1, c0 = 4
// Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
//
//
//
//
//
//
//  
//
// Note:
//
//
// 	1 <= R <= 100
// 	1 <= C <= 100
// 	0 <= r0 < R
// 	0 <= c0 < C
//
//
//


class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] output = new int[R*C][];
        int idx = 0;
        output[idx++] = new int[]{r0, c0};
        int r1 = r0-1, r2 = r0+1;
        int c1 = c0-1, c2 = c0+1;
        
        while(idx < R*C){
            //down 
            for(int r = r1+1; r <= r2; r++){
                if(isValid(r, c2, R, C)) output[idx++] = new int[]{r, c2};
            } 
            //left
            for(int c = c2-1; c >= c1; c--){
                if(isValid(r2, c, R, C)) output[idx++] = new int[]{r2, c};
            }
            //up
            for(int r = r2-1; r >= r1; r--){
                if(isValid(r, c1, R, C)) output[idx++] = new int[]{r, c1};
            }
            //right
            for(int c = c1+1; c<=c2; c++) {
                if(isValid(r1, c, R, C)) output[idx++] = new int[]{r1, c}; 
            }
            r1--;
            r2++;
            c1--;
            c2++;
        }
        return output;
    }
    
    boolean isValid(int r, int c, int R, int C){
        return r >= 0 && c>= 0 && r< R && c< C;
    }
}

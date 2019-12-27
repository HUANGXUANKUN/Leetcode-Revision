// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
// Example:
//
//
// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
//
//


class Solution {
    public int[][] generateMatrix(int n) {
        int[][] output = new int[n][n];
        if (n == 0) return output;
        int r1 = 0, c1 = 0;
        int r2 = n-1, c2 = n-1;
        int idx = 1;
        while(r1 <= r2 && c1<= c2){
            //right
            for(int c = c1; c <=c2; c++) output[r1][c] = idx++;    
            //down
            for(int r = r1+1; r <= r2; r++) output[r][c2] = idx++;
            //left
            for(int c = c2-1; c >= c1; c--) output[r2][c] = idx++;
            //up
            for(int r = r2-1; r > r1; r--) output[r][c1] = idx++;
            r1++;
            r2--;
            c1++;
            c2--;
            // System.out.println(idx);
            
        }
        return output;
        
    }
}

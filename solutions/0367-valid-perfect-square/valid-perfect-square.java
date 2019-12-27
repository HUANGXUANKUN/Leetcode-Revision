// Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
// Note: Do not use any built-in library function such as sqrt.
//
// Example 1:
//
//
//
// Input: 16
// Output: true
//
//
//
// Example 2:
//
//
// Input: 14
// Output: false
//
//
//


class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 1) return true;
        long sqr;
        int left = 2;
        int right = num/2;
        while(left <= right){
            int mid = (left+right)/2;
            sqr = (long)mid*mid;
            if(sqr == num) return true;
            else if(sqr < num) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}

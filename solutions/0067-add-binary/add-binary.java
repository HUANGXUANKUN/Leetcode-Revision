// Given two binary strings, return their sum (also a binary string).
//
// The input strings are both non-empty and contains only characters 1 or 0.
//
// Example 1:
//
//
// Input: a = "11", b = "1"
// Output: "100"
//
// Example 2:
//
//
// Input: a = "1010", b = "1011"
// Output: "10101"
//


class Solution {
    public String addBinary(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();
        if (a_len > b_len) return addBinary(b, a);
        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        for(int i = b_len-1, j = a_len-1; i >= 0; i--){
            int value = 0;
            if(j >= 0 && a.charAt(j--) == '1') value++;
            if(b.charAt(i) == '1') value++;
            value+= carry;
            if(value%2 == 1) sb.append('1');
            else sb.append('0');
            if(value / 2 == 1){
                carry = 1;
            }
            else carry = 0;
            System.out.println(sb.toString());
            System.out.println("carry: " + carry);
        }
        if (carry==1){
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}

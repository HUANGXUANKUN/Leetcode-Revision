// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
//
//
// Note:
// In the string, each word is separated by single space and there will not be any extra space in the string.
//


class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder("");
        String[] strs = s.trim().split(" ");
        for(int i = 0; i < strs.length; i++){
            String temp = strs[i];
            //reverse
            for(int k = temp.length() -1; k >= 0; k--){
                sb.append(temp.charAt(k));
            }
            
            // add a space except for the last word
            if(i != strs.length -1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

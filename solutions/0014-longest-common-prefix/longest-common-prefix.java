// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
         // vertical scanning
        if (strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++){
            char curr = strs[0].charAt(i);
            for(int k = 1; k < strs.length; k++){
                if(i >= strs[k].length() || strs[k].charAt(i) != curr){
                    return strs[0].substring(0,i);
                }
            }    
        }
        return strs[0];
    }
}

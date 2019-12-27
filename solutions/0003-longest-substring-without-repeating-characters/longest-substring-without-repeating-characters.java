// Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
//
//
//
// Example 2:
//
//
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//
//


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        int win_left = 0;
        for(int win_right = 0; win_right < s.length(); win_right++){
            char next = s.charAt(win_right);
            while (set.contains(next)){
                set.remove(s.charAt(win_left));
                win_left++;
            }
            set.add(next);
            maxLen = Math.max(win_right - win_left + 1, maxLen);
        }
        return maxLen;
    }
}

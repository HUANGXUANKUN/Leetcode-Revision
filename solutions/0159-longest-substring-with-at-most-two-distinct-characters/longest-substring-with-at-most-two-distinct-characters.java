// Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
//
// Example 1:
//
//
// Input: "eceba"
// Output: 3
// Explanation: t is "ece" which its length is 3.
//
//
// Example 2:
//
//
// Input: "ccaabbb"
// Output: 5
// Explanation: t is "aabbb" which its length is 5.
//
//


class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        int win_left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int win_right = 0; win_right < s.length(); win_right++){
            char next = s.charAt(win_right);
            if(map.containsKey(next)){
                map.put(next, map.get(next) + 1);
            }
            else{
                map.put(next, 1);
            }
            while(map.size() >= 3){
                char left_most = s.charAt(win_left);
                if(map.get(left_most) != 1){
                    map.put(left_most, map.get(left_most) -1);
                }
                else{
                    map.remove(left_most);
                }
                win_left++;
            }
            maxLen = Math.max(maxLen, win_right - win_left +1);
        }
        return maxLen;
    }
}

// Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
// Example 1:
//
//
//
// Input: s = "eceba", k = 2
// Output: 3
// Explanation: T is "ece" which its length is 3.
//
//
// Example 2:
//
//
// Input: s = "aa", k = 1
// Output: 2
// Explanation: T is "aa" which its length is 2.
//
//
//


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if(n<=k) return n;
        int left = 0, right = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < n){
            // System.out.println(left + " | " + right);
            char next = s.charAt(right);
            // expand right
            if(map.size() <= k){
                map.put(next, 1 + map.getOrDefault(next, 0));
            }
            right++;
            //shrink left
            while(map.size() > k){
                char left_char = s.charAt(left);
                map.put(left_char, map.get(left_char)-1);
                if(map.get(left_char) == 0) map.remove(left_char);
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}

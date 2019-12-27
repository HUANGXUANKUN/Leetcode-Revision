// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// Example:
//
//
// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"
//
//
// Note:
//
//
// 	If there is no such window in S that covers all characters in T, return the empty string "".
// 	If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
//
//


class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> t_dict = new HashMap<>();
        Map<Character, Integer> window_dict = new HashMap<>();
        if(s.length() == 0 || t.length() == 0){
            return "";
        }
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            t_dict.put(c, t_dict.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int[] window_min = {-1, 0, 0};// {length, ;eft, right}
        int formed = 0;
        int requried = t_dict.size();
        while(right < s.length()){
            //append right if not formed
            char next = s.charAt(right);
            window_dict.put(next, window_dict.getOrDefault(next, 0)+1);
            if (t_dict.containsKey(next) && window_dict.get(next).equals(t_dict.get(next))){
                formed++;
            }
            // System.out.printf("formed: %d left: %d right: %d\n",formed, left, right);
            // shrink if formed == required, left--
            while(formed == requried && left <= right){
                //update window_min
                if(window_min[0] == -1 || window_min[0] > (right-left+1)){
                    window_min[0] = right-left +1;
                    window_min[1] = left;
                    window_min[2] = right;
                }
                char c = s.charAt(left);
                window_dict.put(c, window_dict.get(c) - 1);
                if(t_dict.containsKey(c) && t_dict.get(c).intValue() > window_dict.get(c).intValue()){
                    formed--;
                }
                left++;                
            }
            right++;
        }
        return window_min[0] == -1 ? "" : s.substring(window_min[1], window_min[2] + 1);
    }
}

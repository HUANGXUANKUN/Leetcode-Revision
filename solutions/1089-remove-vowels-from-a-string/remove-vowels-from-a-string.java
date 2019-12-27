// Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
//
//  
//
// Example 1:
//
//
// Input: "leetcodeisacommunityforcoders"
// Output: "ltcdscmmntyfrcdrs"
//
//
// Example 2:
//
//
// Input: "aeiou"
// Output: ""
//
//
//  
//
// Note:
//
//
// 	S consists of lowercase English letters only.
// 	1 <= S.length <= 1000
//
//


class Solution {
    public String removeVowels(String S) {
        String output = "";
        for(int i = 0; i < S.length(); i++){
            char a = Character.toLowerCase(S.charAt(i));
            if (a == 'a' || a =='e' || a == 'i' || a=='o' || a=='u'){
                continue;
            }
            output+=S.charAt(i);
        }
        return output;
    }
}

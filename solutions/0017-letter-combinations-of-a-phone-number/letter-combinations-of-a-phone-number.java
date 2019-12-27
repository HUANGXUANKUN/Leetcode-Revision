// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be in any order you want.
//


class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if (digits.length() == 0) return output;
        Map<String, String> phone = new HashMap<String, String>(){{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        
        backtrack(0, digits, phone, output, "");
        return output;
    }
    
    void backtrack(int idx, String digits,Map<String, String> phone, List<String> output, String temp){
        
        if (temp.length() == digits.length()){
            output.add(temp);
            return;
        }
        String digit = digits.substring(idx, idx+1);
        String options = phone.get(digit);
        for(int i = 0; i < options.length(); i++){
            temp+= Character.toString(options.charAt(i));
            backtrack(idx+1, digits, phone, output, temp);
            temp = temp.substring(0, temp.length()-1);
        }
    }
}

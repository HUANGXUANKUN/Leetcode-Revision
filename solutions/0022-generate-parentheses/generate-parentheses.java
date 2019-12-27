//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    List<String> output = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n,"");
        return output;
    }
    
    void backtrack(int left, int right, int n, String str){
        if(left == right && left == n){
            output.add(str);
        }
        else{
            if(left < n){
                backtrack(left+1, right, n, str+"(");
            }
            if(right < left){
                backtrack(left, right+1, n, str+")");
            }
        }
    }
}

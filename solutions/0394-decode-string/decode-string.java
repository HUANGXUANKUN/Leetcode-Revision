// Given an encoded string, return its decoded string.
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
//
// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
//
// Examples:
//
//
// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
//
//
//  
//


class Solution {
    public String decodeString(String s) {
        LinkedList<String> list = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            // if ]
            if (curr == ']'){
                LinkedList<String> stack = new LinkedList<>();
                while(!list.peekLast().equals("[")){
                    stack.add(list.removeLast());
                }
                list.removeLast();//remove "["
                int count = Integer.parseInt(list.removeLast()); // get digit
                StringBuilder sb = new StringBuilder("");
                StringBuilder sb_2 = new StringBuilder("");
                while(!stack.isEmpty()){
                    sb.append(stack.removeLast());
                }

                for(int x = 0; x < count; x++){
                    sb_2.append(sb.toString());
                }
                list.add(sb_2.toString());
                continue;
            }
            else{
                if(Character.isDigit(curr)){
                    int digit = curr - '0';
                    while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                        digit = digit*10 + (s.charAt(i+1) - '0');
                        i++;
                    }    
                    list.add(Integer.toString(digit));
                }
                else{
                    list.add(s.substring(i,i+1));
                }
            }
        }
        int size = list.size();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++){
            sb.append(list.removeFirst());
        }
        return sb.toString();
    }
}

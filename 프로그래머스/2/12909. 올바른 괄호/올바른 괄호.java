import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else if(!st.empty() && c == ')' ){
                st.pop();
            }else if(st.empty() && c == ')'){
                return false;
            }
        }
        
        return st.empty();
    }
}
import java.util.Stack;
class Solution {
    boolean solution(String s) {
        // 극단적인 경우 왼쪽에 5만개의 괄호 오른쪽에 5만개의 괄호
        // 반드시 열리고 닫혀야 됨
        boolean answer = true;
        Stack<Character> stack = new Stack();
        for (int i= 0 ; i<s.length() ; i++){ 
            if(s.charAt(i) == '(' )
                stack.push(s.charAt(i));  
            else if(s.charAt(i) == ')' && !stack.empty())    
                stack.pop();
            else
                return false;
        }
        if(!stack.empty())
            answer = false;
        return answer;
    }
}
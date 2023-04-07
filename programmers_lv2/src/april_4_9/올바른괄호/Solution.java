package april_4_9.올바른괄호;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack();
        stack.add(')');
        stack.push(')');
        System.out.println(stack.toString());
    }
    boolean solution(String s) {
        // 효율성 테스트에서 실패한 코드. 정답과 비교가 필요 -> 모범답안과의 차이는 같은 뜻을 의미하더라도 연산이 더 들어간 것이 있다.
        // 이로 인해, 효율성 테스트를 통과하지 못 한 것 같다.
        boolean answer = true;
        Stack<Character> stack = new Stack();
        for (int i= 0 ; i<s.length() ; i++){
            if( stack.empty()&& s.charAt(i) == ')' ){
                answer = false;
                break;
            }

            if(!stack.empty() && stack.peek() == '(' && s.charAt(i) == ')'){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(!stack.empty())
            answer = false;
        return answer;
    }
}
/* 모범답안.
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
*/

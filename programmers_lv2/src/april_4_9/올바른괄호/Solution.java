package april_4_9.올바른괄호;

import java.util.Stack;

/*
괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

- "()()" 또는 "(())()" 는 올바른 괄호입니다.

- ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.

'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

제한사항

- 문자열 s의 길이 : 100,000 이하의 자연수

- 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
*/
// 대표적인 stack문제
public class Solution {
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

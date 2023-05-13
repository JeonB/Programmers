package may_8_14.괄호회전하기;

import java.util.*;
class Solution {
    public int solution(String s) {
        // (),{},[] 가 존재하는 문자열 s
        // (),{},[] 가 올바른 괄호 형태이며 겹처도 됨
        // s를 문자열의 길이까지 왼쪽으로 회전 시켰을 때 가능한 올바른 문자열 경우의 수 구하기
        // stack을 활용하여 문자열의 길이만큼 순회하며 괄호가 제대로 짝지어졌는지 확인
        int answer = 0;

        for(int i = 0; i<s.length() ; i++){
            Stack<Character> brace = new Stack<>();
            for(int j = 0 ; j < s.length(); j++){
                if(s.charAt(j) == '(' || s.charAt(j) == '{'||s.charAt(j) == '['){
                    brace.push(s.charAt(j));
                }
                else if(!brace.isEmpty() && brace.peek() == '('&& s.charAt(j) == ')'){
                    brace.pop();
                }
                else if(!brace.isEmpty() && brace.peek() == '{'&& s.charAt(j) == '}'){
                    brace.pop();
                }
                else if(!brace.isEmpty() && brace.peek() == '['&& s.charAt(j) == ']'){
                    brace.pop();
                }else{
                    brace.push('x');
                    break;
                }
            }
            if(brace.isEmpty()){
                answer++;
            }
            String str = s.substring(1);
            s = str.concat(String.valueOf(s.charAt(0)));

        }
        return answer;
    }
}
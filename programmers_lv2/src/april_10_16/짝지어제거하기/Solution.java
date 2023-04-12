package april_10_16.짝지어제거하기;

import java.util.Stack;

/*
 문자열 S = baabaa 라면
b aa baa → bb aa → aa →

의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
*/
public class Solution {
    // 효율성테스트 실패
/*    public int solution(String s)
    {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 1 ; i<sb.length();i++){
                if(sb.charAt(i) == sb.charAt(i-1)) {
                    sb.delete(i - 1, i + 1);
                    i =0;
                }
        }
        if(sb.length() == 0)
            answer = 1;
        return answer;
    }*/
    public int solution(String s)
    {
        int answer = 0;
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c: str) {
            if(!stack.empty()&&stack.peek() == c)
                stack.pop();
            else{
                stack.push(c);
            }
        }
        if(stack.empty())
            answer=1;
        return answer;
    }
}

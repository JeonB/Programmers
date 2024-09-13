import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length() ; i++){
            char currentNum = number.charAt(i);
            
            while(!stack.isEmpty() && k > 0 && currentNum > stack.peek()){
                stack.pop();
                k--;
            }
            
            stack.push(currentNum);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for(char num : stack){
            sb.append(num);
        }
        answer = sb.toString();
        return answer;
    }
}
import java.util.ArrayList;
class Solution {
    public int[] solution(long n) {
    
    String num = String.valueOf(n);
    int[] answer = new int[num.length()];
    for(int i = num.length()-1 ; i>-1 ; i--){
        answer[num.length()-1-i] =  num.charAt(i) - '0';
    }
    return answer;
    }
}
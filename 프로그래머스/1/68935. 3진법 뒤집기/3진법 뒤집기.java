import java.util.*;
class Solution {
    public int solution(int n) {
    
    String sam = Integer.toString(n,3);
    String num = new StringBuilder(sam).reverse().toString();
    
    int answer = Integer.parseInt(num,3);
    return answer;
    }
}
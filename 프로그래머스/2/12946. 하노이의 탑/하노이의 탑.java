import java.util.*;
class Solution {
    public List<int[]> solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(n,1,3,answer);
        return answer;
    }
    
    public void hanoi(int n , int from , int to, List<int[]> answer){
        if(n == 1) {answer.add(new int[]{from,to});
                    return;};
        int temp = 6 - (from + to);
        hanoi(n-1,from,temp,answer );
        answer.add(new int[]{from,to});
        hanoi(n-1, temp, to, answer);
        
    }
}
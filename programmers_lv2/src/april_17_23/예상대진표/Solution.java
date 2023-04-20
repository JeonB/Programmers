package april_17_23.예상대진표;

public class Solution {

    public int solution(int n, int a, int b){
        int answer = 1;
        while(true){
            if(a%2 != 0 && a+1 == b)
                return answer;
            else if(b%2 !=0 && b+1 == a)
                return answer;
            if(a%2 != 0)
                a = a/2 +1;
            else
                a/=2;
            if(b%2 !=0)
                b = b/2 +1;
            else
                b/=2;
            answer++;
        }
    }

}

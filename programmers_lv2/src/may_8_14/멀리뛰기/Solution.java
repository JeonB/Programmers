package may_8_14.멀리뛰기;

class Solution {
    
    public long solution(int n) {
        //2칸 또는 1칸만 이동 가능
        // 2칸씩 최대로 갈 수 있는 경우의 수부터 구해보자
        // 최대 경우의 수에서 2의 개수를 하나씩 줄여서 조합으로 구해보기
        // ex) 10칸일 때 2칸씩 4번 1칸씩 2번가능 6C2
        // 조합으로 결국 못 풂
        long answer = 0;
        int move = 0;  //1칸 이동 횟수
        int move2 = 0; //2칸 이동 횟수
        move2 = n/2; // 2칸 최대 이동 횟수


        for(int i = move2 ; i>=0 ; i--){
            move = n - i*2;
            answer += combi(move+i,i);
        }


        return answer%1234567;
    }

    public long combi(int n, int a){
        long answer = 1;
        if(a == 0 || n==a)
            return answer;
        else if(a == 1 || n-a == 1)
            return answer = n;

        int j = a;
        for(int i = n ;i>a ; i--){
            answer *= i;
            answer /= j;
            j--;
            if(j<1)
                break;
        }
        return answer%1234567;
    }
}

/* 동적 프로그래밍 사용.. 2*n 타일문제랑 같이 봐야할 듯
    int[] dp = new int[2001];
      dp[1] = 1;
      dp[2] = 2;
      for(int i=3; i<2001; i++){
          dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
      }
      return dp[n]; 
*/
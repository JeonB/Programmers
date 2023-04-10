package april_4_9.타일만들기;

public class Solution {

    // 점화식을 세워 DP를 이용하여 문제 풀이
    public int solution(int n){
        int answer = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        answer = dp[1] + dp[2];
        for(int i = 3; i<dp.length;i++){
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }
        answer = dp[n];
        return answer;
    }
}

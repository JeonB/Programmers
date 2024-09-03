import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
         // DP 배열 초기화
        int[][] dp = new int[n + 1][m + 1];
        
        // 물에 잠긴 지역 표시
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1; // 물에 잠긴 지역은 -1로 표시
        }
        
        // 시작점 초기화
        dp[1][1] = 1;
        
        // DP를 이용하여 최단 경로 개수 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0; // 물에 잠긴 지역은 경로 개수를 0으로 설정
                } else {
                    if (i > 1) dp[i][j] += dp[i - 1][j];
                    if (j > 1) dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= 1000000007; // 경로 수를 1,000,000,007로 나눈 나머지
                }
            }
        }
        
        return dp[n][m];
    }
    
    
}
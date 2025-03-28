import java.util.Arrays;

public class Solution {
    public int solution(int[][] info, int n, int m) {
        int itemCount = info.length;
        int INF = 1000000;

        // DP 테이블 초기화: dp[i][j] = A의 최소 흔적 (i개의 물건 처리 후, B의 흔적이 j일 때)
        int[][] dp = new int[itemCount + 1][m];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int i = 0; i < itemCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];

            for (int j = 0; j < m; j++) {
                if (dp[i][j] == INF) continue;

                // A 도둑이 i번째 물건을 훔칠 경우
                int newATrace = dp[i][j] + aTrace;
                if (newATrace < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], newATrace);
                }

                // B 도둑이 i번째 물건을 훔칠 경우
                int newBTrace = j + bTrace;
                if (newBTrace < m) {
                    dp[i + 1][newBTrace] = Math.min(dp[i + 1][newBTrace], dp[i][j]);
                }
            }
        }

        // 최종 결과: itemCount개의 물건 처리 후, B의 흔적 < m 이면서 A의 흔적 < n 인 최소값 찾기
        int result = INF;
        for (int j = 0; j < m; j++) {
            result = Math.min(result, dp[itemCount][j]);
        }

        return result == INF ? -1 : result;
    }
}

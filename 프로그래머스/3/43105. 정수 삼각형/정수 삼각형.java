class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        // DP 배열의 꼭대기 값 초기화
        dp[0][0] = triangle[0][0];
        
        // 삼각형의 각 레벨을 순회하며 최대 합 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 왼쪽 가장자리의 경우, 바로 위의 값에서만 올 수 있음
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    // 오른쪽 가장자리의 경우, 바로 위의 값에서만 올 수 있음
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    // 그 외의 경우, 위의 두 칸에서 올 수 있음
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        // 마지막 행에서 최대값 찾기
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[n - 1][i]);
        }
        
        return maxSum;
    }
    

}
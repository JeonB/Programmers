import java.util.*;
class Solution {
    public int solution(int N, int number) {
       // DP 배열 초기화: N을 i번 사용해서 만들 수 있는 숫자의 집합
        Set<Integer>[] dp = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            dp[i] = new HashSet<>();
        }
        
        // N을 1번 사용해서 만들 수 있는 숫자
        dp[1].add(N);
        
        // dp[1]에 이미 목표 숫자가 있는지 체크
        if (number == N) {
            return 1;
        }
        
        // dp[i] 초기화
        for (int i = 2; i <= 8; i++) {
            // N을 i번 반복한 숫자를 추가 (예: 5, 55, 555, ...)
            int repeatedNum = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(repeatedNum);
            
            // i = j + k의 경우로 모든 조합을 검사
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            
            // 목표 숫자가 dp[i]에 있다면 최소 사용 횟수를 반환
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        // N을 8번 사용해도 목표 숫자를 만들 수 없다면 -1 반환
        return -1;
    }
}
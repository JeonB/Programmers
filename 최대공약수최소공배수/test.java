package 최대공약수최소공배수;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(3, 4)));
  }

  public static int[] solution(int n, int m) {
    int[] answer = new int[2];
    if (n > m) {
      for (int i = 1; i * i <= m; i++) {
        if (m % i == 0) {
          if (n % i == 0) {
            answer[0] = i;
          }
          if (n % (m / i) == 0) {
            answer[0] = m / i;
            break;
          }
        }
      }
      answer[1] = m * n / answer[0];
    } else {
      for (int i = 1; i * i <= n; i++) {
        if (n % i == 0) {
          if (m % i == 0) {
            answer[0] = i;
          }
          if (m % (n / i) == 0) {
            answer[0] = n / i;
            break;
          }
        }
      }
      answer[1] = m * n / answer[0];
    }
    return answer;
  }
}
/* 모범답안. 유클리드 호제법과 재귀함수를 이용한 최대공약수 처리가 독보적이다 
  public static int gcd(int p, int q)
   {
    if (q == 0) return p;
    return gcd(q, p%q);
   }
 */

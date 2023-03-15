package FindPrimeNum;

import java.util.Arrays;

public class finPrimeNum {

  public static int solution(int n) {
    int answer = 0;
    boolean[] nums = new boolean[n + 1]; //편의상 2부터 n까지 소수 여부 판단하는 배열
    Arrays.fill(nums, true);
    for (int i = 2; i <= n; i++) {
      if (nums[i] == false) continue;
      if (isPrime(i) == true) {
        answer++;
        for (int k = 2; i * k <= n; k++) {
          nums[i * k] = false;
        }
      }
    }
    return answer;
  }

  //소수인지 아닌지 판별하는 메소드
  public static boolean isPrime(int num) {
    boolean isPrime = true;
    for (int i = 2; i <= (int) Math.sqrt(num); i++) {
      if (num % i == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }
}
/*
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 *
 * 1. 소수 만드는 알고리즘부터 구해보면, 숫자 num의 소수는 i<=Math.sqrt(n)을 이용해 구할 수 있음
 * 2. 입력값 n은 nums=[n]으로 활용하여 생성한 배열에 일단 전부다 true값 집어 넣는 것으로 초기화
 * 3. 에라토스테네스의 체를 이용하여 답을 구함 -> 특정 소수를 구하면 그 소수의 배수는 전부 삭제(false)
 * 4. 최종적으로 남은 true값의 개수를 answer에 대입
 */

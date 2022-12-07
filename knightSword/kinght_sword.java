import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    System.out.println();
  }

  // 약수의 개수 구하기
  public int solution(int number, int limit, int power) {
    int[] exponent = new int[4]; // 2,3,5,7 소수
    int[] knight = new int[number];
    int sum = Arrays.stream(exponent).sum();
    int answer = Arrays.stream(knight).sum();
    int attack_damage = 0;

    return answer;
  }
}

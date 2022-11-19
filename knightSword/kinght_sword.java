import java.util.Arrays;

class Solution {

  public int solution(int number, int limit, int power) {
    Solution a = new Solution();
    int[] exponent = new int[4]; // 2,3,5,7 소수
    int[] knight = new int[number];
    int sum = Arrays.stream(exponent).sum();
    int answer = Arrays.stream(knight).sum();
    int attack_damage = 0;

    for (int i = 1; i < number + 1; i++) {
      attack_damage = a.exponent_op(i);
      if (attack_damage > limit) {
        attack_damage = power;
      }
      knight[i - 1] = attack_damage;
      Arrays.fill(exponent, 0);
    }
    return answer;
  }

  public int exponent_op(int number) {
    if (number == 1) {
      return a.sum + 1;
    } else if (number % 2 == 0) {
      a.exponent[0]++;
      exponent_op(number / 2);
    } else if (number % 3 == 0) {
      a.exponent[1]++;
      exponent_op(number / 3);
    } else if (number % 5 == 0) {
      a.exponent[2]++;
      exponent_op(number / 5);
    } else if (number % 7 == 0) {
      a.exponent[3]++;
      exponent_op(number / 7);
    } else {
      return a.sum + 2;
    }
  }
}

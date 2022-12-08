package knightSword;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    System.out.println(solution(5, 3, 2));
  }

  // 약수의 개수 구하기가 핵심
  public static int solution(int number, int limit, int power) {
    int attack_damage[] = new int[number];
    int iron_weight = 0;
    for (int knight = 1; knight <= number; knight++) {
      for (int i = 1; i * i <= knight; i++) {
        if (i * i == knight) {
          attack_damage[knight - 1]++;
        } else if (knight % i == 0) {
          attack_damage[knight - 1] += 2;
        }
      }
      if (attack_damage[knight - 1] > limit) {
        attack_damage[knight - 1] = power;
      }
    }
    iron_weight = Arrays.stream(attack_damage).sum();
    return iron_weight;
  }
}
/* 굳이 배열을 따로 선언해서 그 배열의 합을 구하는 작업을 할 필요가 없음을 보여준다.
class Solution {
  public int solution(int number, int limit, int power) {
      int answer = 0;

      for(int i = 1; i <= number; ++i) {
          int count = 0;
          for(int j = 1; j*j <= i; ++j) {
              if(j*j == i) count++;
              else if(i%j == 0) count += 2;
          }
          if(count > limit) answer += power;
          else answer += count;
      }

      return answer;
  }
} */

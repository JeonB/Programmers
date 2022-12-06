package MinScore;

import java.util.Arrays;

public class MinScore {

  public static void main(String[] args) {
    int[] score = { 10, 100, 20, 150, 1, 100, 200 };
    int k = 3;
    System.out.println(Arrays.toString(solution(k, score)));
  }

  public static int[] solution(int k, int[] score) { //k는 명예의 전당에 오를 사람의 수
    int[] answer = new int[score.length];
    int[] fameHall = new int[k];

    for (int i = 0; i < score.length; i++) {
      if (i < k) {
        fameHall[i] = score[i];
        answer[i] = score[i];
      } else {
        fameHall[k - 1] = Math.min(fameHall[k - 1], score[i]);
        answer[i] = fameHall[k - 1];
      }
    }

    return answer;
  }
}

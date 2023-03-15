package MinScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinScore {

  public static void main(String[] args) {
    int[] score = { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 };
    int k = 4;
    System.out.println(Arrays.toString(solution(k, score)));
  }

  public static int[] solution(int k, int[] score) { //k는 명예의 전당에 오를 사람의 수
    int[] answer = new int[score.length];
    ArrayList<Integer> fameHall = new ArrayList<Integer>();

    //arrays.sort 이용해보기
    for (int i = 0; i < score.length; i++) {
      if (i < k) {
        fameHall.add(score[i]);
        Collections.sort(fameHall);
        answer[i] = fameHall.get(0);
      } else {
        if (answer[i - 1] < score[i]) {
          fameHall.remove(0);
          fameHall.add(0, score[i]);
          Collections.sort(fameHall);
          answer[i] = fameHall.get(0);
        } else {
          answer[i] = answer[i - 1];
        }
      }
    }
    return answer;
  }
  /* 모범답안 -> 우선순위 큐를 이용하여 코드를 좀 더 깔끔하게 작성하였다.
  public int[] solution(int k, int[] score) {
    int[] answer = new int[score.length];

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    int temp = 0;

    for(int i = 0; i < score.length; i++) {

        priorityQueue.add(score[i]);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }

        answer[i] = priorityQueue.peek();
    }



    return answer;
} */
}

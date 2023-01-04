package 수포자;

import java.util.*;

class Solution {

  public static void main(String[] args) {
    int[] answers = { 1, 3, 2, 4, 2 };
    System.out.println(Arrays.toString(solution(answers)));
  }

  public static int[] solution(int[] answers) {
    List<Integer> list = new ArrayList<Integer>();
    int topScore = Math.max(
      answer_1(answers),
      Math.max(answer_2(answers), answer_3(answers))
    );
    if (topScore == answer_1(answers)) list.add(1);
    if (topScore == answer_2(answers)) list.add(2);
    if (topScore == answer_3(answers)) list.add(3);

    return list.stream().mapToInt(i -> i).toArray();
  }

  public static int answer_1(int[] answers) {
    int cnt = 0;
    int[] answer_1 = { 1, 2, 3, 4, 5 };
    int j = 0;
    for (int i : answers) {
      if (i == answer_1[j]) {
        cnt++;
      }
      j++;
      if (j > 4) {
        j = 0;
      }
    }
    return cnt;
  }

  public static int answer_2(int[] answers) {
    int cnt = 0;
    int[] answer_2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
    int j = 0;
    for (int i : answers) {
      if (i == answer_2[j]) {
        cnt++;
      }
      j++;
      if (j > 7) {
        j = 0;
      }
    }
    return cnt;
  }

  public static int answer_3(int[] answers) {
    int cnt = 0;
    int[] answer_3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    int j = 0;
    for (int i : answers) {
      if (i == answer_3[j]) {
        cnt++;
      }
      j++;
      if (j > 9) {
        j = 0;
      }
    }
    return cnt;
  }
}
/*  문제 수는 1문제 이상 10000문제 이하
1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... 
1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성

회고 : 중복된 코드가 너무 많고 %연산자를 이용하면 훨씬 간결하다는 걸 인지하지 못 했다. 또한, 
stream().mapToInt(i -> i).toArray()와 같은 Integer -> int 로 변환하는 클래스를 활용하는 건 이제 외워야겠다.
*/
/* 모범답안
  public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

  
        return list.stream().mapToInt(i -> i).toArray();
    }

 
*/

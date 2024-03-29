package Budget;

import java.util.*;

class Solution {
//test
  public int solution(int[] d, int budget) {
    int answer = 0;
    Arrays.sort(d);

    for (int i = 0; i < d.length; i++) {
      if (budget - d[i] >= 0) {
        budget -= d[i];
        answer++;
      } else break;
    }

    return answer;
  }
}
/* 모범 답안 
class Solution {

  public int solution(int[] d, int budget) {
    int answer = 0;

    Arrays.sort(d);

    for (int i = 0; i < d.length; i++) {
      budget -= d[i];

      if (budget < 0) break;

      answer++;
    }

    return answer;
  }
} */

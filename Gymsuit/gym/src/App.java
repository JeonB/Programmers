/* Greedy Algorithms(탐욕법, 탐욕 알고리즘) 문제
➡ 미리 정한 기준에 따라서 매번 가장 좋아보이는 답을 선택하는 알고리즘
 */
import java.util.ArrayList;
import java.util.Arrays;
/* Arrays.asList() 메소드는,
primitive 타입을 Wrapper 클래스로(여기서는 int에서 Integer로) 형변환해주지 않기 때문에,
primitive 타입의 배열은, Arrays.asList()로는 List로 변환할 수 없다.
 */

//모범 답안
import java.util.Arrays;
import java.util.List;

class Solution {

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

    Arrays.sort(lost);
    Arrays.sort(reserve);

    // 여벌 체육복을 가져온 학생이 도난당한 경우
    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] == reserve[j]) {
          answer++;
          lost[i] = -1;
          reserve[j] = -1;
          break;
        }
      }
    }
    // 도난당한 학생에게 체육복 빌려주는 경우
    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
          answer++;
          reserve[j] = -1;
          break;
        }
      }
    }
    return answer;
  }
}

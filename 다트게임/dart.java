package 다트게임;

import java.util.Arrays;
import java.util.regex.*;

public class dart {

  public static void main(String[] args) {
    String dart = "1S*10T*0S";
    System.out.println(solution(dart));
  }

  public static int solution(String dartResult) {
    int answer = 0;

    String regex = "([0-9]|10){1}[SDT]+[*#]?";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(dartResult);
    while (matcher.find()) {
      String point = matcher.group();
      System.out.println(point);
      // if(point.length()==2){
      //     answer += (int) Math.pow(point.charAt(0)-'0', answer)
      // }
    }
    return answer;
  }
}
//s -> pow(a,1) d-> 2제곱 pow(a,2) t -> 3제곱 pow(a,3)
// *, # -> 옵션 *은 바로앞과 전 점수 2배 / #은 바로앞 점수 마이너스
// *은 첫번째 기회에서부터 나올 수 있으며 중첩 가능
// #도 중첩 가능
//0~10정수,SDT*#

package 문자열내림차순배치;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class gogo {

  public static void main(String[] args) {
    System.out.println(solution("Zbcdefg"));
  }

  public static String solution(String s) {
    String answer = "";
    char[] str = s.toCharArray();
    Arrays.sort(str);
    StringBuilder sb = new StringBuilder(String.valueOf(str));

    answer = sb.reverse().toString();
    return answer;
  }
}

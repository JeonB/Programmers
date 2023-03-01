package 시저암호;

import SortStr.sortStr;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class caesarPassword {

  public static void main(String[] args) {
    String s = "A z c Z";
    System.out.println(solution(s, 25));
  }

  public static String solution(String s, int n) {
    String answer = "";
    StringBuilder stringBuilder = new StringBuilder();
    char c = 0;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (!(c == ' ')) {
        if ('a' <= c && c <= 'z') {
          c += n;
          if (c > 'z') {
            c = (char) ('a' + (c % 'z') - 1);
          }
        } else if ('A' <= c && c <= 'Z') {
          c += n;
          if (c > 'Z') {
            c = (char) ('A' + (c % 'Z') - 1);
          }
        }
      }
      stringBuilder.append(c);
    }
    answer = stringBuilder.toString();
    return answer;
  }
}
/* 내 코드랑 큰 차이는 없으나, java.lang.Character 클래스의 isUpperCase,isLowerCase 메소드를 이용하여 깔끔.
 String caesar(String s, int n) {
        String result = "";
    n = n % 26;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (Character.isLowerCase(ch)) {
        ch = (char) ((ch - 'a' + n) % 26 + 'a');
      } else if (Character.isUpperCase(ch)) {
        ch = (char) ((ch - 'A' + n) % 26 + 'A');
      }
      result += ch;
    }
        return result;
    }
 */

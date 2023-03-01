package 이상한문자만들기;

public class strangeStr {

  public static void main(String[] args) {
    String str = "try hello world";
    System.out.println(solution(str));
  }

  public static String solution(String s) {
    StringBuilder stringBuilder = new StringBuilder();
    int num = 0;
    char[] strTochar = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        num = 0;
        continue;
      }
      if (num % 2 == 0 && 'a' <= s.charAt(i)) {
        strTochar[i] -= 32;
      } else if (num % 2 == 1 && 'a' > s.charAt(i)) {
        strTochar[i] += 32;
      }
      num++;
    }
    for (char c : strTochar) {
      stringBuilder.append(c);
    }
    String answer = stringBuilder.toString();
    return answer;
  }
}

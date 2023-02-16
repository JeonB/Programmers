package Password;

public class Password {

  public static void main(String[] args) {
    System.out.println(solution("tukks", "wbqd", 5));
  }

  public static String solution(String s, String skip, int index) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = (char) (s.charAt(i) + index);
      if (c > 122) {
        c = (char) ('a' + (c - 122) - 1);
        for (int j = 0; j < skip.length(); j++) {
          if (skip.charAt(j) < c) {
            c += 1;
            if (c > 122) c = 'a';
          }
        }
      }
      for (int j = 0; j < skip.length(); j++) {
        if (s.charAt(i) < skip.charAt(j) && skip.charAt(j) < c) {
          c += 1;
          if (c > 122) c = 'a';
        }
      }
      stringBuilder.append(c);
    }
    String answer = stringBuilder.toString();
    return answer;
  }
}

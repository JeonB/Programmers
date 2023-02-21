package Password;

public class Password {

  public static void main(String[] args) {
    System.out.println(solution("zukks", "wbqd", 5));
  }

  public static String solution(String s, String skip, int index) {
    char[] charArr = s.toCharArray();
    for (int i = 0; i < charArr.length; i++) {
      charArr[i] = (char) (s.charAt(i) + index);
      if (charArr[i] > 122) charArr[i] -= 26;
      for (int j = 0; j < skip.length(); j++) {
        if (s.charAt(i) > skip.charAt(j) && skip.charAt(j) < charArr[i]) {
          charArr[i] += 1;
          if (charArr[i] > 122) charArr[i] -= 26;
          continue;
        }
        if (
          s.charAt(i) < skip.charAt(j) && charArr[i] > skip.charAt(j)
        ) charArr[i] += 1;
      }
    }
    String answer = new String(charArr);
    return answer;
  }
}

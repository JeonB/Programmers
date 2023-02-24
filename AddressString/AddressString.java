package AddressString;

public class AddressString {

  public static void main(String[] args) {
    solution("a12346");
  }

  public static boolean solution(String s) {
    boolean answer = true;
    if (s.length() == 4 || s.length() == 6) {
      for (int i = 0; i < s.length(); i++) {
        if (!(47 < s.charAt(i) && s.charAt(i) < 58)) {
          answer = false;
        }
      }
    } else {
      answer = false;
    }
    return answer;
  }
}

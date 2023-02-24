package SortStr;

import java.util.Arrays;

public class sortStr {

  public String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];
    char[] tmp = new char[strings.length];

    Arrays.sort(strings);
    for (int i = 0; i < strings.length; i++) {
      tmp[i] = strings[i].charAt(n);
    }
    Arrays.sort(tmp);
    for (int i = 0; i < tmp.length; i++) {
      for (String str : strings) {
        if (tmp[i] == str.charAt(n)) {
          answer[i] = str;
          str = "";
        }
      }
    }
    return answer;
  }
}

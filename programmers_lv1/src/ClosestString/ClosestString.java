package ClosestString;

import java.util.*;

public class ClosestString {

  public static void main(String[] args) {
    String str = "banana";
    System.out.println(Arrays.toString(solution(str)));
  }

  //banana
  public static int[] solution(String s) {
    int[] answer = new int[s.length()];
    Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        answer[i] = i - map.get(s.charAt(i));
        map.put(s.charAt(i), i);
      } else {
        map.put(s.charAt(i), i);
        answer[i] = -1;
      }
    }

    return answer;
  }
}

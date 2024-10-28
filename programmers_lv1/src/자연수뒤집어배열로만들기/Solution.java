package 자연수뒤집어배열로만들기;

import java.util.*;

public class Solution {

  public static void main(String[] args) {
    int n = 12345;
    System.out.println(Arrays.toString(solution(n)));
  }

  public static int[] solution(int n) {
    char[] s = String.valueOf(n).toCharArray();
    for (int i = 0; i < s.length / 2; i++) {
      char temp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = temp;
    }
  }
}

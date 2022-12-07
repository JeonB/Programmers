package StringSplit;

class Split {

  public static void main(String[] args) {
    String abc = "abracadabra";
    System.out.println(solution(abc));
  }

  public static int solution(String s) {
    String[] str = s.split("");
    int answer = 0;
    int cnt1 = 0, cnt2 = 0;
    String firstChar = "";
    for (String c : str) {
      if (firstChar == "") {
        firstChar = c;
        cnt1++;
        continue;
      } else if (firstChar.equals(c)) {
        cnt1++;
        continue;
      } else {
        cnt2++;
      }

      if (cnt1 == cnt2) {
        firstChar = "";
        cnt1 = 0;
        cnt2 = 0;
        answer++;
      }
    }
    if (!firstChar.isEmpty()) {
      answer++;
    }
    return answer;
  }
}
/* 모범답안 ->  toCharArray()를 이용하면 split(),equals(),isEmpty() 같은 메소드를 안 써도 된다.
 class Solution {

  public int solution(String s) {
      char firstChar = '1';
      int same = 0, different = 0, answer = 0;
      for (char c : s.toCharArray()) {
          if (firstChar == '1') {
              firstChar = c;
              same++;
              answer++;
          } else if (firstChar == c) {
              same++;
          } else {
              different++;
          }

          if (same == different) {
              firstChar = '1';
              same = 0; different = 0;
          }
      }

      return answer;
  }
}
*/

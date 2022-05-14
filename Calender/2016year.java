import java.util.*;

class Solution {

  public String solution(int a, int b) {
    String answer = "";
    String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
    int i = 0;
    int feb = 29;
    int c = 30;
    int d = 31;

    switch (a) {
      case 1:
        i = b % 7;
        answer = week[i];
        break;
      case 2:
        i = (b + d) % 7;
        answer = week[i];
        break;
      case 3:
        i = (b + feb + d) % 7;
        answer = week[i];
        break;
      case 4:
        i = (b + feb + 2 * d) % 7;
        answer = week[i];
        break;
      case 5:
        i = (b + feb + c + 2 * d) % 7;
        answer = week[i];
        break;
      case 6:
        i = (b + feb + c + 3 * d) % 7;
        answer = week[i];
        break;
      case 7:
        i = (b + feb + 2 * c + 3 * d) % 7;
        answer = week[i];
        break;
      case 8:
        i = (b + feb + 2 * c + 4 * d) % 7;
        answer = week[i];
        break;
      case 9:
        i = (b + feb + 2 * c + 5 * d) % 7;
        answer = week[i];
        break;
      case 10:
        i = (b + feb + 3 * c + 5 * d) % 7;
        answer = week[i];
        break;
      case 11:
        i = (b + feb + 3 * c + 6 * d) % 7;
        answer = week[i];
        break;
      case 12:
        i = (b + feb + 4 * c + 6 * d) % 7;
        answer = week[i];
        break;
    }
    return answer;
  }
}

//모범 답안
class Solution {

  public String solution(int a, int b) {
    String answer = "";

    int[] c = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    String[] MM = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
    int Adate = 0;
    for (int i = 0; i < a - 1; i++) {
      Adate += c[i];
    }
    Adate += b - 1;
    answer = MM[Adate % 7];

    return answer;
  }
}

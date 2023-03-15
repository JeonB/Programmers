package base3;

import java.util.ArrayList;

public class base3 {

  public static void main(String[] args) {
    System.out.println(solution(45));
  }

  public static int solution(int n) {
    ArrayList<Integer> base = new ArrayList<>();

    int answer = 0;
    int exp = 0;
    int tmp = n;
    while (n > 2) {
      n /= 3;
      exp++;
    }
    for (int i = 0; i < exp + 1; i++) {
      base.add(i, 0);
    }
    while (tmp > 2) {
      while (n > 2) {
        n /= 3;
        exp++;
      }

      base.set(exp, tmp / (int) Math.pow(3, exp));
      tmp %= (int) Math.pow(3, exp);
      n = tmp;
      exp = 0;
    }
    base.set(exp, n);
    for (int i = 0; i < base.size(); i++) {
      answer += base.get(i) * Math.pow(3, base.size() - (i + 1));
    }
    return answer;
  }
}
/* 모범답안 parseInt()는 원하는 진법으로 변환 가능함
public int solution(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    } */

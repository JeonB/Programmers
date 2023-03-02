package 부족한금액계산;

public class bigNum {

  public static void main(String[] args) {
    System.out.println(solution(2500, 1000000000, 2500));
  }

  public static long solution(int price, int money, int count) {
    long answer = (long) count * (price + price * count) / 2 - money;
    if (answer <= 0) return 0;
    return answer;
  }
}

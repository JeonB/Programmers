package 놀이공원;

public class Playground {

  public static void main(String[] args) {}

  public long solution(int price, int money, int count) {
    double answer = (price + count * price) / 2d;
    if (money > answer) {
      answer = 0;
    } else {
      answer -= money;
    }
    return (long) answer;
  }
}

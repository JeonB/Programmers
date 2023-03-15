package MinimumBox;

public class minimumBox {

  public static void main(String[] args) {
    int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
    minimumBox test = new minimumBox();
    System.out.println(test.solution(sizes));
  }

  public int solution(int[][] sizes) {
    int answer = 0;
    int tmp = 0;
    int[] max = new int[2];
    for (int i = 0; i < sizes.length; i++) {
      if (sizes[i][0] < sizes[i][1]) {
        tmp = sizes[i][0];
        sizes[i][0] = sizes[i][1];
        sizes[i][1] = tmp;
      }
      if (sizes[i][0] > max[0]) max[0] = sizes[i][0];
      if (sizes[i][1] > max[1]) max[1] = sizes[i][1];
    }
    answer = max[0] * max[1];
    return answer;
  }

  //모범답안. Math클래스의 max와 min 메소드를 활용하여 깔끔학게 구현 가능.
  public int solution2(int[][] cards) {
    int answer = 0;
    int width = 0, height = 0;
    for (int[] card : cards) {
      width = Math.max(width, Math.max(card[0], card[1]));
      height = Math.max(height, Math.min(card[0], card[1]));
    }

    answer = width * height;
    return answer;
  }
}

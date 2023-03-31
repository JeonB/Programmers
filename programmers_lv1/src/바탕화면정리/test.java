package 바탕화면정리;

import java.util.Arrays;

public class test {

  public static void main(String[] args) {
    String[] wallpaper = {
      ".##...##.",
      "#..#.#..#",
      "#...#...#",
      ".#.....#.",
      "..#...#..",
      "...#.#...",
      "....#....",
    };
    System.out.println(Arrays.toString(solution(wallpaper)));
  }

  public static int[] solution(String[] wallpaper) {
    int[] answer = new int[4]; // 0번 째: s의 행 , 1번 째: s의 열 , 2번 째: e의 행, 3번 째: e의 열
    answer[0] = 50;
    answer[1] = 50;
    answer[2] = 0;
    answer[3] = 0;

    for (int i = 0; i < wallpaper.length; i++) {
      for (int j = 0; j < wallpaper[i].length(); j++) {
        if (wallpaper[i].charAt(j) == '#') {
          if (i <= answer[0]) answer[0] = i;
          if (j <= answer[1]) answer[1] = j;
          if (i >= answer[2]) answer[2] = i + 1;
          if (j >= answer[3]) answer[3] = j + 1;
        }
      }
    }
    // 가장 작은 j 값이 answer[1]에 입력됨 그 때 i 값이 answer[0]

    return answer;
  }
}

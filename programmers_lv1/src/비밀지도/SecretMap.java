package 비밀지도;

import java.util.Arrays;

public class SecretMap {
  //프로그래머스 비밀지도
  public static void main(String[] args) {
    int[] arr1 = { 9, 20, 28, 18, 11 };
    int[] arr2 = { 30, 1, 21, 17, 28 };
    System.out.println(Arrays.toString(solution(5, arr1, arr2)));
  }

  public static String[] solution(int n, int arr1[], int arr2[]) {
    String[] answer = new String[n];
    String[] code = new String[n];
    String[] code2 = new String[n];

    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      while (arr1[i] > 0) {
        sb.insert(0, arr1[i] % 2);
        arr1[i] /= 2;
      }
      while (sb.length() < n) sb.insert(0, '0');

      code[i] = sb.toString();
      sb.delete(0, sb.length());

      while (arr2[i] > 0) {
        sb.insert(0, arr2[i] % 2);
        arr2[i] /= 2;
      }
      while (sb.length() < n) sb.insert(0, '0');

      code2[i] = sb.toString();
    }
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        if (code[i].charAt(j) == '1' || code2[i].charAt(j) == '1') {
          sb.append("#");
        } else {
          sb.append(" ");
        }
      }
      answer[i] = sb.toString();
    }

    return answer;
  }
  /* toBinaryString 메소드는 말 그대로 2진수 문자열로 변환해준다. 이 때 |(or)연산자 활용이 눈에 띈다. 단, 처리속도가 매우느림
    public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
    }

    for (int i = 0; i < n; i++) {
      result[i] = String.format("%" + n + "s", result[i]);
      result[i] = result[i].replaceAll("1", "#");
      result[i] = result[i].replaceAll("0", " ");
    }

    return result;
  } */
}

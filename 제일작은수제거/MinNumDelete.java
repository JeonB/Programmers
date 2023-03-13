package 제일작은수제거;

public class MinNumDelete {

  public int[] solution(int[] arr) {
    int[] answer = new int[arr.length - 1];
    if (arr.length == 1) {
      arr[0] = -1;
      return arr;
    }

    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i]) min = arr[i];
    }
    int j = 0;
    for (int i = 0; i < arr.length; i++) {
      if (min == arr[i]) continue;
      answer[j] = arr[i];
      j++;
    }

    return answer;
  }
}

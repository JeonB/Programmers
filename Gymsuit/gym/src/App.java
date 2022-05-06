public class App {

  public static void main(String[] args) throws Exception {
    Solution func = new Solution();
    int n = 5;
    int[] lost = { 2, 4 };
    int[] reserve = { 3 };
    func.solution(n, lost, reserve);
  }
}

class Solution {

  public int solution(int n, int[] lost, int[] reserve) {
    int ln = n - lost.length;

    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (reserve[j] - 1 == lost[i] || reserve[j] + 1 == lost[i]) {
          ln++;
        }
      }
    }
    if (ln > n) return n; else return ln;
  }
}

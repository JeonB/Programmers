package 콜라츠추측;

public class Collatz {

  int count = 0;

  public long solution(long num) { // 주어진 문제를 변형했을 때부터 의도를 벗어났다고 생각됨.
    if (count == 0 && num == 1) {
      return 0;
    } else if (count > 500) return -1; else if (num % 2 == 0) {
      num /= 2;
      count++;
      return solution(num);
    } else {
      if (num == 1) {
        return count;
      }
      num = num * 3 + 1;
      count++;
      return solution(num);
    }
  }
}
/* 귀찮게 재귀함수로 구현하는게 아니라 반복문으로 구현.
  public int collatz(int num) {
    if(num == 1)
        return 0;
    long n = (long)num;
    for(int i=0; i<500; i++){
        if(n==1) return i; 
      n = (n%2==0) ? n/2 : n*3+1;
    }

 */

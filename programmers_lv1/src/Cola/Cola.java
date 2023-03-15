package Cola;
class Cola {
    public static void main(String[] args) {
        System.out.println(solution(3, 2, 20));
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;

        while(n>=a){
            answer += n/a*b;
            n = n%a + n/a*b;
        }

        return answer;
    }
}



/* 빈 병 a개를 가져다 주면 콜라b병을 줌
 * 빈 병 n개를 가져다주면 총 몇병의 콜라를 받을까?
 * a = 2 , b = 1, n = 20일 때 콜라 총 19개 받음
 * 보유 중인 병이 a개 미만이면 추가적으로 빈병 못 받음
 * 
 * 몫과 나머지를 이용해보자
 * n = n * b/a
 */

 /* 
  *  public int solution(int a, int b, int n) {
        return (n-b)/(a-b)*b;
    }
  */
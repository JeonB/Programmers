package april_10_16.숫자의표현;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    //효율성 테스트 실패
    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int num = 1;
        while(num <= n/2){
            for(int i = num ; i<n/2+2 ; i++){
                sum += i;
                if(sum == n){
                    answer++;
                    break;
                }
            }
            sum = 0;
            num++;
        }
        answer++;
        return answer;
    }
}

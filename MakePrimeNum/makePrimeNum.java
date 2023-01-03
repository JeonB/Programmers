package MakePrimeNum;

class Solution {
    public static void main(String[] args) {
       int[] nums = {1,2,3,4};
       System.out.println(solution(nums));
    }
    public static int solution(int[] nums) {
        int answer = 0;
        int num = 0;
        for(int i = 0 ; i<nums.length - 2;i++){
            for(int j = i+1 ; j<nums.length - 1 ; j++){
                for(int k = j+1; k<nums.length ; k++){
                    num = nums[i] + nums[j] + nums[k];
                    if(isPrime(num))
                        answer++;
                }
            }
        }

        return answer;
    }
    public static boolean isPrime(int num){
        boolean isprime=true;
        for(int i = 2 ; i<=(int)Math.sqrt(num) ; i++){
            if(num % i == 0){
                isprime=false;
                break;
            }
        }

        return isprime;
    }
}

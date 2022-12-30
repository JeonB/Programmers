package MakePrimeNum;

class Solution {
    public static void main(String[] args) {
       int[] nums = {1,2,7,6,4};
       System.out.println(solution(nums));
    }
    public static int solution(int[] nums) {
        int answer = -1;
        int sum = 0;
        for(int i = 0 ; i<nums.length-3;i++){
            for(int j = i+1 ; j<nums.length -2 ; j++){
                for(int k = j+1; k<nums.length - 1 ; k++){
                    sum = nums[i] + nums[j] + nums[k];
                }
            }
        }

        return answer;
    }
    public static boolean isPrime(int num){
        boolean isprime;
        for(int i =1 ; i<=Math.pow(num, 0.5) ; i++){
            
        }


        return 
    }
}

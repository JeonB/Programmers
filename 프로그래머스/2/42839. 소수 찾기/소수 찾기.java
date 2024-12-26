import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int[] nums = numbers.chars().map(i->i-'0').toArray();
        Set<Integer> primes = new HashSet<>();
        generatePrime(0,nums,new boolean[nums.length],primes);
        answer = primes.size();
        return answer;
    }
    
    void generatePrime(int acc, int[] nums, boolean[] isUsed, Set<Integer> primes){
        if(isPrime(acc)) primes.add(acc);
        
        for( int i =0; i<nums.length ; i++){
            if(isUsed[i]) continue;
            int nextAcc = acc * 10 + nums[i];
            
            isUsed[i] = true;
            generatePrime(nextAcc, nums, isUsed, primes);
             isUsed[i] = false;
        }
    }
    
    boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}
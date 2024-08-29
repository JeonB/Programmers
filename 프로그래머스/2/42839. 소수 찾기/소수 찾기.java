import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> primesCandidates = new HashSet<>();
        generatePrimeCandidates("", numbers, primesCandidates);
        for (int num : primesCandidates) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public void generatePrimeCandidates(String current ,  String remains,HashSet<Integer> primesCandidates){
        if(!current.isEmpty()) primesCandidates.add(Integer.parseInt(current));
        
        for(int i = 0 ; i < remains.length() ; i++){
            generatePrimeCandidates(current + remains.charAt(i) , remains.substring(0,i) + remains.substring(i + 1), primesCandidates);
        }
    }
    
    
    public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}
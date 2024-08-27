class Solution {
    public long solution(int k, int d) {
        long answer = 0;
     
        int maxValue = d / k;
        
        for(int b = 0 ; b<= maxValue ; b++){
            long y = (long) b * k;
            long maxX = (long) Math.sqrt((long)d * d - y * y);
            
            // 가능한 a 값의 개수를 더함
            answer += (maxX / k) + 1;
        }
        
        return answer;
    }
}
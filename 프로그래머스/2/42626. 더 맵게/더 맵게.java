import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int sco : scoville){
            pq.offer(sco);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int minSco = pq.poll();
            int secondMinSco = pq.poll();
            pq.offer(minSco + 2 * secondMinSco);
            answer++;
        }
        
        if(pq.peek() < K) return -1;
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(String operation : operations){
            String[] op = operation.split(" ");

            if(op[0].equals("I")){
                int num = Integer.valueOf(op[1]);
                minHeap.offer(num);
                maxHeap.offer(num);
            }else{
                if(minHeap.isEmpty()) continue;
                int maxValue = maxHeap.peek();
                int minValue = minHeap.peek();
                if(op[1].equals("1")){
                    maxHeap.poll();
                    minHeap.remove(maxValue);
                }else{
                    minHeap.poll();
                    maxHeap.remove(minValue);
                }
            }
        }
        
        if(minHeap.isEmpty() ) return new int[]{0,0};
        
        answer = new int[]{maxHeap.peek(),minHeap.peek()};
        return answer;
    }
}



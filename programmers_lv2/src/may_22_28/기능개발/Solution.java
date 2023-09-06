package may_22_28.기능개발;

import java.util.*;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int day = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    //Stack으로 구현한 메소드
    public int[] solution2(int[] progresses, int[] speeds) {

        int[] dayList = new int[speeds.length];
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i = 0 ; i<speeds.length ; i++){
            int cnt = 0;
            while( progresses[i]<100){
                progresses[i] += speeds[i];
                cnt++;
            }
            dayList[i] = cnt;
        }

        int count = 1;

        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < dayList.length ; i++){
            if(i  == dayList.length-1 ){
                if(st.peek() >= dayList[i]){
                    count++;
                    answerList.add(count);
                }else{
                    answerList.add(count);
                    answerList.add(1);
                }
            }else{
                if(st.isEmpty()){
                    st.push(dayList[i]);
                }else if(st.peek() >= dayList[i]){
                    count++;
                }
                else{
                    st.push(dayList[i]);
                    answerList.add(count);
                    count = 1;
                }
            }
        }

        int[] answer = answerList.stream().mapToInt(x->x).toArray();
        return answer;
    }
}

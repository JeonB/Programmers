package april_10_16.구명보트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    //최대 2명 탈 수 있으며 무게제한이 있는 보트
public class Solution {
    // 통과는 했으나 엄밀히 풀면 틀린 풀이. 최대 2명이 탈 수 있다는 조건을 안 지킴. 어떻게 통과할 수 있었는지 모르겠음
    public int solution(int[] people, int limit) {
        int answer = 0;
        int pl = 0 ,pr = people.length-1;
        int sum = 0;
        int[] weight = Arrays.stream(people).boxed().mapToInt(Integer::intValue).sorted().toArray();
        while(pl <= pr){
            if (weight[pl] + weight[pr] <= limit) {
                pl++;
                sum = weight[pl] + weight[pr];
            }
            else {
                pr--;
                answer++;
                continue;
            }
            while(sum + weight[pl] <= limit) {
                sum+=weight[pl];
                pl++;
            }
            answer++;
            sum = 0;
            pr--;
        }
        return answer;
    }
    // 2명씩 보트에 탈 수 있으며 무게제한 있음
    //
}

    /* 조건을 맞춘 풀이
        public int solution(int[] people, int limit) {
        int answer = 0;
        int pl = 0 ,pr = people.length-1;
        int sum = 0;
        Arrays.sort(people);
        while(pl <= pr){
            if(pl == pr){
                answer++;
                break;
            }
            if (people[pl] + people[pr] <= limit) {
                pl++;
                pr--;
                answer++;
            }
            else {     
                pr--;
                answer++;
                
            }
    }
   return answer;
    }  
    */


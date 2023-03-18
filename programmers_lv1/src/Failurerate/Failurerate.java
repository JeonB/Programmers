package Failurerate;

import java.util.Arrays;
import java.util.Comparator;

public class Failurerate {
    // N 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
    // N이 5이면 총 5스테이지 , stages의 길이는 사람의 수 , stages의 각 값은 그 사람의 현재 스테이지
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        float[][] rate = new float[N][2];
        for(int i =1 ; i<N+1;i++){
            int people = 0,fpeople = 0;
            float failrate=0;
            for (int stage : stages) {
                if(stage>i){
                    people++;
                } else if (stage == i) {
                    fpeople++;
                }
            }
            people+= fpeople;
            if(people == 0)
                failrate = 0;
            else
                failrate = (float) fpeople/people;
            rate[i-1][0]=failrate;
            rate[i-1][1]=i;
        }
        Arrays.sort(rate, Comparator.comparingDouble((float[] o) -> o[0]).reversed());
        for(int i = 0; i< answer.length;i++){
            answer[i] = (int)rate[i][1];
        }
        return answer;
    }
}

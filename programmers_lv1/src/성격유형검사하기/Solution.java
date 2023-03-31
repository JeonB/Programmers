package 성격유형검사하기;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 1. 4개의 지표가 있으며 각 지표는 RT,CF,JM,AN 의 순서를 가진다.
    // 2. 각 지표당 더 큰 점수를 획득한 지표가 성격으로 고정되며, 같을 경우 알파벳 순서를 따른다
    // 3. 계산한 성격을 출력
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int[][] personality = new int[4][2]; //RT,CF,JM,AN
        List<String> inspect = Arrays.asList("RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"); //0,2,4,6
        for(int i = 0 ; i< survey.length ; i++){
            int index = inspect.indexOf(survey[i])/2;
            if(inspect.indexOf(survey[i])%2 == 0){
                if(choices[i]<4){
                    if(choices[i] == 1)
                        choices[i]+=2;
                    else if(choices[i] == 3)
                        choices[i]-=2;
                    personality[index][0] += choices[i];
                }
                else if(choices[i]>4)
                    personality[index][1] += (choices[i]-4);
            }
            else {
                if(choices[i]<4)
                {
                    if(choices[i] == 1)
                        choices[i]+=2;
                    else if(choices[i] == 3)
                        choices[i]-=2;
                    personality[index][1] += choices[i];
                }
                else if(choices[i]>4)
                    personality[index][0] += (choices[i]-4);
            }
        }
        answer = whatPersonal(personality);
        return answer;
    }

    public static String whatPersonal(int[][] personality){
        StringBuilder sb = new StringBuilder();

        String[] inspect = {"RT", "CF", "JM", "AN"};
        for (int i = 0 ; i<personality.length ; i++) {
            if(personality[i][0] < personality[i][1])
                sb.append(inspect[i].charAt(1));
            else
                sb.append(inspect[i].charAt(0));
        }

        return sb.toString();
    }
}

package NumberPartner;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution("3403","13203"));
    }
    public static String solution(String X, String Y) {
        
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        
        for (String tmpX : X.split("")) cntX[Integer.parseInt(tmpX)]++;
        for (String tmpY : Y.split("")) cntY[Integer.parseInt(tmpY)]++;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i >= 0; i--){
            while(cntX[i] > 0 && cntY[i] > 0){
                sb.append(i); //sb 는 추가되는 요소의 타입을 안 가리는 듯?
                cntX[i]--;
                cntY[i]--;
            }
        }
        
        String answer = "";
        
        if ("".equals(sb.toString())) {
            answer = "-1";
        } else if ("0".equals(sb.toString().substring(0,1))) {
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;
    }
}

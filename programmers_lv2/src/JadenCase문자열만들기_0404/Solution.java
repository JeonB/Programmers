package JadenCase문자열만들기_0404;

import java.util.ArrayList;

public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> space = new ArrayList<>();
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == ' ')
                space.add(i);
        }

        String[] jadencase = s.split("\\s");

        for(int i = 0 ; i<jadencase.length ; i++){
            char[] jaden = jadencase[i].toCharArray();
            for(int j = 0; j<jadencase[i].length() ; j++){
                if(!Character.isDigit(jadencase[i].charAt(j)) && j == 0)
                    jaden[j] = Character.toUpperCase(jadencase[i].charAt(j));
                else if(!Character.isDigit(jadencase[i].charAt(j)))
                    jaden[j] = Character.toLowerCase(jadencase[i].charAt(j));
            }

            sb.append(jaden);
        }

        for(int i = 0; i<space.size() ; i++)
            sb.insert((int)space.get(i), ' ');

        String answer = sb.toString();
        return answer;
    }
    
    /* 모범답안 flag를 이용해 공백문자와 첫 문자를 구분하였다.
    public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
  } 
    */
}

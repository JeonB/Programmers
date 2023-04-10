package april_4_9.JadenCase문자열만들기;

import java.util.ArrayList;


/*
        JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열.
        문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수 구현.

        # 제한 사항

        - s는 길이 1 이상인 문자열입니다.
        - s는 알파벳과 공백문자(" ")로 이루어져 있습니다.
        - 첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )
*/

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
    
/*//     모범답안 flag를 이용해 공백문자와 첫 문자를 구분하였다.
    public String solution2(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            sb.append(flag ? ss.toUpperCase() : ss);
            flag = ss.equals(" ") ? true : false;
        }
        answer = sb.toString();
        return answer;
  }*/
}

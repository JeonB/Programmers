package april_10_16.영어끝말잇기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
이전에 등장했던 단어는 사용할 수 없습니다.
한 글자인 단어는 인정되지 않습니다.
 */
    public int[] solution(int n, String[] words) {
        int player = 0;
        int cycle = 1;
        int[] answer = new int[]{0,0};
        List<String> strList = new ArrayList<>();
        //한글자 단어, 이전 알파벳과 이어지지 않는 단어, 또 나온 단어 탈락
        strList.add(words[0]);
        for(int i = 1 ; i< words.length;i++){
            if(i%n == 0 )
                cycle++;
            if( words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                player = i%n + 1;
                answer = new int[]{player, cycle};
                return answer;
            }
            else if(words[i].length() == 1){
                player = i%n + 1;
                answer = new int[]{player, cycle};
                return answer;
            }
            else if(strList.contains(words[i])){
                player = i%n + 1;
                answer = new int[]{player, cycle};
                return answer;
            }
            strList.add(words[i]);
        }

        return answer;
    }
    /* HashSet을 이용한 중복제거로 특정 객체가 중복되었는지 안 되었는지 알 수 있음
    public int[] solution(int n, String[] words) {
        int[] answer = { 0, 0 };
        char chEnd = words[0].charAt(words[0].length() - 1);
        char chStart;
        
        HashSet<String> log = new HashSet<>();
        log.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            chStart = words[i].charAt(0);
            log.add(words[i]);
            if (chEnd != chStart || log.size() != i + 1) {
                answer[0] = (i % n)+1;
                answer[1] = (i / n) + 1;
                break;
            }

            chEnd = words[i].charAt(words[i].length() - 1);
        }
      
        return answer;
    } 
    */
}

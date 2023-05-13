package may_8_14.HIndex;

import java.util.*;
class Solution {
    /*
    어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
    어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성
    */
    public int solution(int[] citations) {
        // citations == 각 논문의 인용 횟수 담은 배열
        // citations.length == 발표 논문 수
        int answer = 0;
        int citationsCnt = 0;

        Arrays.sort(citations);
        //1,6,6,6,6 -> 4
        //0,2,3,5,6 -> 3
        //0,0,0,0,0 -> 0
        //0,1,1,1,1 -> 1
        for(int i = citations.length - 1 ; i>=0 ; i--){
            if(citations[i] == 0)
                break;
            else if(citations[i] > 0 && citations[i]> citationsCnt)
                citationsCnt++;
            else
                return citationsCnt;
        }
        answer = citationsCnt;
        return answer;
    }
}
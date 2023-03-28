package 개인정보수집유효기간;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 주어진 오늘 날짜(today)기준으로 약관(terms) 보관 날짜가 지났는지 확인
// privacies: 개인정보 수집날짜 약관종류 --> 공백문자로 구분 날짜는 yyyy.mm.dd, 약관종류는 A~Z
// terms: 약관종류 유효기간 --> 공백문자로 구분 약관종류는 A~Z , terms 에서 중복X , 유효기간은 1~100, 각 달은 28일
// 파기해야할 개인정보 번호를 오름차순으로 반환 -> 개인정보 번호는 privacies[i]에서 i+1
public class Privacies {
    // 1. today, privacies를 숫자로 year month day 형태로 변환 day는 1 or 28일 기준으로 주의
    // 2. terms의 약관종류 유효달 -> key value hashmap
    // 3. privacies[i] + 유효달과 today 크기비교
    // 4. today 보다 작으면 answer에 i+1추가
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); //약관 종류와 유효기간(달) 매핑
        String[] date = today.split(    "['.']");

        int t_date = Integer.parseInt(date[0])*12*28+Integer.parseInt(date[1])*28 +Integer.parseInt(date[2]) ; //오늘 날짜
        String[] termDuration; // 약관과 유효기간
        String[] privacyTerm; //privacies의 개인정보 수집날짜와 약관
        String term;  // 약관
        int duration; // 유효 달
        
        // 약관과 유효기간 매핑
        for(int i = 0 ; i<terms.length ; i++){
            termDuration = terms[i].split("[' ']");
            duration = Integer.parseInt(termDuration[1]);
            term = termDuration[0];
            map.put(term,duration);
        }
        
        // privacies의 약관 값에 맞는 value값 반환 및 반환값과 유효기간을 합친 값과 오늘 날짜와의 크기 비교
        for(int i = 0 ; i<privacies.length ; i++){
            privacyTerm = privacies[i].split("[' ']");
            date = privacyTerm[0].split("['.']");
            int p_date = (Integer.parseInt(date[0])*12*28)+(Integer.parseInt(date[1])*28)+Integer.parseInt(date[2]) + (map.get(privacyTerm[1])*28)- 1;
            if (t_date>p_date) {
                list.add(i+1);
         }
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}

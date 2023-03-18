package 숫자문자열과영단어;

import java.util.HashMap;

public class NumberStringEng {
    //숫자와 영단어가 있는 문자열을 숫자로 반환
    public int solution(String s) {
        int answer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<String,String> map = new HashMap<>();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("zero", "0");
        String str = "";
        for(int i = 0 ; i<s.length();i++){

            if(Character.isDigit(s.charAt(i))){
                stringBuilder.append(s.charAt(i));
            }else {
                str += String.valueOf(s.charAt(i));
                if(map.containsKey(str)){
                    stringBuilder.append(map.get(str));
                    str="";
                }
            }
        }
        answer = Integer.parseInt(stringBuilder.toString());
        return answer;
    }

    /* replaceAll 함수를 이용하여 영단어를 숫자로 변환.
    public int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
    */
}

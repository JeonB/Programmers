package SortStr;

import java.util.Arrays;

public class sortStr {

  public String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];
    char[] tmp = new char[strings.length];

    Arrays.sort(strings);
    for (int i = 0; i < strings.length; i++) {
      tmp[i] = strings[i].charAt(n);
    }
    Arrays.sort(tmp);
    for (int i = 0; i < tmp.length; i++) {
      for (String str : strings) {
        if (tmp[i] == str.charAt(n)) {
          answer[i] = str;
          str = "";
        }
      }
    }
    return answer;
  }
  /*  기준 문자를 꺼내서 기존 문자열에 붙인다는 발상이 놀랍다. arr.add()에서 ""의 의미가 뭘까?. 하지만, 실행속도가 너무 느리다는 단점이 있다.
   String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
   */

  /* 실행속도가 훨씬 빠르고 자바적으로 풀은 답이다.
    Arrays.sort(strings, new Comparator<String>(){
          @Override
          public int compare(String s1, String s2){
              if(s1.charAt(n) > s2.charAt(n)) return 1;
              else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
              else if(s1.charAt(n) < s2.charAt(n)) return -1;
              else return 0;
          }
      });
      return strings;
    */
}

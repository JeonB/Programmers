class Split {

  public static void main(String[] args) {
    Solution("test")
    System.out.println("test");
  }

  public int solution(String s) {
    int answer = 0,i=0;
    int cnt1 = 1, cnt2 = 0;
    char fistChar = s.charAt(i);
    for (i =0; i < s.length(); i++) {

      if (fistChar == s.charAt(i+1)) {
        cnt1++;
        fistChar=s.charAt(i+1);
        continue;
      } else {
        cnt2++;
      }
      
      if (cnt1 == cnt2) {
        answer++;
      }
      fistChar = s.charAt(i+2);
    }
    return answer;
  }
}
//     ex str = "aaabbbcc";
//     -> return 2
//     if()
//     string firstChar = s[0]
//     string otherChar
//     1) 검사하는 첫 문자의 개수 == 첫 문자가 아닌 문자의 개수 -> 제외 result값 증가
//     2) 반복 + result값 증가
//     3) 문자열 끝에 다다르면 종료 및 result값 반환
// }

class Split {

  public static void main(String[] args) {
    Solution("test")
    System.out.println("test");
  }

  public int solution(String s) {
    String[] str = s.split("");
    int answer = 0,i=0;
    int cnt1 = 0, cnt2 = 0;
    char fistChar;
    for (String c : str) {
      fistChar= c ;
      cnt1++;
      if (cnt1 == cnt2) {
        answer++;
      }
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

package 핸드폰번호가리기;

public class PhoneNum {

  public static String solution(String phone_number) {
    String answer = "";
    if (phone_number.length() > 4) {
      String temp = phone_number.substring(0, phone_number.length() - 4);
      answer =
        temp.replaceAll("\\w", "*") +
        phone_number.substring(
          phone_number.length() - 4,
          phone_number.length()
        );
    } else {
      answer = phone_number;
    }
    return answer;
  }
  /*  모범답안. 4자리일 경우 반복문 패스. 처리 속도가 훨씬 빠르다.
       public String solution(String phone_number) {
         char[] ch = phone_number.toCharArray();
         for(int i = 0; i < ch.length - 4; i ++){
             ch[i] = '*';
         }
         return String.valueOf(ch);
      }
       */
}

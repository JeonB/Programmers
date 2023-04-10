package april_4_9.이진변환반복;

class Solution {
    // 메모리 할당을 최대한 줄이면 줄일수록 당연히 처리 속도는 빨라진다.
    public int[] solution(String s) {
        int binaryOp = 0; //이진변환반복 연산 횟수
        int delZero = 0;  //제거된 0의 개수
        int slength = 0;  //문자열길이
        while(s.length() != 1){
            for(int i= 0 ; i<s.length() ; i++){
                if(s.charAt(i) == '1' )
                    slength++;
            }
            delZero += s.length() - slength;
            binaryOp++;
            s = Integer.toBinaryString(slength); // 10진수를 2진수 문자열로 변환하는 메소드
            slength = 0;
        }

        int[] answer = {binaryOp,delZero};
        return answer;
    }
}

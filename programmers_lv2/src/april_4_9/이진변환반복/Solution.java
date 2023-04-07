package april_4_9.이진변환반복;

class Solution {
    public int[] solution(String s) {
        int binaryOp = 0;
        int delZero = 0;
        while(s.length() != 1){
            StringBuilder sb = new StringBuilder();

            for(int i= 0 ; i<s.length() ; i++){
                if(s.charAt(i) == '1' )
                    sb.append('1');
            }
            delZero += s.length() - sb.length();
            binaryOp++;
            s = Integer.toBinaryString(sb.length());
        }

        int[] answer = {binaryOp,delZero};
        return answer;
    }
}

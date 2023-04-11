package april_10_16.다음큰숫자;

import java.util.Arrays;

public class Solution {
    // 직접 비트를 옮겨 본 헛짓거리 메소드. 1의 개수를 구하는게 힌트다.
    public static int solution(int n) {
        int answer = 0;
        boolean flag = true;
        int j = 0;
        String[] binaryNum = Integer.toBinaryString(n).split("");
        for(int i=0;i<binaryNum.length;i++){
            if(binaryNum[i].equals("0")){
                flag = false;
            }
            else if(flag == false && binaryNum[i].equals("1")){
                binaryNum[i] = "0";
                binaryNum[i-1] = "1";
                j = i;
                break;
            }
        }
        if(flag== true){
            String[] bin = new String[binaryNum.length+1];
            for(int i = 0 ; i<bin.length;i++){
                bin[i] = "1";
                if(i == 1)
                    bin[i]= "0";
            }
            return answer = Integer.parseInt(String.join("",bin),2);
        }

        for(int i = binaryNum.length-1; i>j ; i--){
            if(binaryNum[i].equals("0"))
                flag = false;
            else if (flag == false && binaryNum[i].equals("1")) {
                binaryNum[i] = "0";
                binaryNum[i+1] = "1";
                if(Integer.parseInt(String.join("",binaryNum),2) < n){
                    binaryNum[i] = "1";
                    binaryNum[i+1] = "0";
                    return answer = Integer.parseInt(String.join("",binaryNum),2);
                }
            }
        }
        char[] num = Integer.toBinaryString(n).toCharArray();
        for(char i : num){

        }
        answer = Integer.parseInt(String.join("",binaryNum),2);
        return answer;
    }
/* 1번 모범답안. 이해 안 가는 비트 연산을 통한 값 도출.
    public int nextBigNumber(int n) {
        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
    */

/* 2번 모범답안. Integer 클래스의 bitCount()를 통해 1의 개수 구함
    public int nextBigNumber(int n)
    {
        int a = Integer.bitCount(n);
        int compare = n+1;
        while(true) {
            if(Integer.bitCount(compare)==a)
                break;
            compare++;
        }
        return compare;
    }
   */

/* api가 아닌 직접 메소드를 구현해서 1의 개수 구하기
    public int solution(int n) {
        int answer = 0;
        int a = n;
        while(true){
            if(cntOne(n) == cntOne(++a)){
                answer = a;
                break;
            }
        }


        return answer;
    }
    // 변환된 2진수의 1의 개수 구하기
    public int cntOne(int n){
        char[] num = Integer.toBinaryString(n).toCharArray();
        int cnt = 0;

        for(char i : num){
            if(i == '1')
                cnt++;
        }
        return cnt;
    }
    */
}

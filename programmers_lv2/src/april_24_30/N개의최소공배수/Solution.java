package april_24_30.N개의최소공배수;

import java.util.Arrays;
// n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성
class Solution {
    public int solution(int[] arr) {

        int max = 0;
        int min = 0;

        for (int i = 1 ; i <arr.length; i++) {
            int a = arr[i];
            int b = arr[i-1];
            while(true){
                if(a>b){
                    a%=b;
                    if(a == 0 ){
                        max = b;
                        break;
                    }
                }
                else {
                    b%=a;
                    if(b == 0 ){
                        max = a;
                        break;
                    }
                }
            }
            min = arr[i]*arr[i-1]/max; //최소공배수
            arr[i] = min;
        }

        return min;
    }
}
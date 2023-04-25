package april_24_30.N개의최소공배수;

import java.util.Arrays;

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
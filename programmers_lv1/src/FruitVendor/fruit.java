package FruitVendor;

import java.util.*;
class Solution {

    public static void main(String[] args) {
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(4,3,score));

    }
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] fruit_score = Arrays.stream(  score ).boxed().toArray( Integer[]::new );
        Arrays.sort(fruit_score,Collections.reverseOrder());

        int fruit_box = (score.length)/m;  //상자 개수
        for(int i = 1;i<fruit_box+1 ;i++){
            answer += (fruit_score[m*i-1].intValue())*m;
        }                       
        return answer;
    }
}

/* 
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        for(int i = score.length; i >= m; i -= m){
            answer += score[i - m] * m;
        }

        return answer;
    }
} */
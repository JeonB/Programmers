package april_24_30.주식가격;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        // 각각의 주식이 가격이 떨어지지 않은 초 구하기
        // 가격하락 구간을 파악하려면 해당 인덱스 값과 배열의 모든 값 비교?
        // 배열 길이가 최대 10만이므로 O(10만)이상으로 넘어선다
        // 인덱스와 스택을 활용 -> 스택에 price 넣음. 다음 인덱스로 넘어갈 때마다 크기 비교
        int[] answer = new int[prices.length];
        for (int i = 0; i<answer.length;i++){
            answer[i] = prices.length-1 -i;
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        stack.push(prices[0]);
        index.push(0);
        for(int i = 1; i < prices.length; i++) {

           while (!stack.empty()&&stack.peek()>prices[i])  {
               stack.pop();
               answer[index.peek()] = i - index.pop();
           }
           stack.push(prices[i]);
           index.push(i);
        }


        return answer;
    }

}

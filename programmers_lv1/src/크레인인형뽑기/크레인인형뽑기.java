package 크레인인형뽑기;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class 크레인인형뽑기 {
        //1. 정사각형 격자의 게임화면과 크레인의 이동 위치를 담은 배열이 주어짐
        //2. 바구니에 이동 위치 순서대로 인형이 쌓이며, 같은 인형이 2개 쌓이면 둘 다 사라짐
        //3. 인형이 없는 곳을 집을 경우 아무런 일도 없음
        //4. board에 있는 1~100 숫자는 인형의 종류를 의미하며 0은 빈 칸을 나타냄
        //5. board의 원소는 게임 화면의 맨 위 부터 차례대로 한 행씩을 의미함
        //6. 터트려져 사라진 인형의 개수 구하기
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        Stack<Integer>[] gameBoard = new Stack[board.length];

        for(int i = 0 ;i< board.length ;i++){
            gameBoard[i] = new Stack<>();
            for(int j = board.length-1 ; j>=0 ; j--){
                if(board[j][i] == 0)
                    continue;
                gameBoard[i].push(board[j][i]);
            }
        }
        for (int i: moves) {
            if(gameBoard[i-1].empty())
                continue;
            if(basket.empty()){
                basket.push(gameBoard[i-1].pop());
                continue;
            }
            if(gameBoard[i-1].peek().equals(basket.peek())){
                basket.pop();
                gameBoard[i-1].pop();
                answer+=2;
            }
            else{
                basket.push(gameBoard[i-1].pop());
            }
        }

        return answer;
    }
}
/* 모범답안. stack을 2개 만들 필요없이 board의 값을 추출하는 과정을 0으로 바꿈으로써 더 간편하게 작성 가능함.
 public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
*/

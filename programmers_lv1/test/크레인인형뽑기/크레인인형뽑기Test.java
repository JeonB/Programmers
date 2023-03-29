package 크레인인형뽑기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 크레인인형뽑기Test {

    @Test
    void solution() {
        크레인인형뽑기 test = new 크레인인형뽑기();
        int[][] board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[]{1,5,3,5,1,2,1,4};
        assertEquals(test.solution(board,moves),4);
    }
}
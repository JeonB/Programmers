package april_24_30.주식가격;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        Solution s = new Solution();
        int[] prices = {1,2,3,2,3,4};
        int[] answer = {5,3,2,1,1,0};
        assertEquals(s.solution(prices),answer);
    }
}
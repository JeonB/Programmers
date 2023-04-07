package april_4_9.이진변환반복;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        String s = "1111111";
        Solution so = new Solution();

        assertEquals(Arrays.toString(so.solution(s)),new int[]{3,3});
    }
}
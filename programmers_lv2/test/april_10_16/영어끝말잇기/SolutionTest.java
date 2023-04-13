package april_10_16.영어끝말잇기;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        Solution sb = new Solution();
        assertEquals(sb.solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}),new int[]{3,3});
    }
}
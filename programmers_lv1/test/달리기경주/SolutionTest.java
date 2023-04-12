package 달리기경주;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        String[] players= {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"mine", "mine","kai","kai"};
        String[] results= {"mumu", "kai", "mine", "soe", "poe"};
        Solution s = new Solution();
        assertEquals(s.solution(players,callings),results);
    }
}
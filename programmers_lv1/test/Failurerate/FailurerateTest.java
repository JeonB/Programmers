package Failurerate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FailurerateTest {

    @Test
    void solution() {
        Failurerate fr = new Failurerate();
        int[] arr= {2, 1, 2, 6, 2, 4, 3, 3};
        assertEquals(Arrays.toString(fr.solution(5,arr)), Arrays.toString(new int[]{3, 4, 2, 1, 5}));
    }
}
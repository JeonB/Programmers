package 공원산책;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ParkTest {

    @Test
    void solution() {
        Park park = new Park();
        assertEquals(park.solution(new String[]{"SOO","OXX","OOO"},new String[]{"E 2","S 2","W 1"}), Arrays.toString(new int[]{0,1}));
    }
}
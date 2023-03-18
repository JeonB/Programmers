package DartGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DartGameTest {

    @Test
    public void solutionTest() {
        DartGame dg = new DartGame();
        assertEquals(dg.solution("1D2S3T*"),59);
    }
}
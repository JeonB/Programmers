package 추억점수;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        Solution sl = new Solution();
        String[] name = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photo = {{"kali", "mari", "don"},{"pony", "tom", "teddy"},{"con", "mona", "don"}};
        System.out.println(Arrays.toString(sl.solution(name,yearning,photo)));
        assertEquals(sl.solution(name,yearning,photo),new int[]{19,15,6});
    }
}
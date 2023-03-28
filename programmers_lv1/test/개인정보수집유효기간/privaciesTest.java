package 개인정보수집유효기간;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class privaciesTest {

    @Test
    void solution() {
        Privacies privacies = new Privacies();
        String[] privacies1 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String[] terms = {"A 6", "B 12", "C 3"};
        String today = "2022.05.19";
        assertEquals(privacies.solution(today,terms,privacies1),new int[]{1,3});
    }
}
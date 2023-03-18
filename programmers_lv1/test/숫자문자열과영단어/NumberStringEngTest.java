package 숫자문자열과영단어;

import static org.junit.jupiter.api.Assertions.*;

class NumberStringEngTest {

    @org.junit.jupiter.api.Test
    void solution() {
        NumberStringEng te = new NumberStringEng();
        assertEquals(te.solution("1zerotwozero3"),1479);
    }
}
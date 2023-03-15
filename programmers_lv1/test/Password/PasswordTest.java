package Password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @Test
    public void stringTest() {
        Password pa = new Password();
        assertEquals(pa.solution("aukks", "wbqd", 5),"happier");
    }
}
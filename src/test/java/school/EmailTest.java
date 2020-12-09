package school;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void shouldNotCreteEmailFromNull() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
    }

    @Test
    void shouldNotCreateEmailFromEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    @Test
    void shouldNotCreateEmailFromBlankString() {
        assertThrows(IllegalArgumentException.class, () -> new Email(" "));
    }

    @Test
    void shouldNotCreateEmailWithoutAtMark() {
        assertThrows(IllegalArgumentException.class, () -> new Email("ricardo.email.com"));
    }

    @Test
    void shouldNotCreateEmailWithoutDomain() {
        assertThrows(IllegalArgumentException.class, () -> new Email("ricardo@"));
    }

    @Test
    void shouldNotCreateEmailWithoutUser() {
        assertThrows(IllegalArgumentException.class, () -> new Email("@email.com"));
    }

    @Test
    void shouldNotCreateEmailWithoutExtension() {
        assertThrows(IllegalArgumentException.class, () -> new Email("ricardo@email"));
    }

    @Test
    void shouldCreateEmail() {

        String emailAddress = "ricardo@email.com.br";

        Email email = new Email(emailAddress);

        assertNotNull(email);
        assertEquals(emailAddress, email.getAddress());
    }
}
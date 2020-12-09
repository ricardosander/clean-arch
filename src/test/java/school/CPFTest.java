package school;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CPFTest {

    @Test
    void shouldNotCreateCPFFromNull() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }

    @Test
    void shouldNotCreateCPFFromEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
    }

    @Test
    void shouldNotCreateCPFFromBlankString() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(" "));
    }

    @Test
    void shouldNotCreateCPFFromInvalidNumber() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("1"));
    }

    @Test
    void shouldNotCreateCPFFromInvalidNumber2() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("123"));
    }

    @Test
    void shouldNotCreateCPFFromInvalidNumber3() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456"));
    }

    @Test
    void shouldNotCreateCPFFromInvalidNumber4() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("123456789"));
    }

    @Test
    void shouldCreateCPFFromValidNumber() {

        String cpfNumber = "12345678900";

        CPF cpf = new CPF(cpfNumber);

        assertNotNull(cpf);
        assertEquals(cpfNumber, cpf.getNumber());
    }

    @Test
    void shouldCreateCPFFromValidNumberWihSymbols() {

        String cpfNumber = "123.456.789-00";

        CPF cpf = new CPF(cpfNumber);

        assertNotNull(cpf);
        assertEquals(cpfNumber, cpf.getNumber());
    }

}
package io.github.ricardosander.school.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneNumberTest {

    @Test
    void shouldNotCreatePhoneNumberFromNullAreaCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(null, "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromNullLineNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("11", null));
    }

    @Test
    void shouldNotCreatePhoneNumberFromEmptyStringAreaCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromEmptyLineNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("11", ""));
    }

    @Test
    void shouldNotCreatePhoneNumberFromBlankStringAreaCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(" ", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromBlankLineNumber() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("11", " "));
    }

    @Test
    void shouldNotCreatePhoneNumberFromInvalidShortAreaCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("1", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromInvalidLongAreaCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("111", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromInvalidAreaCodeStartingWithZero() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("01", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromInvalidAreaCodeEndingWithZero() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("10", "12345678"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromInvalidShortLineCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("11", "1234567"));
    }

    @Test
    void shouldNotCreatePhoneNumberFromInvalidLongLineCode() {
        assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("11", "1234567"));
    }

    @Test
    void shouldCreatePhoneNumberFromValidPhoneNumber() {

        String areCode = "11";
        String lineNumber = "12345678";

        PhoneNumber phoneNumber = new PhoneNumber(areCode, lineNumber);

        assertNotNull(phoneNumber);
        assertEquals(areCode, phoneNumber.getAreaCode());
        assertEquals(lineNumber, phoneNumber.getLineNumber());
    }

    @Test
    void shouldCreatePhoneNumberFromValidLongPhoneNumber() {

        String areCode = "11";
        String lineNumber = "123456789";

        PhoneNumber phoneNumber = new PhoneNumber(areCode, lineNumber);

        assertNotNull(phoneNumber);
        assertEquals(areCode, phoneNumber.getAreaCode());
        assertEquals(lineNumber, phoneNumber.getLineNumber());
    }
}
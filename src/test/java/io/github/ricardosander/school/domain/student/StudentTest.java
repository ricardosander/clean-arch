package io.github.ricardosander.school.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void addsPhoneNumber() {

        String areaCode = "11";
        String lineNumber = "98765432";

        Student student = StudentBuilder.withNameCPFEmail("Ricardo", "12345678900", "ricardo@email.com").build();

        assertEquals(0, student.getPhoneNumbers().size());

        student.addsPhoneNumber(areaCode, lineNumber);

        assertEquals(1, student.getPhoneNumbers().size());
        assertEquals(areaCode, student.getPhoneNumbers().get(0).getAreaCode());
        assertEquals(lineNumber, student.getPhoneNumbers().get(0).getLineNumber());
    }

}
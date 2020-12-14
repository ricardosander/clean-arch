package io.github.ricardosander.school.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentBuilderTest {

    @Test
    void createStudent() {

        String name = "Ricardo";
        String cpf = "12345678900";
        String email = "ricardo@email.com";

        Student student = StudentBuilder.withNameCPFEmail(name, cpf, email).build();

        assertNotNull(student);
        assertEquals(name, student.getName());
        assertEquals(cpf, student.getCpf());
        assertEquals(email, student.getEmail());
    }

    @Test
    void createStudentWithPhoneNumber() {

        String name = "Ricardo";
        String cpf = "12345678900";
        String email = "ricardo@email.com";
        String areaCode = "11";
        String lineNumber = "98765432";

        Student student = StudentBuilder.withNameCPFEmail(name, cpf, email)
                .withPhoneNumber(areaCode, lineNumber)
                .build();

        assertNotNull(student);
        assertEquals(name, student.getName());
        assertEquals(cpf, student.getCpf());
        assertEquals(email, student.getEmail());
        assertEquals(1, student.getPhoneNumbers().size());
        assertEquals(areaCode, student.getPhoneNumbers().get(0).getAreaCode());
        assertEquals(lineNumber, student.getPhoneNumbers().get(0).getLineNumber());
    }

    @Test
    void createStudentWithPhoneNumbers() {

        String name = "Ricardo";
        String cpf = "12345678900";
        String email = "ricardo@email.com";
        String firstAreaCode = "11";
        String firstLineNumber = "98765432";
        String secondAreaCode = "22";
        String secondLineNumber = "123456789";

        Student student = StudentBuilder.withNameCPFEmail(name, cpf, email)
                .withPhoneNumber(firstAreaCode, firstLineNumber)
                .withPhoneNumber(secondAreaCode, secondLineNumber)
                .build();

        assertNotNull(student);
        assertEquals(name, student.getName());
        assertEquals(cpf, student.getCpf());
        assertEquals(email, student.getEmail());
        assertEquals(2, student.getPhoneNumbers().size());
        assertEquals(firstAreaCode, student.getPhoneNumbers().get(0).getAreaCode());
        assertEquals(firstLineNumber, student.getPhoneNumbers().get(0).getLineNumber());
        assertEquals(secondAreaCode, student.getPhoneNumbers().get(1).getAreaCode());
        assertEquals(secondLineNumber, student.getPhoneNumbers().get(1).getLineNumber());
    }

}
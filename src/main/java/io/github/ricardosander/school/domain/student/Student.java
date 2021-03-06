package io.github.ricardosander.school.domain.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private final CPF cpf;
    private final String name;
    private final Email email;

    private final List<PhoneNumber> phoneNumbers;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        phoneNumbers = new ArrayList<>();
    }

    public String getCpf() {
        return cpf.getNumber();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return Collections.unmodifiableList(phoneNumbers);
    }

    public void addsPhoneNumber(String areaCode, String lineNumber) {
        phoneNumbers.add(new PhoneNumber(areaCode, lineNumber));
    }
}

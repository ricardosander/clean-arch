package io.github.ricardosander.school.domain.student;

public class Email {

    private static final String VALID_EMAIL_REGEX = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

    private String address;

    public Email(String address) {

        if (address == null || !address.matches(VALID_EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

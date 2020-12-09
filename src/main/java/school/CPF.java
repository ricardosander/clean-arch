package school;

public class CPF {

    private static final String VALID_CPF_REGEX = "^([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})$";

    private final String number;

    public CPF(String number) {

        if (number == null || !number.matches(VALID_CPF_REGEX)) {
            throw new IllegalArgumentException("Invalid CPF number.");
        }

        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

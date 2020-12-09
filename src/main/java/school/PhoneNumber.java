package school;

public class PhoneNumber {

    private static final String AREA_CODE_VALID_REGEX = "^([1-9]{2})$";
    private static final String LINE_NUMBER_VALID_REGEX = "^([0-9]{8})|([0-9]{9})$";

    private final String areaCode;
    private final String lineNumber;

    public PhoneNumber(String areaCode, String lineNumber) {

        if (areaCode == null || lineNumber == null || !areaCode.matches(AREA_CODE_VALID_REGEX) || !lineNumber.matches(LINE_NUMBER_VALID_REGEX)) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }

        this.areaCode = areaCode;
        this.lineNumber = lineNumber;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getLineNumber() {
        return lineNumber;
    }
}

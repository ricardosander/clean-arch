package school;

public class StudentBuilder {

    private Student student;

    private StudentBuilder() {

    }

    public static StudentBuilder withNameCPFEmail(String name, String cpf, String email) {
        StudentBuilder builder = new StudentBuilder();
        builder.student = new Student(new CPF(cpf), name, new Email(email));
        return builder;
    }

    public StudentBuilder withPhoneNumber(String areCode, String lineNumber) {
        student.addsPhoneNumber(areCode, lineNumber);
        return this;
    }

    public Student build() {
        return student;
    }

}

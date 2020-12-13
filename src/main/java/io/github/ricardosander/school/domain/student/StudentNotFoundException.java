package io.github.ricardosander.school.domain.student;

public class StudentNotFoundException extends RuntimeException {

  public StudentNotFoundException(CPF cpf) {
    super("Student not found with CPF " + cpf.getNumber());
  }
}

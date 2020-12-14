package io.github.ricardosander.school.infrastructure.student;

import io.github.ricardosander.school.domain.student.CPF;
import io.github.ricardosander.school.domain.student.Student;
import io.github.ricardosander.school.domain.student.StudentNotFoundException;
import io.github.ricardosander.school.domain.student.StudentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryStudentRepository implements StudentRepository {

  private final List<Student> students = new ArrayList<>();

  @Override
  public void enroll(Student student) {
    students.add(student);
  }

  @Override
  public Student searchByCPF(CPF cpf) {
    return students.stream()
        .filter(student -> student.getCpf().equals(cpf.getNumber()))
        .findFirst()
        .orElseThrow(() -> new StudentNotFoundException(cpf));
  }

  @Override
  public List<Student> listAll() {
    return Collections.unmodifiableList(students);
  }
}

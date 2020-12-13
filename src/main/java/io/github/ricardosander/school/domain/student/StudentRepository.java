package io.github.ricardosander.school.domain.student;

import java.util.List;

public interface StudentRepository {
  void enroll(Student student);
  Student searchByCPF(CPF cpf);
  List<Student> listAll();
}

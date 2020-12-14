package io.github.ricardosander.school.infrastructure.student;

import static org.junit.jupiter.api.Assertions.*;

import io.github.ricardosander.school.domain.student.CPF;
import io.github.ricardosander.school.domain.student.Student;
import io.github.ricardosander.school.domain.student.StudentBuilder;
import io.github.ricardosander.school.domain.student.StudentNotFoundException;
import io.github.ricardosander.school.domain.student.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class InMemoryStudentRepositoryTest {

  private StudentRepository studentRepository;

  @BeforeEach
  void setUp() {
    studentRepository = new InMemoryStudentRepository();
  }

  @Test
  void enrolledStudentIsFound() {

    String studentName = "Ricardo";
    String studentCPF = "12345678900";
    String studentEmail = "ricardo@github.com";

    Student student =
        StudentBuilder.withNameCPFEmail(studentName, studentCPF, studentEmail)
            .build();

    studentRepository.enroll(student);

    Student studentFound = studentRepository.searchByCPF(new CPF(studentCPF));

    assertNotNull(studentFound);
    assertEquals(studentName, studentFound.getName());
    assertEquals(studentCPF, studentFound.getCpf());
    assertEquals(studentEmail, studentFound.getEmail());
    assertEquals(0, studentFound.getPhoneNumbers().size());
  }

  @Test
  void notEnrolledStudentTrowsException() {


    assertThrows(StudentNotFoundException.class, () -> {

          Student student =
              StudentBuilder.withNameCPFEmail("Ricardo", "12345678900", "ricardo@github.com")
                  .build();

          studentRepository.enroll(student);

          studentRepository.searchByCPF(new CPF("00000000000"));
        }
    );

  }

  @Test
  void listAll() {

    Student firstStudent =
        StudentBuilder.withNameCPFEmail("Ricardo", "11111111111", "ricardo@github.com")
            .build();

    Student secondStudent =
        StudentBuilder.withNameCPFEmail("Sander", "22222222222", "sander@github.com")
            .build();

    Student thirdStudent =
        StudentBuilder.withNameCPFEmail("Lopes", "33333333333", "lopes@github.com")
            .build();

    studentRepository.enroll(firstStudent);
    studentRepository.enroll(secondStudent);
    studentRepository.enroll(thirdStudent);

    List<Student> students = studentRepository.listAll();

    assertNotNull(students);
    assertEquals(3, students.size());
  }
}
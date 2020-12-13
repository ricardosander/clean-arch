package io.github.ricardosander.school.domain.student;

import java.time.LocalDateTime;

public class Indication {

  private Student indicated;
  private Student indicative;
  private LocalDateTime date;

  public Indication(Student indicated, Student indicative) {
    this.indicated = indicated;
    this.indicative = indicative;
    this.date = LocalDateTime.now();
  }

  public Student getIndicated() {
    return indicated;
  }

  public Student getIndicative() {
    return indicative;
  }

  public LocalDateTime getDate() {
    return date;
  }
}

package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain;

import static lombok.AccessLevel.PRIVATE;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Generated
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "EVA_TOKEN")
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  Long id;

  @Column(name = "Token")
  String token;
}

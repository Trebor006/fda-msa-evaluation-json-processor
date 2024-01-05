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
@Table(name = "EVA_DATA")
public class Data {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  Long id;

  @Column(name = "IdToken")
  Long idToken;

  @Column(name = "column1")
  String column1;

  @Column(name = "column2")
  String column2;
}

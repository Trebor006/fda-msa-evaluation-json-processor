package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain;

import static lombok.AccessLevel.PRIVATE;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Generated
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "EJP_TOKEN")
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EJTO_ID")
  Long id;

  @Column(name = "TOKEN")
  String token;

  @Column(name = "CREATION_DATE")
  Date creationDate;

}

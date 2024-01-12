package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain;

import static lombok.AccessLevel.PRIVATE;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Generated
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "EVA_USER")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  Long id;

  @ManyToOne
  @JoinColumn(
      name = "IdToken",
      nullable = false,
      foreignKey = @ForeignKey(name = "FK_user_token_id"))
  Token token;

  @Column(name = "name")
  String name;

  @Column(name = "lastname")
  String lastname;

  @Column(name = "creationDate")
  Date creationDate;
}

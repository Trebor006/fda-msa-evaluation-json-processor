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
@Table(name = "EJP_USER")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "EJUS_ID")
  Long id;

  @ManyToOne
  @JoinColumn(
      name = "EJTO_ID",
      nullable = false,
      foreignKey = @ForeignKey(name = "FK_EJP_USER_EJP_TOKEN_EJTO_ID"))
  Token token;

  @Column(name = "NAME")
  String name;

  @Column(name = "LASTNAME")
  String lastname;

  @Column(name = "CREATION_DATE")
  Date creationDate;
}

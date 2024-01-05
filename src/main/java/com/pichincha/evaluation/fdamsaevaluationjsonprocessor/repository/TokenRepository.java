package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

  Token findByToken(String token);

  boolean existsByToken(String token);
}

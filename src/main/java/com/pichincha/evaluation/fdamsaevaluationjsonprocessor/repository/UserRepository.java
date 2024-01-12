package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

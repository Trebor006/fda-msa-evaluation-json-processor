package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto;

import static org.junit.jupiter.api.Assertions.*;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.util.MockUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostUserRequestDtoTest {

  @Test
  @DisplayName("Should validate dto")
  void shouldValidateDto() {

    PostUserRequestDto postUserRequestDto = MockUtils.POST_USER_REQUEST_DTO;

    Assertions.assertSame(postUserRequestDto.getName(), MockUtils.POST_USER_REQUEST_DTO.getName());
    Assertions.assertSame(
        postUserRequestDto.getLastname(), MockUtils.POST_USER_REQUEST_DTO.getLastname());
  }
}

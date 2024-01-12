package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.util;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Token;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.User;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostUserRequestDto;

public class MockUtils {
  public static final PostUserRequestDto POST_USER_REQUEST_DTO =
      PostUserRequestDto.builder()
              .name("Robert")
              .lastname("Cabrera")
              .build();
  private static final String TOKEN_VALUE =
      "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIiLCJleHAiOjE3MDUwNzIzNjUsImlhdCI6MTcwNTA3MjM1NX0.N1BXsEiJosyo_4dtQmYOtPJxC8uuWELKk1Cnb5UXZNw";
  public static final PostRequestDto POST_REQUEST_DTO =
      PostRequestDto.builder().token(TOKEN_VALUE).build();
  public static final PostResponseDto POST_RESPONSE_DTO = PostResponseDto.builder().build();
  public static final Token TOKEN = Token.builder().build();
  public static final User USER = User.builder().build();

  private MockUtils() {}
}

package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository.DataRepository;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository.TokenRepository;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.mapper.TokenMapper;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.mapper.UserMapper;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.util.MockUtils;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {ProcessorServiceImplTest.class})
class ProcessorServiceImplTest {

  @Mock private TokenMapper tokenMapper;
  @Mock private UserMapper userMapper;

  @Mock private DataRepository dataRepository;
  @Mock private TokenRepository tokenRepository;

  @InjectMocks ProcessorServiceImpl processorService;

  @Test
  @DisplayName("Should return a valid token")
  void shouldReturnAValidResponseWhenTokenNotInDatabase() {
    PostRequestDto requestDto = MockUtils.POST_REQUEST_DTO;

    when(tokenRepository.existsByToken(any())).thenReturn(Boolean.FALSE);
    when(tokenRepository.findByToken(any())).thenReturn(MockUtils.TOKEN);
    when(userMapper.mapToUserEntity(any(), any())).thenReturn(MockUtils.USER);

    Optional<PostResponseDto> result = processorService.saveDataStructure(requestDto);

    assertTrue(result.isPresent());
    assertNotNull(result.get());

    verify(tokenRepository, times(1)).save(any());
    verify(tokenMapper, times(1)).mapToTokenEntity(any());

    verify(tokenRepository, times(1)).existsByToken(any());
    verify(tokenRepository, times(1)).findByToken(any());
    verify(dataRepository, times(1)).save(any());
  }

  @Test
  @DisplayName("Should return a valid token when token already exists")
  void shouldReturnAValidResponseWhenTokenAlreadyExists() {
    PostRequestDto requestDto = MockUtils.POST_REQUEST_DTO;

    when(tokenRepository.existsByToken(any())).thenReturn(Boolean.TRUE);
    when(tokenRepository.findByToken(any())).thenReturn(MockUtils.TOKEN);
    when(userMapper.mapToUserEntity(any(), any())).thenReturn(MockUtils.USER);

    Optional<PostResponseDto> result = processorService.saveDataStructure(requestDto);

    assertTrue(result.isPresent());
    assertNotNull(result.get());

    verify(tokenRepository, never()).save(any());
    verify(tokenMapper, never()).mapToTokenEntity(any());

    verify(tokenRepository, times(1)).existsByToken(any());
    verify(tokenRepository, times(1)).findByToken(any());
    verify(dataRepository, times(1)).save(any());
  }
}

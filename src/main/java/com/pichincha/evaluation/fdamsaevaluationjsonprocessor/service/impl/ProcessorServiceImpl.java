package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.impl;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Token;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.User;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository.DataRepository;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository.TokenRepository;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.ProcessorService;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.mapper.TokenMapper;
import java.util.Optional;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

  private final TokenMapper tokenMapper;
  private final UserMapper userMapper;

  private final DataRepository dataRepository;
  private final TokenRepository tokenRepository;

  @Override
  public Optional<PostResponseDto> saveDataStructure(PostRequestDto requestDto) {

    if (!tokenRepository.existsByToken(requestDto.getToken())) {
      saveToken(requestDto);
    }

    Token token = tokenRepository.findByToken(requestDto.getToken());

    User user = userMapper.mapToUserEntity(token, requestDto.getUser());

    dataRepository.save(user);

    return Optional.empty();
  }

  private void saveToken(PostRequestDto requestDto) {
    tokenRepository.save(tokenMapper.mapToTokenEntity(requestDto.getToken()));
  }
}

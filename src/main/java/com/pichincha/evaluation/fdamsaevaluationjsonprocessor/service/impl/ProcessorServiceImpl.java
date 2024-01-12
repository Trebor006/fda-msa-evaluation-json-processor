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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
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
      log.info("saving new token in database");
      saveToken(requestDto);
    }

    User user =
        userMapper.mapToUserEntity(
            tokenRepository.findByToken(requestDto.getToken()), requestDto.getUser());

    dataRepository.save(user);

    return Optional.of(PostResponseDto.builder().name(user.getName()).build());
  }

  private void saveToken(PostRequestDto requestDto) {
    tokenRepository.save(tokenMapper.mapToTokenEntity(requestDto.getToken()));
  }
}

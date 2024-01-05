package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.impl;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Data;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Token;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository.DataRepository;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.repository.TokenRepository;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.ProcessorService;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessorServiceImpl implements ProcessorService {

  private final DataRepository dataRepository;
  private final TokenRepository tokenRepository;

  @Override
  public Optional<PostResponseDto> saveDataStructure(PostRequestDto requestDto) {

    if (!tokenRepository.existsByToken(requestDto.getToken())) {
      saveToken(requestDto);
    }

    Token token = tokenRepository.findByToken(requestDto.getToken());

    Data data =
        Data.builder()
            .idToken(token.getId())
            .column1(requestDto.getJsonStructure().getCampo1())
            .column2(requestDto.getJsonStructure().getCampo2())
            .build();

    dataRepository.save(data);

    return Optional.empty();
  }

  private void saveToken(PostRequestDto requestDto) {
    tokenRepository.save(Token.builder().token(requestDto.getToken()).build());
  }
}

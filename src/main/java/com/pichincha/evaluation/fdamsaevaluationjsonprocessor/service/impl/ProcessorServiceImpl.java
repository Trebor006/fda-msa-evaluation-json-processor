package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.impl;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.ProcessorService;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProcessorServiceImpl implements ProcessorService {
  @Override
  public Optional<PostResponseDto> save(PostRequestDto requestDto) {
    return Optional.empty();
  }
}

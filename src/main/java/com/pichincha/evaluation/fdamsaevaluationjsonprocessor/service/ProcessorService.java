package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import java.util.Optional;

public interface ProcessorService {
  Optional<PostResponseDto> save(PostRequestDto requestDto);
}

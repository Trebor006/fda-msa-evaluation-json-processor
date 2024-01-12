package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.controller;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.ProcessorService;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostRequestDto;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostResponseDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("processor")
public class ProcessorController {

  private final ProcessorService processorService;

  @PostMapping("save")
  public ResponseEntity<PostResponseDto> generateToken(@RequestBody PostRequestDto requestDto) {
    log.info("Token : " + requestDto.getToken());
    Optional<PostResponseDto> response = processorService.saveUserInformation(requestDto);

    return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
  }
}

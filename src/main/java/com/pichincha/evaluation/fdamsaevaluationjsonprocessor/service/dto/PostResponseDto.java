package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PostResponseDto {
    String name;
}

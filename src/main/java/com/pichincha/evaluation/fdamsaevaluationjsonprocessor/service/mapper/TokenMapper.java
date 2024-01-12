package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.mapper;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Token;
import lombok.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Generated
@Mapper(componentModel = "spring")
public interface TokenMapper {

  @Mapping(target = "token", source = "tokenVal")
  @Mapping(target = "creationDate", expression = "java(new java.util.Date())")
  Token mapToTokenEntity(String tokenVal);
}

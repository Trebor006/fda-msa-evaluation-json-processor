package com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.mapper;

import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.Token;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.domain.User;
import com.pichincha.evaluation.fdamsaevaluationjsonprocessor.service.dto.PostUserRequestDto;
import lombok.Generated;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Generated
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", source = "userRequestDto.name")
    @Mapping(target = "lastname", source = "userRequestDto.lastname")
    @Mapping(target = "token", source = "token")
    @Mapping(target = "creationDate", expression = "java(new java.util.Date())")
    User mapToUserEntity(Token token, PostUserRequestDto userRequestDto);
}

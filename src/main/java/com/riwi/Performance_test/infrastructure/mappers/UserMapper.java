package com.riwi.Performance_test.infrastructure.mappers;

import com.riwi.Performance_test.domain.models.UserEntity;
import com.riwi.Performance_test.infrastructure.dtos.request.RegisterRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.response.RegisterResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegisterResponseDTO userEntityToRegisterResponseDTO(UserEntity userEntity);

    UserEntity registerRequestDTOToUserEntity(RegisterRequestDTO registerRequestDTO);

}
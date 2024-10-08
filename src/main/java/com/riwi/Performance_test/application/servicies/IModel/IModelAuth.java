package com.riwi.Performance_test.application.servicies.IModel;

import com.riwi.Performance_test.infrastructure.dtos.request.LoginRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.request.RegisterRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.response.LoginResponseDTO;
import com.riwi.Performance_test.infrastructure.dtos.response.RegisterResponseDTO;
import com.riwi.Performance_test.utils.enums.Roles;

public interface IModelAuth {
    RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Roles role);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
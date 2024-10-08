package com.riwi.Performance_test.infrastructure.controllers.interfaces;

import com.riwi.Performance_test.infrastructure.dtos.request.LoginRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.request.RegisterRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IAuthController {
    ResponseEntity<?> registerAdmin(RegisterRequestDTO registerRequestDTO);
    ResponseEntity<?> registerCarrier(RegisterRequestDTO registerRequestDTO);

    ResponseEntity<?> login(LoginRequestDTO loginRequestDTO);

}

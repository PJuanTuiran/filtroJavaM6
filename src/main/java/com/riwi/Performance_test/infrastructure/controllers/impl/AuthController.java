package com.riwi.Performance_test.infrastructure.controllers.impl;

import com.riwi.Performance_test.application.servicies.IModel.IModelAuth;
import com.riwi.Performance_test.infrastructure.controllers.interfaces.IAuthController;
import com.riwi.Performance_test.infrastructure.dtos.request.LoginRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.request.RegisterRequestDTO;
import com.riwi.Performance_test.utils.enums.Roles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController implements IAuthController {

    @Autowired
    IModelAuth authService;
    @Operation(
            summary = "Admin Registration",
            description = "Register a new user with Administrator privileges. This endpoint is used to create an Admin user by submitting the required user details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Admin user successfully registered."),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Ensure all required fields are provided and valid."),
            @ApiResponse(responseCode = "409", description = "A user with the provided email already exists."),
    })
    @PostMapping("/adminRegister")
    @Override
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO, Roles.ADMIN));
    }

    @Operation(
            summary = "Carrier Registration",
            description = "Register a new Carrier user. This endpoint is used to register a user who will act as a Carrier in the system. The request body must contain all necessary user details, such as name, email, and password."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carrier user successfully registered."),
            @ApiResponse(responseCode = "400", description = "Invalid input data. Ensure the request body meets the required validation rules."),
            @ApiResponse(responseCode = "409", description = "A user with the provided email already exists.")
    })
    @PostMapping("/carrierRegister")
    @Override
    public ResponseEntity<?> registerCarrier(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO,Roles.CARRIER));

    }

    @Operation(
            summary = "User Login",
            description = "Authenticate a user with valid credentials. Submit the user's email and password to obtain an authentication token. This token can be used for accessing other secured endpoints."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful. Returns an authentication token."),
            @ApiResponse(responseCode = "400", description = "Invalid credentials provided. Ensure the email and password are correct."),
            @ApiResponse(responseCode = "404", description = "User not found with the provided email.")
    })
    @PostMapping("/login")
    @Override
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
    }
}

package com.riwi.Performance_test.application.servicies.impl;

import com.riwi.Performance_test.application.servicies.IModel.IModelAuth;
import com.riwi.Performance_test.domain.models.UserEntity;
import com.riwi.Performance_test.domain.persistence.UserRepository;
import com.riwi.Performance_test.infrastructure.dtos.request.LoginRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.request.RegisterRequestDTO;
import com.riwi.Performance_test.infrastructure.dtos.response.LoginResponseDTO;
import com.riwi.Performance_test.infrastructure.dtos.response.RegisterResponseDTO;
import com.riwi.Performance_test.infrastructure.mappers.UserMapper;
import com.riwi.Performance_test.utils.enums.Roles;
import com.riwi.Performance_test.utils.helpers.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IModelAuth {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTService jwtService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserMapper userMapper;
    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO, Roles role) {


        UserEntity user = userRepository.findByUsername(registerRequestDTO.getUsername());
        if(user != null){
            throw new IllegalArgumentException("User already exists");
        }

        UserEntity userSave = userMapper.registerRequestDTOToUserEntity(registerRequestDTO);
        userSave.setRoles(role);
        userSave.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userSave.setEmail(registerRequestDTO.getEmail());

        userRepository.save(userSave);

        return RegisterResponseDTO.builder()
                .message("user created")
                .username(registerRequestDTO.getUsername())
                .role(role)
                .build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(authentication.isAuthenticated()){
            UserEntity user = userRepository.findByUsername(loginRequestDTO.getUsername());
            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder()
                    .message("Login successful")
                    .role(user.getRoles())
                    .token(jwtService.getToken(user))
                    .build();

            return loginResponseDTO;
        }
        throw new RuntimeException("invalid credentials");

    }
}
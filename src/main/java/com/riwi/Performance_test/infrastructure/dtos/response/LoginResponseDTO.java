package com.riwi.Performance_test.infrastructure.dtos.response;


import com.riwi.Performance_test.utils.enums.Roles;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDTO {

    private String message;
    private Roles role;
    private String token;
}
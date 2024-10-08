package com.riwi.Performance_test.infrastructure.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestDTO {
    @NotBlank(message = "required username")
    private String username;
    @NotBlank(message = "required password")
    private String password;
}
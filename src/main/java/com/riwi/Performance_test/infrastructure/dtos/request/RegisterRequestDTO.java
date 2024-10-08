package com.riwi.Performance_test.infrastructure.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {

    @NotBlank(message = "required username")
    private String username;
    @Email(message = "required email")
    private String email;
    @NotBlank(message = "required password")
    private String password;
}
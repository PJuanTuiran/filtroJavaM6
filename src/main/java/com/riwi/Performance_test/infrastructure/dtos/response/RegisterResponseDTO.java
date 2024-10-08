package com.riwi.Performance_test.infrastructure.dtos.response;

import com.riwi.Performance_test.utils.enums.Roles;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDTO {

    private String message;
    private String username;
    private Roles role;
}
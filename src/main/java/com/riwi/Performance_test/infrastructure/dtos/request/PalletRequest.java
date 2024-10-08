package com.riwi.Performance_test.infrastructure.dtos.request;

import com.riwi.Performance_test.utils.enums.StatusPallets;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PalletRequest {

    @Positive(message = "El peso debe ser mayor a 0")
    private int maxWeight;
    @NotBlank(message = "La ubicación no puede estar vacía")
    private String location;
    @NotBlank(message = "El estado no puede estar vacía")
    @Enumerated(EnumType.STRING)
    private StatusPallets status;
}

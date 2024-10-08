package com.riwi.Performance_test.infrastructure.dtos.request;

import com.riwi.Performance_test.utils.enums.StatusLoads;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoadRequest {
    @NotBlank(message = "El campo no puede estar vacío")
    private Double weight;
    @NotBlank(message = "El campo no puede estar vacío")
    @Positive(message = "El campo no puede ser negativo")
    private Double height;
    @Positive(message = "El campo no puede ser negativo")
    private Double width;
    @Positive(message = "El campo no puede ser negativo")
    private Double length;
    @NotBlank(message = "El campo no puede estar vacío")
    @Enumerated(EnumType.STRING)
    private StatusLoads status;
}

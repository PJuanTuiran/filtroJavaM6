package com.riwi.Performance_test.infrastructure.exeptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ErrorSimple {
    private int code;
    private String status;
    private String message;
}

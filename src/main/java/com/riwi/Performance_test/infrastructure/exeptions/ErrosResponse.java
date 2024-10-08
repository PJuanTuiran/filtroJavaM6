package com.riwi.Performance_test.infrastructure.exeptions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Getter
@Setter
@SuperBuilder
public class ErrosResponse extends ErrorSimple {
    private List<String> Errors;
}

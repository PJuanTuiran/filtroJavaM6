package com.riwi.Performance_test.infrastructure.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface Save <T> {
    ResponseEntity<?> save(T t);
}

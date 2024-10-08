package com.riwi.Performance_test.infrastructure.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface Update <T, ID> {
    ResponseEntity<?> update(ID id, T t);
}

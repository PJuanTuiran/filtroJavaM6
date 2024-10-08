package com.riwi.Performance_test.infrastructure.controllers.generics;

import org.springframework.http.ResponseEntity;

public interface GetById <T, ID>{

    ResponseEntity<?> getById(ID id);
}

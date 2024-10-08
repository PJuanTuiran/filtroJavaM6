package com.riwi.Performance_test.infrastructure.controllers.generics;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetAll <T> {
    ResponseEntity<List<T>> getAll();

}

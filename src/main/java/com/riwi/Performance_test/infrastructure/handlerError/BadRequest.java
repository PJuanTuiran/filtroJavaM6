package com.riwi.Performance_test.infrastructure.handlerError;

import com.riwi.Performance_test.infrastructure.exeptions.ErrorSimple;
import com.riwi.Performance_test.infrastructure.exeptions.ErrosResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest {



        @ExceptionHandler(MethodArgumentNotValidException.class)

        public ErrorSimple badRequest(MethodArgumentNotValidException ex) {
            List<String> errores = new ArrayList<>();
            ex.getAllErrors().forEach(error -> errores.add(error.getDefaultMessage()));

            return ErrosResponse.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .message("Errores de validación")
                    .Errors(errores).build();

        }
    }


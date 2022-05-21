package com.tests.tester.model.exeption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalException {

//TODO: HttpClient lar qushilib qoldi Samandar akaga ko`rsatish kere;
        @ExceptionHandler
        public ResponseEntity<?> exeption(HttpClientErrorException.BadRequest testerException){
            return ResponseEntity.badRequest().body(testerException.getMessage());
        }
}

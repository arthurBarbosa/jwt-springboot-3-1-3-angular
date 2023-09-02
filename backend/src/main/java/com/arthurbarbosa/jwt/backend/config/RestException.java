package com.arthurbarbosa.jwt.backend.config;

import com.arthurbarbosa.jwt.backend.dtos.ErrorDTO;
import com.arthurbarbosa.jwt.backend.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestException {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDTO(ex.getMessage()));
    }
}

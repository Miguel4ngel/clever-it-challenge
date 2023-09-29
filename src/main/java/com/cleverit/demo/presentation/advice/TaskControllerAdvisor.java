package com.cleverit.demo.presentation.advice;

import com.cleverit.demo.domain.exception.TaskNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

/**
 * @author Miguel Angel
 * @since v1.0.0
 */

@ControllerAdvice
@Log4j2
public class TaskControllerAdvisor {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleTaskNotFoundException(TaskNotFoundException ex) {
        log.info("[handleTaskNotFoundException] Task Not found.");
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(Instant.now())
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

}

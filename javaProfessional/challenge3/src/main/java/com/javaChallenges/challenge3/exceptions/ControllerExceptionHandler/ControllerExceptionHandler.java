package com.javaChallenges.challenge3.exceptions.ControllerExceptionHandler;


import com.javaChallenges.challenge3.dto.CustomErrorDTO;
import com.javaChallenges.challenge3.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomErrorDTO errorDTO = new CustomErrorDTO(Instant.now(),status.value(),exception.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(errorDTO);

    }

}

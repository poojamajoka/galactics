package com.galactice.Galactics.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AstronautNotFoundException.class)
    public ResponseEntity<ApiError> handleAstronautNotFound(
            AstronautNotFoundException ex,
            HttpServletRequest request
    ) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI(), "Astronaut Not Found");
    }

    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiError> handleSatelliteNotFound(
            SatelliteNotFoundException ex,
            HttpServletRequest request
    ) {
        ex.printStackTrace();
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI(), "Satellite Not Found");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        // Collecting all the validation errors into a list
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.toList());

        // Formatting the error messages
        String errorMsg = String.join(", ", errorMessages);

        // Returning the error response
        return buildError(HttpStatus.BAD_REQUEST, errorMsg, request.getRequestURI(), "Validation Error");
    }

    // Build error response with an additional error field
    private ResponseEntity<ApiError> buildError(HttpStatus status, String message, String path, String error) {
        ApiError apiError = new ApiError(
                message,
                path,
                status.value(),
                Instant.now(),
                error
        );
        return ResponseEntity.status(status).body(apiError);
    }
}

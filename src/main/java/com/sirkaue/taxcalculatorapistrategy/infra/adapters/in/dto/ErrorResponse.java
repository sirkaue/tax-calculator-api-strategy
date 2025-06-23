package com.sirkaue.taxcalculatorapistrategy.infra.adapters.in.dto;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        String method) {

    public ErrorResponse(HttpServletRequest request, HttpStatus status, Exception message) {
        this(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message.getMessage(),
                request.getRequestURI(),
                request.getMethod());
    }
}

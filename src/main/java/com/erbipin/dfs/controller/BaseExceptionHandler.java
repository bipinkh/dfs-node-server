package com.erbipin.dfs.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public abstract class BaseExceptionHandler {

    private static final ExceptionMapping DEFAULT_ERROR = new ExceptionMapping(
            "SERVER_ERROR",
            "Internal server error",
            INTERNAL_SERVER_ERROR);

    private final Logger log;
    private String customDetails = "Oops, no further details provided !";
    private final Map<Class, ExceptionMapping> exceptionMappings = new HashMap<>();

    public BaseExceptionHandler(final Logger log) {
        this.log = log;
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleThrowable(final Throwable ex, final HttpServletResponse response) {
        ExceptionMapping mapping = exceptionMappings.getOrDefault(ex.getClass(), DEFAULT_ERROR);

        response.setStatus(mapping.status.value());

        log.error("{} ({}): {}", mapping.message, mapping.code, ex.getMessage(), ex);

        if(ex.getMessage() != null ) customDetails = ex.getMessage();

        return new ErrorResponse(mapping.code, mapping.message, customDetails, mapping.status);
    }


    protected void registerMapping(
            final Class<?> clazz,
            final String code,
            final String message,
            final HttpStatus status) {
        exceptionMappings.put(clazz, new ExceptionMapping(code, message, status));
    }

    @Data
    public static class ErrorResponse {
        private final String code;
        private final String message;
        private final String details;
        private final HttpStatus httpStatus;
    }

    @AllArgsConstructor
    private static class ExceptionMapping {
        private final String code;
        private final String message;
        private final HttpStatus status;
    }
}
package com.erbipin.dfs.controller;

import com.erbipin.dfs.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends BaseExceptionHandler {
    public ExceptionHandlers() {
        super(log);
        registerMapping(ResourceNotFoundException.class, "RESOURCE_NOT_FOUND", "Resource not found", HttpStatus.NOT_FOUND);
    }
}

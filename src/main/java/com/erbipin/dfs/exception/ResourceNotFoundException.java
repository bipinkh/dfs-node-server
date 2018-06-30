package com.erbipin.dfs.exception;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String customMessage){
        super(customMessage);
    }
}

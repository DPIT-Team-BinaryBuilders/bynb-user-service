package com.binarybuilders.bynb_user_service.exception;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message){
        super(message);
    }
}

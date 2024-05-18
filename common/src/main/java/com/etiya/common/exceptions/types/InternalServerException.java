package com.etiya.common.exceptions.types;

public class InternalServerException extends InternalError{
    public InternalServerException(String message){
        super(message);
    }
}

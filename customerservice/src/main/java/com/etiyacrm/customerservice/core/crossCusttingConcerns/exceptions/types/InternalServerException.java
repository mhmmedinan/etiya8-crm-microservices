package com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.types;

public class InternalServerException extends InternalError{
    public InternalServerException(String message){
        super(message);
    }
}

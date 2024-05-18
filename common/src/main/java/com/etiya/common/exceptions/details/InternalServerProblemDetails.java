package com.etiya.common.exceptions.details;

import org.springframework.http.HttpStatus;

public class InternalServerProblemDetails extends ProblemDetails {
    public InternalServerProblemDetails(){
        setTitle("Data Integrity Violation");
        setType("http://etiya.com/exceptions/internalservererror");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}

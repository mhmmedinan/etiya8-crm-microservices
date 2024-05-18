package com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.handlers;

import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.details.BusinessProblemDetails;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.details.ValidationProblemDetails;
import com.etiyacrm.customerservice.core.crossCusttingConcerns.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice //try
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class}) //catch
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        Map<String, String> errorDetails = new HashMap<>();
        for (FieldError error : fieldErrors) {
            errorDetails.put(error.getField(), error.getDefaultMessage());
        }

        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setErrors(errorDetails);

        return problemDetails;

    }

/*    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ProblemDetails handleException() {
        return new ProblemDetails("Unknown Error","Some error occurred."
                ,"https://etiya.com/exceptions/unknown","400");
    }*/
}
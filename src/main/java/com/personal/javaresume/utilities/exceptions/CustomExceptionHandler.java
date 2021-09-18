package com.personal.javaresume.utilities.exceptions;

import com.personal.javaresume.utilities.constants.ErrorResponseMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {

        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UsernameNotFoundException ex, WebRequest request) {

        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public final ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) {

        ErrorResponse error = new ErrorResponse(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex) {

        ErrorResponse error = new ErrorResponse(ErrorResponseMessage.INTERNAL_SERVER_ERROR);
        error.setErrorDescription(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ValidationErrorResponse errorResponse = new ValidationErrorResponse();
        ex.getBindingResult() .getFieldErrors() .forEach(errorResponse::setDetails);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected final ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorResponse error = new ErrorResponse(ErrorResponseMessage.BAD_REQUEST_ERROR);
        error.setErrorDescription(ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

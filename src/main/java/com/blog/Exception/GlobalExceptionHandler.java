package com.blog.Exception;

import com.blog.payload.Errormessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Errormessage> handleError(ResourceNotFoundException e, WebRequest request){
    Errormessage er=new Errormessage(e.getMessage(),new Date(),request.getDescription(true));
    return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
}
}

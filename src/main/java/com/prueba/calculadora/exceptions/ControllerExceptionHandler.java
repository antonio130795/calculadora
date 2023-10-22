package com.prueba.calculadora.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
  
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));
    
    return message;
  }
  
  @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorMessage HttpMessageNotReadableException(org.springframework.http.converter.HttpMessageNotReadableException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
            HttpStatus.BAD_REQUEST.value(),
            new Date(),
            "JSON values must be numeric",
            request.getDescription(false));
    
    return message;
  }
  
  @ExceptionHandler(java.lang.NoSuchMethodError.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage HttpMessageNotReadableException(java.lang.NoSuchMethodError ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            new Date(),
            "Json Body required",
            request.getDescription(false));
    
    return message;
  }
  
  @ExceptionHandler(org.springframework.web.HttpRequestMethodNotSupportedException.class)
  @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
  public ErrorMessage HttpMessageNotReadableException(org.springframework.web.HttpRequestMethodNotSupportedException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
            HttpStatus.METHOD_NOT_ALLOWED.value(),
            new Date(),
            "Method Not Allowed",
            request.getDescription(false));
    
    return message;
  }
  
}

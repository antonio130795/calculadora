package com.prueba.calculadora.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "unitTest")
@DisplayName("ControllerExceptionHandlerTest")
@ExtendWith(MockitoExtension.class)
@SuppressWarnings("deprecation")
public class ControllerExceptionHandlerTest {
	    
    @Mock
    private TracerImpl tracer;

    private WebRequest request;
    
	@InjectMocks
    ControllerExceptionHandler controllerExceptionHandler;
	
    @BeforeEach
    void setUp() {
        request = mock(WebRequest.class);
    }
    
    @Test
    void testResourceNotFoundExceptionHandler() {
        ResourceNotFoundException ex = new ResourceNotFoundException("Resource not found");
        ErrorMessage result = controllerExceptionHandler.resourceNotFoundException(ex, request);
        
        assertEquals(HttpStatus.NOT_FOUND.value(), result.getStatusCode());
        assertEquals("Resource not found", result.getMessage());
        
    }
    
    @Test
    void HttpMessageNotReadableException() {
		org.springframework.http.converter.HttpMessageNotReadableException ex = new org.springframework.http.converter.HttpMessageNotReadableException("JSON values must be numeric");
        ErrorMessage result = controllerExceptionHandler.HttpMessageNotReadableException(ex, request);
        
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatusCode());
        assertEquals("JSON values must be numeric", result.getMessage());
    }
    
    @Test
    void testHttpHttpRequestMethodNotSupportedException() {
    	java.lang.NoSuchMethodError ex = new java.lang.NoSuchMethodError("Json Body required");
        ErrorMessage result = controllerExceptionHandler.NoSuchMethodError(ex, request);
        
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getStatusCode());
        assertEquals("Json Body required", result.getMessage());
    }
    
    @Test
    void HttpHttpRequestMethodNotSupportedException() {
    	org.springframework.web.HttpRequestMethodNotSupportedException ex = new org.springframework.web.HttpRequestMethodNotSupportedException("Method Not Allowed");
        ErrorMessage result = controllerExceptionHandler.HttpRequestMethodNotSupportedException(ex, request);
        
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), result.getStatusCode());
        assertEquals("Method Not Allowed", result.getMessage());
    }
    
    @Test
    void HttpMediaTypeNotSupportedException() {
    	org.springframework.web.HttpMediaTypeNotSupportedException ex = new org.springframework.web.HttpMediaTypeNotSupportedException("Content Type Not Supported");
        ErrorMessage result = controllerExceptionHandler.HttpMediaTypeNotSupportedException(ex, request);
        
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), result.getStatusCode());
        assertEquals("Content Type Not Supported", result.getMessage());
    }
   
}

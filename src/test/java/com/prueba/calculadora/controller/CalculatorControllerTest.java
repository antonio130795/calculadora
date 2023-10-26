package com.prueba.calculadora.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.calculadora.model.AvailableOperations;
import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;
import com.prueba.calculadora.service.CalculatorService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "UnitTest")
@DisplayName("CalculatorControllerTest")
@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {
       
    @Mock
    CalculatorService calculatorService;
    
    @InjectMocks
    CalculatorController calculatorController;

    private CalculatorInput calculatorInput;
    private Result operationResult;
    AvailableOperations availableOperations;

    @BeforeEach
    void setUp() {
       calculatorInput = new CalculatorInput();
       calculatorInput.setFirstOperator(new BigDecimal(1));
       calculatorInput.setSecondOperator(new BigDecimal(2));
       calculatorInput.setOperation("SUM");
       operationResult = new Result();
       operationResult.setResult(new BigDecimal(3));
       
   	   List<String> operationsList = new ArrayList<String>();
   	   operationsList.add("SUBTRACTION");
   	   operationsList.add("SUM");
   	   availableOperations = new AvailableOperations();
   	   availableOperations.setAvailableOperations(operationsList);
    }
    
    @Test
    void testCalculator(){
       when(calculatorService.performOperation(calculatorInput)).thenReturn(operationResult);
       ResponseEntity<Result> result = calculatorController.calculator(calculatorInput);

       assertNotNull(result);
       assertEquals(HttpStatus.OK, result.getStatusCode());
       assertEquals(operationResult, result.getBody());
    }
    
    @Test
    void testOperations(){
       when(calculatorService.getAvaliableOperations()).thenReturn(availableOperations);
       ResponseEntity<AvailableOperations> result = calculatorController.operations();

       assertNotNull(result);
       assertEquals(HttpStatus.OK, result.getStatusCode());
       assertEquals(availableOperations, result.getBody());
    }
}

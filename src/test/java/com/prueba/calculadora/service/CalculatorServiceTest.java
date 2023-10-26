package com.prueba.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.calculadora.exceptions.ResourceNotFoundException;
import com.prueba.calculadora.model.AvailableOperations;
import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;
import com.prueba.calculadora.operations.OperationsI;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "unitTest")
@DisplayName("CalculatorServiceTest")
@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {
    @Mock
    Map<String, OperationsI> operations;

    @InjectMocks
    CalculatorService calculatorService;

    private OperationsI operation;
    private CalculatorInput calculatorInput;
    private Result operationResult;
    private Set<String> set;
    AvailableOperations availableOperations;
    
    @BeforeEach
    void setUp() {
       operation = mock(OperationsI.class);

       calculatorInput = new CalculatorInput();
       calculatorInput.setFirstOperator(new BigDecimal(1));
       calculatorInput.setSecondOperator(new BigDecimal(2));
       calculatorInput.setOperation("SUM");
       operationResult = new Result();
       operationResult.setResult(new BigDecimal(3));
   	   set = new HashSet<String> ();
   	   set.add("SUBTRACTION");
   	   set.add("SUM");
   	   List<String> operationsList = new ArrayList<String>();
   	   operationsList.add("SUBTRACTION");
   	   operationsList.add("SUM");
   	   availableOperations = new AvailableOperations();
   	   availableOperations.setAvailableOperations(operationsList);
   	   
    }
    
    @Test
    void performOperationOkTest() {
       when(operations.get("SUM")).thenReturn(operation);
       when(operations.containsKey("SUM")).thenReturn(true);
       when(operation.calc(calculatorInput)).thenReturn(operationResult);

       Result result = calculatorService.performOperation(calculatorInput);
       assertNotNull(result);
       assertEquals(result, operationResult);
    }
    
    @Test
    void getAvaliableOperationsTest() {

        when(operations.keySet()).thenReturn(set);

    	AvailableOperations result = calculatorService.getAvaliableOperations();
        assertNotNull(result);
        assertEquals(result, availableOperations);

    }
    

    @Test
    void performOperationKoTest() {
       calculatorInput.setOperation("DIVIDE");
       assertThrows(ResourceNotFoundException.class, () -> calculatorService.performOperation(calculatorInput));

       calculatorInput.setOperation(null);
       assertThrows(ResourceNotFoundException.class, () -> calculatorService.performOperation(calculatorInput));

       calculatorInput.setSecondOperator(null);
       assertThrows(ResourceNotFoundException.class, () -> calculatorService.performOperation(calculatorInput));

       calculatorInput.setFirstOperator(null);
       assertThrows(ResourceNotFoundException.class, () -> calculatorService.performOperation(calculatorInput));
    }
}
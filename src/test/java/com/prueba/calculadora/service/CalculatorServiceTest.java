package com.prueba.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.calculadora.exceptions.ResourceNotFoundException;
import com.prueba.calculadora.model.CalculatorInput;


@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	
	@InjectMocks
	CalculatorService calculatorService;
	
	@Test
	void TestCheckOperation() {
		CalculatorInput calculatorInput = new CalculatorInput();
		calculatorInput.setFirstOperator(new BigDecimal(1));
		calculatorInput.setSecondOperator(new BigDecimal(2));
		calculatorInput.setOperation("/");
		Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
			calculatorService.performOperation(calculatorInput);
	    });
		

	}
	
	@Test
	void TestCheckBodyExceptionOperatorNull() {
		CalculatorInput calculatorInput = new CalculatorInput();
		calculatorInput.setFirstOperator(new BigDecimal(1));
		calculatorInput.setSecondOperator(null);
		calculatorInput.setOperation("+");
		Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
			calculatorService.performOperation(calculatorInput);
	    });
	}


}

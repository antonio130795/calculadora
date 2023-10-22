package com.prueba.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.calculadora.model.Operators;
import com.prueba.calculadora.service.CalculatorService;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
	
	@InjectMocks
	CalculatorService calculatorService;
	
	@Test
	void TestGetSubstract() {
	
		Operators operators = new Operators();
		operators.setFirstOperator(new BigDecimal(1));
		operators.setSecondOperator(new BigDecimal(3));
		
		BigDecimal resta = calculatorService.getSubstract(operators);
		assertEquals(resta, new BigDecimal(-2));
	}
	
	@Test
	void TestGetSum() {
	
		Operators operators = new Operators();
		operators.setFirstOperator(new BigDecimal(1));
		operators.setSecondOperator(new BigDecimal(3));
		
		BigDecimal resta = calculatorService.getSum(operators);
		assertEquals(resta, new BigDecimal(4));
	}

}

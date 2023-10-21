package com.prueba.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.calculadora.model.Operators;
import com.prueba.calculadora.service.CalculatorService;

@SpringBootTest
public class TestCalculatorService {
	
	@Autowired
	private CalculatorService calculatorService;
	
	@Test
	public void TestGetSubstract() {
	
		Operators operators = new Operators();
		operators.setFirstOperator(new BigDecimal(1));
		operators.setSecondOperator(new BigDecimal(3));
		
		BigDecimal resta = calculatorService.getSubstract(operators);
		assertEquals(resta, new BigDecimal(-2));
	}
	
	@Test
	public void TestGetSum() {
	
		Operators operators = new Operators();
		operators.setFirstOperator(new BigDecimal(1));
		operators.setSecondOperator(new BigDecimal(3));
		
		BigDecimal resta = calculatorService.getSum(operators);
		assertEquals(resta, new BigDecimal(4));
	}

}

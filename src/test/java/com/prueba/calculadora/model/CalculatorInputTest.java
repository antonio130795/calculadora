package com.prueba.calculadora.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorInputTest {

	@Test
	void testCalculatorInputClass() {
		CalculatorInput calculatorInput = new CalculatorInput();
		calculatorInput.setFirstOperator(new BigDecimal(1));
		calculatorInput.setSecondOperator(new BigDecimal(2));
		calculatorInput.setOperation("+");
		
		assertEquals(new BigDecimal(1), calculatorInput.getFirstOperator());
		assertEquals(new BigDecimal(2), calculatorInput.getSecondOperator());
		assertEquals("+", calculatorInput.getOperation());
		
		CalculatorInput calculatorInput1 = new CalculatorInput();
		calculatorInput1.firstOperator(new BigDecimal(1));
		calculatorInput1.secondOperator(new BigDecimal(1));
		calculatorInput1.operation("+");

		
		
	}
	
	@Test
	void testToString() {
		
		CalculatorInput calculatorInput = new CalculatorInput();
		calculatorInput.setFirstOperator(new BigDecimal(1));
		calculatorInput.setSecondOperator(new BigDecimal(2));
		calculatorInput.setOperation("+");
		
		StringBuilder sb = new StringBuilder();
	    sb.append("class CalculatorInput {\n");
	    sb.append("    firstOperator: ").append(toIndentedString(new BigDecimal(1))).append("\n");
	    sb.append("    secondOperator: ").append(toIndentedString(new BigDecimal(2))).append("\n");
	    sb.append("    operation: ").append(toIndentedString("+")).append("\n");
	    sb.append("}");
	    
	    assertEquals(sb.toString(), calculatorInput.toString());
	    
	}
	
	@Test
	void testEquals() {
		
		CalculatorInput calculatorInput = new CalculatorInput();
		calculatorInput.setFirstOperator(new BigDecimal(1));
		calculatorInput.setSecondOperator(new BigDecimal(2));
		calculatorInput.setOperation("+");
		
		CalculatorInput calculatorInput1 = new CalculatorInput();
		calculatorInput1.setFirstOperator(new BigDecimal(1));
		calculatorInput1.setSecondOperator(new BigDecimal(2));
		calculatorInput1.setOperation("+");
	    
		assertTrue(calculatorInput.equals(calculatorInput1));
	    
	}
	
	
	  private String toIndentedString(Object o) {
		    if (o == null) {
		      return "null";
		    }
		    return o.toString().replace("\n", "\n    ");
		  }
}

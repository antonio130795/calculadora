package com.prueba.calculadora.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.prueba.calculadora.model.Operators;

public class OperatorsTest {

	@Test
	void testOperators() throws Exception {
		
		Operators operators = new Operators();
		Operators operators1 = new Operators();

		operators.firstOperator(new BigDecimal(1));
		operators.secondOperator(new BigDecimal(1));

		operators.setFirstOperator(new BigDecimal(1));
		operators.setSecondOperator(new BigDecimal(3));
		
		operators.getFirstOperator();
		operators.getSecondOperator();
		
		
		assertEquals(true,operators.equals(operators));
		assertEquals(false,operators.equals(operators1));
		assertEquals(2015,operators.hashCode());
		
		Operators operators2 = new Operators();
		StringBuilder sb = new StringBuilder();
	    sb.append("class Operators {\n");
	    sb.append("    firstOperator: ").append(toIndentedString(operators2.getFirstOperator())).append("\n");
	    sb.append("    secondOperator: ").append(toIndentedString(operators2.getSecondOperator())).append("\n");
	    sb.append("}");
		assertEquals(sb.toString(), operators2.toString());

		
		 
	}
	
	 String toIndentedString(Object o) {
		    if (o == null) {
		      return "null";
		    }
		    return o.toString().replace("\n", "\n    ");
		  }
}

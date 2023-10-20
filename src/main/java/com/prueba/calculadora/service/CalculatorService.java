package com.prueba.calculadora.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.prueba.calculadora.model.Operators;

@Component
public class CalculatorService {

	public BigDecimal getSubstract(Operators operators)  {
		
		BigDecimal resta = operators.getFirstOperator().subtract(operators.getSecondOperator());
		
        return resta;
    }
	
	
	public BigDecimal getSum(Operators operators)  {
		
		BigDecimal resta = operators.getFirstOperator().add(operators.getSecondOperator());
		
        return resta;
    }
}

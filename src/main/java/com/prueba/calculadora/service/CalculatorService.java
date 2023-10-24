package com.prueba.calculadora.service;

import org.springframework.stereotype.Component;

import com.prueba.calculadora.exceptions.ResourceNotFoundException;
import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;
import com.prueba.calculadora.operations.Subtraction;
import com.prueba.calculadora.operations.Sum;

@Component
public class CalculatorService {

	Sum sum = new Sum();
	Subtraction subtraction = new Subtraction();

	
	public Result performOperation(CalculatorInput calculatorInput) {
	
		checkBody(calculatorInput);
		return checkOperation(calculatorInput);
	}


	private Result checkOperation(CalculatorInput calculatorInput) {
		switch (calculatorInput.getOperation()) { 
	    case "+":
	    	return sum.calc(calculatorInput);
	    case "-":
	    	return subtraction.calc(calculatorInput);
	    default:
	     throw new ResourceNotFoundException("operation not available");	
	  }
	}


	private void checkBody(CalculatorInput calculatorInput) {
		if(calculatorInput.getFirstOperator() == null || calculatorInput.getSecondOperator() == null || calculatorInput.getOperation() == null) {
			throw new ResourceNotFoundException("json body malformed ");
		}
	}
	
}

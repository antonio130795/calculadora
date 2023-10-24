package com.prueba.calculadora.operations;

import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;

public class Sum implements OperationsI{


	@Override
	public Result calc(CalculatorInput calculatorInput) {
		result.setResult(calculatorInput.getFirstOperator().add(calculatorInput.getSecondOperator()));
		tracerBean.trace("Result of the sum " + result.getResult());
		return result;
	}

}

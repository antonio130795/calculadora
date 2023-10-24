package com.prueba.calculadora.operations;

import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;

public class Subtraction implements OperationsI{

	@Override
	public Result calc(CalculatorInput calculatorInput) {
		result.setResult(calculatorInput.getFirstOperator().subtract(calculatorInput.getSecondOperator()));
		tracerBean.trace("Result of the subtraction " + result.getResult());
        return result;
	}

}

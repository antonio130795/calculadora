package com.prueba.calculadora.operations;

import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;

import io.corp.calculator.TracerImpl;

public interface OperationsI {

	Result result = new Result();
	TracerImpl tracerBean = new TracerImpl();

	public Result calc(CalculatorInput calculatorInput); 
}
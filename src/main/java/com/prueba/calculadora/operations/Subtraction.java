package com.prueba.calculadora.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;

import io.corp.calculator.TracerImpl;

@Component
public class Subtraction implements OperationsI {
    @Autowired
    TracerImpl tracer;

    @Override
    public Result calc(CalculatorInput calculatorInput) {
       Result result = new Result();
       result.setResult(calculatorInput.getFirstOperator().subtract(calculatorInput.getSecondOperator()));
        tracer.trace("Result of the subtract " + result.getResult());
        return result;
    }
}
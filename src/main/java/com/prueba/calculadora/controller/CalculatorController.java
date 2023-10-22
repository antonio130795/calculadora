package com.prueba.calculadora.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.OperationsApi;
import com.prueba.calculadora.exceptions.ResourceNotFoundException;
import com.prueba.calculadora.model.Operators;
import com.prueba.calculadora.service.CalculatorService;

import io.corp.calculator.TracerImpl;

@ControllerAdvice
@RestController
@RequestMapping
public class CalculatorController implements OperationsApi {
	
	CalculatorService calculatorService = new CalculatorService();
	
	TracerImpl tracerBean = new TracerImpl();

	
	@Override
	public ResponseEntity<BigDecimal> subtraction(Operators operators) {
		
		if(operators.getFirstOperator() == null || operators.getSecondOperator() == null) {
			throw new ResourceNotFoundException("One json attribute not correct");
		}
		
		BigDecimal result = calculatorService.getSubstract(operators);
		ResponseEntity<BigDecimal> respuesta = new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
		tracerBean.trace("Result of the subtraction " + respuesta);

		return respuesta;
	}
	
	@Override
	public ResponseEntity<BigDecimal> sum(Operators operators ) {
		
		if(operators.getFirstOperator() == null || operators.getSecondOperator() == null) {
			throw new ResourceNotFoundException("One json attribute not correct");
		}
		BigDecimal result = calculatorService.getSum(operators);
		ResponseEntity<BigDecimal> respuesta = new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
		tracerBean.trace("Result of the sum " + respuesta);

		return respuesta;
	}
}

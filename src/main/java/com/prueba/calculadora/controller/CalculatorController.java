package com.prueba.calculadora.controller;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.OperationsApi;
import com.prueba.calculadora.model.Operators;
import com.prueba.calculadora.service.CalculatorService;

@RestController
public class CalculatorController implements OperationsApi {
	
	CalculatorService calculatorService = new CalculatorService();
	
	@Override
	public ResponseEntity<BigDecimal> subtraction(Operators operators) {
		
		BigDecimal result = calculatorService.getSubstract(operators);
		ResponseEntity<BigDecimal> respuesta = new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
    	
		return respuesta;
	}
	
	@Override
	public ResponseEntity<BigDecimal> sum(Operators operators ) {
		
		BigDecimal result = calculatorService.getSum(operators);
		ResponseEntity<BigDecimal> respuesta = new ResponseEntity<BigDecimal>(result, HttpStatus.OK);
    	
		return respuesta;
	}
}

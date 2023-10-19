package com.prueba.calculadora.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.OperationsApi;
import com.prueba.calculadora.model.Operators;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CalculatorController implements OperationsApi {
	
	@Override
	public ResponseEntity<BigDecimal> subtraction(@Parameter(name = "Operators", description = "Two numbers to add", required = true) @Valid @RequestBody Operators operators) {
		
		BigDecimal resta = operators.getFirstOperator().subtract(operators.getSecondOperator());
		ResponseEntity<BigDecimal> respuesta = new ResponseEntity<BigDecimal>(resta, HttpStatus.OK);
    	
		return respuesta;
	}
	
	@Override
	public ResponseEntity<BigDecimal> sum(Operators operators ) {
		
		BigDecimal resta = operators.getFirstOperator().add(operators.getSecondOperator());
		ResponseEntity<BigDecimal> respuesta = new ResponseEntity<BigDecimal>(resta, HttpStatus.OK);

		return respuesta;
	}
}

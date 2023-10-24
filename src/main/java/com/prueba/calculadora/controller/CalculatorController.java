package com.prueba.calculadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.CalculatorApi;
import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;
import com.prueba.calculadora.service.CalculatorService;

import io.corp.calculator.TracerImpl;

@ControllerAdvice
@RestController
@RequestMapping
public class CalculatorController implements CalculatorApi {
	
	CalculatorService calculatorService = new CalculatorService();
	
	TracerImpl tracerBean = new TracerImpl();

	
	@Override
	public ResponseEntity<Result> calculator(CalculatorInput calculatorInput) {
		
		return new ResponseEntity<Result>(calculatorService.performOperation(calculatorInput), HttpStatus.OK);
	}
}

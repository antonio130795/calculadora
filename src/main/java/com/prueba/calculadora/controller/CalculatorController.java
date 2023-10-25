package com.prueba.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.calculadora.CalculatorApi;
import com.prueba.calculadora.model.AvailableOperations;
import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;
import com.prueba.calculadora.service.CalculatorService;

@ControllerAdvice
@RestController
@RequestMapping
public class CalculatorController implements CalculatorApi {
	
    @Autowired
    CalculatorService calculatorService;
    
	@Override
	public ResponseEntity<Result> calculator(CalculatorInput calculatorInput) {
		
		return ResponseEntity.ok(calculatorService.performOperation(calculatorInput));
	}

	@Override
	public ResponseEntity<AvailableOperations> operations() {
		
		return ResponseEntity.ok(calculatorService.getAvaliableOperations());
	}

}

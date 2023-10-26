package com.prueba.calculadora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.calculadora.exceptions.ResourceNotFoundException;
import com.prueba.calculadora.model.AvailableOperations;
import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;
import com.prueba.calculadora.operations.OperationsI;

import io.corp.calculator.TracerImpl;

@Service
public class CalculatorService {
	
	@Autowired
	Map<String, OperationsI> operations;
	
	
    @Autowired
    TracerImpl tracer;
	
	public Result performOperation(CalculatorInput calculatorInput) {
        checkBody(calculatorInput);
        return operations.get(calculatorInput.getOperation()).calc(calculatorInput);
    }
	
	public AvailableOperations getAvaliableOperations() {
        return listOfOperations();
    }

	private AvailableOperations listOfOperations() {
		List<String> operationsList = new ArrayList<String>();
		AvailableOperations availableOperations = new AvailableOperations();
		operationsList.addAll(operations.keySet());
		availableOperations.setAvailableOperations(operationsList);
		tracer.trace(availableOperations.toString());
		return availableOperations;
	}

    private void checkBody(CalculatorInput calculatorInput) {
        if (calculatorInput.getFirstOperator() == null || calculatorInput.getSecondOperator() == null || calculatorInput.getOperation() == null) {
            throw new ResourceNotFoundException("json body malformed ");
        }

        if (!operations.containsKey(calculatorInput.getOperation())) {
            throw new ResourceNotFoundException("operation not available");
        }
    }
}

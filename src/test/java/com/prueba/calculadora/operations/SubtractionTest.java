package com.prueba.calculadora.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.calculadora.model.CalculatorInput;
import com.prueba.calculadora.model.Result;

import io.corp.calculator.TracerImpl;

@ExtendWith(MockitoExtension.class)
public class SubtractionTest {

    @InjectMocks
    private Subtraction subtraction;

    @Mock
    private TracerImpl tracer;
    
    private CalculatorInput calculatorInput;

    @BeforeEach
    void setUp() {
       calculatorInput = new CalculatorInput();
       calculatorInput.setFirstOperator(new BigDecimal(1));
       calculatorInput.setSecondOperator(new BigDecimal(2));
       calculatorInput.setOperation("SUBTRACTION");


    }
    
    @Test
    public void testSumCalc() {
        Result result = subtraction.calc(calculatorInput);
        assertEquals(new BigDecimal(-1), result.getResult());
    }
}

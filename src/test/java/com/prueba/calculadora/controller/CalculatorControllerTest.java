package com.prueba.calculadora.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.prueba.calculadora.service.CalculatorService;


@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {
		
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	CalculatorService calculatorService;
	
	@Mock
	CalculatorController calculatorController;
	
	@Test
	void testSubstraction() throws Exception {
		
		String requestBody = "{\"firstOperator\" : 1,\"secondOperator\" : 2,\"operation\" : \"-\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	
	@Test
	void testSum() throws Exception {

		String requestBody = "{\"firstOperator\" : 1,\"secondOperator\" : 2,\"operation\" : \"+\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
}

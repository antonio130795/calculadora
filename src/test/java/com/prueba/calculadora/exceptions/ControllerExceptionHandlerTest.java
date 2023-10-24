package com.prueba.calculadora.exceptions;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.prueba.calculadora.controller.CalculatorController;
import com.prueba.calculadora.service.CalculatorService;

@WebMvcTest(CalculatorController.class)
public class ControllerExceptionHandlerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	CalculatorService calculatorService;
	
	@Mock
	CalculatorController calculatorController;
	
	@Test
	void testSubstractionException() throws Exception {

		String requestBody = "{\"firstOperator\" : 1,\"SecodOperator\" : 2,\"operation\" : \"-\"}}";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isNotFound());

	}
	
	@Test
	void testException400() throws Exception {

		String requestBody = "{\"firstOperator\" : \"a\",\"SecondOperator\" : 2,\"operation\" : \"-\"}}";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());

	}
	
	@Test
	void testException500() throws Exception {

		String requestBody = "{\"firstOperator\" : \"a\",\"SecondOperator\" : 2,\"operation\" : \"-\"}}";
		mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_ATOM_XML)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isInternalServerError());

	}
	
	@Test
	void testException415() throws Exception {

		String requestBody = "{\"firstOperator\" : \"a\",\"SecondOperator\" : 2,\"operation\" : \"-\"}}";
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/calculator")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());

	}
}

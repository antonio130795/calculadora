package com.prueba.calculadora.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ResultTest {

	@Test
	void testResultClass() {
		Result result = new Result();
		result.setResult(new BigDecimal(1));
		
		assertEquals(new BigDecimal(1), result.getResult());
		
	}
	
	@Test
	void testToString() {
		
		Result result = new Result();
		result.setResult(new BigDecimal(1));
		
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Result {\n");
	    sb.append("    result: ").append(toIndentedString(new BigDecimal(1))).append("\n");
	    sb.append("}");
	    
	    assertEquals(sb.toString(), result.toString());
	    
	}
	
	
	@Test
	void testEquals() {
		
		Result result = new Result();
		result.setResult(new BigDecimal(1));
		
		Result result1 = new Result();
		result1.setResult(new BigDecimal(1));
	    
		assertTrue(result.equals(result1));
	    
	}
	
	
	  private String toIndentedString(Object o) {
		    if (o == null) {
		      return "null";
		    }
		    return o.toString().replace("\n", "\n    ");
		  }
	  
}


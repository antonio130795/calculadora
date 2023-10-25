package com.prueba.calculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class TracerConfiguration {
	
    @Bean
    public TracerImpl getTracerImpl() {
        return new TracerImpl();
    }
}

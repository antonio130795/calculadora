# calculadora
Prueba técnica, servicio API calculadora

Se ha añadido en el pom la dependencia de forma que en una instalacion limpia aplique el jar correctamente:

		<dependency>
		    <groupId>io.corp.calculator</groupId>
		    <artifactId>tracer</artifactId>
		    <version>1.0.0</version>
		</dependency>

Estructura del proyecto:

	Se ha dividido el proyecto en diferentes paquetes:
		- Config: Implementacion de la libreria tracer
		- Controller: Aqui se encuentra la implementacion del controlador generado por openApi
		- Exceptions: Aqui se encuentra lo relacionado al control de las excepciones generadas en el proyecto
		- Operations: Interfaz e implementaciones de la misma, siendo esta las operaciones disponibles en el proyecto
		- Service: Lógica de la aplicacion
		
	
Se han utilizado las depencencias de Spring Boot y javax asociadas al concepto de OpenApi.
La libreria Tracer proporcionada en la prueba para la implementación de una serie de trazas usadas para ver tanto el resultado como las excepciones que ocurren en el proyecto

Se han implementado las funcionalidades de suma y resta con dos operandos.

Proyecto realizado en Java 17
Spring boot version 3.1.4

Lanzar el proyecto:

	mvn validate (para instalar la librería, solamente es necesario ejecutarlo la primera vez)
	
	mvn clean install (para realizar la compilación limpia)
	
	mvn spring-boot:run (para ejecutar el proyecto)

En la ruta resources hay una colección de Postman con los casos de uso tratados y las excepciones controladas 

Ejemplos de endpoint de suma y resta:

POST: http://localhost:8080/calculator

Suma:

	{
	    "firstOperator": 1.234,
	    "secondOperator": 2,
	    "operation": "SUM"
	}
Resta:

	{
	    "firstOperator": 1.234,
	    "secondOperator": 2,
	    "operation": "SUBTRACT"
	}
	
GET: http://localhost:8080/calculator/availableOperations

Algunos casos de error controlados:

POST: http://localhost:8080/calculator --> Body malformed

	{
	    "firstOperator": 1.234,
	    "SecondOpertor": 2
	}



POST: http://localhost:8080/calculator --> Operation not available

	{
	    "firstOperator": 1.234,
	    "secondOperator": 1.2,  
	    "operation": 1
	}


# calculadora
Prueba técnica, servicio API calculadora

Comando usado para la instalacción de la libreria tracer:

install:install-file -Dfile=${project.basedir}/src/main/resources/lib/tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar

Se ha añadido en el pom la dependencia de forma que en una instalacion limpia aplique el jar correctamente:

		<dependency>
		    <groupId>io.corp.calculator</groupId>
		    <artifactId>tracer</artifactId>
		    <version>1.0.0</version>
		    <scope>system</scope>
            <systemPath>${project.basedir}/src/main/resources/lib/tracer-1.0.0.jar</systemPath>
		</dependency>

Estructura del proyecto:

	Se ha dividido el proyecto en diferentes paquetes:
		- Controller: Aqui se encuentra la implementacion del controlador generado por openApi
		- Exceptions: Aqui se encuentra lo relacionado al control de las excepciones generadas en el proyecto
		- Operations: Interfaz e implementaciones de la misma, siendo esta las operaciones disponibles en el proyecto
		- Service: Lógica de la aplicacion
		
	
Se han utilizado las depencencias de Spring Boot y javax asociadas al concepto de OpenApi.
La libreria Tracer proporcionada en la prueba para la implementación de una serie de trazas usadas para ver tanto el resultado como las excepciones que ocurren en el proyecto

Se han implementado las funcionalidades de suma y resta con dos operandos.

Proyecto realizado en Java 17
Spring boot version 3.1.4

Realizar maven clean install
Posteriormente ejecutar como Spring Boot App

En la ruta resources hay una colección de Postman con los casos de uso tratados y las excepciones controladas 

Ejemplos de endpoint de suma y resta:

POST: http://localhost:8080/calculator

Suma:

	{
	    "firstOperator": 1.234,
	    "secondOperator": 2,
	    "operation": "+"
	}
Resta:

	{
	    "firstOperator": 1.234,
	    "secondOperator": 2,
	    "operation": "-"
	}
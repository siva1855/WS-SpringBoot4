package siva.bootexception.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import siva.bootexception.exception.EmployeeNotFoundException;
import siva.bootexception.exceptionbean.ExceptionType;

@RestControllerAdvice
public class MyCustomExceptionHandler {

	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionType> handlerEmployeeNotFoundException(EmployeeNotFoundException ex) {
		return new ResponseEntity<ExceptionType>(new ExceptionType(
				LocalDateTime.now(),
				"No Employee Found",
				"Data Not Found Given ID",
				ex.getMessage(),
				"Employee"),
				HttpStatus.BAD_REQUEST);
	}

}

package com.padhu.rest.webservices.restfulwebservice.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.padhu.rest.webservices.restfulwebservice.user.UserNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetail=new ErrorDetails(LocalDate.now(),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetail,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetail=new ErrorDetails(LocalDate.now(),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ErrorDetails>(errorDetail,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetails errorDetail=new ErrorDetails(LocalDate.now(),
				ex.getFieldError().getDefaultMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetail,HttpStatus.NOT_FOUND);
	}
}

package com.cg.dryclean.advice;
import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.cg.dryclean.exception.AddressNotFoundException;
import com.cg.dryclean.exception.AuthenticationFailureException;
import com.cg.dryclean.exception.EmptyInputException;
import com.cg.dryclean.exception.OrderLineItemNotFoundException;
import com.cg.dryclean.exception.OrderNotFoundException;
import com.cg.dryclean.exception.UserNotFoundException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
	
	//Pre-defined exception
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException elementException)
	{
		return new  ResponseEntity<String>("No such value is present in DB, Please change your request",HttpStatus.BAD_REQUEST);
	}
	
	//Pre-defined exception
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException elementException)
	{
		return new  ResponseEntity<String>("No such value is present in DB, Please change your request",HttpStatus.BAD_REQUEST);
	}
	
	//Pre-defined exception
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		return new  ResponseEntity<Object>("400:BAD_REQUEST:Please change the Http method type",HttpStatus.BAD_REQUEST);
	}

	//User-defined exception  
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<String> handleAddressNotFoundException(AddressNotFoundException elementException)
	{
		return new  ResponseEntity<String>("Address is not present in the database",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException elementException)
	{
		return new  ResponseEntity<String>("User is not present in the database",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(OrderNotFoundException elementException)
	{
		return new  ResponseEntity<String>("Order is not present in the database",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
	@ExceptionHandler(OrderLineItemNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(OrderLineItemNotFoundException elementException)
	{
		return new  ResponseEntity<String>("OrderLineItem is not present in the database",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException elementException)
	{
		return new  ResponseEntity<String>("Input field is empty, Please look into it",HttpStatus.BAD_REQUEST);
	}
	
	//User-defined exception 
		@ExceptionHandler(AuthenticationFailureException.class)
		public ResponseEntity<String> handleAuthenticationFailureException(AuthenticationFailureException elementException)
		{
			return new  ResponseEntity<String>("Wrong Password. Try again.",HttpStatus.BAD_REQUEST);
		}
	
}
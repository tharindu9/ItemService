package com.foodcourt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ItemException.class)
	public final ResponseEntity<ErrorMassage> itemNotFound(ItemException ex ,
			WebRequest request){
		ErrorMassage errMsg =
				new ErrorMassage(ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
	
	}
	
	
	
	@ExceptionHandler(CategoryException.class)
	public final ResponseEntity<ErrorMassage> categoryNotFound(CategoryException ex ,
			WebRequest request){
		ErrorMassage errMsg =
				new ErrorMassage(ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity<>(errMsg, HttpStatus.NOT_FOUND);
	
	}
	
	
	
	
	
	
	

}

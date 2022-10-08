package com.Bookmark.Excep;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

   @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex){
	   
	   String message = ex.getMessage();
	   
		return new ResponseEntity<>( message, HttpStatus.NOT_FOUND);
		
	}
   
  
   
   @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> argumentTypeMismatch(MethodArgumentNotValidException ex){
	   
	   HashMap<String ,String> map = new HashMap<>();
	   
	   ex.getBindingResult().getAllErrors().forEach((error) ->{
		   String fieldName = ((FieldError)error).getField();
		   String message = error.getDefaultMessage();
		   map.put(fieldName, message);
	   });
	   String message = ex.getMessage();
	   
		return new ResponseEntity<>( map, HttpStatus.NOT_FOUND);
		
	}
   

   @ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex){
	  String message = "";
	   if (ex.getMessage().contains("link")) {
		    message = "Bookmark link";
	   }
	   if (ex.getMessage().contains("tittle")) {
		    message = "Tag Tittle";
	   }
	 
		return new ResponseEntity<>(message  + " is a mandatory parameter.", HttpStatus.NOT_FOUND);
		
	}
   @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  	public ResponseEntity<?> resourceNotFound(SQLIntegrityConstraintViolationException ex){
  	   
  	   String message = ex.getMessage();
  	   
  	   
  		return new ResponseEntity<>( message, HttpStatus.NOT_FOUND);
   }
  	
}

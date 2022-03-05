package com.avalicao3.states.apirest.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.avalicao3.states.apirest.services.exception.ObjNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler(ObjNotFoundException.class)
	public ResponseEntity<StandardError> objNotFound(ObjNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), 
			"Não encontrado" , e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}

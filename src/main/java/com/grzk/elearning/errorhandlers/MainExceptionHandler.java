package com.grzk.elearning.errorhandlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

@ControllerAdvice
public class MainExceptionHandler {

	@ResponseStatus(value=HttpStatus.CONFLICT)
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody 
	public ValidationErrorMessage conflict(HttpServletRequest req,DataIntegrityViolationException ex){
		ValidationErrorMessage errorMessage = new ValidationErrorMessage();
		errorMessage.setStatus(HttpStatus.CONFLICT);
		errorMessage.setTitle("Data integrity violation");
		return errorMessage;
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseBody
	public ErrorMessage userNotFound(HttpServletRequest req, UsernameNotFoundException ex){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatus(HttpStatus.NOT_FOUND);
		errorMessage.setTitle("Incorrect username or password");
		errorMessage.setDetail(errorMessage.getTitle());
		return errorMessage;
	}
	
}

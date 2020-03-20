package com.poc.SpringBootRestExample.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public final UserNotFoundException userNotFoundException(final UserNotFoundException ex) {
		UserNotFoundException error = new UserNotFoundException(ex.getId(),ex.getMsg());
		return error;
	}
	
	@ExceptionHandler(AlphaNumericsException.class)
	public final AlphaNumericsException alphaNumericsException(AlphaNumericsException ex) {
		AlphaNumericsException error = new AlphaNumericsException(ex.getId(), ex.getMsg());
		return error;
	}

}

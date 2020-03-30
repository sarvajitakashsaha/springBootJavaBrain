package com.example.springboot.topic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
//	@ExceptionHandler(DataNotFoundException.class)
//	 @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
//	public @ResponseBody ErrorMessage handleResourceNotFound(final DataNotFoundException exception,
//			final HttpServletRequest request) {
//
//		ErrorMessage error = new ErrorMessage();
//		error.setErrorMessage(exception.getMessage());
//		error.callerURL(request.getRequestURI());
//
//		return error;
//	}
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
	@ResponseBody
	public ErrorMessage dataNotFound(final DataNotFoundException exception,final HttpServletRequest request) {
			ErrorMessage error = new ErrorMessage();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());
			
			return error;
	}
	
	@ExceptionHandler(DataAlreadyPresentException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorMessage dataAlreadyPresent(final DataAlreadyPresentException exception ,final HttpServletRequest request) {
		ErrorMessage message = new ErrorMessage();
		message.setErrorMessage(exception.getMessage());
		message.callerURL(request.getRequestURI());
		return message;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorMessage handleException(final Exception exception,
			final HttpServletRequest request) {

		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}
}

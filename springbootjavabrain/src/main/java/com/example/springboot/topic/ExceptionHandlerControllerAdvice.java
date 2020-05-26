package com.example.springboot.topic;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler {
	
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
	
	
	@ExceptionHandler(InvalidHeaderFieldException.class)
	@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
	@ResponseBody
	public ErrorMessage handleInvalidHeaderException(final InvalidHeaderFieldException exception ,final HttpServletRequest request) {
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

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ErrorMessage error = new ErrorMessage();
		error.setErrorMessage("not valid");	
		error.callerURL(request.getDescription(true));

		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
}

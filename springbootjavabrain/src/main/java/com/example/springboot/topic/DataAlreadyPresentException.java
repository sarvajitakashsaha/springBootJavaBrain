package com.example.springboot.topic;

public class DataAlreadyPresentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2694343169951506287L;
	public DataAlreadyPresentException(String msg) {
		super(msg);
	}
	public DataAlreadyPresentException() {
		super();
	}

}

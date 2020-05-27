package com.example.springboot.topic;

public class InvalidHeaderFieldException extends Exception {
private static final long serialVersionUID = 1L;
	
	public InvalidHeaderFieldException(String msg) {
		super(msg);
	}
}

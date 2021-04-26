package com.neo.exceptions;

public class InvalidSymbolException extends RuntimeException {
	
	private static final long serialVersionUID = 5246904375905699313L;

	public InvalidSymbolException(String message) {
		super(message);
	}
	
	public InvalidSymbolException(String message, Throwable error) {
		super(message, error);
	}
	
}


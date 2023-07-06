package com.app.delivery.api.exceptionhandler;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NegocioException(String cause) {
		super(cause);
	}
	
}

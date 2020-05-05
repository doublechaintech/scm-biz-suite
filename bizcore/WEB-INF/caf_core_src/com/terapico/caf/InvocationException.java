package com.terapico.caf;

public class InvocationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvocationException(Exception e) {
		super(e);
	}

	public InvocationException(String string) {
		super(string);
	}

}

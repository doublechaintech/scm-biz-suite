package com.terapico.caf;

public interface InvocationContextFactory {
	InvocationContext create(Object context) throws InvocationException;
}

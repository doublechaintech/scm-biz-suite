package com.terapico.caf;

public interface InvocationTool {
	public InvocationResult invoke(InvocationContext context) throws InvocationException;
}

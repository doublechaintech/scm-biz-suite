package com.terapico.caf;

import java.lang.reflect.Method;

public interface InvocationContext {
	public Object getTargetObject();
	public Method getMethodToCall();
	public Object [] getParameters();
}

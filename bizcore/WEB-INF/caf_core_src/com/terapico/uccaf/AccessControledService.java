package com.terapico.uccaf;

public interface AccessControledService {
	public Object checkAccess(BaseUserContext userContext,String methodName, Object[] parameters) throws Exception;
	public void enforceAccess(BaseUserContext userContext, Object targetObject) throws Exception;

	default public void onAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters) {}
	default public void afterInvoke(BaseUserContext baseUserContext, String methodName, Object[] parameters, boolean success, Object result, Throwable throwable) {}

}




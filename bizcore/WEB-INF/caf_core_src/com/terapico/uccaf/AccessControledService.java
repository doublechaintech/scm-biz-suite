package com.terapico.uccaf;

public interface AccessControledService {
	public Object checkAccess(BaseUserContext userContext,String methodName, Object[] parameters) throws Exception;
	public void enforceAccess(BaseUserContext userContext, Object targetObject) throws Exception;

	public void onAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters);
}




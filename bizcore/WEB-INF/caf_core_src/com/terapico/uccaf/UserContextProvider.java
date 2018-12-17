package com.terapico.uccaf;

import javax.servlet.http.HttpServletRequest;

public interface UserContextProvider {
	public BaseUserContext loadUserConext(HttpServletRequest request) throws Exception;

	public void saveUserContext(BaseUserContext uc)throws Exception;
}


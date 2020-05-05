package com.doublechaintech.retailscm.iamservice;

public class LoginResult {
	protected boolean authenticated;
	protected LoginContext loginContext;
	protected boolean success;
	protected boolean newUser;
	protected String message;
	
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	public LoginContext getLoginContext() {
		return loginContext;
	}
	public void setLoginContext(LoginContext loginContext) {
		this.loginContext = loginContext;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public boolean hasSecUser() {
		if (loginContext.getLoginTarget() == null || loginContext.getLoginTarget().getSecUser() == null) {
			return false;
		}
		return true;
	}
	
	public LoginResult withError(String message) {
		this.setMessage(message);
		this.setSuccess(false);
		this.setAuthenticated(false);
		return this;
	}
	
	public void success(String message) {
		this.setMessage(message);
		this.setSuccess(true);
	}
	
	public LoginResult authenticated(String message) {
		this.setMessage(message);
		this.setAuthenticated(true);
		return this;
	}
	public boolean isNewUser() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

















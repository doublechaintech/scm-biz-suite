package com.terapico.caf;

public class Password implements SecureLoggingParameter{
	private String clearTextPassword;
	public Password(String clearTextPassword) {
		this.clearTextPassword = clearTextPassword;
	}
	public String getClearTextPassword() {
		return clearTextPassword;
	}
	
	@Override
	public Object getValue() {
		return clearTextPassword;
	}
	
	@Override
	public String toLoggingString() {
		if(clearTextPassword==null) {
			return "null password";
		}
		int length = clearTextPassword.length();
		return "**** pass len "+length+" ***";
		//return clearTextPassword.substring(0, 1)+"*******"+clearTextPassword.substring(length-1, length);
	}
	
}

package com.terapico.caf.baseelement;

public class RedirectTarget{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String redirectUrl;

	public RedirectTarget(String url) {
	    redirectUrl = url;
	}

	public RedirectTarget() {
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	
	
}

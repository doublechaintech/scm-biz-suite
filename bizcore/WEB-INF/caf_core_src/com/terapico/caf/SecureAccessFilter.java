package com.terapico.caf;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
//response.getWriter().print("need to authentication first");
//HttpServletResponse  httpRespoinse=(HttpServletResponse)response;
//HttpServletRequest  httpRespoinse=(HttpServletRequest)request;
public class SecureAccessFilter implements Filter {
	
	AuthencationService service;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		
		//HttpServletResponse  httpResponse=(HttpServletResponse)response;
		HttpServletRequest  httpRequest=(HttpServletRequest)request;
		
		

		

		if(isPublicResource(httpRequest)){
			chain.doFilter(request, response);
			return;
		}
		

		if(isLoginRequest(httpRequest)){
			
			String userId=httpRequest.getParameter(getAuthService().getUsernameParameterName());
			String password=httpRequest.getParameter(getAuthService().getPasswordParameterName());
			
			if(getAuthService().login(userId, password, httpRequest.getRequestedSessionId())){
				chain.doFilter(request, response);
				return;
			}
			
		}
		if(isLogoutRequest(httpRequest)){
			//logInfo("queryString： "+httpRequest.getQueryString());
			getAuthService().logout(httpRequest.getRequestedSessionId());
			request.setAttribute(ServletInvocationContextFactory.OVERRIDE_URI, "/naf/auth/loginForm/");
			
			chain.doFilter(request, response);
			return;
			//chain.doFilter(request, response);
			
		}

		if(isPublicResource(httpRequest)){
			chain.doFilter(request, response);
			return;
		}
		

		if(isAuthorizedResource(httpRequest)){
			chain.doFilter(request, response);
			return;
		}

		
		
		
		//logInfo(httpRequest.getRequestedSessionId());
		
		
		request.setAttribute(ServletInvocationContextFactory.OVERRIDE_URI, "/naf/auth/loginForm/");

		chain.doFilter(request, response);
		
	}

	private boolean isLoginRequest(HttpServletRequest httpRequest) {
		
		String value=httpRequest.getParameter(getAuthService().getInternalToken());

		return value!=null;
	}
	
	private boolean isLogoutRequest(HttpServletRequest httpRequest) {
		
		//String value=
		String queryString=httpRequest.getQueryString();
		if(queryString==null){
			return false;
		}
		logInfo("queryString： "+queryString);
		return queryString.contains(getAuthService().getLogoutToken());
	}

	private boolean isPublicResource(HttpServletRequest request) {
		
		return false;
	}

	private boolean isAuthorizedResource(HttpServletRequest request) {
		
		return getAuthService().authencated(request.getRequestedSessionId());
	}

	public void init(FilterConfig config) throws ServletException {
		
		
	}
	
	protected AuthencationService getAuthService() {
		
		if(service==null) service=new AuthencationService();
		return service;
	}
	
	protected void logInfo(Object message) {
		//log.log(Level.INFO, message);
		System.err.println("Filter: "+message);
	}

}

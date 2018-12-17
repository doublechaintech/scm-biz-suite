package com.terapico.caf;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terapico.uccaf.BaseUserContext;

public class SimpleInvocationResult implements InvocationResult {
	
	private InvocationContext invocationContext;
	private Object actualResult;
	public void setActualResult(Object actualResult) {
		this.actualResult=actualResult;
	}
	public void setInvocationContext(InvocationContext context) {
		this.invocationContext=context;
	}
	public InvocationContext getInvocationContext() {
		return invocationContext;
	}
	public Object getActualResult() {
		
		if(actualResult==null){
			return Boolean.TRUE;
		}
		
		return actualResult;
	}
	
	public Object getResultExpr() {
		return getObjectExpr(actualResult);
	}
	
	protected String getObjectExpr(Object target) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return "class: '" + target.getClass().getName() + "'\r\n" + mapper.writeValueAsString(target);
		} catch (Throwable e) {
			return e.getMessage();
		}
	}
	@Override
	public boolean isAssignedRenderingWay() {
		return getAssignedRenderingWay() != null;
	}
	
	private String getAssignedRenderingWay() {
		InvocationContext invokeCtx = getInvocationContext();
		if (invokeCtx == null){
			return null;
		}
		Object[] params = invokeCtx.getParameters();
		if (params == null || params.length < 1){
			return null;
		}
		if (!(params[0] instanceof BaseUserContext)){
			return null;
		}
		BaseUserContext usrCtx = (BaseUserContext) params[0];
		return usrCtx.getAssignedRederingWay();
	}
	@Override
	public Map<String, String> getResponseHeader() {
		InvocationContext invokeCtx = getInvocationContext();
		if (invokeCtx == null){
			return null;
		}
		Object[] params = invokeCtx.getParameters();
		if (params == null || params.length < 1){
			return null;
		}
		if (!(params[0] instanceof BaseUserContext)){
			return null;
		}
		BaseUserContext usrCtx = (BaseUserContext) params[0];
		return usrCtx.getResponseHeaders();
	}
	@Override
	public boolean isRenderAsHtml() {
		return InvocationResult.RENDER_AS_HTML.equals(getAssignedRenderingWay());
	}
	@Override
	public boolean isRenderAsJavaScript() {
		return InvocationResult.RENDER_AS_JAVASCRIPT.equals(getAssignedRenderingWay());
	}
	@Override
	public boolean isRenderAsJSON() {
		return InvocationResult.RENDER_AS_JSON.equals(getAssignedRenderingWay());
	}
	

}

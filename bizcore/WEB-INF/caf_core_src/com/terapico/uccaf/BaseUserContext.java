package com.terapico.uccaf;

import java.util.Map;

public interface BaseUserContext {
	public void assignRenderingWay(String renderingWay);
	public void forceRenderingAsJson();
	public void forceRenderingAsHtml();
	public void forceRenderingAsJavaScript();
	public String getAssignedRederingWay();
	public Map<String, Object> getRequestParameters();
	public byte[] getRequestBody();
	public boolean isProductEnvironment();
	public String getEnvironmentName();
	public Map<String, String> getResponseHeaders();
}

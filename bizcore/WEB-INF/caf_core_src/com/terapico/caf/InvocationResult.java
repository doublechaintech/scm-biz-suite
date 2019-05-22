package com.terapico.caf;

import java.util.Map;

public interface InvocationResult {
	public static final String RENDER_AS_HTML = "html";
	public static final String RENDER_AS_JAVASCRIPT = "javascript";
	public static final String RENDER_AS_JSON = "json";
	public static final String RENDER_AS_DEFAULT = "default";
	
	public void setActualResult(Object actualResult);

	public void setInvocationContext(InvocationContext context);
	public InvocationContext getInvocationContext();

	public Object getActualResult();

	public boolean isAssignedRenderingWay();
	public boolean isRenderAsHtml();
	public boolean isRenderAsJavaScript();
	public boolean isRenderAsJSON();

	public Map<String, String> getResponseHeader();
	public String getEnvName();
	public String getEnvType();
	
}

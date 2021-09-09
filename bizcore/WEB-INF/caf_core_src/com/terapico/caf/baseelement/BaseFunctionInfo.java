package com.terapico.caf.baseelement;

import java.util.LinkedHashMap;
import java.util.Map;

public class BaseFunctionInfo {
	protected String title;
	protected String type = "simple";
	protected Map<String, ParamInfo> params = new LinkedHashMap<>();
	protected String curParamName;
	protected String curParamLabel;
	protected String curParamType;
	protected String invokeUrl;
	protected ParamInfo curParam;
	
	
	public String getInvokeUrl() {
		return invokeUrl;
	}
	public void setInvokeUrl(String invokeUrl) {
		this.invokeUrl = invokeUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, ParamInfo> getParams() {
		return params;
	}
	public void setParams(Map<String, ParamInfo> params) {
		this.params = params;
	}
	
	
	public void setParamName(String paramName) {
		this.curParamName = paramName;
		refreshIntoParams();
	}
	
	private void refreshIntoParams() {
		if (curParamName == null || curParamLabel == null) {
			return;
		}
		ParamInfo info = new ParamInfo();
		info.setTitle(curParamLabel);
		if (curParamType != null) {
			info.setType(curParamType);
		}
		params.put(curParamName, info);
		curParam = info;
		curParamName = null;
		curParamLabel = null;
	}
	public void setParamLabel(String label) {
		this.curParamLabel = label;
		refreshIntoParams();
	}
	
	public void done() {
		// TODO Auto-generated method stub
		
	}
	public void setCandidateValueToCurrentParam(String key, String value) {
		curParam.addCandidate(key, value);
	}
}

package com.terapico.caf.baseelement;


import java.util.ArrayList;
import java.util.List;

/**
 * 支持 simpleFunction 和 FormFunction
 */
public class LabFunctionIndex {
	protected String curUser;
	protected String callbackUrl;
	protected String sendVCodeUrl;
	protected BaseFunctionInfo curFunction;
	protected List<BaseFunctionInfo> functions = new ArrayList<>();
	
	public List<BaseFunctionInfo> getFunctions() {
		return functions;
	}

	public void setFunctions(List<BaseFunctionInfo> functions) {
		this.functions = functions;
	}

	public String getSendVCodeUrl() {
		return sendVCodeUrl;
	}

	public void setSendVCodeUrl(String sendVCodeUrl) {
		this.sendVCodeUrl = sendVCodeUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	

	public String getCurUser() {
		return curUser;
	}

	public void setCurUser(String curUser) {
		this.curUser = curUser;
	}

	/**
	 * 构建一个简单功能,使用GET方法传递参数, 在 invoke()的时候,用:name的方式填好对应参数位置
	 * @param title
	 * @return
	 */
	public LabFunctionIndex addSimpleFunction(String title) {
		curFunction = new SimpleFunctionInfo();
		curFunction.setTitle(title);
		functions.add(curFunction);
		return this;
	}

	/**
	 * 构建一个 Form 提交的功能. 使用 POST 提交方法,参数从userContext里拿
	 * @param title
	 * @return
	 */
	public LabFunctionIndex addForm(String title) {
		curFunction = new FormFunction();
		curFunction.setTitle(title);
		functions.add(curFunction);
		return this;
	}

	public LabFunctionIndex with_input(String paramName) {
		curFunction.setParamName(paramName);
		return this;
	}
	public LabFunctionIndex with_file(String paramName) {
		if (!curFunction.getType().equals("form")) {
			throw new RuntimeException("file 只能在 addForm()时使用");
		}
		curFunction.curParamType = "file";
		curFunction.setParamName(paramName);
		return this;
	}

	public LabFunctionIndex label_as(String label) {
		curFunction.setParamLabel(label);
		return this;
	}

	public LabFunctionIndex invoke(String string) {
		curFunction.setInvokeUrl(string);
		return this;
	}

	public LabFunctionIndex done() {
		curFunction.done();
		return this;
	}

	public LabFunctionIndex select_from(String ... KVList) {
		for (String kvPaire : KVList) {
			int pos = kvPaire.indexOf(':');
			String key,value;
			if (pos < 0) {
				key = kvPaire;
				value = kvPaire;
			}else {
				key = kvPaire.substring(0,pos);
				value = kvPaire.substring(pos+1);
			}
			curFunction.setCandidateValueToCurrentParam(key, value);
		}
		return this;
	}
 }

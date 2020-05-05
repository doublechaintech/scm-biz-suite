package com.doublechaintech.retailscm.iamservice;

import java.util.HashMap;
import java.util.Map;

public class LoginData {
	protected static final String MOBILE = "mobile";
	protected static final String VCODE = "verify_code";
	protected static final String LOGIN_ID = "login_id";
	protected static final String EMAIL = "email";
	protected static final String PASSWORD = "password";
	protected static final String TOKEN = "token";
	protected static final String SECURITY_ID = "security_id";
	protected static final String CODE = "code";
	protected static final String APP_ID = "app_id";
	protected static final String OPEN_ID = "open_id";
	
	protected Map<String, Object> datas;
	protected void ensureDatas() {
		if (datas == null) {
			datas = new HashMap<>();
		}
	}
	protected Object getData(String key) {
		ensureDatas();
		return datas.get(key);
	}
	protected void setData(String key, Object value) {
		ensureDatas();
		datas.put(key, value);
	}
	

	public String getMobile() {
		return (String) getData(MOBILE);
	}
	
	public void setMobile(String mobile) {
		setData(MOBILE, mobile);
	}
	public String getVerifyCode() {
		return (String) getData(VCODE);
	}
	public void setVerifyCode(String verifyCode) {
		setData(VCODE, verifyCode);
	}
	public String getLoginId() {
		return (String) getData(LOGIN_ID);
	}
	public void setLoginId(String loginId) {
		setData(LOGIN_ID, loginId);
	}
	public String getEmail() {
		return (String) getData(EMAIL);
	}
	public void setEmail(String email) {
		setData(EMAIL, email);
	}
	public String getPassword() {
		return (String) getData(PASSWORD);
	}
	public void setPassword(String password) {
		setData(PASSWORD, password);
	}
	public String getToken() {
		return (String) getData(TOKEN);
	}
	public void setToken(String token) {
		setData(TOKEN, token);
	}
	public String getSecurityId() {
		return (String) getData(SECURITY_ID);
	}
	public void setSecurityId(String securityId) {
		setData(SECURITY_ID, securityId);
	}
	public String getCode() {
		return (String) getData(CODE);
	}
	public void setCode(String code) {
		setData(CODE, code);
	}
	public String getAppId() {
		return (String) getData(APP_ID);
	}
	public void setAppId(String appId) {
		setData(APP_ID, appId);
	}
	public String getOpenId() {
		return (String) getData(OPEN_ID);
	}
	public void setOpenId(String openId) {
		setData(OPEN_ID, openId);
	}
	
}

















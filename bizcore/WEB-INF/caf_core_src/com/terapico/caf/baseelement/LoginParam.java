package com.terapico.caf.baseelement;

import java.util.Map;

import com.terapico.caf.RemoteInitiable;
import com.terapico.utils.MapUtil;

public class LoginParam implements RemoteInitiable {
	public static final String MOBILE_VCODE = "mobile_vcode";
	public static final String WECHAT_APP = "wechat_app";
	public static final String WECHAT_WORK_APP = "wechat_work_app";
	public static final String ACCOUNT_PASSWORD = "account_password";
	
	String id;
	String login;
	String loginMethod;
	String code;
	String mobile;
	String verifyCode;
	String password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginMethod() {
		return loginMethod;
	}

	public void setLoginMethod(String loginMethod) {
		this.loginMethod = loginMethod;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public Map<String, Object> toMap() {
		return MapUtil.put("loginMethod", loginMethod)
				.putIf("id", id)
				.putIf("login", login)
				.putIf("code", code)
				.putIf("mobile", mobile)
				.putIf("verifyCode", verifyCode)
				.into_map();
	}

}

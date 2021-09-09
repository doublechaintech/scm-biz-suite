package com.terapico.caf.baseelement;

import java.util.Map;

import com.terapico.caf.RemoteInitiable;
import com.terapico.utils.MapUtil;

public class LoginParam implements RemoteInitiable {
	public static final String MOBILE_VCODE = "mobile_vcode";
	public static final String WECHAT_APP = "wechat_app";
	public static final String WECHAT_MOBILE = "wechat_mobile";
	public static final String WECHAT_WORK_APP = "wechat_work_app";
	public static final String ACCOUNT_PASSWORD = "account_password";
	
	String id;
	String login;
	String loginMethod;
	String code;
	String mobile;
	String verifyCode;
	String password;
	String encryptedData;
	String iv;
	boolean simulation = false;
	boolean forceAuthenSuccess = false;
	Object forceAuthenResult = null;
	Map<String, Object> extraData;
	
	
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

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public Map<String, Object> getExtraData() {
		return extraData;
	}

	public void setExtraData(Map<String, Object> extraData) {
		this.extraData = extraData;
	}

	public Map<String, Object> toMap() {
		return MapUtil.put("loginMethod", loginMethod)
				.putIf("id", id)
				.putIf("login", login)
				.putIf("code", code)
				.putIf("mobile", mobile)
				.putIf("verifyCode", verifyCode)
				.putIf("encryptedData", encryptedData)
				.putIf("iv", iv)
				.into_map();
	}

	public boolean isSimulation() {
		return simulation;
	}

	public void setSimulation(boolean simulation) {
		this.simulation = simulation;
	}

	public boolean isForceAuthenSuccess() {
		return forceAuthenSuccess;
	}

	public void setForceAuthenSuccess(boolean forceAuthenSuccess) {
		this.forceAuthenSuccess = forceAuthenSuccess;
	}

	public Object getForceAuthenResult() {
		return forceAuthenResult;
	}

	public void setForceAuthenResult(Object forceAuthenResult) {
		this.forceAuthenResult = forceAuthenResult;
	}
}

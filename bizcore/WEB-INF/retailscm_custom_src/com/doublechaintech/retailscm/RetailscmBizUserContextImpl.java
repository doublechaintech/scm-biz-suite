package com.doublechaintech.retailscm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.caf.viewcomponent.PopupViewComponent;
import com.terapico.utils.TextUtil;

public class RetailscmBizUserContextImpl extends RetailscmUserContextImpl{

	protected static final String DEFAULT_ACTION_GROUP = "default";
	protected Map<String, List<ButtonViewComponent>> actionGroups;
	protected String accessUrl;
	protected Object resultObject;
	protected String mobile;
	protected String userId;
	protected String lastRecordId;
	protected String verifyCode;
	protected String filter;
	protected String orderId;
	protected String formKey;
	protected String wechatEncryptedData;
	protected String wechatOpenId;
	protected String wechatIv;
	protected String message;
	protected PopupViewComponent popup;
	protected Map<String, Object> toast;
	protected String accessToken;
	protected BaseRetailscmFormProcessor inputFormData;
	protected BaseRetailscmFormProcessor outputFormData;
	
	public void clearFormResubmitFlag() {
		removeFromCache(getPostMd5Key(this));
	}
	public String getPostMd5Key(RetailscmBizUserContextImpl ctx) {
		return ctx.tokenId()+":postMd5Key";
	}
	public void checkOnlyCalledByLocalhost() throws Exception {
		String ip = getRemoteIP();
		if (!ip.equals("127.0.0.1") && isProductEnvironment()) {
			throw new Exception("本接口只能在本地调用");
		}
	}
	public void setEventResult(String eventName, int processResult) {
		this.putIntoContextLocalStorage("event_"+eventName+"_result", processResult);
	}
	public Integer getEventResult(String eventName) {
		return (Integer) this.getFromContextLocalStorage("event_"+eventName+"_result");
	}
	public void addAction(String title, String code, String linkToUrl) {
		addAction(DEFAULT_ACTION_GROUP, title, code, linkToUrl);
	}
	public void addAction(ButtonViewComponent actionButton) {
		addAction(DEFAULT_ACTION_GROUP, actionButton);
	}
	public List<ButtonViewComponent> getActionList(){
		return getActionList(DEFAULT_ACTION_GROUP);
	}
	public List<ButtonViewComponent> getActionList(String groupName){
		return ensureActionGroups(groupName);
	}
	public Map<String, ButtonViewComponent> getActions(){
		return getActions(DEFAULT_ACTION_GROUP);
	}
	public Map<String, ButtonViewComponent> getActions(String groupName){
		List<ButtonViewComponent> actions = ensureActionGroups(groupName);
		Map<String, ButtonViewComponent> resultMap = new HashMap<>();
		for(ButtonViewComponent action: actions) {
			resultMap.put(action.getTag(), action);
		}
		return resultMap;
	}
	public void addAction(String groupName, String title, String code, String linkToUrl) {
		List<ButtonViewComponent> actionList = ensureActionGroups(groupName);
		ButtonViewComponent btn = new ButtonViewComponent(title);
		btn.setTag(code);
		btn.setLinkToUrl(linkToUrl);
		actionList.add(btn);
	}
	public void addAction(String groupName, ButtonViewComponent actionButton) {
		ensureActionGroups(groupName).add(actionButton);
	}
	private List<ButtonViewComponent> ensureActionGroups(String groupName) {
		if (actionGroups == null) {
			actionGroups = new HashMap<>();
		}
		if (TextUtil.isBlank(groupName)) {
			return null;
		}
		List<ButtonViewComponent> actionList = actionGroups.get(groupName);
		if (actionList == null) {
			actionList = new ArrayList<>();
			actionGroups.put(groupName, actionList);
		}
		return actionList;
	}
	public Map<String, List<ButtonViewComponent>> getActionGroups() {
		return actionGroups;
	}
	public void setActionGroups(Map<String, List<ButtonViewComponent>> actionGroups) {
		this.actionGroups = actionGroups;
	}
	public String getAccessUrl() {
		return accessUrl;
	}
	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}
	public Object getResultObject() {
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLastRecordId() {
		return lastRecordId;
	}
	public void setLastRecordId(String lastRecordId) {
		this.lastRecordId = lastRecordId;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getFilter() {
		return filter;
	}
	public String getFilter(String defaulValue) {
		if (TextUtil.isBlank(filter)) {
			return defaulValue;
		}
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getFormKey() {
		return formKey;
	}
	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}
	public String getWechatEncryptedData() {
		return wechatEncryptedData;
	}
	public void setWechatEncryptedData(String wechatEncryptedData) {
		this.wechatEncryptedData = wechatEncryptedData;
	}
	public String getWechatOpenId() {
		return wechatOpenId;
	}
	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}
	public String getWechatIv() {
		return wechatIv;
	}
	public void setWechatIv(String wechatIv) {
		this.wechatIv = wechatIv;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PopupViewComponent getPopup() {
		return popup;
	}
	public void setPopup(PopupViewComponent popup) {
		this.popup = popup;
	}
	public Map<String, Object> getToast() {
		return toast;
	}
	public void setToast(Map<String, Object> toast) {
		this.toast = toast;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public BaseRetailscmFormProcessor getInputFormData() {
		return inputFormData;
	}
	public void setInputFormData(BaseRetailscmFormProcessor inputFormData) {
		this.inputFormData = inputFormData;
	}
	public BaseRetailscmFormProcessor getOutputFormData() {
		return outputFormData;
	}
	public void setOutputFormData(BaseRetailscmFormProcessor outputFormData) {
		this.outputFormData = outputFormData;
	}
	
	// 这个对象仅用于在开发环境中, 用cookie来模拟react-client的 JWT header. 因为开发环境使用的是普通的浏览器,不能在A
	// href的header中设置值.
	protected Cookie[] cookies;

	public Cookie[] getCookies() {
		return cookies;
	}

	public void setCookies(Cookie[] cookies) {
		this.cookies = cookies;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////
}



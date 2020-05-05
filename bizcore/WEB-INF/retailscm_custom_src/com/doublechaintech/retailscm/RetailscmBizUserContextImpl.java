package com.doublechaintech.retailscm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.terapico.caf.BlobObject;
import com.terapico.caf.appview.ChangeRequestData;
import com.terapico.caf.appview.ChangeRequestProcessResult;
import com.terapico.caf.baseelement.LoginParam;
import com.terapico.caf.viewcomponent.ButtonViewComponent;
import com.terapico.caf.viewcomponent.FilterTabsViewComponent;
import com.terapico.caf.viewcomponent.PopupViewComponent;

// 不包含支付相关的内容

import com.terapico.utils.TextUtil;
import com.doublechaintech.retailscm.secuser.SecUser;

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
	protected String jwtKeyId;
	protected FilterTabsViewComponent tabs;
	protected SecUser secUser;
	protected String inputJwtToken;
	protected String assignmentId;
	protected BaseRetailscmFormProcessor inputFormData;
	protected BaseRetailscmFormProcessor outputFormData;
	protected LoginParam loginParam;
	protected BaseEntity currentUserInfo;
	protected ChangeRequestData changeRequestResponse;
	protected ChangeRequestProcessResult changeRequestProcessResult;
	
	


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
	public BaseEntity getCurrentUserInfo() {
		return currentUserInfo;
	}
	public void setCurrentUserInfo(BaseEntity currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
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
	public ButtonViewComponent addAction(String groupName, String title, String code, String linkToUrl) {
		List<ButtonViewComponent> actionList = ensureActionGroups(groupName);
		ButtonViewComponent btn = new ButtonViewComponent(title);
		btn.setTag(code);
		btn.setLinkToUrl(linkToUrl);
		actionList.add(btn);
		return btn;
	}
	public ButtonViewComponent addAction(String groupName, ButtonViewComponent actionButton) {
		ensureActionGroups(groupName).add(actionButton);
		return actionButton;
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
			setFilter(defaulValue);
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
	public String getJwtKeyId() {
		return jwtKeyId;
	}
	public void setJwtKeyId(String jwtKeyId) {
		this.jwtKeyId = jwtKeyId;
	}
	public FilterTabsViewComponent getTabs() {
		return tabs;
	}
	public void setTabs(FilterTabsViewComponent tabs) {
		this.tabs = tabs;
	}
	public SecUser getSecUser() {
		return secUser;
	}
	public void setSecUser(SecUser secUser) {
		this.secUser = secUser;
	}
	public String getInputJwtToken() {
		return inputJwtToken;
	}
	public void setInputJwtToken(String inputJwtToken) {
		this.inputJwtToken = inputJwtToken;
	}
	public String getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}
	public LoginParam getLoginParam() {
		return loginParam;
	}
	public void setLoginParam(LoginParam loginParam) {
		this.loginParam = loginParam;
	}
	public ChangeRequestData getChangeRequestResponse() {
		return changeRequestResponse;
	}
	public void setChangeRequestResponse(ChangeRequestData changeRequestResponse) {
		this.changeRequestResponse = changeRequestResponse;
	}
	public ChangeRequestProcessResult getChangeRequestProcessResult() {
		return changeRequestProcessResult;
	}
	public void setChangeRequestProcessResult(ChangeRequestProcessResult changeRequestProcessResult) {
		this.changeRequestProcessResult = changeRequestProcessResult;
	}
	@Override
	public void sendEmail(String to, String subject, String content) throws Exception {
		if (!isProductEnvironment()) {
			to = "wangyudong@doublechaintech.com";
		}
		super.sendEmail(to, subject, content);
	}

	@Override
	public void sendEmailWithAttachment(String to, String subject, String content, List<BlobObject> attachments)
			throws Exception {
		if (!isProductEnvironment()) {
			to = "wangyudong@doublechaintech.com";
		}
		super.sendEmailWithAttachment(to, subject, content, attachments);
	}

	@Override
	public void sendMessage(String dest, String fromWho, String template, Map<String, String> parameters)
			throws Exception {
		if (!isProductEnvironment()) {
			System.out.printf("send to %s: %s:%s\n", dest, template, String.valueOf(parameters));
			return; // 短信直接不发
		}
		super.sendMessage(dest, fromWho, template, parameters);
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



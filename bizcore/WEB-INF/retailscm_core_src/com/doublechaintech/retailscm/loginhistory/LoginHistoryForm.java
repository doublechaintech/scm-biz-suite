package com.doublechaintech.retailscm.loginhistory;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LoginHistoryForm extends BaseForm {
	
	
	public LoginHistoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LoginHistoryForm loginHistoryIdField(String parameterName, String initValue){
		FormField field = idFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LoginHistoryForm loginHistoryIdField(String initValue){
		return loginHistoryIdField("loginHistoryId",initValue);
	}
	public LoginHistoryForm loginHistoryIdField(){
		return loginHistoryIdField("loginHistoryId","");
	}


	public LoginHistoryForm loginTimeField(String parameterName, String initValue){
		FormField field = loginTimeFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LoginHistoryForm loginTimeField(String initValue){
		return loginTimeField("loginTime",initValue);
	}
	public LoginHistoryForm loginTimeField(){
		return loginTimeField("loginTime","");
	}


	public LoginHistoryForm fromIpField(String parameterName, String initValue){
		FormField field = fromIpFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LoginHistoryForm fromIpField(String initValue){
		return fromIpField("fromIp",initValue);
	}
	public LoginHistoryForm fromIpField(){
		return fromIpField("fromIp","");
	}


	public LoginHistoryForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LoginHistoryForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public LoginHistoryForm descriptionField(){
		return descriptionField("description","");
	}


	public LoginHistoryForm secUserIdField(String parameterName, String initValue){
		FormField field = secUserIdFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LoginHistoryForm secUserIdField(String initValue){
		return secUserIdField("secUserId",initValue);
	}
	public LoginHistoryForm secUserIdField(){
		return secUserIdField("secUserId","");
	}

	
	


	public LoginHistoryForm secUserIdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  idFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm secUserIdFieldOfSecUser(String initValue){
		return secUserIdFieldOfSecUser("secUserId",initValue);
	}
	public LoginHistoryForm secUserIdFieldOfSecUser(){
		return secUserIdFieldOfSecUser("secUserId","");
	}


	public LoginHistoryForm loginFieldOfSecUser(String parameterName, String initValue){
		FormField field =  loginFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm loginFieldOfSecUser(String initValue){
		return loginFieldOfSecUser("login",initValue);
	}
	public LoginHistoryForm loginFieldOfSecUser(){
		return loginFieldOfSecUser("login","");
	}


	public LoginHistoryForm mobileFieldOfSecUser(String parameterName, String initValue){
		FormField field =  mobileFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm mobileFieldOfSecUser(String initValue){
		return mobileFieldOfSecUser("mobile",initValue);
	}
	public LoginHistoryForm mobileFieldOfSecUser(){
		return mobileFieldOfSecUser("mobile","");
	}


	public LoginHistoryForm emailFieldOfSecUser(String parameterName, String initValue){
		FormField field =  emailFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm emailFieldOfSecUser(String initValue){
		return emailFieldOfSecUser("email",initValue);
	}
	public LoginHistoryForm emailFieldOfSecUser(){
		return emailFieldOfSecUser("email","");
	}


	public LoginHistoryForm pwdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  pwdFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm pwdFieldOfSecUser(String initValue){
		return pwdFieldOfSecUser("pwd",initValue);
	}
	public LoginHistoryForm pwdFieldOfSecUser(){
		return pwdFieldOfSecUser("pwd","");
	}


	public LoginHistoryForm verificationCodeFieldOfSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm verificationCodeFieldOfSecUser(String initValue){
		return verificationCodeFieldOfSecUser("verificationCode",initValue);
	}
	public LoginHistoryForm verificationCodeFieldOfSecUser(){
		return verificationCodeFieldOfSecUser("verificationCode","");
	}


	public LoginHistoryForm verificationCodeExpireFieldOfSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeExpireFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm verificationCodeExpireFieldOfSecUser(String initValue){
		return verificationCodeExpireFieldOfSecUser("verificationCodeExpire",initValue);
	}
	public LoginHistoryForm verificationCodeExpireFieldOfSecUser(){
		return verificationCodeExpireFieldOfSecUser("verificationCodeExpire","");
	}


	public LoginHistoryForm lastLoginTimeFieldOfSecUser(String parameterName, String initValue){
		FormField field =  lastLoginTimeFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm lastLoginTimeFieldOfSecUser(String initValue){
		return lastLoginTimeFieldOfSecUser("lastLoginTime",initValue);
	}
	public LoginHistoryForm lastLoginTimeFieldOfSecUser(){
		return lastLoginTimeFieldOfSecUser("lastLoginTime","");
	}


	public LoginHistoryForm domainIdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  domainIdFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm domainIdFieldOfSecUser(String initValue){
		return domainIdFieldOfSecUser("domainId",initValue);
	}
	public LoginHistoryForm domainIdFieldOfSecUser(){
		return domainIdFieldOfSecUser("domainId","");
	}


	public LoginHistoryForm blockingIdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  blockingIdFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm blockingIdFieldOfSecUser(String initValue){
		return blockingIdFieldOfSecUser("blockingId",initValue);
	}
	public LoginHistoryForm blockingIdFieldOfSecUser(){
		return blockingIdFieldOfSecUser("blockingId","");
	}


	public LoginHistoryForm currentStatusFieldOfSecUser(String parameterName, String initValue){
		FormField field =  currentStatusFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LoginHistoryForm currentStatusFieldOfSecUser(String initValue){
		return currentStatusFieldOfSecUser("currentStatus",initValue);
	}
	public LoginHistoryForm currentStatusFieldOfSecUser(){
		return currentStatusFieldOfSecUser("currentStatus","");
	}

	


	

	
 	public LoginHistoryForm transferToAnotherSecUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSecUser/loginHistoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LoginHistoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.userdomain;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class UserDomainForm extends BaseForm {
	
	
	public UserDomainForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public UserDomainForm userDomainIdField(String parameterName, String initValue){
		FormField field = idFromUserDomain(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm userDomainIdField(String initValue){
		return userDomainIdField("userDomainId",initValue);
	}
	public UserDomainForm userDomainIdField(){
		return userDomainIdField("userDomainId","");
	}


	public UserDomainForm nameField(String parameterName, String initValue){
		FormField field = nameFromUserDomain(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public UserDomainForm nameField(){
		return nameField("name","");
	}

	
	

	



	public UserDomainForm userWhiteListIdFieldForUserWhiteList(String parameterName, String initValue){
		FormField field =  idFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm userWhiteListIdFieldForUserWhiteList(String initValue){
		return userWhiteListIdFieldForUserWhiteList("userWhiteListId",initValue);
	}
	public UserDomainForm userWhiteListIdFieldForUserWhiteList(){
		return userWhiteListIdFieldForUserWhiteList("userWhiteListId","");
	}


	public UserDomainForm userIdentityFieldForUserWhiteList(String parameterName, String initValue){
		FormField field =  userIdentityFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm userIdentityFieldForUserWhiteList(String initValue){
		return userIdentityFieldForUserWhiteList("userIdentity",initValue);
	}
	public UserDomainForm userIdentityFieldForUserWhiteList(){
		return userIdentityFieldForUserWhiteList("userIdentity","");
	}


	public UserDomainForm userSpecialFunctionsFieldForUserWhiteList(String parameterName, String initValue){
		FormField field =  userSpecialFunctionsFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm userSpecialFunctionsFieldForUserWhiteList(String initValue){
		return userSpecialFunctionsFieldForUserWhiteList("userSpecialFunctions",initValue);
	}
	public UserDomainForm userSpecialFunctionsFieldForUserWhiteList(){
		return userSpecialFunctionsFieldForUserWhiteList("userSpecialFunctions","");
	}


	public UserDomainForm domainIdFieldForUserWhiteList(String parameterName, String initValue){
		FormField field =  domainIdFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm domainIdFieldForUserWhiteList(String initValue){
		return domainIdFieldForUserWhiteList("domainId",initValue);
	}
	public UserDomainForm domainIdFieldForUserWhiteList(){
		return domainIdFieldForUserWhiteList("domainId","");
	}


	public UserDomainForm secUserIdFieldForSecUser(String parameterName, String initValue){
		FormField field =  idFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm secUserIdFieldForSecUser(String initValue){
		return secUserIdFieldForSecUser("secUserId",initValue);
	}
	public UserDomainForm secUserIdFieldForSecUser(){
		return secUserIdFieldForSecUser("secUserId","");
	}


	public UserDomainForm loginFieldForSecUser(String parameterName, String initValue){
		FormField field =  loginFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm loginFieldForSecUser(String initValue){
		return loginFieldForSecUser("login",initValue);
	}
	public UserDomainForm loginFieldForSecUser(){
		return loginFieldForSecUser("login","");
	}


	public UserDomainForm mobileFieldForSecUser(String parameterName, String initValue){
		FormField field =  mobileFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm mobileFieldForSecUser(String initValue){
		return mobileFieldForSecUser("mobile",initValue);
	}
	public UserDomainForm mobileFieldForSecUser(){
		return mobileFieldForSecUser("mobile","");
	}


	public UserDomainForm emailFieldForSecUser(String parameterName, String initValue){
		FormField field =  emailFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm emailFieldForSecUser(String initValue){
		return emailFieldForSecUser("email",initValue);
	}
	public UserDomainForm emailFieldForSecUser(){
		return emailFieldForSecUser("email","");
	}


	public UserDomainForm pwdFieldForSecUser(String parameterName, String initValue){
		FormField field =  pwdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm pwdFieldForSecUser(String initValue){
		return pwdFieldForSecUser("pwd",initValue);
	}
	public UserDomainForm pwdFieldForSecUser(){
		return pwdFieldForSecUser("pwd","");
	}


	public UserDomainForm verificationCodeFieldForSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm verificationCodeFieldForSecUser(String initValue){
		return verificationCodeFieldForSecUser("verificationCode",initValue);
	}
	public UserDomainForm verificationCodeFieldForSecUser(){
		return verificationCodeFieldForSecUser("verificationCode","");
	}


	public UserDomainForm verificationCodeExpireFieldForSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeExpireFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm verificationCodeExpireFieldForSecUser(String initValue){
		return verificationCodeExpireFieldForSecUser("verificationCodeExpire",initValue);
	}
	public UserDomainForm verificationCodeExpireFieldForSecUser(){
		return verificationCodeExpireFieldForSecUser("verificationCodeExpire","");
	}


	public UserDomainForm lastLoginTimeFieldForSecUser(String parameterName, String initValue){
		FormField field =  lastLoginTimeFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm lastLoginTimeFieldForSecUser(String initValue){
		return lastLoginTimeFieldForSecUser("lastLoginTime",initValue);
	}
	public UserDomainForm lastLoginTimeFieldForSecUser(){
		return lastLoginTimeFieldForSecUser("lastLoginTime","");
	}


	public UserDomainForm domainIdFieldForSecUser(String parameterName, String initValue){
		FormField field =  domainIdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm domainIdFieldForSecUser(String initValue){
		return domainIdFieldForSecUser("domainId",initValue);
	}
	public UserDomainForm domainIdFieldForSecUser(){
		return domainIdFieldForSecUser("domainId","");
	}


	public UserDomainForm blockingIdFieldForSecUser(String parameterName, String initValue){
		FormField field =  blockingIdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm blockingIdFieldForSecUser(String initValue){
		return blockingIdFieldForSecUser("blockingId",initValue);
	}
	public UserDomainForm blockingIdFieldForSecUser(){
		return blockingIdFieldForSecUser("blockingId","");
	}


	public UserDomainForm currentStatusFieldForSecUser(String parameterName, String initValue){
		FormField field =  currentStatusFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserDomainForm currentStatusFieldForSecUser(String initValue){
		return currentStatusFieldForSecUser("currentStatus",initValue);
	}
	public UserDomainForm currentStatusFieldForSecUser(){
		return currentStatusFieldForSecUser("currentStatus","");
	}

	



	public UserDomainForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



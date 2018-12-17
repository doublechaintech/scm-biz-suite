package com.doublechaintech.retailscm.secuserblocking;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SecUserBlockingForm extends BaseForm {
	
	
	public SecUserBlockingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SecUserBlockingForm secUserBlockingIdField(String parameterName, String initValue){
		FormField field = idFromSecUserBlocking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm secUserBlockingIdField(String initValue){
		return secUserBlockingIdField("secUserBlockingId",initValue);
	}
	public SecUserBlockingForm secUserBlockingIdField(){
		return secUserBlockingIdField("secUserBlockingId","");
	}


	public SecUserBlockingForm whoField(String parameterName, String initValue){
		FormField field = whoFromSecUserBlocking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public SecUserBlockingForm whoField(){
		return whoField("who","");
	}


	public SecUserBlockingForm blockTimeField(String parameterName, String initValue){
		FormField field = blockTimeFromSecUserBlocking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm blockTimeField(String initValue){
		return blockTimeField("blockTime",initValue);
	}
	public SecUserBlockingForm blockTimeField(){
		return blockTimeField("blockTime","");
	}


	public SecUserBlockingForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromSecUserBlocking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public SecUserBlockingForm commentsField(){
		return commentsField("comments","");
	}

	
	

	



	public SecUserBlockingForm secUserIdFieldForSecUser(String parameterName, String initValue){
		FormField field =  idFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm secUserIdFieldForSecUser(String initValue){
		return secUserIdFieldForSecUser("secUserId",initValue);
	}
	public SecUserBlockingForm secUserIdFieldForSecUser(){
		return secUserIdFieldForSecUser("secUserId","");
	}


	public SecUserBlockingForm loginFieldForSecUser(String parameterName, String initValue){
		FormField field =  loginFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm loginFieldForSecUser(String initValue){
		return loginFieldForSecUser("login",initValue);
	}
	public SecUserBlockingForm loginFieldForSecUser(){
		return loginFieldForSecUser("login","");
	}


	public SecUserBlockingForm mobileFieldForSecUser(String parameterName, String initValue){
		FormField field =  mobileFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm mobileFieldForSecUser(String initValue){
		return mobileFieldForSecUser("mobile",initValue);
	}
	public SecUserBlockingForm mobileFieldForSecUser(){
		return mobileFieldForSecUser("mobile","");
	}


	public SecUserBlockingForm emailFieldForSecUser(String parameterName, String initValue){
		FormField field =  emailFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm emailFieldForSecUser(String initValue){
		return emailFieldForSecUser("email",initValue);
	}
	public SecUserBlockingForm emailFieldForSecUser(){
		return emailFieldForSecUser("email","");
	}


	public SecUserBlockingForm pwdFieldForSecUser(String parameterName, String initValue){
		FormField field =  pwdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm pwdFieldForSecUser(String initValue){
		return pwdFieldForSecUser("pwd",initValue);
	}
	public SecUserBlockingForm pwdFieldForSecUser(){
		return pwdFieldForSecUser("pwd","");
	}


	public SecUserBlockingForm verificationCodeFieldForSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm verificationCodeFieldForSecUser(String initValue){
		return verificationCodeFieldForSecUser("verificationCode",initValue);
	}
	public SecUserBlockingForm verificationCodeFieldForSecUser(){
		return verificationCodeFieldForSecUser("verificationCode","");
	}


	public SecUserBlockingForm verificationCodeExpireFieldForSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeExpireFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm verificationCodeExpireFieldForSecUser(String initValue){
		return verificationCodeExpireFieldForSecUser("verificationCodeExpire",initValue);
	}
	public SecUserBlockingForm verificationCodeExpireFieldForSecUser(){
		return verificationCodeExpireFieldForSecUser("verificationCodeExpire","");
	}


	public SecUserBlockingForm lastLoginTimeFieldForSecUser(String parameterName, String initValue){
		FormField field =  lastLoginTimeFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm lastLoginTimeFieldForSecUser(String initValue){
		return lastLoginTimeFieldForSecUser("lastLoginTime",initValue);
	}
	public SecUserBlockingForm lastLoginTimeFieldForSecUser(){
		return lastLoginTimeFieldForSecUser("lastLoginTime","");
	}


	public SecUserBlockingForm domainIdFieldForSecUser(String parameterName, String initValue){
		FormField field =  domainIdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm domainIdFieldForSecUser(String initValue){
		return domainIdFieldForSecUser("domainId",initValue);
	}
	public SecUserBlockingForm domainIdFieldForSecUser(){
		return domainIdFieldForSecUser("domainId","");
	}


	public SecUserBlockingForm blockingIdFieldForSecUser(String parameterName, String initValue){
		FormField field =  blockingIdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm blockingIdFieldForSecUser(String initValue){
		return blockingIdFieldForSecUser("blockingId",initValue);
	}
	public SecUserBlockingForm blockingIdFieldForSecUser(){
		return blockingIdFieldForSecUser("blockingId","");
	}


	public SecUserBlockingForm currentStatusFieldForSecUser(String parameterName, String initValue){
		FormField field =  currentStatusFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserBlockingForm currentStatusFieldForSecUser(String initValue){
		return currentStatusFieldForSecUser("currentStatus",initValue);
	}
	public SecUserBlockingForm currentStatusFieldForSecUser(){
		return currentStatusFieldForSecUser("currentStatus","");
	}

	



	public SecUserBlockingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



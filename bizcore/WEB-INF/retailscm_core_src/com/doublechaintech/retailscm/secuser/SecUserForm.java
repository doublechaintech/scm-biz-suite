package com.doublechaintech.retailscm.secuser;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SecUserForm extends BaseForm {
	
	
	public SecUserForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SecUserForm secUserIdField(String parameterName, String initValue){
		FormField field = idFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm secUserIdField(String initValue){
		return secUserIdField("secUserId",initValue);
	}
	public SecUserForm secUserIdField(){
		return secUserIdField("secUserId","");
	}


	public SecUserForm loginField(String parameterName, String initValue){
		FormField field = loginFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm loginField(String initValue){
		return loginField("login",initValue);
	}
	public SecUserForm loginField(){
		return loginField("login","");
	}


	public SecUserForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public SecUserForm mobileField(){
		return mobileField("mobile","");
	}


	public SecUserForm emailField(String parameterName, String initValue){
		FormField field = emailFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm emailField(String initValue){
		return emailField("email",initValue);
	}
	public SecUserForm emailField(){
		return emailField("email","");
	}


	public SecUserForm pwdField(String parameterName, String initValue){
		FormField field = pwdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm pwdField(String initValue){
		return pwdField("pwd",initValue);
	}
	public SecUserForm pwdField(){
		return pwdField("pwd","");
	}


	public SecUserForm verificationCodeField(String parameterName, String initValue){
		FormField field = verificationCodeFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm verificationCodeField(String initValue){
		return verificationCodeField("verificationCode",initValue);
	}
	public SecUserForm verificationCodeField(){
		return verificationCodeField("verificationCode","");
	}


	public SecUserForm verificationCodeExpireField(String parameterName, String initValue){
		FormField field = verificationCodeExpireFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm verificationCodeExpireField(String initValue){
		return verificationCodeExpireField("verificationCodeExpire",initValue);
	}
	public SecUserForm verificationCodeExpireField(){
		return verificationCodeExpireField("verificationCodeExpire","");
	}


	public SecUserForm lastLoginTimeField(String parameterName, String initValue){
		FormField field = lastLoginTimeFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm lastLoginTimeField(String initValue){
		return lastLoginTimeField("lastLoginTime",initValue);
	}
	public SecUserForm lastLoginTimeField(){
		return lastLoginTimeField("lastLoginTime","");
	}


	public SecUserForm domainIdField(String parameterName, String initValue){
		FormField field = domainIdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm domainIdField(String initValue){
		return domainIdField("domainId",initValue);
	}
	public SecUserForm domainIdField(){
		return domainIdField("domainId","");
	}


	public SecUserForm blockingIdField(String parameterName, String initValue){
		FormField field = blockingIdFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm blockingIdField(String initValue){
		return blockingIdField("blockingId",initValue);
	}
	public SecUserForm blockingIdField(){
		return blockingIdField("blockingId","");
	}


	public SecUserForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromSecUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public SecUserForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public SecUserForm userDomainIdFieldOfUserDomain(String parameterName, String initValue){
		FormField field =  idFromUserDomain(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SecUserForm userDomainIdFieldOfUserDomain(String initValue){
		return userDomainIdFieldOfUserDomain("userDomainId",initValue);
	}
	public SecUserForm userDomainIdFieldOfUserDomain(){
		return userDomainIdFieldOfUserDomain("userDomainId","");
	}


	public SecUserForm nameFieldOfUserDomain(String parameterName, String initValue){
		FormField field =  nameFromUserDomain(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SecUserForm nameFieldOfUserDomain(String initValue){
		return nameFieldOfUserDomain("name",initValue);
	}
	public SecUserForm nameFieldOfUserDomain(){
		return nameFieldOfUserDomain("name","");
	}


	public SecUserForm secUserBlockingIdFieldOfSecUserBlocking(String parameterName, String initValue){
		FormField field =  idFromSecUserBlocking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SecUserForm secUserBlockingIdFieldOfSecUserBlocking(String initValue){
		return secUserBlockingIdFieldOfSecUserBlocking("secUserBlockingId",initValue);
	}
	public SecUserForm secUserBlockingIdFieldOfSecUserBlocking(){
		return secUserBlockingIdFieldOfSecUserBlocking("secUserBlockingId","");
	}


	public SecUserForm whoFieldOfSecUserBlocking(String parameterName, String initValue){
		FormField field =  whoFromSecUserBlocking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SecUserForm whoFieldOfSecUserBlocking(String initValue){
		return whoFieldOfSecUserBlocking("who",initValue);
	}
	public SecUserForm whoFieldOfSecUserBlocking(){
		return whoFieldOfSecUserBlocking("who","");
	}


	public SecUserForm blockTimeFieldOfSecUserBlocking(String parameterName, String initValue){
		FormField field =  blockTimeFromSecUserBlocking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SecUserForm blockTimeFieldOfSecUserBlocking(String initValue){
		return blockTimeFieldOfSecUserBlocking("blockTime",initValue);
	}
	public SecUserForm blockTimeFieldOfSecUserBlocking(){
		return blockTimeFieldOfSecUserBlocking("blockTime","");
	}


	public SecUserForm commentsFieldOfSecUserBlocking(String parameterName, String initValue){
		FormField field =  commentsFromSecUserBlocking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SecUserForm commentsFieldOfSecUserBlocking(String initValue){
		return commentsFieldOfSecUserBlocking("comments",initValue);
	}
	public SecUserForm commentsFieldOfSecUserBlocking(){
		return commentsFieldOfSecUserBlocking("comments","");
	}

	



	public SecUserForm userAppIdFieldForUserApp(String parameterName, String initValue){
		FormField field =  idFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm userAppIdFieldForUserApp(String initValue){
		return userAppIdFieldForUserApp("userAppId",initValue);
	}
	public SecUserForm userAppIdFieldForUserApp(){
		return userAppIdFieldForUserApp("userAppId","");
	}


	public SecUserForm titleFieldForUserApp(String parameterName, String initValue){
		FormField field =  titleFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm titleFieldForUserApp(String initValue){
		return titleFieldForUserApp("title",initValue);
	}
	public SecUserForm titleFieldForUserApp(){
		return titleFieldForUserApp("title","");
	}


	public SecUserForm secUserIdFieldForUserApp(String parameterName, String initValue){
		FormField field =  secUserIdFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm secUserIdFieldForUserApp(String initValue){
		return secUserIdFieldForUserApp("secUserId",initValue);
	}
	public SecUserForm secUserIdFieldForUserApp(){
		return secUserIdFieldForUserApp("secUserId","");
	}


	public SecUserForm appIconFieldForUserApp(String parameterName, String initValue){
		FormField field =  appIconFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm appIconFieldForUserApp(String initValue){
		return appIconFieldForUserApp("appIcon",initValue);
	}
	public SecUserForm appIconFieldForUserApp(){
		return appIconFieldForUserApp("appIcon","");
	}


	public SecUserForm fullAccessFieldForUserApp(String parameterName, String initValue){
		FormField field =  fullAccessFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm fullAccessFieldForUserApp(String initValue){
		return fullAccessFieldForUserApp("fullAccess",initValue);
	}
	public SecUserForm fullAccessFieldForUserApp(){
		return fullAccessFieldForUserApp("fullAccess","");
	}


	public SecUserForm permissionFieldForUserApp(String parameterName, String initValue){
		FormField field =  permissionFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm permissionFieldForUserApp(String initValue){
		return permissionFieldForUserApp("permission",initValue);
	}
	public SecUserForm permissionFieldForUserApp(){
		return permissionFieldForUserApp("permission","");
	}


	public SecUserForm objectTypeFieldForUserApp(String parameterName, String initValue){
		FormField field =  objectTypeFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm objectTypeFieldForUserApp(String initValue){
		return objectTypeFieldForUserApp("objectType",initValue);
	}
	public SecUserForm objectTypeFieldForUserApp(){
		return objectTypeFieldForUserApp("objectType","");
	}


	public SecUserForm objectIdFieldForUserApp(String parameterName, String initValue){
		FormField field =  objectIdFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm objectIdFieldForUserApp(String initValue){
		return objectIdFieldForUserApp("objectId",initValue);
	}
	public SecUserForm objectIdFieldForUserApp(){
		return objectIdFieldForUserApp("objectId","");
	}


	public SecUserForm locationFieldForUserApp(String parameterName, String initValue){
		FormField field =  locationFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm locationFieldForUserApp(String initValue){
		return locationFieldForUserApp("location",initValue);
	}
	public SecUserForm locationFieldForUserApp(){
		return locationFieldForUserApp("location","");
	}


	public SecUserForm loginHistoryIdFieldForLoginHistory(String parameterName, String initValue){
		FormField field =  idFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm loginHistoryIdFieldForLoginHistory(String initValue){
		return loginHistoryIdFieldForLoginHistory("loginHistoryId",initValue);
	}
	public SecUserForm loginHistoryIdFieldForLoginHistory(){
		return loginHistoryIdFieldForLoginHistory("loginHistoryId","");
	}


	public SecUserForm loginTimeFieldForLoginHistory(String parameterName, String initValue){
		FormField field =  loginTimeFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm loginTimeFieldForLoginHistory(String initValue){
		return loginTimeFieldForLoginHistory("loginTime",initValue);
	}
	public SecUserForm loginTimeFieldForLoginHistory(){
		return loginTimeFieldForLoginHistory("loginTime","");
	}


	public SecUserForm fromIpFieldForLoginHistory(String parameterName, String initValue){
		FormField field =  fromIpFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm fromIpFieldForLoginHistory(String initValue){
		return fromIpFieldForLoginHistory("fromIp",initValue);
	}
	public SecUserForm fromIpFieldForLoginHistory(){
		return fromIpFieldForLoginHistory("fromIp","");
	}


	public SecUserForm descriptionFieldForLoginHistory(String parameterName, String initValue){
		FormField field =  descriptionFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm descriptionFieldForLoginHistory(String initValue){
		return descriptionFieldForLoginHistory("description",initValue);
	}
	public SecUserForm descriptionFieldForLoginHistory(){
		return descriptionFieldForLoginHistory("description","");
	}


	public SecUserForm secUserIdFieldForLoginHistory(String parameterName, String initValue){
		FormField field =  secUserIdFromLoginHistory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SecUserForm secUserIdFieldForLoginHistory(String initValue){
		return secUserIdFieldForLoginHistory("secUserId",initValue);
	}
	public SecUserForm secUserIdFieldForLoginHistory(){
		return secUserIdFieldForLoginHistory("secUserId","");
	}

	

	
 	public SecUserForm transferToAnotherDomainAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDomain/secUserId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public SecUserForm  blockAction(){
		FormAction action = new FormAction();
		action.setLabel("Block");
		action.setLocaleKey("sec_user.block");
		action.setUrl("secUserManager/block/secUserId/who/comments/");
		this.addFormAction(action);
		return this;
	}

	public SecUserForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



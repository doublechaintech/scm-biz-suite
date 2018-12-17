package com.doublechaintech.retailscm.userapp;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class UserAppForm extends BaseForm {
	
	
	public UserAppForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public UserAppForm userAppIdField(String parameterName, String initValue){
		FormField field = idFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm userAppIdField(String initValue){
		return userAppIdField("userAppId",initValue);
	}
	public UserAppForm userAppIdField(){
		return userAppIdField("userAppId","");
	}


	public UserAppForm titleField(String parameterName, String initValue){
		FormField field = titleFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public UserAppForm titleField(){
		return titleField("title","");
	}


	public UserAppForm secUserIdField(String parameterName, String initValue){
		FormField field = secUserIdFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm secUserIdField(String initValue){
		return secUserIdField("secUserId",initValue);
	}
	public UserAppForm secUserIdField(){
		return secUserIdField("secUserId","");
	}


	public UserAppForm appIconField(String parameterName, String initValue){
		FormField field = appIconFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm appIconField(String initValue){
		return appIconField("appIcon",initValue);
	}
	public UserAppForm appIconField(){
		return appIconField("appIcon","");
	}


	public UserAppForm fullAccessField(String parameterName, String initValue){
		FormField field = fullAccessFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm fullAccessField(String initValue){
		return fullAccessField("fullAccess",initValue);
	}
	public UserAppForm fullAccessField(){
		return fullAccessField("fullAccess","");
	}


	public UserAppForm permissionField(String parameterName, String initValue){
		FormField field = permissionFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm permissionField(String initValue){
		return permissionField("permission",initValue);
	}
	public UserAppForm permissionField(){
		return permissionField("permission","");
	}


	public UserAppForm objectTypeField(String parameterName, String initValue){
		FormField field = objectTypeFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm objectTypeField(String initValue){
		return objectTypeField("objectType",initValue);
	}
	public UserAppForm objectTypeField(){
		return objectTypeField("objectType","");
	}


	public UserAppForm objectIdField(String parameterName, String initValue){
		FormField field = objectIdFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm objectIdField(String initValue){
		return objectIdField("objectId",initValue);
	}
	public UserAppForm objectIdField(){
		return objectIdField("objectId","");
	}


	public UserAppForm locationField(String parameterName, String initValue){
		FormField field = locationFromUserApp(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public UserAppForm locationField(){
		return locationField("location","");
	}

	
	


	public UserAppForm secUserIdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  idFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm secUserIdFieldOfSecUser(String initValue){
		return secUserIdFieldOfSecUser("secUserId",initValue);
	}
	public UserAppForm secUserIdFieldOfSecUser(){
		return secUserIdFieldOfSecUser("secUserId","");
	}


	public UserAppForm loginFieldOfSecUser(String parameterName, String initValue){
		FormField field =  loginFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm loginFieldOfSecUser(String initValue){
		return loginFieldOfSecUser("login",initValue);
	}
	public UserAppForm loginFieldOfSecUser(){
		return loginFieldOfSecUser("login","");
	}


	public UserAppForm mobileFieldOfSecUser(String parameterName, String initValue){
		FormField field =  mobileFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm mobileFieldOfSecUser(String initValue){
		return mobileFieldOfSecUser("mobile",initValue);
	}
	public UserAppForm mobileFieldOfSecUser(){
		return mobileFieldOfSecUser("mobile","");
	}


	public UserAppForm emailFieldOfSecUser(String parameterName, String initValue){
		FormField field =  emailFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm emailFieldOfSecUser(String initValue){
		return emailFieldOfSecUser("email",initValue);
	}
	public UserAppForm emailFieldOfSecUser(){
		return emailFieldOfSecUser("email","");
	}


	public UserAppForm pwdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  pwdFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm pwdFieldOfSecUser(String initValue){
		return pwdFieldOfSecUser("pwd",initValue);
	}
	public UserAppForm pwdFieldOfSecUser(){
		return pwdFieldOfSecUser("pwd","");
	}


	public UserAppForm verificationCodeFieldOfSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm verificationCodeFieldOfSecUser(String initValue){
		return verificationCodeFieldOfSecUser("verificationCode",initValue);
	}
	public UserAppForm verificationCodeFieldOfSecUser(){
		return verificationCodeFieldOfSecUser("verificationCode","");
	}


	public UserAppForm verificationCodeExpireFieldOfSecUser(String parameterName, String initValue){
		FormField field =  verificationCodeExpireFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm verificationCodeExpireFieldOfSecUser(String initValue){
		return verificationCodeExpireFieldOfSecUser("verificationCodeExpire",initValue);
	}
	public UserAppForm verificationCodeExpireFieldOfSecUser(){
		return verificationCodeExpireFieldOfSecUser("verificationCodeExpire","");
	}


	public UserAppForm lastLoginTimeFieldOfSecUser(String parameterName, String initValue){
		FormField field =  lastLoginTimeFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm lastLoginTimeFieldOfSecUser(String initValue){
		return lastLoginTimeFieldOfSecUser("lastLoginTime",initValue);
	}
	public UserAppForm lastLoginTimeFieldOfSecUser(){
		return lastLoginTimeFieldOfSecUser("lastLoginTime","");
	}


	public UserAppForm domainIdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  domainIdFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm domainIdFieldOfSecUser(String initValue){
		return domainIdFieldOfSecUser("domainId",initValue);
	}
	public UserAppForm domainIdFieldOfSecUser(){
		return domainIdFieldOfSecUser("domainId","");
	}


	public UserAppForm blockingIdFieldOfSecUser(String parameterName, String initValue){
		FormField field =  blockingIdFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm blockingIdFieldOfSecUser(String initValue){
		return blockingIdFieldOfSecUser("blockingId",initValue);
	}
	public UserAppForm blockingIdFieldOfSecUser(){
		return blockingIdFieldOfSecUser("blockingId","");
	}


	public UserAppForm currentStatusFieldOfSecUser(String parameterName, String initValue){
		FormField field =  currentStatusFromSecUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAppForm currentStatusFieldOfSecUser(String initValue){
		return currentStatusFieldOfSecUser("currentStatus",initValue);
	}
	public UserAppForm currentStatusFieldOfSecUser(){
		return currentStatusFieldOfSecUser("currentStatus","");
	}

	



	public UserAppForm listAccessIdFieldForListAccess(String parameterName, String initValue){
		FormField field =  idFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm listAccessIdFieldForListAccess(String initValue){
		return listAccessIdFieldForListAccess("listAccessId",initValue);
	}
	public UserAppForm listAccessIdFieldForListAccess(){
		return listAccessIdFieldForListAccess("listAccessId","");
	}


	public UserAppForm nameFieldForListAccess(String parameterName, String initValue){
		FormField field =  nameFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm nameFieldForListAccess(String initValue){
		return nameFieldForListAccess("name",initValue);
	}
	public UserAppForm nameFieldForListAccess(){
		return nameFieldForListAccess("name","");
	}


	public UserAppForm internalNameFieldForListAccess(String parameterName, String initValue){
		FormField field =  internalNameFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm internalNameFieldForListAccess(String initValue){
		return internalNameFieldForListAccess("internalName",initValue);
	}
	public UserAppForm internalNameFieldForListAccess(){
		return internalNameFieldForListAccess("internalName","");
	}


	public UserAppForm readPermissionFieldForListAccess(String parameterName, String initValue){
		FormField field =  readPermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm readPermissionFieldForListAccess(String initValue){
		return readPermissionFieldForListAccess("readPermission",initValue);
	}
	public UserAppForm readPermissionFieldForListAccess(){
		return readPermissionFieldForListAccess("readPermission","");
	}


	public UserAppForm createPermissionFieldForListAccess(String parameterName, String initValue){
		FormField field =  createPermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm createPermissionFieldForListAccess(String initValue){
		return createPermissionFieldForListAccess("createPermission",initValue);
	}
	public UserAppForm createPermissionFieldForListAccess(){
		return createPermissionFieldForListAccess("createPermission","");
	}


	public UserAppForm deletePermissionFieldForListAccess(String parameterName, String initValue){
		FormField field =  deletePermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm deletePermissionFieldForListAccess(String initValue){
		return deletePermissionFieldForListAccess("deletePermission",initValue);
	}
	public UserAppForm deletePermissionFieldForListAccess(){
		return deletePermissionFieldForListAccess("deletePermission","");
	}


	public UserAppForm updatePermissionFieldForListAccess(String parameterName, String initValue){
		FormField field =  updatePermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm updatePermissionFieldForListAccess(String initValue){
		return updatePermissionFieldForListAccess("updatePermission",initValue);
	}
	public UserAppForm updatePermissionFieldForListAccess(){
		return updatePermissionFieldForListAccess("updatePermission","");
	}


	public UserAppForm executionPermissionFieldForListAccess(String parameterName, String initValue){
		FormField field =  executionPermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm executionPermissionFieldForListAccess(String initValue){
		return executionPermissionFieldForListAccess("executionPermission",initValue);
	}
	public UserAppForm executionPermissionFieldForListAccess(){
		return executionPermissionFieldForListAccess("executionPermission","");
	}


	public UserAppForm appIdFieldForListAccess(String parameterName, String initValue){
		FormField field =  appIdFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm appIdFieldForListAccess(String initValue){
		return appIdFieldForListAccess("appId",initValue);
	}
	public UserAppForm appIdFieldForListAccess(){
		return appIdFieldForListAccess("appId","");
	}


	public UserAppForm objectAccessIdFieldForObjectAccess(String parameterName, String initValue){
		FormField field =  idFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm objectAccessIdFieldForObjectAccess(String initValue){
		return objectAccessIdFieldForObjectAccess("objectAccessId",initValue);
	}
	public UserAppForm objectAccessIdFieldForObjectAccess(){
		return objectAccessIdFieldForObjectAccess("objectAccessId","");
	}


	public UserAppForm nameFieldForObjectAccess(String parameterName, String initValue){
		FormField field =  nameFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm nameFieldForObjectAccess(String initValue){
		return nameFieldForObjectAccess("name",initValue);
	}
	public UserAppForm nameFieldForObjectAccess(){
		return nameFieldForObjectAccess("name","");
	}


	public UserAppForm objectTypeFieldForObjectAccess(String parameterName, String initValue){
		FormField field =  objectTypeFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm objectTypeFieldForObjectAccess(String initValue){
		return objectTypeFieldForObjectAccess("objectType",initValue);
	}
	public UserAppForm objectTypeFieldForObjectAccess(){
		return objectTypeFieldForObjectAccess("objectType","");
	}


	public UserAppForm list1FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list1FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list1FieldForObjectAccess(String initValue){
		return list1FieldForObjectAccess("list1",initValue);
	}
	public UserAppForm list1FieldForObjectAccess(){
		return list1FieldForObjectAccess("list1","");
	}


	public UserAppForm list2FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list2FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list2FieldForObjectAccess(String initValue){
		return list2FieldForObjectAccess("list2",initValue);
	}
	public UserAppForm list2FieldForObjectAccess(){
		return list2FieldForObjectAccess("list2","");
	}


	public UserAppForm list3FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list3FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list3FieldForObjectAccess(String initValue){
		return list3FieldForObjectAccess("list3",initValue);
	}
	public UserAppForm list3FieldForObjectAccess(){
		return list3FieldForObjectAccess("list3","");
	}


	public UserAppForm list4FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list4FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list4FieldForObjectAccess(String initValue){
		return list4FieldForObjectAccess("list4",initValue);
	}
	public UserAppForm list4FieldForObjectAccess(){
		return list4FieldForObjectAccess("list4","");
	}


	public UserAppForm list5FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list5FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list5FieldForObjectAccess(String initValue){
		return list5FieldForObjectAccess("list5",initValue);
	}
	public UserAppForm list5FieldForObjectAccess(){
		return list5FieldForObjectAccess("list5","");
	}


	public UserAppForm list6FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list6FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list6FieldForObjectAccess(String initValue){
		return list6FieldForObjectAccess("list6",initValue);
	}
	public UserAppForm list6FieldForObjectAccess(){
		return list6FieldForObjectAccess("list6","");
	}


	public UserAppForm list7FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list7FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list7FieldForObjectAccess(String initValue){
		return list7FieldForObjectAccess("list7",initValue);
	}
	public UserAppForm list7FieldForObjectAccess(){
		return list7FieldForObjectAccess("list7","");
	}


	public UserAppForm list8FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list8FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list8FieldForObjectAccess(String initValue){
		return list8FieldForObjectAccess("list8",initValue);
	}
	public UserAppForm list8FieldForObjectAccess(){
		return list8FieldForObjectAccess("list8","");
	}


	public UserAppForm list9FieldForObjectAccess(String parameterName, String initValue){
		FormField field =  list9FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm list9FieldForObjectAccess(String initValue){
		return list9FieldForObjectAccess("list9",initValue);
	}
	public UserAppForm list9FieldForObjectAccess(){
		return list9FieldForObjectAccess("list9","");
	}


	public UserAppForm appIdFieldForObjectAccess(String parameterName, String initValue){
		FormField field =  appIdFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAppForm appIdFieldForObjectAccess(String initValue){
		return appIdFieldForObjectAccess("appId",initValue);
	}
	public UserAppForm appIdFieldForObjectAccess(){
		return appIdFieldForObjectAccess("appId","");
	}

	

	
 	public UserAppForm transferToAnotherSecUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSecUser/userAppId/");
		this.addFormAction(action);
		return this;
	}

 

	public UserAppForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



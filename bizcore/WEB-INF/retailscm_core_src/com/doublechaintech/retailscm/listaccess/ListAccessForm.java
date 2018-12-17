package com.doublechaintech.retailscm.listaccess;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ListAccessForm extends BaseForm {
	
	
	public ListAccessForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ListAccessForm listAccessIdField(String parameterName, String initValue){
		FormField field = idFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm listAccessIdField(String initValue){
		return listAccessIdField("listAccessId",initValue);
	}
	public ListAccessForm listAccessIdField(){
		return listAccessIdField("listAccessId","");
	}


	public ListAccessForm nameField(String parameterName, String initValue){
		FormField field = nameFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ListAccessForm nameField(){
		return nameField("name","");
	}


	public ListAccessForm internalNameField(String parameterName, String initValue){
		FormField field = internalNameFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm internalNameField(String initValue){
		return internalNameField("internalName",initValue);
	}
	public ListAccessForm internalNameField(){
		return internalNameField("internalName","");
	}


	public ListAccessForm readPermissionField(String parameterName, String initValue){
		FormField field = readPermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm readPermissionField(String initValue){
		return readPermissionField("readPermission",initValue);
	}
	public ListAccessForm readPermissionField(){
		return readPermissionField("readPermission","");
	}


	public ListAccessForm createPermissionField(String parameterName, String initValue){
		FormField field = createPermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm createPermissionField(String initValue){
		return createPermissionField("createPermission",initValue);
	}
	public ListAccessForm createPermissionField(){
		return createPermissionField("createPermission","");
	}


	public ListAccessForm deletePermissionField(String parameterName, String initValue){
		FormField field = deletePermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm deletePermissionField(String initValue){
		return deletePermissionField("deletePermission",initValue);
	}
	public ListAccessForm deletePermissionField(){
		return deletePermissionField("deletePermission","");
	}


	public ListAccessForm updatePermissionField(String parameterName, String initValue){
		FormField field = updatePermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm updatePermissionField(String initValue){
		return updatePermissionField("updatePermission",initValue);
	}
	public ListAccessForm updatePermissionField(){
		return updatePermissionField("updatePermission","");
	}


	public ListAccessForm executionPermissionField(String parameterName, String initValue){
		FormField field = executionPermissionFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm executionPermissionField(String initValue){
		return executionPermissionField("executionPermission",initValue);
	}
	public ListAccessForm executionPermissionField(){
		return executionPermissionField("executionPermission","");
	}


	public ListAccessForm appIdField(String parameterName, String initValue){
		FormField field = appIdFromListAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ListAccessForm appIdField(String initValue){
		return appIdField("appId",initValue);
	}
	public ListAccessForm appIdField(){
		return appIdField("appId","");
	}

	
	


	public ListAccessForm userAppIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  idFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm userAppIdFieldOfUserApp(String initValue){
		return userAppIdFieldOfUserApp("userAppId",initValue);
	}
	public ListAccessForm userAppIdFieldOfUserApp(){
		return userAppIdFieldOfUserApp("userAppId","");
	}


	public ListAccessForm titleFieldOfUserApp(String parameterName, String initValue){
		FormField field =  titleFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm titleFieldOfUserApp(String initValue){
		return titleFieldOfUserApp("title",initValue);
	}
	public ListAccessForm titleFieldOfUserApp(){
		return titleFieldOfUserApp("title","");
	}


	public ListAccessForm secUserIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  secUserIdFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm secUserIdFieldOfUserApp(String initValue){
		return secUserIdFieldOfUserApp("secUserId",initValue);
	}
	public ListAccessForm secUserIdFieldOfUserApp(){
		return secUserIdFieldOfUserApp("secUserId","");
	}


	public ListAccessForm appIconFieldOfUserApp(String parameterName, String initValue){
		FormField field =  appIconFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm appIconFieldOfUserApp(String initValue){
		return appIconFieldOfUserApp("appIcon",initValue);
	}
	public ListAccessForm appIconFieldOfUserApp(){
		return appIconFieldOfUserApp("appIcon","");
	}


	public ListAccessForm fullAccessFieldOfUserApp(String parameterName, String initValue){
		FormField field =  fullAccessFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm fullAccessFieldOfUserApp(String initValue){
		return fullAccessFieldOfUserApp("fullAccess",initValue);
	}
	public ListAccessForm fullAccessFieldOfUserApp(){
		return fullAccessFieldOfUserApp("fullAccess","");
	}


	public ListAccessForm permissionFieldOfUserApp(String parameterName, String initValue){
		FormField field =  permissionFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm permissionFieldOfUserApp(String initValue){
		return permissionFieldOfUserApp("permission",initValue);
	}
	public ListAccessForm permissionFieldOfUserApp(){
		return permissionFieldOfUserApp("permission","");
	}


	public ListAccessForm objectTypeFieldOfUserApp(String parameterName, String initValue){
		FormField field =  objectTypeFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm objectTypeFieldOfUserApp(String initValue){
		return objectTypeFieldOfUserApp("objectType",initValue);
	}
	public ListAccessForm objectTypeFieldOfUserApp(){
		return objectTypeFieldOfUserApp("objectType","");
	}


	public ListAccessForm objectIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  objectIdFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm objectIdFieldOfUserApp(String initValue){
		return objectIdFieldOfUserApp("objectId",initValue);
	}
	public ListAccessForm objectIdFieldOfUserApp(){
		return objectIdFieldOfUserApp("objectId","");
	}


	public ListAccessForm locationFieldOfUserApp(String parameterName, String initValue){
		FormField field =  locationFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ListAccessForm locationFieldOfUserApp(String initValue){
		return locationFieldOfUserApp("location",initValue);
	}
	public ListAccessForm locationFieldOfUserApp(){
		return locationFieldOfUserApp("location","");
	}

	


	

	
 	public ListAccessForm transferToAnotherAppAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherApp/listAccessId/");
		this.addFormAction(action);
		return this;
	}

 

	public ListAccessForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



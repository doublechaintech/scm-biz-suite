package com.doublechaintech.retailscm.objectaccess;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ObjectAccessForm extends BaseForm {
	
	
	public ObjectAccessForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ObjectAccessForm objectAccessIdField(String parameterName, String initValue){
		FormField field = idFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm objectAccessIdField(String initValue){
		return objectAccessIdField("objectAccessId",initValue);
	}
	public ObjectAccessForm objectAccessIdField(){
		return objectAccessIdField("objectAccessId","");
	}


	public ObjectAccessForm nameField(String parameterName, String initValue){
		FormField field = nameFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ObjectAccessForm nameField(){
		return nameField("name","");
	}


	public ObjectAccessForm objectTypeField(String parameterName, String initValue){
		FormField field = objectTypeFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm objectTypeField(String initValue){
		return objectTypeField("objectType",initValue);
	}
	public ObjectAccessForm objectTypeField(){
		return objectTypeField("objectType","");
	}


	public ObjectAccessForm list1Field(String parameterName, String initValue){
		FormField field = list1FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list1Field(String initValue){
		return list1Field("list1",initValue);
	}
	public ObjectAccessForm list1Field(){
		return list1Field("list1","");
	}


	public ObjectAccessForm list2Field(String parameterName, String initValue){
		FormField field = list2FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list2Field(String initValue){
		return list2Field("list2",initValue);
	}
	public ObjectAccessForm list2Field(){
		return list2Field("list2","");
	}


	public ObjectAccessForm list3Field(String parameterName, String initValue){
		FormField field = list3FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list3Field(String initValue){
		return list3Field("list3",initValue);
	}
	public ObjectAccessForm list3Field(){
		return list3Field("list3","");
	}


	public ObjectAccessForm list4Field(String parameterName, String initValue){
		FormField field = list4FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list4Field(String initValue){
		return list4Field("list4",initValue);
	}
	public ObjectAccessForm list4Field(){
		return list4Field("list4","");
	}


	public ObjectAccessForm list5Field(String parameterName, String initValue){
		FormField field = list5FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list5Field(String initValue){
		return list5Field("list5",initValue);
	}
	public ObjectAccessForm list5Field(){
		return list5Field("list5","");
	}


	public ObjectAccessForm list6Field(String parameterName, String initValue){
		FormField field = list6FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list6Field(String initValue){
		return list6Field("list6",initValue);
	}
	public ObjectAccessForm list6Field(){
		return list6Field("list6","");
	}


	public ObjectAccessForm list7Field(String parameterName, String initValue){
		FormField field = list7FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list7Field(String initValue){
		return list7Field("list7",initValue);
	}
	public ObjectAccessForm list7Field(){
		return list7Field("list7","");
	}


	public ObjectAccessForm list8Field(String parameterName, String initValue){
		FormField field = list8FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list8Field(String initValue){
		return list8Field("list8",initValue);
	}
	public ObjectAccessForm list8Field(){
		return list8Field("list8","");
	}


	public ObjectAccessForm list9Field(String parameterName, String initValue){
		FormField field = list9FromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm list9Field(String initValue){
		return list9Field("list9",initValue);
	}
	public ObjectAccessForm list9Field(){
		return list9Field("list9","");
	}


	public ObjectAccessForm appIdField(String parameterName, String initValue){
		FormField field = appIdFromObjectAccess(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ObjectAccessForm appIdField(String initValue){
		return appIdField("appId",initValue);
	}
	public ObjectAccessForm appIdField(){
		return appIdField("appId","");
	}

	
	


	public ObjectAccessForm userAppIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  idFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm userAppIdFieldOfUserApp(String initValue){
		return userAppIdFieldOfUserApp("userAppId",initValue);
	}
	public ObjectAccessForm userAppIdFieldOfUserApp(){
		return userAppIdFieldOfUserApp("userAppId","");
	}


	public ObjectAccessForm titleFieldOfUserApp(String parameterName, String initValue){
		FormField field =  titleFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm titleFieldOfUserApp(String initValue){
		return titleFieldOfUserApp("title",initValue);
	}
	public ObjectAccessForm titleFieldOfUserApp(){
		return titleFieldOfUserApp("title","");
	}


	public ObjectAccessForm secUserIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  secUserIdFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm secUserIdFieldOfUserApp(String initValue){
		return secUserIdFieldOfUserApp("secUserId",initValue);
	}
	public ObjectAccessForm secUserIdFieldOfUserApp(){
		return secUserIdFieldOfUserApp("secUserId","");
	}


	public ObjectAccessForm appIconFieldOfUserApp(String parameterName, String initValue){
		FormField field =  appIconFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm appIconFieldOfUserApp(String initValue){
		return appIconFieldOfUserApp("appIcon",initValue);
	}
	public ObjectAccessForm appIconFieldOfUserApp(){
		return appIconFieldOfUserApp("appIcon","");
	}


	public ObjectAccessForm fullAccessFieldOfUserApp(String parameterName, String initValue){
		FormField field =  fullAccessFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm fullAccessFieldOfUserApp(String initValue){
		return fullAccessFieldOfUserApp("fullAccess",initValue);
	}
	public ObjectAccessForm fullAccessFieldOfUserApp(){
		return fullAccessFieldOfUserApp("fullAccess","");
	}


	public ObjectAccessForm permissionFieldOfUserApp(String parameterName, String initValue){
		FormField field =  permissionFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm permissionFieldOfUserApp(String initValue){
		return permissionFieldOfUserApp("permission",initValue);
	}
	public ObjectAccessForm permissionFieldOfUserApp(){
		return permissionFieldOfUserApp("permission","");
	}


	public ObjectAccessForm objectTypeFieldOfUserApp(String parameterName, String initValue){
		FormField field =  objectTypeFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm objectTypeFieldOfUserApp(String initValue){
		return objectTypeFieldOfUserApp("objectType",initValue);
	}
	public ObjectAccessForm objectTypeFieldOfUserApp(){
		return objectTypeFieldOfUserApp("objectType","");
	}


	public ObjectAccessForm objectIdFieldOfUserApp(String parameterName, String initValue){
		FormField field =  objectIdFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm objectIdFieldOfUserApp(String initValue){
		return objectIdFieldOfUserApp("objectId",initValue);
	}
	public ObjectAccessForm objectIdFieldOfUserApp(){
		return objectIdFieldOfUserApp("objectId","");
	}


	public ObjectAccessForm locationFieldOfUserApp(String parameterName, String initValue){
		FormField field =  locationFromUserApp(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ObjectAccessForm locationFieldOfUserApp(String initValue){
		return locationFieldOfUserApp("location",initValue);
	}
	public ObjectAccessForm locationFieldOfUserApp(){
		return locationFieldOfUserApp("location","");
	}

	


	

	
 	public ObjectAccessForm transferToAnotherAppAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherApp/objectAccessId/");
		this.addFormAction(action);
		return this;
	}

 

	public ObjectAccessForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



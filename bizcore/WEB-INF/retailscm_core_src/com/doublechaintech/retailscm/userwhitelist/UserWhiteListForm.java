package com.doublechaintech.retailscm.userwhitelist;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class UserWhiteListForm extends BaseForm {
	
	
	public UserWhiteListForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public UserWhiteListForm userWhiteListIdField(String parameterName, String initValue){
		FormField field = idFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserWhiteListForm userWhiteListIdField(String initValue){
		return userWhiteListIdField("userWhiteListId",initValue);
	}
	public UserWhiteListForm userWhiteListIdField(){
		return userWhiteListIdField("userWhiteListId","");
	}


	public UserWhiteListForm userIdentityField(String parameterName, String initValue){
		FormField field = userIdentityFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserWhiteListForm userIdentityField(String initValue){
		return userIdentityField("userIdentity",initValue);
	}
	public UserWhiteListForm userIdentityField(){
		return userIdentityField("userIdentity","");
	}


	public UserWhiteListForm userSpecialFunctionsField(String parameterName, String initValue){
		FormField field = userSpecialFunctionsFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserWhiteListForm userSpecialFunctionsField(String initValue){
		return userSpecialFunctionsField("userSpecialFunctions",initValue);
	}
	public UserWhiteListForm userSpecialFunctionsField(){
		return userSpecialFunctionsField("userSpecialFunctions","");
	}


	public UserWhiteListForm domainIdField(String parameterName, String initValue){
		FormField field = domainIdFromUserWhiteList(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserWhiteListForm domainIdField(String initValue){
		return domainIdField("domainId",initValue);
	}
	public UserWhiteListForm domainIdField(){
		return domainIdField("domainId","");
	}

	
	


	public UserWhiteListForm userDomainIdFieldOfUserDomain(String parameterName, String initValue){
		FormField field =  idFromUserDomain(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserWhiteListForm userDomainIdFieldOfUserDomain(String initValue){
		return userDomainIdFieldOfUserDomain("userDomainId",initValue);
	}
	public UserWhiteListForm userDomainIdFieldOfUserDomain(){
		return userDomainIdFieldOfUserDomain("userDomainId","");
	}


	public UserWhiteListForm nameFieldOfUserDomain(String parameterName, String initValue){
		FormField field =  nameFromUserDomain(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserWhiteListForm nameFieldOfUserDomain(String initValue){
		return nameFieldOfUserDomain("name",initValue);
	}
	public UserWhiteListForm nameFieldOfUserDomain(){
		return nameFieldOfUserDomain("name","");
	}

	


	

	
 	public UserWhiteListForm transferToAnotherDomainAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDomain/userWhiteListId/");
		this.addFormAction(action);
		return this;
	}

 

	public UserWhiteListForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



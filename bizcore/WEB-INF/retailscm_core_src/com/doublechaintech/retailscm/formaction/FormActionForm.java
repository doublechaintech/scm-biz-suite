package com.doublechaintech.retailscm.formaction;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class FormActionForm extends BaseForm {
	
	
	public FormActionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public FormActionForm formActionIdField(String parameterName, String initValue){
		FormField field = idFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm formActionIdField(String initValue){
		return formActionIdField("formActionId",initValue);
	}
	public FormActionForm formActionIdField(){
		return formActionIdField("formActionId","");
	}


	public FormActionForm labelField(String parameterName, String initValue){
		FormField field = labelFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm labelField(String initValue){
		return labelField("label",initValue);
	}
	public FormActionForm labelField(){
		return labelField("label","");
	}


	public FormActionForm localeKeyField(String parameterName, String initValue){
		FormField field = localeKeyFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm localeKeyField(String initValue){
		return localeKeyField("localeKey",initValue);
	}
	public FormActionForm localeKeyField(){
		return localeKeyField("localeKey","");
	}


	public FormActionForm actionKeyField(String parameterName, String initValue){
		FormField field = actionKeyFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm actionKeyField(String initValue){
		return actionKeyField("actionKey",initValue);
	}
	public FormActionForm actionKeyField(){
		return actionKeyField("actionKey","");
	}


	public FormActionForm levelField(String parameterName, String initValue){
		FormField field = levelFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm levelField(String initValue){
		return levelField("level",initValue);
	}
	public FormActionForm levelField(){
		return levelField("level","");
	}


	public FormActionForm urlField(String parameterName, String initValue){
		FormField field = urlFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm urlField(String initValue){
		return urlField("url",initValue);
	}
	public FormActionForm urlField(){
		return urlField("url","");
	}


	public FormActionForm formIdField(String parameterName, String initValue){
		FormField field = formIdFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormActionForm formIdField(String initValue){
		return formIdField("formId",initValue);
	}
	public FormActionForm formIdField(){
		return formIdField("formId","");
	}

	
	


	public FormActionForm genericFormIdFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  idFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormActionForm genericFormIdFieldOfGenericForm(String initValue){
		return genericFormIdFieldOfGenericForm("genericFormId",initValue);
	}
	public FormActionForm genericFormIdFieldOfGenericForm(){
		return genericFormIdFieldOfGenericForm("genericFormId","");
	}


	public FormActionForm titleFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  titleFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormActionForm titleFieldOfGenericForm(String initValue){
		return titleFieldOfGenericForm("title",initValue);
	}
	public FormActionForm titleFieldOfGenericForm(){
		return titleFieldOfGenericForm("title","");
	}


	public FormActionForm descriptionFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  descriptionFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormActionForm descriptionFieldOfGenericForm(String initValue){
		return descriptionFieldOfGenericForm("description",initValue);
	}
	public FormActionForm descriptionFieldOfGenericForm(){
		return descriptionFieldOfGenericForm("description","");
	}

	


	

	
 	public FormActionForm transferToAnotherFormAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherForm/formActionId/");
		this.addFormAction(action);
		return this;
	}

 

	public FormActionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}
















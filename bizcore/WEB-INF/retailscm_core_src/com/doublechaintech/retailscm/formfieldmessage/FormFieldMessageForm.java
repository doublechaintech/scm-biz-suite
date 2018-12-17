package com.doublechaintech.retailscm.formfieldmessage;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class FormFieldMessageForm extends BaseForm {
	
	
	public FormFieldMessageForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public FormFieldMessageForm formFieldMessageIdField(String parameterName, String initValue){
		FormField field = idFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldMessageForm formFieldMessageIdField(String initValue){
		return formFieldMessageIdField("formFieldMessageId",initValue);
	}
	public FormFieldMessageForm formFieldMessageIdField(){
		return formFieldMessageIdField("formFieldMessageId","");
	}


	public FormFieldMessageForm titleField(String parameterName, String initValue){
		FormField field = titleFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldMessageForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public FormFieldMessageForm titleField(){
		return titleField("title","");
	}


	public FormFieldMessageForm parameterNameField(String parameterName, String initValue){
		FormField field = parameterNameFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldMessageForm parameterNameField(String initValue){
		return parameterNameField("parameterName",initValue);
	}
	public FormFieldMessageForm parameterNameField(){
		return parameterNameField("parameterName","");
	}


	public FormFieldMessageForm formIdField(String parameterName, String initValue){
		FormField field = formIdFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldMessageForm formIdField(String initValue){
		return formIdField("formId",initValue);
	}
	public FormFieldMessageForm formIdField(){
		return formIdField("formId","");
	}


	public FormFieldMessageForm levelField(String parameterName, String initValue){
		FormField field = levelFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldMessageForm levelField(String initValue){
		return levelField("level",initValue);
	}
	public FormFieldMessageForm levelField(){
		return levelField("level","");
	}

	
	


	public FormFieldMessageForm genericFormIdFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  idFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormFieldMessageForm genericFormIdFieldOfGenericForm(String initValue){
		return genericFormIdFieldOfGenericForm("genericFormId",initValue);
	}
	public FormFieldMessageForm genericFormIdFieldOfGenericForm(){
		return genericFormIdFieldOfGenericForm("genericFormId","");
	}


	public FormFieldMessageForm titleFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  titleFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormFieldMessageForm titleFieldOfGenericForm(String initValue){
		return titleFieldOfGenericForm("title",initValue);
	}
	public FormFieldMessageForm titleFieldOfGenericForm(){
		return titleFieldOfGenericForm("title","");
	}


	public FormFieldMessageForm descriptionFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  descriptionFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormFieldMessageForm descriptionFieldOfGenericForm(String initValue){
		return descriptionFieldOfGenericForm("description",initValue);
	}
	public FormFieldMessageForm descriptionFieldOfGenericForm(){
		return descriptionFieldOfGenericForm("description","");
	}

	


	

	
 	public FormFieldMessageForm transferToAnotherFormAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherForm/formFieldMessageId/");
		this.addFormAction(action);
		return this;
	}

 

	public FormFieldMessageForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



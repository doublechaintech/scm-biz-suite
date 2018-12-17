package com.doublechaintech.retailscm.formfield;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class FormFieldForm extends BaseForm {
	
	
	public FormFieldForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public FormFieldForm formFieldIdField(String parameterName, String initValue){
		FormField field = idFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm formFieldIdField(String initValue){
		return formFieldIdField("formFieldId",initValue);
	}
	public FormFieldForm formFieldIdField(){
		return formFieldIdField("formFieldId","");
	}


	public FormFieldForm labelField(String parameterName, String initValue){
		FormField field = labelFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm labelField(String initValue){
		return labelField("label",initValue);
	}
	public FormFieldForm labelField(){
		return labelField("label","");
	}


	public FormFieldForm localeKeyField(String parameterName, String initValue){
		FormField field = localeKeyFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm localeKeyField(String initValue){
		return localeKeyField("localeKey",initValue);
	}
	public FormFieldForm localeKeyField(){
		return localeKeyField("localeKey","");
	}


	public FormFieldForm parameterNameField(String parameterName, String initValue){
		FormField field = parameterNameFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm parameterNameField(String initValue){
		return parameterNameField("parameterName",initValue);
	}
	public FormFieldForm parameterNameField(){
		return parameterNameField("parameterName","");
	}


	public FormFieldForm typeField(String parameterName, String initValue){
		FormField field = typeFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm typeField(String initValue){
		return typeField("type",initValue);
	}
	public FormFieldForm typeField(){
		return typeField("type","");
	}


	public FormFieldForm formIdField(String parameterName, String initValue){
		FormField field = formIdFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm formIdField(String initValue){
		return formIdField("formId",initValue);
	}
	public FormFieldForm formIdField(){
		return formIdField("formId","");
	}


	public FormFieldForm placeholderField(String parameterName, String initValue){
		FormField field = placeholderFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm placeholderField(String initValue){
		return placeholderField("placeholder",initValue);
	}
	public FormFieldForm placeholderField(){
		return placeholderField("placeholder","");
	}


	public FormFieldForm defaultValueField(String parameterName, String initValue){
		FormField field = defaultValueFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm defaultValueField(String initValue){
		return defaultValueField("defaultValue",initValue);
	}
	public FormFieldForm defaultValueField(){
		return defaultValueField("defaultValue","");
	}


	public FormFieldForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public FormFieldForm descriptionField(){
		return descriptionField("description","");
	}


	public FormFieldForm fieldGroupField(String parameterName, String initValue){
		FormField field = fieldGroupFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm fieldGroupField(String initValue){
		return fieldGroupField("fieldGroup",initValue);
	}
	public FormFieldForm fieldGroupField(){
		return fieldGroupField("fieldGroup","");
	}


	public FormFieldForm minimumValueField(String parameterName, String initValue){
		FormField field = minimumValueFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm minimumValueField(String initValue){
		return minimumValueField("minimumValue",initValue);
	}
	public FormFieldForm minimumValueField(){
		return minimumValueField("minimumValue","");
	}


	public FormFieldForm maximumValueField(String parameterName, String initValue){
		FormField field = maximumValueFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm maximumValueField(String initValue){
		return maximumValueField("maximumValue",initValue);
	}
	public FormFieldForm maximumValueField(){
		return maximumValueField("maximumValue","");
	}


	public FormFieldForm requiredField(String parameterName, String initValue){
		FormField field = requiredFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm requiredField(String initValue){
		return requiredField("required",initValue);
	}
	public FormFieldForm requiredField(){
		return requiredField("required","");
	}


	public FormFieldForm disabledField(String parameterName, String initValue){
		FormField field = disabledFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm disabledField(String initValue){
		return disabledField("disabled",initValue);
	}
	public FormFieldForm disabledField(){
		return disabledField("disabled","");
	}


	public FormFieldForm customRenderingField(String parameterName, String initValue){
		FormField field = customRenderingFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm customRenderingField(String initValue){
		return customRenderingField("customRendering",initValue);
	}
	public FormFieldForm customRenderingField(){
		return customRenderingField("customRendering","");
	}


	public FormFieldForm candidateValuesField(String parameterName, String initValue){
		FormField field = candidateValuesFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm candidateValuesField(String initValue){
		return candidateValuesField("candidateValues",initValue);
	}
	public FormFieldForm candidateValuesField(){
		return candidateValuesField("candidateValues","");
	}


	public FormFieldForm suggestValuesField(String parameterName, String initValue){
		FormField field = suggestValuesFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FormFieldForm suggestValuesField(String initValue){
		return suggestValuesField("suggestValues",initValue);
	}
	public FormFieldForm suggestValuesField(){
		return suggestValuesField("suggestValues","");
	}

	
	


	public FormFieldForm genericFormIdFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  idFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormFieldForm genericFormIdFieldOfGenericForm(String initValue){
		return genericFormIdFieldOfGenericForm("genericFormId",initValue);
	}
	public FormFieldForm genericFormIdFieldOfGenericForm(){
		return genericFormIdFieldOfGenericForm("genericFormId","");
	}


	public FormFieldForm titleFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  titleFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormFieldForm titleFieldOfGenericForm(String initValue){
		return titleFieldOfGenericForm("title",initValue);
	}
	public FormFieldForm titleFieldOfGenericForm(){
		return titleFieldOfGenericForm("title","");
	}


	public FormFieldForm descriptionFieldOfGenericForm(String parameterName, String initValue){
		FormField field =  descriptionFromGenericForm(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FormFieldForm descriptionFieldOfGenericForm(String initValue){
		return descriptionFieldOfGenericForm("description",initValue);
	}
	public FormFieldForm descriptionFieldOfGenericForm(){
		return descriptionFieldOfGenericForm("description","");
	}

	


	

	
 	public FormFieldForm transferToAnotherFormAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherForm/formFieldId/");
		this.addFormAction(action);
		return this;
	}

 

	public FormFieldForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



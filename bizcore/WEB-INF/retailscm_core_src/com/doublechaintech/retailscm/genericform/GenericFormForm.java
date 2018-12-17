package com.doublechaintech.retailscm.genericform;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GenericFormForm extends BaseForm {
	
	
	public GenericFormForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GenericFormForm genericFormIdField(String parameterName, String initValue){
		FormField field = idFromGenericForm(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm genericFormIdField(String initValue){
		return genericFormIdField("genericFormId",initValue);
	}
	public GenericFormForm genericFormIdField(){
		return genericFormIdField("genericFormId","");
	}


	public GenericFormForm titleField(String parameterName, String initValue){
		FormField field = titleFromGenericForm(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public GenericFormForm titleField(){
		return titleField("title","");
	}


	public GenericFormForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromGenericForm(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public GenericFormForm descriptionField(){
		return descriptionField("description","");
	}

	
	

	



	public GenericFormForm formMessageIdFieldForFormMessage(String parameterName, String initValue){
		FormField field =  idFromFormMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formMessageIdFieldForFormMessage(String initValue){
		return formMessageIdFieldForFormMessage("formMessageId",initValue);
	}
	public GenericFormForm formMessageIdFieldForFormMessage(){
		return formMessageIdFieldForFormMessage("formMessageId","");
	}


	public GenericFormForm titleFieldForFormMessage(String parameterName, String initValue){
		FormField field =  titleFromFormMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm titleFieldForFormMessage(String initValue){
		return titleFieldForFormMessage("title",initValue);
	}
	public GenericFormForm titleFieldForFormMessage(){
		return titleFieldForFormMessage("title","");
	}


	public GenericFormForm formIdFieldForFormMessage(String parameterName, String initValue){
		FormField field =  formIdFromFormMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formIdFieldForFormMessage(String initValue){
		return formIdFieldForFormMessage("formId",initValue);
	}
	public GenericFormForm formIdFieldForFormMessage(){
		return formIdFieldForFormMessage("formId","");
	}


	public GenericFormForm levelFieldForFormMessage(String parameterName, String initValue){
		FormField field =  levelFromFormMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm levelFieldForFormMessage(String initValue){
		return levelFieldForFormMessage("level",initValue);
	}
	public GenericFormForm levelFieldForFormMessage(){
		return levelFieldForFormMessage("level","");
	}


	public GenericFormForm formFieldMessageIdFieldForFormFieldMessage(String parameterName, String initValue){
		FormField field =  idFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formFieldMessageIdFieldForFormFieldMessage(String initValue){
		return formFieldMessageIdFieldForFormFieldMessage("formFieldMessageId",initValue);
	}
	public GenericFormForm formFieldMessageIdFieldForFormFieldMessage(){
		return formFieldMessageIdFieldForFormFieldMessage("formFieldMessageId","");
	}


	public GenericFormForm titleFieldForFormFieldMessage(String parameterName, String initValue){
		FormField field =  titleFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm titleFieldForFormFieldMessage(String initValue){
		return titleFieldForFormFieldMessage("title",initValue);
	}
	public GenericFormForm titleFieldForFormFieldMessage(){
		return titleFieldForFormFieldMessage("title","");
	}


	public GenericFormForm parameterNameFieldForFormFieldMessage(String parameterName, String initValue){
		FormField field =  parameterNameFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm parameterNameFieldForFormFieldMessage(String initValue){
		return parameterNameFieldForFormFieldMessage("parameterName",initValue);
	}
	public GenericFormForm parameterNameFieldForFormFieldMessage(){
		return parameterNameFieldForFormFieldMessage("parameterName","");
	}


	public GenericFormForm formIdFieldForFormFieldMessage(String parameterName, String initValue){
		FormField field =  formIdFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formIdFieldForFormFieldMessage(String initValue){
		return formIdFieldForFormFieldMessage("formId",initValue);
	}
	public GenericFormForm formIdFieldForFormFieldMessage(){
		return formIdFieldForFormFieldMessage("formId","");
	}


	public GenericFormForm levelFieldForFormFieldMessage(String parameterName, String initValue){
		FormField field =  levelFromFormFieldMessage(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm levelFieldForFormFieldMessage(String initValue){
		return levelFieldForFormFieldMessage("level",initValue);
	}
	public GenericFormForm levelFieldForFormFieldMessage(){
		return levelFieldForFormFieldMessage("level","");
	}


	public GenericFormForm formFieldIdFieldForFormField(String parameterName, String initValue){
		FormField field =  idFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formFieldIdFieldForFormField(String initValue){
		return formFieldIdFieldForFormField("formFieldId",initValue);
	}
	public GenericFormForm formFieldIdFieldForFormField(){
		return formFieldIdFieldForFormField("formFieldId","");
	}


	public GenericFormForm labelFieldForFormField(String parameterName, String initValue){
		FormField field =  labelFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm labelFieldForFormField(String initValue){
		return labelFieldForFormField("label",initValue);
	}
	public GenericFormForm labelFieldForFormField(){
		return labelFieldForFormField("label","");
	}


	public GenericFormForm localeKeyFieldForFormField(String parameterName, String initValue){
		FormField field =  localeKeyFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm localeKeyFieldForFormField(String initValue){
		return localeKeyFieldForFormField("localeKey",initValue);
	}
	public GenericFormForm localeKeyFieldForFormField(){
		return localeKeyFieldForFormField("localeKey","");
	}


	public GenericFormForm parameterNameFieldForFormField(String parameterName, String initValue){
		FormField field =  parameterNameFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm parameterNameFieldForFormField(String initValue){
		return parameterNameFieldForFormField("parameterName",initValue);
	}
	public GenericFormForm parameterNameFieldForFormField(){
		return parameterNameFieldForFormField("parameterName","");
	}


	public GenericFormForm typeFieldForFormField(String parameterName, String initValue){
		FormField field =  typeFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm typeFieldForFormField(String initValue){
		return typeFieldForFormField("type",initValue);
	}
	public GenericFormForm typeFieldForFormField(){
		return typeFieldForFormField("type","");
	}


	public GenericFormForm formIdFieldForFormField(String parameterName, String initValue){
		FormField field =  formIdFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formIdFieldForFormField(String initValue){
		return formIdFieldForFormField("formId",initValue);
	}
	public GenericFormForm formIdFieldForFormField(){
		return formIdFieldForFormField("formId","");
	}


	public GenericFormForm placeholderFieldForFormField(String parameterName, String initValue){
		FormField field =  placeholderFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm placeholderFieldForFormField(String initValue){
		return placeholderFieldForFormField("placeholder",initValue);
	}
	public GenericFormForm placeholderFieldForFormField(){
		return placeholderFieldForFormField("placeholder","");
	}


	public GenericFormForm defaultValueFieldForFormField(String parameterName, String initValue){
		FormField field =  defaultValueFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm defaultValueFieldForFormField(String initValue){
		return defaultValueFieldForFormField("defaultValue",initValue);
	}
	public GenericFormForm defaultValueFieldForFormField(){
		return defaultValueFieldForFormField("defaultValue","");
	}


	public GenericFormForm descriptionFieldForFormField(String parameterName, String initValue){
		FormField field =  descriptionFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm descriptionFieldForFormField(String initValue){
		return descriptionFieldForFormField("description",initValue);
	}
	public GenericFormForm descriptionFieldForFormField(){
		return descriptionFieldForFormField("description","");
	}


	public GenericFormForm fieldGroupFieldForFormField(String parameterName, String initValue){
		FormField field =  fieldGroupFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm fieldGroupFieldForFormField(String initValue){
		return fieldGroupFieldForFormField("fieldGroup",initValue);
	}
	public GenericFormForm fieldGroupFieldForFormField(){
		return fieldGroupFieldForFormField("fieldGroup","");
	}


	public GenericFormForm minimumValueFieldForFormField(String parameterName, String initValue){
		FormField field =  minimumValueFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm minimumValueFieldForFormField(String initValue){
		return minimumValueFieldForFormField("minimumValue",initValue);
	}
	public GenericFormForm minimumValueFieldForFormField(){
		return minimumValueFieldForFormField("minimumValue","");
	}


	public GenericFormForm maximumValueFieldForFormField(String parameterName, String initValue){
		FormField field =  maximumValueFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm maximumValueFieldForFormField(String initValue){
		return maximumValueFieldForFormField("maximumValue",initValue);
	}
	public GenericFormForm maximumValueFieldForFormField(){
		return maximumValueFieldForFormField("maximumValue","");
	}


	public GenericFormForm requiredFieldForFormField(String parameterName, String initValue){
		FormField field =  requiredFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm requiredFieldForFormField(String initValue){
		return requiredFieldForFormField("required",initValue);
	}
	public GenericFormForm requiredFieldForFormField(){
		return requiredFieldForFormField("required","");
	}


	public GenericFormForm disabledFieldForFormField(String parameterName, String initValue){
		FormField field =  disabledFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm disabledFieldForFormField(String initValue){
		return disabledFieldForFormField("disabled",initValue);
	}
	public GenericFormForm disabledFieldForFormField(){
		return disabledFieldForFormField("disabled","");
	}


	public GenericFormForm customRenderingFieldForFormField(String parameterName, String initValue){
		FormField field =  customRenderingFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm customRenderingFieldForFormField(String initValue){
		return customRenderingFieldForFormField("customRendering",initValue);
	}
	public GenericFormForm customRenderingFieldForFormField(){
		return customRenderingFieldForFormField("customRendering","");
	}


	public GenericFormForm candidateValuesFieldForFormField(String parameterName, String initValue){
		FormField field =  candidateValuesFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm candidateValuesFieldForFormField(String initValue){
		return candidateValuesFieldForFormField("candidateValues",initValue);
	}
	public GenericFormForm candidateValuesFieldForFormField(){
		return candidateValuesFieldForFormField("candidateValues","");
	}


	public GenericFormForm suggestValuesFieldForFormField(String parameterName, String initValue){
		FormField field =  suggestValuesFromFormField(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm suggestValuesFieldForFormField(String initValue){
		return suggestValuesFieldForFormField("suggestValues",initValue);
	}
	public GenericFormForm suggestValuesFieldForFormField(){
		return suggestValuesFieldForFormField("suggestValues","");
	}


	public GenericFormForm formActionIdFieldForFormAction(String parameterName, String initValue){
		FormField field =  idFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formActionIdFieldForFormAction(String initValue){
		return formActionIdFieldForFormAction("formActionId",initValue);
	}
	public GenericFormForm formActionIdFieldForFormAction(){
		return formActionIdFieldForFormAction("formActionId","");
	}


	public GenericFormForm labelFieldForFormAction(String parameterName, String initValue){
		FormField field =  labelFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm labelFieldForFormAction(String initValue){
		return labelFieldForFormAction("label",initValue);
	}
	public GenericFormForm labelFieldForFormAction(){
		return labelFieldForFormAction("label","");
	}


	public GenericFormForm localeKeyFieldForFormAction(String parameterName, String initValue){
		FormField field =  localeKeyFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm localeKeyFieldForFormAction(String initValue){
		return localeKeyFieldForFormAction("localeKey",initValue);
	}
	public GenericFormForm localeKeyFieldForFormAction(){
		return localeKeyFieldForFormAction("localeKey","");
	}


	public GenericFormForm actionKeyFieldForFormAction(String parameterName, String initValue){
		FormField field =  actionKeyFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm actionKeyFieldForFormAction(String initValue){
		return actionKeyFieldForFormAction("actionKey",initValue);
	}
	public GenericFormForm actionKeyFieldForFormAction(){
		return actionKeyFieldForFormAction("actionKey","");
	}


	public GenericFormForm levelFieldForFormAction(String parameterName, String initValue){
		FormField field =  levelFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm levelFieldForFormAction(String initValue){
		return levelFieldForFormAction("level",initValue);
	}
	public GenericFormForm levelFieldForFormAction(){
		return levelFieldForFormAction("level","");
	}


	public GenericFormForm urlFieldForFormAction(String parameterName, String initValue){
		FormField field =  urlFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm urlFieldForFormAction(String initValue){
		return urlFieldForFormAction("url",initValue);
	}
	public GenericFormForm urlFieldForFormAction(){
		return urlFieldForFormAction("url","");
	}


	public GenericFormForm formIdFieldForFormAction(String parameterName, String initValue){
		FormField field =  formIdFromFormAction(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GenericFormForm formIdFieldForFormAction(String initValue){
		return formIdFieldForFormAction("formId",initValue);
	}
	public GenericFormForm formIdFieldForFormAction(){
		return formIdFieldForFormAction("formId","");
	}

	



	public GenericFormForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



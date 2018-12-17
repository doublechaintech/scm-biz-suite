package com.doublechaintech.retailscm.consumerorderprocessing;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderProcessingForm extends BaseForm {
	
	
	public ConsumerOrderProcessingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderProcessingForm consumerOrderProcessingIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderProcessingForm consumerOrderProcessingIdField(String initValue){
		return consumerOrderProcessingIdField("consumerOrderProcessingId",initValue);
	}
	public ConsumerOrderProcessingForm consumerOrderProcessingIdField(){
		return consumerOrderProcessingIdField("consumerOrderProcessingId","");
	}


	public ConsumerOrderProcessingForm whoField(String parameterName, String initValue){
		FormField field = whoFromConsumerOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderProcessingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ConsumerOrderProcessingForm whoField(){
		return whoField("who","");
	}


	public ConsumerOrderProcessingForm processTimeField(String parameterName, String initValue){
		FormField field = processTimeFromConsumerOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderProcessingForm processTimeField(String initValue){
		return processTimeField("processTime",initValue);
	}
	public ConsumerOrderProcessingForm processTimeField(){
		return processTimeField("processTime","");
	}

	
	

	


	



	public ConsumerOrderProcessingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



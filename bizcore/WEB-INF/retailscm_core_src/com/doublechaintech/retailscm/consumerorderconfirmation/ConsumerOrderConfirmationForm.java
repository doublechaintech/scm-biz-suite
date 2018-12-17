package com.doublechaintech.retailscm.consumerorderconfirmation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderConfirmationForm extends BaseForm {
	
	
	public ConsumerOrderConfirmationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderConfirmationForm consumerOrderConfirmationIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderConfirmationForm consumerOrderConfirmationIdField(String initValue){
		return consumerOrderConfirmationIdField("consumerOrderConfirmationId",initValue);
	}
	public ConsumerOrderConfirmationForm consumerOrderConfirmationIdField(){
		return consumerOrderConfirmationIdField("consumerOrderConfirmationId","");
	}


	public ConsumerOrderConfirmationForm whoField(String parameterName, String initValue){
		FormField field = whoFromConsumerOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderConfirmationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ConsumerOrderConfirmationForm whoField(){
		return whoField("who","");
	}


	public ConsumerOrderConfirmationForm confirmTimeField(String parameterName, String initValue){
		FormField field = confirmTimeFromConsumerOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderConfirmationForm confirmTimeField(String initValue){
		return confirmTimeField("confirmTime",initValue);
	}
	public ConsumerOrderConfirmationForm confirmTimeField(){
		return confirmTimeField("confirmTime","");
	}

	
	

	


	



	public ConsumerOrderConfirmationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



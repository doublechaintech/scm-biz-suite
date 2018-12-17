package com.doublechaintech.retailscm.consumerorderdelivery;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderDeliveryForm extends BaseForm {
	
	
	public ConsumerOrderDeliveryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderDeliveryForm consumerOrderDeliveryIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderDelivery(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderDeliveryForm consumerOrderDeliveryIdField(String initValue){
		return consumerOrderDeliveryIdField("consumerOrderDeliveryId",initValue);
	}
	public ConsumerOrderDeliveryForm consumerOrderDeliveryIdField(){
		return consumerOrderDeliveryIdField("consumerOrderDeliveryId","");
	}


	public ConsumerOrderDeliveryForm whoField(String parameterName, String initValue){
		FormField field = whoFromConsumerOrderDelivery(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderDeliveryForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ConsumerOrderDeliveryForm whoField(){
		return whoField("who","");
	}


	public ConsumerOrderDeliveryForm deliveryTimeField(String parameterName, String initValue){
		FormField field = deliveryTimeFromConsumerOrderDelivery(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderDeliveryForm deliveryTimeField(String initValue){
		return deliveryTimeField("deliveryTime",initValue);
	}
	public ConsumerOrderDeliveryForm deliveryTimeField(){
		return deliveryTimeField("deliveryTime","");
	}

	
	

	


	



	public ConsumerOrderDeliveryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



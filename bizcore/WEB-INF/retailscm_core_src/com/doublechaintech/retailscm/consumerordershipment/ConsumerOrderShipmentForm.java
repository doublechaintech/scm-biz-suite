package com.doublechaintech.retailscm.consumerordershipment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderShipmentForm extends BaseForm {
	
	
	public ConsumerOrderShipmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderShipmentForm consumerOrderShipmentIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShipmentForm consumerOrderShipmentIdField(String initValue){
		return consumerOrderShipmentIdField("consumerOrderShipmentId",initValue);
	}
	public ConsumerOrderShipmentForm consumerOrderShipmentIdField(){
		return consumerOrderShipmentIdField("consumerOrderShipmentId","");
	}


	public ConsumerOrderShipmentForm whoField(String parameterName, String initValue){
		FormField field = whoFromConsumerOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShipmentForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ConsumerOrderShipmentForm whoField(){
		return whoField("who","");
	}


	public ConsumerOrderShipmentForm shipTimeField(String parameterName, String initValue){
		FormField field = shipTimeFromConsumerOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShipmentForm shipTimeField(String initValue){
		return shipTimeField("shipTime",initValue);
	}
	public ConsumerOrderShipmentForm shipTimeField(){
		return shipTimeField("shipTime","");
	}

	
	

	


	



	public ConsumerOrderShipmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



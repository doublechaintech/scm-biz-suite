package com.doublechaintech.retailscm.consumerorderpaymentgroup;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderPaymentGroupForm extends BaseForm {
	
	
	public ConsumerOrderPaymentGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderPaymentGroupForm consumerOrderPaymentGroupIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm consumerOrderPaymentGroupIdField(String initValue){
		return consumerOrderPaymentGroupIdField("consumerOrderPaymentGroupId",initValue);
	}
	public ConsumerOrderPaymentGroupForm consumerOrderPaymentGroupIdField(){
		return consumerOrderPaymentGroupIdField("consumerOrderPaymentGroupId","");
	}


	public ConsumerOrderPaymentGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ConsumerOrderPaymentGroupForm nameField(){
		return nameField("name","");
	}


	public ConsumerOrderPaymentGroupForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public ConsumerOrderPaymentGroupForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public ConsumerOrderPaymentGroupForm cardNumberField(String parameterName, String initValue){
		FormField field = cardNumberFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm cardNumberField(String initValue){
		return cardNumberField("cardNumber",initValue);
	}
	public ConsumerOrderPaymentGroupForm cardNumberField(){
		return cardNumberField("cardNumber","");
	}

	
	


	public ConsumerOrderPaymentGroupForm consumerOrderIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm consumerOrderIdFieldOfConsumerOrder(String initValue){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId",initValue);
	}
	public ConsumerOrderPaymentGroupForm consumerOrderIdFieldOfConsumerOrder(){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId","");
	}


	public ConsumerOrderPaymentGroupForm titleFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm titleFieldOfConsumerOrder(String initValue){
		return titleFieldOfConsumerOrder("title",initValue);
	}
	public ConsumerOrderPaymentGroupForm titleFieldOfConsumerOrder(){
		return titleFieldOfConsumerOrder("title","");
	}


	public ConsumerOrderPaymentGroupForm consumerIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm consumerIdFieldOfConsumerOrder(String initValue){
		return consumerIdFieldOfConsumerOrder("consumerId",initValue);
	}
	public ConsumerOrderPaymentGroupForm consumerIdFieldOfConsumerOrder(){
		return consumerIdFieldOfConsumerOrder("consumerId","");
	}


	public ConsumerOrderPaymentGroupForm confirmationIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm confirmationIdFieldOfConsumerOrder(String initValue){
		return confirmationIdFieldOfConsumerOrder("confirmationId",initValue);
	}
	public ConsumerOrderPaymentGroupForm confirmationIdFieldOfConsumerOrder(){
		return confirmationIdFieldOfConsumerOrder("confirmationId","");
	}


	public ConsumerOrderPaymentGroupForm approvalIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm approvalIdFieldOfConsumerOrder(String initValue){
		return approvalIdFieldOfConsumerOrder("approvalId",initValue);
	}
	public ConsumerOrderPaymentGroupForm approvalIdFieldOfConsumerOrder(){
		return approvalIdFieldOfConsumerOrder("approvalId","");
	}


	public ConsumerOrderPaymentGroupForm processingIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm processingIdFieldOfConsumerOrder(String initValue){
		return processingIdFieldOfConsumerOrder("processingId",initValue);
	}
	public ConsumerOrderPaymentGroupForm processingIdFieldOfConsumerOrder(){
		return processingIdFieldOfConsumerOrder("processingId","");
	}


	public ConsumerOrderPaymentGroupForm shipmentIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm shipmentIdFieldOfConsumerOrder(String initValue){
		return shipmentIdFieldOfConsumerOrder("shipmentId",initValue);
	}
	public ConsumerOrderPaymentGroupForm shipmentIdFieldOfConsumerOrder(){
		return shipmentIdFieldOfConsumerOrder("shipmentId","");
	}


	public ConsumerOrderPaymentGroupForm deliveryIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm deliveryIdFieldOfConsumerOrder(String initValue){
		return deliveryIdFieldOfConsumerOrder("deliveryId",initValue);
	}
	public ConsumerOrderPaymentGroupForm deliveryIdFieldOfConsumerOrder(){
		return deliveryIdFieldOfConsumerOrder("deliveryId","");
	}


	public ConsumerOrderPaymentGroupForm storeIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm storeIdFieldOfConsumerOrder(String initValue){
		return storeIdFieldOfConsumerOrder("storeId",initValue);
	}
	public ConsumerOrderPaymentGroupForm storeIdFieldOfConsumerOrder(){
		return storeIdFieldOfConsumerOrder("storeId","");
	}


	public ConsumerOrderPaymentGroupForm lastUpdateTimeFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm lastUpdateTimeFieldOfConsumerOrder(String initValue){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime",initValue);
	}
	public ConsumerOrderPaymentGroupForm lastUpdateTimeFieldOfConsumerOrder(){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime","");
	}


	public ConsumerOrderPaymentGroupForm currentStatusFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPaymentGroupForm currentStatusFieldOfConsumerOrder(String initValue){
		return currentStatusFieldOfConsumerOrder("currentStatus",initValue);
	}
	public ConsumerOrderPaymentGroupForm currentStatusFieldOfConsumerOrder(){
		return currentStatusFieldOfConsumerOrder("currentStatus","");
	}

	


	

	
 	public ConsumerOrderPaymentGroupForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/consumerOrderPaymentGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public ConsumerOrderPaymentGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



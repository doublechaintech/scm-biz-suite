package com.doublechaintech.retailscm.consumerordershippinggroup;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderShippingGroupForm extends BaseForm {
	
	
	public ConsumerOrderShippingGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderShippingGroupForm consumerOrderShippingGroupIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShippingGroupForm consumerOrderShippingGroupIdField(String initValue){
		return consumerOrderShippingGroupIdField("consumerOrderShippingGroupId",initValue);
	}
	public ConsumerOrderShippingGroupForm consumerOrderShippingGroupIdField(){
		return consumerOrderShippingGroupIdField("consumerOrderShippingGroupId","");
	}


	public ConsumerOrderShippingGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShippingGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ConsumerOrderShippingGroupForm nameField(){
		return nameField("name","");
	}


	public ConsumerOrderShippingGroupForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShippingGroupForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public ConsumerOrderShippingGroupForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public ConsumerOrderShippingGroupForm amountField(String parameterName, String initValue){
		FormField field = amountFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderShippingGroupForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public ConsumerOrderShippingGroupForm amountField(){
		return amountField("amount","");
	}

	
	


	public ConsumerOrderShippingGroupForm consumerOrderIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm consumerOrderIdFieldOfConsumerOrder(String initValue){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId",initValue);
	}
	public ConsumerOrderShippingGroupForm consumerOrderIdFieldOfConsumerOrder(){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId","");
	}


	public ConsumerOrderShippingGroupForm titleFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm titleFieldOfConsumerOrder(String initValue){
		return titleFieldOfConsumerOrder("title",initValue);
	}
	public ConsumerOrderShippingGroupForm titleFieldOfConsumerOrder(){
		return titleFieldOfConsumerOrder("title","");
	}


	public ConsumerOrderShippingGroupForm consumerIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm consumerIdFieldOfConsumerOrder(String initValue){
		return consumerIdFieldOfConsumerOrder("consumerId",initValue);
	}
	public ConsumerOrderShippingGroupForm consumerIdFieldOfConsumerOrder(){
		return consumerIdFieldOfConsumerOrder("consumerId","");
	}


	public ConsumerOrderShippingGroupForm confirmationIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm confirmationIdFieldOfConsumerOrder(String initValue){
		return confirmationIdFieldOfConsumerOrder("confirmationId",initValue);
	}
	public ConsumerOrderShippingGroupForm confirmationIdFieldOfConsumerOrder(){
		return confirmationIdFieldOfConsumerOrder("confirmationId","");
	}


	public ConsumerOrderShippingGroupForm approvalIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm approvalIdFieldOfConsumerOrder(String initValue){
		return approvalIdFieldOfConsumerOrder("approvalId",initValue);
	}
	public ConsumerOrderShippingGroupForm approvalIdFieldOfConsumerOrder(){
		return approvalIdFieldOfConsumerOrder("approvalId","");
	}


	public ConsumerOrderShippingGroupForm processingIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm processingIdFieldOfConsumerOrder(String initValue){
		return processingIdFieldOfConsumerOrder("processingId",initValue);
	}
	public ConsumerOrderShippingGroupForm processingIdFieldOfConsumerOrder(){
		return processingIdFieldOfConsumerOrder("processingId","");
	}


	public ConsumerOrderShippingGroupForm shipmentIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm shipmentIdFieldOfConsumerOrder(String initValue){
		return shipmentIdFieldOfConsumerOrder("shipmentId",initValue);
	}
	public ConsumerOrderShippingGroupForm shipmentIdFieldOfConsumerOrder(){
		return shipmentIdFieldOfConsumerOrder("shipmentId","");
	}


	public ConsumerOrderShippingGroupForm deliveryIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm deliveryIdFieldOfConsumerOrder(String initValue){
		return deliveryIdFieldOfConsumerOrder("deliveryId",initValue);
	}
	public ConsumerOrderShippingGroupForm deliveryIdFieldOfConsumerOrder(){
		return deliveryIdFieldOfConsumerOrder("deliveryId","");
	}


	public ConsumerOrderShippingGroupForm storeIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm storeIdFieldOfConsumerOrder(String initValue){
		return storeIdFieldOfConsumerOrder("storeId",initValue);
	}
	public ConsumerOrderShippingGroupForm storeIdFieldOfConsumerOrder(){
		return storeIdFieldOfConsumerOrder("storeId","");
	}


	public ConsumerOrderShippingGroupForm lastUpdateTimeFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm lastUpdateTimeFieldOfConsumerOrder(String initValue){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime",initValue);
	}
	public ConsumerOrderShippingGroupForm lastUpdateTimeFieldOfConsumerOrder(){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime","");
	}


	public ConsumerOrderShippingGroupForm currentStatusFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderShippingGroupForm currentStatusFieldOfConsumerOrder(String initValue){
		return currentStatusFieldOfConsumerOrder("currentStatus",initValue);
	}
	public ConsumerOrderShippingGroupForm currentStatusFieldOfConsumerOrder(){
		return currentStatusFieldOfConsumerOrder("currentStatus","");
	}

	


	

	
 	public ConsumerOrderShippingGroupForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/consumerOrderShippingGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public ConsumerOrderShippingGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



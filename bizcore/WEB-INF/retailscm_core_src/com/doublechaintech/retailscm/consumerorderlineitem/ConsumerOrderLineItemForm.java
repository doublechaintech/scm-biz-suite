package com.doublechaintech.retailscm.consumerorderlineitem;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderLineItemForm extends BaseForm {
	
	
	public ConsumerOrderLineItemForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderLineItemForm consumerOrderLineItemIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm consumerOrderLineItemIdField(String initValue){
		return consumerOrderLineItemIdField("consumerOrderLineItemId",initValue);
	}
	public ConsumerOrderLineItemForm consumerOrderLineItemIdField(){
		return consumerOrderLineItemIdField("consumerOrderLineItemId","");
	}


	public ConsumerOrderLineItemForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public ConsumerOrderLineItemForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public ConsumerOrderLineItemForm skuIdField(String parameterName, String initValue){
		FormField field = skuIdFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm skuIdField(String initValue){
		return skuIdField("skuId",initValue);
	}
	public ConsumerOrderLineItemForm skuIdField(){
		return skuIdField("skuId","");
	}


	public ConsumerOrderLineItemForm skuNameField(String parameterName, String initValue){
		FormField field = skuNameFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm skuNameField(String initValue){
		return skuNameField("skuName",initValue);
	}
	public ConsumerOrderLineItemForm skuNameField(){
		return skuNameField("skuName","");
	}


	public ConsumerOrderLineItemForm priceField(String parameterName, String initValue){
		FormField field = priceFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm priceField(String initValue){
		return priceField("price",initValue);
	}
	public ConsumerOrderLineItemForm priceField(){
		return priceField("price","");
	}


	public ConsumerOrderLineItemForm quantityField(String parameterName, String initValue){
		FormField field = quantityFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm quantityField(String initValue){
		return quantityField("quantity",initValue);
	}
	public ConsumerOrderLineItemForm quantityField(){
		return quantityField("quantity","");
	}


	public ConsumerOrderLineItemForm amountField(String parameterName, String initValue){
		FormField field = amountFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderLineItemForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public ConsumerOrderLineItemForm amountField(){
		return amountField("amount","");
	}

	
	


	public ConsumerOrderLineItemForm consumerOrderIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm consumerOrderIdFieldOfConsumerOrder(String initValue){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId",initValue);
	}
	public ConsumerOrderLineItemForm consumerOrderIdFieldOfConsumerOrder(){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId","");
	}


	public ConsumerOrderLineItemForm titleFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm titleFieldOfConsumerOrder(String initValue){
		return titleFieldOfConsumerOrder("title",initValue);
	}
	public ConsumerOrderLineItemForm titleFieldOfConsumerOrder(){
		return titleFieldOfConsumerOrder("title","");
	}


	public ConsumerOrderLineItemForm consumerIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm consumerIdFieldOfConsumerOrder(String initValue){
		return consumerIdFieldOfConsumerOrder("consumerId",initValue);
	}
	public ConsumerOrderLineItemForm consumerIdFieldOfConsumerOrder(){
		return consumerIdFieldOfConsumerOrder("consumerId","");
	}


	public ConsumerOrderLineItemForm confirmationIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm confirmationIdFieldOfConsumerOrder(String initValue){
		return confirmationIdFieldOfConsumerOrder("confirmationId",initValue);
	}
	public ConsumerOrderLineItemForm confirmationIdFieldOfConsumerOrder(){
		return confirmationIdFieldOfConsumerOrder("confirmationId","");
	}


	public ConsumerOrderLineItemForm approvalIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm approvalIdFieldOfConsumerOrder(String initValue){
		return approvalIdFieldOfConsumerOrder("approvalId",initValue);
	}
	public ConsumerOrderLineItemForm approvalIdFieldOfConsumerOrder(){
		return approvalIdFieldOfConsumerOrder("approvalId","");
	}


	public ConsumerOrderLineItemForm processingIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm processingIdFieldOfConsumerOrder(String initValue){
		return processingIdFieldOfConsumerOrder("processingId",initValue);
	}
	public ConsumerOrderLineItemForm processingIdFieldOfConsumerOrder(){
		return processingIdFieldOfConsumerOrder("processingId","");
	}


	public ConsumerOrderLineItemForm shipmentIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm shipmentIdFieldOfConsumerOrder(String initValue){
		return shipmentIdFieldOfConsumerOrder("shipmentId",initValue);
	}
	public ConsumerOrderLineItemForm shipmentIdFieldOfConsumerOrder(){
		return shipmentIdFieldOfConsumerOrder("shipmentId","");
	}


	public ConsumerOrderLineItemForm deliveryIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm deliveryIdFieldOfConsumerOrder(String initValue){
		return deliveryIdFieldOfConsumerOrder("deliveryId",initValue);
	}
	public ConsumerOrderLineItemForm deliveryIdFieldOfConsumerOrder(){
		return deliveryIdFieldOfConsumerOrder("deliveryId","");
	}


	public ConsumerOrderLineItemForm storeIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm storeIdFieldOfConsumerOrder(String initValue){
		return storeIdFieldOfConsumerOrder("storeId",initValue);
	}
	public ConsumerOrderLineItemForm storeIdFieldOfConsumerOrder(){
		return storeIdFieldOfConsumerOrder("storeId","");
	}


	public ConsumerOrderLineItemForm lastUpdateTimeFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm lastUpdateTimeFieldOfConsumerOrder(String initValue){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime",initValue);
	}
	public ConsumerOrderLineItemForm lastUpdateTimeFieldOfConsumerOrder(){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime","");
	}


	public ConsumerOrderLineItemForm currentStatusFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderLineItemForm currentStatusFieldOfConsumerOrder(String initValue){
		return currentStatusFieldOfConsumerOrder("currentStatus",initValue);
	}
	public ConsumerOrderLineItemForm currentStatusFieldOfConsumerOrder(){
		return currentStatusFieldOfConsumerOrder("currentStatus","");
	}

	


	

	
 	public ConsumerOrderLineItemForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/consumerOrderLineItemId/");
		this.addFormAction(action);
		return this;
	}

 

	public ConsumerOrderLineItemForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.consumerorderpriceadjustment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderPriceAdjustmentForm extends BaseForm {
	
	
	public ConsumerOrderPriceAdjustmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderPriceAdjustmentForm consumerOrderPriceAdjustmentIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm consumerOrderPriceAdjustmentIdField(String initValue){
		return consumerOrderPriceAdjustmentIdField("consumerOrderPriceAdjustmentId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm consumerOrderPriceAdjustmentIdField(){
		return consumerOrderPriceAdjustmentIdField("consumerOrderPriceAdjustmentId","");
	}


	public ConsumerOrderPriceAdjustmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm nameField(){
		return nameField("name","");
	}


	public ConsumerOrderPriceAdjustmentForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public ConsumerOrderPriceAdjustmentForm amountField(String parameterName, String initValue){
		FormField field = amountFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm amountField(){
		return amountField("amount","");
	}


	public ConsumerOrderPriceAdjustmentForm providerField(String parameterName, String initValue){
		FormField field = providerFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm providerField(String initValue){
		return providerField("provider",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm providerField(){
		return providerField("provider","");
	}

	
	


	public ConsumerOrderPriceAdjustmentForm consumerOrderIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm consumerOrderIdFieldOfConsumerOrder(String initValue){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm consumerOrderIdFieldOfConsumerOrder(){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId","");
	}


	public ConsumerOrderPriceAdjustmentForm titleFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm titleFieldOfConsumerOrder(String initValue){
		return titleFieldOfConsumerOrder("title",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm titleFieldOfConsumerOrder(){
		return titleFieldOfConsumerOrder("title","");
	}


	public ConsumerOrderPriceAdjustmentForm consumerIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm consumerIdFieldOfConsumerOrder(String initValue){
		return consumerIdFieldOfConsumerOrder("consumerId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm consumerIdFieldOfConsumerOrder(){
		return consumerIdFieldOfConsumerOrder("consumerId","");
	}


	public ConsumerOrderPriceAdjustmentForm confirmationIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm confirmationIdFieldOfConsumerOrder(String initValue){
		return confirmationIdFieldOfConsumerOrder("confirmationId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm confirmationIdFieldOfConsumerOrder(){
		return confirmationIdFieldOfConsumerOrder("confirmationId","");
	}


	public ConsumerOrderPriceAdjustmentForm approvalIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm approvalIdFieldOfConsumerOrder(String initValue){
		return approvalIdFieldOfConsumerOrder("approvalId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm approvalIdFieldOfConsumerOrder(){
		return approvalIdFieldOfConsumerOrder("approvalId","");
	}


	public ConsumerOrderPriceAdjustmentForm processingIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm processingIdFieldOfConsumerOrder(String initValue){
		return processingIdFieldOfConsumerOrder("processingId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm processingIdFieldOfConsumerOrder(){
		return processingIdFieldOfConsumerOrder("processingId","");
	}


	public ConsumerOrderPriceAdjustmentForm shipmentIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm shipmentIdFieldOfConsumerOrder(String initValue){
		return shipmentIdFieldOfConsumerOrder("shipmentId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm shipmentIdFieldOfConsumerOrder(){
		return shipmentIdFieldOfConsumerOrder("shipmentId","");
	}


	public ConsumerOrderPriceAdjustmentForm deliveryIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm deliveryIdFieldOfConsumerOrder(String initValue){
		return deliveryIdFieldOfConsumerOrder("deliveryId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm deliveryIdFieldOfConsumerOrder(){
		return deliveryIdFieldOfConsumerOrder("deliveryId","");
	}


	public ConsumerOrderPriceAdjustmentForm storeIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm storeIdFieldOfConsumerOrder(String initValue){
		return storeIdFieldOfConsumerOrder("storeId",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm storeIdFieldOfConsumerOrder(){
		return storeIdFieldOfConsumerOrder("storeId","");
	}


	public ConsumerOrderPriceAdjustmentForm lastUpdateTimeFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm lastUpdateTimeFieldOfConsumerOrder(String initValue){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm lastUpdateTimeFieldOfConsumerOrder(){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime","");
	}


	public ConsumerOrderPriceAdjustmentForm currentStatusFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderPriceAdjustmentForm currentStatusFieldOfConsumerOrder(String initValue){
		return currentStatusFieldOfConsumerOrder("currentStatus",initValue);
	}
	public ConsumerOrderPriceAdjustmentForm currentStatusFieldOfConsumerOrder(){
		return currentStatusFieldOfConsumerOrder("currentStatus","");
	}

	


	

	
 	public ConsumerOrderPriceAdjustmentForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/consumerOrderPriceAdjustmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public ConsumerOrderPriceAdjustmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



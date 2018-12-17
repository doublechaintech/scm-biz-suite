package com.doublechaintech.retailscm.supplyorderprocessing;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderProcessingForm extends BaseForm {
	
	
	public SupplyOrderProcessingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderProcessingForm supplyOrderProcessingIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm supplyOrderProcessingIdField(String initValue){
		return supplyOrderProcessingIdField("supplyOrderProcessingId",initValue);
	}
	public SupplyOrderProcessingForm supplyOrderProcessingIdField(){
		return supplyOrderProcessingIdField("supplyOrderProcessingId","");
	}


	public SupplyOrderProcessingForm whoField(String parameterName, String initValue){
		FormField field = whoFromSupplyOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public SupplyOrderProcessingForm whoField(){
		return whoField("who","");
	}


	public SupplyOrderProcessingForm processTimeField(String parameterName, String initValue){
		FormField field = processTimeFromSupplyOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm processTimeField(String initValue){
		return processTimeField("processTime",initValue);
	}
	public SupplyOrderProcessingForm processTimeField(){
		return processTimeField("processTime","");
	}

	
	

	



	public SupplyOrderProcessingForm consumerOrderIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm consumerOrderIdFieldForConsumerOrder(String initValue){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId",initValue);
	}
	public SupplyOrderProcessingForm consumerOrderIdFieldForConsumerOrder(){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId","");
	}


	public SupplyOrderProcessingForm titleFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm titleFieldForConsumerOrder(String initValue){
		return titleFieldForConsumerOrder("title",initValue);
	}
	public SupplyOrderProcessingForm titleFieldForConsumerOrder(){
		return titleFieldForConsumerOrder("title","");
	}


	public SupplyOrderProcessingForm consumerIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm consumerIdFieldForConsumerOrder(String initValue){
		return consumerIdFieldForConsumerOrder("consumerId",initValue);
	}
	public SupplyOrderProcessingForm consumerIdFieldForConsumerOrder(){
		return consumerIdFieldForConsumerOrder("consumerId","");
	}


	public SupplyOrderProcessingForm confirmationIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm confirmationIdFieldForConsumerOrder(String initValue){
		return confirmationIdFieldForConsumerOrder("confirmationId",initValue);
	}
	public SupplyOrderProcessingForm confirmationIdFieldForConsumerOrder(){
		return confirmationIdFieldForConsumerOrder("confirmationId","");
	}


	public SupplyOrderProcessingForm approvalIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm approvalIdFieldForConsumerOrder(String initValue){
		return approvalIdFieldForConsumerOrder("approvalId",initValue);
	}
	public SupplyOrderProcessingForm approvalIdFieldForConsumerOrder(){
		return approvalIdFieldForConsumerOrder("approvalId","");
	}


	public SupplyOrderProcessingForm processingIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm processingIdFieldForConsumerOrder(String initValue){
		return processingIdFieldForConsumerOrder("processingId",initValue);
	}
	public SupplyOrderProcessingForm processingIdFieldForConsumerOrder(){
		return processingIdFieldForConsumerOrder("processingId","");
	}


	public SupplyOrderProcessingForm shipmentIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm shipmentIdFieldForConsumerOrder(String initValue){
		return shipmentIdFieldForConsumerOrder("shipmentId",initValue);
	}
	public SupplyOrderProcessingForm shipmentIdFieldForConsumerOrder(){
		return shipmentIdFieldForConsumerOrder("shipmentId","");
	}


	public SupplyOrderProcessingForm deliveryIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm deliveryIdFieldForConsumerOrder(String initValue){
		return deliveryIdFieldForConsumerOrder("deliveryId",initValue);
	}
	public SupplyOrderProcessingForm deliveryIdFieldForConsumerOrder(){
		return deliveryIdFieldForConsumerOrder("deliveryId","");
	}


	public SupplyOrderProcessingForm storeIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm storeIdFieldForConsumerOrder(String initValue){
		return storeIdFieldForConsumerOrder("storeId",initValue);
	}
	public SupplyOrderProcessingForm storeIdFieldForConsumerOrder(){
		return storeIdFieldForConsumerOrder("storeId","");
	}


	public SupplyOrderProcessingForm lastUpdateTimeFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm lastUpdateTimeFieldForConsumerOrder(String initValue){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderProcessingForm lastUpdateTimeFieldForConsumerOrder(){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime","");
	}


	public SupplyOrderProcessingForm currentStatusFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm currentStatusFieldForConsumerOrder(String initValue){
		return currentStatusFieldForConsumerOrder("currentStatus",initValue);
	}
	public SupplyOrderProcessingForm currentStatusFieldForConsumerOrder(){
		return currentStatusFieldForConsumerOrder("currentStatus","");
	}


	public SupplyOrderProcessingForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderProcessingForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderProcessingForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderProcessingForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public SupplyOrderProcessingForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderProcessingForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public SupplyOrderProcessingForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public SupplyOrderProcessingForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public SupplyOrderProcessingForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderProcessingForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public SupplyOrderProcessingForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderProcessingForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public SupplyOrderProcessingForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderProcessingForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public SupplyOrderProcessingForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public SupplyOrderProcessingForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public SupplyOrderProcessingForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderProcessingForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public SupplyOrderProcessingForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderProcessingForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public SupplyOrderProcessingForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderProcessingForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public SupplyOrderProcessingForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderProcessingForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderProcessingForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderProcessingForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderProcessingForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}

	



	public SupplyOrderProcessingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



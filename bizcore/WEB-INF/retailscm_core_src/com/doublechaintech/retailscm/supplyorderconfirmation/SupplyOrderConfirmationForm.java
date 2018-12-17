package com.doublechaintech.retailscm.supplyorderconfirmation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderConfirmationForm extends BaseForm {
	
	
	public SupplyOrderConfirmationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderConfirmationForm supplyOrderConfirmationIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm supplyOrderConfirmationIdField(String initValue){
		return supplyOrderConfirmationIdField("supplyOrderConfirmationId",initValue);
	}
	public SupplyOrderConfirmationForm supplyOrderConfirmationIdField(){
		return supplyOrderConfirmationIdField("supplyOrderConfirmationId","");
	}


	public SupplyOrderConfirmationForm whoField(String parameterName, String initValue){
		FormField field = whoFromSupplyOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public SupplyOrderConfirmationForm whoField(){
		return whoField("who","");
	}


	public SupplyOrderConfirmationForm confirmTimeField(String parameterName, String initValue){
		FormField field = confirmTimeFromSupplyOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm confirmTimeField(String initValue){
		return confirmTimeField("confirmTime",initValue);
	}
	public SupplyOrderConfirmationForm confirmTimeField(){
		return confirmTimeField("confirmTime","");
	}

	
	

	



	public SupplyOrderConfirmationForm consumerOrderIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm consumerOrderIdFieldForConsumerOrder(String initValue){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId",initValue);
	}
	public SupplyOrderConfirmationForm consumerOrderIdFieldForConsumerOrder(){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId","");
	}


	public SupplyOrderConfirmationForm titleFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm titleFieldForConsumerOrder(String initValue){
		return titleFieldForConsumerOrder("title",initValue);
	}
	public SupplyOrderConfirmationForm titleFieldForConsumerOrder(){
		return titleFieldForConsumerOrder("title","");
	}


	public SupplyOrderConfirmationForm consumerIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm consumerIdFieldForConsumerOrder(String initValue){
		return consumerIdFieldForConsumerOrder("consumerId",initValue);
	}
	public SupplyOrderConfirmationForm consumerIdFieldForConsumerOrder(){
		return consumerIdFieldForConsumerOrder("consumerId","");
	}


	public SupplyOrderConfirmationForm confirmationIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm confirmationIdFieldForConsumerOrder(String initValue){
		return confirmationIdFieldForConsumerOrder("confirmationId",initValue);
	}
	public SupplyOrderConfirmationForm confirmationIdFieldForConsumerOrder(){
		return confirmationIdFieldForConsumerOrder("confirmationId","");
	}


	public SupplyOrderConfirmationForm approvalIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm approvalIdFieldForConsumerOrder(String initValue){
		return approvalIdFieldForConsumerOrder("approvalId",initValue);
	}
	public SupplyOrderConfirmationForm approvalIdFieldForConsumerOrder(){
		return approvalIdFieldForConsumerOrder("approvalId","");
	}


	public SupplyOrderConfirmationForm processingIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm processingIdFieldForConsumerOrder(String initValue){
		return processingIdFieldForConsumerOrder("processingId",initValue);
	}
	public SupplyOrderConfirmationForm processingIdFieldForConsumerOrder(){
		return processingIdFieldForConsumerOrder("processingId","");
	}


	public SupplyOrderConfirmationForm shipmentIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm shipmentIdFieldForConsumerOrder(String initValue){
		return shipmentIdFieldForConsumerOrder("shipmentId",initValue);
	}
	public SupplyOrderConfirmationForm shipmentIdFieldForConsumerOrder(){
		return shipmentIdFieldForConsumerOrder("shipmentId","");
	}


	public SupplyOrderConfirmationForm deliveryIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm deliveryIdFieldForConsumerOrder(String initValue){
		return deliveryIdFieldForConsumerOrder("deliveryId",initValue);
	}
	public SupplyOrderConfirmationForm deliveryIdFieldForConsumerOrder(){
		return deliveryIdFieldForConsumerOrder("deliveryId","");
	}


	public SupplyOrderConfirmationForm storeIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm storeIdFieldForConsumerOrder(String initValue){
		return storeIdFieldForConsumerOrder("storeId",initValue);
	}
	public SupplyOrderConfirmationForm storeIdFieldForConsumerOrder(){
		return storeIdFieldForConsumerOrder("storeId","");
	}


	public SupplyOrderConfirmationForm lastUpdateTimeFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm lastUpdateTimeFieldForConsumerOrder(String initValue){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderConfirmationForm lastUpdateTimeFieldForConsumerOrder(){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime","");
	}


	public SupplyOrderConfirmationForm currentStatusFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm currentStatusFieldForConsumerOrder(String initValue){
		return currentStatusFieldForConsumerOrder("currentStatus",initValue);
	}
	public SupplyOrderConfirmationForm currentStatusFieldForConsumerOrder(){
		return currentStatusFieldForConsumerOrder("currentStatus","");
	}


	public SupplyOrderConfirmationForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderConfirmationForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderConfirmationForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderConfirmationForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public SupplyOrderConfirmationForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderConfirmationForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public SupplyOrderConfirmationForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public SupplyOrderConfirmationForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public SupplyOrderConfirmationForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderConfirmationForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public SupplyOrderConfirmationForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderConfirmationForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public SupplyOrderConfirmationForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderConfirmationForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public SupplyOrderConfirmationForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public SupplyOrderConfirmationForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public SupplyOrderConfirmationForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderConfirmationForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public SupplyOrderConfirmationForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderConfirmationForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public SupplyOrderConfirmationForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderConfirmationForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public SupplyOrderConfirmationForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderConfirmationForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderConfirmationForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderConfirmationForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderConfirmationForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}

	



	public SupplyOrderConfirmationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.retailstoreorderprocessing;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderProcessingForm extends BaseForm {
	
	
	public RetailStoreOrderProcessingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderProcessingForm retailStoreOrderProcessingIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm retailStoreOrderProcessingIdField(String initValue){
		return retailStoreOrderProcessingIdField("retailStoreOrderProcessingId",initValue);
	}
	public RetailStoreOrderProcessingForm retailStoreOrderProcessingIdField(){
		return retailStoreOrderProcessingIdField("retailStoreOrderProcessingId","");
	}


	public RetailStoreOrderProcessingForm whoField(String parameterName, String initValue){
		FormField field = whoFromRetailStoreOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public RetailStoreOrderProcessingForm whoField(){
		return whoField("who","");
	}


	public RetailStoreOrderProcessingForm processTimeField(String parameterName, String initValue){
		FormField field = processTimeFromRetailStoreOrderProcessing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm processTimeField(String initValue){
		return processTimeField("processTime",initValue);
	}
	public RetailStoreOrderProcessingForm processTimeField(){
		return processTimeField("processTime","");
	}

	
	

	



	public RetailStoreOrderProcessingForm retailStoreOrderIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm retailStoreOrderIdFieldForRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderProcessingForm retailStoreOrderIdFieldForRetailStoreOrder(){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderProcessingForm buyerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm buyerIdFieldForRetailStoreOrder(String initValue){
		return buyerIdFieldForRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderProcessingForm buyerIdFieldForRetailStoreOrder(){
		return buyerIdFieldForRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderProcessingForm sellerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm sellerIdFieldForRetailStoreOrder(String initValue){
		return sellerIdFieldForRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderProcessingForm sellerIdFieldForRetailStoreOrder(){
		return sellerIdFieldForRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderProcessingForm titleFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm titleFieldForRetailStoreOrder(String initValue){
		return titleFieldForRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderProcessingForm titleFieldForRetailStoreOrder(){
		return titleFieldForRetailStoreOrder("title","");
	}


	public RetailStoreOrderProcessingForm totalAmountFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm totalAmountFieldForRetailStoreOrder(String initValue){
		return totalAmountFieldForRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderProcessingForm totalAmountFieldForRetailStoreOrder(){
		return totalAmountFieldForRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderProcessingForm confirmationIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm confirmationIdFieldForRetailStoreOrder(String initValue){
		return confirmationIdFieldForRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderProcessingForm confirmationIdFieldForRetailStoreOrder(){
		return confirmationIdFieldForRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderProcessingForm approvalIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm approvalIdFieldForRetailStoreOrder(String initValue){
		return approvalIdFieldForRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderProcessingForm approvalIdFieldForRetailStoreOrder(){
		return approvalIdFieldForRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderProcessingForm processingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm processingIdFieldForRetailStoreOrder(String initValue){
		return processingIdFieldForRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderProcessingForm processingIdFieldForRetailStoreOrder(){
		return processingIdFieldForRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderProcessingForm pickingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm pickingIdFieldForRetailStoreOrder(String initValue){
		return pickingIdFieldForRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderProcessingForm pickingIdFieldForRetailStoreOrder(){
		return pickingIdFieldForRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderProcessingForm shipmentIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm shipmentIdFieldForRetailStoreOrder(String initValue){
		return shipmentIdFieldForRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderProcessingForm shipmentIdFieldForRetailStoreOrder(){
		return shipmentIdFieldForRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderProcessingForm deliveryIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm deliveryIdFieldForRetailStoreOrder(String initValue){
		return deliveryIdFieldForRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderProcessingForm deliveryIdFieldForRetailStoreOrder(){
		return deliveryIdFieldForRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderProcessingForm lastUpdateTimeFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm lastUpdateTimeFieldForRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderProcessingForm lastUpdateTimeFieldForRetailStoreOrder(){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderProcessingForm currentStatusFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderProcessingForm currentStatusFieldForRetailStoreOrder(String initValue){
		return currentStatusFieldForRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderProcessingForm currentStatusFieldForRetailStoreOrder(){
		return currentStatusFieldForRetailStoreOrder("currentStatus","");
	}

	



	public RetailStoreOrderProcessingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



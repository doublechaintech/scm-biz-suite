package com.doublechaintech.retailscm.retailstoreorderconfirmation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderConfirmationForm extends BaseForm {
	
	
	public RetailStoreOrderConfirmationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderConfirmationForm retailStoreOrderConfirmationIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm retailStoreOrderConfirmationIdField(String initValue){
		return retailStoreOrderConfirmationIdField("retailStoreOrderConfirmationId",initValue);
	}
	public RetailStoreOrderConfirmationForm retailStoreOrderConfirmationIdField(){
		return retailStoreOrderConfirmationIdField("retailStoreOrderConfirmationId","");
	}


	public RetailStoreOrderConfirmationForm whoField(String parameterName, String initValue){
		FormField field = whoFromRetailStoreOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public RetailStoreOrderConfirmationForm whoField(){
		return whoField("who","");
	}


	public RetailStoreOrderConfirmationForm confirmTimeField(String parameterName, String initValue){
		FormField field = confirmTimeFromRetailStoreOrderConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm confirmTimeField(String initValue){
		return confirmTimeField("confirmTime",initValue);
	}
	public RetailStoreOrderConfirmationForm confirmTimeField(){
		return confirmTimeField("confirmTime","");
	}

	
	

	



	public RetailStoreOrderConfirmationForm retailStoreOrderIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm retailStoreOrderIdFieldForRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderConfirmationForm retailStoreOrderIdFieldForRetailStoreOrder(){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderConfirmationForm buyerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm buyerIdFieldForRetailStoreOrder(String initValue){
		return buyerIdFieldForRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderConfirmationForm buyerIdFieldForRetailStoreOrder(){
		return buyerIdFieldForRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderConfirmationForm sellerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm sellerIdFieldForRetailStoreOrder(String initValue){
		return sellerIdFieldForRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderConfirmationForm sellerIdFieldForRetailStoreOrder(){
		return sellerIdFieldForRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderConfirmationForm titleFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm titleFieldForRetailStoreOrder(String initValue){
		return titleFieldForRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderConfirmationForm titleFieldForRetailStoreOrder(){
		return titleFieldForRetailStoreOrder("title","");
	}


	public RetailStoreOrderConfirmationForm totalAmountFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm totalAmountFieldForRetailStoreOrder(String initValue){
		return totalAmountFieldForRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderConfirmationForm totalAmountFieldForRetailStoreOrder(){
		return totalAmountFieldForRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderConfirmationForm confirmationIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm confirmationIdFieldForRetailStoreOrder(String initValue){
		return confirmationIdFieldForRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderConfirmationForm confirmationIdFieldForRetailStoreOrder(){
		return confirmationIdFieldForRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderConfirmationForm approvalIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm approvalIdFieldForRetailStoreOrder(String initValue){
		return approvalIdFieldForRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderConfirmationForm approvalIdFieldForRetailStoreOrder(){
		return approvalIdFieldForRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderConfirmationForm processingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm processingIdFieldForRetailStoreOrder(String initValue){
		return processingIdFieldForRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderConfirmationForm processingIdFieldForRetailStoreOrder(){
		return processingIdFieldForRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderConfirmationForm pickingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm pickingIdFieldForRetailStoreOrder(String initValue){
		return pickingIdFieldForRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderConfirmationForm pickingIdFieldForRetailStoreOrder(){
		return pickingIdFieldForRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderConfirmationForm shipmentIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm shipmentIdFieldForRetailStoreOrder(String initValue){
		return shipmentIdFieldForRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderConfirmationForm shipmentIdFieldForRetailStoreOrder(){
		return shipmentIdFieldForRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderConfirmationForm deliveryIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm deliveryIdFieldForRetailStoreOrder(String initValue){
		return deliveryIdFieldForRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderConfirmationForm deliveryIdFieldForRetailStoreOrder(){
		return deliveryIdFieldForRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderConfirmationForm lastUpdateTimeFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm lastUpdateTimeFieldForRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderConfirmationForm lastUpdateTimeFieldForRetailStoreOrder(){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderConfirmationForm currentStatusFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderConfirmationForm currentStatusFieldForRetailStoreOrder(String initValue){
		return currentStatusFieldForRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderConfirmationForm currentStatusFieldForRetailStoreOrder(){
		return currentStatusFieldForRetailStoreOrder("currentStatus","");
	}

	



	public RetailStoreOrderConfirmationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



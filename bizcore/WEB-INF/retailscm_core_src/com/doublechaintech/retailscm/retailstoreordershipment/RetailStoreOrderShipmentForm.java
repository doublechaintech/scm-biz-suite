package com.doublechaintech.retailscm.retailstoreordershipment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderShipmentForm extends BaseForm {
	
	
	public RetailStoreOrderShipmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderShipmentForm retailStoreOrderShipmentIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm retailStoreOrderShipmentIdField(String initValue){
		return retailStoreOrderShipmentIdField("retailStoreOrderShipmentId",initValue);
	}
	public RetailStoreOrderShipmentForm retailStoreOrderShipmentIdField(){
		return retailStoreOrderShipmentIdField("retailStoreOrderShipmentId","");
	}


	public RetailStoreOrderShipmentForm whoField(String parameterName, String initValue){
		FormField field = whoFromRetailStoreOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public RetailStoreOrderShipmentForm whoField(){
		return whoField("who","");
	}


	public RetailStoreOrderShipmentForm shipTimeField(String parameterName, String initValue){
		FormField field = shipTimeFromRetailStoreOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm shipTimeField(String initValue){
		return shipTimeField("shipTime",initValue);
	}
	public RetailStoreOrderShipmentForm shipTimeField(){
		return shipTimeField("shipTime","");
	}

	
	

	



	public RetailStoreOrderShipmentForm retailStoreOrderIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm retailStoreOrderIdFieldForRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderShipmentForm retailStoreOrderIdFieldForRetailStoreOrder(){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderShipmentForm buyerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm buyerIdFieldForRetailStoreOrder(String initValue){
		return buyerIdFieldForRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderShipmentForm buyerIdFieldForRetailStoreOrder(){
		return buyerIdFieldForRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderShipmentForm sellerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm sellerIdFieldForRetailStoreOrder(String initValue){
		return sellerIdFieldForRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderShipmentForm sellerIdFieldForRetailStoreOrder(){
		return sellerIdFieldForRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderShipmentForm titleFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm titleFieldForRetailStoreOrder(String initValue){
		return titleFieldForRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderShipmentForm titleFieldForRetailStoreOrder(){
		return titleFieldForRetailStoreOrder("title","");
	}


	public RetailStoreOrderShipmentForm totalAmountFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm totalAmountFieldForRetailStoreOrder(String initValue){
		return totalAmountFieldForRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderShipmentForm totalAmountFieldForRetailStoreOrder(){
		return totalAmountFieldForRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderShipmentForm confirmationIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm confirmationIdFieldForRetailStoreOrder(String initValue){
		return confirmationIdFieldForRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderShipmentForm confirmationIdFieldForRetailStoreOrder(){
		return confirmationIdFieldForRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderShipmentForm approvalIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm approvalIdFieldForRetailStoreOrder(String initValue){
		return approvalIdFieldForRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderShipmentForm approvalIdFieldForRetailStoreOrder(){
		return approvalIdFieldForRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderShipmentForm processingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm processingIdFieldForRetailStoreOrder(String initValue){
		return processingIdFieldForRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderShipmentForm processingIdFieldForRetailStoreOrder(){
		return processingIdFieldForRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderShipmentForm pickingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm pickingIdFieldForRetailStoreOrder(String initValue){
		return pickingIdFieldForRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderShipmentForm pickingIdFieldForRetailStoreOrder(){
		return pickingIdFieldForRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderShipmentForm shipmentIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm shipmentIdFieldForRetailStoreOrder(String initValue){
		return shipmentIdFieldForRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderShipmentForm shipmentIdFieldForRetailStoreOrder(){
		return shipmentIdFieldForRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderShipmentForm deliveryIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm deliveryIdFieldForRetailStoreOrder(String initValue){
		return deliveryIdFieldForRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderShipmentForm deliveryIdFieldForRetailStoreOrder(){
		return deliveryIdFieldForRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderShipmentForm lastUpdateTimeFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm lastUpdateTimeFieldForRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderShipmentForm lastUpdateTimeFieldForRetailStoreOrder(){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderShipmentForm currentStatusFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShipmentForm currentStatusFieldForRetailStoreOrder(String initValue){
		return currentStatusFieldForRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderShipmentForm currentStatusFieldForRetailStoreOrder(){
		return currentStatusFieldForRetailStoreOrder("currentStatus","");
	}

	



	public RetailStoreOrderShipmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



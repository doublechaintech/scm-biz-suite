package com.doublechaintech.retailscm.retailstoreorderpicking;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderPickingForm extends BaseForm {
	
	
	public RetailStoreOrderPickingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderPickingForm retailStoreOrderPickingIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderPicking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm retailStoreOrderPickingIdField(String initValue){
		return retailStoreOrderPickingIdField("retailStoreOrderPickingId",initValue);
	}
	public RetailStoreOrderPickingForm retailStoreOrderPickingIdField(){
		return retailStoreOrderPickingIdField("retailStoreOrderPickingId","");
	}


	public RetailStoreOrderPickingForm whoField(String parameterName, String initValue){
		FormField field = whoFromRetailStoreOrderPicking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public RetailStoreOrderPickingForm whoField(){
		return whoField("who","");
	}


	public RetailStoreOrderPickingForm processTimeField(String parameterName, String initValue){
		FormField field = processTimeFromRetailStoreOrderPicking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm processTimeField(String initValue){
		return processTimeField("processTime",initValue);
	}
	public RetailStoreOrderPickingForm processTimeField(){
		return processTimeField("processTime","");
	}

	
	

	



	public RetailStoreOrderPickingForm retailStoreOrderIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm retailStoreOrderIdFieldForRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderPickingForm retailStoreOrderIdFieldForRetailStoreOrder(){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderPickingForm buyerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm buyerIdFieldForRetailStoreOrder(String initValue){
		return buyerIdFieldForRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderPickingForm buyerIdFieldForRetailStoreOrder(){
		return buyerIdFieldForRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderPickingForm sellerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm sellerIdFieldForRetailStoreOrder(String initValue){
		return sellerIdFieldForRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderPickingForm sellerIdFieldForRetailStoreOrder(){
		return sellerIdFieldForRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderPickingForm titleFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm titleFieldForRetailStoreOrder(String initValue){
		return titleFieldForRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderPickingForm titleFieldForRetailStoreOrder(){
		return titleFieldForRetailStoreOrder("title","");
	}


	public RetailStoreOrderPickingForm totalAmountFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm totalAmountFieldForRetailStoreOrder(String initValue){
		return totalAmountFieldForRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderPickingForm totalAmountFieldForRetailStoreOrder(){
		return totalAmountFieldForRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderPickingForm confirmationIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm confirmationIdFieldForRetailStoreOrder(String initValue){
		return confirmationIdFieldForRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderPickingForm confirmationIdFieldForRetailStoreOrder(){
		return confirmationIdFieldForRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderPickingForm approvalIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm approvalIdFieldForRetailStoreOrder(String initValue){
		return approvalIdFieldForRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderPickingForm approvalIdFieldForRetailStoreOrder(){
		return approvalIdFieldForRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderPickingForm processingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm processingIdFieldForRetailStoreOrder(String initValue){
		return processingIdFieldForRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderPickingForm processingIdFieldForRetailStoreOrder(){
		return processingIdFieldForRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderPickingForm pickingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm pickingIdFieldForRetailStoreOrder(String initValue){
		return pickingIdFieldForRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderPickingForm pickingIdFieldForRetailStoreOrder(){
		return pickingIdFieldForRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderPickingForm shipmentIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm shipmentIdFieldForRetailStoreOrder(String initValue){
		return shipmentIdFieldForRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderPickingForm shipmentIdFieldForRetailStoreOrder(){
		return shipmentIdFieldForRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderPickingForm deliveryIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm deliveryIdFieldForRetailStoreOrder(String initValue){
		return deliveryIdFieldForRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderPickingForm deliveryIdFieldForRetailStoreOrder(){
		return deliveryIdFieldForRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderPickingForm lastUpdateTimeFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm lastUpdateTimeFieldForRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderPickingForm lastUpdateTimeFieldForRetailStoreOrder(){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderPickingForm currentStatusFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPickingForm currentStatusFieldForRetailStoreOrder(String initValue){
		return currentStatusFieldForRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderPickingForm currentStatusFieldForRetailStoreOrder(){
		return currentStatusFieldForRetailStoreOrder("currentStatus","");
	}

	



	public RetailStoreOrderPickingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



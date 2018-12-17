package com.doublechaintech.retailscm.supplyordershipment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderShipmentForm extends BaseForm {
	
	
	public SupplyOrderShipmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderShipmentForm supplyOrderShipmentIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm supplyOrderShipmentIdField(String initValue){
		return supplyOrderShipmentIdField("supplyOrderShipmentId",initValue);
	}
	public SupplyOrderShipmentForm supplyOrderShipmentIdField(){
		return supplyOrderShipmentIdField("supplyOrderShipmentId","");
	}


	public SupplyOrderShipmentForm whoField(String parameterName, String initValue){
		FormField field = whoFromSupplyOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public SupplyOrderShipmentForm whoField(){
		return whoField("who","");
	}


	public SupplyOrderShipmentForm shipTimeField(String parameterName, String initValue){
		FormField field = shipTimeFromSupplyOrderShipment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm shipTimeField(String initValue){
		return shipTimeField("shipTime",initValue);
	}
	public SupplyOrderShipmentForm shipTimeField(){
		return shipTimeField("shipTime","");
	}

	
	

	



	public SupplyOrderShipmentForm consumerOrderIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm consumerOrderIdFieldForConsumerOrder(String initValue){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId",initValue);
	}
	public SupplyOrderShipmentForm consumerOrderIdFieldForConsumerOrder(){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId","");
	}


	public SupplyOrderShipmentForm titleFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm titleFieldForConsumerOrder(String initValue){
		return titleFieldForConsumerOrder("title",initValue);
	}
	public SupplyOrderShipmentForm titleFieldForConsumerOrder(){
		return titleFieldForConsumerOrder("title","");
	}


	public SupplyOrderShipmentForm consumerIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm consumerIdFieldForConsumerOrder(String initValue){
		return consumerIdFieldForConsumerOrder("consumerId",initValue);
	}
	public SupplyOrderShipmentForm consumerIdFieldForConsumerOrder(){
		return consumerIdFieldForConsumerOrder("consumerId","");
	}


	public SupplyOrderShipmentForm confirmationIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm confirmationIdFieldForConsumerOrder(String initValue){
		return confirmationIdFieldForConsumerOrder("confirmationId",initValue);
	}
	public SupplyOrderShipmentForm confirmationIdFieldForConsumerOrder(){
		return confirmationIdFieldForConsumerOrder("confirmationId","");
	}


	public SupplyOrderShipmentForm approvalIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm approvalIdFieldForConsumerOrder(String initValue){
		return approvalIdFieldForConsumerOrder("approvalId",initValue);
	}
	public SupplyOrderShipmentForm approvalIdFieldForConsumerOrder(){
		return approvalIdFieldForConsumerOrder("approvalId","");
	}


	public SupplyOrderShipmentForm processingIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm processingIdFieldForConsumerOrder(String initValue){
		return processingIdFieldForConsumerOrder("processingId",initValue);
	}
	public SupplyOrderShipmentForm processingIdFieldForConsumerOrder(){
		return processingIdFieldForConsumerOrder("processingId","");
	}


	public SupplyOrderShipmentForm shipmentIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm shipmentIdFieldForConsumerOrder(String initValue){
		return shipmentIdFieldForConsumerOrder("shipmentId",initValue);
	}
	public SupplyOrderShipmentForm shipmentIdFieldForConsumerOrder(){
		return shipmentIdFieldForConsumerOrder("shipmentId","");
	}


	public SupplyOrderShipmentForm deliveryIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm deliveryIdFieldForConsumerOrder(String initValue){
		return deliveryIdFieldForConsumerOrder("deliveryId",initValue);
	}
	public SupplyOrderShipmentForm deliveryIdFieldForConsumerOrder(){
		return deliveryIdFieldForConsumerOrder("deliveryId","");
	}


	public SupplyOrderShipmentForm storeIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm storeIdFieldForConsumerOrder(String initValue){
		return storeIdFieldForConsumerOrder("storeId",initValue);
	}
	public SupplyOrderShipmentForm storeIdFieldForConsumerOrder(){
		return storeIdFieldForConsumerOrder("storeId","");
	}


	public SupplyOrderShipmentForm lastUpdateTimeFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm lastUpdateTimeFieldForConsumerOrder(String initValue){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderShipmentForm lastUpdateTimeFieldForConsumerOrder(){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime","");
	}


	public SupplyOrderShipmentForm currentStatusFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm currentStatusFieldForConsumerOrder(String initValue){
		return currentStatusFieldForConsumerOrder("currentStatus",initValue);
	}
	public SupplyOrderShipmentForm currentStatusFieldForConsumerOrder(){
		return currentStatusFieldForConsumerOrder("currentStatus","");
	}


	public SupplyOrderShipmentForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderShipmentForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderShipmentForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderShipmentForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public SupplyOrderShipmentForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderShipmentForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public SupplyOrderShipmentForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public SupplyOrderShipmentForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public SupplyOrderShipmentForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderShipmentForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public SupplyOrderShipmentForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderShipmentForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public SupplyOrderShipmentForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderShipmentForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public SupplyOrderShipmentForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public SupplyOrderShipmentForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public SupplyOrderShipmentForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderShipmentForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public SupplyOrderShipmentForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderShipmentForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public SupplyOrderShipmentForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderShipmentForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public SupplyOrderShipmentForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderShipmentForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderShipmentForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShipmentForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderShipmentForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}

	



	public SupplyOrderShipmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.retailstoreorderlineitem;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderLineItemForm extends BaseForm {
	
	
	public RetailStoreOrderLineItemForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderLineItemForm retailStoreOrderLineItemIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm retailStoreOrderLineItemIdField(String initValue){
		return retailStoreOrderLineItemIdField("retailStoreOrderLineItemId",initValue);
	}
	public RetailStoreOrderLineItemForm retailStoreOrderLineItemIdField(){
		return retailStoreOrderLineItemIdField("retailStoreOrderLineItemId","");
	}


	public RetailStoreOrderLineItemForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public RetailStoreOrderLineItemForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public RetailStoreOrderLineItemForm skuIdField(String parameterName, String initValue){
		FormField field = skuIdFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm skuIdField(String initValue){
		return skuIdField("skuId",initValue);
	}
	public RetailStoreOrderLineItemForm skuIdField(){
		return skuIdField("skuId","");
	}


	public RetailStoreOrderLineItemForm skuNameField(String parameterName, String initValue){
		FormField field = skuNameFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm skuNameField(String initValue){
		return skuNameField("skuName",initValue);
	}
	public RetailStoreOrderLineItemForm skuNameField(){
		return skuNameField("skuName","");
	}


	public RetailStoreOrderLineItemForm amountField(String parameterName, String initValue){
		FormField field = amountFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public RetailStoreOrderLineItemForm amountField(){
		return amountField("amount","");
	}


	public RetailStoreOrderLineItemForm quantityField(String parameterName, String initValue){
		FormField field = quantityFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm quantityField(String initValue){
		return quantityField("quantity",initValue);
	}
	public RetailStoreOrderLineItemForm quantityField(){
		return quantityField("quantity","");
	}


	public RetailStoreOrderLineItemForm unitOfMeasurementField(String parameterName, String initValue){
		FormField field = unitOfMeasurementFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderLineItemForm unitOfMeasurementField(String initValue){
		return unitOfMeasurementField("unitOfMeasurement",initValue);
	}
	public RetailStoreOrderLineItemForm unitOfMeasurementField(){
		return unitOfMeasurementField("unitOfMeasurement","");
	}

	
	


	public RetailStoreOrderLineItemForm retailStoreOrderIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm retailStoreOrderIdFieldOfRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderLineItemForm retailStoreOrderIdFieldOfRetailStoreOrder(){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderLineItemForm buyerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm buyerIdFieldOfRetailStoreOrder(String initValue){
		return buyerIdFieldOfRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderLineItemForm buyerIdFieldOfRetailStoreOrder(){
		return buyerIdFieldOfRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderLineItemForm sellerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm sellerIdFieldOfRetailStoreOrder(String initValue){
		return sellerIdFieldOfRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderLineItemForm sellerIdFieldOfRetailStoreOrder(){
		return sellerIdFieldOfRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderLineItemForm titleFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm titleFieldOfRetailStoreOrder(String initValue){
		return titleFieldOfRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderLineItemForm titleFieldOfRetailStoreOrder(){
		return titleFieldOfRetailStoreOrder("title","");
	}


	public RetailStoreOrderLineItemForm totalAmountFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm totalAmountFieldOfRetailStoreOrder(String initValue){
		return totalAmountFieldOfRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderLineItemForm totalAmountFieldOfRetailStoreOrder(){
		return totalAmountFieldOfRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderLineItemForm confirmationIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm confirmationIdFieldOfRetailStoreOrder(String initValue){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderLineItemForm confirmationIdFieldOfRetailStoreOrder(){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderLineItemForm approvalIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm approvalIdFieldOfRetailStoreOrder(String initValue){
		return approvalIdFieldOfRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderLineItemForm approvalIdFieldOfRetailStoreOrder(){
		return approvalIdFieldOfRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderLineItemForm processingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm processingIdFieldOfRetailStoreOrder(String initValue){
		return processingIdFieldOfRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderLineItemForm processingIdFieldOfRetailStoreOrder(){
		return processingIdFieldOfRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderLineItemForm pickingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm pickingIdFieldOfRetailStoreOrder(String initValue){
		return pickingIdFieldOfRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderLineItemForm pickingIdFieldOfRetailStoreOrder(){
		return pickingIdFieldOfRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderLineItemForm shipmentIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm shipmentIdFieldOfRetailStoreOrder(String initValue){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderLineItemForm shipmentIdFieldOfRetailStoreOrder(){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderLineItemForm deliveryIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm deliveryIdFieldOfRetailStoreOrder(String initValue){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderLineItemForm deliveryIdFieldOfRetailStoreOrder(){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderLineItemForm lastUpdateTimeFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm lastUpdateTimeFieldOfRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderLineItemForm lastUpdateTimeFieldOfRetailStoreOrder(){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderLineItemForm currentStatusFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderLineItemForm currentStatusFieldOfRetailStoreOrder(String initValue){
		return currentStatusFieldOfRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderLineItemForm currentStatusFieldOfRetailStoreOrder(){
		return currentStatusFieldOfRetailStoreOrder("currentStatus","");
	}

	


	

	
 	public RetailStoreOrderLineItemForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/retailStoreOrderLineItemId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreOrderLineItemForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



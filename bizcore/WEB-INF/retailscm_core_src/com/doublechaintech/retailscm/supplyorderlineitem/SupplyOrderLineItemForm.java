package com.doublechaintech.retailscm.supplyorderlineitem;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderLineItemForm extends BaseForm {
	
	
	public SupplyOrderLineItemForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderLineItemForm supplyOrderLineItemIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm supplyOrderLineItemIdField(String initValue){
		return supplyOrderLineItemIdField("supplyOrderLineItemId",initValue);
	}
	public SupplyOrderLineItemForm supplyOrderLineItemIdField(){
		return supplyOrderLineItemIdField("supplyOrderLineItemId","");
	}


	public SupplyOrderLineItemForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public SupplyOrderLineItemForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public SupplyOrderLineItemForm skuIdField(String parameterName, String initValue){
		FormField field = skuIdFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm skuIdField(String initValue){
		return skuIdField("skuId",initValue);
	}
	public SupplyOrderLineItemForm skuIdField(){
		return skuIdField("skuId","");
	}


	public SupplyOrderLineItemForm skuNameField(String parameterName, String initValue){
		FormField field = skuNameFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm skuNameField(String initValue){
		return skuNameField("skuName",initValue);
	}
	public SupplyOrderLineItemForm skuNameField(){
		return skuNameField("skuName","");
	}


	public SupplyOrderLineItemForm amountField(String parameterName, String initValue){
		FormField field = amountFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public SupplyOrderLineItemForm amountField(){
		return amountField("amount","");
	}


	public SupplyOrderLineItemForm quantityField(String parameterName, String initValue){
		FormField field = quantityFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm quantityField(String initValue){
		return quantityField("quantity",initValue);
	}
	public SupplyOrderLineItemForm quantityField(){
		return quantityField("quantity","");
	}


	public SupplyOrderLineItemForm unitOfMeasurementField(String parameterName, String initValue){
		FormField field = unitOfMeasurementFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderLineItemForm unitOfMeasurementField(String initValue){
		return unitOfMeasurementField("unitOfMeasurement",initValue);
	}
	public SupplyOrderLineItemForm unitOfMeasurementField(){
		return unitOfMeasurementField("unitOfMeasurement","");
	}

	
	


	public SupplyOrderLineItemForm supplyOrderIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm supplyOrderIdFieldOfSupplyOrder(String initValue){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderLineItemForm supplyOrderIdFieldOfSupplyOrder(){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderLineItemForm buyerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm buyerIdFieldOfSupplyOrder(String initValue){
		return buyerIdFieldOfSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderLineItemForm buyerIdFieldOfSupplyOrder(){
		return buyerIdFieldOfSupplyOrder("buyerId","");
	}


	public SupplyOrderLineItemForm sellerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm sellerIdFieldOfSupplyOrder(String initValue){
		return sellerIdFieldOfSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderLineItemForm sellerIdFieldOfSupplyOrder(){
		return sellerIdFieldOfSupplyOrder("sellerId","");
	}


	public SupplyOrderLineItemForm titleFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm titleFieldOfSupplyOrder(String initValue){
		return titleFieldOfSupplyOrder("title",initValue);
	}
	public SupplyOrderLineItemForm titleFieldOfSupplyOrder(){
		return titleFieldOfSupplyOrder("title","");
	}


	public SupplyOrderLineItemForm totalAmountFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm totalAmountFieldOfSupplyOrder(String initValue){
		return totalAmountFieldOfSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderLineItemForm totalAmountFieldOfSupplyOrder(){
		return totalAmountFieldOfSupplyOrder("totalAmount","");
	}


	public SupplyOrderLineItemForm confirmationIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm confirmationIdFieldOfSupplyOrder(String initValue){
		return confirmationIdFieldOfSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderLineItemForm confirmationIdFieldOfSupplyOrder(){
		return confirmationIdFieldOfSupplyOrder("confirmationId","");
	}


	public SupplyOrderLineItemForm approvalIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm approvalIdFieldOfSupplyOrder(String initValue){
		return approvalIdFieldOfSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderLineItemForm approvalIdFieldOfSupplyOrder(){
		return approvalIdFieldOfSupplyOrder("approvalId","");
	}


	public SupplyOrderLineItemForm processingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm processingIdFieldOfSupplyOrder(String initValue){
		return processingIdFieldOfSupplyOrder("processingId",initValue);
	}
	public SupplyOrderLineItemForm processingIdFieldOfSupplyOrder(){
		return processingIdFieldOfSupplyOrder("processingId","");
	}


	public SupplyOrderLineItemForm pickingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm pickingIdFieldOfSupplyOrder(String initValue){
		return pickingIdFieldOfSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderLineItemForm pickingIdFieldOfSupplyOrder(){
		return pickingIdFieldOfSupplyOrder("pickingId","");
	}


	public SupplyOrderLineItemForm shipmentIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm shipmentIdFieldOfSupplyOrder(String initValue){
		return shipmentIdFieldOfSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderLineItemForm shipmentIdFieldOfSupplyOrder(){
		return shipmentIdFieldOfSupplyOrder("shipmentId","");
	}


	public SupplyOrderLineItemForm deliveryIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm deliveryIdFieldOfSupplyOrder(String initValue){
		return deliveryIdFieldOfSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderLineItemForm deliveryIdFieldOfSupplyOrder(){
		return deliveryIdFieldOfSupplyOrder("deliveryId","");
	}


	public SupplyOrderLineItemForm lastUpdateTimeFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm lastUpdateTimeFieldOfSupplyOrder(String initValue){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderLineItemForm lastUpdateTimeFieldOfSupplyOrder(){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderLineItemForm currentStatusFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderLineItemForm currentStatusFieldOfSupplyOrder(String initValue){
		return currentStatusFieldOfSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderLineItemForm currentStatusFieldOfSupplyOrder(){
		return currentStatusFieldOfSupplyOrder("currentStatus","");
	}

	


	

	
 	public SupplyOrderLineItemForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/supplyOrderLineItemId/");
		this.addFormAction(action);
		return this;
	}

 

	public SupplyOrderLineItemForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



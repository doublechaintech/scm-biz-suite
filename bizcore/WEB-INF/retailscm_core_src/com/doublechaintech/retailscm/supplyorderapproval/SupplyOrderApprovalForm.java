package com.doublechaintech.retailscm.supplyorderapproval;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderApprovalForm extends BaseForm {
	
	
	public SupplyOrderApprovalForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderApprovalForm supplyOrderApprovalIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderApproval(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm supplyOrderApprovalIdField(String initValue){
		return supplyOrderApprovalIdField("supplyOrderApprovalId",initValue);
	}
	public SupplyOrderApprovalForm supplyOrderApprovalIdField(){
		return supplyOrderApprovalIdField("supplyOrderApprovalId","");
	}


	public SupplyOrderApprovalForm whoField(String parameterName, String initValue){
		FormField field = whoFromSupplyOrderApproval(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public SupplyOrderApprovalForm whoField(){
		return whoField("who","");
	}


	public SupplyOrderApprovalForm approveTimeField(String parameterName, String initValue){
		FormField field = approveTimeFromSupplyOrderApproval(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm approveTimeField(String initValue){
		return approveTimeField("approveTime",initValue);
	}
	public SupplyOrderApprovalForm approveTimeField(){
		return approveTimeField("approveTime","");
	}

	
	

	



	public SupplyOrderApprovalForm consumerOrderIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm consumerOrderIdFieldForConsumerOrder(String initValue){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId",initValue);
	}
	public SupplyOrderApprovalForm consumerOrderIdFieldForConsumerOrder(){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId","");
	}


	public SupplyOrderApprovalForm titleFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm titleFieldForConsumerOrder(String initValue){
		return titleFieldForConsumerOrder("title",initValue);
	}
	public SupplyOrderApprovalForm titleFieldForConsumerOrder(){
		return titleFieldForConsumerOrder("title","");
	}


	public SupplyOrderApprovalForm consumerIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm consumerIdFieldForConsumerOrder(String initValue){
		return consumerIdFieldForConsumerOrder("consumerId",initValue);
	}
	public SupplyOrderApprovalForm consumerIdFieldForConsumerOrder(){
		return consumerIdFieldForConsumerOrder("consumerId","");
	}


	public SupplyOrderApprovalForm confirmationIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm confirmationIdFieldForConsumerOrder(String initValue){
		return confirmationIdFieldForConsumerOrder("confirmationId",initValue);
	}
	public SupplyOrderApprovalForm confirmationIdFieldForConsumerOrder(){
		return confirmationIdFieldForConsumerOrder("confirmationId","");
	}


	public SupplyOrderApprovalForm approvalIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm approvalIdFieldForConsumerOrder(String initValue){
		return approvalIdFieldForConsumerOrder("approvalId",initValue);
	}
	public SupplyOrderApprovalForm approvalIdFieldForConsumerOrder(){
		return approvalIdFieldForConsumerOrder("approvalId","");
	}


	public SupplyOrderApprovalForm processingIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm processingIdFieldForConsumerOrder(String initValue){
		return processingIdFieldForConsumerOrder("processingId",initValue);
	}
	public SupplyOrderApprovalForm processingIdFieldForConsumerOrder(){
		return processingIdFieldForConsumerOrder("processingId","");
	}


	public SupplyOrderApprovalForm shipmentIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm shipmentIdFieldForConsumerOrder(String initValue){
		return shipmentIdFieldForConsumerOrder("shipmentId",initValue);
	}
	public SupplyOrderApprovalForm shipmentIdFieldForConsumerOrder(){
		return shipmentIdFieldForConsumerOrder("shipmentId","");
	}


	public SupplyOrderApprovalForm deliveryIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm deliveryIdFieldForConsumerOrder(String initValue){
		return deliveryIdFieldForConsumerOrder("deliveryId",initValue);
	}
	public SupplyOrderApprovalForm deliveryIdFieldForConsumerOrder(){
		return deliveryIdFieldForConsumerOrder("deliveryId","");
	}


	public SupplyOrderApprovalForm storeIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm storeIdFieldForConsumerOrder(String initValue){
		return storeIdFieldForConsumerOrder("storeId",initValue);
	}
	public SupplyOrderApprovalForm storeIdFieldForConsumerOrder(){
		return storeIdFieldForConsumerOrder("storeId","");
	}


	public SupplyOrderApprovalForm lastUpdateTimeFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm lastUpdateTimeFieldForConsumerOrder(String initValue){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderApprovalForm lastUpdateTimeFieldForConsumerOrder(){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime","");
	}


	public SupplyOrderApprovalForm currentStatusFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm currentStatusFieldForConsumerOrder(String initValue){
		return currentStatusFieldForConsumerOrder("currentStatus",initValue);
	}
	public SupplyOrderApprovalForm currentStatusFieldForConsumerOrder(){
		return currentStatusFieldForConsumerOrder("currentStatus","");
	}


	public SupplyOrderApprovalForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderApprovalForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderApprovalForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderApprovalForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public SupplyOrderApprovalForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderApprovalForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public SupplyOrderApprovalForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public SupplyOrderApprovalForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public SupplyOrderApprovalForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderApprovalForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public SupplyOrderApprovalForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderApprovalForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public SupplyOrderApprovalForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderApprovalForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public SupplyOrderApprovalForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public SupplyOrderApprovalForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public SupplyOrderApprovalForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderApprovalForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public SupplyOrderApprovalForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderApprovalForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public SupplyOrderApprovalForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderApprovalForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public SupplyOrderApprovalForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderApprovalForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderApprovalForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderApprovalForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderApprovalForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}

	



	public SupplyOrderApprovalForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



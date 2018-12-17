package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderPaymentGroupForm extends BaseForm {
	
	
	public RetailStoreOrderPaymentGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderPaymentGroupForm retailStoreOrderPaymentGroupIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm retailStoreOrderPaymentGroupIdField(String initValue){
		return retailStoreOrderPaymentGroupIdField("retailStoreOrderPaymentGroupId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm retailStoreOrderPaymentGroupIdField(){
		return retailStoreOrderPaymentGroupIdField("retailStoreOrderPaymentGroupId","");
	}


	public RetailStoreOrderPaymentGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreOrderPaymentGroupForm nameField(){
		return nameField("name","");
	}


	public RetailStoreOrderPaymentGroupForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public RetailStoreOrderPaymentGroupForm cardNumberField(String parameterName, String initValue){
		FormField field = cardNumberFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm cardNumberField(String initValue){
		return cardNumberField("cardNumber",initValue);
	}
	public RetailStoreOrderPaymentGroupForm cardNumberField(){
		return cardNumberField("cardNumber","");
	}

	
	


	public RetailStoreOrderPaymentGroupForm retailStoreOrderIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm retailStoreOrderIdFieldOfRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm retailStoreOrderIdFieldOfRetailStoreOrder(){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderPaymentGroupForm buyerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm buyerIdFieldOfRetailStoreOrder(String initValue){
		return buyerIdFieldOfRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm buyerIdFieldOfRetailStoreOrder(){
		return buyerIdFieldOfRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderPaymentGroupForm sellerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm sellerIdFieldOfRetailStoreOrder(String initValue){
		return sellerIdFieldOfRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm sellerIdFieldOfRetailStoreOrder(){
		return sellerIdFieldOfRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderPaymentGroupForm titleFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm titleFieldOfRetailStoreOrder(String initValue){
		return titleFieldOfRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderPaymentGroupForm titleFieldOfRetailStoreOrder(){
		return titleFieldOfRetailStoreOrder("title","");
	}


	public RetailStoreOrderPaymentGroupForm totalAmountFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm totalAmountFieldOfRetailStoreOrder(String initValue){
		return totalAmountFieldOfRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderPaymentGroupForm totalAmountFieldOfRetailStoreOrder(){
		return totalAmountFieldOfRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderPaymentGroupForm confirmationIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm confirmationIdFieldOfRetailStoreOrder(String initValue){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm confirmationIdFieldOfRetailStoreOrder(){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderPaymentGroupForm approvalIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm approvalIdFieldOfRetailStoreOrder(String initValue){
		return approvalIdFieldOfRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm approvalIdFieldOfRetailStoreOrder(){
		return approvalIdFieldOfRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderPaymentGroupForm processingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm processingIdFieldOfRetailStoreOrder(String initValue){
		return processingIdFieldOfRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm processingIdFieldOfRetailStoreOrder(){
		return processingIdFieldOfRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderPaymentGroupForm pickingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm pickingIdFieldOfRetailStoreOrder(String initValue){
		return pickingIdFieldOfRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm pickingIdFieldOfRetailStoreOrder(){
		return pickingIdFieldOfRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderPaymentGroupForm shipmentIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm shipmentIdFieldOfRetailStoreOrder(String initValue){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm shipmentIdFieldOfRetailStoreOrder(){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderPaymentGroupForm deliveryIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm deliveryIdFieldOfRetailStoreOrder(String initValue){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderPaymentGroupForm deliveryIdFieldOfRetailStoreOrder(){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderPaymentGroupForm lastUpdateTimeFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm lastUpdateTimeFieldOfRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderPaymentGroupForm lastUpdateTimeFieldOfRetailStoreOrder(){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderPaymentGroupForm currentStatusFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderPaymentGroupForm currentStatusFieldOfRetailStoreOrder(String initValue){
		return currentStatusFieldOfRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderPaymentGroupForm currentStatusFieldOfRetailStoreOrder(){
		return currentStatusFieldOfRetailStoreOrder("currentStatus","");
	}

	


	

	
 	public RetailStoreOrderPaymentGroupForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/retailStoreOrderPaymentGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreOrderPaymentGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



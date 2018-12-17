package com.doublechaintech.retailscm.retailstoreordershippinggroup;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderShippingGroupForm extends BaseForm {
	
	
	public RetailStoreOrderShippingGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderShippingGroupForm retailStoreOrderShippingGroupIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm retailStoreOrderShippingGroupIdField(String initValue){
		return retailStoreOrderShippingGroupIdField("retailStoreOrderShippingGroupId",initValue);
	}
	public RetailStoreOrderShippingGroupForm retailStoreOrderShippingGroupIdField(){
		return retailStoreOrderShippingGroupIdField("retailStoreOrderShippingGroupId","");
	}


	public RetailStoreOrderShippingGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreOrderShippingGroupForm nameField(){
		return nameField("name","");
	}


	public RetailStoreOrderShippingGroupForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public RetailStoreOrderShippingGroupForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public RetailStoreOrderShippingGroupForm amountField(String parameterName, String initValue){
		FormField field = amountFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public RetailStoreOrderShippingGroupForm amountField(){
		return amountField("amount","");
	}

	
	


	public RetailStoreOrderShippingGroupForm retailStoreOrderIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm retailStoreOrderIdFieldOfRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderShippingGroupForm retailStoreOrderIdFieldOfRetailStoreOrder(){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreOrderShippingGroupForm buyerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm buyerIdFieldOfRetailStoreOrder(String initValue){
		return buyerIdFieldOfRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreOrderShippingGroupForm buyerIdFieldOfRetailStoreOrder(){
		return buyerIdFieldOfRetailStoreOrder("buyerId","");
	}


	public RetailStoreOrderShippingGroupForm sellerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm sellerIdFieldOfRetailStoreOrder(String initValue){
		return sellerIdFieldOfRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreOrderShippingGroupForm sellerIdFieldOfRetailStoreOrder(){
		return sellerIdFieldOfRetailStoreOrder("sellerId","");
	}


	public RetailStoreOrderShippingGroupForm titleFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm titleFieldOfRetailStoreOrder(String initValue){
		return titleFieldOfRetailStoreOrder("title",initValue);
	}
	public RetailStoreOrderShippingGroupForm titleFieldOfRetailStoreOrder(){
		return titleFieldOfRetailStoreOrder("title","");
	}


	public RetailStoreOrderShippingGroupForm totalAmountFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm totalAmountFieldOfRetailStoreOrder(String initValue){
		return totalAmountFieldOfRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreOrderShippingGroupForm totalAmountFieldOfRetailStoreOrder(){
		return totalAmountFieldOfRetailStoreOrder("totalAmount","");
	}


	public RetailStoreOrderShippingGroupForm confirmationIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm confirmationIdFieldOfRetailStoreOrder(String initValue){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreOrderShippingGroupForm confirmationIdFieldOfRetailStoreOrder(){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId","");
	}


	public RetailStoreOrderShippingGroupForm approvalIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm approvalIdFieldOfRetailStoreOrder(String initValue){
		return approvalIdFieldOfRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreOrderShippingGroupForm approvalIdFieldOfRetailStoreOrder(){
		return approvalIdFieldOfRetailStoreOrder("approvalId","");
	}


	public RetailStoreOrderShippingGroupForm processingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm processingIdFieldOfRetailStoreOrder(String initValue){
		return processingIdFieldOfRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreOrderShippingGroupForm processingIdFieldOfRetailStoreOrder(){
		return processingIdFieldOfRetailStoreOrder("processingId","");
	}


	public RetailStoreOrderShippingGroupForm pickingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm pickingIdFieldOfRetailStoreOrder(String initValue){
		return pickingIdFieldOfRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreOrderShippingGroupForm pickingIdFieldOfRetailStoreOrder(){
		return pickingIdFieldOfRetailStoreOrder("pickingId","");
	}


	public RetailStoreOrderShippingGroupForm shipmentIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm shipmentIdFieldOfRetailStoreOrder(String initValue){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreOrderShippingGroupForm shipmentIdFieldOfRetailStoreOrder(){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId","");
	}


	public RetailStoreOrderShippingGroupForm deliveryIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm deliveryIdFieldOfRetailStoreOrder(String initValue){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreOrderShippingGroupForm deliveryIdFieldOfRetailStoreOrder(){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId","");
	}


	public RetailStoreOrderShippingGroupForm lastUpdateTimeFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm lastUpdateTimeFieldOfRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreOrderShippingGroupForm lastUpdateTimeFieldOfRetailStoreOrder(){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreOrderShippingGroupForm currentStatusFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderShippingGroupForm currentStatusFieldOfRetailStoreOrder(String initValue){
		return currentStatusFieldOfRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreOrderShippingGroupForm currentStatusFieldOfRetailStoreOrder(){
		return currentStatusFieldOfRetailStoreOrder("currentStatus","");
	}

	


	

	
 	public RetailStoreOrderShippingGroupForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/retailStoreOrderShippingGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreOrderShippingGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



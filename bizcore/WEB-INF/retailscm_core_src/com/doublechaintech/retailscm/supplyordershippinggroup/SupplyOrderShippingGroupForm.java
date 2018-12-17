package com.doublechaintech.retailscm.supplyordershippinggroup;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderShippingGroupForm extends BaseForm {
	
	
	public SupplyOrderShippingGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderShippingGroupForm supplyOrderShippingGroupIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShippingGroupForm supplyOrderShippingGroupIdField(String initValue){
		return supplyOrderShippingGroupIdField("supplyOrderShippingGroupId",initValue);
	}
	public SupplyOrderShippingGroupForm supplyOrderShippingGroupIdField(){
		return supplyOrderShippingGroupIdField("supplyOrderShippingGroupId","");
	}


	public SupplyOrderShippingGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShippingGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public SupplyOrderShippingGroupForm nameField(){
		return nameField("name","");
	}


	public SupplyOrderShippingGroupForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShippingGroupForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public SupplyOrderShippingGroupForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public SupplyOrderShippingGroupForm amountField(String parameterName, String initValue){
		FormField field = amountFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderShippingGroupForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public SupplyOrderShippingGroupForm amountField(){
		return amountField("amount","");
	}

	
	


	public SupplyOrderShippingGroupForm supplyOrderIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm supplyOrderIdFieldOfSupplyOrder(String initValue){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderShippingGroupForm supplyOrderIdFieldOfSupplyOrder(){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderShippingGroupForm buyerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm buyerIdFieldOfSupplyOrder(String initValue){
		return buyerIdFieldOfSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderShippingGroupForm buyerIdFieldOfSupplyOrder(){
		return buyerIdFieldOfSupplyOrder("buyerId","");
	}


	public SupplyOrderShippingGroupForm sellerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm sellerIdFieldOfSupplyOrder(String initValue){
		return sellerIdFieldOfSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderShippingGroupForm sellerIdFieldOfSupplyOrder(){
		return sellerIdFieldOfSupplyOrder("sellerId","");
	}


	public SupplyOrderShippingGroupForm titleFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm titleFieldOfSupplyOrder(String initValue){
		return titleFieldOfSupplyOrder("title",initValue);
	}
	public SupplyOrderShippingGroupForm titleFieldOfSupplyOrder(){
		return titleFieldOfSupplyOrder("title","");
	}


	public SupplyOrderShippingGroupForm totalAmountFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm totalAmountFieldOfSupplyOrder(String initValue){
		return totalAmountFieldOfSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderShippingGroupForm totalAmountFieldOfSupplyOrder(){
		return totalAmountFieldOfSupplyOrder("totalAmount","");
	}


	public SupplyOrderShippingGroupForm confirmationIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm confirmationIdFieldOfSupplyOrder(String initValue){
		return confirmationIdFieldOfSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderShippingGroupForm confirmationIdFieldOfSupplyOrder(){
		return confirmationIdFieldOfSupplyOrder("confirmationId","");
	}


	public SupplyOrderShippingGroupForm approvalIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm approvalIdFieldOfSupplyOrder(String initValue){
		return approvalIdFieldOfSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderShippingGroupForm approvalIdFieldOfSupplyOrder(){
		return approvalIdFieldOfSupplyOrder("approvalId","");
	}


	public SupplyOrderShippingGroupForm processingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm processingIdFieldOfSupplyOrder(String initValue){
		return processingIdFieldOfSupplyOrder("processingId",initValue);
	}
	public SupplyOrderShippingGroupForm processingIdFieldOfSupplyOrder(){
		return processingIdFieldOfSupplyOrder("processingId","");
	}


	public SupplyOrderShippingGroupForm pickingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm pickingIdFieldOfSupplyOrder(String initValue){
		return pickingIdFieldOfSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderShippingGroupForm pickingIdFieldOfSupplyOrder(){
		return pickingIdFieldOfSupplyOrder("pickingId","");
	}


	public SupplyOrderShippingGroupForm shipmentIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm shipmentIdFieldOfSupplyOrder(String initValue){
		return shipmentIdFieldOfSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderShippingGroupForm shipmentIdFieldOfSupplyOrder(){
		return shipmentIdFieldOfSupplyOrder("shipmentId","");
	}


	public SupplyOrderShippingGroupForm deliveryIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm deliveryIdFieldOfSupplyOrder(String initValue){
		return deliveryIdFieldOfSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderShippingGroupForm deliveryIdFieldOfSupplyOrder(){
		return deliveryIdFieldOfSupplyOrder("deliveryId","");
	}


	public SupplyOrderShippingGroupForm lastUpdateTimeFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm lastUpdateTimeFieldOfSupplyOrder(String initValue){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderShippingGroupForm lastUpdateTimeFieldOfSupplyOrder(){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderShippingGroupForm currentStatusFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderShippingGroupForm currentStatusFieldOfSupplyOrder(String initValue){
		return currentStatusFieldOfSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderShippingGroupForm currentStatusFieldOfSupplyOrder(){
		return currentStatusFieldOfSupplyOrder("currentStatus","");
	}

	


	

	
 	public SupplyOrderShippingGroupForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/supplyOrderShippingGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public SupplyOrderShippingGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



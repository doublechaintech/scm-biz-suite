package com.doublechaintech.retailscm.supplyorderpaymentgroup;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderPaymentGroupForm extends BaseForm {
	
	
	public SupplyOrderPaymentGroupForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderPaymentGroupForm supplyOrderPaymentGroupIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPaymentGroupForm supplyOrderPaymentGroupIdField(String initValue){
		return supplyOrderPaymentGroupIdField("supplyOrderPaymentGroupId",initValue);
	}
	public SupplyOrderPaymentGroupForm supplyOrderPaymentGroupIdField(){
		return supplyOrderPaymentGroupIdField("supplyOrderPaymentGroupId","");
	}


	public SupplyOrderPaymentGroupForm nameField(String parameterName, String initValue){
		FormField field = nameFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPaymentGroupForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public SupplyOrderPaymentGroupForm nameField(){
		return nameField("name","");
	}


	public SupplyOrderPaymentGroupForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPaymentGroupForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public SupplyOrderPaymentGroupForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public SupplyOrderPaymentGroupForm cardNumberField(String parameterName, String initValue){
		FormField field = cardNumberFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPaymentGroupForm cardNumberField(String initValue){
		return cardNumberField("cardNumber",initValue);
	}
	public SupplyOrderPaymentGroupForm cardNumberField(){
		return cardNumberField("cardNumber","");
	}

	
	


	public SupplyOrderPaymentGroupForm supplyOrderIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm supplyOrderIdFieldOfSupplyOrder(String initValue){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderPaymentGroupForm supplyOrderIdFieldOfSupplyOrder(){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderPaymentGroupForm buyerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm buyerIdFieldOfSupplyOrder(String initValue){
		return buyerIdFieldOfSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderPaymentGroupForm buyerIdFieldOfSupplyOrder(){
		return buyerIdFieldOfSupplyOrder("buyerId","");
	}


	public SupplyOrderPaymentGroupForm sellerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm sellerIdFieldOfSupplyOrder(String initValue){
		return sellerIdFieldOfSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderPaymentGroupForm sellerIdFieldOfSupplyOrder(){
		return sellerIdFieldOfSupplyOrder("sellerId","");
	}


	public SupplyOrderPaymentGroupForm titleFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm titleFieldOfSupplyOrder(String initValue){
		return titleFieldOfSupplyOrder("title",initValue);
	}
	public SupplyOrderPaymentGroupForm titleFieldOfSupplyOrder(){
		return titleFieldOfSupplyOrder("title","");
	}


	public SupplyOrderPaymentGroupForm totalAmountFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm totalAmountFieldOfSupplyOrder(String initValue){
		return totalAmountFieldOfSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderPaymentGroupForm totalAmountFieldOfSupplyOrder(){
		return totalAmountFieldOfSupplyOrder("totalAmount","");
	}


	public SupplyOrderPaymentGroupForm confirmationIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm confirmationIdFieldOfSupplyOrder(String initValue){
		return confirmationIdFieldOfSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderPaymentGroupForm confirmationIdFieldOfSupplyOrder(){
		return confirmationIdFieldOfSupplyOrder("confirmationId","");
	}


	public SupplyOrderPaymentGroupForm approvalIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm approvalIdFieldOfSupplyOrder(String initValue){
		return approvalIdFieldOfSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderPaymentGroupForm approvalIdFieldOfSupplyOrder(){
		return approvalIdFieldOfSupplyOrder("approvalId","");
	}


	public SupplyOrderPaymentGroupForm processingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm processingIdFieldOfSupplyOrder(String initValue){
		return processingIdFieldOfSupplyOrder("processingId",initValue);
	}
	public SupplyOrderPaymentGroupForm processingIdFieldOfSupplyOrder(){
		return processingIdFieldOfSupplyOrder("processingId","");
	}


	public SupplyOrderPaymentGroupForm pickingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm pickingIdFieldOfSupplyOrder(String initValue){
		return pickingIdFieldOfSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderPaymentGroupForm pickingIdFieldOfSupplyOrder(){
		return pickingIdFieldOfSupplyOrder("pickingId","");
	}


	public SupplyOrderPaymentGroupForm shipmentIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm shipmentIdFieldOfSupplyOrder(String initValue){
		return shipmentIdFieldOfSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderPaymentGroupForm shipmentIdFieldOfSupplyOrder(){
		return shipmentIdFieldOfSupplyOrder("shipmentId","");
	}


	public SupplyOrderPaymentGroupForm deliveryIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm deliveryIdFieldOfSupplyOrder(String initValue){
		return deliveryIdFieldOfSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderPaymentGroupForm deliveryIdFieldOfSupplyOrder(){
		return deliveryIdFieldOfSupplyOrder("deliveryId","");
	}


	public SupplyOrderPaymentGroupForm lastUpdateTimeFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm lastUpdateTimeFieldOfSupplyOrder(String initValue){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderPaymentGroupForm lastUpdateTimeFieldOfSupplyOrder(){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderPaymentGroupForm currentStatusFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderPaymentGroupForm currentStatusFieldOfSupplyOrder(String initValue){
		return currentStatusFieldOfSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderPaymentGroupForm currentStatusFieldOfSupplyOrder(){
		return currentStatusFieldOfSupplyOrder("currentStatus","");
	}

	


	

	
 	public SupplyOrderPaymentGroupForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/supplyOrderPaymentGroupId/");
		this.addFormAction(action);
		return this;
	}

 

	public SupplyOrderPaymentGroupForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



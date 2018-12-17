package com.doublechaintech.retailscm.supplyorderpicking;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderPickingForm extends BaseForm {
	
	
	public SupplyOrderPickingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderPickingForm supplyOrderPickingIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrderPicking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm supplyOrderPickingIdField(String initValue){
		return supplyOrderPickingIdField("supplyOrderPickingId",initValue);
	}
	public SupplyOrderPickingForm supplyOrderPickingIdField(){
		return supplyOrderPickingIdField("supplyOrderPickingId","");
	}


	public SupplyOrderPickingForm whoField(String parameterName, String initValue){
		FormField field = whoFromSupplyOrderPicking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public SupplyOrderPickingForm whoField(){
		return whoField("who","");
	}


	public SupplyOrderPickingForm processTimeField(String parameterName, String initValue){
		FormField field = processTimeFromSupplyOrderPicking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm processTimeField(String initValue){
		return processTimeField("processTime",initValue);
	}
	public SupplyOrderPickingForm processTimeField(){
		return processTimeField("processTime","");
	}

	
	

	



	public SupplyOrderPickingForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public SupplyOrderPickingForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public SupplyOrderPickingForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public SupplyOrderPickingForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public SupplyOrderPickingForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public SupplyOrderPickingForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public SupplyOrderPickingForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public SupplyOrderPickingForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public SupplyOrderPickingForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public SupplyOrderPickingForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public SupplyOrderPickingForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public SupplyOrderPickingForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public SupplyOrderPickingForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public SupplyOrderPickingForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public SupplyOrderPickingForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public SupplyOrderPickingForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public SupplyOrderPickingForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public SupplyOrderPickingForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public SupplyOrderPickingForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public SupplyOrderPickingForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public SupplyOrderPickingForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public SupplyOrderPickingForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public SupplyOrderPickingForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public SupplyOrderPickingForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public SupplyOrderPickingForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderPickingForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public SupplyOrderPickingForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}

	



	public SupplyOrderPickingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



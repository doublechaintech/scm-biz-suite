package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreMemberGiftCardConsumeRecordForm extends BaseForm {
	
	
	public RetailStoreMemberGiftCardConsumeRecordForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreMemberGiftCardConsumeRecordForm retailStoreMemberGiftCardConsumeRecordIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm retailStoreMemberGiftCardConsumeRecordIdField(String initValue){
		return retailStoreMemberGiftCardConsumeRecordIdField("retailStoreMemberGiftCardConsumeRecordId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm retailStoreMemberGiftCardConsumeRecordIdField(){
		return retailStoreMemberGiftCardConsumeRecordIdField("retailStoreMemberGiftCardConsumeRecordId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm occureTimeField(String parameterName, String initValue){
		FormField field = occureTimeFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm occureTimeField(String initValue){
		return occureTimeField("occureTime",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm occureTimeField(){
		return occureTimeField("occureTime","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm ownerIdField(){
		return ownerIdField("ownerId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm numberField(String parameterName, String initValue){
		FormField field = numberFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm numberField(String initValue){
		return numberField("number",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm numberField(){
		return numberField("number","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm amountField(String parameterName, String initValue){
		FormField field = amountFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm amountField(){
		return amountField("amount","");
	}

	
	


	public RetailStoreMemberGiftCardConsumeRecordForm retailStoreMemberGiftCardIdFieldOfRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMemberGiftCard(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm retailStoreMemberGiftCardIdFieldOfRetailStoreMemberGiftCard(String initValue){
		return retailStoreMemberGiftCardIdFieldOfRetailStoreMemberGiftCard("retailStoreMemberGiftCardId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm retailStoreMemberGiftCardIdFieldOfRetailStoreMemberGiftCard(){
		return retailStoreMemberGiftCardIdFieldOfRetailStoreMemberGiftCard("retailStoreMemberGiftCardId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm nameFieldOfRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMemberGiftCard(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm nameFieldOfRetailStoreMemberGiftCard(String initValue){
		return nameFieldOfRetailStoreMemberGiftCard("name",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm nameFieldOfRetailStoreMemberGiftCard(){
		return nameFieldOfRetailStoreMemberGiftCard("name","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm ownerIdFieldOfRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMemberGiftCard(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm ownerIdFieldOfRetailStoreMemberGiftCard(String initValue){
		return ownerIdFieldOfRetailStoreMemberGiftCard("ownerId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm ownerIdFieldOfRetailStoreMemberGiftCard(){
		return ownerIdFieldOfRetailStoreMemberGiftCard("ownerId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm numberFieldOfRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  numberFromRetailStoreMemberGiftCard(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm numberFieldOfRetailStoreMemberGiftCard(String initValue){
		return numberFieldOfRetailStoreMemberGiftCard("number",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm numberFieldOfRetailStoreMemberGiftCard(){
		return numberFieldOfRetailStoreMemberGiftCard("number","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm remainFieldOfRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  remainFromRetailStoreMemberGiftCard(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm remainFieldOfRetailStoreMemberGiftCard(String initValue){
		return remainFieldOfRetailStoreMemberGiftCard("remain",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm remainFieldOfRetailStoreMemberGiftCard(){
		return remainFieldOfRetailStoreMemberGiftCard("remain","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm consumerOrderIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm consumerOrderIdFieldOfConsumerOrder(String initValue){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm consumerOrderIdFieldOfConsumerOrder(){
		return consumerOrderIdFieldOfConsumerOrder("consumerOrderId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm titleFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm titleFieldOfConsumerOrder(String initValue){
		return titleFieldOfConsumerOrder("title",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm titleFieldOfConsumerOrder(){
		return titleFieldOfConsumerOrder("title","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm consumerIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm consumerIdFieldOfConsumerOrder(String initValue){
		return consumerIdFieldOfConsumerOrder("consumerId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm consumerIdFieldOfConsumerOrder(){
		return consumerIdFieldOfConsumerOrder("consumerId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm confirmationIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm confirmationIdFieldOfConsumerOrder(String initValue){
		return confirmationIdFieldOfConsumerOrder("confirmationId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm confirmationIdFieldOfConsumerOrder(){
		return confirmationIdFieldOfConsumerOrder("confirmationId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm approvalIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm approvalIdFieldOfConsumerOrder(String initValue){
		return approvalIdFieldOfConsumerOrder("approvalId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm approvalIdFieldOfConsumerOrder(){
		return approvalIdFieldOfConsumerOrder("approvalId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm processingIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm processingIdFieldOfConsumerOrder(String initValue){
		return processingIdFieldOfConsumerOrder("processingId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm processingIdFieldOfConsumerOrder(){
		return processingIdFieldOfConsumerOrder("processingId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm shipmentIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm shipmentIdFieldOfConsumerOrder(String initValue){
		return shipmentIdFieldOfConsumerOrder("shipmentId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm shipmentIdFieldOfConsumerOrder(){
		return shipmentIdFieldOfConsumerOrder("shipmentId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm deliveryIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm deliveryIdFieldOfConsumerOrder(String initValue){
		return deliveryIdFieldOfConsumerOrder("deliveryId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm deliveryIdFieldOfConsumerOrder(){
		return deliveryIdFieldOfConsumerOrder("deliveryId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm storeIdFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm storeIdFieldOfConsumerOrder(String initValue){
		return storeIdFieldOfConsumerOrder("storeId",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm storeIdFieldOfConsumerOrder(){
		return storeIdFieldOfConsumerOrder("storeId","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm lastUpdateTimeFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm lastUpdateTimeFieldOfConsumerOrder(String initValue){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm lastUpdateTimeFieldOfConsumerOrder(){
		return lastUpdateTimeFieldOfConsumerOrder("lastUpdateTime","");
	}


	public RetailStoreMemberGiftCardConsumeRecordForm currentStatusFieldOfConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardConsumeRecordForm currentStatusFieldOfConsumerOrder(String initValue){
		return currentStatusFieldOfConsumerOrder("currentStatus",initValue);
	}
	public RetailStoreMemberGiftCardConsumeRecordForm currentStatusFieldOfConsumerOrder(){
		return currentStatusFieldOfConsumerOrder("currentStatus","");
	}

	


	

	
 	public RetailStoreMemberGiftCardConsumeRecordForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/retailStoreMemberGiftCardConsumeRecordId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RetailStoreMemberGiftCardConsumeRecordForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/retailStoreMemberGiftCardConsumeRecordId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreMemberGiftCardConsumeRecordForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.consumerorder;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderForm extends BaseForm {
	
	
	public ConsumerOrderForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderForm consumerOrderIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm consumerOrderIdField(String initValue){
		return consumerOrderIdField("consumerOrderId",initValue);
	}
	public ConsumerOrderForm consumerOrderIdField(){
		return consumerOrderIdField("consumerOrderId","");
	}


	public ConsumerOrderForm titleField(String parameterName, String initValue){
		FormField field = titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public ConsumerOrderForm titleField(){
		return titleField("title","");
	}


	public ConsumerOrderForm consumerIdField(String parameterName, String initValue){
		FormField field = consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm consumerIdField(String initValue){
		return consumerIdField("consumerId",initValue);
	}
	public ConsumerOrderForm consumerIdField(){
		return consumerIdField("consumerId","");
	}


	public ConsumerOrderForm confirmationIdField(String parameterName, String initValue){
		FormField field = confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm confirmationIdField(String initValue){
		return confirmationIdField("confirmationId",initValue);
	}
	public ConsumerOrderForm confirmationIdField(){
		return confirmationIdField("confirmationId","");
	}


	public ConsumerOrderForm approvalIdField(String parameterName, String initValue){
		FormField field = approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm approvalIdField(String initValue){
		return approvalIdField("approvalId",initValue);
	}
	public ConsumerOrderForm approvalIdField(){
		return approvalIdField("approvalId","");
	}


	public ConsumerOrderForm processingIdField(String parameterName, String initValue){
		FormField field = processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm processingIdField(String initValue){
		return processingIdField("processingId",initValue);
	}
	public ConsumerOrderForm processingIdField(){
		return processingIdField("processingId","");
	}


	public ConsumerOrderForm shipmentIdField(String parameterName, String initValue){
		FormField field = shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm shipmentIdField(String initValue){
		return shipmentIdField("shipmentId",initValue);
	}
	public ConsumerOrderForm shipmentIdField(){
		return shipmentIdField("shipmentId","");
	}


	public ConsumerOrderForm deliveryIdField(String parameterName, String initValue){
		FormField field = deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm deliveryIdField(String initValue){
		return deliveryIdField("deliveryId",initValue);
	}
	public ConsumerOrderForm deliveryIdField(){
		return deliveryIdField("deliveryId","");
	}


	public ConsumerOrderForm storeIdField(String parameterName, String initValue){
		FormField field = storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm storeIdField(String initValue){
		return storeIdField("storeId",initValue);
	}
	public ConsumerOrderForm storeIdField(){
		return storeIdField("storeId","");
	}


	public ConsumerOrderForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ConsumerOrderForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public ConsumerOrderForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public ConsumerOrderForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public ConsumerOrderForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public ConsumerOrderForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public ConsumerOrderForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public ConsumerOrderForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public ConsumerOrderForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public ConsumerOrderForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public ConsumerOrderForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public ConsumerOrderForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}


	public ConsumerOrderForm supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation(String initValue){
		return supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation("supplyOrderConfirmationId",initValue);
	}
	public ConsumerOrderForm supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation(){
		return supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation("supplyOrderConfirmationId","");
	}


	public ConsumerOrderForm whoFieldOfSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm whoFieldOfSupplyOrderConfirmation(String initValue){
		return whoFieldOfSupplyOrderConfirmation("who",initValue);
	}
	public ConsumerOrderForm whoFieldOfSupplyOrderConfirmation(){
		return whoFieldOfSupplyOrderConfirmation("who","");
	}


	public ConsumerOrderForm confirmTimeFieldOfSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field =  confirmTimeFromSupplyOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm confirmTimeFieldOfSupplyOrderConfirmation(String initValue){
		return confirmTimeFieldOfSupplyOrderConfirmation("confirmTime",initValue);
	}
	public ConsumerOrderForm confirmTimeFieldOfSupplyOrderConfirmation(){
		return confirmTimeFieldOfSupplyOrderConfirmation("confirmTime","");
	}


	public ConsumerOrderForm supplyOrderApprovalIdFieldOfSupplyOrderApproval(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm supplyOrderApprovalIdFieldOfSupplyOrderApproval(String initValue){
		return supplyOrderApprovalIdFieldOfSupplyOrderApproval("supplyOrderApprovalId",initValue);
	}
	public ConsumerOrderForm supplyOrderApprovalIdFieldOfSupplyOrderApproval(){
		return supplyOrderApprovalIdFieldOfSupplyOrderApproval("supplyOrderApprovalId","");
	}


	public ConsumerOrderForm whoFieldOfSupplyOrderApproval(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm whoFieldOfSupplyOrderApproval(String initValue){
		return whoFieldOfSupplyOrderApproval("who",initValue);
	}
	public ConsumerOrderForm whoFieldOfSupplyOrderApproval(){
		return whoFieldOfSupplyOrderApproval("who","");
	}


	public ConsumerOrderForm approveTimeFieldOfSupplyOrderApproval(String parameterName, String initValue){
		FormField field =  approveTimeFromSupplyOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm approveTimeFieldOfSupplyOrderApproval(String initValue){
		return approveTimeFieldOfSupplyOrderApproval("approveTime",initValue);
	}
	public ConsumerOrderForm approveTimeFieldOfSupplyOrderApproval(){
		return approveTimeFieldOfSupplyOrderApproval("approveTime","");
	}


	public ConsumerOrderForm supplyOrderProcessingIdFieldOfSupplyOrderProcessing(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm supplyOrderProcessingIdFieldOfSupplyOrderProcessing(String initValue){
		return supplyOrderProcessingIdFieldOfSupplyOrderProcessing("supplyOrderProcessingId",initValue);
	}
	public ConsumerOrderForm supplyOrderProcessingIdFieldOfSupplyOrderProcessing(){
		return supplyOrderProcessingIdFieldOfSupplyOrderProcessing("supplyOrderProcessingId","");
	}


	public ConsumerOrderForm whoFieldOfSupplyOrderProcessing(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm whoFieldOfSupplyOrderProcessing(String initValue){
		return whoFieldOfSupplyOrderProcessing("who",initValue);
	}
	public ConsumerOrderForm whoFieldOfSupplyOrderProcessing(){
		return whoFieldOfSupplyOrderProcessing("who","");
	}


	public ConsumerOrderForm processTimeFieldOfSupplyOrderProcessing(String parameterName, String initValue){
		FormField field =  processTimeFromSupplyOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm processTimeFieldOfSupplyOrderProcessing(String initValue){
		return processTimeFieldOfSupplyOrderProcessing("processTime",initValue);
	}
	public ConsumerOrderForm processTimeFieldOfSupplyOrderProcessing(){
		return processTimeFieldOfSupplyOrderProcessing("processTime","");
	}


	public ConsumerOrderForm supplyOrderShipmentIdFieldOfSupplyOrderShipment(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm supplyOrderShipmentIdFieldOfSupplyOrderShipment(String initValue){
		return supplyOrderShipmentIdFieldOfSupplyOrderShipment("supplyOrderShipmentId",initValue);
	}
	public ConsumerOrderForm supplyOrderShipmentIdFieldOfSupplyOrderShipment(){
		return supplyOrderShipmentIdFieldOfSupplyOrderShipment("supplyOrderShipmentId","");
	}


	public ConsumerOrderForm whoFieldOfSupplyOrderShipment(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm whoFieldOfSupplyOrderShipment(String initValue){
		return whoFieldOfSupplyOrderShipment("who",initValue);
	}
	public ConsumerOrderForm whoFieldOfSupplyOrderShipment(){
		return whoFieldOfSupplyOrderShipment("who","");
	}


	public ConsumerOrderForm shipTimeFieldOfSupplyOrderShipment(String parameterName, String initValue){
		FormField field =  shipTimeFromSupplyOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm shipTimeFieldOfSupplyOrderShipment(String initValue){
		return shipTimeFieldOfSupplyOrderShipment("shipTime",initValue);
	}
	public ConsumerOrderForm shipTimeFieldOfSupplyOrderShipment(){
		return shipTimeFieldOfSupplyOrderShipment("shipTime","");
	}


	public ConsumerOrderForm supplyOrderDeliveryIdFieldOfSupplyOrderDelivery(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm supplyOrderDeliveryIdFieldOfSupplyOrderDelivery(String initValue){
		return supplyOrderDeliveryIdFieldOfSupplyOrderDelivery("supplyOrderDeliveryId",initValue);
	}
	public ConsumerOrderForm supplyOrderDeliveryIdFieldOfSupplyOrderDelivery(){
		return supplyOrderDeliveryIdFieldOfSupplyOrderDelivery("supplyOrderDeliveryId","");
	}


	public ConsumerOrderForm whoFieldOfSupplyOrderDelivery(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm whoFieldOfSupplyOrderDelivery(String initValue){
		return whoFieldOfSupplyOrderDelivery("who",initValue);
	}
	public ConsumerOrderForm whoFieldOfSupplyOrderDelivery(){
		return whoFieldOfSupplyOrderDelivery("who","");
	}


	public ConsumerOrderForm deliveryTimeFieldOfSupplyOrderDelivery(String parameterName, String initValue){
		FormField field =  deliveryTimeFromSupplyOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm deliveryTimeFieldOfSupplyOrderDelivery(String initValue){
		return deliveryTimeFieldOfSupplyOrderDelivery("deliveryTime",initValue);
	}
	public ConsumerOrderForm deliveryTimeFieldOfSupplyOrderDelivery(){
		return deliveryTimeFieldOfSupplyOrderDelivery("deliveryTime","");
	}


	public ConsumerOrderForm retailStoreIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm retailStoreIdFieldOfRetailStore(String initValue){
		return retailStoreIdFieldOfRetailStore("retailStoreId",initValue);
	}
	public ConsumerOrderForm retailStoreIdFieldOfRetailStore(){
		return retailStoreIdFieldOfRetailStore("retailStoreId","");
	}


	public ConsumerOrderForm nameFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm nameFieldOfRetailStore(String initValue){
		return nameFieldOfRetailStore("name",initValue);
	}
	public ConsumerOrderForm nameFieldOfRetailStore(){
		return nameFieldOfRetailStore("name","");
	}


	public ConsumerOrderForm telephoneFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm telephoneFieldOfRetailStore(String initValue){
		return telephoneFieldOfRetailStore("telephone",initValue);
	}
	public ConsumerOrderForm telephoneFieldOfRetailStore(){
		return telephoneFieldOfRetailStore("telephone","");
	}


	public ConsumerOrderForm ownerFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm ownerFieldOfRetailStore(String initValue){
		return ownerFieldOfRetailStore("owner",initValue);
	}
	public ConsumerOrderForm ownerFieldOfRetailStore(){
		return ownerFieldOfRetailStore("owner","");
	}


	public ConsumerOrderForm retailStoreCountryCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm retailStoreCountryCenterIdFieldOfRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId",initValue);
	}
	public ConsumerOrderForm retailStoreCountryCenterIdFieldOfRetailStore(){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId","");
	}


	public ConsumerOrderForm cityServiceCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm cityServiceCenterIdFieldOfRetailStore(String initValue){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId",initValue);
	}
	public ConsumerOrderForm cityServiceCenterIdFieldOfRetailStore(){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId","");
	}


	public ConsumerOrderForm creationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm creationIdFieldOfRetailStore(String initValue){
		return creationIdFieldOfRetailStore("creationId",initValue);
	}
	public ConsumerOrderForm creationIdFieldOfRetailStore(){
		return creationIdFieldOfRetailStore("creationId","");
	}


	public ConsumerOrderForm investmentInvitationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm investmentInvitationIdFieldOfRetailStore(String initValue){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId",initValue);
	}
	public ConsumerOrderForm investmentInvitationIdFieldOfRetailStore(){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId","");
	}


	public ConsumerOrderForm franchisingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm franchisingIdFieldOfRetailStore(String initValue){
		return franchisingIdFieldOfRetailStore("franchisingId",initValue);
	}
	public ConsumerOrderForm franchisingIdFieldOfRetailStore(){
		return franchisingIdFieldOfRetailStore("franchisingId","");
	}


	public ConsumerOrderForm decorationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm decorationIdFieldOfRetailStore(String initValue){
		return decorationIdFieldOfRetailStore("decorationId",initValue);
	}
	public ConsumerOrderForm decorationIdFieldOfRetailStore(){
		return decorationIdFieldOfRetailStore("decorationId","");
	}


	public ConsumerOrderForm openingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm openingIdFieldOfRetailStore(String initValue){
		return openingIdFieldOfRetailStore("openingId",initValue);
	}
	public ConsumerOrderForm openingIdFieldOfRetailStore(){
		return openingIdFieldOfRetailStore("openingId","");
	}


	public ConsumerOrderForm closingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm closingIdFieldOfRetailStore(String initValue){
		return closingIdFieldOfRetailStore("closingId",initValue);
	}
	public ConsumerOrderForm closingIdFieldOfRetailStore(){
		return closingIdFieldOfRetailStore("closingId","");
	}


	public ConsumerOrderForm foundedFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm foundedFieldOfRetailStore(String initValue){
		return foundedFieldOfRetailStore("founded",initValue);
	}
	public ConsumerOrderForm foundedFieldOfRetailStore(){
		return foundedFieldOfRetailStore("founded","");
	}


	public ConsumerOrderForm latitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm latitudeFieldOfRetailStore(String initValue){
		return latitudeFieldOfRetailStore("latitude",initValue);
	}
	public ConsumerOrderForm latitudeFieldOfRetailStore(){
		return latitudeFieldOfRetailStore("latitude","");
	}


	public ConsumerOrderForm longitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm longitudeFieldOfRetailStore(String initValue){
		return longitudeFieldOfRetailStore("longitude",initValue);
	}
	public ConsumerOrderForm longitudeFieldOfRetailStore(){
		return longitudeFieldOfRetailStore("longitude","");
	}


	public ConsumerOrderForm descriptionFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm descriptionFieldOfRetailStore(String initValue){
		return descriptionFieldOfRetailStore("description",initValue);
	}
	public ConsumerOrderForm descriptionFieldOfRetailStore(){
		return descriptionFieldOfRetailStore("description","");
	}


	public ConsumerOrderForm lastUpdateTimeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm lastUpdateTimeFieldOfRetailStore(String initValue){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime",initValue);
	}
	public ConsumerOrderForm lastUpdateTimeFieldOfRetailStore(){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime","");
	}


	public ConsumerOrderForm currentStatusFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ConsumerOrderForm currentStatusFieldOfRetailStore(String initValue){
		return currentStatusFieldOfRetailStore("currentStatus",initValue);
	}
	public ConsumerOrderForm currentStatusFieldOfRetailStore(){
		return currentStatusFieldOfRetailStore("currentStatus","");
	}

	



	public ConsumerOrderForm consumerOrderLineItemIdFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  idFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm consumerOrderLineItemIdFieldForConsumerOrderLineItem(String initValue){
		return consumerOrderLineItemIdFieldForConsumerOrderLineItem("consumerOrderLineItemId",initValue);
	}
	public ConsumerOrderForm consumerOrderLineItemIdFieldForConsumerOrderLineItem(){
		return consumerOrderLineItemIdFieldForConsumerOrderLineItem("consumerOrderLineItemId","");
	}


	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  bizOrderIdFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderLineItem(String initValue){
		return bizOrderIdFieldForConsumerOrderLineItem("bizOrderId",initValue);
	}
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderLineItem(){
		return bizOrderIdFieldForConsumerOrderLineItem("bizOrderId","");
	}


	public ConsumerOrderForm skuIdFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  skuIdFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm skuIdFieldForConsumerOrderLineItem(String initValue){
		return skuIdFieldForConsumerOrderLineItem("skuId",initValue);
	}
	public ConsumerOrderForm skuIdFieldForConsumerOrderLineItem(){
		return skuIdFieldForConsumerOrderLineItem("skuId","");
	}


	public ConsumerOrderForm skuNameFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  skuNameFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm skuNameFieldForConsumerOrderLineItem(String initValue){
		return skuNameFieldForConsumerOrderLineItem("skuName",initValue);
	}
	public ConsumerOrderForm skuNameFieldForConsumerOrderLineItem(){
		return skuNameFieldForConsumerOrderLineItem("skuName","");
	}


	public ConsumerOrderForm priceFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  priceFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm priceFieldForConsumerOrderLineItem(String initValue){
		return priceFieldForConsumerOrderLineItem("price",initValue);
	}
	public ConsumerOrderForm priceFieldForConsumerOrderLineItem(){
		return priceFieldForConsumerOrderLineItem("price","");
	}


	public ConsumerOrderForm quantityFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  quantityFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm quantityFieldForConsumerOrderLineItem(String initValue){
		return quantityFieldForConsumerOrderLineItem("quantity",initValue);
	}
	public ConsumerOrderForm quantityFieldForConsumerOrderLineItem(){
		return quantityFieldForConsumerOrderLineItem("quantity","");
	}


	public ConsumerOrderForm amountFieldForConsumerOrderLineItem(String parameterName, String initValue){
		FormField field =  amountFromConsumerOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm amountFieldForConsumerOrderLineItem(String initValue){
		return amountFieldForConsumerOrderLineItem("amount",initValue);
	}
	public ConsumerOrderForm amountFieldForConsumerOrderLineItem(){
		return amountFieldForConsumerOrderLineItem("amount","");
	}


	public ConsumerOrderForm consumerOrderShippingGroupIdFieldForConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field =  idFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm consumerOrderShippingGroupIdFieldForConsumerOrderShippingGroup(String initValue){
		return consumerOrderShippingGroupIdFieldForConsumerOrderShippingGroup("consumerOrderShippingGroupId",initValue);
	}
	public ConsumerOrderForm consumerOrderShippingGroupIdFieldForConsumerOrderShippingGroup(){
		return consumerOrderShippingGroupIdFieldForConsumerOrderShippingGroup("consumerOrderShippingGroupId","");
	}


	public ConsumerOrderForm nameFieldForConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field =  nameFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm nameFieldForConsumerOrderShippingGroup(String initValue){
		return nameFieldForConsumerOrderShippingGroup("name",initValue);
	}
	public ConsumerOrderForm nameFieldForConsumerOrderShippingGroup(){
		return nameFieldForConsumerOrderShippingGroup("name","");
	}


	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field =  bizOrderIdFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderShippingGroup(String initValue){
		return bizOrderIdFieldForConsumerOrderShippingGroup("bizOrderId",initValue);
	}
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderShippingGroup(){
		return bizOrderIdFieldForConsumerOrderShippingGroup("bizOrderId","");
	}


	public ConsumerOrderForm amountFieldForConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field =  amountFromConsumerOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm amountFieldForConsumerOrderShippingGroup(String initValue){
		return amountFieldForConsumerOrderShippingGroup("amount",initValue);
	}
	public ConsumerOrderForm amountFieldForConsumerOrderShippingGroup(){
		return amountFieldForConsumerOrderShippingGroup("amount","");
	}


	public ConsumerOrderForm consumerOrderPaymentGroupIdFieldForConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  idFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm consumerOrderPaymentGroupIdFieldForConsumerOrderPaymentGroup(String initValue){
		return consumerOrderPaymentGroupIdFieldForConsumerOrderPaymentGroup("consumerOrderPaymentGroupId",initValue);
	}
	public ConsumerOrderForm consumerOrderPaymentGroupIdFieldForConsumerOrderPaymentGroup(){
		return consumerOrderPaymentGroupIdFieldForConsumerOrderPaymentGroup("consumerOrderPaymentGroupId","");
	}


	public ConsumerOrderForm nameFieldForConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  nameFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm nameFieldForConsumerOrderPaymentGroup(String initValue){
		return nameFieldForConsumerOrderPaymentGroup("name",initValue);
	}
	public ConsumerOrderForm nameFieldForConsumerOrderPaymentGroup(){
		return nameFieldForConsumerOrderPaymentGroup("name","");
	}


	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  bizOrderIdFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderPaymentGroup(String initValue){
		return bizOrderIdFieldForConsumerOrderPaymentGroup("bizOrderId",initValue);
	}
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderPaymentGroup(){
		return bizOrderIdFieldForConsumerOrderPaymentGroup("bizOrderId","");
	}


	public ConsumerOrderForm cardNumberFieldForConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  cardNumberFromConsumerOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm cardNumberFieldForConsumerOrderPaymentGroup(String initValue){
		return cardNumberFieldForConsumerOrderPaymentGroup("cardNumber",initValue);
	}
	public ConsumerOrderForm cardNumberFieldForConsumerOrderPaymentGroup(){
		return cardNumberFieldForConsumerOrderPaymentGroup("cardNumber","");
	}


	public ConsumerOrderForm consumerOrderPriceAdjustmentIdFieldForConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field =  idFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm consumerOrderPriceAdjustmentIdFieldForConsumerOrderPriceAdjustment(String initValue){
		return consumerOrderPriceAdjustmentIdFieldForConsumerOrderPriceAdjustment("consumerOrderPriceAdjustmentId",initValue);
	}
	public ConsumerOrderForm consumerOrderPriceAdjustmentIdFieldForConsumerOrderPriceAdjustment(){
		return consumerOrderPriceAdjustmentIdFieldForConsumerOrderPriceAdjustment("consumerOrderPriceAdjustmentId","");
	}


	public ConsumerOrderForm nameFieldForConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field =  nameFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm nameFieldForConsumerOrderPriceAdjustment(String initValue){
		return nameFieldForConsumerOrderPriceAdjustment("name",initValue);
	}
	public ConsumerOrderForm nameFieldForConsumerOrderPriceAdjustment(){
		return nameFieldForConsumerOrderPriceAdjustment("name","");
	}


	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field =  bizOrderIdFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderPriceAdjustment(String initValue){
		return bizOrderIdFieldForConsumerOrderPriceAdjustment("bizOrderId",initValue);
	}
	public ConsumerOrderForm bizOrderIdFieldForConsumerOrderPriceAdjustment(){
		return bizOrderIdFieldForConsumerOrderPriceAdjustment("bizOrderId","");
	}


	public ConsumerOrderForm amountFieldForConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field =  amountFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm amountFieldForConsumerOrderPriceAdjustment(String initValue){
		return amountFieldForConsumerOrderPriceAdjustment("amount",initValue);
	}
	public ConsumerOrderForm amountFieldForConsumerOrderPriceAdjustment(){
		return amountFieldForConsumerOrderPriceAdjustment("amount","");
	}


	public ConsumerOrderForm providerFieldForConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field =  providerFromConsumerOrderPriceAdjustment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm providerFieldForConsumerOrderPriceAdjustment(String initValue){
		return providerFieldForConsumerOrderPriceAdjustment("provider",initValue);
	}
	public ConsumerOrderForm providerFieldForConsumerOrderPriceAdjustment(){
		return providerFieldForConsumerOrderPriceAdjustment("provider","");
	}


	public ConsumerOrderForm retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord("retailStoreMemberGiftCardConsumeRecordId",initValue);
	}
	public ConsumerOrderForm retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord("retailStoreMemberGiftCardConsumeRecordId","");
	}


	public ConsumerOrderForm occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  occureTimeFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord("occureTime",initValue);
	}
	public ConsumerOrderForm occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord("occureTime","");
	}


	public ConsumerOrderForm ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord("ownerId",initValue);
	}
	public ConsumerOrderForm ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord("ownerId","");
	}


	public ConsumerOrderForm bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  bizOrderIdFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord("bizOrderId",initValue);
	}
	public ConsumerOrderForm bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord("bizOrderId","");
	}


	public ConsumerOrderForm numberFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  numberFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm numberFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return numberFieldForRetailStoreMemberGiftCardConsumeRecord("number",initValue);
	}
	public ConsumerOrderForm numberFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return numberFieldForRetailStoreMemberGiftCardConsumeRecord("number","");
	}


	public ConsumerOrderForm amountFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  amountFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderForm amountFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return amountFieldForRetailStoreMemberGiftCardConsumeRecord("amount",initValue);
	}
	public ConsumerOrderForm amountFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return amountFieldForRetailStoreMemberGiftCardConsumeRecord("amount","");
	}

	

	
 	public ConsumerOrderForm transferToAnotherConsumerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherConsumer/consumerOrderId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ConsumerOrderForm  confirmAction(){
		FormAction action = new FormAction();
		action.setLabel("确认");
		action.setLocaleKey("consumer_order.confirm");
		action.setUrl("consumerOrderManager/confirm/consumerOrderId/who/confirmTime/");
		this.addFormAction(action);
		return this;
	}	
 	public ConsumerOrderForm  approveAction(){
		FormAction action = new FormAction();
		action.setLabel("批准");
		action.setLocaleKey("consumer_order.approve");
		action.setUrl("consumerOrderManager/approve/consumerOrderId/who/approveTime/");
		this.addFormAction(action);
		return this;
	}	
 	public ConsumerOrderForm  processAction(){
		FormAction action = new FormAction();
		action.setLabel("过程");
		action.setLocaleKey("consumer_order.process");
		action.setUrl("consumerOrderManager/process/consumerOrderId/who/processTime/");
		this.addFormAction(action);
		return this;
	}	
 	public ConsumerOrderForm  shipAction(){
		FormAction action = new FormAction();
		action.setLabel("船");
		action.setLocaleKey("consumer_order.ship");
		action.setUrl("consumerOrderManager/ship/consumerOrderId/who/shipTime/");
		this.addFormAction(action);
		return this;
	}	
 	public ConsumerOrderForm  deliverAction(){
		FormAction action = new FormAction();
		action.setLabel("交付");
		action.setLocaleKey("consumer_order.deliver");
		action.setUrl("consumerOrderManager/deliver/consumerOrderId/who/deliveryTime/");
		this.addFormAction(action);
		return this;
	}	
 	public ConsumerOrderForm transferToAnotherStoreAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherStore/consumerOrderId/");
		this.addFormAction(action);
		return this;
	}

 

	public ConsumerOrderForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



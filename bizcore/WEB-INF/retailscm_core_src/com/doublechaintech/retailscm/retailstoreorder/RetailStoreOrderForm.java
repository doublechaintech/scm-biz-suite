package com.doublechaintech.retailscm.retailstoreorder;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreOrderForm extends BaseForm {
	
	
	public RetailStoreOrderForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreOrderForm retailStoreOrderIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderIdField(String initValue){
		return retailStoreOrderIdField("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderIdField(){
		return retailStoreOrderIdField("retailStoreOrderId","");
	}


	public RetailStoreOrderForm buyerIdField(String parameterName, String initValue){
		FormField field = buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm buyerIdField(String initValue){
		return buyerIdField("buyerId",initValue);
	}
	public RetailStoreOrderForm buyerIdField(){
		return buyerIdField("buyerId","");
	}


	public RetailStoreOrderForm sellerIdField(String parameterName, String initValue){
		FormField field = sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm sellerIdField(String initValue){
		return sellerIdField("sellerId",initValue);
	}
	public RetailStoreOrderForm sellerIdField(){
		return sellerIdField("sellerId","");
	}


	public RetailStoreOrderForm titleField(String parameterName, String initValue){
		FormField field = titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public RetailStoreOrderForm titleField(){
		return titleField("title","");
	}


	public RetailStoreOrderForm totalAmountField(String parameterName, String initValue){
		FormField field = totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm totalAmountField(String initValue){
		return totalAmountField("totalAmount",initValue);
	}
	public RetailStoreOrderForm totalAmountField(){
		return totalAmountField("totalAmount","");
	}


	public RetailStoreOrderForm confirmationIdField(String parameterName, String initValue){
		FormField field = confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm confirmationIdField(String initValue){
		return confirmationIdField("confirmationId",initValue);
	}
	public RetailStoreOrderForm confirmationIdField(){
		return confirmationIdField("confirmationId","");
	}


	public RetailStoreOrderForm approvalIdField(String parameterName, String initValue){
		FormField field = approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm approvalIdField(String initValue){
		return approvalIdField("approvalId",initValue);
	}
	public RetailStoreOrderForm approvalIdField(){
		return approvalIdField("approvalId","");
	}


	public RetailStoreOrderForm processingIdField(String parameterName, String initValue){
		FormField field = processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm processingIdField(String initValue){
		return processingIdField("processingId",initValue);
	}
	public RetailStoreOrderForm processingIdField(){
		return processingIdField("processingId","");
	}


	public RetailStoreOrderForm pickingIdField(String parameterName, String initValue){
		FormField field = pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm pickingIdField(String initValue){
		return pickingIdField("pickingId",initValue);
	}
	public RetailStoreOrderForm pickingIdField(){
		return pickingIdField("pickingId","");
	}


	public RetailStoreOrderForm shipmentIdField(String parameterName, String initValue){
		FormField field = shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm shipmentIdField(String initValue){
		return shipmentIdField("shipmentId",initValue);
	}
	public RetailStoreOrderForm shipmentIdField(){
		return shipmentIdField("shipmentId","");
	}


	public RetailStoreOrderForm deliveryIdField(String parameterName, String initValue){
		FormField field = deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm deliveryIdField(String initValue){
		return deliveryIdField("deliveryId",initValue);
	}
	public RetailStoreOrderForm deliveryIdField(){
		return deliveryIdField("deliveryId","");
	}


	public RetailStoreOrderForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public RetailStoreOrderForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public RetailStoreOrderForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public RetailStoreOrderForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public RetailStoreOrderForm retailStoreIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreIdFieldOfRetailStore(String initValue){
		return retailStoreIdFieldOfRetailStore("retailStoreId",initValue);
	}
	public RetailStoreOrderForm retailStoreIdFieldOfRetailStore(){
		return retailStoreIdFieldOfRetailStore("retailStoreId","");
	}


	public RetailStoreOrderForm nameFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm nameFieldOfRetailStore(String initValue){
		return nameFieldOfRetailStore("name",initValue);
	}
	public RetailStoreOrderForm nameFieldOfRetailStore(){
		return nameFieldOfRetailStore("name","");
	}


	public RetailStoreOrderForm telephoneFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm telephoneFieldOfRetailStore(String initValue){
		return telephoneFieldOfRetailStore("telephone",initValue);
	}
	public RetailStoreOrderForm telephoneFieldOfRetailStore(){
		return telephoneFieldOfRetailStore("telephone","");
	}


	public RetailStoreOrderForm ownerFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm ownerFieldOfRetailStore(String initValue){
		return ownerFieldOfRetailStore("owner",initValue);
	}
	public RetailStoreOrderForm ownerFieldOfRetailStore(){
		return ownerFieldOfRetailStore("owner","");
	}


	public RetailStoreOrderForm retailStoreCountryCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreCountryCenterIdFieldOfRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreOrderForm retailStoreCountryCenterIdFieldOfRetailStore(){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId","");
	}


	public RetailStoreOrderForm cityServiceCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm cityServiceCenterIdFieldOfRetailStore(String initValue){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId",initValue);
	}
	public RetailStoreOrderForm cityServiceCenterIdFieldOfRetailStore(){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId","");
	}


	public RetailStoreOrderForm creationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm creationIdFieldOfRetailStore(String initValue){
		return creationIdFieldOfRetailStore("creationId",initValue);
	}
	public RetailStoreOrderForm creationIdFieldOfRetailStore(){
		return creationIdFieldOfRetailStore("creationId","");
	}


	public RetailStoreOrderForm investmentInvitationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm investmentInvitationIdFieldOfRetailStore(String initValue){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId",initValue);
	}
	public RetailStoreOrderForm investmentInvitationIdFieldOfRetailStore(){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId","");
	}


	public RetailStoreOrderForm franchisingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm franchisingIdFieldOfRetailStore(String initValue){
		return franchisingIdFieldOfRetailStore("franchisingId",initValue);
	}
	public RetailStoreOrderForm franchisingIdFieldOfRetailStore(){
		return franchisingIdFieldOfRetailStore("franchisingId","");
	}


	public RetailStoreOrderForm decorationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm decorationIdFieldOfRetailStore(String initValue){
		return decorationIdFieldOfRetailStore("decorationId",initValue);
	}
	public RetailStoreOrderForm decorationIdFieldOfRetailStore(){
		return decorationIdFieldOfRetailStore("decorationId","");
	}


	public RetailStoreOrderForm openingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm openingIdFieldOfRetailStore(String initValue){
		return openingIdFieldOfRetailStore("openingId",initValue);
	}
	public RetailStoreOrderForm openingIdFieldOfRetailStore(){
		return openingIdFieldOfRetailStore("openingId","");
	}


	public RetailStoreOrderForm closingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm closingIdFieldOfRetailStore(String initValue){
		return closingIdFieldOfRetailStore("closingId",initValue);
	}
	public RetailStoreOrderForm closingIdFieldOfRetailStore(){
		return closingIdFieldOfRetailStore("closingId","");
	}


	public RetailStoreOrderForm foundedFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm foundedFieldOfRetailStore(String initValue){
		return foundedFieldOfRetailStore("founded",initValue);
	}
	public RetailStoreOrderForm foundedFieldOfRetailStore(){
		return foundedFieldOfRetailStore("founded","");
	}


	public RetailStoreOrderForm latitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm latitudeFieldOfRetailStore(String initValue){
		return latitudeFieldOfRetailStore("latitude",initValue);
	}
	public RetailStoreOrderForm latitudeFieldOfRetailStore(){
		return latitudeFieldOfRetailStore("latitude","");
	}


	public RetailStoreOrderForm longitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm longitudeFieldOfRetailStore(String initValue){
		return longitudeFieldOfRetailStore("longitude",initValue);
	}
	public RetailStoreOrderForm longitudeFieldOfRetailStore(){
		return longitudeFieldOfRetailStore("longitude","");
	}


	public RetailStoreOrderForm descriptionFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm descriptionFieldOfRetailStore(String initValue){
		return descriptionFieldOfRetailStore("description",initValue);
	}
	public RetailStoreOrderForm descriptionFieldOfRetailStore(){
		return descriptionFieldOfRetailStore("description","");
	}


	public RetailStoreOrderForm lastUpdateTimeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm lastUpdateTimeFieldOfRetailStore(String initValue){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime",initValue);
	}
	public RetailStoreOrderForm lastUpdateTimeFieldOfRetailStore(){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime","");
	}


	public RetailStoreOrderForm currentStatusFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm currentStatusFieldOfRetailStore(String initValue){
		return currentStatusFieldOfRetailStore("currentStatus",initValue);
	}
	public RetailStoreOrderForm currentStatusFieldOfRetailStore(){
		return currentStatusFieldOfRetailStore("currentStatus","");
	}


	public RetailStoreOrderForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreOrderForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public RetailStoreOrderForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public RetailStoreOrderForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public RetailStoreOrderForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public RetailStoreOrderForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public RetailStoreOrderForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public RetailStoreOrderForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public RetailStoreOrderForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public RetailStoreOrderForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public RetailStoreOrderForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public RetailStoreOrderForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public RetailStoreOrderForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public RetailStoreOrderForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public RetailStoreOrderForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public RetailStoreOrderForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public RetailStoreOrderForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public RetailStoreOrderForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}


	public RetailStoreOrderForm retailStoreOrderConfirmationIdFieldOfRetailStoreOrderConfirmation(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderConfirmationIdFieldOfRetailStoreOrderConfirmation(String initValue){
		return retailStoreOrderConfirmationIdFieldOfRetailStoreOrderConfirmation("retailStoreOrderConfirmationId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderConfirmationIdFieldOfRetailStoreOrderConfirmation(){
		return retailStoreOrderConfirmationIdFieldOfRetailStoreOrderConfirmation("retailStoreOrderConfirmationId","");
	}


	public RetailStoreOrderForm whoFieldOfRetailStoreOrderConfirmation(String parameterName, String initValue){
		FormField field =  whoFromRetailStoreOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderConfirmation(String initValue){
		return whoFieldOfRetailStoreOrderConfirmation("who",initValue);
	}
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderConfirmation(){
		return whoFieldOfRetailStoreOrderConfirmation("who","");
	}


	public RetailStoreOrderForm confirmTimeFieldOfRetailStoreOrderConfirmation(String parameterName, String initValue){
		FormField field =  confirmTimeFromRetailStoreOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm confirmTimeFieldOfRetailStoreOrderConfirmation(String initValue){
		return confirmTimeFieldOfRetailStoreOrderConfirmation("confirmTime",initValue);
	}
	public RetailStoreOrderForm confirmTimeFieldOfRetailStoreOrderConfirmation(){
		return confirmTimeFieldOfRetailStoreOrderConfirmation("confirmTime","");
	}


	public RetailStoreOrderForm retailStoreOrderApprovalIdFieldOfRetailStoreOrderApproval(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderApprovalIdFieldOfRetailStoreOrderApproval(String initValue){
		return retailStoreOrderApprovalIdFieldOfRetailStoreOrderApproval("retailStoreOrderApprovalId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderApprovalIdFieldOfRetailStoreOrderApproval(){
		return retailStoreOrderApprovalIdFieldOfRetailStoreOrderApproval("retailStoreOrderApprovalId","");
	}


	public RetailStoreOrderForm whoFieldOfRetailStoreOrderApproval(String parameterName, String initValue){
		FormField field =  whoFromRetailStoreOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderApproval(String initValue){
		return whoFieldOfRetailStoreOrderApproval("who",initValue);
	}
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderApproval(){
		return whoFieldOfRetailStoreOrderApproval("who","");
	}


	public RetailStoreOrderForm approveTimeFieldOfRetailStoreOrderApproval(String parameterName, String initValue){
		FormField field =  approveTimeFromRetailStoreOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm approveTimeFieldOfRetailStoreOrderApproval(String initValue){
		return approveTimeFieldOfRetailStoreOrderApproval("approveTime",initValue);
	}
	public RetailStoreOrderForm approveTimeFieldOfRetailStoreOrderApproval(){
		return approveTimeFieldOfRetailStoreOrderApproval("approveTime","");
	}


	public RetailStoreOrderForm retailStoreOrderProcessingIdFieldOfRetailStoreOrderProcessing(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderProcessingIdFieldOfRetailStoreOrderProcessing(String initValue){
		return retailStoreOrderProcessingIdFieldOfRetailStoreOrderProcessing("retailStoreOrderProcessingId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderProcessingIdFieldOfRetailStoreOrderProcessing(){
		return retailStoreOrderProcessingIdFieldOfRetailStoreOrderProcessing("retailStoreOrderProcessingId","");
	}


	public RetailStoreOrderForm whoFieldOfRetailStoreOrderProcessing(String parameterName, String initValue){
		FormField field =  whoFromRetailStoreOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderProcessing(String initValue){
		return whoFieldOfRetailStoreOrderProcessing("who",initValue);
	}
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderProcessing(){
		return whoFieldOfRetailStoreOrderProcessing("who","");
	}


	public RetailStoreOrderForm processTimeFieldOfRetailStoreOrderProcessing(String parameterName, String initValue){
		FormField field =  processTimeFromRetailStoreOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm processTimeFieldOfRetailStoreOrderProcessing(String initValue){
		return processTimeFieldOfRetailStoreOrderProcessing("processTime",initValue);
	}
	public RetailStoreOrderForm processTimeFieldOfRetailStoreOrderProcessing(){
		return processTimeFieldOfRetailStoreOrderProcessing("processTime","");
	}


	public RetailStoreOrderForm retailStoreOrderPickingIdFieldOfRetailStoreOrderPicking(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderPicking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderPickingIdFieldOfRetailStoreOrderPicking(String initValue){
		return retailStoreOrderPickingIdFieldOfRetailStoreOrderPicking("retailStoreOrderPickingId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderPickingIdFieldOfRetailStoreOrderPicking(){
		return retailStoreOrderPickingIdFieldOfRetailStoreOrderPicking("retailStoreOrderPickingId","");
	}


	public RetailStoreOrderForm whoFieldOfRetailStoreOrderPicking(String parameterName, String initValue){
		FormField field =  whoFromRetailStoreOrderPicking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderPicking(String initValue){
		return whoFieldOfRetailStoreOrderPicking("who",initValue);
	}
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderPicking(){
		return whoFieldOfRetailStoreOrderPicking("who","");
	}


	public RetailStoreOrderForm processTimeFieldOfRetailStoreOrderPicking(String parameterName, String initValue){
		FormField field =  processTimeFromRetailStoreOrderPicking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm processTimeFieldOfRetailStoreOrderPicking(String initValue){
		return processTimeFieldOfRetailStoreOrderPicking("processTime",initValue);
	}
	public RetailStoreOrderForm processTimeFieldOfRetailStoreOrderPicking(){
		return processTimeFieldOfRetailStoreOrderPicking("processTime","");
	}


	public RetailStoreOrderForm retailStoreOrderShipmentIdFieldOfRetailStoreOrderShipment(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderShipmentIdFieldOfRetailStoreOrderShipment(String initValue){
		return retailStoreOrderShipmentIdFieldOfRetailStoreOrderShipment("retailStoreOrderShipmentId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderShipmentIdFieldOfRetailStoreOrderShipment(){
		return retailStoreOrderShipmentIdFieldOfRetailStoreOrderShipment("retailStoreOrderShipmentId","");
	}


	public RetailStoreOrderForm whoFieldOfRetailStoreOrderShipment(String parameterName, String initValue){
		FormField field =  whoFromRetailStoreOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderShipment(String initValue){
		return whoFieldOfRetailStoreOrderShipment("who",initValue);
	}
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderShipment(){
		return whoFieldOfRetailStoreOrderShipment("who","");
	}


	public RetailStoreOrderForm shipTimeFieldOfRetailStoreOrderShipment(String parameterName, String initValue){
		FormField field =  shipTimeFromRetailStoreOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm shipTimeFieldOfRetailStoreOrderShipment(String initValue){
		return shipTimeFieldOfRetailStoreOrderShipment("shipTime",initValue);
	}
	public RetailStoreOrderForm shipTimeFieldOfRetailStoreOrderShipment(){
		return shipTimeFieldOfRetailStoreOrderShipment("shipTime","");
	}


	public RetailStoreOrderForm retailStoreOrderDeliveryIdFieldOfRetailStoreOrderDelivery(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderDeliveryIdFieldOfRetailStoreOrderDelivery(String initValue){
		return retailStoreOrderDeliveryIdFieldOfRetailStoreOrderDelivery("retailStoreOrderDeliveryId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderDeliveryIdFieldOfRetailStoreOrderDelivery(){
		return retailStoreOrderDeliveryIdFieldOfRetailStoreOrderDelivery("retailStoreOrderDeliveryId","");
	}


	public RetailStoreOrderForm whoFieldOfRetailStoreOrderDelivery(String parameterName, String initValue){
		FormField field =  whoFromRetailStoreOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderDelivery(String initValue){
		return whoFieldOfRetailStoreOrderDelivery("who",initValue);
	}
	public RetailStoreOrderForm whoFieldOfRetailStoreOrderDelivery(){
		return whoFieldOfRetailStoreOrderDelivery("who","");
	}


	public RetailStoreOrderForm deliveryTimeFieldOfRetailStoreOrderDelivery(String parameterName, String initValue){
		FormField field =  deliveryTimeFromRetailStoreOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreOrderForm deliveryTimeFieldOfRetailStoreOrderDelivery(String initValue){
		return deliveryTimeFieldOfRetailStoreOrderDelivery("deliveryTime",initValue);
	}
	public RetailStoreOrderForm deliveryTimeFieldOfRetailStoreOrderDelivery(){
		return deliveryTimeFieldOfRetailStoreOrderDelivery("deliveryTime","");
	}

	



	public RetailStoreOrderForm retailStoreOrderLineItemIdFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderLineItemIdFieldForRetailStoreOrderLineItem(String initValue){
		return retailStoreOrderLineItemIdFieldForRetailStoreOrderLineItem("retailStoreOrderLineItemId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderLineItemIdFieldForRetailStoreOrderLineItem(){
		return retailStoreOrderLineItemIdFieldForRetailStoreOrderLineItem("retailStoreOrderLineItemId","");
	}


	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  bizOrderIdFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderLineItem(String initValue){
		return bizOrderIdFieldForRetailStoreOrderLineItem("bizOrderId",initValue);
	}
	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderLineItem(){
		return bizOrderIdFieldForRetailStoreOrderLineItem("bizOrderId","");
	}


	public RetailStoreOrderForm skuIdFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  skuIdFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm skuIdFieldForRetailStoreOrderLineItem(String initValue){
		return skuIdFieldForRetailStoreOrderLineItem("skuId",initValue);
	}
	public RetailStoreOrderForm skuIdFieldForRetailStoreOrderLineItem(){
		return skuIdFieldForRetailStoreOrderLineItem("skuId","");
	}


	public RetailStoreOrderForm skuNameFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  skuNameFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm skuNameFieldForRetailStoreOrderLineItem(String initValue){
		return skuNameFieldForRetailStoreOrderLineItem("skuName",initValue);
	}
	public RetailStoreOrderForm skuNameFieldForRetailStoreOrderLineItem(){
		return skuNameFieldForRetailStoreOrderLineItem("skuName","");
	}


	public RetailStoreOrderForm amountFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  amountFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm amountFieldForRetailStoreOrderLineItem(String initValue){
		return amountFieldForRetailStoreOrderLineItem("amount",initValue);
	}
	public RetailStoreOrderForm amountFieldForRetailStoreOrderLineItem(){
		return amountFieldForRetailStoreOrderLineItem("amount","");
	}


	public RetailStoreOrderForm quantityFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  quantityFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm quantityFieldForRetailStoreOrderLineItem(String initValue){
		return quantityFieldForRetailStoreOrderLineItem("quantity",initValue);
	}
	public RetailStoreOrderForm quantityFieldForRetailStoreOrderLineItem(){
		return quantityFieldForRetailStoreOrderLineItem("quantity","");
	}


	public RetailStoreOrderForm unitOfMeasurementFieldForRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field =  unitOfMeasurementFromRetailStoreOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm unitOfMeasurementFieldForRetailStoreOrderLineItem(String initValue){
		return unitOfMeasurementFieldForRetailStoreOrderLineItem("unitOfMeasurement",initValue);
	}
	public RetailStoreOrderForm unitOfMeasurementFieldForRetailStoreOrderLineItem(){
		return unitOfMeasurementFieldForRetailStoreOrderLineItem("unitOfMeasurement","");
	}


	public RetailStoreOrderForm retailStoreOrderShippingGroupIdFieldForRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderShippingGroupIdFieldForRetailStoreOrderShippingGroup(String initValue){
		return retailStoreOrderShippingGroupIdFieldForRetailStoreOrderShippingGroup("retailStoreOrderShippingGroupId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderShippingGroupIdFieldForRetailStoreOrderShippingGroup(){
		return retailStoreOrderShippingGroupIdFieldForRetailStoreOrderShippingGroup("retailStoreOrderShippingGroupId","");
	}


	public RetailStoreOrderForm nameFieldForRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm nameFieldForRetailStoreOrderShippingGroup(String initValue){
		return nameFieldForRetailStoreOrderShippingGroup("name",initValue);
	}
	public RetailStoreOrderForm nameFieldForRetailStoreOrderShippingGroup(){
		return nameFieldForRetailStoreOrderShippingGroup("name","");
	}


	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field =  bizOrderIdFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderShippingGroup(String initValue){
		return bizOrderIdFieldForRetailStoreOrderShippingGroup("bizOrderId",initValue);
	}
	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderShippingGroup(){
		return bizOrderIdFieldForRetailStoreOrderShippingGroup("bizOrderId","");
	}


	public RetailStoreOrderForm amountFieldForRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field =  amountFromRetailStoreOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm amountFieldForRetailStoreOrderShippingGroup(String initValue){
		return amountFieldForRetailStoreOrderShippingGroup("amount",initValue);
	}
	public RetailStoreOrderForm amountFieldForRetailStoreOrderShippingGroup(){
		return amountFieldForRetailStoreOrderShippingGroup("amount","");
	}


	public RetailStoreOrderForm retailStoreOrderPaymentGroupIdFieldForRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderPaymentGroupIdFieldForRetailStoreOrderPaymentGroup(String initValue){
		return retailStoreOrderPaymentGroupIdFieldForRetailStoreOrderPaymentGroup("retailStoreOrderPaymentGroupId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderPaymentGroupIdFieldForRetailStoreOrderPaymentGroup(){
		return retailStoreOrderPaymentGroupIdFieldForRetailStoreOrderPaymentGroup("retailStoreOrderPaymentGroupId","");
	}


	public RetailStoreOrderForm nameFieldForRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm nameFieldForRetailStoreOrderPaymentGroup(String initValue){
		return nameFieldForRetailStoreOrderPaymentGroup("name",initValue);
	}
	public RetailStoreOrderForm nameFieldForRetailStoreOrderPaymentGroup(){
		return nameFieldForRetailStoreOrderPaymentGroup("name","");
	}


	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  bizOrderIdFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderPaymentGroup(String initValue){
		return bizOrderIdFieldForRetailStoreOrderPaymentGroup("bizOrderId",initValue);
	}
	public RetailStoreOrderForm bizOrderIdFieldForRetailStoreOrderPaymentGroup(){
		return bizOrderIdFieldForRetailStoreOrderPaymentGroup("bizOrderId","");
	}


	public RetailStoreOrderForm cardNumberFieldForRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  cardNumberFromRetailStoreOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm cardNumberFieldForRetailStoreOrderPaymentGroup(String initValue){
		return cardNumberFieldForRetailStoreOrderPaymentGroup("cardNumber",initValue);
	}
	public RetailStoreOrderForm cardNumberFieldForRetailStoreOrderPaymentGroup(){
		return cardNumberFieldForRetailStoreOrderPaymentGroup("cardNumber","");
	}


	public RetailStoreOrderForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public RetailStoreOrderForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public RetailStoreOrderForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public RetailStoreOrderForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public RetailStoreOrderForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public RetailStoreOrderForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public RetailStoreOrderForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public RetailStoreOrderForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public RetailStoreOrderForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public RetailStoreOrderForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public RetailStoreOrderForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public RetailStoreOrderForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public RetailStoreOrderForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public RetailStoreOrderForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public RetailStoreOrderForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public RetailStoreOrderForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public RetailStoreOrderForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public RetailStoreOrderForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public RetailStoreOrderForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public RetailStoreOrderForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public RetailStoreOrderForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public RetailStoreOrderForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public RetailStoreOrderForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public RetailStoreOrderForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public RetailStoreOrderForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public RetailStoreOrderForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public RetailStoreOrderForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public RetailStoreOrderForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public RetailStoreOrderForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public RetailStoreOrderForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public RetailStoreOrderForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public RetailStoreOrderForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public RetailStoreOrderForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreOrderForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public RetailStoreOrderForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public RetailStoreOrderForm transferToAnotherBuyerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBuyer/retailStoreOrderId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RetailStoreOrderForm transferToAnotherSellerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSeller/retailStoreOrderId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RetailStoreOrderForm  confirmAction(){
		FormAction action = new FormAction();
		action.setLabel("确认");
		action.setLocaleKey("retail_store_order.confirm");
		action.setUrl("retailStoreOrderManager/confirm/retailStoreOrderId/who/confirmTime/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreOrderForm  approveAction(){
		FormAction action = new FormAction();
		action.setLabel("批准");
		action.setLocaleKey("retail_store_order.approve");
		action.setUrl("retailStoreOrderManager/approve/retailStoreOrderId/who/approveTime/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreOrderForm  processAction(){
		FormAction action = new FormAction();
		action.setLabel("过程");
		action.setLocaleKey("retail_store_order.process");
		action.setUrl("retailStoreOrderManager/process/retailStoreOrderId/who/processTime/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreOrderForm  pickAction(){
		FormAction action = new FormAction();
		action.setLabel("选择");
		action.setLocaleKey("retail_store_order.pick");
		action.setUrl("retailStoreOrderManager/pick/retailStoreOrderId/who/processTime/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreOrderForm  shipAction(){
		FormAction action = new FormAction();
		action.setLabel("船");
		action.setLocaleKey("retail_store_order.ship");
		action.setUrl("retailStoreOrderManager/ship/retailStoreOrderId/who/shipTime/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreOrderForm  deliverAction(){
		FormAction action = new FormAction();
		action.setLabel("交付");
		action.setLocaleKey("retail_store_order.deliver");
		action.setUrl("retailStoreOrderManager/deliver/retailStoreOrderId/who/deliveryTime/");
		this.addFormAction(action);
		return this;
	}

	public RetailStoreOrderForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



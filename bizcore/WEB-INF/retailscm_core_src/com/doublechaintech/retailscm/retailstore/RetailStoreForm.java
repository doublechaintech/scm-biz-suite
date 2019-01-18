package com.doublechaintech.retailscm.retailstore;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreForm extends BaseForm {
	
	
	public RetailStoreForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreForm retailStoreIdField(String parameterName, String initValue){
		FormField field = idFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm retailStoreIdField(String initValue){
		return retailStoreIdField("retailStoreId",initValue);
	}
	public RetailStoreForm retailStoreIdField(){
		return retailStoreIdField("retailStoreId","");
	}


	public RetailStoreForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreForm nameField(){
		return nameField("name","");
	}


	public RetailStoreForm telephoneField(String parameterName, String initValue){
		FormField field = telephoneFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm telephoneField(String initValue){
		return telephoneField("telephone",initValue);
	}
	public RetailStoreForm telephoneField(){
		return telephoneField("telephone","");
	}


	public RetailStoreForm ownerField(String parameterName, String initValue){
		FormField field = ownerFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm ownerField(String initValue){
		return ownerField("owner",initValue);
	}
	public RetailStoreForm ownerField(){
		return ownerField("owner","");
	}


	public RetailStoreForm retailStoreCountryCenterIdField(String parameterName, String initValue){
		FormField field = retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm retailStoreCountryCenterIdField(String initValue){
		return retailStoreCountryCenterIdField("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreForm retailStoreCountryCenterIdField(){
		return retailStoreCountryCenterIdField("retailStoreCountryCenterId","");
	}


	public RetailStoreForm cityServiceCenterIdField(String parameterName, String initValue){
		FormField field = cityServiceCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm cityServiceCenterIdField(String initValue){
		return cityServiceCenterIdField("cityServiceCenterId",initValue);
	}
	public RetailStoreForm cityServiceCenterIdField(){
		return cityServiceCenterIdField("cityServiceCenterId","");
	}


	public RetailStoreForm creationIdField(String parameterName, String initValue){
		FormField field = creationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm creationIdField(String initValue){
		return creationIdField("creationId",initValue);
	}
	public RetailStoreForm creationIdField(){
		return creationIdField("creationId","");
	}


	public RetailStoreForm investmentInvitationIdField(String parameterName, String initValue){
		FormField field = investmentInvitationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm investmentInvitationIdField(String initValue){
		return investmentInvitationIdField("investmentInvitationId",initValue);
	}
	public RetailStoreForm investmentInvitationIdField(){
		return investmentInvitationIdField("investmentInvitationId","");
	}


	public RetailStoreForm franchisingIdField(String parameterName, String initValue){
		FormField field = franchisingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm franchisingIdField(String initValue){
		return franchisingIdField("franchisingId",initValue);
	}
	public RetailStoreForm franchisingIdField(){
		return franchisingIdField("franchisingId","");
	}


	public RetailStoreForm decorationIdField(String parameterName, String initValue){
		FormField field = decorationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm decorationIdField(String initValue){
		return decorationIdField("decorationId",initValue);
	}
	public RetailStoreForm decorationIdField(){
		return decorationIdField("decorationId","");
	}


	public RetailStoreForm openingIdField(String parameterName, String initValue){
		FormField field = openingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm openingIdField(String initValue){
		return openingIdField("openingId",initValue);
	}
	public RetailStoreForm openingIdField(){
		return openingIdField("openingId","");
	}


	public RetailStoreForm closingIdField(String parameterName, String initValue){
		FormField field = closingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm closingIdField(String initValue){
		return closingIdField("closingId",initValue);
	}
	public RetailStoreForm closingIdField(){
		return closingIdField("closingId","");
	}


	public RetailStoreForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public RetailStoreForm foundedField(){
		return foundedField("founded","");
	}


	public RetailStoreForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public RetailStoreForm latitudeField(){
		return latitudeField("latitude","");
	}


	public RetailStoreForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public RetailStoreForm longitudeField(){
		return longitudeField("longitude","");
	}


	public RetailStoreForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public RetailStoreForm descriptionField(){
		return descriptionField("description","");
	}


	public RetailStoreForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public RetailStoreForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public RetailStoreForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public RetailStoreForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public RetailStoreForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public RetailStoreForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public RetailStoreForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public RetailStoreForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public RetailStoreForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public RetailStoreForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public RetailStoreForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public RetailStoreForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public RetailStoreForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public RetailStoreForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public RetailStoreForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public RetailStoreForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public RetailStoreForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public RetailStoreForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public RetailStoreForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public RetailStoreForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public RetailStoreForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}


	public RetailStoreForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId",initValue);
	}
	public RetailStoreForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId","");
	}


	public RetailStoreForm nameFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm nameFieldOfRetailStoreCityServiceCenter(String initValue){
		return nameFieldOfRetailStoreCityServiceCenter("name",initValue);
	}
	public RetailStoreForm nameFieldOfRetailStoreCityServiceCenter(){
		return nameFieldOfRetailStoreCityServiceCenter("name","");
	}


	public RetailStoreForm foundedFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm foundedFieldOfRetailStoreCityServiceCenter(String initValue){
		return foundedFieldOfRetailStoreCityServiceCenter("founded",initValue);
	}
	public RetailStoreForm foundedFieldOfRetailStoreCityServiceCenter(){
		return foundedFieldOfRetailStoreCityServiceCenter("founded","");
	}


	public RetailStoreForm belongsToIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  belongsToIdFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm belongsToIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId",initValue);
	}
	public RetailStoreForm belongsToIdFieldOfRetailStoreCityServiceCenter(){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId","");
	}


	public RetailStoreForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime",initValue);
	}
	public RetailStoreForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime","");
	}


	public RetailStoreForm retailStoreCreationIdFieldOfRetailStoreCreation(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreCreationIdFieldOfRetailStoreCreation(String initValue){
		return retailStoreCreationIdFieldOfRetailStoreCreation("retailStoreCreationId",initValue);
	}
	public RetailStoreForm retailStoreCreationIdFieldOfRetailStoreCreation(){
		return retailStoreCreationIdFieldOfRetailStoreCreation("retailStoreCreationId","");
	}


	public RetailStoreForm commentFieldOfRetailStoreCreation(String parameterName, String initValue){
		FormField field =  commentFromRetailStoreCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm commentFieldOfRetailStoreCreation(String initValue){
		return commentFieldOfRetailStoreCreation("comment",initValue);
	}
	public RetailStoreForm commentFieldOfRetailStoreCreation(){
		return commentFieldOfRetailStoreCreation("comment","");
	}


	public RetailStoreForm retailStoreInvestmentInvitationIdFieldOfRetailStoreInvestmentInvitation(String parameterName, String initValue){
		FormField field =  idFromRetailStoreInvestmentInvitation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreInvestmentInvitationIdFieldOfRetailStoreInvestmentInvitation(String initValue){
		return retailStoreInvestmentInvitationIdFieldOfRetailStoreInvestmentInvitation("retailStoreInvestmentInvitationId",initValue);
	}
	public RetailStoreForm retailStoreInvestmentInvitationIdFieldOfRetailStoreInvestmentInvitation(){
		return retailStoreInvestmentInvitationIdFieldOfRetailStoreInvestmentInvitation("retailStoreInvestmentInvitationId","");
	}


	public RetailStoreForm commentFieldOfRetailStoreInvestmentInvitation(String parameterName, String initValue){
		FormField field =  commentFromRetailStoreInvestmentInvitation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm commentFieldOfRetailStoreInvestmentInvitation(String initValue){
		return commentFieldOfRetailStoreInvestmentInvitation("comment",initValue);
	}
	public RetailStoreForm commentFieldOfRetailStoreInvestmentInvitation(){
		return commentFieldOfRetailStoreInvestmentInvitation("comment","");
	}


	public RetailStoreForm retailStoreFranchisingIdFieldOfRetailStoreFranchising(String parameterName, String initValue){
		FormField field =  idFromRetailStoreFranchising(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreFranchisingIdFieldOfRetailStoreFranchising(String initValue){
		return retailStoreFranchisingIdFieldOfRetailStoreFranchising("retailStoreFranchisingId",initValue);
	}
	public RetailStoreForm retailStoreFranchisingIdFieldOfRetailStoreFranchising(){
		return retailStoreFranchisingIdFieldOfRetailStoreFranchising("retailStoreFranchisingId","");
	}


	public RetailStoreForm commentFieldOfRetailStoreFranchising(String parameterName, String initValue){
		FormField field =  commentFromRetailStoreFranchising(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm commentFieldOfRetailStoreFranchising(String initValue){
		return commentFieldOfRetailStoreFranchising("comment",initValue);
	}
	public RetailStoreForm commentFieldOfRetailStoreFranchising(){
		return commentFieldOfRetailStoreFranchising("comment","");
	}


	public RetailStoreForm retailStoreDecorationIdFieldOfRetailStoreDecoration(String parameterName, String initValue){
		FormField field =  idFromRetailStoreDecoration(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreDecorationIdFieldOfRetailStoreDecoration(String initValue){
		return retailStoreDecorationIdFieldOfRetailStoreDecoration("retailStoreDecorationId",initValue);
	}
	public RetailStoreForm retailStoreDecorationIdFieldOfRetailStoreDecoration(){
		return retailStoreDecorationIdFieldOfRetailStoreDecoration("retailStoreDecorationId","");
	}


	public RetailStoreForm commentFieldOfRetailStoreDecoration(String parameterName, String initValue){
		FormField field =  commentFromRetailStoreDecoration(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm commentFieldOfRetailStoreDecoration(String initValue){
		return commentFieldOfRetailStoreDecoration("comment",initValue);
	}
	public RetailStoreForm commentFieldOfRetailStoreDecoration(){
		return commentFieldOfRetailStoreDecoration("comment","");
	}


	public RetailStoreForm retailStoreOpeningIdFieldOfRetailStoreOpening(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOpening(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreOpeningIdFieldOfRetailStoreOpening(String initValue){
		return retailStoreOpeningIdFieldOfRetailStoreOpening("retailStoreOpeningId",initValue);
	}
	public RetailStoreForm retailStoreOpeningIdFieldOfRetailStoreOpening(){
		return retailStoreOpeningIdFieldOfRetailStoreOpening("retailStoreOpeningId","");
	}


	public RetailStoreForm commentFieldOfRetailStoreOpening(String parameterName, String initValue){
		FormField field =  commentFromRetailStoreOpening(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm commentFieldOfRetailStoreOpening(String initValue){
		return commentFieldOfRetailStoreOpening("comment",initValue);
	}
	public RetailStoreForm commentFieldOfRetailStoreOpening(){
		return commentFieldOfRetailStoreOpening("comment","");
	}


	public RetailStoreForm retailStoreClosingIdFieldOfRetailStoreClosing(String parameterName, String initValue){
		FormField field =  idFromRetailStoreClosing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm retailStoreClosingIdFieldOfRetailStoreClosing(String initValue){
		return retailStoreClosingIdFieldOfRetailStoreClosing("retailStoreClosingId",initValue);
	}
	public RetailStoreForm retailStoreClosingIdFieldOfRetailStoreClosing(){
		return retailStoreClosingIdFieldOfRetailStoreClosing("retailStoreClosingId","");
	}


	public RetailStoreForm commentFieldOfRetailStoreClosing(String parameterName, String initValue){
		FormField field =  commentFromRetailStoreClosing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreForm commentFieldOfRetailStoreClosing(String initValue){
		return commentFieldOfRetailStoreClosing("comment",initValue);
	}
	public RetailStoreForm commentFieldOfRetailStoreClosing(){
		return commentFieldOfRetailStoreClosing("comment","");
	}

	



	public RetailStoreForm consumerOrderIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm consumerOrderIdFieldForConsumerOrder(String initValue){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId",initValue);
	}
	public RetailStoreForm consumerOrderIdFieldForConsumerOrder(){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId","");
	}


	public RetailStoreForm titleFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm titleFieldForConsumerOrder(String initValue){
		return titleFieldForConsumerOrder("title",initValue);
	}
	public RetailStoreForm titleFieldForConsumerOrder(){
		return titleFieldForConsumerOrder("title","");
	}


	public RetailStoreForm consumerIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm consumerIdFieldForConsumerOrder(String initValue){
		return consumerIdFieldForConsumerOrder("consumerId",initValue);
	}
	public RetailStoreForm consumerIdFieldForConsumerOrder(){
		return consumerIdFieldForConsumerOrder("consumerId","");
	}


	public RetailStoreForm confirmationIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm confirmationIdFieldForConsumerOrder(String initValue){
		return confirmationIdFieldForConsumerOrder("confirmationId",initValue);
	}
	public RetailStoreForm confirmationIdFieldForConsumerOrder(){
		return confirmationIdFieldForConsumerOrder("confirmationId","");
	}


	public RetailStoreForm approvalIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm approvalIdFieldForConsumerOrder(String initValue){
		return approvalIdFieldForConsumerOrder("approvalId",initValue);
	}
	public RetailStoreForm approvalIdFieldForConsumerOrder(){
		return approvalIdFieldForConsumerOrder("approvalId","");
	}


	public RetailStoreForm processingIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm processingIdFieldForConsumerOrder(String initValue){
		return processingIdFieldForConsumerOrder("processingId",initValue);
	}
	public RetailStoreForm processingIdFieldForConsumerOrder(){
		return processingIdFieldForConsumerOrder("processingId","");
	}


	public RetailStoreForm shipmentIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm shipmentIdFieldForConsumerOrder(String initValue){
		return shipmentIdFieldForConsumerOrder("shipmentId",initValue);
	}
	public RetailStoreForm shipmentIdFieldForConsumerOrder(){
		return shipmentIdFieldForConsumerOrder("shipmentId","");
	}


	public RetailStoreForm deliveryIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm deliveryIdFieldForConsumerOrder(String initValue){
		return deliveryIdFieldForConsumerOrder("deliveryId",initValue);
	}
	public RetailStoreForm deliveryIdFieldForConsumerOrder(){
		return deliveryIdFieldForConsumerOrder("deliveryId","");
	}


	public RetailStoreForm storeIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm storeIdFieldForConsumerOrder(String initValue){
		return storeIdFieldForConsumerOrder("storeId",initValue);
	}
	public RetailStoreForm storeIdFieldForConsumerOrder(){
		return storeIdFieldForConsumerOrder("storeId","");
	}


	public RetailStoreForm lastUpdateTimeFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm lastUpdateTimeFieldForConsumerOrder(String initValue){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime",initValue);
	}
	public RetailStoreForm lastUpdateTimeFieldForConsumerOrder(){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime","");
	}


	public RetailStoreForm currentStatusFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm currentStatusFieldForConsumerOrder(String initValue){
		return currentStatusFieldForConsumerOrder("currentStatus",initValue);
	}
	public RetailStoreForm currentStatusFieldForConsumerOrder(){
		return currentStatusFieldForConsumerOrder("currentStatus","");
	}


	public RetailStoreForm retailStoreOrderIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm retailStoreOrderIdFieldForRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreForm retailStoreOrderIdFieldForRetailStoreOrder(){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreForm buyerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm buyerIdFieldForRetailStoreOrder(String initValue){
		return buyerIdFieldForRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreForm buyerIdFieldForRetailStoreOrder(){
		return buyerIdFieldForRetailStoreOrder("buyerId","");
	}


	public RetailStoreForm sellerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm sellerIdFieldForRetailStoreOrder(String initValue){
		return sellerIdFieldForRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreForm sellerIdFieldForRetailStoreOrder(){
		return sellerIdFieldForRetailStoreOrder("sellerId","");
	}


	public RetailStoreForm titleFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm titleFieldForRetailStoreOrder(String initValue){
		return titleFieldForRetailStoreOrder("title",initValue);
	}
	public RetailStoreForm titleFieldForRetailStoreOrder(){
		return titleFieldForRetailStoreOrder("title","");
	}


	public RetailStoreForm totalAmountFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm totalAmountFieldForRetailStoreOrder(String initValue){
		return totalAmountFieldForRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreForm totalAmountFieldForRetailStoreOrder(){
		return totalAmountFieldForRetailStoreOrder("totalAmount","");
	}


	public RetailStoreForm confirmationIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm confirmationIdFieldForRetailStoreOrder(String initValue){
		return confirmationIdFieldForRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreForm confirmationIdFieldForRetailStoreOrder(){
		return confirmationIdFieldForRetailStoreOrder("confirmationId","");
	}


	public RetailStoreForm approvalIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm approvalIdFieldForRetailStoreOrder(String initValue){
		return approvalIdFieldForRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreForm approvalIdFieldForRetailStoreOrder(){
		return approvalIdFieldForRetailStoreOrder("approvalId","");
	}


	public RetailStoreForm processingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm processingIdFieldForRetailStoreOrder(String initValue){
		return processingIdFieldForRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreForm processingIdFieldForRetailStoreOrder(){
		return processingIdFieldForRetailStoreOrder("processingId","");
	}


	public RetailStoreForm pickingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm pickingIdFieldForRetailStoreOrder(String initValue){
		return pickingIdFieldForRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreForm pickingIdFieldForRetailStoreOrder(){
		return pickingIdFieldForRetailStoreOrder("pickingId","");
	}


	public RetailStoreForm shipmentIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm shipmentIdFieldForRetailStoreOrder(String initValue){
		return shipmentIdFieldForRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreForm shipmentIdFieldForRetailStoreOrder(){
		return shipmentIdFieldForRetailStoreOrder("shipmentId","");
	}


	public RetailStoreForm deliveryIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm deliveryIdFieldForRetailStoreOrder(String initValue){
		return deliveryIdFieldForRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreForm deliveryIdFieldForRetailStoreOrder(){
		return deliveryIdFieldForRetailStoreOrder("deliveryId","");
	}


	public RetailStoreForm lastUpdateTimeFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm lastUpdateTimeFieldForRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreForm lastUpdateTimeFieldForRetailStoreOrder(){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreForm currentStatusFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm currentStatusFieldForRetailStoreOrder(String initValue){
		return currentStatusFieldForRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreForm currentStatusFieldForRetailStoreOrder(){
		return currentStatusFieldForRetailStoreOrder("currentStatus","");
	}


	public RetailStoreForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public RetailStoreForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public RetailStoreForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public RetailStoreForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public RetailStoreForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public RetailStoreForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public RetailStoreForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public RetailStoreForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public RetailStoreForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public RetailStoreForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public RetailStoreForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public RetailStoreForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public RetailStoreForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public RetailStoreForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public RetailStoreForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public RetailStoreForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public RetailStoreForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public RetailStoreForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public RetailStoreForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public RetailStoreForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public RetailStoreForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public RetailStoreForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public RetailStoreForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public RetailStoreForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public RetailStoreForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public RetailStoreForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public RetailStoreForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public RetailStoreForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public RetailStoreForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public RetailStoreForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public RetailStoreForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public RetailStoreForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public RetailStoreForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public RetailStoreForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}


	public RetailStoreForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public RetailStoreForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public RetailStoreForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public RetailStoreForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public RetailStoreForm startFieldForTransportTask(String parameterName, String initValue){
		FormField field =  startFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm startFieldForTransportTask(String initValue){
		return startFieldForTransportTask("start",initValue);
	}
	public RetailStoreForm startFieldForTransportTask(){
		return startFieldForTransportTask("start","");
	}


	public RetailStoreForm beginTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  beginTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm beginTimeFieldForTransportTask(String initValue){
		return beginTimeFieldForTransportTask("beginTime",initValue);
	}
	public RetailStoreForm beginTimeFieldForTransportTask(){
		return beginTimeFieldForTransportTask("beginTime","");
	}


	public RetailStoreForm endIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  endIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm endIdFieldForTransportTask(String initValue){
		return endIdFieldForTransportTask("endId",initValue);
	}
	public RetailStoreForm endIdFieldForTransportTask(){
		return endIdFieldForTransportTask("endId","");
	}


	public RetailStoreForm driverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  driverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm driverIdFieldForTransportTask(String initValue){
		return driverIdFieldForTransportTask("driverId",initValue);
	}
	public RetailStoreForm driverIdFieldForTransportTask(){
		return driverIdFieldForTransportTask("driverId","");
	}


	public RetailStoreForm truckIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  truckIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm truckIdFieldForTransportTask(String initValue){
		return truckIdFieldForTransportTask("truckId",initValue);
	}
	public RetailStoreForm truckIdFieldForTransportTask(){
		return truckIdFieldForTransportTask("truckId","");
	}


	public RetailStoreForm belongsToIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  belongsToIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm belongsToIdFieldForTransportTask(String initValue){
		return belongsToIdFieldForTransportTask("belongsToId",initValue);
	}
	public RetailStoreForm belongsToIdFieldForTransportTask(){
		return belongsToIdFieldForTransportTask("belongsToId","");
	}


	public RetailStoreForm latitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm latitudeFieldForTransportTask(String initValue){
		return latitudeFieldForTransportTask("latitude",initValue);
	}
	public RetailStoreForm latitudeFieldForTransportTask(){
		return latitudeFieldForTransportTask("latitude","");
	}


	public RetailStoreForm longitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm longitudeFieldForTransportTask(String initValue){
		return longitudeFieldForTransportTask("longitude",initValue);
	}
	public RetailStoreForm longitudeFieldForTransportTask(){
		return longitudeFieldForTransportTask("longitude","");
	}


	public RetailStoreForm accountSetIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  idFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm accountSetIdFieldForAccountSet(String initValue){
		return accountSetIdFieldForAccountSet("accountSetId",initValue);
	}
	public RetailStoreForm accountSetIdFieldForAccountSet(){
		return accountSetIdFieldForAccountSet("accountSetId","");
	}


	public RetailStoreForm nameFieldForAccountSet(String parameterName, String initValue){
		FormField field =  nameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm nameFieldForAccountSet(String initValue){
		return nameFieldForAccountSet("name",initValue);
	}
	public RetailStoreForm nameFieldForAccountSet(){
		return nameFieldForAccountSet("name","");
	}


	public RetailStoreForm yearSetFieldForAccountSet(String parameterName, String initValue){
		FormField field =  yearSetFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm yearSetFieldForAccountSet(String initValue){
		return yearSetFieldForAccountSet("yearSet",initValue);
	}
	public RetailStoreForm yearSetFieldForAccountSet(){
		return yearSetFieldForAccountSet("yearSet","");
	}


	public RetailStoreForm effectiveDateFieldForAccountSet(String parameterName, String initValue){
		FormField field =  effectiveDateFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm effectiveDateFieldForAccountSet(String initValue){
		return effectiveDateFieldForAccountSet("effectiveDate",initValue);
	}
	public RetailStoreForm effectiveDateFieldForAccountSet(){
		return effectiveDateFieldForAccountSet("effectiveDate","");
	}


	public RetailStoreForm accountingSystemFieldForAccountSet(String parameterName, String initValue){
		FormField field =  accountingSystemFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm accountingSystemFieldForAccountSet(String initValue){
		return accountingSystemFieldForAccountSet("accountingSystem",initValue);
	}
	public RetailStoreForm accountingSystemFieldForAccountSet(){
		return accountingSystemFieldForAccountSet("accountingSystem","");
	}


	public RetailStoreForm domesticCurrencyCodeFieldForAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyCodeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm domesticCurrencyCodeFieldForAccountSet(String initValue){
		return domesticCurrencyCodeFieldForAccountSet("domesticCurrencyCode",initValue);
	}
	public RetailStoreForm domesticCurrencyCodeFieldForAccountSet(){
		return domesticCurrencyCodeFieldForAccountSet("domesticCurrencyCode","");
	}


	public RetailStoreForm domesticCurrencyNameFieldForAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyNameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm domesticCurrencyNameFieldForAccountSet(String initValue){
		return domesticCurrencyNameFieldForAccountSet("domesticCurrencyName",initValue);
	}
	public RetailStoreForm domesticCurrencyNameFieldForAccountSet(){
		return domesticCurrencyNameFieldForAccountSet("domesticCurrencyName","");
	}


	public RetailStoreForm openingBankFieldForAccountSet(String parameterName, String initValue){
		FormField field =  openingBankFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm openingBankFieldForAccountSet(String initValue){
		return openingBankFieldForAccountSet("openingBank",initValue);
	}
	public RetailStoreForm openingBankFieldForAccountSet(){
		return openingBankFieldForAccountSet("openingBank","");
	}


	public RetailStoreForm accountNumberFieldForAccountSet(String parameterName, String initValue){
		FormField field =  accountNumberFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm accountNumberFieldForAccountSet(String initValue){
		return accountNumberFieldForAccountSet("accountNumber",initValue);
	}
	public RetailStoreForm accountNumberFieldForAccountSet(){
		return accountNumberFieldForAccountSet("accountNumber","");
	}


	public RetailStoreForm countryCenterIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  countryCenterIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm countryCenterIdFieldForAccountSet(String initValue){
		return countryCenterIdFieldForAccountSet("countryCenterId",initValue);
	}
	public RetailStoreForm countryCenterIdFieldForAccountSet(){
		return countryCenterIdFieldForAccountSet("countryCenterId","");
	}


	public RetailStoreForm retailStoreIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  retailStoreIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm retailStoreIdFieldForAccountSet(String initValue){
		return retailStoreIdFieldForAccountSet("retailStoreId",initValue);
	}
	public RetailStoreForm retailStoreIdFieldForAccountSet(){
		return retailStoreIdFieldForAccountSet("retailStoreId","");
	}


	public RetailStoreForm goodsSupplierIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  goodsSupplierIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm goodsSupplierIdFieldForAccountSet(String initValue){
		return goodsSupplierIdFieldForAccountSet("goodsSupplierId",initValue);
	}
	public RetailStoreForm goodsSupplierIdFieldForAccountSet(){
		return goodsSupplierIdFieldForAccountSet("goodsSupplierId","");
	}


	public RetailStoreForm lastUpdateTimeFieldForAccountSet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreForm lastUpdateTimeFieldForAccountSet(String initValue){
		return lastUpdateTimeFieldForAccountSet("lastUpdateTime",initValue);
	}
	public RetailStoreForm lastUpdateTimeFieldForAccountSet(){
		return lastUpdateTimeFieldForAccountSet("lastUpdateTime","");
	}

	

	
 	public RetailStoreForm transferToAnotherRetailStoreCountryCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRetailStoreCountryCenter/retailStoreId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RetailStoreForm transferToAnotherCityServiceCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityServiceCenter/retailStoreId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RetailStoreForm  createAction(){
		FormAction action = new FormAction();
		action.setLabel("创建");
		action.setLocaleKey("retail_store.create");
		action.setUrl("retailStoreManager/create/retailStoreId/comment/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreForm  inviteInvestmentAction(){
		FormAction action = new FormAction();
		action.setLabel("邀请投资");
		action.setLocaleKey("retail_store.inviteInvestment");
		action.setUrl("retailStoreManager/inviteInvestment/retailStoreId/comment/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreForm  franchiseAction(){
		FormAction action = new FormAction();
		action.setLabel("特许经营");
		action.setLocaleKey("retail_store.franchise");
		action.setUrl("retailStoreManager/franchise/retailStoreId/comment/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreForm  decorateAction(){
		FormAction action = new FormAction();
		action.setLabel("装修");
		action.setLocaleKey("retail_store.decorate");
		action.setUrl("retailStoreManager/decorate/retailStoreId/comment/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreForm  openAction(){
		FormAction action = new FormAction();
		action.setLabel("开放");
		action.setLocaleKey("retail_store.open");
		action.setUrl("retailStoreManager/open/retailStoreId/comment/");
		this.addFormAction(action);
		return this;
	}	
 	public RetailStoreForm  closeAction(){
		FormAction action = new FormAction();
		action.setLabel("关闭");
		action.setLocaleKey("retail_store.close");
		action.setUrl("retailStoreManager/close/retailStoreId/comment/");
		this.addFormAction(action);
		return this;
	}

	public RetailStoreForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



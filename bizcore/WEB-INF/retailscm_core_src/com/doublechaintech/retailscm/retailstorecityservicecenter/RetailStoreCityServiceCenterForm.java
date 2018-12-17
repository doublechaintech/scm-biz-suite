package com.doublechaintech.retailscm.retailstorecityservicecenter;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreCityServiceCenterForm extends BaseForm {
	
	
	public RetailStoreCityServiceCenterForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreCityServiceCenterForm retailStoreCityServiceCenterIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm retailStoreCityServiceCenterIdField(String initValue){
		return retailStoreCityServiceCenterIdField("retailStoreCityServiceCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm retailStoreCityServiceCenterIdField(){
		return retailStoreCityServiceCenterIdField("retailStoreCityServiceCenterId","");
	}


	public RetailStoreCityServiceCenterForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreCityServiceCenterForm nameField(){
		return nameField("name","");
	}


	public RetailStoreCityServiceCenterForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public RetailStoreCityServiceCenterForm foundedField(){
		return foundedField("founded","");
	}


	public RetailStoreCityServiceCenterForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public RetailStoreCityServiceCenterForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public RetailStoreCityServiceCenterForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public RetailStoreCityServiceCenterForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public RetailStoreCityServiceCenterForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreCityServiceCenterForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(String initValue){
		return retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter("retailStoreProvinceCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(){
		return retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter("retailStoreProvinceCenterId","");
	}


	public RetailStoreCityServiceCenterForm nameFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreCityServiceCenterForm nameFieldOfRetailStoreProvinceCenter(String initValue){
		return nameFieldOfRetailStoreProvinceCenter("name",initValue);
	}
	public RetailStoreCityServiceCenterForm nameFieldOfRetailStoreProvinceCenter(){
		return nameFieldOfRetailStoreProvinceCenter("name","");
	}


	public RetailStoreCityServiceCenterForm foundedFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreCityServiceCenterForm foundedFieldOfRetailStoreProvinceCenter(String initValue){
		return foundedFieldOfRetailStoreProvinceCenter("founded",initValue);
	}
	public RetailStoreCityServiceCenterForm foundedFieldOfRetailStoreProvinceCenter(){
		return foundedFieldOfRetailStoreProvinceCenter("founded","");
	}


	public RetailStoreCityServiceCenterForm countryIdFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  countryIdFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreCityServiceCenterForm countryIdFieldOfRetailStoreProvinceCenter(String initValue){
		return countryIdFieldOfRetailStoreProvinceCenter("countryId",initValue);
	}
	public RetailStoreCityServiceCenterForm countryIdFieldOfRetailStoreProvinceCenter(){
		return countryIdFieldOfRetailStoreProvinceCenter("countryId","");
	}


	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreProvinceCenter("lastUpdateTime",initValue);
	}
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(){
		return lastUpdateTimeFieldOfRetailStoreProvinceCenter("lastUpdateTime","");
	}

	



	public RetailStoreCityServiceCenterForm cityPartnerIdFieldForCityPartner(String parameterName, String initValue){
		FormField field =  idFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityPartnerIdFieldForCityPartner(String initValue){
		return cityPartnerIdFieldForCityPartner("cityPartnerId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityPartnerIdFieldForCityPartner(){
		return cityPartnerIdFieldForCityPartner("cityPartnerId","");
	}


	public RetailStoreCityServiceCenterForm nameFieldForCityPartner(String parameterName, String initValue){
		FormField field =  nameFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm nameFieldForCityPartner(String initValue){
		return nameFieldForCityPartner("name",initValue);
	}
	public RetailStoreCityServiceCenterForm nameFieldForCityPartner(){
		return nameFieldForCityPartner("name","");
	}


	public RetailStoreCityServiceCenterForm mobileFieldForCityPartner(String parameterName, String initValue){
		FormField field =  mobileFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm mobileFieldForCityPartner(String initValue){
		return mobileFieldForCityPartner("mobile",initValue);
	}
	public RetailStoreCityServiceCenterForm mobileFieldForCityPartner(){
		return mobileFieldForCityPartner("mobile","");
	}


	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForCityPartner(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForCityPartner(String initValue){
		return cityServiceCenterIdFieldForCityPartner("cityServiceCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForCityPartner(){
		return cityServiceCenterIdFieldForCityPartner("cityServiceCenterId","");
	}


	public RetailStoreCityServiceCenterForm descriptionFieldForCityPartner(String parameterName, String initValue){
		FormField field =  descriptionFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm descriptionFieldForCityPartner(String initValue){
		return descriptionFieldForCityPartner("description",initValue);
	}
	public RetailStoreCityServiceCenterForm descriptionFieldForCityPartner(){
		return descriptionFieldForCityPartner("description","");
	}


	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForCityPartner(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForCityPartner(String initValue){
		return lastUpdateTimeFieldForCityPartner("lastUpdateTime",initValue);
	}
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForCityPartner(){
		return lastUpdateTimeFieldForCityPartner("lastUpdateTime","");
	}


	public RetailStoreCityServiceCenterForm potentialCustomerIdFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm potentialCustomerIdFieldForPotentialCustomer(String initValue){
		return potentialCustomerIdFieldForPotentialCustomer("potentialCustomerId",initValue);
	}
	public RetailStoreCityServiceCenterForm potentialCustomerIdFieldForPotentialCustomer(){
		return potentialCustomerIdFieldForPotentialCustomer("potentialCustomerId","");
	}


	public RetailStoreCityServiceCenterForm nameFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm nameFieldForPotentialCustomer(String initValue){
		return nameFieldForPotentialCustomer("name",initValue);
	}
	public RetailStoreCityServiceCenterForm nameFieldForPotentialCustomer(){
		return nameFieldForPotentialCustomer("name","");
	}


	public RetailStoreCityServiceCenterForm mobileFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm mobileFieldForPotentialCustomer(String initValue){
		return mobileFieldForPotentialCustomer("mobile",initValue);
	}
	public RetailStoreCityServiceCenterForm mobileFieldForPotentialCustomer(){
		return mobileFieldForPotentialCustomer("mobile","");
	}


	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForPotentialCustomer(String initValue){
		return cityServiceCenterIdFieldForPotentialCustomer("cityServiceCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForPotentialCustomer(){
		return cityServiceCenterIdFieldForPotentialCustomer("cityServiceCenterId","");
	}


	public RetailStoreCityServiceCenterForm cityPartnerIdFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityPartnerIdFieldForPotentialCustomer(String initValue){
		return cityPartnerIdFieldForPotentialCustomer("cityPartnerId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityPartnerIdFieldForPotentialCustomer(){
		return cityPartnerIdFieldForPotentialCustomer("cityPartnerId","");
	}


	public RetailStoreCityServiceCenterForm descriptionFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm descriptionFieldForPotentialCustomer(String initValue){
		return descriptionFieldForPotentialCustomer("description",initValue);
	}
	public RetailStoreCityServiceCenterForm descriptionFieldForPotentialCustomer(){
		return descriptionFieldForPotentialCustomer("description","");
	}


	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForPotentialCustomer(String initValue){
		return lastUpdateTimeFieldForPotentialCustomer("lastUpdateTime",initValue);
	}
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForPotentialCustomer(){
		return lastUpdateTimeFieldForPotentialCustomer("lastUpdateTime","");
	}


	public RetailStoreCityServiceCenterForm cityEventIdFieldForCityEvent(String parameterName, String initValue){
		FormField field =  idFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityEventIdFieldForCityEvent(String initValue){
		return cityEventIdFieldForCityEvent("cityEventId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityEventIdFieldForCityEvent(){
		return cityEventIdFieldForCityEvent("cityEventId","");
	}


	public RetailStoreCityServiceCenterForm nameFieldForCityEvent(String parameterName, String initValue){
		FormField field =  nameFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm nameFieldForCityEvent(String initValue){
		return nameFieldForCityEvent("name",initValue);
	}
	public RetailStoreCityServiceCenterForm nameFieldForCityEvent(){
		return nameFieldForCityEvent("name","");
	}


	public RetailStoreCityServiceCenterForm mobileFieldForCityEvent(String parameterName, String initValue){
		FormField field =  mobileFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm mobileFieldForCityEvent(String initValue){
		return mobileFieldForCityEvent("mobile",initValue);
	}
	public RetailStoreCityServiceCenterForm mobileFieldForCityEvent(){
		return mobileFieldForCityEvent("mobile","");
	}


	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForCityEvent(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForCityEvent(String initValue){
		return cityServiceCenterIdFieldForCityEvent("cityServiceCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForCityEvent(){
		return cityServiceCenterIdFieldForCityEvent("cityServiceCenterId","");
	}


	public RetailStoreCityServiceCenterForm descriptionFieldForCityEvent(String parameterName, String initValue){
		FormField field =  descriptionFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm descriptionFieldForCityEvent(String initValue){
		return descriptionFieldForCityEvent("description",initValue);
	}
	public RetailStoreCityServiceCenterForm descriptionFieldForCityEvent(){
		return descriptionFieldForCityEvent("description","");
	}


	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForCityEvent(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForCityEvent(String initValue){
		return lastUpdateTimeFieldForCityEvent("lastUpdateTime",initValue);
	}
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForCityEvent(){
		return lastUpdateTimeFieldForCityEvent("lastUpdateTime","");
	}


	public RetailStoreCityServiceCenterForm retailStoreIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm retailStoreIdFieldForRetailStore(String initValue){
		return retailStoreIdFieldForRetailStore("retailStoreId",initValue);
	}
	public RetailStoreCityServiceCenterForm retailStoreIdFieldForRetailStore(){
		return retailStoreIdFieldForRetailStore("retailStoreId","");
	}


	public RetailStoreCityServiceCenterForm nameFieldForRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm nameFieldForRetailStore(String initValue){
		return nameFieldForRetailStore("name",initValue);
	}
	public RetailStoreCityServiceCenterForm nameFieldForRetailStore(){
		return nameFieldForRetailStore("name","");
	}


	public RetailStoreCityServiceCenterForm telephoneFieldForRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm telephoneFieldForRetailStore(String initValue){
		return telephoneFieldForRetailStore("telephone",initValue);
	}
	public RetailStoreCityServiceCenterForm telephoneFieldForRetailStore(){
		return telephoneFieldForRetailStore("telephone","");
	}


	public RetailStoreCityServiceCenterForm ownerFieldForRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm ownerFieldForRetailStore(String initValue){
		return ownerFieldForRetailStore("owner",initValue);
	}
	public RetailStoreCityServiceCenterForm ownerFieldForRetailStore(){
		return ownerFieldForRetailStore("owner","");
	}


	public RetailStoreCityServiceCenterForm retailStoreCountryCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm retailStoreCountryCenterIdFieldForRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm retailStoreCountryCenterIdFieldForRetailStore(){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId","");
	}


	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForRetailStore(String initValue){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId",initValue);
	}
	public RetailStoreCityServiceCenterForm cityServiceCenterIdFieldForRetailStore(){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId","");
	}


	public RetailStoreCityServiceCenterForm creationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm creationIdFieldForRetailStore(String initValue){
		return creationIdFieldForRetailStore("creationId",initValue);
	}
	public RetailStoreCityServiceCenterForm creationIdFieldForRetailStore(){
		return creationIdFieldForRetailStore("creationId","");
	}


	public RetailStoreCityServiceCenterForm investmentInvitationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm investmentInvitationIdFieldForRetailStore(String initValue){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId",initValue);
	}
	public RetailStoreCityServiceCenterForm investmentInvitationIdFieldForRetailStore(){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId","");
	}


	public RetailStoreCityServiceCenterForm franchisingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm franchisingIdFieldForRetailStore(String initValue){
		return franchisingIdFieldForRetailStore("franchisingId",initValue);
	}
	public RetailStoreCityServiceCenterForm franchisingIdFieldForRetailStore(){
		return franchisingIdFieldForRetailStore("franchisingId","");
	}


	public RetailStoreCityServiceCenterForm decorationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm decorationIdFieldForRetailStore(String initValue){
		return decorationIdFieldForRetailStore("decorationId",initValue);
	}
	public RetailStoreCityServiceCenterForm decorationIdFieldForRetailStore(){
		return decorationIdFieldForRetailStore("decorationId","");
	}


	public RetailStoreCityServiceCenterForm openingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm openingIdFieldForRetailStore(String initValue){
		return openingIdFieldForRetailStore("openingId",initValue);
	}
	public RetailStoreCityServiceCenterForm openingIdFieldForRetailStore(){
		return openingIdFieldForRetailStore("openingId","");
	}


	public RetailStoreCityServiceCenterForm closingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm closingIdFieldForRetailStore(String initValue){
		return closingIdFieldForRetailStore("closingId",initValue);
	}
	public RetailStoreCityServiceCenterForm closingIdFieldForRetailStore(){
		return closingIdFieldForRetailStore("closingId","");
	}


	public RetailStoreCityServiceCenterForm foundedFieldForRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm foundedFieldForRetailStore(String initValue){
		return foundedFieldForRetailStore("founded",initValue);
	}
	public RetailStoreCityServiceCenterForm foundedFieldForRetailStore(){
		return foundedFieldForRetailStore("founded","");
	}


	public RetailStoreCityServiceCenterForm latitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm latitudeFieldForRetailStore(String initValue){
		return latitudeFieldForRetailStore("latitude",initValue);
	}
	public RetailStoreCityServiceCenterForm latitudeFieldForRetailStore(){
		return latitudeFieldForRetailStore("latitude","");
	}


	public RetailStoreCityServiceCenterForm longitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm longitudeFieldForRetailStore(String initValue){
		return longitudeFieldForRetailStore("longitude",initValue);
	}
	public RetailStoreCityServiceCenterForm longitudeFieldForRetailStore(){
		return longitudeFieldForRetailStore("longitude","");
	}


	public RetailStoreCityServiceCenterForm descriptionFieldForRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm descriptionFieldForRetailStore(String initValue){
		return descriptionFieldForRetailStore("description",initValue);
	}
	public RetailStoreCityServiceCenterForm descriptionFieldForRetailStore(){
		return descriptionFieldForRetailStore("description","");
	}


	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForRetailStore(String initValue){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime",initValue);
	}
	public RetailStoreCityServiceCenterForm lastUpdateTimeFieldForRetailStore(){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime","");
	}


	public RetailStoreCityServiceCenterForm currentStatusFieldForRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCityServiceCenterForm currentStatusFieldForRetailStore(String initValue){
		return currentStatusFieldForRetailStore("currentStatus",initValue);
	}
	public RetailStoreCityServiceCenterForm currentStatusFieldForRetailStore(){
		return currentStatusFieldForRetailStore("currentStatus","");
	}

	

	
 	public RetailStoreCityServiceCenterForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/retailStoreCityServiceCenterId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreCityServiceCenterForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



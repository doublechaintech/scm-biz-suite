package com.doublechaintech.retailscm.retailstorecreation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreCreationForm extends BaseForm {
	
	
	public RetailStoreCreationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreCreationForm retailStoreCreationIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm retailStoreCreationIdField(String initValue){
		return retailStoreCreationIdField("retailStoreCreationId",initValue);
	}
	public RetailStoreCreationForm retailStoreCreationIdField(){
		return retailStoreCreationIdField("retailStoreCreationId","");
	}


	public RetailStoreCreationForm commentField(String parameterName, String initValue){
		FormField field = commentFromRetailStoreCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm commentField(String initValue){
		return commentField("comment",initValue);
	}
	public RetailStoreCreationForm commentField(){
		return commentField("comment","");
	}

	
	

	



	public RetailStoreCreationForm retailStoreIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm retailStoreIdFieldForRetailStore(String initValue){
		return retailStoreIdFieldForRetailStore("retailStoreId",initValue);
	}
	public RetailStoreCreationForm retailStoreIdFieldForRetailStore(){
		return retailStoreIdFieldForRetailStore("retailStoreId","");
	}


	public RetailStoreCreationForm nameFieldForRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm nameFieldForRetailStore(String initValue){
		return nameFieldForRetailStore("name",initValue);
	}
	public RetailStoreCreationForm nameFieldForRetailStore(){
		return nameFieldForRetailStore("name","");
	}


	public RetailStoreCreationForm telephoneFieldForRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm telephoneFieldForRetailStore(String initValue){
		return telephoneFieldForRetailStore("telephone",initValue);
	}
	public RetailStoreCreationForm telephoneFieldForRetailStore(){
		return telephoneFieldForRetailStore("telephone","");
	}


	public RetailStoreCreationForm ownerFieldForRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm ownerFieldForRetailStore(String initValue){
		return ownerFieldForRetailStore("owner",initValue);
	}
	public RetailStoreCreationForm ownerFieldForRetailStore(){
		return ownerFieldForRetailStore("owner","");
	}


	public RetailStoreCreationForm retailStoreCountryCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm retailStoreCountryCenterIdFieldForRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreCreationForm retailStoreCountryCenterIdFieldForRetailStore(){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId","");
	}


	public RetailStoreCreationForm cityServiceCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm cityServiceCenterIdFieldForRetailStore(String initValue){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId",initValue);
	}
	public RetailStoreCreationForm cityServiceCenterIdFieldForRetailStore(){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId","");
	}


	public RetailStoreCreationForm creationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm creationIdFieldForRetailStore(String initValue){
		return creationIdFieldForRetailStore("creationId",initValue);
	}
	public RetailStoreCreationForm creationIdFieldForRetailStore(){
		return creationIdFieldForRetailStore("creationId","");
	}


	public RetailStoreCreationForm investmentInvitationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm investmentInvitationIdFieldForRetailStore(String initValue){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId",initValue);
	}
	public RetailStoreCreationForm investmentInvitationIdFieldForRetailStore(){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId","");
	}


	public RetailStoreCreationForm franchisingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm franchisingIdFieldForRetailStore(String initValue){
		return franchisingIdFieldForRetailStore("franchisingId",initValue);
	}
	public RetailStoreCreationForm franchisingIdFieldForRetailStore(){
		return franchisingIdFieldForRetailStore("franchisingId","");
	}


	public RetailStoreCreationForm decorationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm decorationIdFieldForRetailStore(String initValue){
		return decorationIdFieldForRetailStore("decorationId",initValue);
	}
	public RetailStoreCreationForm decorationIdFieldForRetailStore(){
		return decorationIdFieldForRetailStore("decorationId","");
	}


	public RetailStoreCreationForm openingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm openingIdFieldForRetailStore(String initValue){
		return openingIdFieldForRetailStore("openingId",initValue);
	}
	public RetailStoreCreationForm openingIdFieldForRetailStore(){
		return openingIdFieldForRetailStore("openingId","");
	}


	public RetailStoreCreationForm closingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm closingIdFieldForRetailStore(String initValue){
		return closingIdFieldForRetailStore("closingId",initValue);
	}
	public RetailStoreCreationForm closingIdFieldForRetailStore(){
		return closingIdFieldForRetailStore("closingId","");
	}


	public RetailStoreCreationForm foundedFieldForRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm foundedFieldForRetailStore(String initValue){
		return foundedFieldForRetailStore("founded",initValue);
	}
	public RetailStoreCreationForm foundedFieldForRetailStore(){
		return foundedFieldForRetailStore("founded","");
	}


	public RetailStoreCreationForm latitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm latitudeFieldForRetailStore(String initValue){
		return latitudeFieldForRetailStore("latitude",initValue);
	}
	public RetailStoreCreationForm latitudeFieldForRetailStore(){
		return latitudeFieldForRetailStore("latitude","");
	}


	public RetailStoreCreationForm longitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm longitudeFieldForRetailStore(String initValue){
		return longitudeFieldForRetailStore("longitude",initValue);
	}
	public RetailStoreCreationForm longitudeFieldForRetailStore(){
		return longitudeFieldForRetailStore("longitude","");
	}


	public RetailStoreCreationForm descriptionFieldForRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm descriptionFieldForRetailStore(String initValue){
		return descriptionFieldForRetailStore("description",initValue);
	}
	public RetailStoreCreationForm descriptionFieldForRetailStore(){
		return descriptionFieldForRetailStore("description","");
	}


	public RetailStoreCreationForm lastUpdateTimeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm lastUpdateTimeFieldForRetailStore(String initValue){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime",initValue);
	}
	public RetailStoreCreationForm lastUpdateTimeFieldForRetailStore(){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime","");
	}


	public RetailStoreCreationForm currentStatusFieldForRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCreationForm currentStatusFieldForRetailStore(String initValue){
		return currentStatusFieldForRetailStore("currentStatus",initValue);
	}
	public RetailStoreCreationForm currentStatusFieldForRetailStore(){
		return currentStatusFieldForRetailStore("currentStatus","");
	}

	



	public RetailStoreCreationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



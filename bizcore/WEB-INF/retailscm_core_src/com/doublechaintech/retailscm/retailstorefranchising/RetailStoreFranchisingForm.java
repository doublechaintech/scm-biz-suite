package com.doublechaintech.retailscm.retailstorefranchising;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreFranchisingForm extends BaseForm {
	
	
	public RetailStoreFranchisingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreFranchisingForm retailStoreFranchisingIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreFranchising(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm retailStoreFranchisingIdField(String initValue){
		return retailStoreFranchisingIdField("retailStoreFranchisingId",initValue);
	}
	public RetailStoreFranchisingForm retailStoreFranchisingIdField(){
		return retailStoreFranchisingIdField("retailStoreFranchisingId","");
	}


	public RetailStoreFranchisingForm commentField(String parameterName, String initValue){
		FormField field = commentFromRetailStoreFranchising(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm commentField(String initValue){
		return commentField("comment",initValue);
	}
	public RetailStoreFranchisingForm commentField(){
		return commentField("comment","");
	}

	
	

	



	public RetailStoreFranchisingForm retailStoreIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm retailStoreIdFieldForRetailStore(String initValue){
		return retailStoreIdFieldForRetailStore("retailStoreId",initValue);
	}
	public RetailStoreFranchisingForm retailStoreIdFieldForRetailStore(){
		return retailStoreIdFieldForRetailStore("retailStoreId","");
	}


	public RetailStoreFranchisingForm nameFieldForRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm nameFieldForRetailStore(String initValue){
		return nameFieldForRetailStore("name",initValue);
	}
	public RetailStoreFranchisingForm nameFieldForRetailStore(){
		return nameFieldForRetailStore("name","");
	}


	public RetailStoreFranchisingForm telephoneFieldForRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm telephoneFieldForRetailStore(String initValue){
		return telephoneFieldForRetailStore("telephone",initValue);
	}
	public RetailStoreFranchisingForm telephoneFieldForRetailStore(){
		return telephoneFieldForRetailStore("telephone","");
	}


	public RetailStoreFranchisingForm ownerFieldForRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm ownerFieldForRetailStore(String initValue){
		return ownerFieldForRetailStore("owner",initValue);
	}
	public RetailStoreFranchisingForm ownerFieldForRetailStore(){
		return ownerFieldForRetailStore("owner","");
	}


	public RetailStoreFranchisingForm retailStoreCountryCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm retailStoreCountryCenterIdFieldForRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreFranchisingForm retailStoreCountryCenterIdFieldForRetailStore(){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId","");
	}


	public RetailStoreFranchisingForm cityServiceCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm cityServiceCenterIdFieldForRetailStore(String initValue){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId",initValue);
	}
	public RetailStoreFranchisingForm cityServiceCenterIdFieldForRetailStore(){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId","");
	}


	public RetailStoreFranchisingForm creationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm creationIdFieldForRetailStore(String initValue){
		return creationIdFieldForRetailStore("creationId",initValue);
	}
	public RetailStoreFranchisingForm creationIdFieldForRetailStore(){
		return creationIdFieldForRetailStore("creationId","");
	}


	public RetailStoreFranchisingForm investmentInvitationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm investmentInvitationIdFieldForRetailStore(String initValue){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId",initValue);
	}
	public RetailStoreFranchisingForm investmentInvitationIdFieldForRetailStore(){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId","");
	}


	public RetailStoreFranchisingForm franchisingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm franchisingIdFieldForRetailStore(String initValue){
		return franchisingIdFieldForRetailStore("franchisingId",initValue);
	}
	public RetailStoreFranchisingForm franchisingIdFieldForRetailStore(){
		return franchisingIdFieldForRetailStore("franchisingId","");
	}


	public RetailStoreFranchisingForm decorationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm decorationIdFieldForRetailStore(String initValue){
		return decorationIdFieldForRetailStore("decorationId",initValue);
	}
	public RetailStoreFranchisingForm decorationIdFieldForRetailStore(){
		return decorationIdFieldForRetailStore("decorationId","");
	}


	public RetailStoreFranchisingForm openingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm openingIdFieldForRetailStore(String initValue){
		return openingIdFieldForRetailStore("openingId",initValue);
	}
	public RetailStoreFranchisingForm openingIdFieldForRetailStore(){
		return openingIdFieldForRetailStore("openingId","");
	}


	public RetailStoreFranchisingForm closingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm closingIdFieldForRetailStore(String initValue){
		return closingIdFieldForRetailStore("closingId",initValue);
	}
	public RetailStoreFranchisingForm closingIdFieldForRetailStore(){
		return closingIdFieldForRetailStore("closingId","");
	}


	public RetailStoreFranchisingForm foundedFieldForRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm foundedFieldForRetailStore(String initValue){
		return foundedFieldForRetailStore("founded",initValue);
	}
	public RetailStoreFranchisingForm foundedFieldForRetailStore(){
		return foundedFieldForRetailStore("founded","");
	}


	public RetailStoreFranchisingForm latitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm latitudeFieldForRetailStore(String initValue){
		return latitudeFieldForRetailStore("latitude",initValue);
	}
	public RetailStoreFranchisingForm latitudeFieldForRetailStore(){
		return latitudeFieldForRetailStore("latitude","");
	}


	public RetailStoreFranchisingForm longitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm longitudeFieldForRetailStore(String initValue){
		return longitudeFieldForRetailStore("longitude",initValue);
	}
	public RetailStoreFranchisingForm longitudeFieldForRetailStore(){
		return longitudeFieldForRetailStore("longitude","");
	}


	public RetailStoreFranchisingForm descriptionFieldForRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm descriptionFieldForRetailStore(String initValue){
		return descriptionFieldForRetailStore("description",initValue);
	}
	public RetailStoreFranchisingForm descriptionFieldForRetailStore(){
		return descriptionFieldForRetailStore("description","");
	}


	public RetailStoreFranchisingForm lastUpdateTimeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm lastUpdateTimeFieldForRetailStore(String initValue){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime",initValue);
	}
	public RetailStoreFranchisingForm lastUpdateTimeFieldForRetailStore(){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime","");
	}


	public RetailStoreFranchisingForm currentStatusFieldForRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreFranchisingForm currentStatusFieldForRetailStore(String initValue){
		return currentStatusFieldForRetailStore("currentStatus",initValue);
	}
	public RetailStoreFranchisingForm currentStatusFieldForRetailStore(){
		return currentStatusFieldForRetailStore("currentStatus","");
	}

	



	public RetailStoreFranchisingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.retailstoredecoration;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreDecorationForm extends BaseForm {
	
	
	public RetailStoreDecorationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreDecorationForm retailStoreDecorationIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreDecoration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm retailStoreDecorationIdField(String initValue){
		return retailStoreDecorationIdField("retailStoreDecorationId",initValue);
	}
	public RetailStoreDecorationForm retailStoreDecorationIdField(){
		return retailStoreDecorationIdField("retailStoreDecorationId","");
	}


	public RetailStoreDecorationForm commentField(String parameterName, String initValue){
		FormField field = commentFromRetailStoreDecoration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm commentField(String initValue){
		return commentField("comment",initValue);
	}
	public RetailStoreDecorationForm commentField(){
		return commentField("comment","");
	}

	
	

	



	public RetailStoreDecorationForm retailStoreIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm retailStoreIdFieldForRetailStore(String initValue){
		return retailStoreIdFieldForRetailStore("retailStoreId",initValue);
	}
	public RetailStoreDecorationForm retailStoreIdFieldForRetailStore(){
		return retailStoreIdFieldForRetailStore("retailStoreId","");
	}


	public RetailStoreDecorationForm nameFieldForRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm nameFieldForRetailStore(String initValue){
		return nameFieldForRetailStore("name",initValue);
	}
	public RetailStoreDecorationForm nameFieldForRetailStore(){
		return nameFieldForRetailStore("name","");
	}


	public RetailStoreDecorationForm telephoneFieldForRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm telephoneFieldForRetailStore(String initValue){
		return telephoneFieldForRetailStore("telephone",initValue);
	}
	public RetailStoreDecorationForm telephoneFieldForRetailStore(){
		return telephoneFieldForRetailStore("telephone","");
	}


	public RetailStoreDecorationForm ownerFieldForRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm ownerFieldForRetailStore(String initValue){
		return ownerFieldForRetailStore("owner",initValue);
	}
	public RetailStoreDecorationForm ownerFieldForRetailStore(){
		return ownerFieldForRetailStore("owner","");
	}


	public RetailStoreDecorationForm retailStoreCountryCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm retailStoreCountryCenterIdFieldForRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreDecorationForm retailStoreCountryCenterIdFieldForRetailStore(){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId","");
	}


	public RetailStoreDecorationForm cityServiceCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm cityServiceCenterIdFieldForRetailStore(String initValue){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId",initValue);
	}
	public RetailStoreDecorationForm cityServiceCenterIdFieldForRetailStore(){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId","");
	}


	public RetailStoreDecorationForm creationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm creationIdFieldForRetailStore(String initValue){
		return creationIdFieldForRetailStore("creationId",initValue);
	}
	public RetailStoreDecorationForm creationIdFieldForRetailStore(){
		return creationIdFieldForRetailStore("creationId","");
	}


	public RetailStoreDecorationForm investmentInvitationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm investmentInvitationIdFieldForRetailStore(String initValue){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId",initValue);
	}
	public RetailStoreDecorationForm investmentInvitationIdFieldForRetailStore(){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId","");
	}


	public RetailStoreDecorationForm franchisingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm franchisingIdFieldForRetailStore(String initValue){
		return franchisingIdFieldForRetailStore("franchisingId",initValue);
	}
	public RetailStoreDecorationForm franchisingIdFieldForRetailStore(){
		return franchisingIdFieldForRetailStore("franchisingId","");
	}


	public RetailStoreDecorationForm decorationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm decorationIdFieldForRetailStore(String initValue){
		return decorationIdFieldForRetailStore("decorationId",initValue);
	}
	public RetailStoreDecorationForm decorationIdFieldForRetailStore(){
		return decorationIdFieldForRetailStore("decorationId","");
	}


	public RetailStoreDecorationForm openingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm openingIdFieldForRetailStore(String initValue){
		return openingIdFieldForRetailStore("openingId",initValue);
	}
	public RetailStoreDecorationForm openingIdFieldForRetailStore(){
		return openingIdFieldForRetailStore("openingId","");
	}


	public RetailStoreDecorationForm closingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm closingIdFieldForRetailStore(String initValue){
		return closingIdFieldForRetailStore("closingId",initValue);
	}
	public RetailStoreDecorationForm closingIdFieldForRetailStore(){
		return closingIdFieldForRetailStore("closingId","");
	}


	public RetailStoreDecorationForm foundedFieldForRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm foundedFieldForRetailStore(String initValue){
		return foundedFieldForRetailStore("founded",initValue);
	}
	public RetailStoreDecorationForm foundedFieldForRetailStore(){
		return foundedFieldForRetailStore("founded","");
	}


	public RetailStoreDecorationForm latitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm latitudeFieldForRetailStore(String initValue){
		return latitudeFieldForRetailStore("latitude",initValue);
	}
	public RetailStoreDecorationForm latitudeFieldForRetailStore(){
		return latitudeFieldForRetailStore("latitude","");
	}


	public RetailStoreDecorationForm longitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm longitudeFieldForRetailStore(String initValue){
		return longitudeFieldForRetailStore("longitude",initValue);
	}
	public RetailStoreDecorationForm longitudeFieldForRetailStore(){
		return longitudeFieldForRetailStore("longitude","");
	}


	public RetailStoreDecorationForm descriptionFieldForRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm descriptionFieldForRetailStore(String initValue){
		return descriptionFieldForRetailStore("description",initValue);
	}
	public RetailStoreDecorationForm descriptionFieldForRetailStore(){
		return descriptionFieldForRetailStore("description","");
	}


	public RetailStoreDecorationForm lastUpdateTimeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm lastUpdateTimeFieldForRetailStore(String initValue){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime",initValue);
	}
	public RetailStoreDecorationForm lastUpdateTimeFieldForRetailStore(){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime","");
	}


	public RetailStoreDecorationForm currentStatusFieldForRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreDecorationForm currentStatusFieldForRetailStore(String initValue){
		return currentStatusFieldForRetailStore("currentStatus",initValue);
	}
	public RetailStoreDecorationForm currentStatusFieldForRetailStore(){
		return currentStatusFieldForRetailStore("currentStatus","");
	}

	



	public RetailStoreDecorationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



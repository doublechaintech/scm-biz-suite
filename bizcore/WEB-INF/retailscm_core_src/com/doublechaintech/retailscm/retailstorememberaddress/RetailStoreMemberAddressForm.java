package com.doublechaintech.retailscm.retailstorememberaddress;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreMemberAddressForm extends BaseForm {
	
	
	public RetailStoreMemberAddressForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreMemberAddressForm retailStoreMemberAddressIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberAddressForm retailStoreMemberAddressIdField(String initValue){
		return retailStoreMemberAddressIdField("retailStoreMemberAddressId",initValue);
	}
	public RetailStoreMemberAddressForm retailStoreMemberAddressIdField(){
		return retailStoreMemberAddressIdField("retailStoreMemberAddressId","");
	}


	public RetailStoreMemberAddressForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberAddressForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreMemberAddressForm nameField(){
		return nameField("name","");
	}


	public RetailStoreMemberAddressForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberAddressForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public RetailStoreMemberAddressForm ownerIdField(){
		return ownerIdField("ownerId","");
	}


	public RetailStoreMemberAddressForm mobilePhoneField(String parameterName, String initValue){
		FormField field = mobilePhoneFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberAddressForm mobilePhoneField(String initValue){
		return mobilePhoneField("mobilePhone",initValue);
	}
	public RetailStoreMemberAddressForm mobilePhoneField(){
		return mobilePhoneField("mobilePhone","");
	}


	public RetailStoreMemberAddressForm addressField(String parameterName, String initValue){
		FormField field = addressFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberAddressForm addressField(String initValue){
		return addressField("address",initValue);
	}
	public RetailStoreMemberAddressForm addressField(){
		return addressField("address","");
	}

	
	


	public RetailStoreMemberAddressForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberAddressForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public RetailStoreMemberAddressForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public RetailStoreMemberAddressForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberAddressForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public RetailStoreMemberAddressForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public RetailStoreMemberAddressForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberAddressForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public RetailStoreMemberAddressForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public RetailStoreMemberAddressForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberAddressForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public RetailStoreMemberAddressForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}

	


	

	
 	public RetailStoreMemberAddressForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/retailStoreMemberAddressId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreMemberAddressForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



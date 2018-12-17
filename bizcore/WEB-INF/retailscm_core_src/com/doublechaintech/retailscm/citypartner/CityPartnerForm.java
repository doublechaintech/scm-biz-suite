package com.doublechaintech.retailscm.citypartner;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class CityPartnerForm extends BaseForm {
	
	
	public CityPartnerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CityPartnerForm cityPartnerIdField(String parameterName, String initValue){
		FormField field = idFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm cityPartnerIdField(String initValue){
		return cityPartnerIdField("cityPartnerId",initValue);
	}
	public CityPartnerForm cityPartnerIdField(){
		return cityPartnerIdField("cityPartnerId","");
	}


	public CityPartnerForm nameField(String parameterName, String initValue){
		FormField field = nameFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CityPartnerForm nameField(){
		return nameField("name","");
	}


	public CityPartnerForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public CityPartnerForm mobileField(){
		return mobileField("mobile","");
	}


	public CityPartnerForm cityServiceCenterIdField(String parameterName, String initValue){
		FormField field = cityServiceCenterIdFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm cityServiceCenterIdField(String initValue){
		return cityServiceCenterIdField("cityServiceCenterId",initValue);
	}
	public CityPartnerForm cityServiceCenterIdField(){
		return cityServiceCenterIdField("cityServiceCenterId","");
	}


	public CityPartnerForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public CityPartnerForm descriptionField(){
		return descriptionField("description","");
	}


	public CityPartnerForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromCityPartner(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public CityPartnerForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public CityPartnerForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityPartnerForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId",initValue);
	}
	public CityPartnerForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId","");
	}


	public CityPartnerForm nameFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityPartnerForm nameFieldOfRetailStoreCityServiceCenter(String initValue){
		return nameFieldOfRetailStoreCityServiceCenter("name",initValue);
	}
	public CityPartnerForm nameFieldOfRetailStoreCityServiceCenter(){
		return nameFieldOfRetailStoreCityServiceCenter("name","");
	}


	public CityPartnerForm foundedFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityPartnerForm foundedFieldOfRetailStoreCityServiceCenter(String initValue){
		return foundedFieldOfRetailStoreCityServiceCenter("founded",initValue);
	}
	public CityPartnerForm foundedFieldOfRetailStoreCityServiceCenter(){
		return foundedFieldOfRetailStoreCityServiceCenter("founded","");
	}


	public CityPartnerForm belongsToIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  belongsToIdFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityPartnerForm belongsToIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId",initValue);
	}
	public CityPartnerForm belongsToIdFieldOfRetailStoreCityServiceCenter(){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId","");
	}


	public CityPartnerForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityPartnerForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime",initValue);
	}
	public CityPartnerForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime","");
	}

	



	public CityPartnerForm potentialCustomerIdFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm potentialCustomerIdFieldForPotentialCustomer(String initValue){
		return potentialCustomerIdFieldForPotentialCustomer("potentialCustomerId",initValue);
	}
	public CityPartnerForm potentialCustomerIdFieldForPotentialCustomer(){
		return potentialCustomerIdFieldForPotentialCustomer("potentialCustomerId","");
	}


	public CityPartnerForm nameFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm nameFieldForPotentialCustomer(String initValue){
		return nameFieldForPotentialCustomer("name",initValue);
	}
	public CityPartnerForm nameFieldForPotentialCustomer(){
		return nameFieldForPotentialCustomer("name","");
	}


	public CityPartnerForm mobileFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm mobileFieldForPotentialCustomer(String initValue){
		return mobileFieldForPotentialCustomer("mobile",initValue);
	}
	public CityPartnerForm mobileFieldForPotentialCustomer(){
		return mobileFieldForPotentialCustomer("mobile","");
	}


	public CityPartnerForm cityServiceCenterIdFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm cityServiceCenterIdFieldForPotentialCustomer(String initValue){
		return cityServiceCenterIdFieldForPotentialCustomer("cityServiceCenterId",initValue);
	}
	public CityPartnerForm cityServiceCenterIdFieldForPotentialCustomer(){
		return cityServiceCenterIdFieldForPotentialCustomer("cityServiceCenterId","");
	}


	public CityPartnerForm cityPartnerIdFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm cityPartnerIdFieldForPotentialCustomer(String initValue){
		return cityPartnerIdFieldForPotentialCustomer("cityPartnerId",initValue);
	}
	public CityPartnerForm cityPartnerIdFieldForPotentialCustomer(){
		return cityPartnerIdFieldForPotentialCustomer("cityPartnerId","");
	}


	public CityPartnerForm descriptionFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm descriptionFieldForPotentialCustomer(String initValue){
		return descriptionFieldForPotentialCustomer("description",initValue);
	}
	public CityPartnerForm descriptionFieldForPotentialCustomer(){
		return descriptionFieldForPotentialCustomer("description","");
	}


	public CityPartnerForm lastUpdateTimeFieldForPotentialCustomer(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm lastUpdateTimeFieldForPotentialCustomer(String initValue){
		return lastUpdateTimeFieldForPotentialCustomer("lastUpdateTime",initValue);
	}
	public CityPartnerForm lastUpdateTimeFieldForPotentialCustomer(){
		return lastUpdateTimeFieldForPotentialCustomer("lastUpdateTime","");
	}


	public CityPartnerForm potentialCustomerContactIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm potentialCustomerContactIdFieldForPotentialCustomerContact(String initValue){
		return potentialCustomerContactIdFieldForPotentialCustomerContact("potentialCustomerContactId",initValue);
	}
	public CityPartnerForm potentialCustomerContactIdFieldForPotentialCustomerContact(){
		return potentialCustomerContactIdFieldForPotentialCustomerContact("potentialCustomerContactId","");
	}


	public CityPartnerForm nameFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm nameFieldForPotentialCustomerContact(String initValue){
		return nameFieldForPotentialCustomerContact("name",initValue);
	}
	public CityPartnerForm nameFieldForPotentialCustomerContact(){
		return nameFieldForPotentialCustomerContact("name","");
	}


	public CityPartnerForm contactDateFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactDateFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm contactDateFieldForPotentialCustomerContact(String initValue){
		return contactDateFieldForPotentialCustomerContact("contactDate",initValue);
	}
	public CityPartnerForm contactDateFieldForPotentialCustomerContact(){
		return contactDateFieldForPotentialCustomerContact("contactDate","");
	}


	public CityPartnerForm contactMethodFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactMethodFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm contactMethodFieldForPotentialCustomerContact(String initValue){
		return contactMethodFieldForPotentialCustomerContact("contactMethod",initValue);
	}
	public CityPartnerForm contactMethodFieldForPotentialCustomerContact(){
		return contactMethodFieldForPotentialCustomerContact("contactMethod","");
	}


	public CityPartnerForm potentialCustomerIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm potentialCustomerIdFieldForPotentialCustomerContact(String initValue){
		return potentialCustomerIdFieldForPotentialCustomerContact("potentialCustomerId",initValue);
	}
	public CityPartnerForm potentialCustomerIdFieldForPotentialCustomerContact(){
		return potentialCustomerIdFieldForPotentialCustomerContact("potentialCustomerId","");
	}


	public CityPartnerForm cityPartnerIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm cityPartnerIdFieldForPotentialCustomerContact(String initValue){
		return cityPartnerIdFieldForPotentialCustomerContact("cityPartnerId",initValue);
	}
	public CityPartnerForm cityPartnerIdFieldForPotentialCustomerContact(){
		return cityPartnerIdFieldForPotentialCustomerContact("cityPartnerId","");
	}


	public CityPartnerForm contactToIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactToIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm contactToIdFieldForPotentialCustomerContact(String initValue){
		return contactToIdFieldForPotentialCustomerContact("contactToId",initValue);
	}
	public CityPartnerForm contactToIdFieldForPotentialCustomerContact(){
		return contactToIdFieldForPotentialCustomerContact("contactToId","");
	}


	public CityPartnerForm descriptionFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm descriptionFieldForPotentialCustomerContact(String initValue){
		return descriptionFieldForPotentialCustomerContact("description",initValue);
	}
	public CityPartnerForm descriptionFieldForPotentialCustomerContact(){
		return descriptionFieldForPotentialCustomerContact("description","");
	}


	public CityPartnerForm lastUpdateTimeFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityPartnerForm lastUpdateTimeFieldForPotentialCustomerContact(String initValue){
		return lastUpdateTimeFieldForPotentialCustomerContact("lastUpdateTime",initValue);
	}
	public CityPartnerForm lastUpdateTimeFieldForPotentialCustomerContact(){
		return lastUpdateTimeFieldForPotentialCustomerContact("lastUpdateTime","");
	}

	

	
 	public CityPartnerForm transferToAnotherCityServiceCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityServiceCenter/cityPartnerId/");
		this.addFormAction(action);
		return this;
	}

 

	public CityPartnerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



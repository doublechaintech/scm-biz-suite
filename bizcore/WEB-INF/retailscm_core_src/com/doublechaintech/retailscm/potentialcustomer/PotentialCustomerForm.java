package com.doublechaintech.retailscm.potentialcustomer;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class PotentialCustomerForm extends BaseForm {
	
	
	public PotentialCustomerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PotentialCustomerForm potentialCustomerIdField(String parameterName, String initValue){
		FormField field = idFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm potentialCustomerIdField(String initValue){
		return potentialCustomerIdField("potentialCustomerId",initValue);
	}
	public PotentialCustomerForm potentialCustomerIdField(){
		return potentialCustomerIdField("potentialCustomerId","");
	}


	public PotentialCustomerForm nameField(String parameterName, String initValue){
		FormField field = nameFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PotentialCustomerForm nameField(){
		return nameField("name","");
	}


	public PotentialCustomerForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public PotentialCustomerForm mobileField(){
		return mobileField("mobile","");
	}


	public PotentialCustomerForm cityServiceCenterIdField(String parameterName, String initValue){
		FormField field = cityServiceCenterIdFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm cityServiceCenterIdField(String initValue){
		return cityServiceCenterIdField("cityServiceCenterId",initValue);
	}
	public PotentialCustomerForm cityServiceCenterIdField(){
		return cityServiceCenterIdField("cityServiceCenterId","");
	}


	public PotentialCustomerForm cityPartnerIdField(String parameterName, String initValue){
		FormField field = cityPartnerIdFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm cityPartnerIdField(String initValue){
		return cityPartnerIdField("cityPartnerId",initValue);
	}
	public PotentialCustomerForm cityPartnerIdField(){
		return cityPartnerIdField("cityPartnerId","");
	}


	public PotentialCustomerForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public PotentialCustomerForm descriptionField(){
		return descriptionField("description","");
	}


	public PotentialCustomerForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromPotentialCustomer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public PotentialCustomerForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public PotentialCustomerForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId",initValue);
	}
	public PotentialCustomerForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId","");
	}


	public PotentialCustomerForm nameFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm nameFieldOfRetailStoreCityServiceCenter(String initValue){
		return nameFieldOfRetailStoreCityServiceCenter("name",initValue);
	}
	public PotentialCustomerForm nameFieldOfRetailStoreCityServiceCenter(){
		return nameFieldOfRetailStoreCityServiceCenter("name","");
	}


	public PotentialCustomerForm foundedFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm foundedFieldOfRetailStoreCityServiceCenter(String initValue){
		return foundedFieldOfRetailStoreCityServiceCenter("founded",initValue);
	}
	public PotentialCustomerForm foundedFieldOfRetailStoreCityServiceCenter(){
		return foundedFieldOfRetailStoreCityServiceCenter("founded","");
	}


	public PotentialCustomerForm belongsToIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  belongsToIdFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm belongsToIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId",initValue);
	}
	public PotentialCustomerForm belongsToIdFieldOfRetailStoreCityServiceCenter(){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId","");
	}


	public PotentialCustomerForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime",initValue);
	}
	public PotentialCustomerForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime","");
	}


	public PotentialCustomerForm cityPartnerIdFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  idFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm cityPartnerIdFieldOfCityPartner(String initValue){
		return cityPartnerIdFieldOfCityPartner("cityPartnerId",initValue);
	}
	public PotentialCustomerForm cityPartnerIdFieldOfCityPartner(){
		return cityPartnerIdFieldOfCityPartner("cityPartnerId","");
	}


	public PotentialCustomerForm nameFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  nameFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm nameFieldOfCityPartner(String initValue){
		return nameFieldOfCityPartner("name",initValue);
	}
	public PotentialCustomerForm nameFieldOfCityPartner(){
		return nameFieldOfCityPartner("name","");
	}


	public PotentialCustomerForm mobileFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  mobileFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm mobileFieldOfCityPartner(String initValue){
		return mobileFieldOfCityPartner("mobile",initValue);
	}
	public PotentialCustomerForm mobileFieldOfCityPartner(){
		return mobileFieldOfCityPartner("mobile","");
	}


	public PotentialCustomerForm cityServiceCenterIdFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm cityServiceCenterIdFieldOfCityPartner(String initValue){
		return cityServiceCenterIdFieldOfCityPartner("cityServiceCenterId",initValue);
	}
	public PotentialCustomerForm cityServiceCenterIdFieldOfCityPartner(){
		return cityServiceCenterIdFieldOfCityPartner("cityServiceCenterId","");
	}


	public PotentialCustomerForm descriptionFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  descriptionFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm descriptionFieldOfCityPartner(String initValue){
		return descriptionFieldOfCityPartner("description",initValue);
	}
	public PotentialCustomerForm descriptionFieldOfCityPartner(){
		return descriptionFieldOfCityPartner("description","");
	}


	public PotentialCustomerForm lastUpdateTimeFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerForm lastUpdateTimeFieldOfCityPartner(String initValue){
		return lastUpdateTimeFieldOfCityPartner("lastUpdateTime",initValue);
	}
	public PotentialCustomerForm lastUpdateTimeFieldOfCityPartner(){
		return lastUpdateTimeFieldOfCityPartner("lastUpdateTime","");
	}

	



	public PotentialCustomerForm potentialCustomerContactPersonIdFieldForPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm potentialCustomerContactPersonIdFieldForPotentialCustomerContactPerson(String initValue){
		return potentialCustomerContactPersonIdFieldForPotentialCustomerContactPerson("potentialCustomerContactPersonId",initValue);
	}
	public PotentialCustomerForm potentialCustomerContactPersonIdFieldForPotentialCustomerContactPerson(){
		return potentialCustomerContactPersonIdFieldForPotentialCustomerContactPerson("potentialCustomerContactPersonId","");
	}


	public PotentialCustomerForm nameFieldForPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm nameFieldForPotentialCustomerContactPerson(String initValue){
		return nameFieldForPotentialCustomerContactPerson("name",initValue);
	}
	public PotentialCustomerForm nameFieldForPotentialCustomerContactPerson(){
		return nameFieldForPotentialCustomerContactPerson("name","");
	}


	public PotentialCustomerForm mobileFieldForPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm mobileFieldForPotentialCustomerContactPerson(String initValue){
		return mobileFieldForPotentialCustomerContactPerson("mobile",initValue);
	}
	public PotentialCustomerForm mobileFieldForPotentialCustomerContactPerson(){
		return mobileFieldForPotentialCustomerContactPerson("mobile","");
	}


	public PotentialCustomerForm potentialCustomerIdFieldForPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm potentialCustomerIdFieldForPotentialCustomerContactPerson(String initValue){
		return potentialCustomerIdFieldForPotentialCustomerContactPerson("potentialCustomerId",initValue);
	}
	public PotentialCustomerForm potentialCustomerIdFieldForPotentialCustomerContactPerson(){
		return potentialCustomerIdFieldForPotentialCustomerContactPerson("potentialCustomerId","");
	}


	public PotentialCustomerForm descriptionFieldForPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm descriptionFieldForPotentialCustomerContactPerson(String initValue){
		return descriptionFieldForPotentialCustomerContactPerson("description",initValue);
	}
	public PotentialCustomerForm descriptionFieldForPotentialCustomerContactPerson(){
		return descriptionFieldForPotentialCustomerContactPerson("description","");
	}


	public PotentialCustomerForm potentialCustomerContactIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm potentialCustomerContactIdFieldForPotentialCustomerContact(String initValue){
		return potentialCustomerContactIdFieldForPotentialCustomerContact("potentialCustomerContactId",initValue);
	}
	public PotentialCustomerForm potentialCustomerContactIdFieldForPotentialCustomerContact(){
		return potentialCustomerContactIdFieldForPotentialCustomerContact("potentialCustomerContactId","");
	}


	public PotentialCustomerForm nameFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm nameFieldForPotentialCustomerContact(String initValue){
		return nameFieldForPotentialCustomerContact("name",initValue);
	}
	public PotentialCustomerForm nameFieldForPotentialCustomerContact(){
		return nameFieldForPotentialCustomerContact("name","");
	}


	public PotentialCustomerForm contactDateFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactDateFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm contactDateFieldForPotentialCustomerContact(String initValue){
		return contactDateFieldForPotentialCustomerContact("contactDate",initValue);
	}
	public PotentialCustomerForm contactDateFieldForPotentialCustomerContact(){
		return contactDateFieldForPotentialCustomerContact("contactDate","");
	}


	public PotentialCustomerForm contactMethodFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactMethodFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm contactMethodFieldForPotentialCustomerContact(String initValue){
		return contactMethodFieldForPotentialCustomerContact("contactMethod",initValue);
	}
	public PotentialCustomerForm contactMethodFieldForPotentialCustomerContact(){
		return contactMethodFieldForPotentialCustomerContact("contactMethod","");
	}


	public PotentialCustomerForm potentialCustomerIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm potentialCustomerIdFieldForPotentialCustomerContact(String initValue){
		return potentialCustomerIdFieldForPotentialCustomerContact("potentialCustomerId",initValue);
	}
	public PotentialCustomerForm potentialCustomerIdFieldForPotentialCustomerContact(){
		return potentialCustomerIdFieldForPotentialCustomerContact("potentialCustomerId","");
	}


	public PotentialCustomerForm cityPartnerIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm cityPartnerIdFieldForPotentialCustomerContact(String initValue){
		return cityPartnerIdFieldForPotentialCustomerContact("cityPartnerId",initValue);
	}
	public PotentialCustomerForm cityPartnerIdFieldForPotentialCustomerContact(){
		return cityPartnerIdFieldForPotentialCustomerContact("cityPartnerId","");
	}


	public PotentialCustomerForm contactToIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactToIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm contactToIdFieldForPotentialCustomerContact(String initValue){
		return contactToIdFieldForPotentialCustomerContact("contactToId",initValue);
	}
	public PotentialCustomerForm contactToIdFieldForPotentialCustomerContact(){
		return contactToIdFieldForPotentialCustomerContact("contactToId","");
	}


	public PotentialCustomerForm descriptionFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm descriptionFieldForPotentialCustomerContact(String initValue){
		return descriptionFieldForPotentialCustomerContact("description",initValue);
	}
	public PotentialCustomerForm descriptionFieldForPotentialCustomerContact(){
		return descriptionFieldForPotentialCustomerContact("description","");
	}


	public PotentialCustomerForm lastUpdateTimeFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm lastUpdateTimeFieldForPotentialCustomerContact(String initValue){
		return lastUpdateTimeFieldForPotentialCustomerContact("lastUpdateTime",initValue);
	}
	public PotentialCustomerForm lastUpdateTimeFieldForPotentialCustomerContact(){
		return lastUpdateTimeFieldForPotentialCustomerContact("lastUpdateTime","");
	}


	public PotentialCustomerForm eventAttendanceIdFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  idFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm eventAttendanceIdFieldForEventAttendance(String initValue){
		return eventAttendanceIdFieldForEventAttendance("eventAttendanceId",initValue);
	}
	public PotentialCustomerForm eventAttendanceIdFieldForEventAttendance(){
		return eventAttendanceIdFieldForEventAttendance("eventAttendanceId","");
	}


	public PotentialCustomerForm nameFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  nameFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm nameFieldForEventAttendance(String initValue){
		return nameFieldForEventAttendance("name",initValue);
	}
	public PotentialCustomerForm nameFieldForEventAttendance(){
		return nameFieldForEventAttendance("name","");
	}


	public PotentialCustomerForm potentialCustomerIdFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm potentialCustomerIdFieldForEventAttendance(String initValue){
		return potentialCustomerIdFieldForEventAttendance("potentialCustomerId",initValue);
	}
	public PotentialCustomerForm potentialCustomerIdFieldForEventAttendance(){
		return potentialCustomerIdFieldForEventAttendance("potentialCustomerId","");
	}


	public PotentialCustomerForm cityEventIdFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  cityEventIdFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm cityEventIdFieldForEventAttendance(String initValue){
		return cityEventIdFieldForEventAttendance("cityEventId",initValue);
	}
	public PotentialCustomerForm cityEventIdFieldForEventAttendance(){
		return cityEventIdFieldForEventAttendance("cityEventId","");
	}


	public PotentialCustomerForm descriptionFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  descriptionFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerForm descriptionFieldForEventAttendance(String initValue){
		return descriptionFieldForEventAttendance("description",initValue);
	}
	public PotentialCustomerForm descriptionFieldForEventAttendance(){
		return descriptionFieldForEventAttendance("description","");
	}

	

	
 	public PotentialCustomerForm transferToAnotherCityServiceCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityServiceCenter/potentialCustomerId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public PotentialCustomerForm transferToAnotherCityPartnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityPartner/potentialCustomerId/");
		this.addFormAction(action);
		return this;
	}

 

	public PotentialCustomerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



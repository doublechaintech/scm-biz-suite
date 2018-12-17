package com.doublechaintech.retailscm.potentialcustomercontact;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class PotentialCustomerContactForm extends BaseForm {
	
	
	public PotentialCustomerContactForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PotentialCustomerContactForm potentialCustomerContactIdField(String parameterName, String initValue){
		FormField field = idFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm potentialCustomerContactIdField(String initValue){
		return potentialCustomerContactIdField("potentialCustomerContactId",initValue);
	}
	public PotentialCustomerContactForm potentialCustomerContactIdField(){
		return potentialCustomerContactIdField("potentialCustomerContactId","");
	}


	public PotentialCustomerContactForm nameField(String parameterName, String initValue){
		FormField field = nameFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PotentialCustomerContactForm nameField(){
		return nameField("name","");
	}


	public PotentialCustomerContactForm contactDateField(String parameterName, String initValue){
		FormField field = contactDateFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm contactDateField(String initValue){
		return contactDateField("contactDate",initValue);
	}
	public PotentialCustomerContactForm contactDateField(){
		return contactDateField("contactDate","");
	}


	public PotentialCustomerContactForm contactMethodField(String parameterName, String initValue){
		FormField field = contactMethodFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm contactMethodField(String initValue){
		return contactMethodField("contactMethod",initValue);
	}
	public PotentialCustomerContactForm contactMethodField(){
		return contactMethodField("contactMethod","");
	}


	public PotentialCustomerContactForm potentialCustomerIdField(String parameterName, String initValue){
		FormField field = potentialCustomerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm potentialCustomerIdField(String initValue){
		return potentialCustomerIdField("potentialCustomerId",initValue);
	}
	public PotentialCustomerContactForm potentialCustomerIdField(){
		return potentialCustomerIdField("potentialCustomerId","");
	}


	public PotentialCustomerContactForm cityPartnerIdField(String parameterName, String initValue){
		FormField field = cityPartnerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm cityPartnerIdField(String initValue){
		return cityPartnerIdField("cityPartnerId",initValue);
	}
	public PotentialCustomerContactForm cityPartnerIdField(){
		return cityPartnerIdField("cityPartnerId","");
	}


	public PotentialCustomerContactForm contactToIdField(String parameterName, String initValue){
		FormField field = contactToIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm contactToIdField(String initValue){
		return contactToIdField("contactToId",initValue);
	}
	public PotentialCustomerContactForm contactToIdField(){
		return contactToIdField("contactToId","");
	}


	public PotentialCustomerContactForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public PotentialCustomerContactForm descriptionField(){
		return descriptionField("description","");
	}


	public PotentialCustomerContactForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public PotentialCustomerContactForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public PotentialCustomerContactForm potentialCustomerIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm potentialCustomerIdFieldOfPotentialCustomer(String initValue){
		return potentialCustomerIdFieldOfPotentialCustomer("potentialCustomerId",initValue);
	}
	public PotentialCustomerContactForm potentialCustomerIdFieldOfPotentialCustomer(){
		return potentialCustomerIdFieldOfPotentialCustomer("potentialCustomerId","");
	}


	public PotentialCustomerContactForm nameFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm nameFieldOfPotentialCustomer(String initValue){
		return nameFieldOfPotentialCustomer("name",initValue);
	}
	public PotentialCustomerContactForm nameFieldOfPotentialCustomer(){
		return nameFieldOfPotentialCustomer("name","");
	}


	public PotentialCustomerContactForm mobileFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm mobileFieldOfPotentialCustomer(String initValue){
		return mobileFieldOfPotentialCustomer("mobile",initValue);
	}
	public PotentialCustomerContactForm mobileFieldOfPotentialCustomer(){
		return mobileFieldOfPotentialCustomer("mobile","");
	}


	public PotentialCustomerContactForm cityServiceCenterIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm cityServiceCenterIdFieldOfPotentialCustomer(String initValue){
		return cityServiceCenterIdFieldOfPotentialCustomer("cityServiceCenterId",initValue);
	}
	public PotentialCustomerContactForm cityServiceCenterIdFieldOfPotentialCustomer(){
		return cityServiceCenterIdFieldOfPotentialCustomer("cityServiceCenterId","");
	}


	public PotentialCustomerContactForm cityPartnerIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm cityPartnerIdFieldOfPotentialCustomer(String initValue){
		return cityPartnerIdFieldOfPotentialCustomer("cityPartnerId",initValue);
	}
	public PotentialCustomerContactForm cityPartnerIdFieldOfPotentialCustomer(){
		return cityPartnerIdFieldOfPotentialCustomer("cityPartnerId","");
	}


	public PotentialCustomerContactForm descriptionFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm descriptionFieldOfPotentialCustomer(String initValue){
		return descriptionFieldOfPotentialCustomer("description",initValue);
	}
	public PotentialCustomerContactForm descriptionFieldOfPotentialCustomer(){
		return descriptionFieldOfPotentialCustomer("description","");
	}


	public PotentialCustomerContactForm lastUpdateTimeFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm lastUpdateTimeFieldOfPotentialCustomer(String initValue){
		return lastUpdateTimeFieldOfPotentialCustomer("lastUpdateTime",initValue);
	}
	public PotentialCustomerContactForm lastUpdateTimeFieldOfPotentialCustomer(){
		return lastUpdateTimeFieldOfPotentialCustomer("lastUpdateTime","");
	}


	public PotentialCustomerContactForm cityPartnerIdFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  idFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm cityPartnerIdFieldOfCityPartner(String initValue){
		return cityPartnerIdFieldOfCityPartner("cityPartnerId",initValue);
	}
	public PotentialCustomerContactForm cityPartnerIdFieldOfCityPartner(){
		return cityPartnerIdFieldOfCityPartner("cityPartnerId","");
	}


	public PotentialCustomerContactForm nameFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  nameFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm nameFieldOfCityPartner(String initValue){
		return nameFieldOfCityPartner("name",initValue);
	}
	public PotentialCustomerContactForm nameFieldOfCityPartner(){
		return nameFieldOfCityPartner("name","");
	}


	public PotentialCustomerContactForm mobileFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  mobileFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm mobileFieldOfCityPartner(String initValue){
		return mobileFieldOfCityPartner("mobile",initValue);
	}
	public PotentialCustomerContactForm mobileFieldOfCityPartner(){
		return mobileFieldOfCityPartner("mobile","");
	}


	public PotentialCustomerContactForm cityServiceCenterIdFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm cityServiceCenterIdFieldOfCityPartner(String initValue){
		return cityServiceCenterIdFieldOfCityPartner("cityServiceCenterId",initValue);
	}
	public PotentialCustomerContactForm cityServiceCenterIdFieldOfCityPartner(){
		return cityServiceCenterIdFieldOfCityPartner("cityServiceCenterId","");
	}


	public PotentialCustomerContactForm descriptionFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  descriptionFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm descriptionFieldOfCityPartner(String initValue){
		return descriptionFieldOfCityPartner("description",initValue);
	}
	public PotentialCustomerContactForm descriptionFieldOfCityPartner(){
		return descriptionFieldOfCityPartner("description","");
	}


	public PotentialCustomerContactForm lastUpdateTimeFieldOfCityPartner(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCityPartner(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm lastUpdateTimeFieldOfCityPartner(String initValue){
		return lastUpdateTimeFieldOfCityPartner("lastUpdateTime",initValue);
	}
	public PotentialCustomerContactForm lastUpdateTimeFieldOfCityPartner(){
		return lastUpdateTimeFieldOfCityPartner("lastUpdateTime","");
	}


	public PotentialCustomerContactForm potentialCustomerContactPersonIdFieldOfPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomerContactPerson(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm potentialCustomerContactPersonIdFieldOfPotentialCustomerContactPerson(String initValue){
		return potentialCustomerContactPersonIdFieldOfPotentialCustomerContactPerson("potentialCustomerContactPersonId",initValue);
	}
	public PotentialCustomerContactForm potentialCustomerContactPersonIdFieldOfPotentialCustomerContactPerson(){
		return potentialCustomerContactPersonIdFieldOfPotentialCustomerContactPerson("potentialCustomerContactPersonId","");
	}


	public PotentialCustomerContactForm nameFieldOfPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomerContactPerson(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm nameFieldOfPotentialCustomerContactPerson(String initValue){
		return nameFieldOfPotentialCustomerContactPerson("name",initValue);
	}
	public PotentialCustomerContactForm nameFieldOfPotentialCustomerContactPerson(){
		return nameFieldOfPotentialCustomerContactPerson("name","");
	}


	public PotentialCustomerContactForm mobileFieldOfPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomerContactPerson(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm mobileFieldOfPotentialCustomerContactPerson(String initValue){
		return mobileFieldOfPotentialCustomerContactPerson("mobile",initValue);
	}
	public PotentialCustomerContactForm mobileFieldOfPotentialCustomerContactPerson(){
		return mobileFieldOfPotentialCustomerContactPerson("mobile","");
	}


	public PotentialCustomerContactForm potentialCustomerIdFieldOfPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromPotentialCustomerContactPerson(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm potentialCustomerIdFieldOfPotentialCustomerContactPerson(String initValue){
		return potentialCustomerIdFieldOfPotentialCustomerContactPerson("potentialCustomerId",initValue);
	}
	public PotentialCustomerContactForm potentialCustomerIdFieldOfPotentialCustomerContactPerson(){
		return potentialCustomerIdFieldOfPotentialCustomerContactPerson("potentialCustomerId","");
	}


	public PotentialCustomerContactForm descriptionFieldOfPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomerContactPerson(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactForm descriptionFieldOfPotentialCustomerContactPerson(String initValue){
		return descriptionFieldOfPotentialCustomerContactPerson("description",initValue);
	}
	public PotentialCustomerContactForm descriptionFieldOfPotentialCustomerContactPerson(){
		return descriptionFieldOfPotentialCustomerContactPerson("description","");
	}

	


	

	
 	public PotentialCustomerContactForm transferToAnotherPotentialCustomerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPotentialCustomer/potentialCustomerContactId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public PotentialCustomerContactForm transferToAnotherCityPartnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityPartner/potentialCustomerContactId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public PotentialCustomerContactForm transferToAnotherContactToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherContactTo/potentialCustomerContactId/");
		this.addFormAction(action);
		return this;
	}

 

	public PotentialCustomerContactForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



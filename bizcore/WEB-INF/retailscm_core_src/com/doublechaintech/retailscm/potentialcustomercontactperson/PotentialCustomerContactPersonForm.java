package com.doublechaintech.retailscm.potentialcustomercontactperson;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class PotentialCustomerContactPersonForm extends BaseForm {
	
	
	public PotentialCustomerContactPersonForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PotentialCustomerContactPersonForm potentialCustomerContactPersonIdField(String parameterName, String initValue){
		FormField field = idFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm potentialCustomerContactPersonIdField(String initValue){
		return potentialCustomerContactPersonIdField("potentialCustomerContactPersonId",initValue);
	}
	public PotentialCustomerContactPersonForm potentialCustomerContactPersonIdField(){
		return potentialCustomerContactPersonIdField("potentialCustomerContactPersonId","");
	}


	public PotentialCustomerContactPersonForm nameField(String parameterName, String initValue){
		FormField field = nameFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PotentialCustomerContactPersonForm nameField(){
		return nameField("name","");
	}


	public PotentialCustomerContactPersonForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public PotentialCustomerContactPersonForm mobileField(){
		return mobileField("mobile","");
	}


	public PotentialCustomerContactPersonForm potentialCustomerIdField(String parameterName, String initValue){
		FormField field = potentialCustomerIdFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm potentialCustomerIdField(String initValue){
		return potentialCustomerIdField("potentialCustomerId",initValue);
	}
	public PotentialCustomerContactPersonForm potentialCustomerIdField(){
		return potentialCustomerIdField("potentialCustomerId","");
	}


	public PotentialCustomerContactPersonForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromPotentialCustomerContactPerson(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public PotentialCustomerContactPersonForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public PotentialCustomerContactPersonForm potentialCustomerIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm potentialCustomerIdFieldOfPotentialCustomer(String initValue){
		return potentialCustomerIdFieldOfPotentialCustomer("potentialCustomerId",initValue);
	}
	public PotentialCustomerContactPersonForm potentialCustomerIdFieldOfPotentialCustomer(){
		return potentialCustomerIdFieldOfPotentialCustomer("potentialCustomerId","");
	}


	public PotentialCustomerContactPersonForm nameFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm nameFieldOfPotentialCustomer(String initValue){
		return nameFieldOfPotentialCustomer("name",initValue);
	}
	public PotentialCustomerContactPersonForm nameFieldOfPotentialCustomer(){
		return nameFieldOfPotentialCustomer("name","");
	}


	public PotentialCustomerContactPersonForm mobileFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm mobileFieldOfPotentialCustomer(String initValue){
		return mobileFieldOfPotentialCustomer("mobile",initValue);
	}
	public PotentialCustomerContactPersonForm mobileFieldOfPotentialCustomer(){
		return mobileFieldOfPotentialCustomer("mobile","");
	}


	public PotentialCustomerContactPersonForm cityServiceCenterIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm cityServiceCenterIdFieldOfPotentialCustomer(String initValue){
		return cityServiceCenterIdFieldOfPotentialCustomer("cityServiceCenterId",initValue);
	}
	public PotentialCustomerContactPersonForm cityServiceCenterIdFieldOfPotentialCustomer(){
		return cityServiceCenterIdFieldOfPotentialCustomer("cityServiceCenterId","");
	}


	public PotentialCustomerContactPersonForm cityPartnerIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm cityPartnerIdFieldOfPotentialCustomer(String initValue){
		return cityPartnerIdFieldOfPotentialCustomer("cityPartnerId",initValue);
	}
	public PotentialCustomerContactPersonForm cityPartnerIdFieldOfPotentialCustomer(){
		return cityPartnerIdFieldOfPotentialCustomer("cityPartnerId","");
	}


	public PotentialCustomerContactPersonForm descriptionFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm descriptionFieldOfPotentialCustomer(String initValue){
		return descriptionFieldOfPotentialCustomer("description",initValue);
	}
	public PotentialCustomerContactPersonForm descriptionFieldOfPotentialCustomer(){
		return descriptionFieldOfPotentialCustomer("description","");
	}


	public PotentialCustomerContactPersonForm lastUpdateTimeFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PotentialCustomerContactPersonForm lastUpdateTimeFieldOfPotentialCustomer(String initValue){
		return lastUpdateTimeFieldOfPotentialCustomer("lastUpdateTime",initValue);
	}
	public PotentialCustomerContactPersonForm lastUpdateTimeFieldOfPotentialCustomer(){
		return lastUpdateTimeFieldOfPotentialCustomer("lastUpdateTime","");
	}

	



	public PotentialCustomerContactPersonForm potentialCustomerContactIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm potentialCustomerContactIdFieldForPotentialCustomerContact(String initValue){
		return potentialCustomerContactIdFieldForPotentialCustomerContact("potentialCustomerContactId",initValue);
	}
	public PotentialCustomerContactPersonForm potentialCustomerContactIdFieldForPotentialCustomerContact(){
		return potentialCustomerContactIdFieldForPotentialCustomerContact("potentialCustomerContactId","");
	}


	public PotentialCustomerContactPersonForm nameFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm nameFieldForPotentialCustomerContact(String initValue){
		return nameFieldForPotentialCustomerContact("name",initValue);
	}
	public PotentialCustomerContactPersonForm nameFieldForPotentialCustomerContact(){
		return nameFieldForPotentialCustomerContact("name","");
	}


	public PotentialCustomerContactPersonForm contactDateFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactDateFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm contactDateFieldForPotentialCustomerContact(String initValue){
		return contactDateFieldForPotentialCustomerContact("contactDate",initValue);
	}
	public PotentialCustomerContactPersonForm contactDateFieldForPotentialCustomerContact(){
		return contactDateFieldForPotentialCustomerContact("contactDate","");
	}


	public PotentialCustomerContactPersonForm contactMethodFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactMethodFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm contactMethodFieldForPotentialCustomerContact(String initValue){
		return contactMethodFieldForPotentialCustomerContact("contactMethod",initValue);
	}
	public PotentialCustomerContactPersonForm contactMethodFieldForPotentialCustomerContact(){
		return contactMethodFieldForPotentialCustomerContact("contactMethod","");
	}


	public PotentialCustomerContactPersonForm potentialCustomerIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm potentialCustomerIdFieldForPotentialCustomerContact(String initValue){
		return potentialCustomerIdFieldForPotentialCustomerContact("potentialCustomerId",initValue);
	}
	public PotentialCustomerContactPersonForm potentialCustomerIdFieldForPotentialCustomerContact(){
		return potentialCustomerIdFieldForPotentialCustomerContact("potentialCustomerId","");
	}


	public PotentialCustomerContactPersonForm cityPartnerIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm cityPartnerIdFieldForPotentialCustomerContact(String initValue){
		return cityPartnerIdFieldForPotentialCustomerContact("cityPartnerId",initValue);
	}
	public PotentialCustomerContactPersonForm cityPartnerIdFieldForPotentialCustomerContact(){
		return cityPartnerIdFieldForPotentialCustomerContact("cityPartnerId","");
	}


	public PotentialCustomerContactPersonForm contactToIdFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  contactToIdFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm contactToIdFieldForPotentialCustomerContact(String initValue){
		return contactToIdFieldForPotentialCustomerContact("contactToId",initValue);
	}
	public PotentialCustomerContactPersonForm contactToIdFieldForPotentialCustomerContact(){
		return contactToIdFieldForPotentialCustomerContact("contactToId","");
	}


	public PotentialCustomerContactPersonForm descriptionFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm descriptionFieldForPotentialCustomerContact(String initValue){
		return descriptionFieldForPotentialCustomerContact("description",initValue);
	}
	public PotentialCustomerContactPersonForm descriptionFieldForPotentialCustomerContact(){
		return descriptionFieldForPotentialCustomerContact("description","");
	}


	public PotentialCustomerContactPersonForm lastUpdateTimeFieldForPotentialCustomerContact(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomerContact(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PotentialCustomerContactPersonForm lastUpdateTimeFieldForPotentialCustomerContact(String initValue){
		return lastUpdateTimeFieldForPotentialCustomerContact("lastUpdateTime",initValue);
	}
	public PotentialCustomerContactPersonForm lastUpdateTimeFieldForPotentialCustomerContact(){
		return lastUpdateTimeFieldForPotentialCustomerContact("lastUpdateTime","");
	}

	

	
 	public PotentialCustomerContactPersonForm transferToAnotherPotentialCustomerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPotentialCustomer/potentialCustomerContactPersonId/");
		this.addFormAction(action);
		return this;
	}

 

	public PotentialCustomerContactPersonForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



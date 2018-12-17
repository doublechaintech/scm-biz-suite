package com.doublechaintech.retailscm.eventattendance;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EventAttendanceForm extends BaseForm {
	
	
	public EventAttendanceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EventAttendanceForm eventAttendanceIdField(String parameterName, String initValue){
		FormField field = idFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EventAttendanceForm eventAttendanceIdField(String initValue){
		return eventAttendanceIdField("eventAttendanceId",initValue);
	}
	public EventAttendanceForm eventAttendanceIdField(){
		return eventAttendanceIdField("eventAttendanceId","");
	}


	public EventAttendanceForm nameField(String parameterName, String initValue){
		FormField field = nameFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EventAttendanceForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public EventAttendanceForm nameField(){
		return nameField("name","");
	}


	public EventAttendanceForm potentialCustomerIdField(String parameterName, String initValue){
		FormField field = potentialCustomerIdFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EventAttendanceForm potentialCustomerIdField(String initValue){
		return potentialCustomerIdField("potentialCustomerId",initValue);
	}
	public EventAttendanceForm potentialCustomerIdField(){
		return potentialCustomerIdField("potentialCustomerId","");
	}


	public EventAttendanceForm cityEventIdField(String parameterName, String initValue){
		FormField field = cityEventIdFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EventAttendanceForm cityEventIdField(String initValue){
		return cityEventIdField("cityEventId",initValue);
	}
	public EventAttendanceForm cityEventIdField(){
		return cityEventIdField("cityEventId","");
	}


	public EventAttendanceForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EventAttendanceForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public EventAttendanceForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public EventAttendanceForm potentialCustomerIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  idFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm potentialCustomerIdFieldOfPotentialCustomer(String initValue){
		return potentialCustomerIdFieldOfPotentialCustomer("potentialCustomerId",initValue);
	}
	public EventAttendanceForm potentialCustomerIdFieldOfPotentialCustomer(){
		return potentialCustomerIdFieldOfPotentialCustomer("potentialCustomerId","");
	}


	public EventAttendanceForm nameFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  nameFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm nameFieldOfPotentialCustomer(String initValue){
		return nameFieldOfPotentialCustomer("name",initValue);
	}
	public EventAttendanceForm nameFieldOfPotentialCustomer(){
		return nameFieldOfPotentialCustomer("name","");
	}


	public EventAttendanceForm mobileFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  mobileFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm mobileFieldOfPotentialCustomer(String initValue){
		return mobileFieldOfPotentialCustomer("mobile",initValue);
	}
	public EventAttendanceForm mobileFieldOfPotentialCustomer(){
		return mobileFieldOfPotentialCustomer("mobile","");
	}


	public EventAttendanceForm cityServiceCenterIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm cityServiceCenterIdFieldOfPotentialCustomer(String initValue){
		return cityServiceCenterIdFieldOfPotentialCustomer("cityServiceCenterId",initValue);
	}
	public EventAttendanceForm cityServiceCenterIdFieldOfPotentialCustomer(){
		return cityServiceCenterIdFieldOfPotentialCustomer("cityServiceCenterId","");
	}


	public EventAttendanceForm cityPartnerIdFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  cityPartnerIdFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm cityPartnerIdFieldOfPotentialCustomer(String initValue){
		return cityPartnerIdFieldOfPotentialCustomer("cityPartnerId",initValue);
	}
	public EventAttendanceForm cityPartnerIdFieldOfPotentialCustomer(){
		return cityPartnerIdFieldOfPotentialCustomer("cityPartnerId","");
	}


	public EventAttendanceForm descriptionFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  descriptionFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm descriptionFieldOfPotentialCustomer(String initValue){
		return descriptionFieldOfPotentialCustomer("description",initValue);
	}
	public EventAttendanceForm descriptionFieldOfPotentialCustomer(){
		return descriptionFieldOfPotentialCustomer("description","");
	}


	public EventAttendanceForm lastUpdateTimeFieldOfPotentialCustomer(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromPotentialCustomer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm lastUpdateTimeFieldOfPotentialCustomer(String initValue){
		return lastUpdateTimeFieldOfPotentialCustomer("lastUpdateTime",initValue);
	}
	public EventAttendanceForm lastUpdateTimeFieldOfPotentialCustomer(){
		return lastUpdateTimeFieldOfPotentialCustomer("lastUpdateTime","");
	}


	public EventAttendanceForm cityEventIdFieldOfCityEvent(String parameterName, String initValue){
		FormField field =  idFromCityEvent(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm cityEventIdFieldOfCityEvent(String initValue){
		return cityEventIdFieldOfCityEvent("cityEventId",initValue);
	}
	public EventAttendanceForm cityEventIdFieldOfCityEvent(){
		return cityEventIdFieldOfCityEvent("cityEventId","");
	}


	public EventAttendanceForm nameFieldOfCityEvent(String parameterName, String initValue){
		FormField field =  nameFromCityEvent(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm nameFieldOfCityEvent(String initValue){
		return nameFieldOfCityEvent("name",initValue);
	}
	public EventAttendanceForm nameFieldOfCityEvent(){
		return nameFieldOfCityEvent("name","");
	}


	public EventAttendanceForm mobileFieldOfCityEvent(String parameterName, String initValue){
		FormField field =  mobileFromCityEvent(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm mobileFieldOfCityEvent(String initValue){
		return mobileFieldOfCityEvent("mobile",initValue);
	}
	public EventAttendanceForm mobileFieldOfCityEvent(){
		return mobileFieldOfCityEvent("mobile","");
	}


	public EventAttendanceForm cityServiceCenterIdFieldOfCityEvent(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromCityEvent(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm cityServiceCenterIdFieldOfCityEvent(String initValue){
		return cityServiceCenterIdFieldOfCityEvent("cityServiceCenterId",initValue);
	}
	public EventAttendanceForm cityServiceCenterIdFieldOfCityEvent(){
		return cityServiceCenterIdFieldOfCityEvent("cityServiceCenterId","");
	}


	public EventAttendanceForm descriptionFieldOfCityEvent(String parameterName, String initValue){
		FormField field =  descriptionFromCityEvent(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm descriptionFieldOfCityEvent(String initValue){
		return descriptionFieldOfCityEvent("description",initValue);
	}
	public EventAttendanceForm descriptionFieldOfCityEvent(){
		return descriptionFieldOfCityEvent("description","");
	}


	public EventAttendanceForm lastUpdateTimeFieldOfCityEvent(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCityEvent(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EventAttendanceForm lastUpdateTimeFieldOfCityEvent(String initValue){
		return lastUpdateTimeFieldOfCityEvent("lastUpdateTime",initValue);
	}
	public EventAttendanceForm lastUpdateTimeFieldOfCityEvent(){
		return lastUpdateTimeFieldOfCityEvent("lastUpdateTime","");
	}

	


	

	
 	public EventAttendanceForm transferToAnotherPotentialCustomerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPotentialCustomer/eventAttendanceId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EventAttendanceForm transferToAnotherCityEventAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityEvent/eventAttendanceId/");
		this.addFormAction(action);
		return this;
	}

 

	public EventAttendanceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



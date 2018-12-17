package com.doublechaintech.retailscm.cityevent;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class CityEventForm extends BaseForm {
	
	
	public CityEventForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CityEventForm cityEventIdField(String parameterName, String initValue){
		FormField field = idFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm cityEventIdField(String initValue){
		return cityEventIdField("cityEventId",initValue);
	}
	public CityEventForm cityEventIdField(){
		return cityEventIdField("cityEventId","");
	}


	public CityEventForm nameField(String parameterName, String initValue){
		FormField field = nameFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CityEventForm nameField(){
		return nameField("name","");
	}


	public CityEventForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public CityEventForm mobileField(){
		return mobileField("mobile","");
	}


	public CityEventForm cityServiceCenterIdField(String parameterName, String initValue){
		FormField field = cityServiceCenterIdFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm cityServiceCenterIdField(String initValue){
		return cityServiceCenterIdField("cityServiceCenterId",initValue);
	}
	public CityEventForm cityServiceCenterIdField(){
		return cityServiceCenterIdField("cityServiceCenterId","");
	}


	public CityEventForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public CityEventForm descriptionField(){
		return descriptionField("description","");
	}


	public CityEventForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromCityEvent(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public CityEventForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public CityEventForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityEventForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId",initValue);
	}
	public CityEventForm retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter(){
		return retailStoreCityServiceCenterIdFieldOfRetailStoreCityServiceCenter("retailStoreCityServiceCenterId","");
	}


	public CityEventForm nameFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityEventForm nameFieldOfRetailStoreCityServiceCenter(String initValue){
		return nameFieldOfRetailStoreCityServiceCenter("name",initValue);
	}
	public CityEventForm nameFieldOfRetailStoreCityServiceCenter(){
		return nameFieldOfRetailStoreCityServiceCenter("name","");
	}


	public CityEventForm foundedFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityEventForm foundedFieldOfRetailStoreCityServiceCenter(String initValue){
		return foundedFieldOfRetailStoreCityServiceCenter("founded",initValue);
	}
	public CityEventForm foundedFieldOfRetailStoreCityServiceCenter(){
		return foundedFieldOfRetailStoreCityServiceCenter("founded","");
	}


	public CityEventForm belongsToIdFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  belongsToIdFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityEventForm belongsToIdFieldOfRetailStoreCityServiceCenter(String initValue){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId",initValue);
	}
	public CityEventForm belongsToIdFieldOfRetailStoreCityServiceCenter(){
		return belongsToIdFieldOfRetailStoreCityServiceCenter("belongsToId","");
	}


	public CityEventForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreCityServiceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CityEventForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime",initValue);
	}
	public CityEventForm lastUpdateTimeFieldOfRetailStoreCityServiceCenter(){
		return lastUpdateTimeFieldOfRetailStoreCityServiceCenter("lastUpdateTime","");
	}

	



	public CityEventForm eventAttendanceIdFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  idFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm eventAttendanceIdFieldForEventAttendance(String initValue){
		return eventAttendanceIdFieldForEventAttendance("eventAttendanceId",initValue);
	}
	public CityEventForm eventAttendanceIdFieldForEventAttendance(){
		return eventAttendanceIdFieldForEventAttendance("eventAttendanceId","");
	}


	public CityEventForm nameFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  nameFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm nameFieldForEventAttendance(String initValue){
		return nameFieldForEventAttendance("name",initValue);
	}
	public CityEventForm nameFieldForEventAttendance(){
		return nameFieldForEventAttendance("name","");
	}


	public CityEventForm potentialCustomerIdFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  potentialCustomerIdFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm potentialCustomerIdFieldForEventAttendance(String initValue){
		return potentialCustomerIdFieldForEventAttendance("potentialCustomerId",initValue);
	}
	public CityEventForm potentialCustomerIdFieldForEventAttendance(){
		return potentialCustomerIdFieldForEventAttendance("potentialCustomerId","");
	}


	public CityEventForm cityEventIdFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  cityEventIdFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm cityEventIdFieldForEventAttendance(String initValue){
		return cityEventIdFieldForEventAttendance("cityEventId",initValue);
	}
	public CityEventForm cityEventIdFieldForEventAttendance(){
		return cityEventIdFieldForEventAttendance("cityEventId","");
	}


	public CityEventForm descriptionFieldForEventAttendance(String parameterName, String initValue){
		FormField field =  descriptionFromEventAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CityEventForm descriptionFieldForEventAttendance(String initValue){
		return descriptionFieldForEventAttendance("description",initValue);
	}
	public CityEventForm descriptionFieldForEventAttendance(){
		return descriptionFieldForEventAttendance("description","");
	}

	

	
 	public CityEventForm transferToAnotherCityServiceCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCityServiceCenter/cityEventId/");
		this.addFormAction(action);
		return this;
	}

 

	public CityEventForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



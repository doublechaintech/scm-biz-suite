package com.doublechaintech.retailscm.truckdriver;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TruckDriverForm extends BaseForm {
	
	
	public TruckDriverForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TruckDriverForm truckDriverIdField(String parameterName, String initValue){
		FormField field = idFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm truckDriverIdField(String initValue){
		return truckDriverIdField("truckDriverId",initValue);
	}
	public TruckDriverForm truckDriverIdField(){
		return truckDriverIdField("truckDriverId","");
	}


	public TruckDriverForm nameField(String parameterName, String initValue){
		FormField field = nameFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TruckDriverForm nameField(){
		return nameField("name","");
	}


	public TruckDriverForm driverLicenseNumberField(String parameterName, String initValue){
		FormField field = driverLicenseNumberFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm driverLicenseNumberField(String initValue){
		return driverLicenseNumberField("driverLicenseNumber",initValue);
	}
	public TruckDriverForm driverLicenseNumberField(){
		return driverLicenseNumberField("driverLicenseNumber","");
	}


	public TruckDriverForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public TruckDriverForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public TruckDriverForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public TruckDriverForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}

	
	


	public TruckDriverForm transportFleetIdFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  idFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TruckDriverForm transportFleetIdFieldOfTransportFleet(String initValue){
		return transportFleetIdFieldOfTransportFleet("transportFleetId",initValue);
	}
	public TruckDriverForm transportFleetIdFieldOfTransportFleet(){
		return transportFleetIdFieldOfTransportFleet("transportFleetId","");
	}


	public TruckDriverForm nameFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  nameFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TruckDriverForm nameFieldOfTransportFleet(String initValue){
		return nameFieldOfTransportFleet("name",initValue);
	}
	public TruckDriverForm nameFieldOfTransportFleet(){
		return nameFieldOfTransportFleet("name","");
	}


	public TruckDriverForm contactNumberFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  contactNumberFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TruckDriverForm contactNumberFieldOfTransportFleet(String initValue){
		return contactNumberFieldOfTransportFleet("contactNumber",initValue);
	}
	public TruckDriverForm contactNumberFieldOfTransportFleet(){
		return contactNumberFieldOfTransportFleet("contactNumber","");
	}


	public TruckDriverForm ownerIdFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  ownerIdFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TruckDriverForm ownerIdFieldOfTransportFleet(String initValue){
		return ownerIdFieldOfTransportFleet("ownerId",initValue);
	}
	public TruckDriverForm ownerIdFieldOfTransportFleet(){
		return ownerIdFieldOfTransportFleet("ownerId","");
	}


	public TruckDriverForm lastUpdateTimeFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TruckDriverForm lastUpdateTimeFieldOfTransportFleet(String initValue){
		return lastUpdateTimeFieldOfTransportFleet("lastUpdateTime",initValue);
	}
	public TruckDriverForm lastUpdateTimeFieldOfTransportFleet(){
		return lastUpdateTimeFieldOfTransportFleet("lastUpdateTime","");
	}

	



	public TruckDriverForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public TruckDriverForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public TruckDriverForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public TruckDriverForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public TruckDriverForm startFieldForTransportTask(String parameterName, String initValue){
		FormField field =  startFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm startFieldForTransportTask(String initValue){
		return startFieldForTransportTask("start",initValue);
	}
	public TruckDriverForm startFieldForTransportTask(){
		return startFieldForTransportTask("start","");
	}


	public TruckDriverForm beginTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  beginTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm beginTimeFieldForTransportTask(String initValue){
		return beginTimeFieldForTransportTask("beginTime",initValue);
	}
	public TruckDriverForm beginTimeFieldForTransportTask(){
		return beginTimeFieldForTransportTask("beginTime","");
	}


	public TruckDriverForm endIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  endIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm endIdFieldForTransportTask(String initValue){
		return endIdFieldForTransportTask("endId",initValue);
	}
	public TruckDriverForm endIdFieldForTransportTask(){
		return endIdFieldForTransportTask("endId","");
	}


	public TruckDriverForm driverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  driverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm driverIdFieldForTransportTask(String initValue){
		return driverIdFieldForTransportTask("driverId",initValue);
	}
	public TruckDriverForm driverIdFieldForTransportTask(){
		return driverIdFieldForTransportTask("driverId","");
	}


	public TruckDriverForm truckIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  truckIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm truckIdFieldForTransportTask(String initValue){
		return truckIdFieldForTransportTask("truckId",initValue);
	}
	public TruckDriverForm truckIdFieldForTransportTask(){
		return truckIdFieldForTransportTask("truckId","");
	}


	public TruckDriverForm belongsToIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  belongsToIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm belongsToIdFieldForTransportTask(String initValue){
		return belongsToIdFieldForTransportTask("belongsToId",initValue);
	}
	public TruckDriverForm belongsToIdFieldForTransportTask(){
		return belongsToIdFieldForTransportTask("belongsToId","");
	}


	public TruckDriverForm latitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm latitudeFieldForTransportTask(String initValue){
		return latitudeFieldForTransportTask("latitude",initValue);
	}
	public TruckDriverForm latitudeFieldForTransportTask(){
		return latitudeFieldForTransportTask("latitude","");
	}


	public TruckDriverForm longitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TruckDriverForm longitudeFieldForTransportTask(String initValue){
		return longitudeFieldForTransportTask("longitude",initValue);
	}
	public TruckDriverForm longitudeFieldForTransportTask(){
		return longitudeFieldForTransportTask("longitude","");
	}

	

	
 	public TruckDriverForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/truckDriverId/");
		this.addFormAction(action);
		return this;
	}

 

	public TruckDriverForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



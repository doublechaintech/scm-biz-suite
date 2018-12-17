package com.doublechaintech.retailscm.transporttruck;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TransportTruckForm extends BaseForm {
	
	
	public TransportTruckForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportTruckForm transportTruckIdField(String parameterName, String initValue){
		FormField field = idFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm transportTruckIdField(String initValue){
		return transportTruckIdField("transportTruckId",initValue);
	}
	public TransportTruckForm transportTruckIdField(){
		return transportTruckIdField("transportTruckId","");
	}


	public TransportTruckForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportTruckForm nameField(){
		return nameField("name","");
	}


	public TransportTruckForm plateNumberField(String parameterName, String initValue){
		FormField field = plateNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm plateNumberField(String initValue){
		return plateNumberField("plateNumber",initValue);
	}
	public TransportTruckForm plateNumberField(){
		return plateNumberField("plateNumber","");
	}


	public TransportTruckForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public TransportTruckForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public TransportTruckForm vehicleLicenseNumberField(String parameterName, String initValue){
		FormField field = vehicleLicenseNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm vehicleLicenseNumberField(String initValue){
		return vehicleLicenseNumberField("vehicleLicenseNumber",initValue);
	}
	public TransportTruckForm vehicleLicenseNumberField(){
		return vehicleLicenseNumberField("vehicleLicenseNumber","");
	}


	public TransportTruckForm engineNumberField(String parameterName, String initValue){
		FormField field = engineNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm engineNumberField(String initValue){
		return engineNumberField("engineNumber",initValue);
	}
	public TransportTruckForm engineNumberField(){
		return engineNumberField("engineNumber","");
	}


	public TransportTruckForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public TransportTruckForm makeDateField(){
		return makeDateField("makeDate","");
	}


	public TransportTruckForm mileageField(String parameterName, String initValue){
		FormField field = mileageFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm mileageField(String initValue){
		return mileageField("mileage",initValue);
	}
	public TransportTruckForm mileageField(){
		return mileageField("mileage","");
	}


	public TransportTruckForm bodyColorField(String parameterName, String initValue){
		FormField field = bodyColorFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm bodyColorField(String initValue){
		return bodyColorField("bodyColor",initValue);
	}
	public TransportTruckForm bodyColorField(){
		return bodyColorField("bodyColor","");
	}


	public TransportTruckForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public TransportTruckForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public TransportTruckForm transportFleetIdFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  idFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTruckForm transportFleetIdFieldOfTransportFleet(String initValue){
		return transportFleetIdFieldOfTransportFleet("transportFleetId",initValue);
	}
	public TransportTruckForm transportFleetIdFieldOfTransportFleet(){
		return transportFleetIdFieldOfTransportFleet("transportFleetId","");
	}


	public TransportTruckForm nameFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  nameFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTruckForm nameFieldOfTransportFleet(String initValue){
		return nameFieldOfTransportFleet("name",initValue);
	}
	public TransportTruckForm nameFieldOfTransportFleet(){
		return nameFieldOfTransportFleet("name","");
	}


	public TransportTruckForm contactNumberFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  contactNumberFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTruckForm contactNumberFieldOfTransportFleet(String initValue){
		return contactNumberFieldOfTransportFleet("contactNumber",initValue);
	}
	public TransportTruckForm contactNumberFieldOfTransportFleet(){
		return contactNumberFieldOfTransportFleet("contactNumber","");
	}


	public TransportTruckForm ownerIdFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  ownerIdFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTruckForm ownerIdFieldOfTransportFleet(String initValue){
		return ownerIdFieldOfTransportFleet("ownerId",initValue);
	}
	public TransportTruckForm ownerIdFieldOfTransportFleet(){
		return ownerIdFieldOfTransportFleet("ownerId","");
	}


	public TransportTruckForm lastUpdateTimeFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTruckForm lastUpdateTimeFieldOfTransportFleet(String initValue){
		return lastUpdateTimeFieldOfTransportFleet("lastUpdateTime",initValue);
	}
	public TransportTruckForm lastUpdateTimeFieldOfTransportFleet(){
		return lastUpdateTimeFieldOfTransportFleet("lastUpdateTime","");
	}

	



	public TransportTruckForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public TransportTruckForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public TransportTruckForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public TransportTruckForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public TransportTruckForm startFieldForTransportTask(String parameterName, String initValue){
		FormField field =  startFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm startFieldForTransportTask(String initValue){
		return startFieldForTransportTask("start",initValue);
	}
	public TransportTruckForm startFieldForTransportTask(){
		return startFieldForTransportTask("start","");
	}


	public TransportTruckForm beginTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  beginTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm beginTimeFieldForTransportTask(String initValue){
		return beginTimeFieldForTransportTask("beginTime",initValue);
	}
	public TransportTruckForm beginTimeFieldForTransportTask(){
		return beginTimeFieldForTransportTask("beginTime","");
	}


	public TransportTruckForm endIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  endIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm endIdFieldForTransportTask(String initValue){
		return endIdFieldForTransportTask("endId",initValue);
	}
	public TransportTruckForm endIdFieldForTransportTask(){
		return endIdFieldForTransportTask("endId","");
	}


	public TransportTruckForm driverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  driverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm driverIdFieldForTransportTask(String initValue){
		return driverIdFieldForTransportTask("driverId",initValue);
	}
	public TransportTruckForm driverIdFieldForTransportTask(){
		return driverIdFieldForTransportTask("driverId","");
	}


	public TransportTruckForm truckIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  truckIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm truckIdFieldForTransportTask(String initValue){
		return truckIdFieldForTransportTask("truckId",initValue);
	}
	public TransportTruckForm truckIdFieldForTransportTask(){
		return truckIdFieldForTransportTask("truckId","");
	}


	public TransportTruckForm belongsToIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  belongsToIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm belongsToIdFieldForTransportTask(String initValue){
		return belongsToIdFieldForTransportTask("belongsToId",initValue);
	}
	public TransportTruckForm belongsToIdFieldForTransportTask(){
		return belongsToIdFieldForTransportTask("belongsToId","");
	}


	public TransportTruckForm latitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm latitudeFieldForTransportTask(String initValue){
		return latitudeFieldForTransportTask("latitude",initValue);
	}
	public TransportTruckForm latitudeFieldForTransportTask(){
		return latitudeFieldForTransportTask("latitude","");
	}


	public TransportTruckForm longitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTruckForm longitudeFieldForTransportTask(String initValue){
		return longitudeFieldForTransportTask("longitude",initValue);
	}
	public TransportTruckForm longitudeFieldForTransportTask(){
		return longitudeFieldForTransportTask("longitude","");
	}

	

	
 	public TransportTruckForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/transportTruckId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportTruckForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



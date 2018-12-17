package com.doublechaintech.retailscm.transporttasktrack;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TransportTaskTrackForm extends BaseForm {
	
	
	public TransportTaskTrackForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportTaskTrackForm transportTaskTrackIdField(String parameterName, String initValue){
		FormField field = idFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm transportTaskTrackIdField(String initValue){
		return transportTaskTrackIdField("transportTaskTrackId",initValue);
	}
	public TransportTaskTrackForm transportTaskTrackIdField(){
		return transportTaskTrackIdField("transportTaskTrackId","");
	}


	public TransportTaskTrackForm trackTimeField(String parameterName, String initValue){
		FormField field = trackTimeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm trackTimeField(String initValue){
		return trackTimeField("trackTime",initValue);
	}
	public TransportTaskTrackForm trackTimeField(){
		return trackTimeField("trackTime","");
	}


	public TransportTaskTrackForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public TransportTaskTrackForm latitudeField(){
		return latitudeField("latitude","");
	}


	public TransportTaskTrackForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public TransportTaskTrackForm longitudeField(){
		return longitudeField("longitude","");
	}


	public TransportTaskTrackForm movementIdField(String parameterName, String initValue){
		FormField field = movementIdFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskTrackForm movementIdField(String initValue){
		return movementIdField("movementId",initValue);
	}
	public TransportTaskTrackForm movementIdField(){
		return movementIdField("movementId","");
	}

	
	


	public TransportTaskTrackForm transportTaskIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm transportTaskIdFieldOfTransportTask(String initValue){
		return transportTaskIdFieldOfTransportTask("transportTaskId",initValue);
	}
	public TransportTaskTrackForm transportTaskIdFieldOfTransportTask(){
		return transportTaskIdFieldOfTransportTask("transportTaskId","");
	}


	public TransportTaskTrackForm nameFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm nameFieldOfTransportTask(String initValue){
		return nameFieldOfTransportTask("name",initValue);
	}
	public TransportTaskTrackForm nameFieldOfTransportTask(){
		return nameFieldOfTransportTask("name","");
	}


	public TransportTaskTrackForm startFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  startFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm startFieldOfTransportTask(String initValue){
		return startFieldOfTransportTask("start",initValue);
	}
	public TransportTaskTrackForm startFieldOfTransportTask(){
		return startFieldOfTransportTask("start","");
	}


	public TransportTaskTrackForm beginTimeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  beginTimeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm beginTimeFieldOfTransportTask(String initValue){
		return beginTimeFieldOfTransportTask("beginTime",initValue);
	}
	public TransportTaskTrackForm beginTimeFieldOfTransportTask(){
		return beginTimeFieldOfTransportTask("beginTime","");
	}


	public TransportTaskTrackForm endIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  endIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm endIdFieldOfTransportTask(String initValue){
		return endIdFieldOfTransportTask("endId",initValue);
	}
	public TransportTaskTrackForm endIdFieldOfTransportTask(){
		return endIdFieldOfTransportTask("endId","");
	}


	public TransportTaskTrackForm driverIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  driverIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm driverIdFieldOfTransportTask(String initValue){
		return driverIdFieldOfTransportTask("driverId",initValue);
	}
	public TransportTaskTrackForm driverIdFieldOfTransportTask(){
		return driverIdFieldOfTransportTask("driverId","");
	}


	public TransportTaskTrackForm truckIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  truckIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm truckIdFieldOfTransportTask(String initValue){
		return truckIdFieldOfTransportTask("truckId",initValue);
	}
	public TransportTaskTrackForm truckIdFieldOfTransportTask(){
		return truckIdFieldOfTransportTask("truckId","");
	}


	public TransportTaskTrackForm belongsToIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  belongsToIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm belongsToIdFieldOfTransportTask(String initValue){
		return belongsToIdFieldOfTransportTask("belongsToId",initValue);
	}
	public TransportTaskTrackForm belongsToIdFieldOfTransportTask(){
		return belongsToIdFieldOfTransportTask("belongsToId","");
	}


	public TransportTaskTrackForm latitudeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm latitudeFieldOfTransportTask(String initValue){
		return latitudeFieldOfTransportTask("latitude",initValue);
	}
	public TransportTaskTrackForm latitudeFieldOfTransportTask(){
		return latitudeFieldOfTransportTask("latitude","");
	}


	public TransportTaskTrackForm longitudeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskTrackForm longitudeFieldOfTransportTask(String initValue){
		return longitudeFieldOfTransportTask("longitude",initValue);
	}
	public TransportTaskTrackForm longitudeFieldOfTransportTask(){
		return longitudeFieldOfTransportTask("longitude","");
	}

	


	

	
 	public TransportTaskTrackForm transferToAnotherMovementAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherMovement/transportTaskTrackId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportTaskTrackForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



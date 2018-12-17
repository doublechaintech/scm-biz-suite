package com.doublechaintech.retailscm.transportfleet;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TransportFleetForm extends BaseForm {
	
	
	public TransportFleetForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportFleetForm transportFleetIdField(String parameterName, String initValue){
		FormField field = idFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm transportFleetIdField(String initValue){
		return transportFleetIdField("transportFleetId",initValue);
	}
	public TransportFleetForm transportFleetIdField(){
		return transportFleetIdField("transportFleetId","");
	}


	public TransportFleetForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportFleetForm nameField(){
		return nameField("name","");
	}


	public TransportFleetForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public TransportFleetForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public TransportFleetForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public TransportFleetForm ownerIdField(){
		return ownerIdField("ownerId","");
	}


	public TransportFleetForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public TransportFleetForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public TransportFleetForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public TransportFleetForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public TransportFleetForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public TransportFleetForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public TransportFleetForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public TransportFleetForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public TransportFleetForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public TransportFleetForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public TransportFleetForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public TransportFleetForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public TransportFleetForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public TransportFleetForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public TransportFleetForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public TransportFleetForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public TransportFleetForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public TransportFleetForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public TransportFleetForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportFleetForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public TransportFleetForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public TransportFleetForm transportTruckIdFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  idFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm transportTruckIdFieldForTransportTruck(String initValue){
		return transportTruckIdFieldForTransportTruck("transportTruckId",initValue);
	}
	public TransportFleetForm transportTruckIdFieldForTransportTruck(){
		return transportTruckIdFieldForTransportTruck("transportTruckId","");
	}


	public TransportFleetForm nameFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  nameFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm nameFieldForTransportTruck(String initValue){
		return nameFieldForTransportTruck("name",initValue);
	}
	public TransportFleetForm nameFieldForTransportTruck(){
		return nameFieldForTransportTruck("name","");
	}


	public TransportFleetForm plateNumberFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  plateNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm plateNumberFieldForTransportTruck(String initValue){
		return plateNumberFieldForTransportTruck("plateNumber",initValue);
	}
	public TransportFleetForm plateNumberFieldForTransportTruck(){
		return plateNumberFieldForTransportTruck("plateNumber","");
	}


	public TransportFleetForm contactNumberFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  contactNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm contactNumberFieldForTransportTruck(String initValue){
		return contactNumberFieldForTransportTruck("contactNumber",initValue);
	}
	public TransportFleetForm contactNumberFieldForTransportTruck(){
		return contactNumberFieldForTransportTruck("contactNumber","");
	}


	public TransportFleetForm vehicleLicenseNumberFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  vehicleLicenseNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm vehicleLicenseNumberFieldForTransportTruck(String initValue){
		return vehicleLicenseNumberFieldForTransportTruck("vehicleLicenseNumber",initValue);
	}
	public TransportFleetForm vehicleLicenseNumberFieldForTransportTruck(){
		return vehicleLicenseNumberFieldForTransportTruck("vehicleLicenseNumber","");
	}


	public TransportFleetForm engineNumberFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  engineNumberFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm engineNumberFieldForTransportTruck(String initValue){
		return engineNumberFieldForTransportTruck("engineNumber",initValue);
	}
	public TransportFleetForm engineNumberFieldForTransportTruck(){
		return engineNumberFieldForTransportTruck("engineNumber","");
	}


	public TransportFleetForm makeDateFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  makeDateFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm makeDateFieldForTransportTruck(String initValue){
		return makeDateFieldForTransportTruck("makeDate",initValue);
	}
	public TransportFleetForm makeDateFieldForTransportTruck(){
		return makeDateFieldForTransportTruck("makeDate","");
	}


	public TransportFleetForm mileageFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  mileageFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm mileageFieldForTransportTruck(String initValue){
		return mileageFieldForTransportTruck("mileage",initValue);
	}
	public TransportFleetForm mileageFieldForTransportTruck(){
		return mileageFieldForTransportTruck("mileage","");
	}


	public TransportFleetForm bodyColorFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  bodyColorFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm bodyColorFieldForTransportTruck(String initValue){
		return bodyColorFieldForTransportTruck("bodyColor",initValue);
	}
	public TransportFleetForm bodyColorFieldForTransportTruck(){
		return bodyColorFieldForTransportTruck("bodyColor","");
	}


	public TransportFleetForm ownerIdFieldForTransportTruck(String parameterName, String initValue){
		FormField field =  ownerIdFromTransportTruck(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm ownerIdFieldForTransportTruck(String initValue){
		return ownerIdFieldForTransportTruck("ownerId",initValue);
	}
	public TransportFleetForm ownerIdFieldForTransportTruck(){
		return ownerIdFieldForTransportTruck("ownerId","");
	}


	public TransportFleetForm truckDriverIdFieldForTruckDriver(String parameterName, String initValue){
		FormField field =  idFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm truckDriverIdFieldForTruckDriver(String initValue){
		return truckDriverIdFieldForTruckDriver("truckDriverId",initValue);
	}
	public TransportFleetForm truckDriverIdFieldForTruckDriver(){
		return truckDriverIdFieldForTruckDriver("truckDriverId","");
	}


	public TransportFleetForm nameFieldForTruckDriver(String parameterName, String initValue){
		FormField field =  nameFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm nameFieldForTruckDriver(String initValue){
		return nameFieldForTruckDriver("name",initValue);
	}
	public TransportFleetForm nameFieldForTruckDriver(){
		return nameFieldForTruckDriver("name","");
	}


	public TransportFleetForm driverLicenseNumberFieldForTruckDriver(String parameterName, String initValue){
		FormField field =  driverLicenseNumberFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm driverLicenseNumberFieldForTruckDriver(String initValue){
		return driverLicenseNumberFieldForTruckDriver("driverLicenseNumber",initValue);
	}
	public TransportFleetForm driverLicenseNumberFieldForTruckDriver(){
		return driverLicenseNumberFieldForTruckDriver("driverLicenseNumber","");
	}


	public TransportFleetForm contactNumberFieldForTruckDriver(String parameterName, String initValue){
		FormField field =  contactNumberFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm contactNumberFieldForTruckDriver(String initValue){
		return contactNumberFieldForTruckDriver("contactNumber",initValue);
	}
	public TransportFleetForm contactNumberFieldForTruckDriver(){
		return contactNumberFieldForTruckDriver("contactNumber","");
	}


	public TransportFleetForm belongsToIdFieldForTruckDriver(String parameterName, String initValue){
		FormField field =  belongsToIdFromTruckDriver(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm belongsToIdFieldForTruckDriver(String initValue){
		return belongsToIdFieldForTruckDriver("belongsToId",initValue);
	}
	public TransportFleetForm belongsToIdFieldForTruckDriver(){
		return belongsToIdFieldForTruckDriver("belongsToId","");
	}


	public TransportFleetForm transportTaskIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm transportTaskIdFieldForTransportTask(String initValue){
		return transportTaskIdFieldForTransportTask("transportTaskId",initValue);
	}
	public TransportFleetForm transportTaskIdFieldForTransportTask(){
		return transportTaskIdFieldForTransportTask("transportTaskId","");
	}


	public TransportFleetForm nameFieldForTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm nameFieldForTransportTask(String initValue){
		return nameFieldForTransportTask("name",initValue);
	}
	public TransportFleetForm nameFieldForTransportTask(){
		return nameFieldForTransportTask("name","");
	}


	public TransportFleetForm startFieldForTransportTask(String parameterName, String initValue){
		FormField field =  startFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm startFieldForTransportTask(String initValue){
		return startFieldForTransportTask("start",initValue);
	}
	public TransportFleetForm startFieldForTransportTask(){
		return startFieldForTransportTask("start","");
	}


	public TransportFleetForm beginTimeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  beginTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm beginTimeFieldForTransportTask(String initValue){
		return beginTimeFieldForTransportTask("beginTime",initValue);
	}
	public TransportFleetForm beginTimeFieldForTransportTask(){
		return beginTimeFieldForTransportTask("beginTime","");
	}


	public TransportFleetForm endIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  endIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm endIdFieldForTransportTask(String initValue){
		return endIdFieldForTransportTask("endId",initValue);
	}
	public TransportFleetForm endIdFieldForTransportTask(){
		return endIdFieldForTransportTask("endId","");
	}


	public TransportFleetForm driverIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  driverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm driverIdFieldForTransportTask(String initValue){
		return driverIdFieldForTransportTask("driverId",initValue);
	}
	public TransportFleetForm driverIdFieldForTransportTask(){
		return driverIdFieldForTransportTask("driverId","");
	}


	public TransportFleetForm truckIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  truckIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm truckIdFieldForTransportTask(String initValue){
		return truckIdFieldForTransportTask("truckId",initValue);
	}
	public TransportFleetForm truckIdFieldForTransportTask(){
		return truckIdFieldForTransportTask("truckId","");
	}


	public TransportFleetForm belongsToIdFieldForTransportTask(String parameterName, String initValue){
		FormField field =  belongsToIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm belongsToIdFieldForTransportTask(String initValue){
		return belongsToIdFieldForTransportTask("belongsToId",initValue);
	}
	public TransportFleetForm belongsToIdFieldForTransportTask(){
		return belongsToIdFieldForTransportTask("belongsToId","");
	}


	public TransportFleetForm latitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm latitudeFieldForTransportTask(String initValue){
		return latitudeFieldForTransportTask("latitude",initValue);
	}
	public TransportFleetForm latitudeFieldForTransportTask(){
		return latitudeFieldForTransportTask("latitude","");
	}


	public TransportFleetForm longitudeFieldForTransportTask(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportFleetForm longitudeFieldForTransportTask(String initValue){
		return longitudeFieldForTransportTask("longitude",initValue);
	}
	public TransportFleetForm longitudeFieldForTransportTask(){
		return longitudeFieldForTransportTask("longitude","");
	}

	

	
 	public TransportFleetForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/transportFleetId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportFleetForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



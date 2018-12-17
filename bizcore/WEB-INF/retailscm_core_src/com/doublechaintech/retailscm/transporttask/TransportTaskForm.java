package com.doublechaintech.retailscm.transporttask;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TransportTaskForm extends BaseForm {
	
	
	public TransportTaskForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TransportTaskForm transportTaskIdField(String parameterName, String initValue){
		FormField field = idFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm transportTaskIdField(String initValue){
		return transportTaskIdField("transportTaskId",initValue);
	}
	public TransportTaskForm transportTaskIdField(){
		return transportTaskIdField("transportTaskId","");
	}


	public TransportTaskForm nameField(String parameterName, String initValue){
		FormField field = nameFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TransportTaskForm nameField(){
		return nameField("name","");
	}


	public TransportTaskForm startField(String parameterName, String initValue){
		FormField field = startFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm startField(String initValue){
		return startField("start",initValue);
	}
	public TransportTaskForm startField(){
		return startField("start","");
	}


	public TransportTaskForm beginTimeField(String parameterName, String initValue){
		FormField field = beginTimeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm beginTimeField(String initValue){
		return beginTimeField("beginTime",initValue);
	}
	public TransportTaskForm beginTimeField(){
		return beginTimeField("beginTime","");
	}


	public TransportTaskForm endIdField(String parameterName, String initValue){
		FormField field = endIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm endIdField(String initValue){
		return endIdField("endId",initValue);
	}
	public TransportTaskForm endIdField(){
		return endIdField("endId","");
	}


	public TransportTaskForm driverIdField(String parameterName, String initValue){
		FormField field = driverIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm driverIdField(String initValue){
		return driverIdField("driverId",initValue);
	}
	public TransportTaskForm driverIdField(){
		return driverIdField("driverId","");
	}


	public TransportTaskForm truckIdField(String parameterName, String initValue){
		FormField field = truckIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm truckIdField(String initValue){
		return truckIdField("truckId",initValue);
	}
	public TransportTaskForm truckIdField(){
		return truckIdField("truckId","");
	}


	public TransportTaskForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public TransportTaskForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public TransportTaskForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public TransportTaskForm latitudeField(){
		return latitudeField("latitude","");
	}


	public TransportTaskForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromTransportTask(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public TransportTaskForm longitudeField(){
		return longitudeField("longitude","");
	}

	
	


	public TransportTaskForm retailStoreIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm retailStoreIdFieldOfRetailStore(String initValue){
		return retailStoreIdFieldOfRetailStore("retailStoreId",initValue);
	}
	public TransportTaskForm retailStoreIdFieldOfRetailStore(){
		return retailStoreIdFieldOfRetailStore("retailStoreId","");
	}


	public TransportTaskForm nameFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfRetailStore(String initValue){
		return nameFieldOfRetailStore("name",initValue);
	}
	public TransportTaskForm nameFieldOfRetailStore(){
		return nameFieldOfRetailStore("name","");
	}


	public TransportTaskForm telephoneFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm telephoneFieldOfRetailStore(String initValue){
		return telephoneFieldOfRetailStore("telephone",initValue);
	}
	public TransportTaskForm telephoneFieldOfRetailStore(){
		return telephoneFieldOfRetailStore("telephone","");
	}


	public TransportTaskForm ownerFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm ownerFieldOfRetailStore(String initValue){
		return ownerFieldOfRetailStore("owner",initValue);
	}
	public TransportTaskForm ownerFieldOfRetailStore(){
		return ownerFieldOfRetailStore("owner","");
	}


	public TransportTaskForm retailStoreCountryCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm retailStoreCountryCenterIdFieldOfRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId",initValue);
	}
	public TransportTaskForm retailStoreCountryCenterIdFieldOfRetailStore(){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId","");
	}


	public TransportTaskForm cityServiceCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm cityServiceCenterIdFieldOfRetailStore(String initValue){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId",initValue);
	}
	public TransportTaskForm cityServiceCenterIdFieldOfRetailStore(){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId","");
	}


	public TransportTaskForm creationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm creationIdFieldOfRetailStore(String initValue){
		return creationIdFieldOfRetailStore("creationId",initValue);
	}
	public TransportTaskForm creationIdFieldOfRetailStore(){
		return creationIdFieldOfRetailStore("creationId","");
	}


	public TransportTaskForm investmentInvitationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm investmentInvitationIdFieldOfRetailStore(String initValue){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId",initValue);
	}
	public TransportTaskForm investmentInvitationIdFieldOfRetailStore(){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId","");
	}


	public TransportTaskForm franchisingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm franchisingIdFieldOfRetailStore(String initValue){
		return franchisingIdFieldOfRetailStore("franchisingId",initValue);
	}
	public TransportTaskForm franchisingIdFieldOfRetailStore(){
		return franchisingIdFieldOfRetailStore("franchisingId","");
	}


	public TransportTaskForm decorationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm decorationIdFieldOfRetailStore(String initValue){
		return decorationIdFieldOfRetailStore("decorationId",initValue);
	}
	public TransportTaskForm decorationIdFieldOfRetailStore(){
		return decorationIdFieldOfRetailStore("decorationId","");
	}


	public TransportTaskForm openingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm openingIdFieldOfRetailStore(String initValue){
		return openingIdFieldOfRetailStore("openingId",initValue);
	}
	public TransportTaskForm openingIdFieldOfRetailStore(){
		return openingIdFieldOfRetailStore("openingId","");
	}


	public TransportTaskForm closingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm closingIdFieldOfRetailStore(String initValue){
		return closingIdFieldOfRetailStore("closingId",initValue);
	}
	public TransportTaskForm closingIdFieldOfRetailStore(){
		return closingIdFieldOfRetailStore("closingId","");
	}


	public TransportTaskForm foundedFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm foundedFieldOfRetailStore(String initValue){
		return foundedFieldOfRetailStore("founded",initValue);
	}
	public TransportTaskForm foundedFieldOfRetailStore(){
		return foundedFieldOfRetailStore("founded","");
	}


	public TransportTaskForm latitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm latitudeFieldOfRetailStore(String initValue){
		return latitudeFieldOfRetailStore("latitude",initValue);
	}
	public TransportTaskForm latitudeFieldOfRetailStore(){
		return latitudeFieldOfRetailStore("latitude","");
	}


	public TransportTaskForm longitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm longitudeFieldOfRetailStore(String initValue){
		return longitudeFieldOfRetailStore("longitude",initValue);
	}
	public TransportTaskForm longitudeFieldOfRetailStore(){
		return longitudeFieldOfRetailStore("longitude","");
	}


	public TransportTaskForm descriptionFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm descriptionFieldOfRetailStore(String initValue){
		return descriptionFieldOfRetailStore("description",initValue);
	}
	public TransportTaskForm descriptionFieldOfRetailStore(){
		return descriptionFieldOfRetailStore("description","");
	}


	public TransportTaskForm lastUpdateTimeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm lastUpdateTimeFieldOfRetailStore(String initValue){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime",initValue);
	}
	public TransportTaskForm lastUpdateTimeFieldOfRetailStore(){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime","");
	}


	public TransportTaskForm currentStatusFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm currentStatusFieldOfRetailStore(String initValue){
		return currentStatusFieldOfRetailStore("currentStatus",initValue);
	}
	public TransportTaskForm currentStatusFieldOfRetailStore(){
		return currentStatusFieldOfRetailStore("currentStatus","");
	}


	public TransportTaskForm truckDriverIdFieldOfTruckDriver(String parameterName, String initValue){
		FormField field =  idFromTruckDriver(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm truckDriverIdFieldOfTruckDriver(String initValue){
		return truckDriverIdFieldOfTruckDriver("truckDriverId",initValue);
	}
	public TransportTaskForm truckDriverIdFieldOfTruckDriver(){
		return truckDriverIdFieldOfTruckDriver("truckDriverId","");
	}


	public TransportTaskForm nameFieldOfTruckDriver(String parameterName, String initValue){
		FormField field =  nameFromTruckDriver(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfTruckDriver(String initValue){
		return nameFieldOfTruckDriver("name",initValue);
	}
	public TransportTaskForm nameFieldOfTruckDriver(){
		return nameFieldOfTruckDriver("name","");
	}


	public TransportTaskForm driverLicenseNumberFieldOfTruckDriver(String parameterName, String initValue){
		FormField field =  driverLicenseNumberFromTruckDriver(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm driverLicenseNumberFieldOfTruckDriver(String initValue){
		return driverLicenseNumberFieldOfTruckDriver("driverLicenseNumber",initValue);
	}
	public TransportTaskForm driverLicenseNumberFieldOfTruckDriver(){
		return driverLicenseNumberFieldOfTruckDriver("driverLicenseNumber","");
	}


	public TransportTaskForm contactNumberFieldOfTruckDriver(String parameterName, String initValue){
		FormField field =  contactNumberFromTruckDriver(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm contactNumberFieldOfTruckDriver(String initValue){
		return contactNumberFieldOfTruckDriver("contactNumber",initValue);
	}
	public TransportTaskForm contactNumberFieldOfTruckDriver(){
		return contactNumberFieldOfTruckDriver("contactNumber","");
	}


	public TransportTaskForm belongsToIdFieldOfTruckDriver(String parameterName, String initValue){
		FormField field =  belongsToIdFromTruckDriver(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm belongsToIdFieldOfTruckDriver(String initValue){
		return belongsToIdFieldOfTruckDriver("belongsToId",initValue);
	}
	public TransportTaskForm belongsToIdFieldOfTruckDriver(){
		return belongsToIdFieldOfTruckDriver("belongsToId","");
	}


	public TransportTaskForm transportTruckIdFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  idFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm transportTruckIdFieldOfTransportTruck(String initValue){
		return transportTruckIdFieldOfTransportTruck("transportTruckId",initValue);
	}
	public TransportTaskForm transportTruckIdFieldOfTransportTruck(){
		return transportTruckIdFieldOfTransportTruck("transportTruckId","");
	}


	public TransportTaskForm nameFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  nameFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfTransportTruck(String initValue){
		return nameFieldOfTransportTruck("name",initValue);
	}
	public TransportTaskForm nameFieldOfTransportTruck(){
		return nameFieldOfTransportTruck("name","");
	}


	public TransportTaskForm plateNumberFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  plateNumberFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm plateNumberFieldOfTransportTruck(String initValue){
		return plateNumberFieldOfTransportTruck("plateNumber",initValue);
	}
	public TransportTaskForm plateNumberFieldOfTransportTruck(){
		return plateNumberFieldOfTransportTruck("plateNumber","");
	}


	public TransportTaskForm contactNumberFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  contactNumberFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm contactNumberFieldOfTransportTruck(String initValue){
		return contactNumberFieldOfTransportTruck("contactNumber",initValue);
	}
	public TransportTaskForm contactNumberFieldOfTransportTruck(){
		return contactNumberFieldOfTransportTruck("contactNumber","");
	}


	public TransportTaskForm vehicleLicenseNumberFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  vehicleLicenseNumberFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm vehicleLicenseNumberFieldOfTransportTruck(String initValue){
		return vehicleLicenseNumberFieldOfTransportTruck("vehicleLicenseNumber",initValue);
	}
	public TransportTaskForm vehicleLicenseNumberFieldOfTransportTruck(){
		return vehicleLicenseNumberFieldOfTransportTruck("vehicleLicenseNumber","");
	}


	public TransportTaskForm engineNumberFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  engineNumberFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm engineNumberFieldOfTransportTruck(String initValue){
		return engineNumberFieldOfTransportTruck("engineNumber",initValue);
	}
	public TransportTaskForm engineNumberFieldOfTransportTruck(){
		return engineNumberFieldOfTransportTruck("engineNumber","");
	}


	public TransportTaskForm makeDateFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  makeDateFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm makeDateFieldOfTransportTruck(String initValue){
		return makeDateFieldOfTransportTruck("makeDate",initValue);
	}
	public TransportTaskForm makeDateFieldOfTransportTruck(){
		return makeDateFieldOfTransportTruck("makeDate","");
	}


	public TransportTaskForm mileageFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  mileageFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm mileageFieldOfTransportTruck(String initValue){
		return mileageFieldOfTransportTruck("mileage",initValue);
	}
	public TransportTaskForm mileageFieldOfTransportTruck(){
		return mileageFieldOfTransportTruck("mileage","");
	}


	public TransportTaskForm bodyColorFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  bodyColorFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm bodyColorFieldOfTransportTruck(String initValue){
		return bodyColorFieldOfTransportTruck("bodyColor",initValue);
	}
	public TransportTaskForm bodyColorFieldOfTransportTruck(){
		return bodyColorFieldOfTransportTruck("bodyColor","");
	}


	public TransportTaskForm ownerIdFieldOfTransportTruck(String parameterName, String initValue){
		FormField field =  ownerIdFromTransportTruck(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm ownerIdFieldOfTransportTruck(String initValue){
		return ownerIdFieldOfTransportTruck("ownerId",initValue);
	}
	public TransportTaskForm ownerIdFieldOfTransportTruck(){
		return ownerIdFieldOfTransportTruck("ownerId","");
	}


	public TransportTaskForm transportFleetIdFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  idFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm transportFleetIdFieldOfTransportFleet(String initValue){
		return transportFleetIdFieldOfTransportFleet("transportFleetId",initValue);
	}
	public TransportTaskForm transportFleetIdFieldOfTransportFleet(){
		return transportFleetIdFieldOfTransportFleet("transportFleetId","");
	}


	public TransportTaskForm nameFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  nameFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm nameFieldOfTransportFleet(String initValue){
		return nameFieldOfTransportFleet("name",initValue);
	}
	public TransportTaskForm nameFieldOfTransportFleet(){
		return nameFieldOfTransportFleet("name","");
	}


	public TransportTaskForm contactNumberFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  contactNumberFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm contactNumberFieldOfTransportFleet(String initValue){
		return contactNumberFieldOfTransportFleet("contactNumber",initValue);
	}
	public TransportTaskForm contactNumberFieldOfTransportFleet(){
		return contactNumberFieldOfTransportFleet("contactNumber","");
	}


	public TransportTaskForm ownerIdFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  ownerIdFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm ownerIdFieldOfTransportFleet(String initValue){
		return ownerIdFieldOfTransportFleet("ownerId",initValue);
	}
	public TransportTaskForm ownerIdFieldOfTransportFleet(){
		return ownerIdFieldOfTransportFleet("ownerId","");
	}


	public TransportTaskForm lastUpdateTimeFieldOfTransportFleet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTransportFleet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TransportTaskForm lastUpdateTimeFieldOfTransportFleet(String initValue){
		return lastUpdateTimeFieldOfTransportFleet("lastUpdateTime",initValue);
	}
	public TransportTaskForm lastUpdateTimeFieldOfTransportFleet(){
		return lastUpdateTimeFieldOfTransportFleet("lastUpdateTime","");
	}

	



	public TransportTaskForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public TransportTaskForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public TransportTaskForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public TransportTaskForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public TransportTaskForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public TransportTaskForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public TransportTaskForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public TransportTaskForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public TransportTaskForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public TransportTaskForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public TransportTaskForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public TransportTaskForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public TransportTaskForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public TransportTaskForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public TransportTaskForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public TransportTaskForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public TransportTaskForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public TransportTaskForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public TransportTaskForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public TransportTaskForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public TransportTaskForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public TransportTaskForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public TransportTaskForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public TransportTaskForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public TransportTaskForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public TransportTaskForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public TransportTaskForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public TransportTaskForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public TransportTaskForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public TransportTaskForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public TransportTaskForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public TransportTaskForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public TransportTaskForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public TransportTaskForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}


	public TransportTaskForm transportTaskTrackIdFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  idFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm transportTaskTrackIdFieldForTransportTaskTrack(String initValue){
		return transportTaskTrackIdFieldForTransportTaskTrack("transportTaskTrackId",initValue);
	}
	public TransportTaskForm transportTaskTrackIdFieldForTransportTaskTrack(){
		return transportTaskTrackIdFieldForTransportTaskTrack("transportTaskTrackId","");
	}


	public TransportTaskForm trackTimeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  trackTimeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm trackTimeFieldForTransportTaskTrack(String initValue){
		return trackTimeFieldForTransportTaskTrack("trackTime",initValue);
	}
	public TransportTaskForm trackTimeFieldForTransportTaskTrack(){
		return trackTimeFieldForTransportTaskTrack("trackTime","");
	}


	public TransportTaskForm latitudeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm latitudeFieldForTransportTaskTrack(String initValue){
		return latitudeFieldForTransportTaskTrack("latitude",initValue);
	}
	public TransportTaskForm latitudeFieldForTransportTaskTrack(){
		return latitudeFieldForTransportTaskTrack("latitude","");
	}


	public TransportTaskForm longitudeFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm longitudeFieldForTransportTaskTrack(String initValue){
		return longitudeFieldForTransportTaskTrack("longitude",initValue);
	}
	public TransportTaskForm longitudeFieldForTransportTaskTrack(){
		return longitudeFieldForTransportTaskTrack("longitude","");
	}


	public TransportTaskForm movementIdFieldForTransportTaskTrack(String parameterName, String initValue){
		FormField field =  movementIdFromTransportTaskTrack(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TransportTaskForm movementIdFieldForTransportTaskTrack(String initValue){
		return movementIdFieldForTransportTaskTrack("movementId",initValue);
	}
	public TransportTaskForm movementIdFieldForTransportTaskTrack(){
		return movementIdFieldForTransportTaskTrack("movementId","");
	}

	

	
 	public TransportTaskForm transferToAnotherEndAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEnd/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherDriverAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDriver/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherTruckAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherTruck/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TransportTaskForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/transportTaskId/");
		this.addFormAction(action);
		return this;
	}

 

	public TransportTaskForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



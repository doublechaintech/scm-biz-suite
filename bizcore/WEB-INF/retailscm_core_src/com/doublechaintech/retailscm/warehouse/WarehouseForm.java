package com.doublechaintech.retailscm.warehouse;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class WarehouseForm extends BaseForm {
	
	
	public WarehouseForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public WarehouseForm warehouseIdField(String parameterName, String initValue){
		FormField field = idFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}


	public WarehouseForm locationField(String parameterName, String initValue){
		FormField field = locationFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public WarehouseForm locationField(){
		return locationField("location","");
	}


	public WarehouseForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public WarehouseForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public WarehouseForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public WarehouseForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public WarehouseForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public WarehouseForm ownerIdField(){
		return ownerIdField("ownerId","");
	}


	public WarehouseForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public WarehouseForm latitudeField(){
		return latitudeField("latitude","");
	}


	public WarehouseForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public WarehouseForm longitudeField(){
		return longitudeField("longitude","");
	}


	public WarehouseForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public WarehouseForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public WarehouseForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public WarehouseForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public WarehouseForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public WarehouseForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public WarehouseForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public WarehouseForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public WarehouseForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public WarehouseForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public WarehouseForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public WarehouseForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public WarehouseForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public WarehouseForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public WarehouseForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public WarehouseForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public WarehouseForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public WarehouseForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public WarehouseForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public WarehouseForm storageSpaceIdFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  idFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm storageSpaceIdFieldForStorageSpace(String initValue){
		return storageSpaceIdFieldForStorageSpace("storageSpaceId",initValue);
	}
	public WarehouseForm storageSpaceIdFieldForStorageSpace(){
		return storageSpaceIdFieldForStorageSpace("storageSpaceId","");
	}


	public WarehouseForm locationFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  locationFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationFieldForStorageSpace(String initValue){
		return locationFieldForStorageSpace("location",initValue);
	}
	public WarehouseForm locationFieldForStorageSpace(){
		return locationFieldForStorageSpace("location","");
	}


	public WarehouseForm contactNumberFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberFieldForStorageSpace(String initValue){
		return contactNumberFieldForStorageSpace("contactNumber",initValue);
	}
	public WarehouseForm contactNumberFieldForStorageSpace(){
		return contactNumberFieldForStorageSpace("contactNumber","");
	}


	public WarehouseForm totalAreaFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaFieldForStorageSpace(String initValue){
		return totalAreaFieldForStorageSpace("totalArea",initValue);
	}
	public WarehouseForm totalAreaFieldForStorageSpace(){
		return totalAreaFieldForStorageSpace("totalArea","");
	}


	public WarehouseForm warehouseIdFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdFieldForStorageSpace(String initValue){
		return warehouseIdFieldForStorageSpace("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdFieldForStorageSpace(){
		return warehouseIdFieldForStorageSpace("warehouseId","");
	}


	public WarehouseForm latitudeFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  latitudeFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeFieldForStorageSpace(String initValue){
		return latitudeFieldForStorageSpace("latitude",initValue);
	}
	public WarehouseForm latitudeFieldForStorageSpace(){
		return latitudeFieldForStorageSpace("latitude","");
	}


	public WarehouseForm longitudeFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  longitudeFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeFieldForStorageSpace(String initValue){
		return longitudeFieldForStorageSpace("longitude",initValue);
	}
	public WarehouseForm longitudeFieldForStorageSpace(){
		return longitudeFieldForStorageSpace("longitude","");
	}


	public WarehouseForm lastUpdateTimeFieldForStorageSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForStorageSpace(String initValue){
		return lastUpdateTimeFieldForStorageSpace("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForStorageSpace(){
		return lastUpdateTimeFieldForStorageSpace("lastUpdateTime","");
	}


	public WarehouseForm smartPalletIdFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  idFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm smartPalletIdFieldForSmartPallet(String initValue){
		return smartPalletIdFieldForSmartPallet("smartPalletId",initValue);
	}
	public WarehouseForm smartPalletIdFieldForSmartPallet(){
		return smartPalletIdFieldForSmartPallet("smartPalletId","");
	}


	public WarehouseForm locationFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  locationFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationFieldForSmartPallet(String initValue){
		return locationFieldForSmartPallet("location",initValue);
	}
	public WarehouseForm locationFieldForSmartPallet(){
		return locationFieldForSmartPallet("location","");
	}


	public WarehouseForm contactNumberFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  contactNumberFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberFieldForSmartPallet(String initValue){
		return contactNumberFieldForSmartPallet("contactNumber",initValue);
	}
	public WarehouseForm contactNumberFieldForSmartPallet(){
		return contactNumberFieldForSmartPallet("contactNumber","");
	}


	public WarehouseForm totalAreaFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  totalAreaFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaFieldForSmartPallet(String initValue){
		return totalAreaFieldForSmartPallet("totalArea",initValue);
	}
	public WarehouseForm totalAreaFieldForSmartPallet(){
		return totalAreaFieldForSmartPallet("totalArea","");
	}


	public WarehouseForm latitudeFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  latitudeFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeFieldForSmartPallet(String initValue){
		return latitudeFieldForSmartPallet("latitude",initValue);
	}
	public WarehouseForm latitudeFieldForSmartPallet(){
		return latitudeFieldForSmartPallet("latitude","");
	}


	public WarehouseForm longitudeFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  longitudeFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeFieldForSmartPallet(String initValue){
		return longitudeFieldForSmartPallet("longitude",initValue);
	}
	public WarehouseForm longitudeFieldForSmartPallet(){
		return longitudeFieldForSmartPallet("longitude","");
	}


	public WarehouseForm warehouseIdFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  warehouseIdFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdFieldForSmartPallet(String initValue){
		return warehouseIdFieldForSmartPallet("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdFieldForSmartPallet(){
		return warehouseIdFieldForSmartPallet("warehouseId","");
	}


	public WarehouseForm lastUpdateTimeFieldForSmartPallet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForSmartPallet(String initValue){
		return lastUpdateTimeFieldForSmartPallet("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForSmartPallet(){
		return lastUpdateTimeFieldForSmartPallet("lastUpdateTime","");
	}


	public WarehouseForm supplierSpaceIdFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  idFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm supplierSpaceIdFieldForSupplierSpace(String initValue){
		return supplierSpaceIdFieldForSupplierSpace("supplierSpaceId",initValue);
	}
	public WarehouseForm supplierSpaceIdFieldForSupplierSpace(){
		return supplierSpaceIdFieldForSupplierSpace("supplierSpaceId","");
	}


	public WarehouseForm locationFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  locationFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationFieldForSupplierSpace(String initValue){
		return locationFieldForSupplierSpace("location",initValue);
	}
	public WarehouseForm locationFieldForSupplierSpace(){
		return locationFieldForSupplierSpace("location","");
	}


	public WarehouseForm contactNumberFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberFieldForSupplierSpace(String initValue){
		return contactNumberFieldForSupplierSpace("contactNumber",initValue);
	}
	public WarehouseForm contactNumberFieldForSupplierSpace(){
		return contactNumberFieldForSupplierSpace("contactNumber","");
	}


	public WarehouseForm totalAreaFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaFieldForSupplierSpace(String initValue){
		return totalAreaFieldForSupplierSpace("totalArea",initValue);
	}
	public WarehouseForm totalAreaFieldForSupplierSpace(){
		return totalAreaFieldForSupplierSpace("totalArea","");
	}


	public WarehouseForm warehouseIdFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdFieldForSupplierSpace(String initValue){
		return warehouseIdFieldForSupplierSpace("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdFieldForSupplierSpace(){
		return warehouseIdFieldForSupplierSpace("warehouseId","");
	}


	public WarehouseForm latitudeFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  latitudeFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeFieldForSupplierSpace(String initValue){
		return latitudeFieldForSupplierSpace("latitude",initValue);
	}
	public WarehouseForm latitudeFieldForSupplierSpace(){
		return latitudeFieldForSupplierSpace("latitude","");
	}


	public WarehouseForm longitudeFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  longitudeFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeFieldForSupplierSpace(String initValue){
		return longitudeFieldForSupplierSpace("longitude",initValue);
	}
	public WarehouseForm longitudeFieldForSupplierSpace(){
		return longitudeFieldForSupplierSpace("longitude","");
	}


	public WarehouseForm lastUpdateTimeFieldForSupplierSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForSupplierSpace(String initValue){
		return lastUpdateTimeFieldForSupplierSpace("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForSupplierSpace(){
		return lastUpdateTimeFieldForSupplierSpace("lastUpdateTime","");
	}


	public WarehouseForm receivingSpaceIdFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  idFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm receivingSpaceIdFieldForReceivingSpace(String initValue){
		return receivingSpaceIdFieldForReceivingSpace("receivingSpaceId",initValue);
	}
	public WarehouseForm receivingSpaceIdFieldForReceivingSpace(){
		return receivingSpaceIdFieldForReceivingSpace("receivingSpaceId","");
	}


	public WarehouseForm locationFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  locationFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationFieldForReceivingSpace(String initValue){
		return locationFieldForReceivingSpace("location",initValue);
	}
	public WarehouseForm locationFieldForReceivingSpace(){
		return locationFieldForReceivingSpace("location","");
	}


	public WarehouseForm contactNumberFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberFieldForReceivingSpace(String initValue){
		return contactNumberFieldForReceivingSpace("contactNumber",initValue);
	}
	public WarehouseForm contactNumberFieldForReceivingSpace(){
		return contactNumberFieldForReceivingSpace("contactNumber","");
	}


	public WarehouseForm descriptionFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  descriptionFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm descriptionFieldForReceivingSpace(String initValue){
		return descriptionFieldForReceivingSpace("description",initValue);
	}
	public WarehouseForm descriptionFieldForReceivingSpace(){
		return descriptionFieldForReceivingSpace("description","");
	}


	public WarehouseForm totalAreaFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaFieldForReceivingSpace(String initValue){
		return totalAreaFieldForReceivingSpace("totalArea",initValue);
	}
	public WarehouseForm totalAreaFieldForReceivingSpace(){
		return totalAreaFieldForReceivingSpace("totalArea","");
	}


	public WarehouseForm warehouseIdFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdFieldForReceivingSpace(String initValue){
		return warehouseIdFieldForReceivingSpace("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdFieldForReceivingSpace(){
		return warehouseIdFieldForReceivingSpace("warehouseId","");
	}


	public WarehouseForm latitudeFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  latitudeFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeFieldForReceivingSpace(String initValue){
		return latitudeFieldForReceivingSpace("latitude",initValue);
	}
	public WarehouseForm latitudeFieldForReceivingSpace(){
		return latitudeFieldForReceivingSpace("latitude","");
	}


	public WarehouseForm longitudeFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  longitudeFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeFieldForReceivingSpace(String initValue){
		return longitudeFieldForReceivingSpace("longitude",initValue);
	}
	public WarehouseForm longitudeFieldForReceivingSpace(){
		return longitudeFieldForReceivingSpace("longitude","");
	}


	public WarehouseForm lastUpdateTimeFieldForReceivingSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForReceivingSpace(String initValue){
		return lastUpdateTimeFieldForReceivingSpace("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForReceivingSpace(){
		return lastUpdateTimeFieldForReceivingSpace("lastUpdateTime","");
	}


	public WarehouseForm shippingSpaceIdFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  idFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm shippingSpaceIdFieldForShippingSpace(String initValue){
		return shippingSpaceIdFieldForShippingSpace("shippingSpaceId",initValue);
	}
	public WarehouseForm shippingSpaceIdFieldForShippingSpace(){
		return shippingSpaceIdFieldForShippingSpace("shippingSpaceId","");
	}


	public WarehouseForm locationFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  locationFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationFieldForShippingSpace(String initValue){
		return locationFieldForShippingSpace("location",initValue);
	}
	public WarehouseForm locationFieldForShippingSpace(){
		return locationFieldForShippingSpace("location","");
	}


	public WarehouseForm contactNumberFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberFieldForShippingSpace(String initValue){
		return contactNumberFieldForShippingSpace("contactNumber",initValue);
	}
	public WarehouseForm contactNumberFieldForShippingSpace(){
		return contactNumberFieldForShippingSpace("contactNumber","");
	}


	public WarehouseForm totalAreaFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaFieldForShippingSpace(String initValue){
		return totalAreaFieldForShippingSpace("totalArea",initValue);
	}
	public WarehouseForm totalAreaFieldForShippingSpace(){
		return totalAreaFieldForShippingSpace("totalArea","");
	}


	public WarehouseForm warehouseIdFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdFieldForShippingSpace(String initValue){
		return warehouseIdFieldForShippingSpace("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdFieldForShippingSpace(){
		return warehouseIdFieldForShippingSpace("warehouseId","");
	}


	public WarehouseForm latitudeFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  latitudeFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeFieldForShippingSpace(String initValue){
		return latitudeFieldForShippingSpace("latitude",initValue);
	}
	public WarehouseForm latitudeFieldForShippingSpace(){
		return latitudeFieldForShippingSpace("latitude","");
	}


	public WarehouseForm longitudeFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  longitudeFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeFieldForShippingSpace(String initValue){
		return longitudeFieldForShippingSpace("longitude",initValue);
	}
	public WarehouseForm longitudeFieldForShippingSpace(){
		return longitudeFieldForShippingSpace("longitude","");
	}


	public WarehouseForm descriptionFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  descriptionFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm descriptionFieldForShippingSpace(String initValue){
		return descriptionFieldForShippingSpace("description",initValue);
	}
	public WarehouseForm descriptionFieldForShippingSpace(){
		return descriptionFieldForShippingSpace("description","");
	}


	public WarehouseForm lastUpdateTimeFieldForShippingSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForShippingSpace(String initValue){
		return lastUpdateTimeFieldForShippingSpace("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForShippingSpace(){
		return lastUpdateTimeFieldForShippingSpace("lastUpdateTime","");
	}


	public WarehouseForm damageSpaceIdFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  idFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm damageSpaceIdFieldForDamageSpace(String initValue){
		return damageSpaceIdFieldForDamageSpace("damageSpaceId",initValue);
	}
	public WarehouseForm damageSpaceIdFieldForDamageSpace(){
		return damageSpaceIdFieldForDamageSpace("damageSpaceId","");
	}


	public WarehouseForm locationFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  locationFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm locationFieldForDamageSpace(String initValue){
		return locationFieldForDamageSpace("location",initValue);
	}
	public WarehouseForm locationFieldForDamageSpace(){
		return locationFieldForDamageSpace("location","");
	}


	public WarehouseForm contactNumberFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm contactNumberFieldForDamageSpace(String initValue){
		return contactNumberFieldForDamageSpace("contactNumber",initValue);
	}
	public WarehouseForm contactNumberFieldForDamageSpace(){
		return contactNumberFieldForDamageSpace("contactNumber","");
	}


	public WarehouseForm totalAreaFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm totalAreaFieldForDamageSpace(String initValue){
		return totalAreaFieldForDamageSpace("totalArea",initValue);
	}
	public WarehouseForm totalAreaFieldForDamageSpace(){
		return totalAreaFieldForDamageSpace("totalArea","");
	}


	public WarehouseForm latitudeFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  latitudeFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm latitudeFieldForDamageSpace(String initValue){
		return latitudeFieldForDamageSpace("latitude",initValue);
	}
	public WarehouseForm latitudeFieldForDamageSpace(){
		return latitudeFieldForDamageSpace("latitude","");
	}


	public WarehouseForm longitudeFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  longitudeFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm longitudeFieldForDamageSpace(String initValue){
		return longitudeFieldForDamageSpace("longitude",initValue);
	}
	public WarehouseForm longitudeFieldForDamageSpace(){
		return longitudeFieldForDamageSpace("longitude","");
	}


	public WarehouseForm warehouseIdFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseIdFieldForDamageSpace(String initValue){
		return warehouseIdFieldForDamageSpace("warehouseId",initValue);
	}
	public WarehouseForm warehouseIdFieldForDamageSpace(){
		return warehouseIdFieldForDamageSpace("warehouseId","");
	}


	public WarehouseForm lastUpdateTimeFieldForDamageSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForDamageSpace(String initValue){
		return lastUpdateTimeFieldForDamageSpace("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForDamageSpace(){
		return lastUpdateTimeFieldForDamageSpace("lastUpdateTime","");
	}


	public WarehouseForm warehouseAssetIdFieldForWarehouseAsset(String parameterName, String initValue){
		FormField field =  idFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm warehouseAssetIdFieldForWarehouseAsset(String initValue){
		return warehouseAssetIdFieldForWarehouseAsset("warehouseAssetId",initValue);
	}
	public WarehouseForm warehouseAssetIdFieldForWarehouseAsset(){
		return warehouseAssetIdFieldForWarehouseAsset("warehouseAssetId","");
	}


	public WarehouseForm nameFieldForWarehouseAsset(String parameterName, String initValue){
		FormField field =  nameFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm nameFieldForWarehouseAsset(String initValue){
		return nameFieldForWarehouseAsset("name",initValue);
	}
	public WarehouseForm nameFieldForWarehouseAsset(){
		return nameFieldForWarehouseAsset("name","");
	}


	public WarehouseForm positionFieldForWarehouseAsset(String parameterName, String initValue){
		FormField field =  positionFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm positionFieldForWarehouseAsset(String initValue){
		return positionFieldForWarehouseAsset("position",initValue);
	}
	public WarehouseForm positionFieldForWarehouseAsset(){
		return positionFieldForWarehouseAsset("position","");
	}


	public WarehouseForm ownerIdFieldForWarehouseAsset(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm ownerIdFieldForWarehouseAsset(String initValue){
		return ownerIdFieldForWarehouseAsset("ownerId",initValue);
	}
	public WarehouseForm ownerIdFieldForWarehouseAsset(){
		return ownerIdFieldForWarehouseAsset("ownerId","");
	}


	public WarehouseForm lastUpdateTimeFieldForWarehouseAsset(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseForm lastUpdateTimeFieldForWarehouseAsset(String initValue){
		return lastUpdateTimeFieldForWarehouseAsset("lastUpdateTime",initValue);
	}
	public WarehouseForm lastUpdateTimeFieldForWarehouseAsset(){
		return lastUpdateTimeFieldForWarehouseAsset("lastUpdateTime","");
	}

	

	
 	public WarehouseForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/warehouseId/");
		this.addFormAction(action);
		return this;
	}

 

	public WarehouseForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



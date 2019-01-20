package com.doublechaintech.retailscm.shippingspace;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ShippingSpaceForm extends BaseForm {
	
	
	public ShippingSpaceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ShippingSpaceForm shippingSpaceIdField(String parameterName, String initValue){
		FormField field = idFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm shippingSpaceIdField(String initValue){
		return shippingSpaceIdField("shippingSpaceId",initValue);
	}
	public ShippingSpaceForm shippingSpaceIdField(){
		return shippingSpaceIdField("shippingSpaceId","");
	}


	public ShippingSpaceForm locationField(String parameterName, String initValue){
		FormField field = locationFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public ShippingSpaceForm locationField(){
		return locationField("location","");
	}


	public ShippingSpaceForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public ShippingSpaceForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public ShippingSpaceForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public ShippingSpaceForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public ShippingSpaceForm warehouseIdField(String parameterName, String initValue){
		FormField field = warehouseIdFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public ShippingSpaceForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}


	public ShippingSpaceForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public ShippingSpaceForm latitudeField(){
		return latitudeField("latitude","");
	}


	public ShippingSpaceForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public ShippingSpaceForm longitudeField(){
		return longitudeField("longitude","");
	}


	public ShippingSpaceForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public ShippingSpaceForm descriptionField(){
		return descriptionField("description","");
	}


	public ShippingSpaceForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromShippingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ShippingSpaceForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public ShippingSpaceForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public ShippingSpaceForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public ShippingSpaceForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public ShippingSpaceForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public ShippingSpaceForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public ShippingSpaceForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public ShippingSpaceForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public ShippingSpaceForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public ShippingSpaceForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public ShippingSpaceForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public ShippingSpaceForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public ShippingSpaceForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public ShippingSpaceForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public ShippingSpaceForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public ShippingSpaceForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ShippingSpaceForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public ShippingSpaceForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	



	public ShippingSpaceForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public ShippingSpaceForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public ShippingSpaceForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public ShippingSpaceForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public ShippingSpaceForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public ShippingSpaceForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public ShippingSpaceForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public ShippingSpaceForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public ShippingSpaceForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public ShippingSpaceForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public ShippingSpaceForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public ShippingSpaceForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public ShippingSpaceForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public ShippingSpaceForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public ShippingSpaceForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public ShippingSpaceForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public ShippingSpaceForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public ShippingSpaceForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public ShippingSpaceForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public ShippingSpaceForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public ShippingSpaceForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public ShippingSpaceForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public ShippingSpaceForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public ShippingSpaceForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public ShippingSpaceForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public ShippingSpaceForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public ShippingSpaceForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public ShippingSpaceForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public ShippingSpaceForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public ShippingSpaceForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public ShippingSpaceForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public ShippingSpaceForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public ShippingSpaceForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ShippingSpaceForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public ShippingSpaceForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public ShippingSpaceForm transferToAnotherWarehouseAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWarehouse/shippingSpaceId/");
		this.addFormAction(action);
		return this;
	}

 

	public ShippingSpaceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



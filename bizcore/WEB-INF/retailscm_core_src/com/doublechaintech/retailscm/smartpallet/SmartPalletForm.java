package com.doublechaintech.retailscm.smartpallet;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SmartPalletForm extends BaseForm {
	
	
	public SmartPalletForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SmartPalletForm smartPalletIdField(String parameterName, String initValue){
		FormField field = idFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm smartPalletIdField(String initValue){
		return smartPalletIdField("smartPalletId",initValue);
	}
	public SmartPalletForm smartPalletIdField(){
		return smartPalletIdField("smartPalletId","");
	}


	public SmartPalletForm locationField(String parameterName, String initValue){
		FormField field = locationFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public SmartPalletForm locationField(){
		return locationField("location","");
	}


	public SmartPalletForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public SmartPalletForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public SmartPalletForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public SmartPalletForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public SmartPalletForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public SmartPalletForm latitudeField(){
		return latitudeField("latitude","");
	}


	public SmartPalletForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public SmartPalletForm longitudeField(){
		return longitudeField("longitude","");
	}


	public SmartPalletForm warehouseIdField(String parameterName, String initValue){
		FormField field = warehouseIdFromSmartPallet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public SmartPalletForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}

	
	


	public SmartPalletForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public SmartPalletForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public SmartPalletForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public SmartPalletForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public SmartPalletForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public SmartPalletForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public SmartPalletForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public SmartPalletForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public SmartPalletForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public SmartPalletForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public SmartPalletForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public SmartPalletForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public SmartPalletForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public SmartPalletForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public SmartPalletForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SmartPalletForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public SmartPalletForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	



	public SmartPalletForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public SmartPalletForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public SmartPalletForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public SmartPalletForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public SmartPalletForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public SmartPalletForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public SmartPalletForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public SmartPalletForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public SmartPalletForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public SmartPalletForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public SmartPalletForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public SmartPalletForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public SmartPalletForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public SmartPalletForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public SmartPalletForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public SmartPalletForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public SmartPalletForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public SmartPalletForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public SmartPalletForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public SmartPalletForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public SmartPalletForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public SmartPalletForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public SmartPalletForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public SmartPalletForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public SmartPalletForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public SmartPalletForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public SmartPalletForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public SmartPalletForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public SmartPalletForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public SmartPalletForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public SmartPalletForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public SmartPalletForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public SmartPalletForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SmartPalletForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public SmartPalletForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public SmartPalletForm transferToAnotherWarehouseAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWarehouse/smartPalletId/");
		this.addFormAction(action);
		return this;
	}

 

	public SmartPalletForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.receivingspace;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ReceivingSpaceForm extends BaseForm {
	
	
	public ReceivingSpaceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ReceivingSpaceForm receivingSpaceIdField(String parameterName, String initValue){
		FormField field = idFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm receivingSpaceIdField(String initValue){
		return receivingSpaceIdField("receivingSpaceId",initValue);
	}
	public ReceivingSpaceForm receivingSpaceIdField(){
		return receivingSpaceIdField("receivingSpaceId","");
	}


	public ReceivingSpaceForm locationField(String parameterName, String initValue){
		FormField field = locationFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public ReceivingSpaceForm locationField(){
		return locationField("location","");
	}


	public ReceivingSpaceForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public ReceivingSpaceForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public ReceivingSpaceForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public ReceivingSpaceForm descriptionField(){
		return descriptionField("description","");
	}


	public ReceivingSpaceForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public ReceivingSpaceForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public ReceivingSpaceForm warehouseIdField(String parameterName, String initValue){
		FormField field = warehouseIdFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public ReceivingSpaceForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}


	public ReceivingSpaceForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public ReceivingSpaceForm latitudeField(){
		return latitudeField("latitude","");
	}


	public ReceivingSpaceForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromReceivingSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public ReceivingSpaceForm longitudeField(){
		return longitudeField("longitude","");
	}

	
	


	public ReceivingSpaceForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public ReceivingSpaceForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public ReceivingSpaceForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public ReceivingSpaceForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public ReceivingSpaceForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public ReceivingSpaceForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public ReceivingSpaceForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public ReceivingSpaceForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public ReceivingSpaceForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public ReceivingSpaceForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public ReceivingSpaceForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public ReceivingSpaceForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public ReceivingSpaceForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public ReceivingSpaceForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public ReceivingSpaceForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ReceivingSpaceForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public ReceivingSpaceForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	



	public ReceivingSpaceForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public ReceivingSpaceForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public ReceivingSpaceForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public ReceivingSpaceForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public ReceivingSpaceForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public ReceivingSpaceForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public ReceivingSpaceForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public ReceivingSpaceForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public ReceivingSpaceForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public ReceivingSpaceForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public ReceivingSpaceForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public ReceivingSpaceForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public ReceivingSpaceForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public ReceivingSpaceForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public ReceivingSpaceForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public ReceivingSpaceForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public ReceivingSpaceForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public ReceivingSpaceForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public ReceivingSpaceForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public ReceivingSpaceForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public ReceivingSpaceForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public ReceivingSpaceForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public ReceivingSpaceForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public ReceivingSpaceForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public ReceivingSpaceForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public ReceivingSpaceForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public ReceivingSpaceForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public ReceivingSpaceForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public ReceivingSpaceForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public ReceivingSpaceForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public ReceivingSpaceForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public ReceivingSpaceForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public ReceivingSpaceForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ReceivingSpaceForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public ReceivingSpaceForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public ReceivingSpaceForm transferToAnotherWarehouseAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWarehouse/receivingSpaceId/");
		this.addFormAction(action);
		return this;
	}

 

	public ReceivingSpaceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



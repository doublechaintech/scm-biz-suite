package com.doublechaintech.retailscm.storagespace;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class StorageSpaceForm extends BaseForm {
	
	
	public StorageSpaceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public StorageSpaceForm storageSpaceIdField(String parameterName, String initValue){
		FormField field = idFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm storageSpaceIdField(String initValue){
		return storageSpaceIdField("storageSpaceId",initValue);
	}
	public StorageSpaceForm storageSpaceIdField(){
		return storageSpaceIdField("storageSpaceId","");
	}


	public StorageSpaceForm locationField(String parameterName, String initValue){
		FormField field = locationFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public StorageSpaceForm locationField(){
		return locationField("location","");
	}


	public StorageSpaceForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public StorageSpaceForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public StorageSpaceForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public StorageSpaceForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public StorageSpaceForm warehouseIdField(String parameterName, String initValue){
		FormField field = warehouseIdFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public StorageSpaceForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}


	public StorageSpaceForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public StorageSpaceForm latitudeField(){
		return latitudeField("latitude","");
	}


	public StorageSpaceForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public StorageSpaceForm longitudeField(){
		return longitudeField("longitude","");
	}


	public StorageSpaceForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromStorageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public StorageSpaceForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public StorageSpaceForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public StorageSpaceForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public StorageSpaceForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public StorageSpaceForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public StorageSpaceForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public StorageSpaceForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public StorageSpaceForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public StorageSpaceForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public StorageSpaceForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public StorageSpaceForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public StorageSpaceForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public StorageSpaceForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public StorageSpaceForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public StorageSpaceForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public StorageSpaceForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StorageSpaceForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public StorageSpaceForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	



	public StorageSpaceForm goodsShelfIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  idFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm goodsShelfIdFieldForGoodsShelf(String initValue){
		return goodsShelfIdFieldForGoodsShelf("goodsShelfId",initValue);
	}
	public StorageSpaceForm goodsShelfIdFieldForGoodsShelf(){
		return goodsShelfIdFieldForGoodsShelf("goodsShelfId","");
	}


	public StorageSpaceForm locationFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  locationFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm locationFieldForGoodsShelf(String initValue){
		return locationFieldForGoodsShelf("location",initValue);
	}
	public StorageSpaceForm locationFieldForGoodsShelf(){
		return locationFieldForGoodsShelf("location","");
	}


	public StorageSpaceForm storageSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  storageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm storageSpaceIdFieldForGoodsShelf(String initValue){
		return storageSpaceIdFieldForGoodsShelf("storageSpaceId",initValue);
	}
	public StorageSpaceForm storageSpaceIdFieldForGoodsShelf(){
		return storageSpaceIdFieldForGoodsShelf("storageSpaceId","");
	}


	public StorageSpaceForm supplierSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  supplierSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm supplierSpaceIdFieldForGoodsShelf(String initValue){
		return supplierSpaceIdFieldForGoodsShelf("supplierSpaceId",initValue);
	}
	public StorageSpaceForm supplierSpaceIdFieldForGoodsShelf(){
		return supplierSpaceIdFieldForGoodsShelf("supplierSpaceId","");
	}


	public StorageSpaceForm damageSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  damageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm damageSpaceIdFieldForGoodsShelf(String initValue){
		return damageSpaceIdFieldForGoodsShelf("damageSpaceId",initValue);
	}
	public StorageSpaceForm damageSpaceIdFieldForGoodsShelf(){
		return damageSpaceIdFieldForGoodsShelf("damageSpaceId","");
	}


	public StorageSpaceForm lastUpdateTimeFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StorageSpaceForm lastUpdateTimeFieldForGoodsShelf(String initValue){
		return lastUpdateTimeFieldForGoodsShelf("lastUpdateTime",initValue);
	}
	public StorageSpaceForm lastUpdateTimeFieldForGoodsShelf(){
		return lastUpdateTimeFieldForGoodsShelf("lastUpdateTime","");
	}

	

	
 	public StorageSpaceForm transferToAnotherWarehouseAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWarehouse/storageSpaceId/");
		this.addFormAction(action);
		return this;
	}

 

	public StorageSpaceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



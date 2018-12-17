package com.doublechaintech.retailscm.warehouseasset;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class WarehouseAssetForm extends BaseForm {
	
	
	public WarehouseAssetForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public WarehouseAssetForm warehouseAssetIdField(String parameterName, String initValue){
		FormField field = idFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseAssetForm warehouseAssetIdField(String initValue){
		return warehouseAssetIdField("warehouseAssetId",initValue);
	}
	public WarehouseAssetForm warehouseAssetIdField(){
		return warehouseAssetIdField("warehouseAssetId","");
	}


	public WarehouseAssetForm nameField(String parameterName, String initValue){
		FormField field = nameFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseAssetForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public WarehouseAssetForm nameField(){
		return nameField("name","");
	}


	public WarehouseAssetForm positionField(String parameterName, String initValue){
		FormField field = positionFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseAssetForm positionField(String initValue){
		return positionField("position",initValue);
	}
	public WarehouseAssetForm positionField(){
		return positionField("position","");
	}


	public WarehouseAssetForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromWarehouseAsset(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WarehouseAssetForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public WarehouseAssetForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public WarehouseAssetForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public WarehouseAssetForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public WarehouseAssetForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public WarehouseAssetForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public WarehouseAssetForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public WarehouseAssetForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public WarehouseAssetForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public WarehouseAssetForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public WarehouseAssetForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public WarehouseAssetForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public WarehouseAssetForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public WarehouseAssetForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public WarehouseAssetForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public WarehouseAssetForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public WarehouseAssetForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WarehouseAssetForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public WarehouseAssetForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	


	

	
 	public WarehouseAssetForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/warehouseAssetId/");
		this.addFormAction(action);
		return this;
	}

 

	public WarehouseAssetForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



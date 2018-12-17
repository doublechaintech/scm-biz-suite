package com.doublechaintech.retailscm.damagespace;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class DamageSpaceForm extends BaseForm {
	
	
	public DamageSpaceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public DamageSpaceForm damageSpaceIdField(String parameterName, String initValue){
		FormField field = idFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm damageSpaceIdField(String initValue){
		return damageSpaceIdField("damageSpaceId",initValue);
	}
	public DamageSpaceForm damageSpaceIdField(){
		return damageSpaceIdField("damageSpaceId","");
	}


	public DamageSpaceForm locationField(String parameterName, String initValue){
		FormField field = locationFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public DamageSpaceForm locationField(){
		return locationField("location","");
	}


	public DamageSpaceForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public DamageSpaceForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public DamageSpaceForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public DamageSpaceForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public DamageSpaceForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public DamageSpaceForm latitudeField(){
		return latitudeField("latitude","");
	}


	public DamageSpaceForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public DamageSpaceForm longitudeField(){
		return longitudeField("longitude","");
	}


	public DamageSpaceForm warehouseIdField(String parameterName, String initValue){
		FormField field = warehouseIdFromDamageSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public DamageSpaceForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}

	
	


	public DamageSpaceForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public DamageSpaceForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public DamageSpaceForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public DamageSpaceForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public DamageSpaceForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public DamageSpaceForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public DamageSpaceForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public DamageSpaceForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public DamageSpaceForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public DamageSpaceForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public DamageSpaceForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public DamageSpaceForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public DamageSpaceForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public DamageSpaceForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public DamageSpaceForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public DamageSpaceForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public DamageSpaceForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	



	public DamageSpaceForm goodsShelfIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  idFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm goodsShelfIdFieldForGoodsShelf(String initValue){
		return goodsShelfIdFieldForGoodsShelf("goodsShelfId",initValue);
	}
	public DamageSpaceForm goodsShelfIdFieldForGoodsShelf(){
		return goodsShelfIdFieldForGoodsShelf("goodsShelfId","");
	}


	public DamageSpaceForm locationFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  locationFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm locationFieldForGoodsShelf(String initValue){
		return locationFieldForGoodsShelf("location",initValue);
	}
	public DamageSpaceForm locationFieldForGoodsShelf(){
		return locationFieldForGoodsShelf("location","");
	}


	public DamageSpaceForm storageSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  storageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm storageSpaceIdFieldForGoodsShelf(String initValue){
		return storageSpaceIdFieldForGoodsShelf("storageSpaceId",initValue);
	}
	public DamageSpaceForm storageSpaceIdFieldForGoodsShelf(){
		return storageSpaceIdFieldForGoodsShelf("storageSpaceId","");
	}


	public DamageSpaceForm supplierSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  supplierSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm supplierSpaceIdFieldForGoodsShelf(String initValue){
		return supplierSpaceIdFieldForGoodsShelf("supplierSpaceId",initValue);
	}
	public DamageSpaceForm supplierSpaceIdFieldForGoodsShelf(){
		return supplierSpaceIdFieldForGoodsShelf("supplierSpaceId","");
	}


	public DamageSpaceForm damageSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  damageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public DamageSpaceForm damageSpaceIdFieldForGoodsShelf(String initValue){
		return damageSpaceIdFieldForGoodsShelf("damageSpaceId",initValue);
	}
	public DamageSpaceForm damageSpaceIdFieldForGoodsShelf(){
		return damageSpaceIdFieldForGoodsShelf("damageSpaceId","");
	}

	

	
 	public DamageSpaceForm transferToAnotherWarehouseAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWarehouse/damageSpaceId/");
		this.addFormAction(action);
		return this;
	}

 

	public DamageSpaceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



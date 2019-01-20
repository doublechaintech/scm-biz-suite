package com.doublechaintech.retailscm.supplierspace;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplierSpaceForm extends BaseForm {
	
	
	public SupplierSpaceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplierSpaceForm supplierSpaceIdField(String parameterName, String initValue){
		FormField field = idFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm supplierSpaceIdField(String initValue){
		return supplierSpaceIdField("supplierSpaceId",initValue);
	}
	public SupplierSpaceForm supplierSpaceIdField(){
		return supplierSpaceIdField("supplierSpaceId","");
	}


	public SupplierSpaceForm locationField(String parameterName, String initValue){
		FormField field = locationFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public SupplierSpaceForm locationField(){
		return locationField("location","");
	}


	public SupplierSpaceForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public SupplierSpaceForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public SupplierSpaceForm totalAreaField(String parameterName, String initValue){
		FormField field = totalAreaFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm totalAreaField(String initValue){
		return totalAreaField("totalArea",initValue);
	}
	public SupplierSpaceForm totalAreaField(){
		return totalAreaField("totalArea","");
	}


	public SupplierSpaceForm warehouseIdField(String parameterName, String initValue){
		FormField field = warehouseIdFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm warehouseIdField(String initValue){
		return warehouseIdField("warehouseId",initValue);
	}
	public SupplierSpaceForm warehouseIdField(){
		return warehouseIdField("warehouseId","");
	}


	public SupplierSpaceForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public SupplierSpaceForm latitudeField(){
		return latitudeField("latitude","");
	}


	public SupplierSpaceForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public SupplierSpaceForm longitudeField(){
		return longitudeField("longitude","");
	}


	public SupplierSpaceForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromSupplierSpace(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public SupplierSpaceForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public SupplierSpaceForm warehouseIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm warehouseIdFieldOfWarehouse(String initValue){
		return warehouseIdFieldOfWarehouse("warehouseId",initValue);
	}
	public SupplierSpaceForm warehouseIdFieldOfWarehouse(){
		return warehouseIdFieldOfWarehouse("warehouseId","");
	}


	public SupplierSpaceForm locationFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm locationFieldOfWarehouse(String initValue){
		return locationFieldOfWarehouse("location",initValue);
	}
	public SupplierSpaceForm locationFieldOfWarehouse(){
		return locationFieldOfWarehouse("location","");
	}


	public SupplierSpaceForm contactNumberFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm contactNumberFieldOfWarehouse(String initValue){
		return contactNumberFieldOfWarehouse("contactNumber",initValue);
	}
	public SupplierSpaceForm contactNumberFieldOfWarehouse(){
		return contactNumberFieldOfWarehouse("contactNumber","");
	}


	public SupplierSpaceForm totalAreaFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm totalAreaFieldOfWarehouse(String initValue){
		return totalAreaFieldOfWarehouse("totalArea",initValue);
	}
	public SupplierSpaceForm totalAreaFieldOfWarehouse(){
		return totalAreaFieldOfWarehouse("totalArea","");
	}


	public SupplierSpaceForm ownerIdFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm ownerIdFieldOfWarehouse(String initValue){
		return ownerIdFieldOfWarehouse("ownerId",initValue);
	}
	public SupplierSpaceForm ownerIdFieldOfWarehouse(){
		return ownerIdFieldOfWarehouse("ownerId","");
	}


	public SupplierSpaceForm latitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm latitudeFieldOfWarehouse(String initValue){
		return latitudeFieldOfWarehouse("latitude",initValue);
	}
	public SupplierSpaceForm latitudeFieldOfWarehouse(){
		return latitudeFieldOfWarehouse("latitude","");
	}


	public SupplierSpaceForm longitudeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm longitudeFieldOfWarehouse(String initValue){
		return longitudeFieldOfWarehouse("longitude",initValue);
	}
	public SupplierSpaceForm longitudeFieldOfWarehouse(){
		return longitudeFieldOfWarehouse("longitude","");
	}


	public SupplierSpaceForm lastUpdateTimeFieldOfWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierSpaceForm lastUpdateTimeFieldOfWarehouse(String initValue){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime",initValue);
	}
	public SupplierSpaceForm lastUpdateTimeFieldOfWarehouse(){
		return lastUpdateTimeFieldOfWarehouse("lastUpdateTime","");
	}

	



	public SupplierSpaceForm goodsShelfIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  idFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm goodsShelfIdFieldForGoodsShelf(String initValue){
		return goodsShelfIdFieldForGoodsShelf("goodsShelfId",initValue);
	}
	public SupplierSpaceForm goodsShelfIdFieldForGoodsShelf(){
		return goodsShelfIdFieldForGoodsShelf("goodsShelfId","");
	}


	public SupplierSpaceForm locationFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  locationFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm locationFieldForGoodsShelf(String initValue){
		return locationFieldForGoodsShelf("location",initValue);
	}
	public SupplierSpaceForm locationFieldForGoodsShelf(){
		return locationFieldForGoodsShelf("location","");
	}


	public SupplierSpaceForm storageSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  storageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm storageSpaceIdFieldForGoodsShelf(String initValue){
		return storageSpaceIdFieldForGoodsShelf("storageSpaceId",initValue);
	}
	public SupplierSpaceForm storageSpaceIdFieldForGoodsShelf(){
		return storageSpaceIdFieldForGoodsShelf("storageSpaceId","");
	}


	public SupplierSpaceForm supplierSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  supplierSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm supplierSpaceIdFieldForGoodsShelf(String initValue){
		return supplierSpaceIdFieldForGoodsShelf("supplierSpaceId",initValue);
	}
	public SupplierSpaceForm supplierSpaceIdFieldForGoodsShelf(){
		return supplierSpaceIdFieldForGoodsShelf("supplierSpaceId","");
	}


	public SupplierSpaceForm damageSpaceIdFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  damageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm damageSpaceIdFieldForGoodsShelf(String initValue){
		return damageSpaceIdFieldForGoodsShelf("damageSpaceId",initValue);
	}
	public SupplierSpaceForm damageSpaceIdFieldForGoodsShelf(){
		return damageSpaceIdFieldForGoodsShelf("damageSpaceId","");
	}


	public SupplierSpaceForm lastUpdateTimeFieldForGoodsShelf(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierSpaceForm lastUpdateTimeFieldForGoodsShelf(String initValue){
		return lastUpdateTimeFieldForGoodsShelf("lastUpdateTime",initValue);
	}
	public SupplierSpaceForm lastUpdateTimeFieldForGoodsShelf(){
		return lastUpdateTimeFieldForGoodsShelf("lastUpdateTime","");
	}

	

	
 	public SupplierSpaceForm transferToAnotherWarehouseAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWarehouse/supplierSpaceId/");
		this.addFormAction(action);
		return this;
	}

 

	public SupplierSpaceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



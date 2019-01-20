package com.doublechaintech.retailscm.goodsshelf;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsShelfForm extends BaseForm {
	
	
	public GoodsShelfForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsShelfForm goodsShelfIdField(String parameterName, String initValue){
		FormField field = idFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm goodsShelfIdField(String initValue){
		return goodsShelfIdField("goodsShelfId",initValue);
	}
	public GoodsShelfForm goodsShelfIdField(){
		return goodsShelfIdField("goodsShelfId","");
	}


	public GoodsShelfForm locationField(String parameterName, String initValue){
		FormField field = locationFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public GoodsShelfForm locationField(){
		return locationField("location","");
	}


	public GoodsShelfForm storageSpaceIdField(String parameterName, String initValue){
		FormField field = storageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm storageSpaceIdField(String initValue){
		return storageSpaceIdField("storageSpaceId",initValue);
	}
	public GoodsShelfForm storageSpaceIdField(){
		return storageSpaceIdField("storageSpaceId","");
	}


	public GoodsShelfForm supplierSpaceIdField(String parameterName, String initValue){
		FormField field = supplierSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm supplierSpaceIdField(String initValue){
		return supplierSpaceIdField("supplierSpaceId",initValue);
	}
	public GoodsShelfForm supplierSpaceIdField(){
		return supplierSpaceIdField("supplierSpaceId","");
	}


	public GoodsShelfForm damageSpaceIdField(String parameterName, String initValue){
		FormField field = damageSpaceIdFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm damageSpaceIdField(String initValue){
		return damageSpaceIdField("damageSpaceId",initValue);
	}
	public GoodsShelfForm damageSpaceIdField(){
		return damageSpaceIdField("damageSpaceId","");
	}


	public GoodsShelfForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromGoodsShelf(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public GoodsShelfForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public GoodsShelfForm storageSpaceIdFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  idFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm storageSpaceIdFieldOfStorageSpace(String initValue){
		return storageSpaceIdFieldOfStorageSpace("storageSpaceId",initValue);
	}
	public GoodsShelfForm storageSpaceIdFieldOfStorageSpace(){
		return storageSpaceIdFieldOfStorageSpace("storageSpaceId","");
	}


	public GoodsShelfForm locationFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  locationFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm locationFieldOfStorageSpace(String initValue){
		return locationFieldOfStorageSpace("location",initValue);
	}
	public GoodsShelfForm locationFieldOfStorageSpace(){
		return locationFieldOfStorageSpace("location","");
	}


	public GoodsShelfForm contactNumberFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm contactNumberFieldOfStorageSpace(String initValue){
		return contactNumberFieldOfStorageSpace("contactNumber",initValue);
	}
	public GoodsShelfForm contactNumberFieldOfStorageSpace(){
		return contactNumberFieldOfStorageSpace("contactNumber","");
	}


	public GoodsShelfForm totalAreaFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm totalAreaFieldOfStorageSpace(String initValue){
		return totalAreaFieldOfStorageSpace("totalArea",initValue);
	}
	public GoodsShelfForm totalAreaFieldOfStorageSpace(){
		return totalAreaFieldOfStorageSpace("totalArea","");
	}


	public GoodsShelfForm warehouseIdFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm warehouseIdFieldOfStorageSpace(String initValue){
		return warehouseIdFieldOfStorageSpace("warehouseId",initValue);
	}
	public GoodsShelfForm warehouseIdFieldOfStorageSpace(){
		return warehouseIdFieldOfStorageSpace("warehouseId","");
	}


	public GoodsShelfForm latitudeFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  latitudeFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm latitudeFieldOfStorageSpace(String initValue){
		return latitudeFieldOfStorageSpace("latitude",initValue);
	}
	public GoodsShelfForm latitudeFieldOfStorageSpace(){
		return latitudeFieldOfStorageSpace("latitude","");
	}


	public GoodsShelfForm longitudeFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  longitudeFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm longitudeFieldOfStorageSpace(String initValue){
		return longitudeFieldOfStorageSpace("longitude",initValue);
	}
	public GoodsShelfForm longitudeFieldOfStorageSpace(){
		return longitudeFieldOfStorageSpace("longitude","");
	}


	public GoodsShelfForm lastUpdateTimeFieldOfStorageSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromStorageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm lastUpdateTimeFieldOfStorageSpace(String initValue){
		return lastUpdateTimeFieldOfStorageSpace("lastUpdateTime",initValue);
	}
	public GoodsShelfForm lastUpdateTimeFieldOfStorageSpace(){
		return lastUpdateTimeFieldOfStorageSpace("lastUpdateTime","");
	}


	public GoodsShelfForm supplierSpaceIdFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  idFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm supplierSpaceIdFieldOfSupplierSpace(String initValue){
		return supplierSpaceIdFieldOfSupplierSpace("supplierSpaceId",initValue);
	}
	public GoodsShelfForm supplierSpaceIdFieldOfSupplierSpace(){
		return supplierSpaceIdFieldOfSupplierSpace("supplierSpaceId","");
	}


	public GoodsShelfForm locationFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  locationFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm locationFieldOfSupplierSpace(String initValue){
		return locationFieldOfSupplierSpace("location",initValue);
	}
	public GoodsShelfForm locationFieldOfSupplierSpace(){
		return locationFieldOfSupplierSpace("location","");
	}


	public GoodsShelfForm contactNumberFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm contactNumberFieldOfSupplierSpace(String initValue){
		return contactNumberFieldOfSupplierSpace("contactNumber",initValue);
	}
	public GoodsShelfForm contactNumberFieldOfSupplierSpace(){
		return contactNumberFieldOfSupplierSpace("contactNumber","");
	}


	public GoodsShelfForm totalAreaFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm totalAreaFieldOfSupplierSpace(String initValue){
		return totalAreaFieldOfSupplierSpace("totalArea",initValue);
	}
	public GoodsShelfForm totalAreaFieldOfSupplierSpace(){
		return totalAreaFieldOfSupplierSpace("totalArea","");
	}


	public GoodsShelfForm warehouseIdFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm warehouseIdFieldOfSupplierSpace(String initValue){
		return warehouseIdFieldOfSupplierSpace("warehouseId",initValue);
	}
	public GoodsShelfForm warehouseIdFieldOfSupplierSpace(){
		return warehouseIdFieldOfSupplierSpace("warehouseId","");
	}


	public GoodsShelfForm latitudeFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  latitudeFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm latitudeFieldOfSupplierSpace(String initValue){
		return latitudeFieldOfSupplierSpace("latitude",initValue);
	}
	public GoodsShelfForm latitudeFieldOfSupplierSpace(){
		return latitudeFieldOfSupplierSpace("latitude","");
	}


	public GoodsShelfForm longitudeFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  longitudeFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm longitudeFieldOfSupplierSpace(String initValue){
		return longitudeFieldOfSupplierSpace("longitude",initValue);
	}
	public GoodsShelfForm longitudeFieldOfSupplierSpace(){
		return longitudeFieldOfSupplierSpace("longitude","");
	}


	public GoodsShelfForm lastUpdateTimeFieldOfSupplierSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplierSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm lastUpdateTimeFieldOfSupplierSpace(String initValue){
		return lastUpdateTimeFieldOfSupplierSpace("lastUpdateTime",initValue);
	}
	public GoodsShelfForm lastUpdateTimeFieldOfSupplierSpace(){
		return lastUpdateTimeFieldOfSupplierSpace("lastUpdateTime","");
	}


	public GoodsShelfForm damageSpaceIdFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  idFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm damageSpaceIdFieldOfDamageSpace(String initValue){
		return damageSpaceIdFieldOfDamageSpace("damageSpaceId",initValue);
	}
	public GoodsShelfForm damageSpaceIdFieldOfDamageSpace(){
		return damageSpaceIdFieldOfDamageSpace("damageSpaceId","");
	}


	public GoodsShelfForm locationFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  locationFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm locationFieldOfDamageSpace(String initValue){
		return locationFieldOfDamageSpace("location",initValue);
	}
	public GoodsShelfForm locationFieldOfDamageSpace(){
		return locationFieldOfDamageSpace("location","");
	}


	public GoodsShelfForm contactNumberFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm contactNumberFieldOfDamageSpace(String initValue){
		return contactNumberFieldOfDamageSpace("contactNumber",initValue);
	}
	public GoodsShelfForm contactNumberFieldOfDamageSpace(){
		return contactNumberFieldOfDamageSpace("contactNumber","");
	}


	public GoodsShelfForm totalAreaFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm totalAreaFieldOfDamageSpace(String initValue){
		return totalAreaFieldOfDamageSpace("totalArea",initValue);
	}
	public GoodsShelfForm totalAreaFieldOfDamageSpace(){
		return totalAreaFieldOfDamageSpace("totalArea","");
	}


	public GoodsShelfForm latitudeFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  latitudeFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm latitudeFieldOfDamageSpace(String initValue){
		return latitudeFieldOfDamageSpace("latitude",initValue);
	}
	public GoodsShelfForm latitudeFieldOfDamageSpace(){
		return latitudeFieldOfDamageSpace("latitude","");
	}


	public GoodsShelfForm longitudeFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  longitudeFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm longitudeFieldOfDamageSpace(String initValue){
		return longitudeFieldOfDamageSpace("longitude",initValue);
	}
	public GoodsShelfForm longitudeFieldOfDamageSpace(){
		return longitudeFieldOfDamageSpace("longitude","");
	}


	public GoodsShelfForm warehouseIdFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm warehouseIdFieldOfDamageSpace(String initValue){
		return warehouseIdFieldOfDamageSpace("warehouseId",initValue);
	}
	public GoodsShelfForm warehouseIdFieldOfDamageSpace(){
		return warehouseIdFieldOfDamageSpace("warehouseId","");
	}


	public GoodsShelfForm lastUpdateTimeFieldOfDamageSpace(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromDamageSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsShelfForm lastUpdateTimeFieldOfDamageSpace(String initValue){
		return lastUpdateTimeFieldOfDamageSpace("lastUpdateTime",initValue);
	}
	public GoodsShelfForm lastUpdateTimeFieldOfDamageSpace(){
		return lastUpdateTimeFieldOfDamageSpace("lastUpdateTime","");
	}

	



	public GoodsShelfForm goodsShelfStockCountIdFieldForGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  idFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm goodsShelfStockCountIdFieldForGoodsShelfStockCount(String initValue){
		return goodsShelfStockCountIdFieldForGoodsShelfStockCount("goodsShelfStockCountId",initValue);
	}
	public GoodsShelfForm goodsShelfStockCountIdFieldForGoodsShelfStockCount(){
		return goodsShelfStockCountIdFieldForGoodsShelfStockCount("goodsShelfStockCountId","");
	}


	public GoodsShelfForm titleFieldForGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  titleFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm titleFieldForGoodsShelfStockCount(String initValue){
		return titleFieldForGoodsShelfStockCount("title",initValue);
	}
	public GoodsShelfForm titleFieldForGoodsShelfStockCount(){
		return titleFieldForGoodsShelfStockCount("title","");
	}


	public GoodsShelfForm countTimeFieldForGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  countTimeFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm countTimeFieldForGoodsShelfStockCount(String initValue){
		return countTimeFieldForGoodsShelfStockCount("countTime",initValue);
	}
	public GoodsShelfForm countTimeFieldForGoodsShelfStockCount(){
		return countTimeFieldForGoodsShelfStockCount("countTime","");
	}


	public GoodsShelfForm summaryFieldForGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  summaryFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm summaryFieldForGoodsShelfStockCount(String initValue){
		return summaryFieldForGoodsShelfStockCount("summary",initValue);
	}
	public GoodsShelfForm summaryFieldForGoodsShelfStockCount(){
		return summaryFieldForGoodsShelfStockCount("summary","");
	}


	public GoodsShelfForm shelfIdFieldForGoodsShelfStockCount(String parameterName, String initValue){
		FormField field =  shelfIdFromGoodsShelfStockCount(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm shelfIdFieldForGoodsShelfStockCount(String initValue){
		return shelfIdFieldForGoodsShelfStockCount("shelfId",initValue);
	}
	public GoodsShelfForm shelfIdFieldForGoodsShelfStockCount(){
		return shelfIdFieldForGoodsShelfStockCount("shelfId","");
	}


	public GoodsShelfForm goodsAllocationIdFieldForGoodsAllocation(String parameterName, String initValue){
		FormField field =  idFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm goodsAllocationIdFieldForGoodsAllocation(String initValue){
		return goodsAllocationIdFieldForGoodsAllocation("goodsAllocationId",initValue);
	}
	public GoodsShelfForm goodsAllocationIdFieldForGoodsAllocation(){
		return goodsAllocationIdFieldForGoodsAllocation("goodsAllocationId","");
	}


	public GoodsShelfForm locationFieldForGoodsAllocation(String parameterName, String initValue){
		FormField field =  locationFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm locationFieldForGoodsAllocation(String initValue){
		return locationFieldForGoodsAllocation("location",initValue);
	}
	public GoodsShelfForm locationFieldForGoodsAllocation(){
		return locationFieldForGoodsAllocation("location","");
	}


	public GoodsShelfForm latitudeFieldForGoodsAllocation(String parameterName, String initValue){
		FormField field =  latitudeFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm latitudeFieldForGoodsAllocation(String initValue){
		return latitudeFieldForGoodsAllocation("latitude",initValue);
	}
	public GoodsShelfForm latitudeFieldForGoodsAllocation(){
		return latitudeFieldForGoodsAllocation("latitude","");
	}


	public GoodsShelfForm longitudeFieldForGoodsAllocation(String parameterName, String initValue){
		FormField field =  longitudeFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm longitudeFieldForGoodsAllocation(String initValue){
		return longitudeFieldForGoodsAllocation("longitude",initValue);
	}
	public GoodsShelfForm longitudeFieldForGoodsAllocation(){
		return longitudeFieldForGoodsAllocation("longitude","");
	}


	public GoodsShelfForm goodsShelfIdFieldForGoodsAllocation(String parameterName, String initValue){
		FormField field =  goodsShelfIdFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsShelfForm goodsShelfIdFieldForGoodsAllocation(String initValue){
		return goodsShelfIdFieldForGoodsAllocation("goodsShelfId",initValue);
	}
	public GoodsShelfForm goodsShelfIdFieldForGoodsAllocation(){
		return goodsShelfIdFieldForGoodsAllocation("goodsShelfId","");
	}

	

	
 	public GoodsShelfForm transferToAnotherStorageSpaceAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherStorageSpace/goodsShelfId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsShelfForm transferToAnotherSupplierSpaceAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSupplierSpace/goodsShelfId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsShelfForm transferToAnotherDamageSpaceAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDamageSpace/goodsShelfId/");
		this.addFormAction(action);
		return this;
	}

 

	public GoodsShelfForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



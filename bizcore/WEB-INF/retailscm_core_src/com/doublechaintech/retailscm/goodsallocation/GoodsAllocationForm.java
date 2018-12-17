package com.doublechaintech.retailscm.goodsallocation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsAllocationForm extends BaseForm {
	
	
	public GoodsAllocationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsAllocationForm goodsAllocationIdField(String parameterName, String initValue){
		FormField field = idFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm goodsAllocationIdField(String initValue){
		return goodsAllocationIdField("goodsAllocationId",initValue);
	}
	public GoodsAllocationForm goodsAllocationIdField(){
		return goodsAllocationIdField("goodsAllocationId","");
	}


	public GoodsAllocationForm locationField(String parameterName, String initValue){
		FormField field = locationFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm locationField(String initValue){
		return locationField("location",initValue);
	}
	public GoodsAllocationForm locationField(){
		return locationField("location","");
	}


	public GoodsAllocationForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public GoodsAllocationForm latitudeField(){
		return latitudeField("latitude","");
	}


	public GoodsAllocationForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public GoodsAllocationForm longitudeField(){
		return longitudeField("longitude","");
	}


	public GoodsAllocationForm goodsShelfIdField(String parameterName, String initValue){
		FormField field = goodsShelfIdFromGoodsAllocation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm goodsShelfIdField(String initValue){
		return goodsShelfIdField("goodsShelfId",initValue);
	}
	public GoodsAllocationForm goodsShelfIdField(){
		return goodsShelfIdField("goodsShelfId","");
	}

	
	


	public GoodsAllocationForm goodsShelfIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  idFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsAllocationForm goodsShelfIdFieldOfGoodsShelf(String initValue){
		return goodsShelfIdFieldOfGoodsShelf("goodsShelfId",initValue);
	}
	public GoodsAllocationForm goodsShelfIdFieldOfGoodsShelf(){
		return goodsShelfIdFieldOfGoodsShelf("goodsShelfId","");
	}


	public GoodsAllocationForm locationFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  locationFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsAllocationForm locationFieldOfGoodsShelf(String initValue){
		return locationFieldOfGoodsShelf("location",initValue);
	}
	public GoodsAllocationForm locationFieldOfGoodsShelf(){
		return locationFieldOfGoodsShelf("location","");
	}


	public GoodsAllocationForm storageSpaceIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  storageSpaceIdFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsAllocationForm storageSpaceIdFieldOfGoodsShelf(String initValue){
		return storageSpaceIdFieldOfGoodsShelf("storageSpaceId",initValue);
	}
	public GoodsAllocationForm storageSpaceIdFieldOfGoodsShelf(){
		return storageSpaceIdFieldOfGoodsShelf("storageSpaceId","");
	}


	public GoodsAllocationForm supplierSpaceIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  supplierSpaceIdFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsAllocationForm supplierSpaceIdFieldOfGoodsShelf(String initValue){
		return supplierSpaceIdFieldOfGoodsShelf("supplierSpaceId",initValue);
	}
	public GoodsAllocationForm supplierSpaceIdFieldOfGoodsShelf(){
		return supplierSpaceIdFieldOfGoodsShelf("supplierSpaceId","");
	}


	public GoodsAllocationForm damageSpaceIdFieldOfGoodsShelf(String parameterName, String initValue){
		FormField field =  damageSpaceIdFromGoodsShelf(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsAllocationForm damageSpaceIdFieldOfGoodsShelf(String initValue){
		return damageSpaceIdFieldOfGoodsShelf("damageSpaceId",initValue);
	}
	public GoodsAllocationForm damageSpaceIdFieldOfGoodsShelf(){
		return damageSpaceIdFieldOfGoodsShelf("damageSpaceId","");
	}

	



	public GoodsAllocationForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public GoodsAllocationForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public GoodsAllocationForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public GoodsAllocationForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public GoodsAllocationForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public GoodsAllocationForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public GoodsAllocationForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public GoodsAllocationForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public GoodsAllocationForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public GoodsAllocationForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public GoodsAllocationForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public GoodsAllocationForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public GoodsAllocationForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public GoodsAllocationForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public GoodsAllocationForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public GoodsAllocationForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public GoodsAllocationForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public GoodsAllocationForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public GoodsAllocationForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public GoodsAllocationForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public GoodsAllocationForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public GoodsAllocationForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public GoodsAllocationForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public GoodsAllocationForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public GoodsAllocationForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public GoodsAllocationForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public GoodsAllocationForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public GoodsAllocationForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public GoodsAllocationForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public GoodsAllocationForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public GoodsAllocationForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public GoodsAllocationForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public GoodsAllocationForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsAllocationForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public GoodsAllocationForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public GoodsAllocationForm transferToAnotherGoodsShelfAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherGoodsShelf/goodsAllocationId/");
		this.addFormAction(action);
		return this;
	}

 

	public GoodsAllocationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



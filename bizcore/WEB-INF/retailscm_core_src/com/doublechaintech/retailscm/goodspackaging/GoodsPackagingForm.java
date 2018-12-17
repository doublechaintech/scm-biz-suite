package com.doublechaintech.retailscm.goodspackaging;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsPackagingForm extends BaseForm {
	
	
	public GoodsPackagingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsPackagingForm goodsPackagingIdField(String parameterName, String initValue){
		FormField field = idFromGoodsPackaging(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm goodsPackagingIdField(String initValue){
		return goodsPackagingIdField("goodsPackagingId",initValue);
	}
	public GoodsPackagingForm goodsPackagingIdField(){
		return goodsPackagingIdField("goodsPackagingId","");
	}


	public GoodsPackagingForm packageNameField(String parameterName, String initValue){
		FormField field = packageNameFromGoodsPackaging(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm packageNameField(String initValue){
		return packageNameField("packageName",initValue);
	}
	public GoodsPackagingForm packageNameField(){
		return packageNameField("packageName","");
	}


	public GoodsPackagingForm rfidField(String parameterName, String initValue){
		FormField field = rfidFromGoodsPackaging(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm rfidField(String initValue){
		return rfidField("rfid",initValue);
	}
	public GoodsPackagingForm rfidField(){
		return rfidField("rfid","");
	}


	public GoodsPackagingForm packageTimeField(String parameterName, String initValue){
		FormField field = packageTimeFromGoodsPackaging(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm packageTimeField(String initValue){
		return packageTimeField("packageTime",initValue);
	}
	public GoodsPackagingForm packageTimeField(){
		return packageTimeField("packageTime","");
	}


	public GoodsPackagingForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromGoodsPackaging(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public GoodsPackagingForm descriptionField(){
		return descriptionField("description","");
	}

	
	

	



	public GoodsPackagingForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public GoodsPackagingForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public GoodsPackagingForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public GoodsPackagingForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public GoodsPackagingForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public GoodsPackagingForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public GoodsPackagingForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public GoodsPackagingForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public GoodsPackagingForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public GoodsPackagingForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public GoodsPackagingForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public GoodsPackagingForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public GoodsPackagingForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public GoodsPackagingForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public GoodsPackagingForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public GoodsPackagingForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public GoodsPackagingForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public GoodsPackagingForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public GoodsPackagingForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public GoodsPackagingForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public GoodsPackagingForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public GoodsPackagingForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public GoodsPackagingForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public GoodsPackagingForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public GoodsPackagingForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public GoodsPackagingForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public GoodsPackagingForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public GoodsPackagingForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public GoodsPackagingForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public GoodsPackagingForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public GoodsPackagingForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public GoodsPackagingForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public GoodsPackagingForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsPackagingForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public GoodsPackagingForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	



	public GoodsPackagingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



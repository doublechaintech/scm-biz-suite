package com.doublechaintech.retailscm.goodsmovement;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsMovementForm extends BaseForm {
	
	
	public GoodsMovementForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsMovementForm goodsMovementIdField(String parameterName, String initValue){
		FormField field = idFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm goodsMovementIdField(String initValue){
		return goodsMovementIdField("goodsMovementId",initValue);
	}
	public GoodsMovementForm goodsMovementIdField(){
		return goodsMovementIdField("goodsMovementId","");
	}


	public GoodsMovementForm moveTimeField(String parameterName, String initValue){
		FormField field = moveTimeFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm moveTimeField(String initValue){
		return moveTimeField("moveTime",initValue);
	}
	public GoodsMovementForm moveTimeField(){
		return moveTimeField("moveTime","");
	}


	public GoodsMovementForm facilityField(String parameterName, String initValue){
		FormField field = facilityFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm facilityField(String initValue){
		return facilityField("facility",initValue);
	}
	public GoodsMovementForm facilityField(){
		return facilityField("facility","");
	}


	public GoodsMovementForm facilityIdField(String parameterName, String initValue){
		FormField field = facilityIdFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm facilityIdField(String initValue){
		return facilityIdField("facilityId",initValue);
	}
	public GoodsMovementForm facilityIdField(){
		return facilityIdField("facilityId","");
	}


	public GoodsMovementForm fromIpField(String parameterName, String initValue){
		FormField field = fromIpFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm fromIpField(String initValue){
		return fromIpField("fromIp",initValue);
	}
	public GoodsMovementForm fromIpField(){
		return fromIpField("fromIp","");
	}


	public GoodsMovementForm userAgentField(String parameterName, String initValue){
		FormField field = userAgentFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm userAgentField(String initValue){
		return userAgentField("userAgent",initValue);
	}
	public GoodsMovementForm userAgentField(){
		return userAgentField("userAgent","");
	}


	public GoodsMovementForm sessionIdField(String parameterName, String initValue){
		FormField field = sessionIdFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm sessionIdField(String initValue){
		return sessionIdField("sessionId",initValue);
	}
	public GoodsMovementForm sessionIdField(){
		return sessionIdField("sessionId","");
	}


	public GoodsMovementForm latitudeField(String parameterName, String initValue){
		FormField field = latitudeFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm latitudeField(String initValue){
		return latitudeField("latitude",initValue);
	}
	public GoodsMovementForm latitudeField(){
		return latitudeField("latitude","");
	}


	public GoodsMovementForm longitudeField(String parameterName, String initValue){
		FormField field = longitudeFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm longitudeField(String initValue){
		return longitudeField("longitude",initValue);
	}
	public GoodsMovementForm longitudeField(){
		return longitudeField("longitude","");
	}


	public GoodsMovementForm goodsIdField(String parameterName, String initValue){
		FormField field = goodsIdFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsMovementForm goodsIdField(String initValue){
		return goodsIdField("goodsId",initValue);
	}
	public GoodsMovementForm goodsIdField(){
		return goodsIdField("goodsId","");
	}

	
	


	public GoodsMovementForm goodsIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm goodsIdFieldOfGoods(String initValue){
		return goodsIdFieldOfGoods("goodsId",initValue);
	}
	public GoodsMovementForm goodsIdFieldOfGoods(){
		return goodsIdFieldOfGoods("goodsId","");
	}


	public GoodsMovementForm nameFieldOfGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm nameFieldOfGoods(String initValue){
		return nameFieldOfGoods("name",initValue);
	}
	public GoodsMovementForm nameFieldOfGoods(){
		return nameFieldOfGoods("name","");
	}


	public GoodsMovementForm rfidFieldOfGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm rfidFieldOfGoods(String initValue){
		return rfidFieldOfGoods("rfid",initValue);
	}
	public GoodsMovementForm rfidFieldOfGoods(){
		return rfidFieldOfGoods("rfid","");
	}


	public GoodsMovementForm uomFieldOfGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm uomFieldOfGoods(String initValue){
		return uomFieldOfGoods("uom",initValue);
	}
	public GoodsMovementForm uomFieldOfGoods(){
		return uomFieldOfGoods("uom","");
	}


	public GoodsMovementForm maxPackageFieldOfGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm maxPackageFieldOfGoods(String initValue){
		return maxPackageFieldOfGoods("maxPackage",initValue);
	}
	public GoodsMovementForm maxPackageFieldOfGoods(){
		return maxPackageFieldOfGoods("maxPackage","");
	}


	public GoodsMovementForm expireTimeFieldOfGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm expireTimeFieldOfGoods(String initValue){
		return expireTimeFieldOfGoods("expireTime",initValue);
	}
	public GoodsMovementForm expireTimeFieldOfGoods(){
		return expireTimeFieldOfGoods("expireTime","");
	}


	public GoodsMovementForm skuIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm skuIdFieldOfGoods(String initValue){
		return skuIdFieldOfGoods("skuId",initValue);
	}
	public GoodsMovementForm skuIdFieldOfGoods(){
		return skuIdFieldOfGoods("skuId","");
	}


	public GoodsMovementForm receivingSpaceIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm receivingSpaceIdFieldOfGoods(String initValue){
		return receivingSpaceIdFieldOfGoods("receivingSpaceId",initValue);
	}
	public GoodsMovementForm receivingSpaceIdFieldOfGoods(){
		return receivingSpaceIdFieldOfGoods("receivingSpaceId","");
	}


	public GoodsMovementForm goodsAllocationIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm goodsAllocationIdFieldOfGoods(String initValue){
		return goodsAllocationIdFieldOfGoods("goodsAllocationId",initValue);
	}
	public GoodsMovementForm goodsAllocationIdFieldOfGoods(){
		return goodsAllocationIdFieldOfGoods("goodsAllocationId","");
	}


	public GoodsMovementForm smartPalletIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm smartPalletIdFieldOfGoods(String initValue){
		return smartPalletIdFieldOfGoods("smartPalletId",initValue);
	}
	public GoodsMovementForm smartPalletIdFieldOfGoods(){
		return smartPalletIdFieldOfGoods("smartPalletId","");
	}


	public GoodsMovementForm shippingSpaceIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm shippingSpaceIdFieldOfGoods(String initValue){
		return shippingSpaceIdFieldOfGoods("shippingSpaceId",initValue);
	}
	public GoodsMovementForm shippingSpaceIdFieldOfGoods(){
		return shippingSpaceIdFieldOfGoods("shippingSpaceId","");
	}


	public GoodsMovementForm transportTaskIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm transportTaskIdFieldOfGoods(String initValue){
		return transportTaskIdFieldOfGoods("transportTaskId",initValue);
	}
	public GoodsMovementForm transportTaskIdFieldOfGoods(){
		return transportTaskIdFieldOfGoods("transportTaskId","");
	}


	public GoodsMovementForm retailStoreIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm retailStoreIdFieldOfGoods(String initValue){
		return retailStoreIdFieldOfGoods("retailStoreId",initValue);
	}
	public GoodsMovementForm retailStoreIdFieldOfGoods(){
		return retailStoreIdFieldOfGoods("retailStoreId","");
	}


	public GoodsMovementForm bizOrderIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm bizOrderIdFieldOfGoods(String initValue){
		return bizOrderIdFieldOfGoods("bizOrderId",initValue);
	}
	public GoodsMovementForm bizOrderIdFieldOfGoods(){
		return bizOrderIdFieldOfGoods("bizOrderId","");
	}


	public GoodsMovementForm retailStoreOrderIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm retailStoreOrderIdFieldOfGoods(String initValue){
		return retailStoreOrderIdFieldOfGoods("retailStoreOrderId",initValue);
	}
	public GoodsMovementForm retailStoreOrderIdFieldOfGoods(){
		return retailStoreOrderIdFieldOfGoods("retailStoreOrderId","");
	}


	public GoodsMovementForm packagingIdFieldOfGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm packagingIdFieldOfGoods(String initValue){
		return packagingIdFieldOfGoods("packagingId",initValue);
	}
	public GoodsMovementForm packagingIdFieldOfGoods(){
		return packagingIdFieldOfGoods("packagingId","");
	}


	public GoodsMovementForm currentStatusFieldOfGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsMovementForm currentStatusFieldOfGoods(String initValue){
		return currentStatusFieldOfGoods("currentStatus",initValue);
	}
	public GoodsMovementForm currentStatusFieldOfGoods(){
		return currentStatusFieldOfGoods("currentStatus","");
	}

	


	

	
 	public GoodsMovementForm transferToAnotherGoodsAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherGoods/goodsMovementId/");
		this.addFormAction(action);
		return this;
	}

 

	public GoodsMovementForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



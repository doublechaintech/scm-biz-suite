package com.doublechaintech.retailscm.goods;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsForm extends BaseForm {
	
	
	public GoodsForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsForm goodsIdField(String parameterName, String initValue){
		FormField field = idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm goodsIdField(String initValue){
		return goodsIdField("goodsId",initValue);
	}
	public GoodsForm goodsIdField(){
		return goodsIdField("goodsId","");
	}


	public GoodsForm nameField(String parameterName, String initValue){
		FormField field = nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public GoodsForm nameField(){
		return nameField("name","");
	}


	public GoodsForm rfidField(String parameterName, String initValue){
		FormField field = rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm rfidField(String initValue){
		return rfidField("rfid",initValue);
	}
	public GoodsForm rfidField(){
		return rfidField("rfid","");
	}


	public GoodsForm uomField(String parameterName, String initValue){
		FormField field = uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm uomField(String initValue){
		return uomField("uom",initValue);
	}
	public GoodsForm uomField(){
		return uomField("uom","");
	}


	public GoodsForm maxPackageField(String parameterName, String initValue){
		FormField field = maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm maxPackageField(String initValue){
		return maxPackageField("maxPackage",initValue);
	}
	public GoodsForm maxPackageField(){
		return maxPackageField("maxPackage","");
	}


	public GoodsForm expireTimeField(String parameterName, String initValue){
		FormField field = expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm expireTimeField(String initValue){
		return expireTimeField("expireTime",initValue);
	}
	public GoodsForm expireTimeField(){
		return expireTimeField("expireTime","");
	}


	public GoodsForm skuIdField(String parameterName, String initValue){
		FormField field = skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm skuIdField(String initValue){
		return skuIdField("skuId",initValue);
	}
	public GoodsForm skuIdField(){
		return skuIdField("skuId","");
	}


	public GoodsForm receivingSpaceIdField(String parameterName, String initValue){
		FormField field = receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm receivingSpaceIdField(String initValue){
		return receivingSpaceIdField("receivingSpaceId",initValue);
	}
	public GoodsForm receivingSpaceIdField(){
		return receivingSpaceIdField("receivingSpaceId","");
	}


	public GoodsForm goodsAllocationIdField(String parameterName, String initValue){
		FormField field = goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm goodsAllocationIdField(String initValue){
		return goodsAllocationIdField("goodsAllocationId",initValue);
	}
	public GoodsForm goodsAllocationIdField(){
		return goodsAllocationIdField("goodsAllocationId","");
	}


	public GoodsForm smartPalletIdField(String parameterName, String initValue){
		FormField field = smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm smartPalletIdField(String initValue){
		return smartPalletIdField("smartPalletId",initValue);
	}
	public GoodsForm smartPalletIdField(){
		return smartPalletIdField("smartPalletId","");
	}


	public GoodsForm shippingSpaceIdField(String parameterName, String initValue){
		FormField field = shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm shippingSpaceIdField(String initValue){
		return shippingSpaceIdField("shippingSpaceId",initValue);
	}
	public GoodsForm shippingSpaceIdField(){
		return shippingSpaceIdField("shippingSpaceId","");
	}


	public GoodsForm transportTaskIdField(String parameterName, String initValue){
		FormField field = transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm transportTaskIdField(String initValue){
		return transportTaskIdField("transportTaskId",initValue);
	}
	public GoodsForm transportTaskIdField(){
		return transportTaskIdField("transportTaskId","");
	}


	public GoodsForm retailStoreIdField(String parameterName, String initValue){
		FormField field = retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm retailStoreIdField(String initValue){
		return retailStoreIdField("retailStoreId",initValue);
	}
	public GoodsForm retailStoreIdField(){
		return retailStoreIdField("retailStoreId","");
	}


	public GoodsForm bizOrderIdField(String parameterName, String initValue){
		FormField field = bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm bizOrderIdField(String initValue){
		return bizOrderIdField("bizOrderId",initValue);
	}
	public GoodsForm bizOrderIdField(){
		return bizOrderIdField("bizOrderId","");
	}


	public GoodsForm retailStoreOrderIdField(String parameterName, String initValue){
		FormField field = retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm retailStoreOrderIdField(String initValue){
		return retailStoreOrderIdField("retailStoreOrderId",initValue);
	}
	public GoodsForm retailStoreOrderIdField(){
		return retailStoreOrderIdField("retailStoreOrderId","");
	}


	public GoodsForm packagingIdField(String parameterName, String initValue){
		FormField field = packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm packagingIdField(String initValue){
		return packagingIdField("packagingId",initValue);
	}
	public GoodsForm packagingIdField(){
		return packagingIdField("packagingId","");
	}


	public GoodsForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public GoodsForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public GoodsForm skuIdFieldOfSku(String parameterName, String initValue){
		FormField field =  idFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm skuIdFieldOfSku(String initValue){
		return skuIdFieldOfSku("skuId",initValue);
	}
	public GoodsForm skuIdFieldOfSku(){
		return skuIdFieldOfSku("skuId","");
	}


	public GoodsForm nameFieldOfSku(String parameterName, String initValue){
		FormField field =  nameFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm nameFieldOfSku(String initValue){
		return nameFieldOfSku("name",initValue);
	}
	public GoodsForm nameFieldOfSku(){
		return nameFieldOfSku("name","");
	}


	public GoodsForm sizeFieldOfSku(String parameterName, String initValue){
		FormField field =  sizeFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm sizeFieldOfSku(String initValue){
		return sizeFieldOfSku("size",initValue);
	}
	public GoodsForm sizeFieldOfSku(){
		return sizeFieldOfSku("size","");
	}


	public GoodsForm productIdFieldOfSku(String parameterName, String initValue){
		FormField field =  productIdFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm productIdFieldOfSku(String initValue){
		return productIdFieldOfSku("productId",initValue);
	}
	public GoodsForm productIdFieldOfSku(){
		return productIdFieldOfSku("productId","");
	}


	public GoodsForm barcodeFieldOfSku(String parameterName, String initValue){
		FormField field =  barcodeFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm barcodeFieldOfSku(String initValue){
		return barcodeFieldOfSku("barcode",initValue);
	}
	public GoodsForm barcodeFieldOfSku(){
		return barcodeFieldOfSku("barcode","");
	}


	public GoodsForm packageTypeFieldOfSku(String parameterName, String initValue){
		FormField field =  packageTypeFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm packageTypeFieldOfSku(String initValue){
		return packageTypeFieldOfSku("packageType",initValue);
	}
	public GoodsForm packageTypeFieldOfSku(){
		return packageTypeFieldOfSku("packageType","");
	}


	public GoodsForm netContentFieldOfSku(String parameterName, String initValue){
		FormField field =  netContentFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm netContentFieldOfSku(String initValue){
		return netContentFieldOfSku("netContent",initValue);
	}
	public GoodsForm netContentFieldOfSku(){
		return netContentFieldOfSku("netContent","");
	}


	public GoodsForm priceFieldOfSku(String parameterName, String initValue){
		FormField field =  priceFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm priceFieldOfSku(String initValue){
		return priceFieldOfSku("price",initValue);
	}
	public GoodsForm priceFieldOfSku(){
		return priceFieldOfSku("price","");
	}


	public GoodsForm pictureFieldOfSku(String parameterName, String initValue){
		FormField field =  pictureFromSku(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm pictureFieldOfSku(String initValue){
		return pictureFieldOfSku("picture",initValue);
	}
	public GoodsForm pictureFieldOfSku(){
		return pictureFieldOfSku("picture","");
	}


	public GoodsForm receivingSpaceIdFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  idFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm receivingSpaceIdFieldOfReceivingSpace(String initValue){
		return receivingSpaceIdFieldOfReceivingSpace("receivingSpaceId",initValue);
	}
	public GoodsForm receivingSpaceIdFieldOfReceivingSpace(){
		return receivingSpaceIdFieldOfReceivingSpace("receivingSpaceId","");
	}


	public GoodsForm locationFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  locationFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm locationFieldOfReceivingSpace(String initValue){
		return locationFieldOfReceivingSpace("location",initValue);
	}
	public GoodsForm locationFieldOfReceivingSpace(){
		return locationFieldOfReceivingSpace("location","");
	}


	public GoodsForm contactNumberFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm contactNumberFieldOfReceivingSpace(String initValue){
		return contactNumberFieldOfReceivingSpace("contactNumber",initValue);
	}
	public GoodsForm contactNumberFieldOfReceivingSpace(){
		return contactNumberFieldOfReceivingSpace("contactNumber","");
	}


	public GoodsForm descriptionFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  descriptionFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm descriptionFieldOfReceivingSpace(String initValue){
		return descriptionFieldOfReceivingSpace("description",initValue);
	}
	public GoodsForm descriptionFieldOfReceivingSpace(){
		return descriptionFieldOfReceivingSpace("description","");
	}


	public GoodsForm totalAreaFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm totalAreaFieldOfReceivingSpace(String initValue){
		return totalAreaFieldOfReceivingSpace("totalArea",initValue);
	}
	public GoodsForm totalAreaFieldOfReceivingSpace(){
		return totalAreaFieldOfReceivingSpace("totalArea","");
	}


	public GoodsForm warehouseIdFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm warehouseIdFieldOfReceivingSpace(String initValue){
		return warehouseIdFieldOfReceivingSpace("warehouseId",initValue);
	}
	public GoodsForm warehouseIdFieldOfReceivingSpace(){
		return warehouseIdFieldOfReceivingSpace("warehouseId","");
	}


	public GoodsForm latitudeFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  latitudeFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm latitudeFieldOfReceivingSpace(String initValue){
		return latitudeFieldOfReceivingSpace("latitude",initValue);
	}
	public GoodsForm latitudeFieldOfReceivingSpace(){
		return latitudeFieldOfReceivingSpace("latitude","");
	}


	public GoodsForm longitudeFieldOfReceivingSpace(String parameterName, String initValue){
		FormField field =  longitudeFromReceivingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm longitudeFieldOfReceivingSpace(String initValue){
		return longitudeFieldOfReceivingSpace("longitude",initValue);
	}
	public GoodsForm longitudeFieldOfReceivingSpace(){
		return longitudeFieldOfReceivingSpace("longitude","");
	}


	public GoodsForm goodsAllocationIdFieldOfGoodsAllocation(String parameterName, String initValue){
		FormField field =  idFromGoodsAllocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm goodsAllocationIdFieldOfGoodsAllocation(String initValue){
		return goodsAllocationIdFieldOfGoodsAllocation("goodsAllocationId",initValue);
	}
	public GoodsForm goodsAllocationIdFieldOfGoodsAllocation(){
		return goodsAllocationIdFieldOfGoodsAllocation("goodsAllocationId","");
	}


	public GoodsForm locationFieldOfGoodsAllocation(String parameterName, String initValue){
		FormField field =  locationFromGoodsAllocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm locationFieldOfGoodsAllocation(String initValue){
		return locationFieldOfGoodsAllocation("location",initValue);
	}
	public GoodsForm locationFieldOfGoodsAllocation(){
		return locationFieldOfGoodsAllocation("location","");
	}


	public GoodsForm latitudeFieldOfGoodsAllocation(String parameterName, String initValue){
		FormField field =  latitudeFromGoodsAllocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm latitudeFieldOfGoodsAllocation(String initValue){
		return latitudeFieldOfGoodsAllocation("latitude",initValue);
	}
	public GoodsForm latitudeFieldOfGoodsAllocation(){
		return latitudeFieldOfGoodsAllocation("latitude","");
	}


	public GoodsForm longitudeFieldOfGoodsAllocation(String parameterName, String initValue){
		FormField field =  longitudeFromGoodsAllocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm longitudeFieldOfGoodsAllocation(String initValue){
		return longitudeFieldOfGoodsAllocation("longitude",initValue);
	}
	public GoodsForm longitudeFieldOfGoodsAllocation(){
		return longitudeFieldOfGoodsAllocation("longitude","");
	}


	public GoodsForm goodsShelfIdFieldOfGoodsAllocation(String parameterName, String initValue){
		FormField field =  goodsShelfIdFromGoodsAllocation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm goodsShelfIdFieldOfGoodsAllocation(String initValue){
		return goodsShelfIdFieldOfGoodsAllocation("goodsShelfId",initValue);
	}
	public GoodsForm goodsShelfIdFieldOfGoodsAllocation(){
		return goodsShelfIdFieldOfGoodsAllocation("goodsShelfId","");
	}


	public GoodsForm smartPalletIdFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  idFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm smartPalletIdFieldOfSmartPallet(String initValue){
		return smartPalletIdFieldOfSmartPallet("smartPalletId",initValue);
	}
	public GoodsForm smartPalletIdFieldOfSmartPallet(){
		return smartPalletIdFieldOfSmartPallet("smartPalletId","");
	}


	public GoodsForm locationFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  locationFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm locationFieldOfSmartPallet(String initValue){
		return locationFieldOfSmartPallet("location",initValue);
	}
	public GoodsForm locationFieldOfSmartPallet(){
		return locationFieldOfSmartPallet("location","");
	}


	public GoodsForm contactNumberFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  contactNumberFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm contactNumberFieldOfSmartPallet(String initValue){
		return contactNumberFieldOfSmartPallet("contactNumber",initValue);
	}
	public GoodsForm contactNumberFieldOfSmartPallet(){
		return contactNumberFieldOfSmartPallet("contactNumber","");
	}


	public GoodsForm totalAreaFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  totalAreaFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm totalAreaFieldOfSmartPallet(String initValue){
		return totalAreaFieldOfSmartPallet("totalArea",initValue);
	}
	public GoodsForm totalAreaFieldOfSmartPallet(){
		return totalAreaFieldOfSmartPallet("totalArea","");
	}


	public GoodsForm latitudeFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  latitudeFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm latitudeFieldOfSmartPallet(String initValue){
		return latitudeFieldOfSmartPallet("latitude",initValue);
	}
	public GoodsForm latitudeFieldOfSmartPallet(){
		return latitudeFieldOfSmartPallet("latitude","");
	}


	public GoodsForm longitudeFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  longitudeFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm longitudeFieldOfSmartPallet(String initValue){
		return longitudeFieldOfSmartPallet("longitude",initValue);
	}
	public GoodsForm longitudeFieldOfSmartPallet(){
		return longitudeFieldOfSmartPallet("longitude","");
	}


	public GoodsForm warehouseIdFieldOfSmartPallet(String parameterName, String initValue){
		FormField field =  warehouseIdFromSmartPallet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm warehouseIdFieldOfSmartPallet(String initValue){
		return warehouseIdFieldOfSmartPallet("warehouseId",initValue);
	}
	public GoodsForm warehouseIdFieldOfSmartPallet(){
		return warehouseIdFieldOfSmartPallet("warehouseId","");
	}


	public GoodsForm shippingSpaceIdFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  idFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm shippingSpaceIdFieldOfShippingSpace(String initValue){
		return shippingSpaceIdFieldOfShippingSpace("shippingSpaceId",initValue);
	}
	public GoodsForm shippingSpaceIdFieldOfShippingSpace(){
		return shippingSpaceIdFieldOfShippingSpace("shippingSpaceId","");
	}


	public GoodsForm locationFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  locationFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm locationFieldOfShippingSpace(String initValue){
		return locationFieldOfShippingSpace("location",initValue);
	}
	public GoodsForm locationFieldOfShippingSpace(){
		return locationFieldOfShippingSpace("location","");
	}


	public GoodsForm contactNumberFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  contactNumberFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm contactNumberFieldOfShippingSpace(String initValue){
		return contactNumberFieldOfShippingSpace("contactNumber",initValue);
	}
	public GoodsForm contactNumberFieldOfShippingSpace(){
		return contactNumberFieldOfShippingSpace("contactNumber","");
	}


	public GoodsForm totalAreaFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  totalAreaFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm totalAreaFieldOfShippingSpace(String initValue){
		return totalAreaFieldOfShippingSpace("totalArea",initValue);
	}
	public GoodsForm totalAreaFieldOfShippingSpace(){
		return totalAreaFieldOfShippingSpace("totalArea","");
	}


	public GoodsForm warehouseIdFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  warehouseIdFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm warehouseIdFieldOfShippingSpace(String initValue){
		return warehouseIdFieldOfShippingSpace("warehouseId",initValue);
	}
	public GoodsForm warehouseIdFieldOfShippingSpace(){
		return warehouseIdFieldOfShippingSpace("warehouseId","");
	}


	public GoodsForm latitudeFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  latitudeFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm latitudeFieldOfShippingSpace(String initValue){
		return latitudeFieldOfShippingSpace("latitude",initValue);
	}
	public GoodsForm latitudeFieldOfShippingSpace(){
		return latitudeFieldOfShippingSpace("latitude","");
	}


	public GoodsForm longitudeFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  longitudeFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm longitudeFieldOfShippingSpace(String initValue){
		return longitudeFieldOfShippingSpace("longitude",initValue);
	}
	public GoodsForm longitudeFieldOfShippingSpace(){
		return longitudeFieldOfShippingSpace("longitude","");
	}


	public GoodsForm descriptionFieldOfShippingSpace(String parameterName, String initValue){
		FormField field =  descriptionFromShippingSpace(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm descriptionFieldOfShippingSpace(String initValue){
		return descriptionFieldOfShippingSpace("description",initValue);
	}
	public GoodsForm descriptionFieldOfShippingSpace(){
		return descriptionFieldOfShippingSpace("description","");
	}


	public GoodsForm transportTaskIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  idFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm transportTaskIdFieldOfTransportTask(String initValue){
		return transportTaskIdFieldOfTransportTask("transportTaskId",initValue);
	}
	public GoodsForm transportTaskIdFieldOfTransportTask(){
		return transportTaskIdFieldOfTransportTask("transportTaskId","");
	}


	public GoodsForm nameFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  nameFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm nameFieldOfTransportTask(String initValue){
		return nameFieldOfTransportTask("name",initValue);
	}
	public GoodsForm nameFieldOfTransportTask(){
		return nameFieldOfTransportTask("name","");
	}


	public GoodsForm startFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  startFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm startFieldOfTransportTask(String initValue){
		return startFieldOfTransportTask("start",initValue);
	}
	public GoodsForm startFieldOfTransportTask(){
		return startFieldOfTransportTask("start","");
	}


	public GoodsForm beginTimeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  beginTimeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm beginTimeFieldOfTransportTask(String initValue){
		return beginTimeFieldOfTransportTask("beginTime",initValue);
	}
	public GoodsForm beginTimeFieldOfTransportTask(){
		return beginTimeFieldOfTransportTask("beginTime","");
	}


	public GoodsForm endIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  endIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm endIdFieldOfTransportTask(String initValue){
		return endIdFieldOfTransportTask("endId",initValue);
	}
	public GoodsForm endIdFieldOfTransportTask(){
		return endIdFieldOfTransportTask("endId","");
	}


	public GoodsForm driverIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  driverIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm driverIdFieldOfTransportTask(String initValue){
		return driverIdFieldOfTransportTask("driverId",initValue);
	}
	public GoodsForm driverIdFieldOfTransportTask(){
		return driverIdFieldOfTransportTask("driverId","");
	}


	public GoodsForm truckIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  truckIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm truckIdFieldOfTransportTask(String initValue){
		return truckIdFieldOfTransportTask("truckId",initValue);
	}
	public GoodsForm truckIdFieldOfTransportTask(){
		return truckIdFieldOfTransportTask("truckId","");
	}


	public GoodsForm belongsToIdFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  belongsToIdFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm belongsToIdFieldOfTransportTask(String initValue){
		return belongsToIdFieldOfTransportTask("belongsToId",initValue);
	}
	public GoodsForm belongsToIdFieldOfTransportTask(){
		return belongsToIdFieldOfTransportTask("belongsToId","");
	}


	public GoodsForm latitudeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  latitudeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm latitudeFieldOfTransportTask(String initValue){
		return latitudeFieldOfTransportTask("latitude",initValue);
	}
	public GoodsForm latitudeFieldOfTransportTask(){
		return latitudeFieldOfTransportTask("latitude","");
	}


	public GoodsForm longitudeFieldOfTransportTask(String parameterName, String initValue){
		FormField field =  longitudeFromTransportTask(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm longitudeFieldOfTransportTask(String initValue){
		return longitudeFieldOfTransportTask("longitude",initValue);
	}
	public GoodsForm longitudeFieldOfTransportTask(){
		return longitudeFieldOfTransportTask("longitude","");
	}


	public GoodsForm retailStoreIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm retailStoreIdFieldOfRetailStore(String initValue){
		return retailStoreIdFieldOfRetailStore("retailStoreId",initValue);
	}
	public GoodsForm retailStoreIdFieldOfRetailStore(){
		return retailStoreIdFieldOfRetailStore("retailStoreId","");
	}


	public GoodsForm nameFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm nameFieldOfRetailStore(String initValue){
		return nameFieldOfRetailStore("name",initValue);
	}
	public GoodsForm nameFieldOfRetailStore(){
		return nameFieldOfRetailStore("name","");
	}


	public GoodsForm telephoneFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm telephoneFieldOfRetailStore(String initValue){
		return telephoneFieldOfRetailStore("telephone",initValue);
	}
	public GoodsForm telephoneFieldOfRetailStore(){
		return telephoneFieldOfRetailStore("telephone","");
	}


	public GoodsForm ownerFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm ownerFieldOfRetailStore(String initValue){
		return ownerFieldOfRetailStore("owner",initValue);
	}
	public GoodsForm ownerFieldOfRetailStore(){
		return ownerFieldOfRetailStore("owner","");
	}


	public GoodsForm retailStoreCountryCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm retailStoreCountryCenterIdFieldOfRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId",initValue);
	}
	public GoodsForm retailStoreCountryCenterIdFieldOfRetailStore(){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId","");
	}


	public GoodsForm cityServiceCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm cityServiceCenterIdFieldOfRetailStore(String initValue){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId",initValue);
	}
	public GoodsForm cityServiceCenterIdFieldOfRetailStore(){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId","");
	}


	public GoodsForm creationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm creationIdFieldOfRetailStore(String initValue){
		return creationIdFieldOfRetailStore("creationId",initValue);
	}
	public GoodsForm creationIdFieldOfRetailStore(){
		return creationIdFieldOfRetailStore("creationId","");
	}


	public GoodsForm investmentInvitationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm investmentInvitationIdFieldOfRetailStore(String initValue){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId",initValue);
	}
	public GoodsForm investmentInvitationIdFieldOfRetailStore(){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId","");
	}


	public GoodsForm franchisingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm franchisingIdFieldOfRetailStore(String initValue){
		return franchisingIdFieldOfRetailStore("franchisingId",initValue);
	}
	public GoodsForm franchisingIdFieldOfRetailStore(){
		return franchisingIdFieldOfRetailStore("franchisingId","");
	}


	public GoodsForm decorationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm decorationIdFieldOfRetailStore(String initValue){
		return decorationIdFieldOfRetailStore("decorationId",initValue);
	}
	public GoodsForm decorationIdFieldOfRetailStore(){
		return decorationIdFieldOfRetailStore("decorationId","");
	}


	public GoodsForm openingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm openingIdFieldOfRetailStore(String initValue){
		return openingIdFieldOfRetailStore("openingId",initValue);
	}
	public GoodsForm openingIdFieldOfRetailStore(){
		return openingIdFieldOfRetailStore("openingId","");
	}


	public GoodsForm closingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm closingIdFieldOfRetailStore(String initValue){
		return closingIdFieldOfRetailStore("closingId",initValue);
	}
	public GoodsForm closingIdFieldOfRetailStore(){
		return closingIdFieldOfRetailStore("closingId","");
	}


	public GoodsForm foundedFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm foundedFieldOfRetailStore(String initValue){
		return foundedFieldOfRetailStore("founded",initValue);
	}
	public GoodsForm foundedFieldOfRetailStore(){
		return foundedFieldOfRetailStore("founded","");
	}


	public GoodsForm latitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm latitudeFieldOfRetailStore(String initValue){
		return latitudeFieldOfRetailStore("latitude",initValue);
	}
	public GoodsForm latitudeFieldOfRetailStore(){
		return latitudeFieldOfRetailStore("latitude","");
	}


	public GoodsForm longitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm longitudeFieldOfRetailStore(String initValue){
		return longitudeFieldOfRetailStore("longitude",initValue);
	}
	public GoodsForm longitudeFieldOfRetailStore(){
		return longitudeFieldOfRetailStore("longitude","");
	}


	public GoodsForm descriptionFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm descriptionFieldOfRetailStore(String initValue){
		return descriptionFieldOfRetailStore("description",initValue);
	}
	public GoodsForm descriptionFieldOfRetailStore(){
		return descriptionFieldOfRetailStore("description","");
	}


	public GoodsForm lastUpdateTimeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm lastUpdateTimeFieldOfRetailStore(String initValue){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime",initValue);
	}
	public GoodsForm lastUpdateTimeFieldOfRetailStore(){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime","");
	}


	public GoodsForm currentStatusFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm currentStatusFieldOfRetailStore(String initValue){
		return currentStatusFieldOfRetailStore("currentStatus",initValue);
	}
	public GoodsForm currentStatusFieldOfRetailStore(){
		return currentStatusFieldOfRetailStore("currentStatus","");
	}


	public GoodsForm supplyOrderIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm supplyOrderIdFieldOfSupplyOrder(String initValue){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId",initValue);
	}
	public GoodsForm supplyOrderIdFieldOfSupplyOrder(){
		return supplyOrderIdFieldOfSupplyOrder("supplyOrderId","");
	}


	public GoodsForm buyerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm buyerIdFieldOfSupplyOrder(String initValue){
		return buyerIdFieldOfSupplyOrder("buyerId",initValue);
	}
	public GoodsForm buyerIdFieldOfSupplyOrder(){
		return buyerIdFieldOfSupplyOrder("buyerId","");
	}


	public GoodsForm sellerIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm sellerIdFieldOfSupplyOrder(String initValue){
		return sellerIdFieldOfSupplyOrder("sellerId",initValue);
	}
	public GoodsForm sellerIdFieldOfSupplyOrder(){
		return sellerIdFieldOfSupplyOrder("sellerId","");
	}


	public GoodsForm titleFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm titleFieldOfSupplyOrder(String initValue){
		return titleFieldOfSupplyOrder("title",initValue);
	}
	public GoodsForm titleFieldOfSupplyOrder(){
		return titleFieldOfSupplyOrder("title","");
	}


	public GoodsForm totalAmountFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm totalAmountFieldOfSupplyOrder(String initValue){
		return totalAmountFieldOfSupplyOrder("totalAmount",initValue);
	}
	public GoodsForm totalAmountFieldOfSupplyOrder(){
		return totalAmountFieldOfSupplyOrder("totalAmount","");
	}


	public GoodsForm confirmationIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm confirmationIdFieldOfSupplyOrder(String initValue){
		return confirmationIdFieldOfSupplyOrder("confirmationId",initValue);
	}
	public GoodsForm confirmationIdFieldOfSupplyOrder(){
		return confirmationIdFieldOfSupplyOrder("confirmationId","");
	}


	public GoodsForm approvalIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm approvalIdFieldOfSupplyOrder(String initValue){
		return approvalIdFieldOfSupplyOrder("approvalId",initValue);
	}
	public GoodsForm approvalIdFieldOfSupplyOrder(){
		return approvalIdFieldOfSupplyOrder("approvalId","");
	}


	public GoodsForm processingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm processingIdFieldOfSupplyOrder(String initValue){
		return processingIdFieldOfSupplyOrder("processingId",initValue);
	}
	public GoodsForm processingIdFieldOfSupplyOrder(){
		return processingIdFieldOfSupplyOrder("processingId","");
	}


	public GoodsForm pickingIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm pickingIdFieldOfSupplyOrder(String initValue){
		return pickingIdFieldOfSupplyOrder("pickingId",initValue);
	}
	public GoodsForm pickingIdFieldOfSupplyOrder(){
		return pickingIdFieldOfSupplyOrder("pickingId","");
	}


	public GoodsForm shipmentIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm shipmentIdFieldOfSupplyOrder(String initValue){
		return shipmentIdFieldOfSupplyOrder("shipmentId",initValue);
	}
	public GoodsForm shipmentIdFieldOfSupplyOrder(){
		return shipmentIdFieldOfSupplyOrder("shipmentId","");
	}


	public GoodsForm deliveryIdFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm deliveryIdFieldOfSupplyOrder(String initValue){
		return deliveryIdFieldOfSupplyOrder("deliveryId",initValue);
	}
	public GoodsForm deliveryIdFieldOfSupplyOrder(){
		return deliveryIdFieldOfSupplyOrder("deliveryId","");
	}


	public GoodsForm lastUpdateTimeFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm lastUpdateTimeFieldOfSupplyOrder(String initValue){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime",initValue);
	}
	public GoodsForm lastUpdateTimeFieldOfSupplyOrder(){
		return lastUpdateTimeFieldOfSupplyOrder("lastUpdateTime","");
	}


	public GoodsForm currentStatusFieldOfSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm currentStatusFieldOfSupplyOrder(String initValue){
		return currentStatusFieldOfSupplyOrder("currentStatus",initValue);
	}
	public GoodsForm currentStatusFieldOfSupplyOrder(){
		return currentStatusFieldOfSupplyOrder("currentStatus","");
	}


	public GoodsForm retailStoreOrderIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm retailStoreOrderIdFieldOfRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public GoodsForm retailStoreOrderIdFieldOfRetailStoreOrder(){
		return retailStoreOrderIdFieldOfRetailStoreOrder("retailStoreOrderId","");
	}


	public GoodsForm buyerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm buyerIdFieldOfRetailStoreOrder(String initValue){
		return buyerIdFieldOfRetailStoreOrder("buyerId",initValue);
	}
	public GoodsForm buyerIdFieldOfRetailStoreOrder(){
		return buyerIdFieldOfRetailStoreOrder("buyerId","");
	}


	public GoodsForm sellerIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm sellerIdFieldOfRetailStoreOrder(String initValue){
		return sellerIdFieldOfRetailStoreOrder("sellerId",initValue);
	}
	public GoodsForm sellerIdFieldOfRetailStoreOrder(){
		return sellerIdFieldOfRetailStoreOrder("sellerId","");
	}


	public GoodsForm titleFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm titleFieldOfRetailStoreOrder(String initValue){
		return titleFieldOfRetailStoreOrder("title",initValue);
	}
	public GoodsForm titleFieldOfRetailStoreOrder(){
		return titleFieldOfRetailStoreOrder("title","");
	}


	public GoodsForm totalAmountFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm totalAmountFieldOfRetailStoreOrder(String initValue){
		return totalAmountFieldOfRetailStoreOrder("totalAmount",initValue);
	}
	public GoodsForm totalAmountFieldOfRetailStoreOrder(){
		return totalAmountFieldOfRetailStoreOrder("totalAmount","");
	}


	public GoodsForm confirmationIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm confirmationIdFieldOfRetailStoreOrder(String initValue){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId",initValue);
	}
	public GoodsForm confirmationIdFieldOfRetailStoreOrder(){
		return confirmationIdFieldOfRetailStoreOrder("confirmationId","");
	}


	public GoodsForm approvalIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm approvalIdFieldOfRetailStoreOrder(String initValue){
		return approvalIdFieldOfRetailStoreOrder("approvalId",initValue);
	}
	public GoodsForm approvalIdFieldOfRetailStoreOrder(){
		return approvalIdFieldOfRetailStoreOrder("approvalId","");
	}


	public GoodsForm processingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm processingIdFieldOfRetailStoreOrder(String initValue){
		return processingIdFieldOfRetailStoreOrder("processingId",initValue);
	}
	public GoodsForm processingIdFieldOfRetailStoreOrder(){
		return processingIdFieldOfRetailStoreOrder("processingId","");
	}


	public GoodsForm pickingIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm pickingIdFieldOfRetailStoreOrder(String initValue){
		return pickingIdFieldOfRetailStoreOrder("pickingId",initValue);
	}
	public GoodsForm pickingIdFieldOfRetailStoreOrder(){
		return pickingIdFieldOfRetailStoreOrder("pickingId","");
	}


	public GoodsForm shipmentIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm shipmentIdFieldOfRetailStoreOrder(String initValue){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId",initValue);
	}
	public GoodsForm shipmentIdFieldOfRetailStoreOrder(){
		return shipmentIdFieldOfRetailStoreOrder("shipmentId","");
	}


	public GoodsForm deliveryIdFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm deliveryIdFieldOfRetailStoreOrder(String initValue){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId",initValue);
	}
	public GoodsForm deliveryIdFieldOfRetailStoreOrder(){
		return deliveryIdFieldOfRetailStoreOrder("deliveryId","");
	}


	public GoodsForm lastUpdateTimeFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm lastUpdateTimeFieldOfRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime",initValue);
	}
	public GoodsForm lastUpdateTimeFieldOfRetailStoreOrder(){
		return lastUpdateTimeFieldOfRetailStoreOrder("lastUpdateTime","");
	}


	public GoodsForm currentStatusFieldOfRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm currentStatusFieldOfRetailStoreOrder(String initValue){
		return currentStatusFieldOfRetailStoreOrder("currentStatus",initValue);
	}
	public GoodsForm currentStatusFieldOfRetailStoreOrder(){
		return currentStatusFieldOfRetailStoreOrder("currentStatus","");
	}


	public GoodsForm goodsPackagingIdFieldOfGoodsPackaging(String parameterName, String initValue){
		FormField field =  idFromGoodsPackaging(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm goodsPackagingIdFieldOfGoodsPackaging(String initValue){
		return goodsPackagingIdFieldOfGoodsPackaging("goodsPackagingId",initValue);
	}
	public GoodsForm goodsPackagingIdFieldOfGoodsPackaging(){
		return goodsPackagingIdFieldOfGoodsPackaging("goodsPackagingId","");
	}


	public GoodsForm packageNameFieldOfGoodsPackaging(String parameterName, String initValue){
		FormField field =  packageNameFromGoodsPackaging(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm packageNameFieldOfGoodsPackaging(String initValue){
		return packageNameFieldOfGoodsPackaging("packageName",initValue);
	}
	public GoodsForm packageNameFieldOfGoodsPackaging(){
		return packageNameFieldOfGoodsPackaging("packageName","");
	}


	public GoodsForm rfidFieldOfGoodsPackaging(String parameterName, String initValue){
		FormField field =  rfidFromGoodsPackaging(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm rfidFieldOfGoodsPackaging(String initValue){
		return rfidFieldOfGoodsPackaging("rfid",initValue);
	}
	public GoodsForm rfidFieldOfGoodsPackaging(){
		return rfidFieldOfGoodsPackaging("rfid","");
	}


	public GoodsForm packageTimeFieldOfGoodsPackaging(String parameterName, String initValue){
		FormField field =  packageTimeFromGoodsPackaging(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm packageTimeFieldOfGoodsPackaging(String initValue){
		return packageTimeFieldOfGoodsPackaging("packageTime",initValue);
	}
	public GoodsForm packageTimeFieldOfGoodsPackaging(){
		return packageTimeFieldOfGoodsPackaging("packageTime","");
	}


	public GoodsForm descriptionFieldOfGoodsPackaging(String parameterName, String initValue){
		FormField field =  descriptionFromGoodsPackaging(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsForm descriptionFieldOfGoodsPackaging(String initValue){
		return descriptionFieldOfGoodsPackaging("description",initValue);
	}
	public GoodsForm descriptionFieldOfGoodsPackaging(){
		return descriptionFieldOfGoodsPackaging("description","");
	}

	



	public GoodsForm goodsMovementIdFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  idFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm goodsMovementIdFieldForGoodsMovement(String initValue){
		return goodsMovementIdFieldForGoodsMovement("goodsMovementId",initValue);
	}
	public GoodsForm goodsMovementIdFieldForGoodsMovement(){
		return goodsMovementIdFieldForGoodsMovement("goodsMovementId","");
	}


	public GoodsForm moveTimeFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  moveTimeFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm moveTimeFieldForGoodsMovement(String initValue){
		return moveTimeFieldForGoodsMovement("moveTime",initValue);
	}
	public GoodsForm moveTimeFieldForGoodsMovement(){
		return moveTimeFieldForGoodsMovement("moveTime","");
	}


	public GoodsForm facilityFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  facilityFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm facilityFieldForGoodsMovement(String initValue){
		return facilityFieldForGoodsMovement("facility",initValue);
	}
	public GoodsForm facilityFieldForGoodsMovement(){
		return facilityFieldForGoodsMovement("facility","");
	}


	public GoodsForm facilityIdFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  facilityIdFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm facilityIdFieldForGoodsMovement(String initValue){
		return facilityIdFieldForGoodsMovement("facilityId",initValue);
	}
	public GoodsForm facilityIdFieldForGoodsMovement(){
		return facilityIdFieldForGoodsMovement("facilityId","");
	}


	public GoodsForm fromIpFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  fromIpFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm fromIpFieldForGoodsMovement(String initValue){
		return fromIpFieldForGoodsMovement("fromIp",initValue);
	}
	public GoodsForm fromIpFieldForGoodsMovement(){
		return fromIpFieldForGoodsMovement("fromIp","");
	}


	public GoodsForm userAgentFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  userAgentFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm userAgentFieldForGoodsMovement(String initValue){
		return userAgentFieldForGoodsMovement("userAgent",initValue);
	}
	public GoodsForm userAgentFieldForGoodsMovement(){
		return userAgentFieldForGoodsMovement("userAgent","");
	}


	public GoodsForm sessionIdFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  sessionIdFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm sessionIdFieldForGoodsMovement(String initValue){
		return sessionIdFieldForGoodsMovement("sessionId",initValue);
	}
	public GoodsForm sessionIdFieldForGoodsMovement(){
		return sessionIdFieldForGoodsMovement("sessionId","");
	}


	public GoodsForm latitudeFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  latitudeFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm latitudeFieldForGoodsMovement(String initValue){
		return latitudeFieldForGoodsMovement("latitude",initValue);
	}
	public GoodsForm latitudeFieldForGoodsMovement(){
		return latitudeFieldForGoodsMovement("latitude","");
	}


	public GoodsForm longitudeFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  longitudeFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm longitudeFieldForGoodsMovement(String initValue){
		return longitudeFieldForGoodsMovement("longitude",initValue);
	}
	public GoodsForm longitudeFieldForGoodsMovement(){
		return longitudeFieldForGoodsMovement("longitude","");
	}


	public GoodsForm goodsIdFieldForGoodsMovement(String parameterName, String initValue){
		FormField field =  goodsIdFromGoodsMovement(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsForm goodsIdFieldForGoodsMovement(String initValue){
		return goodsIdFieldForGoodsMovement("goodsId",initValue);
	}
	public GoodsForm goodsIdFieldForGoodsMovement(){
		return goodsIdFieldForGoodsMovement("goodsId","");
	}

	

	
 	public GoodsForm transferToAnotherSkuAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSku/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherReceivingSpaceAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherReceivingSpace/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherGoodsAllocationAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherGoodsAllocation/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherSmartPalletAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSmartPallet/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherShippingSpaceAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherShippingSpace/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherTransportTaskAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherTransportTask/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherRetailStoreAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRetailStore/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherBizOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBizOrder/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm transferToAnotherRetailStoreOrderAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRetailStoreOrder/goodsId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public GoodsForm  packAction(){
		FormAction action = new FormAction();
		action.setLabel("包");
		action.setLocaleKey("goods.pack");
		action.setUrl("goodsManager/pack/goodsId/packageName/rfid/packageTime/description/");
		this.addFormAction(action);
		return this;
	}

	public GoodsForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.sku;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SkuForm extends BaseForm {
	
	
	public SkuForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SkuForm skuIdField(String parameterName, String initValue){
		FormField field = idFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm skuIdField(String initValue){
		return skuIdField("skuId",initValue);
	}
	public SkuForm skuIdField(){
		return skuIdField("skuId","");
	}


	public SkuForm nameField(String parameterName, String initValue){
		FormField field = nameFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public SkuForm nameField(){
		return nameField("name","");
	}


	public SkuForm sizeField(String parameterName, String initValue){
		FormField field = sizeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm sizeField(String initValue){
		return sizeField("size",initValue);
	}
	public SkuForm sizeField(){
		return sizeField("size","");
	}


	public SkuForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public SkuForm productIdField(){
		return productIdField("productId","");
	}


	public SkuForm barcodeField(String parameterName, String initValue){
		FormField field = barcodeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm barcodeField(String initValue){
		return barcodeField("barcode",initValue);
	}
	public SkuForm barcodeField(){
		return barcodeField("barcode","");
	}


	public SkuForm packageTypeField(String parameterName, String initValue){
		FormField field = packageTypeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm packageTypeField(String initValue){
		return packageTypeField("packageType",initValue);
	}
	public SkuForm packageTypeField(){
		return packageTypeField("packageType","");
	}


	public SkuForm netContentField(String parameterName, String initValue){
		FormField field = netContentFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm netContentField(String initValue){
		return netContentField("netContent",initValue);
	}
	public SkuForm netContentField(){
		return netContentField("netContent","");
	}


	public SkuForm priceField(String parameterName, String initValue){
		FormField field = priceFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm priceField(String initValue){
		return priceField("price",initValue);
	}
	public SkuForm priceField(){
		return priceField("price","");
	}


	public SkuForm pictureField(String parameterName, String initValue){
		FormField field = pictureFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm pictureField(String initValue){
		return pictureField("picture",initValue);
	}
	public SkuForm pictureField(){
		return pictureField("picture","");
	}

	
	


	public SkuForm productIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm productIdFieldOfProduct(String initValue){
		return productIdFieldOfProduct("productId",initValue);
	}
	public SkuForm productIdFieldOfProduct(){
		return productIdFieldOfProduct("productId","");
	}


	public SkuForm nameFieldOfProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm nameFieldOfProduct(String initValue){
		return nameFieldOfProduct("name",initValue);
	}
	public SkuForm nameFieldOfProduct(){
		return nameFieldOfProduct("name","");
	}


	public SkuForm parentCategoryIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm parentCategoryIdFieldOfProduct(String initValue){
		return parentCategoryIdFieldOfProduct("parentCategoryId",initValue);
	}
	public SkuForm parentCategoryIdFieldOfProduct(){
		return parentCategoryIdFieldOfProduct("parentCategoryId","");
	}


	public SkuForm originFieldOfProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm originFieldOfProduct(String initValue){
		return originFieldOfProduct("origin",initValue);
	}
	public SkuForm originFieldOfProduct(){
		return originFieldOfProduct("origin","");
	}


	public SkuForm remarkFieldOfProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm remarkFieldOfProduct(String initValue){
		return remarkFieldOfProduct("remark",initValue);
	}
	public SkuForm remarkFieldOfProduct(){
		return remarkFieldOfProduct("remark","");
	}


	public SkuForm brandFieldOfProduct(String parameterName, String initValue){
		FormField field =  brandFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm brandFieldOfProduct(String initValue){
		return brandFieldOfProduct("brand",initValue);
	}
	public SkuForm brandFieldOfProduct(){
		return brandFieldOfProduct("brand","");
	}


	public SkuForm pictureFieldOfProduct(String parameterName, String initValue){
		FormField field =  pictureFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm pictureFieldOfProduct(String initValue){
		return pictureFieldOfProduct("picture",initValue);
	}
	public SkuForm pictureFieldOfProduct(){
		return pictureFieldOfProduct("picture","");
	}


	public SkuForm lastUpdateTimeFieldOfProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkuForm lastUpdateTimeFieldOfProduct(String initValue){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime",initValue);
	}
	public SkuForm lastUpdateTimeFieldOfProduct(){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime","");
	}

	



	public SkuForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public SkuForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public SkuForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public SkuForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public SkuForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public SkuForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public SkuForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public SkuForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public SkuForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public SkuForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public SkuForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public SkuForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public SkuForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public SkuForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public SkuForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public SkuForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public SkuForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public SkuForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public SkuForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public SkuForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public SkuForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public SkuForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public SkuForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public SkuForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public SkuForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public SkuForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public SkuForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public SkuForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public SkuForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public SkuForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public SkuForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public SkuForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public SkuForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkuForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public SkuForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public SkuForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/skuId/");
		this.addFormAction(action);
		return this;
	}

 

	public SkuForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



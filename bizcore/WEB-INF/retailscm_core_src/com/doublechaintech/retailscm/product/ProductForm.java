package com.doublechaintech.retailscm.product;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ProductForm extends BaseForm {
	
	
	public ProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProductForm productIdField(String parameterName, String initValue){
		FormField field = idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public ProductForm productIdField(){
		return productIdField("productId","");
	}


	public ProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProductForm nameField(){
		return nameField("name","");
	}


	public ProductForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public ProductForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public ProductForm originField(String parameterName, String initValue){
		FormField field = originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm originField(String initValue){
		return originField("origin",initValue);
	}
	public ProductForm originField(){
		return originField("origin","");
	}


	public ProductForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public ProductForm remarkField(){
		return remarkField("remark","");
	}


	public ProductForm brandField(String parameterName, String initValue){
		FormField field = brandFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm brandField(String initValue){
		return brandField("brand",initValue);
	}
	public ProductForm brandField(){
		return brandField("brand","");
	}


	public ProductForm pictureField(String parameterName, String initValue){
		FormField field = pictureFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm pictureField(String initValue){
		return pictureField("picture",initValue);
	}
	public ProductForm pictureField(){
		return pictureField("picture","");
	}


	public ProductForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public ProductForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public ProductForm levelThreeCategoryIdFieldOfLevelThreeCategory(String parameterName, String initValue){
		FormField field =  idFromLevelThreeCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm levelThreeCategoryIdFieldOfLevelThreeCategory(String initValue){
		return levelThreeCategoryIdFieldOfLevelThreeCategory("levelThreeCategoryId",initValue);
	}
	public ProductForm levelThreeCategoryIdFieldOfLevelThreeCategory(){
		return levelThreeCategoryIdFieldOfLevelThreeCategory("levelThreeCategoryId","");
	}


	public ProductForm parentCategoryIdFieldOfLevelThreeCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelThreeCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm parentCategoryIdFieldOfLevelThreeCategory(String initValue){
		return parentCategoryIdFieldOfLevelThreeCategory("parentCategoryId",initValue);
	}
	public ProductForm parentCategoryIdFieldOfLevelThreeCategory(){
		return parentCategoryIdFieldOfLevelThreeCategory("parentCategoryId","");
	}


	public ProductForm nameFieldOfLevelThreeCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelThreeCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductForm nameFieldOfLevelThreeCategory(String initValue){
		return nameFieldOfLevelThreeCategory("name",initValue);
	}
	public ProductForm nameFieldOfLevelThreeCategory(){
		return nameFieldOfLevelThreeCategory("name","");
	}

	



	public ProductForm skuIdFieldForSku(String parameterName, String initValue){
		FormField field =  idFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm skuIdFieldForSku(String initValue){
		return skuIdFieldForSku("skuId",initValue);
	}
	public ProductForm skuIdFieldForSku(){
		return skuIdFieldForSku("skuId","");
	}


	public ProductForm nameFieldForSku(String parameterName, String initValue){
		FormField field =  nameFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm nameFieldForSku(String initValue){
		return nameFieldForSku("name",initValue);
	}
	public ProductForm nameFieldForSku(){
		return nameFieldForSku("name","");
	}


	public ProductForm sizeFieldForSku(String parameterName, String initValue){
		FormField field =  sizeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm sizeFieldForSku(String initValue){
		return sizeFieldForSku("size",initValue);
	}
	public ProductForm sizeFieldForSku(){
		return sizeFieldForSku("size","");
	}


	public ProductForm productIdFieldForSku(String parameterName, String initValue){
		FormField field =  productIdFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm productIdFieldForSku(String initValue){
		return productIdFieldForSku("productId",initValue);
	}
	public ProductForm productIdFieldForSku(){
		return productIdFieldForSku("productId","");
	}


	public ProductForm barcodeFieldForSku(String parameterName, String initValue){
		FormField field =  barcodeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm barcodeFieldForSku(String initValue){
		return barcodeFieldForSku("barcode",initValue);
	}
	public ProductForm barcodeFieldForSku(){
		return barcodeFieldForSku("barcode","");
	}


	public ProductForm packageTypeFieldForSku(String parameterName, String initValue){
		FormField field =  packageTypeFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm packageTypeFieldForSku(String initValue){
		return packageTypeFieldForSku("packageType",initValue);
	}
	public ProductForm packageTypeFieldForSku(){
		return packageTypeFieldForSku("packageType","");
	}


	public ProductForm netContentFieldForSku(String parameterName, String initValue){
		FormField field =  netContentFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm netContentFieldForSku(String initValue){
		return netContentFieldForSku("netContent",initValue);
	}
	public ProductForm netContentFieldForSku(){
		return netContentFieldForSku("netContent","");
	}


	public ProductForm priceFieldForSku(String parameterName, String initValue){
		FormField field =  priceFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm priceFieldForSku(String initValue){
		return priceFieldForSku("price",initValue);
	}
	public ProductForm priceFieldForSku(){
		return priceFieldForSku("price","");
	}


	public ProductForm pictureFieldForSku(String parameterName, String initValue){
		FormField field =  pictureFromSku(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductForm pictureFieldForSku(String initValue){
		return pictureFieldForSku("picture",initValue);
	}
	public ProductForm pictureFieldForSku(){
		return pictureFieldForSku("picture","");
	}

	

	
 	public ProductForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/productId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



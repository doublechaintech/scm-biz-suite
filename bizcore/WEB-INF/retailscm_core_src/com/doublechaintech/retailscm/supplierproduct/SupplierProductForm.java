package com.doublechaintech.retailscm.supplierproduct;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplierProductForm extends BaseForm {
	
	
	public SupplierProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplierProductForm supplierProductIdField(String parameterName, String initValue){
		FormField field = idFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm supplierProductIdField(String initValue){
		return supplierProductIdField("supplierProductId",initValue);
	}
	public SupplierProductForm supplierProductIdField(){
		return supplierProductIdField("supplierProductId","");
	}


	public SupplierProductForm productNameField(String parameterName, String initValue){
		FormField field = productNameFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm productNameField(String initValue){
		return productNameField("productName",initValue);
	}
	public SupplierProductForm productNameField(){
		return productNameField("productName","");
	}


	public SupplierProductForm productDescriptionField(String parameterName, String initValue){
		FormField field = productDescriptionFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm productDescriptionField(String initValue){
		return productDescriptionField("productDescription",initValue);
	}
	public SupplierProductForm productDescriptionField(){
		return productDescriptionField("productDescription","");
	}


	public SupplierProductForm productUnitField(String parameterName, String initValue){
		FormField field = productUnitFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm productUnitField(String initValue){
		return productUnitField("productUnit",initValue);
	}
	public SupplierProductForm productUnitField(){
		return productUnitField("productUnit","");
	}


	public SupplierProductForm supplierIdField(String parameterName, String initValue){
		FormField field = supplierIdFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm supplierIdField(String initValue){
		return supplierIdField("supplierId",initValue);
	}
	public SupplierProductForm supplierIdField(){
		return supplierIdField("supplierId","");
	}

	
	


	public SupplierProductForm goodsSupplierIdFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  idFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm goodsSupplierIdFieldOfGoodsSupplier(String initValue){
		return goodsSupplierIdFieldOfGoodsSupplier("goodsSupplierId",initValue);
	}
	public SupplierProductForm goodsSupplierIdFieldOfGoodsSupplier(){
		return goodsSupplierIdFieldOfGoodsSupplier("goodsSupplierId","");
	}


	public SupplierProductForm nameFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  nameFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm nameFieldOfGoodsSupplier(String initValue){
		return nameFieldOfGoodsSupplier("name",initValue);
	}
	public SupplierProductForm nameFieldOfGoodsSupplier(){
		return nameFieldOfGoodsSupplier("name","");
	}


	public SupplierProductForm supplyProductFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  supplyProductFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm supplyProductFieldOfGoodsSupplier(String initValue){
		return supplyProductFieldOfGoodsSupplier("supplyProduct",initValue);
	}
	public SupplierProductForm supplyProductFieldOfGoodsSupplier(){
		return supplyProductFieldOfGoodsSupplier("supplyProduct","");
	}


	public SupplierProductForm belongToIdFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  belongToIdFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm belongToIdFieldOfGoodsSupplier(String initValue){
		return belongToIdFieldOfGoodsSupplier("belongToId",initValue);
	}
	public SupplierProductForm belongToIdFieldOfGoodsSupplier(){
		return belongToIdFieldOfGoodsSupplier("belongToId","");
	}


	public SupplierProductForm contactNumberFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  contactNumberFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm contactNumberFieldOfGoodsSupplier(String initValue){
		return contactNumberFieldOfGoodsSupplier("contactNumber",initValue);
	}
	public SupplierProductForm contactNumberFieldOfGoodsSupplier(){
		return contactNumberFieldOfGoodsSupplier("contactNumber","");
	}


	public SupplierProductForm descriptionFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  descriptionFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm descriptionFieldOfGoodsSupplier(String initValue){
		return descriptionFieldOfGoodsSupplier("description",initValue);
	}
	public SupplierProductForm descriptionFieldOfGoodsSupplier(){
		return descriptionFieldOfGoodsSupplier("description","");
	}


	public SupplierProductForm lastUpdateTimeFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplierProductForm lastUpdateTimeFieldOfGoodsSupplier(String initValue){
		return lastUpdateTimeFieldOfGoodsSupplier("lastUpdateTime",initValue);
	}
	public SupplierProductForm lastUpdateTimeFieldOfGoodsSupplier(){
		return lastUpdateTimeFieldOfGoodsSupplier("lastUpdateTime","");
	}

	



	public SupplierProductForm productSupplyDurationIdFieldForProductSupplyDuration(String parameterName, String initValue){
		FormField field =  idFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm productSupplyDurationIdFieldForProductSupplyDuration(String initValue){
		return productSupplyDurationIdFieldForProductSupplyDuration("productSupplyDurationId",initValue);
	}
	public SupplierProductForm productSupplyDurationIdFieldForProductSupplyDuration(){
		return productSupplyDurationIdFieldForProductSupplyDuration("productSupplyDurationId","");
	}


	public SupplierProductForm quantityFieldForProductSupplyDuration(String parameterName, String initValue){
		FormField field =  quantityFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm quantityFieldForProductSupplyDuration(String initValue){
		return quantityFieldForProductSupplyDuration("quantity",initValue);
	}
	public SupplierProductForm quantityFieldForProductSupplyDuration(){
		return quantityFieldForProductSupplyDuration("quantity","");
	}


	public SupplierProductForm durationFieldForProductSupplyDuration(String parameterName, String initValue){
		FormField field =  durationFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm durationFieldForProductSupplyDuration(String initValue){
		return durationFieldForProductSupplyDuration("duration",initValue);
	}
	public SupplierProductForm durationFieldForProductSupplyDuration(){
		return durationFieldForProductSupplyDuration("duration","");
	}


	public SupplierProductForm priceFieldForProductSupplyDuration(String parameterName, String initValue){
		FormField field =  priceFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm priceFieldForProductSupplyDuration(String initValue){
		return priceFieldForProductSupplyDuration("price",initValue);
	}
	public SupplierProductForm priceFieldForProductSupplyDuration(){
		return priceFieldForProductSupplyDuration("price","");
	}


	public SupplierProductForm productIdFieldForProductSupplyDuration(String parameterName, String initValue){
		FormField field =  productIdFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplierProductForm productIdFieldForProductSupplyDuration(String initValue){
		return productIdFieldForProductSupplyDuration("productId",initValue);
	}
	public SupplierProductForm productIdFieldForProductSupplyDuration(){
		return productIdFieldForProductSupplyDuration("productId","");
	}

	

	
 	public SupplierProductForm transferToAnotherSupplierAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSupplier/supplierProductId/");
		this.addFormAction(action);
		return this;
	}

 

	public SupplierProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



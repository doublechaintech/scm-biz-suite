package com.doublechaintech.retailscm.productsupplyduration;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ProductSupplyDurationForm extends BaseForm {
	
	
	public ProductSupplyDurationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProductSupplyDurationForm productSupplyDurationIdField(String parameterName, String initValue){
		FormField field = idFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductSupplyDurationForm productSupplyDurationIdField(String initValue){
		return productSupplyDurationIdField("productSupplyDurationId",initValue);
	}
	public ProductSupplyDurationForm productSupplyDurationIdField(){
		return productSupplyDurationIdField("productSupplyDurationId","");
	}


	public ProductSupplyDurationForm quantityField(String parameterName, String initValue){
		FormField field = quantityFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductSupplyDurationForm quantityField(String initValue){
		return quantityField("quantity",initValue);
	}
	public ProductSupplyDurationForm quantityField(){
		return quantityField("quantity","");
	}


	public ProductSupplyDurationForm durationField(String parameterName, String initValue){
		FormField field = durationFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductSupplyDurationForm durationField(String initValue){
		return durationField("duration",initValue);
	}
	public ProductSupplyDurationForm durationField(){
		return durationField("duration","");
	}


	public ProductSupplyDurationForm priceField(String parameterName, String initValue){
		FormField field = priceFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductSupplyDurationForm priceField(String initValue){
		return priceField("price",initValue);
	}
	public ProductSupplyDurationForm priceField(){
		return priceField("price","");
	}


	public ProductSupplyDurationForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromProductSupplyDuration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProductSupplyDurationForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public ProductSupplyDurationForm productIdField(){
		return productIdField("productId","");
	}

	
	


	public ProductSupplyDurationForm supplierProductIdFieldOfSupplierProduct(String parameterName, String initValue){
		FormField field =  idFromSupplierProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductSupplyDurationForm supplierProductIdFieldOfSupplierProduct(String initValue){
		return supplierProductIdFieldOfSupplierProduct("supplierProductId",initValue);
	}
	public ProductSupplyDurationForm supplierProductIdFieldOfSupplierProduct(){
		return supplierProductIdFieldOfSupplierProduct("supplierProductId","");
	}


	public ProductSupplyDurationForm productNameFieldOfSupplierProduct(String parameterName, String initValue){
		FormField field =  productNameFromSupplierProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductSupplyDurationForm productNameFieldOfSupplierProduct(String initValue){
		return productNameFieldOfSupplierProduct("productName",initValue);
	}
	public ProductSupplyDurationForm productNameFieldOfSupplierProduct(){
		return productNameFieldOfSupplierProduct("productName","");
	}


	public ProductSupplyDurationForm productDescriptionFieldOfSupplierProduct(String parameterName, String initValue){
		FormField field =  productDescriptionFromSupplierProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductSupplyDurationForm productDescriptionFieldOfSupplierProduct(String initValue){
		return productDescriptionFieldOfSupplierProduct("productDescription",initValue);
	}
	public ProductSupplyDurationForm productDescriptionFieldOfSupplierProduct(){
		return productDescriptionFieldOfSupplierProduct("productDescription","");
	}


	public ProductSupplyDurationForm productUnitFieldOfSupplierProduct(String parameterName, String initValue){
		FormField field =  productUnitFromSupplierProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductSupplyDurationForm productUnitFieldOfSupplierProduct(String initValue){
		return productUnitFieldOfSupplierProduct("productUnit",initValue);
	}
	public ProductSupplyDurationForm productUnitFieldOfSupplierProduct(){
		return productUnitFieldOfSupplierProduct("productUnit","");
	}


	public ProductSupplyDurationForm supplierIdFieldOfSupplierProduct(String parameterName, String initValue){
		FormField field =  supplierIdFromSupplierProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProductSupplyDurationForm supplierIdFieldOfSupplierProduct(String initValue){
		return supplierIdFieldOfSupplierProduct("supplierId",initValue);
	}
	public ProductSupplyDurationForm supplierIdFieldOfSupplierProduct(){
		return supplierIdFieldOfSupplierProduct("supplierId","");
	}

	


	

	
 	public ProductSupplyDurationForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/productSupplyDurationId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProductSupplyDurationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



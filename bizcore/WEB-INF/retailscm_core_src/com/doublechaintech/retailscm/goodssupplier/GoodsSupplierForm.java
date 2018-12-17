package com.doublechaintech.retailscm.goodssupplier;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class GoodsSupplierForm extends BaseForm {
	
	
	public GoodsSupplierForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public GoodsSupplierForm goodsSupplierIdField(String parameterName, String initValue){
		FormField field = idFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm goodsSupplierIdField(String initValue){
		return goodsSupplierIdField("goodsSupplierId",initValue);
	}
	public GoodsSupplierForm goodsSupplierIdField(){
		return goodsSupplierIdField("goodsSupplierId","");
	}


	public GoodsSupplierForm nameField(String parameterName, String initValue){
		FormField field = nameFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public GoodsSupplierForm nameField(){
		return nameField("name","");
	}


	public GoodsSupplierForm supplyProductField(String parameterName, String initValue){
		FormField field = supplyProductFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm supplyProductField(String initValue){
		return supplyProductField("supplyProduct",initValue);
	}
	public GoodsSupplierForm supplyProductField(){
		return supplyProductField("supplyProduct","");
	}


	public GoodsSupplierForm belongToIdField(String parameterName, String initValue){
		FormField field = belongToIdFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm belongToIdField(String initValue){
		return belongToIdField("belongToId",initValue);
	}
	public GoodsSupplierForm belongToIdField(){
		return belongToIdField("belongToId","");
	}


	public GoodsSupplierForm contactNumberField(String parameterName, String initValue){
		FormField field = contactNumberFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm contactNumberField(String initValue){
		return contactNumberField("contactNumber",initValue);
	}
	public GoodsSupplierForm contactNumberField(){
		return contactNumberField("contactNumber","");
	}


	public GoodsSupplierForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public GoodsSupplierForm descriptionField(){
		return descriptionField("description","");
	}


	public GoodsSupplierForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public GoodsSupplierForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public GoodsSupplierForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public GoodsSupplierForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public GoodsSupplierForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public GoodsSupplierForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public GoodsSupplierForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public GoodsSupplierForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public GoodsSupplierForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public GoodsSupplierForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public GoodsSupplierForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public GoodsSupplierForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public GoodsSupplierForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public GoodsSupplierForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public GoodsSupplierForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public GoodsSupplierForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public GoodsSupplierForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public GoodsSupplierForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public GoodsSupplierForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public GoodsSupplierForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public GoodsSupplierForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public GoodsSupplierForm supplierProductIdFieldForSupplierProduct(String parameterName, String initValue){
		FormField field =  idFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm supplierProductIdFieldForSupplierProduct(String initValue){
		return supplierProductIdFieldForSupplierProduct("supplierProductId",initValue);
	}
	public GoodsSupplierForm supplierProductIdFieldForSupplierProduct(){
		return supplierProductIdFieldForSupplierProduct("supplierProductId","");
	}


	public GoodsSupplierForm productNameFieldForSupplierProduct(String parameterName, String initValue){
		FormField field =  productNameFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm productNameFieldForSupplierProduct(String initValue){
		return productNameFieldForSupplierProduct("productName",initValue);
	}
	public GoodsSupplierForm productNameFieldForSupplierProduct(){
		return productNameFieldForSupplierProduct("productName","");
	}


	public GoodsSupplierForm productDescriptionFieldForSupplierProduct(String parameterName, String initValue){
		FormField field =  productDescriptionFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm productDescriptionFieldForSupplierProduct(String initValue){
		return productDescriptionFieldForSupplierProduct("productDescription",initValue);
	}
	public GoodsSupplierForm productDescriptionFieldForSupplierProduct(){
		return productDescriptionFieldForSupplierProduct("productDescription","");
	}


	public GoodsSupplierForm productUnitFieldForSupplierProduct(String parameterName, String initValue){
		FormField field =  productUnitFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm productUnitFieldForSupplierProduct(String initValue){
		return productUnitFieldForSupplierProduct("productUnit",initValue);
	}
	public GoodsSupplierForm productUnitFieldForSupplierProduct(){
		return productUnitFieldForSupplierProduct("productUnit","");
	}


	public GoodsSupplierForm supplierIdFieldForSupplierProduct(String parameterName, String initValue){
		FormField field =  supplierIdFromSupplierProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm supplierIdFieldForSupplierProduct(String initValue){
		return supplierIdFieldForSupplierProduct("supplierId",initValue);
	}
	public GoodsSupplierForm supplierIdFieldForSupplierProduct(){
		return supplierIdFieldForSupplierProduct("supplierId","");
	}


	public GoodsSupplierForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public GoodsSupplierForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public GoodsSupplierForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public GoodsSupplierForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public GoodsSupplierForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public GoodsSupplierForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public GoodsSupplierForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public GoodsSupplierForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public GoodsSupplierForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public GoodsSupplierForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public GoodsSupplierForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public GoodsSupplierForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public GoodsSupplierForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public GoodsSupplierForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public GoodsSupplierForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public GoodsSupplierForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public GoodsSupplierForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public GoodsSupplierForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public GoodsSupplierForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public GoodsSupplierForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public GoodsSupplierForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public GoodsSupplierForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public GoodsSupplierForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public GoodsSupplierForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public GoodsSupplierForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public GoodsSupplierForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}


	public GoodsSupplierForm accountSetIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  idFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm accountSetIdFieldForAccountSet(String initValue){
		return accountSetIdFieldForAccountSet("accountSetId",initValue);
	}
	public GoodsSupplierForm accountSetIdFieldForAccountSet(){
		return accountSetIdFieldForAccountSet("accountSetId","");
	}


	public GoodsSupplierForm nameFieldForAccountSet(String parameterName, String initValue){
		FormField field =  nameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm nameFieldForAccountSet(String initValue){
		return nameFieldForAccountSet("name",initValue);
	}
	public GoodsSupplierForm nameFieldForAccountSet(){
		return nameFieldForAccountSet("name","");
	}


	public GoodsSupplierForm yearSetFieldForAccountSet(String parameterName, String initValue){
		FormField field =  yearSetFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm yearSetFieldForAccountSet(String initValue){
		return yearSetFieldForAccountSet("yearSet",initValue);
	}
	public GoodsSupplierForm yearSetFieldForAccountSet(){
		return yearSetFieldForAccountSet("yearSet","");
	}


	public GoodsSupplierForm effectiveDateFieldForAccountSet(String parameterName, String initValue){
		FormField field =  effectiveDateFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm effectiveDateFieldForAccountSet(String initValue){
		return effectiveDateFieldForAccountSet("effectiveDate",initValue);
	}
	public GoodsSupplierForm effectiveDateFieldForAccountSet(){
		return effectiveDateFieldForAccountSet("effectiveDate","");
	}


	public GoodsSupplierForm accountingSystemFieldForAccountSet(String parameterName, String initValue){
		FormField field =  accountingSystemFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm accountingSystemFieldForAccountSet(String initValue){
		return accountingSystemFieldForAccountSet("accountingSystem",initValue);
	}
	public GoodsSupplierForm accountingSystemFieldForAccountSet(){
		return accountingSystemFieldForAccountSet("accountingSystem","");
	}


	public GoodsSupplierForm domesticCurrencyCodeFieldForAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyCodeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm domesticCurrencyCodeFieldForAccountSet(String initValue){
		return domesticCurrencyCodeFieldForAccountSet("domesticCurrencyCode",initValue);
	}
	public GoodsSupplierForm domesticCurrencyCodeFieldForAccountSet(){
		return domesticCurrencyCodeFieldForAccountSet("domesticCurrencyCode","");
	}


	public GoodsSupplierForm domesticCurrencyNameFieldForAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyNameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm domesticCurrencyNameFieldForAccountSet(String initValue){
		return domesticCurrencyNameFieldForAccountSet("domesticCurrencyName",initValue);
	}
	public GoodsSupplierForm domesticCurrencyNameFieldForAccountSet(){
		return domesticCurrencyNameFieldForAccountSet("domesticCurrencyName","");
	}


	public GoodsSupplierForm openingBankFieldForAccountSet(String parameterName, String initValue){
		FormField field =  openingBankFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm openingBankFieldForAccountSet(String initValue){
		return openingBankFieldForAccountSet("openingBank",initValue);
	}
	public GoodsSupplierForm openingBankFieldForAccountSet(){
		return openingBankFieldForAccountSet("openingBank","");
	}


	public GoodsSupplierForm accountNumberFieldForAccountSet(String parameterName, String initValue){
		FormField field =  accountNumberFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm accountNumberFieldForAccountSet(String initValue){
		return accountNumberFieldForAccountSet("accountNumber",initValue);
	}
	public GoodsSupplierForm accountNumberFieldForAccountSet(){
		return accountNumberFieldForAccountSet("accountNumber","");
	}


	public GoodsSupplierForm countryCenterIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  countryCenterIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm countryCenterIdFieldForAccountSet(String initValue){
		return countryCenterIdFieldForAccountSet("countryCenterId",initValue);
	}
	public GoodsSupplierForm countryCenterIdFieldForAccountSet(){
		return countryCenterIdFieldForAccountSet("countryCenterId","");
	}


	public GoodsSupplierForm retailStoreIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  retailStoreIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm retailStoreIdFieldForAccountSet(String initValue){
		return retailStoreIdFieldForAccountSet("retailStoreId",initValue);
	}
	public GoodsSupplierForm retailStoreIdFieldForAccountSet(){
		return retailStoreIdFieldForAccountSet("retailStoreId","");
	}


	public GoodsSupplierForm goodsSupplierIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  goodsSupplierIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm goodsSupplierIdFieldForAccountSet(String initValue){
		return goodsSupplierIdFieldForAccountSet("goodsSupplierId",initValue);
	}
	public GoodsSupplierForm goodsSupplierIdFieldForAccountSet(){
		return goodsSupplierIdFieldForAccountSet("goodsSupplierId","");
	}


	public GoodsSupplierForm lastUpdateTimeFieldForAccountSet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public GoodsSupplierForm lastUpdateTimeFieldForAccountSet(String initValue){
		return lastUpdateTimeFieldForAccountSet("lastUpdateTime",initValue);
	}
	public GoodsSupplierForm lastUpdateTimeFieldForAccountSet(){
		return lastUpdateTimeFieldForAccountSet("lastUpdateTime","");
	}

	

	
 	public GoodsSupplierForm transferToAnotherBelongToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongTo/goodsSupplierId/");
		this.addFormAction(action);
		return this;
	}

 

	public GoodsSupplierForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



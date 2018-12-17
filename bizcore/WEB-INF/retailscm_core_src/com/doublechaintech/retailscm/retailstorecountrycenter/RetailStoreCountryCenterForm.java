package com.doublechaintech.retailscm.retailstorecountrycenter;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreCountryCenterForm extends BaseForm {
	
	
	public RetailStoreCountryCenterForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreCountryCenterForm retailStoreCountryCenterIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreCountryCenterIdField(String initValue){
		return retailStoreCountryCenterIdField("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreCountryCenterIdField(){
		return retailStoreCountryCenterIdField("retailStoreCountryCenterId","");
	}


	public RetailStoreCountryCenterForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreCountryCenterForm nameField(){
		return nameField("name","");
	}


	public RetailStoreCountryCenterForm serviceNumberField(String parameterName, String initValue){
		FormField field = serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm serviceNumberField(String initValue){
		return serviceNumberField("serviceNumber",initValue);
	}
	public RetailStoreCountryCenterForm serviceNumberField(){
		return serviceNumberField("serviceNumber","");
	}


	public RetailStoreCountryCenterForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public RetailStoreCountryCenterForm foundedField(){
		return foundedField("founded","");
	}


	public RetailStoreCountryCenterForm webSiteField(String parameterName, String initValue){
		FormField field = webSiteFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm webSiteField(String initValue){
		return webSiteField("webSite",initValue);
	}
	public RetailStoreCountryCenterForm webSiteField(){
		return webSiteField("webSite","");
	}


	public RetailStoreCountryCenterForm addressField(String parameterName, String initValue){
		FormField field = addressFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm addressField(String initValue){
		return addressField("address",initValue);
	}
	public RetailStoreCountryCenterForm addressField(){
		return addressField("address","");
	}


	public RetailStoreCountryCenterForm operatedByField(String parameterName, String initValue){
		FormField field = operatedByFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm operatedByField(String initValue){
		return operatedByField("operatedBy",initValue);
	}
	public RetailStoreCountryCenterForm operatedByField(){
		return operatedByField("operatedBy","");
	}


	public RetailStoreCountryCenterForm legalRepresentativeField(String parameterName, String initValue){
		FormField field = legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm legalRepresentativeField(String initValue){
		return legalRepresentativeField("legalRepresentative",initValue);
	}
	public RetailStoreCountryCenterForm legalRepresentativeField(){
		return legalRepresentativeField("legalRepresentative","");
	}


	public RetailStoreCountryCenterForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromRetailStoreCountryCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionField(){
		return descriptionField("description","");
	}

	
	

	



	public RetailStoreCountryCenterForm catalogIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm catalogIdFieldForCatalog(String initValue){
		return catalogIdFieldForCatalog("catalogId",initValue);
	}
	public RetailStoreCountryCenterForm catalogIdFieldForCatalog(){
		return catalogIdFieldForCatalog("catalogId","");
	}


	public RetailStoreCountryCenterForm nameFieldForCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForCatalog(String initValue){
		return nameFieldForCatalog("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForCatalog(){
		return nameFieldForCatalog("name","");
	}


	public RetailStoreCountryCenterForm ownerIdFieldForCatalog(String parameterName, String initValue){
		FormField field =  ownerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm ownerIdFieldForCatalog(String initValue){
		return ownerIdFieldForCatalog("ownerId",initValue);
	}
	public RetailStoreCountryCenterForm ownerIdFieldForCatalog(){
		return ownerIdFieldForCatalog("ownerId","");
	}


	public RetailStoreCountryCenterForm retailStoreProvinceCenterIdFieldForRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreProvinceCenterIdFieldForRetailStoreProvinceCenter(String initValue){
		return retailStoreProvinceCenterIdFieldForRetailStoreProvinceCenter("retailStoreProvinceCenterId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreProvinceCenterIdFieldForRetailStoreProvinceCenter(){
		return retailStoreProvinceCenterIdFieldForRetailStoreProvinceCenter("retailStoreProvinceCenterId","");
	}


	public RetailStoreCountryCenterForm nameFieldForRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForRetailStoreProvinceCenter(String initValue){
		return nameFieldForRetailStoreProvinceCenter("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForRetailStoreProvinceCenter(){
		return nameFieldForRetailStoreProvinceCenter("name","");
	}


	public RetailStoreCountryCenterForm foundedFieldForRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm foundedFieldForRetailStoreProvinceCenter(String initValue){
		return foundedFieldForRetailStoreProvinceCenter("founded",initValue);
	}
	public RetailStoreCountryCenterForm foundedFieldForRetailStoreProvinceCenter(){
		return foundedFieldForRetailStoreProvinceCenter("founded","");
	}


	public RetailStoreCountryCenterForm countryIdFieldForRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  countryIdFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm countryIdFieldForRetailStoreProvinceCenter(String initValue){
		return countryIdFieldForRetailStoreProvinceCenter("countryId",initValue);
	}
	public RetailStoreCountryCenterForm countryIdFieldForRetailStoreProvinceCenter(){
		return countryIdFieldForRetailStoreProvinceCenter("countryId","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStoreProvinceCenter(String initValue){
		return lastUpdateTimeFieldForRetailStoreProvinceCenter("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStoreProvinceCenter(){
		return lastUpdateTimeFieldForRetailStoreProvinceCenter("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm retailStoreIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreIdFieldForRetailStore(String initValue){
		return retailStoreIdFieldForRetailStore("retailStoreId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreIdFieldForRetailStore(){
		return retailStoreIdFieldForRetailStore("retailStoreId","");
	}


	public RetailStoreCountryCenterForm nameFieldForRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForRetailStore(String initValue){
		return nameFieldForRetailStore("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForRetailStore(){
		return nameFieldForRetailStore("name","");
	}


	public RetailStoreCountryCenterForm telephoneFieldForRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm telephoneFieldForRetailStore(String initValue){
		return telephoneFieldForRetailStore("telephone",initValue);
	}
	public RetailStoreCountryCenterForm telephoneFieldForRetailStore(){
		return telephoneFieldForRetailStore("telephone","");
	}


	public RetailStoreCountryCenterForm ownerFieldForRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm ownerFieldForRetailStore(String initValue){
		return ownerFieldForRetailStore("owner",initValue);
	}
	public RetailStoreCountryCenterForm ownerFieldForRetailStore(){
		return ownerFieldForRetailStore("owner","");
	}


	public RetailStoreCountryCenterForm retailStoreCountryCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreCountryCenterIdFieldForRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreCountryCenterIdFieldForRetailStore(){
		return retailStoreCountryCenterIdFieldForRetailStore("retailStoreCountryCenterId","");
	}


	public RetailStoreCountryCenterForm cityServiceCenterIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm cityServiceCenterIdFieldForRetailStore(String initValue){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId",initValue);
	}
	public RetailStoreCountryCenterForm cityServiceCenterIdFieldForRetailStore(){
		return cityServiceCenterIdFieldForRetailStore("cityServiceCenterId","");
	}


	public RetailStoreCountryCenterForm creationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm creationIdFieldForRetailStore(String initValue){
		return creationIdFieldForRetailStore("creationId",initValue);
	}
	public RetailStoreCountryCenterForm creationIdFieldForRetailStore(){
		return creationIdFieldForRetailStore("creationId","");
	}


	public RetailStoreCountryCenterForm investmentInvitationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm investmentInvitationIdFieldForRetailStore(String initValue){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId",initValue);
	}
	public RetailStoreCountryCenterForm investmentInvitationIdFieldForRetailStore(){
		return investmentInvitationIdFieldForRetailStore("investmentInvitationId","");
	}


	public RetailStoreCountryCenterForm franchisingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm franchisingIdFieldForRetailStore(String initValue){
		return franchisingIdFieldForRetailStore("franchisingId",initValue);
	}
	public RetailStoreCountryCenterForm franchisingIdFieldForRetailStore(){
		return franchisingIdFieldForRetailStore("franchisingId","");
	}


	public RetailStoreCountryCenterForm decorationIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm decorationIdFieldForRetailStore(String initValue){
		return decorationIdFieldForRetailStore("decorationId",initValue);
	}
	public RetailStoreCountryCenterForm decorationIdFieldForRetailStore(){
		return decorationIdFieldForRetailStore("decorationId","");
	}


	public RetailStoreCountryCenterForm openingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm openingIdFieldForRetailStore(String initValue){
		return openingIdFieldForRetailStore("openingId",initValue);
	}
	public RetailStoreCountryCenterForm openingIdFieldForRetailStore(){
		return openingIdFieldForRetailStore("openingId","");
	}


	public RetailStoreCountryCenterForm closingIdFieldForRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm closingIdFieldForRetailStore(String initValue){
		return closingIdFieldForRetailStore("closingId",initValue);
	}
	public RetailStoreCountryCenterForm closingIdFieldForRetailStore(){
		return closingIdFieldForRetailStore("closingId","");
	}


	public RetailStoreCountryCenterForm foundedFieldForRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm foundedFieldForRetailStore(String initValue){
		return foundedFieldForRetailStore("founded",initValue);
	}
	public RetailStoreCountryCenterForm foundedFieldForRetailStore(){
		return foundedFieldForRetailStore("founded","");
	}


	public RetailStoreCountryCenterForm latitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm latitudeFieldForRetailStore(String initValue){
		return latitudeFieldForRetailStore("latitude",initValue);
	}
	public RetailStoreCountryCenterForm latitudeFieldForRetailStore(){
		return latitudeFieldForRetailStore("latitude","");
	}


	public RetailStoreCountryCenterForm longitudeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm longitudeFieldForRetailStore(String initValue){
		return longitudeFieldForRetailStore("longitude",initValue);
	}
	public RetailStoreCountryCenterForm longitudeFieldForRetailStore(){
		return longitudeFieldForRetailStore("longitude","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForRetailStore(String initValue){
		return descriptionFieldForRetailStore("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForRetailStore(){
		return descriptionFieldForRetailStore("description","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStore(String initValue){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStore(){
		return lastUpdateTimeFieldForRetailStore("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm currentStatusFieldForRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm currentStatusFieldForRetailStore(String initValue){
		return currentStatusFieldForRetailStore("currentStatus",initValue);
	}
	public RetailStoreCountryCenterForm currentStatusFieldForRetailStore(){
		return currentStatusFieldForRetailStore("currentStatus","");
	}


	public RetailStoreCountryCenterForm retailStoreMemberIdFieldForRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreMemberIdFieldForRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldForRetailStoreMember("retailStoreMemberId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreMemberIdFieldForRetailStoreMember(){
		return retailStoreMemberIdFieldForRetailStoreMember("retailStoreMemberId","");
	}


	public RetailStoreCountryCenterForm nameFieldForRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForRetailStoreMember(String initValue){
		return nameFieldForRetailStoreMember("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForRetailStoreMember(){
		return nameFieldForRetailStoreMember("name","");
	}


	public RetailStoreCountryCenterForm mobilePhoneFieldForRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm mobilePhoneFieldForRetailStoreMember(String initValue){
		return mobilePhoneFieldForRetailStoreMember("mobilePhone",initValue);
	}
	public RetailStoreCountryCenterForm mobilePhoneFieldForRetailStoreMember(){
		return mobilePhoneFieldForRetailStoreMember("mobilePhone","");
	}


	public RetailStoreCountryCenterForm ownerIdFieldForRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm ownerIdFieldForRetailStoreMember(String initValue){
		return ownerIdFieldForRetailStoreMember("ownerId",initValue);
	}
	public RetailStoreCountryCenterForm ownerIdFieldForRetailStoreMember(){
		return ownerIdFieldForRetailStoreMember("ownerId","");
	}


	public RetailStoreCountryCenterForm goodsSupplierIdFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  idFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm goodsSupplierIdFieldForGoodsSupplier(String initValue){
		return goodsSupplierIdFieldForGoodsSupplier("goodsSupplierId",initValue);
	}
	public RetailStoreCountryCenterForm goodsSupplierIdFieldForGoodsSupplier(){
		return goodsSupplierIdFieldForGoodsSupplier("goodsSupplierId","");
	}


	public RetailStoreCountryCenterForm nameFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  nameFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForGoodsSupplier(String initValue){
		return nameFieldForGoodsSupplier("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForGoodsSupplier(){
		return nameFieldForGoodsSupplier("name","");
	}


	public RetailStoreCountryCenterForm supplyProductFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  supplyProductFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm supplyProductFieldForGoodsSupplier(String initValue){
		return supplyProductFieldForGoodsSupplier("supplyProduct",initValue);
	}
	public RetailStoreCountryCenterForm supplyProductFieldForGoodsSupplier(){
		return supplyProductFieldForGoodsSupplier("supplyProduct","");
	}


	public RetailStoreCountryCenterForm belongToIdFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  belongToIdFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm belongToIdFieldForGoodsSupplier(String initValue){
		return belongToIdFieldForGoodsSupplier("belongToId",initValue);
	}
	public RetailStoreCountryCenterForm belongToIdFieldForGoodsSupplier(){
		return belongToIdFieldForGoodsSupplier("belongToId","");
	}


	public RetailStoreCountryCenterForm contactNumberFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  contactNumberFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm contactNumberFieldForGoodsSupplier(String initValue){
		return contactNumberFieldForGoodsSupplier("contactNumber",initValue);
	}
	public RetailStoreCountryCenterForm contactNumberFieldForGoodsSupplier(){
		return contactNumberFieldForGoodsSupplier("contactNumber","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  descriptionFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForGoodsSupplier(String initValue){
		return descriptionFieldForGoodsSupplier("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForGoodsSupplier(){
		return descriptionFieldForGoodsSupplier("description","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForGoodsSupplier(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsSupplier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForGoodsSupplier(String initValue){
		return lastUpdateTimeFieldForGoodsSupplier("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForGoodsSupplier(){
		return lastUpdateTimeFieldForGoodsSupplier("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm supplyOrderIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm supplyOrderIdFieldForSupplyOrder(String initValue){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId",initValue);
	}
	public RetailStoreCountryCenterForm supplyOrderIdFieldForSupplyOrder(){
		return supplyOrderIdFieldForSupplyOrder("supplyOrderId","");
	}


	public RetailStoreCountryCenterForm buyerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm buyerIdFieldForSupplyOrder(String initValue){
		return buyerIdFieldForSupplyOrder("buyerId",initValue);
	}
	public RetailStoreCountryCenterForm buyerIdFieldForSupplyOrder(){
		return buyerIdFieldForSupplyOrder("buyerId","");
	}


	public RetailStoreCountryCenterForm sellerIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm sellerIdFieldForSupplyOrder(String initValue){
		return sellerIdFieldForSupplyOrder("sellerId",initValue);
	}
	public RetailStoreCountryCenterForm sellerIdFieldForSupplyOrder(){
		return sellerIdFieldForSupplyOrder("sellerId","");
	}


	public RetailStoreCountryCenterForm titleFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm titleFieldForSupplyOrder(String initValue){
		return titleFieldForSupplyOrder("title",initValue);
	}
	public RetailStoreCountryCenterForm titleFieldForSupplyOrder(){
		return titleFieldForSupplyOrder("title","");
	}


	public RetailStoreCountryCenterForm totalAmountFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm totalAmountFieldForSupplyOrder(String initValue){
		return totalAmountFieldForSupplyOrder("totalAmount",initValue);
	}
	public RetailStoreCountryCenterForm totalAmountFieldForSupplyOrder(){
		return totalAmountFieldForSupplyOrder("totalAmount","");
	}


	public RetailStoreCountryCenterForm confirmationIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm confirmationIdFieldForSupplyOrder(String initValue){
		return confirmationIdFieldForSupplyOrder("confirmationId",initValue);
	}
	public RetailStoreCountryCenterForm confirmationIdFieldForSupplyOrder(){
		return confirmationIdFieldForSupplyOrder("confirmationId","");
	}


	public RetailStoreCountryCenterForm approvalIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm approvalIdFieldForSupplyOrder(String initValue){
		return approvalIdFieldForSupplyOrder("approvalId",initValue);
	}
	public RetailStoreCountryCenterForm approvalIdFieldForSupplyOrder(){
		return approvalIdFieldForSupplyOrder("approvalId","");
	}


	public RetailStoreCountryCenterForm processingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm processingIdFieldForSupplyOrder(String initValue){
		return processingIdFieldForSupplyOrder("processingId",initValue);
	}
	public RetailStoreCountryCenterForm processingIdFieldForSupplyOrder(){
		return processingIdFieldForSupplyOrder("processingId","");
	}


	public RetailStoreCountryCenterForm pickingIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm pickingIdFieldForSupplyOrder(String initValue){
		return pickingIdFieldForSupplyOrder("pickingId",initValue);
	}
	public RetailStoreCountryCenterForm pickingIdFieldForSupplyOrder(){
		return pickingIdFieldForSupplyOrder("pickingId","");
	}


	public RetailStoreCountryCenterForm shipmentIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm shipmentIdFieldForSupplyOrder(String initValue){
		return shipmentIdFieldForSupplyOrder("shipmentId",initValue);
	}
	public RetailStoreCountryCenterForm shipmentIdFieldForSupplyOrder(){
		return shipmentIdFieldForSupplyOrder("shipmentId","");
	}


	public RetailStoreCountryCenterForm deliveryIdFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm deliveryIdFieldForSupplyOrder(String initValue){
		return deliveryIdFieldForSupplyOrder("deliveryId",initValue);
	}
	public RetailStoreCountryCenterForm deliveryIdFieldForSupplyOrder(){
		return deliveryIdFieldForSupplyOrder("deliveryId","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForSupplyOrder(String initValue){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForSupplyOrder(){
		return lastUpdateTimeFieldForSupplyOrder("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm currentStatusFieldForSupplyOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm currentStatusFieldForSupplyOrder(String initValue){
		return currentStatusFieldForSupplyOrder("currentStatus",initValue);
	}
	public RetailStoreCountryCenterForm currentStatusFieldForSupplyOrder(){
		return currentStatusFieldForSupplyOrder("currentStatus","");
	}


	public RetailStoreCountryCenterForm retailStoreOrderIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  idFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreOrderIdFieldForRetailStoreOrder(String initValue){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreOrderIdFieldForRetailStoreOrder(){
		return retailStoreOrderIdFieldForRetailStoreOrder("retailStoreOrderId","");
	}


	public RetailStoreCountryCenterForm buyerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  buyerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm buyerIdFieldForRetailStoreOrder(String initValue){
		return buyerIdFieldForRetailStoreOrder("buyerId",initValue);
	}
	public RetailStoreCountryCenterForm buyerIdFieldForRetailStoreOrder(){
		return buyerIdFieldForRetailStoreOrder("buyerId","");
	}


	public RetailStoreCountryCenterForm sellerIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  sellerIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm sellerIdFieldForRetailStoreOrder(String initValue){
		return sellerIdFieldForRetailStoreOrder("sellerId",initValue);
	}
	public RetailStoreCountryCenterForm sellerIdFieldForRetailStoreOrder(){
		return sellerIdFieldForRetailStoreOrder("sellerId","");
	}


	public RetailStoreCountryCenterForm titleFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  titleFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm titleFieldForRetailStoreOrder(String initValue){
		return titleFieldForRetailStoreOrder("title",initValue);
	}
	public RetailStoreCountryCenterForm titleFieldForRetailStoreOrder(){
		return titleFieldForRetailStoreOrder("title","");
	}


	public RetailStoreCountryCenterForm totalAmountFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  totalAmountFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm totalAmountFieldForRetailStoreOrder(String initValue){
		return totalAmountFieldForRetailStoreOrder("totalAmount",initValue);
	}
	public RetailStoreCountryCenterForm totalAmountFieldForRetailStoreOrder(){
		return totalAmountFieldForRetailStoreOrder("totalAmount","");
	}


	public RetailStoreCountryCenterForm confirmationIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm confirmationIdFieldForRetailStoreOrder(String initValue){
		return confirmationIdFieldForRetailStoreOrder("confirmationId",initValue);
	}
	public RetailStoreCountryCenterForm confirmationIdFieldForRetailStoreOrder(){
		return confirmationIdFieldForRetailStoreOrder("confirmationId","");
	}


	public RetailStoreCountryCenterForm approvalIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm approvalIdFieldForRetailStoreOrder(String initValue){
		return approvalIdFieldForRetailStoreOrder("approvalId",initValue);
	}
	public RetailStoreCountryCenterForm approvalIdFieldForRetailStoreOrder(){
		return approvalIdFieldForRetailStoreOrder("approvalId","");
	}


	public RetailStoreCountryCenterForm processingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  processingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm processingIdFieldForRetailStoreOrder(String initValue){
		return processingIdFieldForRetailStoreOrder("processingId",initValue);
	}
	public RetailStoreCountryCenterForm processingIdFieldForRetailStoreOrder(){
		return processingIdFieldForRetailStoreOrder("processingId","");
	}


	public RetailStoreCountryCenterForm pickingIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  pickingIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm pickingIdFieldForRetailStoreOrder(String initValue){
		return pickingIdFieldForRetailStoreOrder("pickingId",initValue);
	}
	public RetailStoreCountryCenterForm pickingIdFieldForRetailStoreOrder(){
		return pickingIdFieldForRetailStoreOrder("pickingId","");
	}


	public RetailStoreCountryCenterForm shipmentIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm shipmentIdFieldForRetailStoreOrder(String initValue){
		return shipmentIdFieldForRetailStoreOrder("shipmentId",initValue);
	}
	public RetailStoreCountryCenterForm shipmentIdFieldForRetailStoreOrder(){
		return shipmentIdFieldForRetailStoreOrder("shipmentId","");
	}


	public RetailStoreCountryCenterForm deliveryIdFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm deliveryIdFieldForRetailStoreOrder(String initValue){
		return deliveryIdFieldForRetailStoreOrder("deliveryId",initValue);
	}
	public RetailStoreCountryCenterForm deliveryIdFieldForRetailStoreOrder(){
		return deliveryIdFieldForRetailStoreOrder("deliveryId","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStoreOrder(String initValue){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForRetailStoreOrder(){
		return lastUpdateTimeFieldForRetailStoreOrder("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm currentStatusFieldForRetailStoreOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStoreOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm currentStatusFieldForRetailStoreOrder(String initValue){
		return currentStatusFieldForRetailStoreOrder("currentStatus",initValue);
	}
	public RetailStoreCountryCenterForm currentStatusFieldForRetailStoreOrder(){
		return currentStatusFieldForRetailStoreOrder("currentStatus","");
	}


	public RetailStoreCountryCenterForm warehouseIdFieldForWarehouse(String parameterName, String initValue){
		FormField field =  idFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm warehouseIdFieldForWarehouse(String initValue){
		return warehouseIdFieldForWarehouse("warehouseId",initValue);
	}
	public RetailStoreCountryCenterForm warehouseIdFieldForWarehouse(){
		return warehouseIdFieldForWarehouse("warehouseId","");
	}


	public RetailStoreCountryCenterForm locationFieldForWarehouse(String parameterName, String initValue){
		FormField field =  locationFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm locationFieldForWarehouse(String initValue){
		return locationFieldForWarehouse("location",initValue);
	}
	public RetailStoreCountryCenterForm locationFieldForWarehouse(){
		return locationFieldForWarehouse("location","");
	}


	public RetailStoreCountryCenterForm contactNumberFieldForWarehouse(String parameterName, String initValue){
		FormField field =  contactNumberFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm contactNumberFieldForWarehouse(String initValue){
		return contactNumberFieldForWarehouse("contactNumber",initValue);
	}
	public RetailStoreCountryCenterForm contactNumberFieldForWarehouse(){
		return contactNumberFieldForWarehouse("contactNumber","");
	}


	public RetailStoreCountryCenterForm totalAreaFieldForWarehouse(String parameterName, String initValue){
		FormField field =  totalAreaFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm totalAreaFieldForWarehouse(String initValue){
		return totalAreaFieldForWarehouse("totalArea",initValue);
	}
	public RetailStoreCountryCenterForm totalAreaFieldForWarehouse(){
		return totalAreaFieldForWarehouse("totalArea","");
	}


	public RetailStoreCountryCenterForm ownerIdFieldForWarehouse(String parameterName, String initValue){
		FormField field =  ownerIdFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm ownerIdFieldForWarehouse(String initValue){
		return ownerIdFieldForWarehouse("ownerId",initValue);
	}
	public RetailStoreCountryCenterForm ownerIdFieldForWarehouse(){
		return ownerIdFieldForWarehouse("ownerId","");
	}


	public RetailStoreCountryCenterForm latitudeFieldForWarehouse(String parameterName, String initValue){
		FormField field =  latitudeFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm latitudeFieldForWarehouse(String initValue){
		return latitudeFieldForWarehouse("latitude",initValue);
	}
	public RetailStoreCountryCenterForm latitudeFieldForWarehouse(){
		return latitudeFieldForWarehouse("latitude","");
	}


	public RetailStoreCountryCenterForm longitudeFieldForWarehouse(String parameterName, String initValue){
		FormField field =  longitudeFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm longitudeFieldForWarehouse(String initValue){
		return longitudeFieldForWarehouse("longitude",initValue);
	}
	public RetailStoreCountryCenterForm longitudeFieldForWarehouse(){
		return longitudeFieldForWarehouse("longitude","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForWarehouse(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWarehouse(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForWarehouse(String initValue){
		return lastUpdateTimeFieldForWarehouse("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForWarehouse(){
		return lastUpdateTimeFieldForWarehouse("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm transportFleetIdFieldForTransportFleet(String parameterName, String initValue){
		FormField field =  idFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm transportFleetIdFieldForTransportFleet(String initValue){
		return transportFleetIdFieldForTransportFleet("transportFleetId",initValue);
	}
	public RetailStoreCountryCenterForm transportFleetIdFieldForTransportFleet(){
		return transportFleetIdFieldForTransportFleet("transportFleetId","");
	}


	public RetailStoreCountryCenterForm nameFieldForTransportFleet(String parameterName, String initValue){
		FormField field =  nameFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForTransportFleet(String initValue){
		return nameFieldForTransportFleet("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForTransportFleet(){
		return nameFieldForTransportFleet("name","");
	}


	public RetailStoreCountryCenterForm contactNumberFieldForTransportFleet(String parameterName, String initValue){
		FormField field =  contactNumberFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm contactNumberFieldForTransportFleet(String initValue){
		return contactNumberFieldForTransportFleet("contactNumber",initValue);
	}
	public RetailStoreCountryCenterForm contactNumberFieldForTransportFleet(){
		return contactNumberFieldForTransportFleet("contactNumber","");
	}


	public RetailStoreCountryCenterForm ownerIdFieldForTransportFleet(String parameterName, String initValue){
		FormField field =  ownerIdFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm ownerIdFieldForTransportFleet(String initValue){
		return ownerIdFieldForTransportFleet("ownerId",initValue);
	}
	public RetailStoreCountryCenterForm ownerIdFieldForTransportFleet(){
		return ownerIdFieldForTransportFleet("ownerId","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForTransportFleet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromTransportFleet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForTransportFleet(String initValue){
		return lastUpdateTimeFieldForTransportFleet("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForTransportFleet(){
		return lastUpdateTimeFieldForTransportFleet("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm accountSetIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  idFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm accountSetIdFieldForAccountSet(String initValue){
		return accountSetIdFieldForAccountSet("accountSetId",initValue);
	}
	public RetailStoreCountryCenterForm accountSetIdFieldForAccountSet(){
		return accountSetIdFieldForAccountSet("accountSetId","");
	}


	public RetailStoreCountryCenterForm nameFieldForAccountSet(String parameterName, String initValue){
		FormField field =  nameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForAccountSet(String initValue){
		return nameFieldForAccountSet("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForAccountSet(){
		return nameFieldForAccountSet("name","");
	}


	public RetailStoreCountryCenterForm yearSetFieldForAccountSet(String parameterName, String initValue){
		FormField field =  yearSetFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm yearSetFieldForAccountSet(String initValue){
		return yearSetFieldForAccountSet("yearSet",initValue);
	}
	public RetailStoreCountryCenterForm yearSetFieldForAccountSet(){
		return yearSetFieldForAccountSet("yearSet","");
	}


	public RetailStoreCountryCenterForm effectiveDateFieldForAccountSet(String parameterName, String initValue){
		FormField field =  effectiveDateFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm effectiveDateFieldForAccountSet(String initValue){
		return effectiveDateFieldForAccountSet("effectiveDate",initValue);
	}
	public RetailStoreCountryCenterForm effectiveDateFieldForAccountSet(){
		return effectiveDateFieldForAccountSet("effectiveDate","");
	}


	public RetailStoreCountryCenterForm accountingSystemFieldForAccountSet(String parameterName, String initValue){
		FormField field =  accountingSystemFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm accountingSystemFieldForAccountSet(String initValue){
		return accountingSystemFieldForAccountSet("accountingSystem",initValue);
	}
	public RetailStoreCountryCenterForm accountingSystemFieldForAccountSet(){
		return accountingSystemFieldForAccountSet("accountingSystem","");
	}


	public RetailStoreCountryCenterForm domesticCurrencyCodeFieldForAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyCodeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm domesticCurrencyCodeFieldForAccountSet(String initValue){
		return domesticCurrencyCodeFieldForAccountSet("domesticCurrencyCode",initValue);
	}
	public RetailStoreCountryCenterForm domesticCurrencyCodeFieldForAccountSet(){
		return domesticCurrencyCodeFieldForAccountSet("domesticCurrencyCode","");
	}


	public RetailStoreCountryCenterForm domesticCurrencyNameFieldForAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyNameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm domesticCurrencyNameFieldForAccountSet(String initValue){
		return domesticCurrencyNameFieldForAccountSet("domesticCurrencyName",initValue);
	}
	public RetailStoreCountryCenterForm domesticCurrencyNameFieldForAccountSet(){
		return domesticCurrencyNameFieldForAccountSet("domesticCurrencyName","");
	}


	public RetailStoreCountryCenterForm openingBankFieldForAccountSet(String parameterName, String initValue){
		FormField field =  openingBankFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm openingBankFieldForAccountSet(String initValue){
		return openingBankFieldForAccountSet("openingBank",initValue);
	}
	public RetailStoreCountryCenterForm openingBankFieldForAccountSet(){
		return openingBankFieldForAccountSet("openingBank","");
	}


	public RetailStoreCountryCenterForm accountNumberFieldForAccountSet(String parameterName, String initValue){
		FormField field =  accountNumberFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm accountNumberFieldForAccountSet(String initValue){
		return accountNumberFieldForAccountSet("accountNumber",initValue);
	}
	public RetailStoreCountryCenterForm accountNumberFieldForAccountSet(){
		return accountNumberFieldForAccountSet("accountNumber","");
	}


	public RetailStoreCountryCenterForm countryCenterIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  countryCenterIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm countryCenterIdFieldForAccountSet(String initValue){
		return countryCenterIdFieldForAccountSet("countryCenterId",initValue);
	}
	public RetailStoreCountryCenterForm countryCenterIdFieldForAccountSet(){
		return countryCenterIdFieldForAccountSet("countryCenterId","");
	}


	public RetailStoreCountryCenterForm retailStoreIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  retailStoreIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm retailStoreIdFieldForAccountSet(String initValue){
		return retailStoreIdFieldForAccountSet("retailStoreId",initValue);
	}
	public RetailStoreCountryCenterForm retailStoreIdFieldForAccountSet(){
		return retailStoreIdFieldForAccountSet("retailStoreId","");
	}


	public RetailStoreCountryCenterForm goodsSupplierIdFieldForAccountSet(String parameterName, String initValue){
		FormField field =  goodsSupplierIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm goodsSupplierIdFieldForAccountSet(String initValue){
		return goodsSupplierIdFieldForAccountSet("goodsSupplierId",initValue);
	}
	public RetailStoreCountryCenterForm goodsSupplierIdFieldForAccountSet(){
		return goodsSupplierIdFieldForAccountSet("goodsSupplierId","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForAccountSet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForAccountSet(String initValue){
		return lastUpdateTimeFieldForAccountSet("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForAccountSet(){
		return lastUpdateTimeFieldForAccountSet("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm levelOneDepartmentIdFieldForLevelOneDepartment(String parameterName, String initValue){
		FormField field =  idFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm levelOneDepartmentIdFieldForLevelOneDepartment(String initValue){
		return levelOneDepartmentIdFieldForLevelOneDepartment("levelOneDepartmentId",initValue);
	}
	public RetailStoreCountryCenterForm levelOneDepartmentIdFieldForLevelOneDepartment(){
		return levelOneDepartmentIdFieldForLevelOneDepartment("levelOneDepartmentId","");
	}


	public RetailStoreCountryCenterForm belongsToIdFieldForLevelOneDepartment(String parameterName, String initValue){
		FormField field =  belongsToIdFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm belongsToIdFieldForLevelOneDepartment(String initValue){
		return belongsToIdFieldForLevelOneDepartment("belongsToId",initValue);
	}
	public RetailStoreCountryCenterForm belongsToIdFieldForLevelOneDepartment(){
		return belongsToIdFieldForLevelOneDepartment("belongsToId","");
	}


	public RetailStoreCountryCenterForm nameFieldForLevelOneDepartment(String parameterName, String initValue){
		FormField field =  nameFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForLevelOneDepartment(String initValue){
		return nameFieldForLevelOneDepartment("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForLevelOneDepartment(){
		return nameFieldForLevelOneDepartment("name","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForLevelOneDepartment(String parameterName, String initValue){
		FormField field =  descriptionFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForLevelOneDepartment(String initValue){
		return descriptionFieldForLevelOneDepartment("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForLevelOneDepartment(){
		return descriptionFieldForLevelOneDepartment("description","");
	}


	public RetailStoreCountryCenterForm managerFieldForLevelOneDepartment(String parameterName, String initValue){
		FormField field =  managerFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm managerFieldForLevelOneDepartment(String initValue){
		return managerFieldForLevelOneDepartment("manager",initValue);
	}
	public RetailStoreCountryCenterForm managerFieldForLevelOneDepartment(){
		return managerFieldForLevelOneDepartment("manager","");
	}


	public RetailStoreCountryCenterForm foundedFieldForLevelOneDepartment(String parameterName, String initValue){
		FormField field =  foundedFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm foundedFieldForLevelOneDepartment(String initValue){
		return foundedFieldForLevelOneDepartment("founded",initValue);
	}
	public RetailStoreCountryCenterForm foundedFieldForLevelOneDepartment(){
		return foundedFieldForLevelOneDepartment("founded","");
	}


	public RetailStoreCountryCenterForm skillTypeIdFieldForSkillType(String parameterName, String initValue){
		FormField field =  idFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm skillTypeIdFieldForSkillType(String initValue){
		return skillTypeIdFieldForSkillType("skillTypeId",initValue);
	}
	public RetailStoreCountryCenterForm skillTypeIdFieldForSkillType(){
		return skillTypeIdFieldForSkillType("skillTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForSkillType(String parameterName, String initValue){
		FormField field =  codeFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForSkillType(String initValue){
		return codeFieldForSkillType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForSkillType(){
		return codeFieldForSkillType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForSkillType(String parameterName, String initValue){
		FormField field =  companyIdFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForSkillType(String initValue){
		return companyIdFieldForSkillType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForSkillType(){
		return companyIdFieldForSkillType("companyId","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForSkillType(String parameterName, String initValue){
		FormField field =  descriptionFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForSkillType(String initValue){
		return descriptionFieldForSkillType("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForSkillType(){
		return descriptionFieldForSkillType("description","");
	}


	public RetailStoreCountryCenterForm responsibilityTypeIdFieldForResponsibilityType(String parameterName, String initValue){
		FormField field =  idFromResponsibilityType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm responsibilityTypeIdFieldForResponsibilityType(String initValue){
		return responsibilityTypeIdFieldForResponsibilityType("responsibilityTypeId",initValue);
	}
	public RetailStoreCountryCenterForm responsibilityTypeIdFieldForResponsibilityType(){
		return responsibilityTypeIdFieldForResponsibilityType("responsibilityTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForResponsibilityType(String parameterName, String initValue){
		FormField field =  codeFromResponsibilityType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForResponsibilityType(String initValue){
		return codeFieldForResponsibilityType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForResponsibilityType(){
		return codeFieldForResponsibilityType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForResponsibilityType(String parameterName, String initValue){
		FormField field =  companyIdFromResponsibilityType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForResponsibilityType(String initValue){
		return companyIdFieldForResponsibilityType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForResponsibilityType(){
		return companyIdFieldForResponsibilityType("companyId","");
	}


	public RetailStoreCountryCenterForm baseDescriptionFieldForResponsibilityType(String parameterName, String initValue){
		FormField field =  baseDescriptionFromResponsibilityType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm baseDescriptionFieldForResponsibilityType(String initValue){
		return baseDescriptionFieldForResponsibilityType("baseDescription",initValue);
	}
	public RetailStoreCountryCenterForm baseDescriptionFieldForResponsibilityType(){
		return baseDescriptionFieldForResponsibilityType("baseDescription","");
	}


	public RetailStoreCountryCenterForm detailDescriptionFieldForResponsibilityType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromResponsibilityType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm detailDescriptionFieldForResponsibilityType(String initValue){
		return detailDescriptionFieldForResponsibilityType("detailDescription",initValue);
	}
	public RetailStoreCountryCenterForm detailDescriptionFieldForResponsibilityType(){
		return detailDescriptionFieldForResponsibilityType("detailDescription","");
	}


	public RetailStoreCountryCenterForm terminationReasonIdFieldForTerminationReason(String parameterName, String initValue){
		FormField field =  idFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm terminationReasonIdFieldForTerminationReason(String initValue){
		return terminationReasonIdFieldForTerminationReason("terminationReasonId",initValue);
	}
	public RetailStoreCountryCenterForm terminationReasonIdFieldForTerminationReason(){
		return terminationReasonIdFieldForTerminationReason("terminationReasonId","");
	}


	public RetailStoreCountryCenterForm codeFieldForTerminationReason(String parameterName, String initValue){
		FormField field =  codeFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForTerminationReason(String initValue){
		return codeFieldForTerminationReason("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForTerminationReason(){
		return codeFieldForTerminationReason("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForTerminationReason(String parameterName, String initValue){
		FormField field =  companyIdFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForTerminationReason(String initValue){
		return companyIdFieldForTerminationReason("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForTerminationReason(){
		return companyIdFieldForTerminationReason("companyId","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForTerminationReason(String parameterName, String initValue){
		FormField field =  descriptionFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForTerminationReason(String initValue){
		return descriptionFieldForTerminationReason("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForTerminationReason(){
		return descriptionFieldForTerminationReason("description","");
	}


	public RetailStoreCountryCenterForm terminationTypeIdFieldForTerminationType(String parameterName, String initValue){
		FormField field =  idFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm terminationTypeIdFieldForTerminationType(String initValue){
		return terminationTypeIdFieldForTerminationType("terminationTypeId",initValue);
	}
	public RetailStoreCountryCenterForm terminationTypeIdFieldForTerminationType(){
		return terminationTypeIdFieldForTerminationType("terminationTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForTerminationType(String parameterName, String initValue){
		FormField field =  codeFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForTerminationType(String initValue){
		return codeFieldForTerminationType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForTerminationType(){
		return codeFieldForTerminationType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForTerminationType(String parameterName, String initValue){
		FormField field =  companyIdFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForTerminationType(String initValue){
		return companyIdFieldForTerminationType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForTerminationType(){
		return companyIdFieldForTerminationType("companyId","");
	}


	public RetailStoreCountryCenterForm baseDescriptionFieldForTerminationType(String parameterName, String initValue){
		FormField field =  baseDescriptionFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm baseDescriptionFieldForTerminationType(String initValue){
		return baseDescriptionFieldForTerminationType("baseDescription",initValue);
	}
	public RetailStoreCountryCenterForm baseDescriptionFieldForTerminationType(){
		return baseDescriptionFieldForTerminationType("baseDescription","");
	}


	public RetailStoreCountryCenterForm detailDescriptionFieldForTerminationType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm detailDescriptionFieldForTerminationType(String initValue){
		return detailDescriptionFieldForTerminationType("detailDescription",initValue);
	}
	public RetailStoreCountryCenterForm detailDescriptionFieldForTerminationType(){
		return detailDescriptionFieldForTerminationType("detailDescription","");
	}


	public RetailStoreCountryCenterForm occupationTypeIdFieldForOccupationType(String parameterName, String initValue){
		FormField field =  idFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm occupationTypeIdFieldForOccupationType(String initValue){
		return occupationTypeIdFieldForOccupationType("occupationTypeId",initValue);
	}
	public RetailStoreCountryCenterForm occupationTypeIdFieldForOccupationType(){
		return occupationTypeIdFieldForOccupationType("occupationTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForOccupationType(String parameterName, String initValue){
		FormField field =  codeFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForOccupationType(String initValue){
		return codeFieldForOccupationType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForOccupationType(){
		return codeFieldForOccupationType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForOccupationType(String parameterName, String initValue){
		FormField field =  companyIdFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForOccupationType(String initValue){
		return companyIdFieldForOccupationType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForOccupationType(){
		return companyIdFieldForOccupationType("companyId","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForOccupationType(String parameterName, String initValue){
		FormField field =  descriptionFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForOccupationType(String initValue){
		return descriptionFieldForOccupationType("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForOccupationType(){
		return descriptionFieldForOccupationType("description","");
	}


	public RetailStoreCountryCenterForm detailDescriptionFieldForOccupationType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm detailDescriptionFieldForOccupationType(String initValue){
		return detailDescriptionFieldForOccupationType("detailDescription",initValue);
	}
	public RetailStoreCountryCenterForm detailDescriptionFieldForOccupationType(){
		return detailDescriptionFieldForOccupationType("detailDescription","");
	}


	public RetailStoreCountryCenterForm leaveTypeIdFieldForLeaveType(String parameterName, String initValue){
		FormField field =  idFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm leaveTypeIdFieldForLeaveType(String initValue){
		return leaveTypeIdFieldForLeaveType("leaveTypeId",initValue);
	}
	public RetailStoreCountryCenterForm leaveTypeIdFieldForLeaveType(){
		return leaveTypeIdFieldForLeaveType("leaveTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForLeaveType(String parameterName, String initValue){
		FormField field =  codeFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForLeaveType(String initValue){
		return codeFieldForLeaveType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForLeaveType(){
		return codeFieldForLeaveType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForLeaveType(String parameterName, String initValue){
		FormField field =  companyIdFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForLeaveType(String initValue){
		return companyIdFieldForLeaveType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForLeaveType(){
		return companyIdFieldForLeaveType("companyId","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForLeaveType(String parameterName, String initValue){
		FormField field =  descriptionFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForLeaveType(String initValue){
		return descriptionFieldForLeaveType("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForLeaveType(){
		return descriptionFieldForLeaveType("description","");
	}


	public RetailStoreCountryCenterForm detailDescriptionFieldForLeaveType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm detailDescriptionFieldForLeaveType(String initValue){
		return detailDescriptionFieldForLeaveType("detailDescription",initValue);
	}
	public RetailStoreCountryCenterForm detailDescriptionFieldForLeaveType(){
		return detailDescriptionFieldForLeaveType("detailDescription","");
	}


	public RetailStoreCountryCenterForm salaryGradeIdFieldForSalaryGrade(String parameterName, String initValue){
		FormField field =  idFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm salaryGradeIdFieldForSalaryGrade(String initValue){
		return salaryGradeIdFieldForSalaryGrade("salaryGradeId",initValue);
	}
	public RetailStoreCountryCenterForm salaryGradeIdFieldForSalaryGrade(){
		return salaryGradeIdFieldForSalaryGrade("salaryGradeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForSalaryGrade(String parameterName, String initValue){
		FormField field =  codeFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForSalaryGrade(String initValue){
		return codeFieldForSalaryGrade("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForSalaryGrade(){
		return codeFieldForSalaryGrade("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForSalaryGrade(String parameterName, String initValue){
		FormField field =  companyIdFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForSalaryGrade(String initValue){
		return companyIdFieldForSalaryGrade("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForSalaryGrade(){
		return companyIdFieldForSalaryGrade("companyId","");
	}


	public RetailStoreCountryCenterForm nameFieldForSalaryGrade(String parameterName, String initValue){
		FormField field =  nameFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForSalaryGrade(String initValue){
		return nameFieldForSalaryGrade("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForSalaryGrade(){
		return nameFieldForSalaryGrade("name","");
	}


	public RetailStoreCountryCenterForm detailDescriptionFieldForSalaryGrade(String parameterName, String initValue){
		FormField field =  detailDescriptionFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm detailDescriptionFieldForSalaryGrade(String initValue){
		return detailDescriptionFieldForSalaryGrade("detailDescription",initValue);
	}
	public RetailStoreCountryCenterForm detailDescriptionFieldForSalaryGrade(){
		return detailDescriptionFieldForSalaryGrade("detailDescription","");
	}


	public RetailStoreCountryCenterForm interviewTypeIdFieldForInterviewType(String parameterName, String initValue){
		FormField field =  idFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm interviewTypeIdFieldForInterviewType(String initValue){
		return interviewTypeIdFieldForInterviewType("interviewTypeId",initValue);
	}
	public RetailStoreCountryCenterForm interviewTypeIdFieldForInterviewType(){
		return interviewTypeIdFieldForInterviewType("interviewTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForInterviewType(String parameterName, String initValue){
		FormField field =  codeFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForInterviewType(String initValue){
		return codeFieldForInterviewType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForInterviewType(){
		return codeFieldForInterviewType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForInterviewType(String parameterName, String initValue){
		FormField field =  companyIdFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForInterviewType(String initValue){
		return companyIdFieldForInterviewType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForInterviewType(){
		return companyIdFieldForInterviewType("companyId","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForInterviewType(String parameterName, String initValue){
		FormField field =  descriptionFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForInterviewType(String initValue){
		return descriptionFieldForInterviewType("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForInterviewType(){
		return descriptionFieldForInterviewType("description","");
	}


	public RetailStoreCountryCenterForm detailDescriptionFieldForInterviewType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm detailDescriptionFieldForInterviewType(String initValue){
		return detailDescriptionFieldForInterviewType("detailDescription",initValue);
	}
	public RetailStoreCountryCenterForm detailDescriptionFieldForInterviewType(){
		return detailDescriptionFieldForInterviewType("detailDescription","");
	}


	public RetailStoreCountryCenterForm trainingCourseTypeIdFieldForTrainingCourseType(String parameterName, String initValue){
		FormField field =  idFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm trainingCourseTypeIdFieldForTrainingCourseType(String initValue){
		return trainingCourseTypeIdFieldForTrainingCourseType("trainingCourseTypeId",initValue);
	}
	public RetailStoreCountryCenterForm trainingCourseTypeIdFieldForTrainingCourseType(){
		return trainingCourseTypeIdFieldForTrainingCourseType("trainingCourseTypeId","");
	}


	public RetailStoreCountryCenterForm codeFieldForTrainingCourseType(String parameterName, String initValue){
		FormField field =  codeFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForTrainingCourseType(String initValue){
		return codeFieldForTrainingCourseType("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForTrainingCourseType(){
		return codeFieldForTrainingCourseType("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForTrainingCourseType(String parameterName, String initValue){
		FormField field =  companyIdFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForTrainingCourseType(String initValue){
		return companyIdFieldForTrainingCourseType("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForTrainingCourseType(){
		return companyIdFieldForTrainingCourseType("companyId","");
	}


	public RetailStoreCountryCenterForm nameFieldForTrainingCourseType(String parameterName, String initValue){
		FormField field =  nameFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForTrainingCourseType(String initValue){
		return nameFieldForTrainingCourseType("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForTrainingCourseType(){
		return nameFieldForTrainingCourseType("name","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForTrainingCourseType(String parameterName, String initValue){
		FormField field =  descriptionFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForTrainingCourseType(String initValue){
		return descriptionFieldForTrainingCourseType("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForTrainingCourseType(){
		return descriptionFieldForTrainingCourseType("description","");
	}


	public RetailStoreCountryCenterForm publicHolidayIdFieldForPublicHoliday(String parameterName, String initValue){
		FormField field =  idFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm publicHolidayIdFieldForPublicHoliday(String initValue){
		return publicHolidayIdFieldForPublicHoliday("publicHolidayId",initValue);
	}
	public RetailStoreCountryCenterForm publicHolidayIdFieldForPublicHoliday(){
		return publicHolidayIdFieldForPublicHoliday("publicHolidayId","");
	}


	public RetailStoreCountryCenterForm codeFieldForPublicHoliday(String parameterName, String initValue){
		FormField field =  codeFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm codeFieldForPublicHoliday(String initValue){
		return codeFieldForPublicHoliday("code",initValue);
	}
	public RetailStoreCountryCenterForm codeFieldForPublicHoliday(){
		return codeFieldForPublicHoliday("code","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForPublicHoliday(String parameterName, String initValue){
		FormField field =  companyIdFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForPublicHoliday(String initValue){
		return companyIdFieldForPublicHoliday("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForPublicHoliday(){
		return companyIdFieldForPublicHoliday("companyId","");
	}


	public RetailStoreCountryCenterForm nameFieldForPublicHoliday(String parameterName, String initValue){
		FormField field =  nameFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm nameFieldForPublicHoliday(String initValue){
		return nameFieldForPublicHoliday("name",initValue);
	}
	public RetailStoreCountryCenterForm nameFieldForPublicHoliday(){
		return nameFieldForPublicHoliday("name","");
	}


	public RetailStoreCountryCenterForm descriptionFieldForPublicHoliday(String parameterName, String initValue){
		FormField field =  descriptionFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm descriptionFieldForPublicHoliday(String initValue){
		return descriptionFieldForPublicHoliday("description",initValue);
	}
	public RetailStoreCountryCenterForm descriptionFieldForPublicHoliday(){
		return descriptionFieldForPublicHoliday("description","");
	}


	public RetailStoreCountryCenterForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public RetailStoreCountryCenterForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public RetailStoreCountryCenterForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public RetailStoreCountryCenterForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public RetailStoreCountryCenterForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public RetailStoreCountryCenterForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public RetailStoreCountryCenterForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public RetailStoreCountryCenterForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public RetailStoreCountryCenterForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public RetailStoreCountryCenterForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public RetailStoreCountryCenterForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public RetailStoreCountryCenterForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public RetailStoreCountryCenterForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public RetailStoreCountryCenterForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public RetailStoreCountryCenterForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public RetailStoreCountryCenterForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public RetailStoreCountryCenterForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public RetailStoreCountryCenterForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public RetailStoreCountryCenterForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public RetailStoreCountryCenterForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public RetailStoreCountryCenterForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public RetailStoreCountryCenterForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public RetailStoreCountryCenterForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public RetailStoreCountryCenterForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public RetailStoreCountryCenterForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public RetailStoreCountryCenterForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public RetailStoreCountryCenterForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public RetailStoreCountryCenterForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public RetailStoreCountryCenterForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public RetailStoreCountryCenterForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public RetailStoreCountryCenterForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public RetailStoreCountryCenterForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public RetailStoreCountryCenterForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public RetailStoreCountryCenterForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public RetailStoreCountryCenterForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public RetailStoreCountryCenterForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public RetailStoreCountryCenterForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public RetailStoreCountryCenterForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public RetailStoreCountryCenterForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public RetailStoreCountryCenterForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public RetailStoreCountryCenterForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}


	public RetailStoreCountryCenterForm instructorIdFieldForInstructor(String parameterName, String initValue){
		FormField field =  idFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm instructorIdFieldForInstructor(String initValue){
		return instructorIdFieldForInstructor("instructorId",initValue);
	}
	public RetailStoreCountryCenterForm instructorIdFieldForInstructor(){
		return instructorIdFieldForInstructor("instructorId","");
	}


	public RetailStoreCountryCenterForm titleFieldForInstructor(String parameterName, String initValue){
		FormField field =  titleFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm titleFieldForInstructor(String initValue){
		return titleFieldForInstructor("title",initValue);
	}
	public RetailStoreCountryCenterForm titleFieldForInstructor(){
		return titleFieldForInstructor("title","");
	}


	public RetailStoreCountryCenterForm familyNameFieldForInstructor(String parameterName, String initValue){
		FormField field =  familyNameFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm familyNameFieldForInstructor(String initValue){
		return familyNameFieldForInstructor("familyName",initValue);
	}
	public RetailStoreCountryCenterForm familyNameFieldForInstructor(){
		return familyNameFieldForInstructor("familyName","");
	}


	public RetailStoreCountryCenterForm givenNameFieldForInstructor(String parameterName, String initValue){
		FormField field =  givenNameFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm givenNameFieldForInstructor(String initValue){
		return givenNameFieldForInstructor("givenName",initValue);
	}
	public RetailStoreCountryCenterForm givenNameFieldForInstructor(){
		return givenNameFieldForInstructor("givenName","");
	}


	public RetailStoreCountryCenterForm cellPhoneFieldForInstructor(String parameterName, String initValue){
		FormField field =  cellPhoneFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm cellPhoneFieldForInstructor(String initValue){
		return cellPhoneFieldForInstructor("cellPhone",initValue);
	}
	public RetailStoreCountryCenterForm cellPhoneFieldForInstructor(){
		return cellPhoneFieldForInstructor("cellPhone","");
	}


	public RetailStoreCountryCenterForm emailFieldForInstructor(String parameterName, String initValue){
		FormField field =  emailFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm emailFieldForInstructor(String initValue){
		return emailFieldForInstructor("email",initValue);
	}
	public RetailStoreCountryCenterForm emailFieldForInstructor(){
		return emailFieldForInstructor("email","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForInstructor(String parameterName, String initValue){
		FormField field =  companyIdFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForInstructor(String initValue){
		return companyIdFieldForInstructor("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForInstructor(){
		return companyIdFieldForInstructor("companyId","");
	}


	public RetailStoreCountryCenterForm introductionFieldForInstructor(String parameterName, String initValue){
		FormField field =  introductionFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm introductionFieldForInstructor(String initValue){
		return introductionFieldForInstructor("introduction",initValue);
	}
	public RetailStoreCountryCenterForm introductionFieldForInstructor(){
		return introductionFieldForInstructor("introduction","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForInstructor(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForInstructor(String initValue){
		return lastUpdateTimeFieldForInstructor("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForInstructor(){
		return lastUpdateTimeFieldForInstructor("lastUpdateTime","");
	}


	public RetailStoreCountryCenterForm companyTrainingIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyTrainingIdFieldForCompanyTraining(String initValue){
		return companyTrainingIdFieldForCompanyTraining("companyTrainingId",initValue);
	}
	public RetailStoreCountryCenterForm companyTrainingIdFieldForCompanyTraining(){
		return companyTrainingIdFieldForCompanyTraining("companyTrainingId","");
	}


	public RetailStoreCountryCenterForm titleFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  titleFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm titleFieldForCompanyTraining(String initValue){
		return titleFieldForCompanyTraining("title",initValue);
	}
	public RetailStoreCountryCenterForm titleFieldForCompanyTraining(){
		return titleFieldForCompanyTraining("title","");
	}


	public RetailStoreCountryCenterForm companyIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  companyIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm companyIdFieldForCompanyTraining(String initValue){
		return companyIdFieldForCompanyTraining("companyId",initValue);
	}
	public RetailStoreCountryCenterForm companyIdFieldForCompanyTraining(){
		return companyIdFieldForCompanyTraining("companyId","");
	}


	public RetailStoreCountryCenterForm instructorIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  instructorIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm instructorIdFieldForCompanyTraining(String initValue){
		return instructorIdFieldForCompanyTraining("instructorId",initValue);
	}
	public RetailStoreCountryCenterForm instructorIdFieldForCompanyTraining(){
		return instructorIdFieldForCompanyTraining("instructorId","");
	}


	public RetailStoreCountryCenterForm trainingCourseTypeIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingCourseTypeIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm trainingCourseTypeIdFieldForCompanyTraining(String initValue){
		return trainingCourseTypeIdFieldForCompanyTraining("trainingCourseTypeId",initValue);
	}
	public RetailStoreCountryCenterForm trainingCourseTypeIdFieldForCompanyTraining(){
		return trainingCourseTypeIdFieldForCompanyTraining("trainingCourseTypeId","");
	}


	public RetailStoreCountryCenterForm timeStartFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  timeStartFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm timeStartFieldForCompanyTraining(String initValue){
		return timeStartFieldForCompanyTraining("timeStart",initValue);
	}
	public RetailStoreCountryCenterForm timeStartFieldForCompanyTraining(){
		return timeStartFieldForCompanyTraining("timeStart","");
	}


	public RetailStoreCountryCenterForm durationHoursFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  durationHoursFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm durationHoursFieldForCompanyTraining(String initValue){
		return durationHoursFieldForCompanyTraining("durationHours",initValue);
	}
	public RetailStoreCountryCenterForm durationHoursFieldForCompanyTraining(){
		return durationHoursFieldForCompanyTraining("durationHours","");
	}


	public RetailStoreCountryCenterForm lastUpdateTimeFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForCompanyTraining(String initValue){
		return lastUpdateTimeFieldForCompanyTraining("lastUpdateTime",initValue);
	}
	public RetailStoreCountryCenterForm lastUpdateTimeFieldForCompanyTraining(){
		return lastUpdateTimeFieldForCompanyTraining("lastUpdateTime","");
	}

	



	public RetailStoreCountryCenterForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



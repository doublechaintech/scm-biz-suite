package com.doublechaintech.retailscm.accountset;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountSetForm extends BaseForm {
	
	
	public AccountSetForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountSetForm accountSetIdField(String parameterName, String initValue){
		FormField field = idFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountSetIdField(String initValue){
		return accountSetIdField("accountSetId",initValue);
	}
	public AccountSetForm accountSetIdField(){
		return accountSetIdField("accountSetId","");
	}


	public AccountSetForm nameField(String parameterName, String initValue){
		FormField field = nameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public AccountSetForm nameField(){
		return nameField("name","");
	}


	public AccountSetForm yearSetField(String parameterName, String initValue){
		FormField field = yearSetFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm yearSetField(String initValue){
		return yearSetField("yearSet",initValue);
	}
	public AccountSetForm yearSetField(){
		return yearSetField("yearSet","");
	}


	public AccountSetForm effectiveDateField(String parameterName, String initValue){
		FormField field = effectiveDateFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm effectiveDateField(String initValue){
		return effectiveDateField("effectiveDate",initValue);
	}
	public AccountSetForm effectiveDateField(){
		return effectiveDateField("effectiveDate","");
	}


	public AccountSetForm accountingSystemField(String parameterName, String initValue){
		FormField field = accountingSystemFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingSystemField(String initValue){
		return accountingSystemField("accountingSystem",initValue);
	}
	public AccountSetForm accountingSystemField(){
		return accountingSystemField("accountingSystem","");
	}


	public AccountSetForm domesticCurrencyCodeField(String parameterName, String initValue){
		FormField field = domesticCurrencyCodeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm domesticCurrencyCodeField(String initValue){
		return domesticCurrencyCodeField("domesticCurrencyCode",initValue);
	}
	public AccountSetForm domesticCurrencyCodeField(){
		return domesticCurrencyCodeField("domesticCurrencyCode","");
	}


	public AccountSetForm domesticCurrencyNameField(String parameterName, String initValue){
		FormField field = domesticCurrencyNameFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm domesticCurrencyNameField(String initValue){
		return domesticCurrencyNameField("domesticCurrencyName",initValue);
	}
	public AccountSetForm domesticCurrencyNameField(){
		return domesticCurrencyNameField("domesticCurrencyName","");
	}


	public AccountSetForm openingBankField(String parameterName, String initValue){
		FormField field = openingBankFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm openingBankField(String initValue){
		return openingBankField("openingBank",initValue);
	}
	public AccountSetForm openingBankField(){
		return openingBankField("openingBank","");
	}


	public AccountSetForm accountNumberField(String parameterName, String initValue){
		FormField field = accountNumberFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountNumberField(String initValue){
		return accountNumberField("accountNumber",initValue);
	}
	public AccountSetForm accountNumberField(){
		return accountNumberField("accountNumber","");
	}


	public AccountSetForm countryCenterIdField(String parameterName, String initValue){
		FormField field = countryCenterIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm countryCenterIdField(String initValue){
		return countryCenterIdField("countryCenterId",initValue);
	}
	public AccountSetForm countryCenterIdField(){
		return countryCenterIdField("countryCenterId","");
	}


	public AccountSetForm retailStoreIdField(String parameterName, String initValue){
		FormField field = retailStoreIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm retailStoreIdField(String initValue){
		return retailStoreIdField("retailStoreId",initValue);
	}
	public AccountSetForm retailStoreIdField(){
		return retailStoreIdField("retailStoreId","");
	}


	public AccountSetForm goodsSupplierIdField(String parameterName, String initValue){
		FormField field = goodsSupplierIdFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm goodsSupplierIdField(String initValue){
		return goodsSupplierIdField("goodsSupplierId",initValue);
	}
	public AccountSetForm goodsSupplierIdField(){
		return goodsSupplierIdField("goodsSupplierId","");
	}


	public AccountSetForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromAccountSet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public AccountSetForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public AccountSetForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public AccountSetForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public AccountSetForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public AccountSetForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public AccountSetForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public AccountSetForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public AccountSetForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public AccountSetForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public AccountSetForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public AccountSetForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public AccountSetForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public AccountSetForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public AccountSetForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public AccountSetForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public AccountSetForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public AccountSetForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public AccountSetForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public AccountSetForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}


	public AccountSetForm retailStoreIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  idFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm retailStoreIdFieldOfRetailStore(String initValue){
		return retailStoreIdFieldOfRetailStore("retailStoreId",initValue);
	}
	public AccountSetForm retailStoreIdFieldOfRetailStore(){
		return retailStoreIdFieldOfRetailStore("retailStoreId","");
	}


	public AccountSetForm nameFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  nameFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm nameFieldOfRetailStore(String initValue){
		return nameFieldOfRetailStore("name",initValue);
	}
	public AccountSetForm nameFieldOfRetailStore(){
		return nameFieldOfRetailStore("name","");
	}


	public AccountSetForm telephoneFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  telephoneFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm telephoneFieldOfRetailStore(String initValue){
		return telephoneFieldOfRetailStore("telephone",initValue);
	}
	public AccountSetForm telephoneFieldOfRetailStore(){
		return telephoneFieldOfRetailStore("telephone","");
	}


	public AccountSetForm ownerFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  ownerFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm ownerFieldOfRetailStore(String initValue){
		return ownerFieldOfRetailStore("owner",initValue);
	}
	public AccountSetForm ownerFieldOfRetailStore(){
		return ownerFieldOfRetailStore("owner","");
	}


	public AccountSetForm retailStoreCountryCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  retailStoreCountryCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm retailStoreCountryCenterIdFieldOfRetailStore(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId",initValue);
	}
	public AccountSetForm retailStoreCountryCenterIdFieldOfRetailStore(){
		return retailStoreCountryCenterIdFieldOfRetailStore("retailStoreCountryCenterId","");
	}


	public AccountSetForm cityServiceCenterIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  cityServiceCenterIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm cityServiceCenterIdFieldOfRetailStore(String initValue){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId",initValue);
	}
	public AccountSetForm cityServiceCenterIdFieldOfRetailStore(){
		return cityServiceCenterIdFieldOfRetailStore("cityServiceCenterId","");
	}


	public AccountSetForm creationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  creationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm creationIdFieldOfRetailStore(String initValue){
		return creationIdFieldOfRetailStore("creationId",initValue);
	}
	public AccountSetForm creationIdFieldOfRetailStore(){
		return creationIdFieldOfRetailStore("creationId","");
	}


	public AccountSetForm investmentInvitationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  investmentInvitationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm investmentInvitationIdFieldOfRetailStore(String initValue){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId",initValue);
	}
	public AccountSetForm investmentInvitationIdFieldOfRetailStore(){
		return investmentInvitationIdFieldOfRetailStore("investmentInvitationId","");
	}


	public AccountSetForm franchisingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  franchisingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm franchisingIdFieldOfRetailStore(String initValue){
		return franchisingIdFieldOfRetailStore("franchisingId",initValue);
	}
	public AccountSetForm franchisingIdFieldOfRetailStore(){
		return franchisingIdFieldOfRetailStore("franchisingId","");
	}


	public AccountSetForm decorationIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  decorationIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm decorationIdFieldOfRetailStore(String initValue){
		return decorationIdFieldOfRetailStore("decorationId",initValue);
	}
	public AccountSetForm decorationIdFieldOfRetailStore(){
		return decorationIdFieldOfRetailStore("decorationId","");
	}


	public AccountSetForm openingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  openingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm openingIdFieldOfRetailStore(String initValue){
		return openingIdFieldOfRetailStore("openingId",initValue);
	}
	public AccountSetForm openingIdFieldOfRetailStore(){
		return openingIdFieldOfRetailStore("openingId","");
	}


	public AccountSetForm closingIdFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  closingIdFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm closingIdFieldOfRetailStore(String initValue){
		return closingIdFieldOfRetailStore("closingId",initValue);
	}
	public AccountSetForm closingIdFieldOfRetailStore(){
		return closingIdFieldOfRetailStore("closingId","");
	}


	public AccountSetForm foundedFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  foundedFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm foundedFieldOfRetailStore(String initValue){
		return foundedFieldOfRetailStore("founded",initValue);
	}
	public AccountSetForm foundedFieldOfRetailStore(){
		return foundedFieldOfRetailStore("founded","");
	}


	public AccountSetForm latitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  latitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm latitudeFieldOfRetailStore(String initValue){
		return latitudeFieldOfRetailStore("latitude",initValue);
	}
	public AccountSetForm latitudeFieldOfRetailStore(){
		return latitudeFieldOfRetailStore("latitude","");
	}


	public AccountSetForm longitudeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  longitudeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm longitudeFieldOfRetailStore(String initValue){
		return longitudeFieldOfRetailStore("longitude",initValue);
	}
	public AccountSetForm longitudeFieldOfRetailStore(){
		return longitudeFieldOfRetailStore("longitude","");
	}


	public AccountSetForm descriptionFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm descriptionFieldOfRetailStore(String initValue){
		return descriptionFieldOfRetailStore("description",initValue);
	}
	public AccountSetForm descriptionFieldOfRetailStore(){
		return descriptionFieldOfRetailStore("description","");
	}


	public AccountSetForm lastUpdateTimeFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm lastUpdateTimeFieldOfRetailStore(String initValue){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime",initValue);
	}
	public AccountSetForm lastUpdateTimeFieldOfRetailStore(){
		return lastUpdateTimeFieldOfRetailStore("lastUpdateTime","");
	}


	public AccountSetForm currentStatusFieldOfRetailStore(String parameterName, String initValue){
		FormField field =  currentStatusFromRetailStore(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm currentStatusFieldOfRetailStore(String initValue){
		return currentStatusFieldOfRetailStore("currentStatus",initValue);
	}
	public AccountSetForm currentStatusFieldOfRetailStore(){
		return currentStatusFieldOfRetailStore("currentStatus","");
	}


	public AccountSetForm goodsSupplierIdFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  idFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm goodsSupplierIdFieldOfGoodsSupplier(String initValue){
		return goodsSupplierIdFieldOfGoodsSupplier("goodsSupplierId",initValue);
	}
	public AccountSetForm goodsSupplierIdFieldOfGoodsSupplier(){
		return goodsSupplierIdFieldOfGoodsSupplier("goodsSupplierId","");
	}


	public AccountSetForm nameFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  nameFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm nameFieldOfGoodsSupplier(String initValue){
		return nameFieldOfGoodsSupplier("name",initValue);
	}
	public AccountSetForm nameFieldOfGoodsSupplier(){
		return nameFieldOfGoodsSupplier("name","");
	}


	public AccountSetForm supplyProductFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  supplyProductFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm supplyProductFieldOfGoodsSupplier(String initValue){
		return supplyProductFieldOfGoodsSupplier("supplyProduct",initValue);
	}
	public AccountSetForm supplyProductFieldOfGoodsSupplier(){
		return supplyProductFieldOfGoodsSupplier("supplyProduct","");
	}


	public AccountSetForm belongToIdFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  belongToIdFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm belongToIdFieldOfGoodsSupplier(String initValue){
		return belongToIdFieldOfGoodsSupplier("belongToId",initValue);
	}
	public AccountSetForm belongToIdFieldOfGoodsSupplier(){
		return belongToIdFieldOfGoodsSupplier("belongToId","");
	}


	public AccountSetForm contactNumberFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  contactNumberFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm contactNumberFieldOfGoodsSupplier(String initValue){
		return contactNumberFieldOfGoodsSupplier("contactNumber",initValue);
	}
	public AccountSetForm contactNumberFieldOfGoodsSupplier(){
		return contactNumberFieldOfGoodsSupplier("contactNumber","");
	}


	public AccountSetForm descriptionFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  descriptionFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm descriptionFieldOfGoodsSupplier(String initValue){
		return descriptionFieldOfGoodsSupplier("description",initValue);
	}
	public AccountSetForm descriptionFieldOfGoodsSupplier(){
		return descriptionFieldOfGoodsSupplier("description","");
	}


	public AccountSetForm lastUpdateTimeFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountSetForm lastUpdateTimeFieldOfGoodsSupplier(String initValue){
		return lastUpdateTimeFieldOfGoodsSupplier("lastUpdateTime",initValue);
	}
	public AccountSetForm lastUpdateTimeFieldOfGoodsSupplier(){
		return lastUpdateTimeFieldOfGoodsSupplier("lastUpdateTime","");
	}

	



	public AccountSetForm accountingSubjectIdFieldForAccountingSubject(String parameterName, String initValue){
		FormField field =  idFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingSubjectIdFieldForAccountingSubject(String initValue){
		return accountingSubjectIdFieldForAccountingSubject("accountingSubjectId",initValue);
	}
	public AccountSetForm accountingSubjectIdFieldForAccountingSubject(){
		return accountingSubjectIdFieldForAccountingSubject("accountingSubjectId","");
	}


	public AccountSetForm accountingSubjectCodeFieldForAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectCodeFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingSubjectCodeFieldForAccountingSubject(String initValue){
		return accountingSubjectCodeFieldForAccountingSubject("accountingSubjectCode",initValue);
	}
	public AccountSetForm accountingSubjectCodeFieldForAccountingSubject(){
		return accountingSubjectCodeFieldForAccountingSubject("accountingSubjectCode","");
	}


	public AccountSetForm accountingSubjectNameFieldForAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectNameFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingSubjectNameFieldForAccountingSubject(String initValue){
		return accountingSubjectNameFieldForAccountingSubject("accountingSubjectName",initValue);
	}
	public AccountSetForm accountingSubjectNameFieldForAccountingSubject(){
		return accountingSubjectNameFieldForAccountingSubject("accountingSubjectName","");
	}


	public AccountSetForm accountingSubjectClassCodeFieldForAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectClassCodeFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingSubjectClassCodeFieldForAccountingSubject(String initValue){
		return accountingSubjectClassCodeFieldForAccountingSubject("accountingSubjectClassCode",initValue);
	}
	public AccountSetForm accountingSubjectClassCodeFieldForAccountingSubject(){
		return accountingSubjectClassCodeFieldForAccountingSubject("accountingSubjectClassCode","");
	}


	public AccountSetForm accountingSubjectClassNameFieldForAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectClassNameFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingSubjectClassNameFieldForAccountingSubject(String initValue){
		return accountingSubjectClassNameFieldForAccountingSubject("accountingSubjectClassName",initValue);
	}
	public AccountSetForm accountingSubjectClassNameFieldForAccountingSubject(){
		return accountingSubjectClassNameFieldForAccountingSubject("accountingSubjectClassName","");
	}


	public AccountSetForm accountSetIdFieldForAccountingSubject(String parameterName, String initValue){
		FormField field =  accountSetIdFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountSetIdFieldForAccountingSubject(String initValue){
		return accountSetIdFieldForAccountingSubject("accountSetId",initValue);
	}
	public AccountSetForm accountSetIdFieldForAccountingSubject(){
		return accountSetIdFieldForAccountingSubject("accountSetId","");
	}


	public AccountSetForm accountingPeriodIdFieldForAccountingPeriod(String parameterName, String initValue){
		FormField field =  idFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingPeriodIdFieldForAccountingPeriod(String initValue){
		return accountingPeriodIdFieldForAccountingPeriod("accountingPeriodId",initValue);
	}
	public AccountSetForm accountingPeriodIdFieldForAccountingPeriod(){
		return accountingPeriodIdFieldForAccountingPeriod("accountingPeriodId","");
	}


	public AccountSetForm nameFieldForAccountingPeriod(String parameterName, String initValue){
		FormField field =  nameFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm nameFieldForAccountingPeriod(String initValue){
		return nameFieldForAccountingPeriod("name",initValue);
	}
	public AccountSetForm nameFieldForAccountingPeriod(){
		return nameFieldForAccountingPeriod("name","");
	}


	public AccountSetForm startDateFieldForAccountingPeriod(String parameterName, String initValue){
		FormField field =  startDateFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm startDateFieldForAccountingPeriod(String initValue){
		return startDateFieldForAccountingPeriod("startDate",initValue);
	}
	public AccountSetForm startDateFieldForAccountingPeriod(){
		return startDateFieldForAccountingPeriod("startDate","");
	}


	public AccountSetForm endDateFieldForAccountingPeriod(String parameterName, String initValue){
		FormField field =  endDateFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm endDateFieldForAccountingPeriod(String initValue){
		return endDateFieldForAccountingPeriod("endDate",initValue);
	}
	public AccountSetForm endDateFieldForAccountingPeriod(){
		return endDateFieldForAccountingPeriod("endDate","");
	}


	public AccountSetForm accountSetIdFieldForAccountingPeriod(String parameterName, String initValue){
		FormField field =  accountSetIdFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountSetIdFieldForAccountingPeriod(String initValue){
		return accountSetIdFieldForAccountingPeriod("accountSetId",initValue);
	}
	public AccountSetForm accountSetIdFieldForAccountingPeriod(){
		return accountSetIdFieldForAccountingPeriod("accountSetId","");
	}


	public AccountSetForm accountingDocumentTypeIdFieldForAccountingDocumentType(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingDocumentTypeIdFieldForAccountingDocumentType(String initValue){
		return accountingDocumentTypeIdFieldForAccountingDocumentType("accountingDocumentTypeId",initValue);
	}
	public AccountSetForm accountingDocumentTypeIdFieldForAccountingDocumentType(){
		return accountingDocumentTypeIdFieldForAccountingDocumentType("accountingDocumentTypeId","");
	}


	public AccountSetForm nameFieldForAccountingDocumentType(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm nameFieldForAccountingDocumentType(String initValue){
		return nameFieldForAccountingDocumentType("name",initValue);
	}
	public AccountSetForm nameFieldForAccountingDocumentType(){
		return nameFieldForAccountingDocumentType("name","");
	}


	public AccountSetForm descriptionFieldForAccountingDocumentType(String parameterName, String initValue){
		FormField field =  descriptionFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm descriptionFieldForAccountingDocumentType(String initValue){
		return descriptionFieldForAccountingDocumentType("description",initValue);
	}
	public AccountSetForm descriptionFieldForAccountingDocumentType(){
		return descriptionFieldForAccountingDocumentType("description","");
	}


	public AccountSetForm accountingPeriodIdFieldForAccountingDocumentType(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountSetForm accountingPeriodIdFieldForAccountingDocumentType(String initValue){
		return accountingPeriodIdFieldForAccountingDocumentType("accountingPeriodId",initValue);
	}
	public AccountSetForm accountingPeriodIdFieldForAccountingDocumentType(){
		return accountingPeriodIdFieldForAccountingDocumentType("accountingPeriodId","");
	}

	

	
 	public AccountSetForm transferToAnotherCountryCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCountryCenter/accountSetId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AccountSetForm transferToAnotherRetailStoreAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRetailStore/accountSetId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AccountSetForm transferToAnotherGoodsSupplierAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherGoodsSupplier/accountSetId/");
		this.addFormAction(action);
		return this;
	}

 

	public AccountSetForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



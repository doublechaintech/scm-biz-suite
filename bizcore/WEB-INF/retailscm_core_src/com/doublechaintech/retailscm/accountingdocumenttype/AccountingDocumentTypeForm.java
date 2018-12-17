package com.doublechaintech.retailscm.accountingdocumenttype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentTypeForm extends BaseForm {
	
	
	public AccountingDocumentTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentTypeForm accountingDocumentTypeIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm accountingDocumentTypeIdField(String initValue){
		return accountingDocumentTypeIdField("accountingDocumentTypeId",initValue);
	}
	public AccountingDocumentTypeForm accountingDocumentTypeIdField(){
		return accountingDocumentTypeIdField("accountingDocumentTypeId","");
	}


	public AccountingDocumentTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public AccountingDocumentTypeForm nameField(){
		return nameField("name","");
	}


	public AccountingDocumentTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public AccountingDocumentTypeForm descriptionField(){
		return descriptionField("description","");
	}


	public AccountingDocumentTypeForm accountingPeriodIdField(String parameterName, String initValue){
		FormField field = accountingPeriodIdFromAccountingDocumentType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm accountingPeriodIdField(String initValue){
		return accountingPeriodIdField("accountingPeriodId",initValue);
	}
	public AccountingDocumentTypeForm accountingPeriodIdField(){
		return accountingPeriodIdField("accountingPeriodId","");
	}

	
	


	public AccountingDocumentTypeForm accountSetIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  idFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm accountSetIdFieldOfAccountSet(String initValue){
		return accountSetIdFieldOfAccountSet("accountSetId",initValue);
	}
	public AccountingDocumentTypeForm accountSetIdFieldOfAccountSet(){
		return accountSetIdFieldOfAccountSet("accountSetId","");
	}


	public AccountingDocumentTypeForm nameFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  nameFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm nameFieldOfAccountSet(String initValue){
		return nameFieldOfAccountSet("name",initValue);
	}
	public AccountingDocumentTypeForm nameFieldOfAccountSet(){
		return nameFieldOfAccountSet("name","");
	}


	public AccountingDocumentTypeForm yearSetFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  yearSetFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm yearSetFieldOfAccountSet(String initValue){
		return yearSetFieldOfAccountSet("yearSet",initValue);
	}
	public AccountingDocumentTypeForm yearSetFieldOfAccountSet(){
		return yearSetFieldOfAccountSet("yearSet","");
	}


	public AccountingDocumentTypeForm effectiveDateFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  effectiveDateFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm effectiveDateFieldOfAccountSet(String initValue){
		return effectiveDateFieldOfAccountSet("effectiveDate",initValue);
	}
	public AccountingDocumentTypeForm effectiveDateFieldOfAccountSet(){
		return effectiveDateFieldOfAccountSet("effectiveDate","");
	}


	public AccountingDocumentTypeForm accountingSystemFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  accountingSystemFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm accountingSystemFieldOfAccountSet(String initValue){
		return accountingSystemFieldOfAccountSet("accountingSystem",initValue);
	}
	public AccountingDocumentTypeForm accountingSystemFieldOfAccountSet(){
		return accountingSystemFieldOfAccountSet("accountingSystem","");
	}


	public AccountingDocumentTypeForm domesticCurrencyCodeFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyCodeFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm domesticCurrencyCodeFieldOfAccountSet(String initValue){
		return domesticCurrencyCodeFieldOfAccountSet("domesticCurrencyCode",initValue);
	}
	public AccountingDocumentTypeForm domesticCurrencyCodeFieldOfAccountSet(){
		return domesticCurrencyCodeFieldOfAccountSet("domesticCurrencyCode","");
	}


	public AccountingDocumentTypeForm domesticCurrencyNameFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyNameFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm domesticCurrencyNameFieldOfAccountSet(String initValue){
		return domesticCurrencyNameFieldOfAccountSet("domesticCurrencyName",initValue);
	}
	public AccountingDocumentTypeForm domesticCurrencyNameFieldOfAccountSet(){
		return domesticCurrencyNameFieldOfAccountSet("domesticCurrencyName","");
	}


	public AccountingDocumentTypeForm openingBankFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  openingBankFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm openingBankFieldOfAccountSet(String initValue){
		return openingBankFieldOfAccountSet("openingBank",initValue);
	}
	public AccountingDocumentTypeForm openingBankFieldOfAccountSet(){
		return openingBankFieldOfAccountSet("openingBank","");
	}


	public AccountingDocumentTypeForm accountNumberFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  accountNumberFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm accountNumberFieldOfAccountSet(String initValue){
		return accountNumberFieldOfAccountSet("accountNumber",initValue);
	}
	public AccountingDocumentTypeForm accountNumberFieldOfAccountSet(){
		return accountNumberFieldOfAccountSet("accountNumber","");
	}


	public AccountingDocumentTypeForm countryCenterIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  countryCenterIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm countryCenterIdFieldOfAccountSet(String initValue){
		return countryCenterIdFieldOfAccountSet("countryCenterId",initValue);
	}
	public AccountingDocumentTypeForm countryCenterIdFieldOfAccountSet(){
		return countryCenterIdFieldOfAccountSet("countryCenterId","");
	}


	public AccountingDocumentTypeForm retailStoreIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  retailStoreIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm retailStoreIdFieldOfAccountSet(String initValue){
		return retailStoreIdFieldOfAccountSet("retailStoreId",initValue);
	}
	public AccountingDocumentTypeForm retailStoreIdFieldOfAccountSet(){
		return retailStoreIdFieldOfAccountSet("retailStoreId","");
	}


	public AccountingDocumentTypeForm goodsSupplierIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  goodsSupplierIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm goodsSupplierIdFieldOfAccountSet(String initValue){
		return goodsSupplierIdFieldOfAccountSet("goodsSupplierId",initValue);
	}
	public AccountingDocumentTypeForm goodsSupplierIdFieldOfAccountSet(){
		return goodsSupplierIdFieldOfAccountSet("goodsSupplierId","");
	}


	public AccountingDocumentTypeForm lastUpdateTimeFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentTypeForm lastUpdateTimeFieldOfAccountSet(String initValue){
		return lastUpdateTimeFieldOfAccountSet("lastUpdateTime",initValue);
	}
	public AccountingDocumentTypeForm lastUpdateTimeFieldOfAccountSet(){
		return lastUpdateTimeFieldOfAccountSet("lastUpdateTime","");
	}

	



	public AccountingDocumentTypeForm accountingDocumentIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm accountingDocumentIdFieldForAccountingDocument(String initValue){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingDocumentTypeForm accountingDocumentIdFieldForAccountingDocument(){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId","");
	}


	public AccountingDocumentTypeForm nameFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm nameFieldForAccountingDocument(String initValue){
		return nameFieldForAccountingDocument("name",initValue);
	}
	public AccountingDocumentTypeForm nameFieldForAccountingDocument(){
		return nameFieldForAccountingDocument("name","");
	}


	public AccountingDocumentTypeForm accountingDocumentDateFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm accountingDocumentDateFieldForAccountingDocument(String initValue){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingDocumentTypeForm accountingDocumentDateFieldForAccountingDocument(){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate","");
	}


	public AccountingDocumentTypeForm accountingPeriodIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm accountingPeriodIdFieldForAccountingDocument(String initValue){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingDocumentTypeForm accountingPeriodIdFieldForAccountingDocument(){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId","");
	}


	public AccountingDocumentTypeForm documentTypeIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm documentTypeIdFieldForAccountingDocument(String initValue){
		return documentTypeIdFieldForAccountingDocument("documentTypeId",initValue);
	}
	public AccountingDocumentTypeForm documentTypeIdFieldForAccountingDocument(){
		return documentTypeIdFieldForAccountingDocument("documentTypeId","");
	}


	public AccountingDocumentTypeForm creationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm creationIdFieldForAccountingDocument(String initValue){
		return creationIdFieldForAccountingDocument("creationId",initValue);
	}
	public AccountingDocumentTypeForm creationIdFieldForAccountingDocument(){
		return creationIdFieldForAccountingDocument("creationId","");
	}


	public AccountingDocumentTypeForm confirmationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm confirmationIdFieldForAccountingDocument(String initValue){
		return confirmationIdFieldForAccountingDocument("confirmationId",initValue);
	}
	public AccountingDocumentTypeForm confirmationIdFieldForAccountingDocument(){
		return confirmationIdFieldForAccountingDocument("confirmationId","");
	}


	public AccountingDocumentTypeForm auditingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm auditingIdFieldForAccountingDocument(String initValue){
		return auditingIdFieldForAccountingDocument("auditingId",initValue);
	}
	public AccountingDocumentTypeForm auditingIdFieldForAccountingDocument(){
		return auditingIdFieldForAccountingDocument("auditingId","");
	}


	public AccountingDocumentTypeForm postingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm postingIdFieldForAccountingDocument(String initValue){
		return postingIdFieldForAccountingDocument("postingId",initValue);
	}
	public AccountingDocumentTypeForm postingIdFieldForAccountingDocument(){
		return postingIdFieldForAccountingDocument("postingId","");
	}


	public AccountingDocumentTypeForm currentStatusFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentTypeForm currentStatusFieldForAccountingDocument(String initValue){
		return currentStatusFieldForAccountingDocument("currentStatus",initValue);
	}
	public AccountingDocumentTypeForm currentStatusFieldForAccountingDocument(){
		return currentStatusFieldForAccountingDocument("currentStatus","");
	}

	

	
 	public AccountingDocumentTypeForm transferToAnotherAccountingPeriodAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAccountingPeriod/accountingDocumentTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public AccountingDocumentTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



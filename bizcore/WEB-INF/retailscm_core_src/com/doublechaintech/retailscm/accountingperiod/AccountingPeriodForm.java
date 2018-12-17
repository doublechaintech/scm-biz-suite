package com.doublechaintech.retailscm.accountingperiod;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingPeriodForm extends BaseForm {
	
	
	public AccountingPeriodForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingPeriodForm accountingPeriodIdField(String parameterName, String initValue){
		FormField field = idFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm accountingPeriodIdField(String initValue){
		return accountingPeriodIdField("accountingPeriodId",initValue);
	}
	public AccountingPeriodForm accountingPeriodIdField(){
		return accountingPeriodIdField("accountingPeriodId","");
	}


	public AccountingPeriodForm nameField(String parameterName, String initValue){
		FormField field = nameFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public AccountingPeriodForm nameField(){
		return nameField("name","");
	}


	public AccountingPeriodForm startDateField(String parameterName, String initValue){
		FormField field = startDateFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm startDateField(String initValue){
		return startDateField("startDate",initValue);
	}
	public AccountingPeriodForm startDateField(){
		return startDateField("startDate","");
	}


	public AccountingPeriodForm endDateField(String parameterName, String initValue){
		FormField field = endDateFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm endDateField(String initValue){
		return endDateField("endDate",initValue);
	}
	public AccountingPeriodForm endDateField(){
		return endDateField("endDate","");
	}


	public AccountingPeriodForm accountSetIdField(String parameterName, String initValue){
		FormField field = accountSetIdFromAccountingPeriod(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm accountSetIdField(String initValue){
		return accountSetIdField("accountSetId",initValue);
	}
	public AccountingPeriodForm accountSetIdField(){
		return accountSetIdField("accountSetId","");
	}

	
	


	public AccountingPeriodForm accountSetIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  idFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm accountSetIdFieldOfAccountSet(String initValue){
		return accountSetIdFieldOfAccountSet("accountSetId",initValue);
	}
	public AccountingPeriodForm accountSetIdFieldOfAccountSet(){
		return accountSetIdFieldOfAccountSet("accountSetId","");
	}


	public AccountingPeriodForm nameFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  nameFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm nameFieldOfAccountSet(String initValue){
		return nameFieldOfAccountSet("name",initValue);
	}
	public AccountingPeriodForm nameFieldOfAccountSet(){
		return nameFieldOfAccountSet("name","");
	}


	public AccountingPeriodForm yearSetFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  yearSetFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm yearSetFieldOfAccountSet(String initValue){
		return yearSetFieldOfAccountSet("yearSet",initValue);
	}
	public AccountingPeriodForm yearSetFieldOfAccountSet(){
		return yearSetFieldOfAccountSet("yearSet","");
	}


	public AccountingPeriodForm effectiveDateFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  effectiveDateFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm effectiveDateFieldOfAccountSet(String initValue){
		return effectiveDateFieldOfAccountSet("effectiveDate",initValue);
	}
	public AccountingPeriodForm effectiveDateFieldOfAccountSet(){
		return effectiveDateFieldOfAccountSet("effectiveDate","");
	}


	public AccountingPeriodForm accountingSystemFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  accountingSystemFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm accountingSystemFieldOfAccountSet(String initValue){
		return accountingSystemFieldOfAccountSet("accountingSystem",initValue);
	}
	public AccountingPeriodForm accountingSystemFieldOfAccountSet(){
		return accountingSystemFieldOfAccountSet("accountingSystem","");
	}


	public AccountingPeriodForm domesticCurrencyCodeFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyCodeFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm domesticCurrencyCodeFieldOfAccountSet(String initValue){
		return domesticCurrencyCodeFieldOfAccountSet("domesticCurrencyCode",initValue);
	}
	public AccountingPeriodForm domesticCurrencyCodeFieldOfAccountSet(){
		return domesticCurrencyCodeFieldOfAccountSet("domesticCurrencyCode","");
	}


	public AccountingPeriodForm domesticCurrencyNameFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyNameFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm domesticCurrencyNameFieldOfAccountSet(String initValue){
		return domesticCurrencyNameFieldOfAccountSet("domesticCurrencyName",initValue);
	}
	public AccountingPeriodForm domesticCurrencyNameFieldOfAccountSet(){
		return domesticCurrencyNameFieldOfAccountSet("domesticCurrencyName","");
	}


	public AccountingPeriodForm openingBankFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  openingBankFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm openingBankFieldOfAccountSet(String initValue){
		return openingBankFieldOfAccountSet("openingBank",initValue);
	}
	public AccountingPeriodForm openingBankFieldOfAccountSet(){
		return openingBankFieldOfAccountSet("openingBank","");
	}


	public AccountingPeriodForm accountNumberFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  accountNumberFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm accountNumberFieldOfAccountSet(String initValue){
		return accountNumberFieldOfAccountSet("accountNumber",initValue);
	}
	public AccountingPeriodForm accountNumberFieldOfAccountSet(){
		return accountNumberFieldOfAccountSet("accountNumber","");
	}


	public AccountingPeriodForm countryCenterIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  countryCenterIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm countryCenterIdFieldOfAccountSet(String initValue){
		return countryCenterIdFieldOfAccountSet("countryCenterId",initValue);
	}
	public AccountingPeriodForm countryCenterIdFieldOfAccountSet(){
		return countryCenterIdFieldOfAccountSet("countryCenterId","");
	}


	public AccountingPeriodForm retailStoreIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  retailStoreIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm retailStoreIdFieldOfAccountSet(String initValue){
		return retailStoreIdFieldOfAccountSet("retailStoreId",initValue);
	}
	public AccountingPeriodForm retailStoreIdFieldOfAccountSet(){
		return retailStoreIdFieldOfAccountSet("retailStoreId","");
	}


	public AccountingPeriodForm goodsSupplierIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  goodsSupplierIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm goodsSupplierIdFieldOfAccountSet(String initValue){
		return goodsSupplierIdFieldOfAccountSet("goodsSupplierId",initValue);
	}
	public AccountingPeriodForm goodsSupplierIdFieldOfAccountSet(){
		return goodsSupplierIdFieldOfAccountSet("goodsSupplierId","");
	}


	public AccountingPeriodForm lastUpdateTimeFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingPeriodForm lastUpdateTimeFieldOfAccountSet(String initValue){
		return lastUpdateTimeFieldOfAccountSet("lastUpdateTime",initValue);
	}
	public AccountingPeriodForm lastUpdateTimeFieldOfAccountSet(){
		return lastUpdateTimeFieldOfAccountSet("lastUpdateTime","");
	}

	



	public AccountingPeriodForm accountingDocumentIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm accountingDocumentIdFieldForAccountingDocument(String initValue){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingPeriodForm accountingDocumentIdFieldForAccountingDocument(){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId","");
	}


	public AccountingPeriodForm nameFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm nameFieldForAccountingDocument(String initValue){
		return nameFieldForAccountingDocument("name",initValue);
	}
	public AccountingPeriodForm nameFieldForAccountingDocument(){
		return nameFieldForAccountingDocument("name","");
	}


	public AccountingPeriodForm accountingDocumentDateFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm accountingDocumentDateFieldForAccountingDocument(String initValue){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingPeriodForm accountingDocumentDateFieldForAccountingDocument(){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate","");
	}


	public AccountingPeriodForm accountingPeriodIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm accountingPeriodIdFieldForAccountingDocument(String initValue){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingPeriodForm accountingPeriodIdFieldForAccountingDocument(){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId","");
	}


	public AccountingPeriodForm documentTypeIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm documentTypeIdFieldForAccountingDocument(String initValue){
		return documentTypeIdFieldForAccountingDocument("documentTypeId",initValue);
	}
	public AccountingPeriodForm documentTypeIdFieldForAccountingDocument(){
		return documentTypeIdFieldForAccountingDocument("documentTypeId","");
	}


	public AccountingPeriodForm creationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm creationIdFieldForAccountingDocument(String initValue){
		return creationIdFieldForAccountingDocument("creationId",initValue);
	}
	public AccountingPeriodForm creationIdFieldForAccountingDocument(){
		return creationIdFieldForAccountingDocument("creationId","");
	}


	public AccountingPeriodForm confirmationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm confirmationIdFieldForAccountingDocument(String initValue){
		return confirmationIdFieldForAccountingDocument("confirmationId",initValue);
	}
	public AccountingPeriodForm confirmationIdFieldForAccountingDocument(){
		return confirmationIdFieldForAccountingDocument("confirmationId","");
	}


	public AccountingPeriodForm auditingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm auditingIdFieldForAccountingDocument(String initValue){
		return auditingIdFieldForAccountingDocument("auditingId",initValue);
	}
	public AccountingPeriodForm auditingIdFieldForAccountingDocument(){
		return auditingIdFieldForAccountingDocument("auditingId","");
	}


	public AccountingPeriodForm postingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm postingIdFieldForAccountingDocument(String initValue){
		return postingIdFieldForAccountingDocument("postingId",initValue);
	}
	public AccountingPeriodForm postingIdFieldForAccountingDocument(){
		return postingIdFieldForAccountingDocument("postingId","");
	}


	public AccountingPeriodForm currentStatusFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingPeriodForm currentStatusFieldForAccountingDocument(String initValue){
		return currentStatusFieldForAccountingDocument("currentStatus",initValue);
	}
	public AccountingPeriodForm currentStatusFieldForAccountingDocument(){
		return currentStatusFieldForAccountingDocument("currentStatus","");
	}

	

	
 	public AccountingPeriodForm transferToAnotherAccountSetAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAccountSet/accountingPeriodId/");
		this.addFormAction(action);
		return this;
	}

 

	public AccountingPeriodForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



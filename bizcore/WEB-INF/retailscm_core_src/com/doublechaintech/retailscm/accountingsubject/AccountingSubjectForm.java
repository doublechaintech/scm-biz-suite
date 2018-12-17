package com.doublechaintech.retailscm.accountingsubject;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingSubjectForm extends BaseForm {
	
	
	public AccountingSubjectForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingSubjectForm accountingSubjectIdField(String parameterName, String initValue){
		FormField field = idFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingSubjectIdField(String initValue){
		return accountingSubjectIdField("accountingSubjectId",initValue);
	}
	public AccountingSubjectForm accountingSubjectIdField(){
		return accountingSubjectIdField("accountingSubjectId","");
	}


	public AccountingSubjectForm accountingSubjectCodeField(String parameterName, String initValue){
		FormField field = accountingSubjectCodeFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingSubjectCodeField(String initValue){
		return accountingSubjectCodeField("accountingSubjectCode",initValue);
	}
	public AccountingSubjectForm accountingSubjectCodeField(){
		return accountingSubjectCodeField("accountingSubjectCode","");
	}


	public AccountingSubjectForm accountingSubjectNameField(String parameterName, String initValue){
		FormField field = accountingSubjectNameFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingSubjectNameField(String initValue){
		return accountingSubjectNameField("accountingSubjectName",initValue);
	}
	public AccountingSubjectForm accountingSubjectNameField(){
		return accountingSubjectNameField("accountingSubjectName","");
	}


	public AccountingSubjectForm accountingSubjectClassCodeField(String parameterName, String initValue){
		FormField field = accountingSubjectClassCodeFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingSubjectClassCodeField(String initValue){
		return accountingSubjectClassCodeField("accountingSubjectClassCode",initValue);
	}
	public AccountingSubjectForm accountingSubjectClassCodeField(){
		return accountingSubjectClassCodeField("accountingSubjectClassCode","");
	}


	public AccountingSubjectForm accountingSubjectClassNameField(String parameterName, String initValue){
		FormField field = accountingSubjectClassNameFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingSubjectClassNameField(String initValue){
		return accountingSubjectClassNameField("accountingSubjectClassName",initValue);
	}
	public AccountingSubjectForm accountingSubjectClassNameField(){
		return accountingSubjectClassNameField("accountingSubjectClassName","");
	}


	public AccountingSubjectForm accountSetIdField(String parameterName, String initValue){
		FormField field = accountSetIdFromAccountingSubject(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountSetIdField(String initValue){
		return accountSetIdField("accountSetId",initValue);
	}
	public AccountingSubjectForm accountSetIdField(){
		return accountSetIdField("accountSetId","");
	}

	
	


	public AccountingSubjectForm accountSetIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  idFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm accountSetIdFieldOfAccountSet(String initValue){
		return accountSetIdFieldOfAccountSet("accountSetId",initValue);
	}
	public AccountingSubjectForm accountSetIdFieldOfAccountSet(){
		return accountSetIdFieldOfAccountSet("accountSetId","");
	}


	public AccountingSubjectForm nameFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  nameFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm nameFieldOfAccountSet(String initValue){
		return nameFieldOfAccountSet("name",initValue);
	}
	public AccountingSubjectForm nameFieldOfAccountSet(){
		return nameFieldOfAccountSet("name","");
	}


	public AccountingSubjectForm yearSetFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  yearSetFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm yearSetFieldOfAccountSet(String initValue){
		return yearSetFieldOfAccountSet("yearSet",initValue);
	}
	public AccountingSubjectForm yearSetFieldOfAccountSet(){
		return yearSetFieldOfAccountSet("yearSet","");
	}


	public AccountingSubjectForm effectiveDateFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  effectiveDateFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm effectiveDateFieldOfAccountSet(String initValue){
		return effectiveDateFieldOfAccountSet("effectiveDate",initValue);
	}
	public AccountingSubjectForm effectiveDateFieldOfAccountSet(){
		return effectiveDateFieldOfAccountSet("effectiveDate","");
	}


	public AccountingSubjectForm accountingSystemFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  accountingSystemFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm accountingSystemFieldOfAccountSet(String initValue){
		return accountingSystemFieldOfAccountSet("accountingSystem",initValue);
	}
	public AccountingSubjectForm accountingSystemFieldOfAccountSet(){
		return accountingSystemFieldOfAccountSet("accountingSystem","");
	}


	public AccountingSubjectForm domesticCurrencyCodeFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyCodeFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm domesticCurrencyCodeFieldOfAccountSet(String initValue){
		return domesticCurrencyCodeFieldOfAccountSet("domesticCurrencyCode",initValue);
	}
	public AccountingSubjectForm domesticCurrencyCodeFieldOfAccountSet(){
		return domesticCurrencyCodeFieldOfAccountSet("domesticCurrencyCode","");
	}


	public AccountingSubjectForm domesticCurrencyNameFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  domesticCurrencyNameFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm domesticCurrencyNameFieldOfAccountSet(String initValue){
		return domesticCurrencyNameFieldOfAccountSet("domesticCurrencyName",initValue);
	}
	public AccountingSubjectForm domesticCurrencyNameFieldOfAccountSet(){
		return domesticCurrencyNameFieldOfAccountSet("domesticCurrencyName","");
	}


	public AccountingSubjectForm openingBankFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  openingBankFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm openingBankFieldOfAccountSet(String initValue){
		return openingBankFieldOfAccountSet("openingBank",initValue);
	}
	public AccountingSubjectForm openingBankFieldOfAccountSet(){
		return openingBankFieldOfAccountSet("openingBank","");
	}


	public AccountingSubjectForm accountNumberFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  accountNumberFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm accountNumberFieldOfAccountSet(String initValue){
		return accountNumberFieldOfAccountSet("accountNumber",initValue);
	}
	public AccountingSubjectForm accountNumberFieldOfAccountSet(){
		return accountNumberFieldOfAccountSet("accountNumber","");
	}


	public AccountingSubjectForm countryCenterIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  countryCenterIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm countryCenterIdFieldOfAccountSet(String initValue){
		return countryCenterIdFieldOfAccountSet("countryCenterId",initValue);
	}
	public AccountingSubjectForm countryCenterIdFieldOfAccountSet(){
		return countryCenterIdFieldOfAccountSet("countryCenterId","");
	}


	public AccountingSubjectForm retailStoreIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  retailStoreIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm retailStoreIdFieldOfAccountSet(String initValue){
		return retailStoreIdFieldOfAccountSet("retailStoreId",initValue);
	}
	public AccountingSubjectForm retailStoreIdFieldOfAccountSet(){
		return retailStoreIdFieldOfAccountSet("retailStoreId","");
	}


	public AccountingSubjectForm goodsSupplierIdFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  goodsSupplierIdFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm goodsSupplierIdFieldOfAccountSet(String initValue){
		return goodsSupplierIdFieldOfAccountSet("goodsSupplierId",initValue);
	}
	public AccountingSubjectForm goodsSupplierIdFieldOfAccountSet(){
		return goodsSupplierIdFieldOfAccountSet("goodsSupplierId","");
	}


	public AccountingSubjectForm lastUpdateTimeFieldOfAccountSet(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromAccountSet(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingSubjectForm lastUpdateTimeFieldOfAccountSet(String initValue){
		return lastUpdateTimeFieldOfAccountSet("lastUpdateTime",initValue);
	}
	public AccountingSubjectForm lastUpdateTimeFieldOfAccountSet(){
		return lastUpdateTimeFieldOfAccountSet("lastUpdateTime","");
	}

	



	public AccountingSubjectForm accountingDocumentLineIdFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingDocumentLineIdFieldForAccountingDocumentLine(String initValue){
		return accountingDocumentLineIdFieldForAccountingDocumentLine("accountingDocumentLineId",initValue);
	}
	public AccountingSubjectForm accountingDocumentLineIdFieldForAccountingDocumentLine(){
		return accountingDocumentLineIdFieldForAccountingDocumentLine("accountingDocumentLineId","");
	}


	public AccountingSubjectForm nameFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm nameFieldForAccountingDocumentLine(String initValue){
		return nameFieldForAccountingDocumentLine("name",initValue);
	}
	public AccountingSubjectForm nameFieldForAccountingDocumentLine(){
		return nameFieldForAccountingDocumentLine("name","");
	}


	public AccountingSubjectForm codeFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  codeFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm codeFieldForAccountingDocumentLine(String initValue){
		return codeFieldForAccountingDocumentLine("code",initValue);
	}
	public AccountingSubjectForm codeFieldForAccountingDocumentLine(){
		return codeFieldForAccountingDocumentLine("code","");
	}


	public AccountingSubjectForm directFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  directFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm directFieldForAccountingDocumentLine(String initValue){
		return directFieldForAccountingDocumentLine("direct",initValue);
	}
	public AccountingSubjectForm directFieldForAccountingDocumentLine(){
		return directFieldForAccountingDocumentLine("direct","");
	}


	public AccountingSubjectForm amountFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  amountFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm amountFieldForAccountingDocumentLine(String initValue){
		return amountFieldForAccountingDocumentLine("amount",initValue);
	}
	public AccountingSubjectForm amountFieldForAccountingDocumentLine(){
		return amountFieldForAccountingDocumentLine("amount","");
	}


	public AccountingSubjectForm belongsToIdFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  belongsToIdFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm belongsToIdFieldForAccountingDocumentLine(String initValue){
		return belongsToIdFieldForAccountingDocumentLine("belongsToId",initValue);
	}
	public AccountingSubjectForm belongsToIdFieldForAccountingDocumentLine(){
		return belongsToIdFieldForAccountingDocumentLine("belongsToId","");
	}


	public AccountingSubjectForm accountingSubjectIdFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  accountingSubjectIdFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingSubjectForm accountingSubjectIdFieldForAccountingDocumentLine(String initValue){
		return accountingSubjectIdFieldForAccountingDocumentLine("accountingSubjectId",initValue);
	}
	public AccountingSubjectForm accountingSubjectIdFieldForAccountingDocumentLine(){
		return accountingSubjectIdFieldForAccountingDocumentLine("accountingSubjectId","");
	}

	

	
 	public AccountingSubjectForm transferToAnotherAccountSetAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAccountSet/accountingSubjectId/");
		this.addFormAction(action);
		return this;
	}

 

	public AccountingSubjectForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.accountingdocumentline;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentLineForm extends BaseForm {
	
	
	public AccountingDocumentLineForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentLineForm accountingDocumentLineIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm accountingDocumentLineIdField(String initValue){
		return accountingDocumentLineIdField("accountingDocumentLineId",initValue);
	}
	public AccountingDocumentLineForm accountingDocumentLineIdField(){
		return accountingDocumentLineIdField("accountingDocumentLineId","");
	}


	public AccountingDocumentLineForm nameField(String parameterName, String initValue){
		FormField field = nameFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public AccountingDocumentLineForm nameField(){
		return nameField("name","");
	}


	public AccountingDocumentLineForm codeField(String parameterName, String initValue){
		FormField field = codeFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public AccountingDocumentLineForm codeField(){
		return codeField("code","");
	}


	public AccountingDocumentLineForm directField(String parameterName, String initValue){
		FormField field = directFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm directField(String initValue){
		return directField("direct",initValue);
	}
	public AccountingDocumentLineForm directField(){
		return directField("direct","");
	}


	public AccountingDocumentLineForm amountField(String parameterName, String initValue){
		FormField field = amountFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public AccountingDocumentLineForm amountField(){
		return amountField("amount","");
	}


	public AccountingDocumentLineForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public AccountingDocumentLineForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public AccountingDocumentLineForm accountingSubjectIdField(String parameterName, String initValue){
		FormField field = accountingSubjectIdFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentLineForm accountingSubjectIdField(String initValue){
		return accountingSubjectIdField("accountingSubjectId",initValue);
	}
	public AccountingDocumentLineForm accountingSubjectIdField(){
		return accountingSubjectIdField("accountingSubjectId","");
	}

	
	


	public AccountingDocumentLineForm accountingDocumentIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingDocumentIdFieldOfAccountingDocument(String initValue){
		return accountingDocumentIdFieldOfAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingDocumentLineForm accountingDocumentIdFieldOfAccountingDocument(){
		return accountingDocumentIdFieldOfAccountingDocument("accountingDocumentId","");
	}


	public AccountingDocumentLineForm nameFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm nameFieldOfAccountingDocument(String initValue){
		return nameFieldOfAccountingDocument("name",initValue);
	}
	public AccountingDocumentLineForm nameFieldOfAccountingDocument(){
		return nameFieldOfAccountingDocument("name","");
	}


	public AccountingDocumentLineForm accountingDocumentDateFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingDocumentDateFieldOfAccountingDocument(String initValue){
		return accountingDocumentDateFieldOfAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingDocumentLineForm accountingDocumentDateFieldOfAccountingDocument(){
		return accountingDocumentDateFieldOfAccountingDocument("accountingDocumentDate","");
	}


	public AccountingDocumentLineForm accountingPeriodIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingPeriodIdFieldOfAccountingDocument(String initValue){
		return accountingPeriodIdFieldOfAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingDocumentLineForm accountingPeriodIdFieldOfAccountingDocument(){
		return accountingPeriodIdFieldOfAccountingDocument("accountingPeriodId","");
	}


	public AccountingDocumentLineForm documentTypeIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm documentTypeIdFieldOfAccountingDocument(String initValue){
		return documentTypeIdFieldOfAccountingDocument("documentTypeId",initValue);
	}
	public AccountingDocumentLineForm documentTypeIdFieldOfAccountingDocument(){
		return documentTypeIdFieldOfAccountingDocument("documentTypeId","");
	}


	public AccountingDocumentLineForm creationIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm creationIdFieldOfAccountingDocument(String initValue){
		return creationIdFieldOfAccountingDocument("creationId",initValue);
	}
	public AccountingDocumentLineForm creationIdFieldOfAccountingDocument(){
		return creationIdFieldOfAccountingDocument("creationId","");
	}


	public AccountingDocumentLineForm confirmationIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm confirmationIdFieldOfAccountingDocument(String initValue){
		return confirmationIdFieldOfAccountingDocument("confirmationId",initValue);
	}
	public AccountingDocumentLineForm confirmationIdFieldOfAccountingDocument(){
		return confirmationIdFieldOfAccountingDocument("confirmationId","");
	}


	public AccountingDocumentLineForm auditingIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm auditingIdFieldOfAccountingDocument(String initValue){
		return auditingIdFieldOfAccountingDocument("auditingId",initValue);
	}
	public AccountingDocumentLineForm auditingIdFieldOfAccountingDocument(){
		return auditingIdFieldOfAccountingDocument("auditingId","");
	}


	public AccountingDocumentLineForm postingIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm postingIdFieldOfAccountingDocument(String initValue){
		return postingIdFieldOfAccountingDocument("postingId",initValue);
	}
	public AccountingDocumentLineForm postingIdFieldOfAccountingDocument(){
		return postingIdFieldOfAccountingDocument("postingId","");
	}


	public AccountingDocumentLineForm currentStatusFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm currentStatusFieldOfAccountingDocument(String initValue){
		return currentStatusFieldOfAccountingDocument("currentStatus",initValue);
	}
	public AccountingDocumentLineForm currentStatusFieldOfAccountingDocument(){
		return currentStatusFieldOfAccountingDocument("currentStatus","");
	}


	public AccountingDocumentLineForm accountingSubjectIdFieldOfAccountingSubject(String parameterName, String initValue){
		FormField field =  idFromAccountingSubject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingSubjectIdFieldOfAccountingSubject(String initValue){
		return accountingSubjectIdFieldOfAccountingSubject("accountingSubjectId",initValue);
	}
	public AccountingDocumentLineForm accountingSubjectIdFieldOfAccountingSubject(){
		return accountingSubjectIdFieldOfAccountingSubject("accountingSubjectId","");
	}


	public AccountingDocumentLineForm accountingSubjectCodeFieldOfAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectCodeFromAccountingSubject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingSubjectCodeFieldOfAccountingSubject(String initValue){
		return accountingSubjectCodeFieldOfAccountingSubject("accountingSubjectCode",initValue);
	}
	public AccountingDocumentLineForm accountingSubjectCodeFieldOfAccountingSubject(){
		return accountingSubjectCodeFieldOfAccountingSubject("accountingSubjectCode","");
	}


	public AccountingDocumentLineForm accountingSubjectNameFieldOfAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectNameFromAccountingSubject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingSubjectNameFieldOfAccountingSubject(String initValue){
		return accountingSubjectNameFieldOfAccountingSubject("accountingSubjectName",initValue);
	}
	public AccountingDocumentLineForm accountingSubjectNameFieldOfAccountingSubject(){
		return accountingSubjectNameFieldOfAccountingSubject("accountingSubjectName","");
	}


	public AccountingDocumentLineForm accountingSubjectClassCodeFieldOfAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectClassCodeFromAccountingSubject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingSubjectClassCodeFieldOfAccountingSubject(String initValue){
		return accountingSubjectClassCodeFieldOfAccountingSubject("accountingSubjectClassCode",initValue);
	}
	public AccountingDocumentLineForm accountingSubjectClassCodeFieldOfAccountingSubject(){
		return accountingSubjectClassCodeFieldOfAccountingSubject("accountingSubjectClassCode","");
	}


	public AccountingDocumentLineForm accountingSubjectClassNameFieldOfAccountingSubject(String parameterName, String initValue){
		FormField field =  accountingSubjectClassNameFromAccountingSubject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountingSubjectClassNameFieldOfAccountingSubject(String initValue){
		return accountingSubjectClassNameFieldOfAccountingSubject("accountingSubjectClassName",initValue);
	}
	public AccountingDocumentLineForm accountingSubjectClassNameFieldOfAccountingSubject(){
		return accountingSubjectClassNameFieldOfAccountingSubject("accountingSubjectClassName","");
	}


	public AccountingDocumentLineForm accountSetIdFieldOfAccountingSubject(String parameterName, String initValue){
		FormField field =  accountSetIdFromAccountingSubject(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentLineForm accountSetIdFieldOfAccountingSubject(String initValue){
		return accountSetIdFieldOfAccountingSubject("accountSetId",initValue);
	}
	public AccountingDocumentLineForm accountSetIdFieldOfAccountingSubject(){
		return accountSetIdFieldOfAccountingSubject("accountSetId","");
	}

	


	

	
 	public AccountingDocumentLineForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/accountingDocumentLineId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AccountingDocumentLineForm transferToAnotherAccountingSubjectAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAccountingSubject/accountingDocumentLineId/");
		this.addFormAction(action);
		return this;
	}

 

	public AccountingDocumentLineForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



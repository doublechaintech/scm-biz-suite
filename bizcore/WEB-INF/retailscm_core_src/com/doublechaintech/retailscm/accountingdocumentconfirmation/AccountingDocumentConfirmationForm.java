package com.doublechaintech.retailscm.accountingdocumentconfirmation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentConfirmationForm extends BaseForm {
	
	
	public AccountingDocumentConfirmationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentConfirmationForm accountingDocumentConfirmationIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocumentConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm accountingDocumentConfirmationIdField(String initValue){
		return accountingDocumentConfirmationIdField("accountingDocumentConfirmationId",initValue);
	}
	public AccountingDocumentConfirmationForm accountingDocumentConfirmationIdField(){
		return accountingDocumentConfirmationIdField("accountingDocumentConfirmationId","");
	}


	public AccountingDocumentConfirmationForm whoField(String parameterName, String initValue){
		FormField field = whoFromAccountingDocumentConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public AccountingDocumentConfirmationForm whoField(){
		return whoField("who","");
	}


	public AccountingDocumentConfirmationForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromAccountingDocumentConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public AccountingDocumentConfirmationForm commentsField(){
		return commentsField("comments","");
	}


	public AccountingDocumentConfirmationForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromAccountingDocumentConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public AccountingDocumentConfirmationForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public AccountingDocumentConfirmationForm accountingDocumentIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm accountingDocumentIdFieldForAccountingDocument(String initValue){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingDocumentConfirmationForm accountingDocumentIdFieldForAccountingDocument(){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId","");
	}


	public AccountingDocumentConfirmationForm nameFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm nameFieldForAccountingDocument(String initValue){
		return nameFieldForAccountingDocument("name",initValue);
	}
	public AccountingDocumentConfirmationForm nameFieldForAccountingDocument(){
		return nameFieldForAccountingDocument("name","");
	}


	public AccountingDocumentConfirmationForm accountingDocumentDateFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm accountingDocumentDateFieldForAccountingDocument(String initValue){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingDocumentConfirmationForm accountingDocumentDateFieldForAccountingDocument(){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate","");
	}


	public AccountingDocumentConfirmationForm accountingPeriodIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm accountingPeriodIdFieldForAccountingDocument(String initValue){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingDocumentConfirmationForm accountingPeriodIdFieldForAccountingDocument(){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId","");
	}


	public AccountingDocumentConfirmationForm documentTypeIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm documentTypeIdFieldForAccountingDocument(String initValue){
		return documentTypeIdFieldForAccountingDocument("documentTypeId",initValue);
	}
	public AccountingDocumentConfirmationForm documentTypeIdFieldForAccountingDocument(){
		return documentTypeIdFieldForAccountingDocument("documentTypeId","");
	}


	public AccountingDocumentConfirmationForm creationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm creationIdFieldForAccountingDocument(String initValue){
		return creationIdFieldForAccountingDocument("creationId",initValue);
	}
	public AccountingDocumentConfirmationForm creationIdFieldForAccountingDocument(){
		return creationIdFieldForAccountingDocument("creationId","");
	}


	public AccountingDocumentConfirmationForm confirmationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm confirmationIdFieldForAccountingDocument(String initValue){
		return confirmationIdFieldForAccountingDocument("confirmationId",initValue);
	}
	public AccountingDocumentConfirmationForm confirmationIdFieldForAccountingDocument(){
		return confirmationIdFieldForAccountingDocument("confirmationId","");
	}


	public AccountingDocumentConfirmationForm auditingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm auditingIdFieldForAccountingDocument(String initValue){
		return auditingIdFieldForAccountingDocument("auditingId",initValue);
	}
	public AccountingDocumentConfirmationForm auditingIdFieldForAccountingDocument(){
		return auditingIdFieldForAccountingDocument("auditingId","");
	}


	public AccountingDocumentConfirmationForm postingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm postingIdFieldForAccountingDocument(String initValue){
		return postingIdFieldForAccountingDocument("postingId",initValue);
	}
	public AccountingDocumentConfirmationForm postingIdFieldForAccountingDocument(){
		return postingIdFieldForAccountingDocument("postingId","");
	}


	public AccountingDocumentConfirmationForm currentStatusFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentConfirmationForm currentStatusFieldForAccountingDocument(String initValue){
		return currentStatusFieldForAccountingDocument("currentStatus",initValue);
	}
	public AccountingDocumentConfirmationForm currentStatusFieldForAccountingDocument(){
		return currentStatusFieldForAccountingDocument("currentStatus","");
	}

	



	public AccountingDocumentConfirmationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



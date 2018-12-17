package com.doublechaintech.retailscm.accountingdocumentcreation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentCreationForm extends BaseForm {
	
	
	public AccountingDocumentCreationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentCreationForm accountingDocumentCreationIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocumentCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm accountingDocumentCreationIdField(String initValue){
		return accountingDocumentCreationIdField("accountingDocumentCreationId",initValue);
	}
	public AccountingDocumentCreationForm accountingDocumentCreationIdField(){
		return accountingDocumentCreationIdField("accountingDocumentCreationId","");
	}


	public AccountingDocumentCreationForm whoField(String parameterName, String initValue){
		FormField field = whoFromAccountingDocumentCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public AccountingDocumentCreationForm whoField(){
		return whoField("who","");
	}


	public AccountingDocumentCreationForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromAccountingDocumentCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public AccountingDocumentCreationForm commentsField(){
		return commentsField("comments","");
	}


	public AccountingDocumentCreationForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromAccountingDocumentCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public AccountingDocumentCreationForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public AccountingDocumentCreationForm accountingDocumentIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm accountingDocumentIdFieldForAccountingDocument(String initValue){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingDocumentCreationForm accountingDocumentIdFieldForAccountingDocument(){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId","");
	}


	public AccountingDocumentCreationForm nameFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm nameFieldForAccountingDocument(String initValue){
		return nameFieldForAccountingDocument("name",initValue);
	}
	public AccountingDocumentCreationForm nameFieldForAccountingDocument(){
		return nameFieldForAccountingDocument("name","");
	}


	public AccountingDocumentCreationForm accountingDocumentDateFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm accountingDocumentDateFieldForAccountingDocument(String initValue){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingDocumentCreationForm accountingDocumentDateFieldForAccountingDocument(){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate","");
	}


	public AccountingDocumentCreationForm accountingPeriodIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm accountingPeriodIdFieldForAccountingDocument(String initValue){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingDocumentCreationForm accountingPeriodIdFieldForAccountingDocument(){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId","");
	}


	public AccountingDocumentCreationForm documentTypeIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm documentTypeIdFieldForAccountingDocument(String initValue){
		return documentTypeIdFieldForAccountingDocument("documentTypeId",initValue);
	}
	public AccountingDocumentCreationForm documentTypeIdFieldForAccountingDocument(){
		return documentTypeIdFieldForAccountingDocument("documentTypeId","");
	}


	public AccountingDocumentCreationForm creationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm creationIdFieldForAccountingDocument(String initValue){
		return creationIdFieldForAccountingDocument("creationId",initValue);
	}
	public AccountingDocumentCreationForm creationIdFieldForAccountingDocument(){
		return creationIdFieldForAccountingDocument("creationId","");
	}


	public AccountingDocumentCreationForm confirmationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm confirmationIdFieldForAccountingDocument(String initValue){
		return confirmationIdFieldForAccountingDocument("confirmationId",initValue);
	}
	public AccountingDocumentCreationForm confirmationIdFieldForAccountingDocument(){
		return confirmationIdFieldForAccountingDocument("confirmationId","");
	}


	public AccountingDocumentCreationForm auditingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm auditingIdFieldForAccountingDocument(String initValue){
		return auditingIdFieldForAccountingDocument("auditingId",initValue);
	}
	public AccountingDocumentCreationForm auditingIdFieldForAccountingDocument(){
		return auditingIdFieldForAccountingDocument("auditingId","");
	}


	public AccountingDocumentCreationForm postingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm postingIdFieldForAccountingDocument(String initValue){
		return postingIdFieldForAccountingDocument("postingId",initValue);
	}
	public AccountingDocumentCreationForm postingIdFieldForAccountingDocument(){
		return postingIdFieldForAccountingDocument("postingId","");
	}


	public AccountingDocumentCreationForm currentStatusFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentCreationForm currentStatusFieldForAccountingDocument(String initValue){
		return currentStatusFieldForAccountingDocument("currentStatus",initValue);
	}
	public AccountingDocumentCreationForm currentStatusFieldForAccountingDocument(){
		return currentStatusFieldForAccountingDocument("currentStatus","");
	}

	



	public AccountingDocumentCreationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



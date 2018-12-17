package com.doublechaintech.retailscm.accountingdocumentauditing;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentAuditingForm extends BaseForm {
	
	
	public AccountingDocumentAuditingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentAuditingForm accountingDocumentAuditingIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocumentAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm accountingDocumentAuditingIdField(String initValue){
		return accountingDocumentAuditingIdField("accountingDocumentAuditingId",initValue);
	}
	public AccountingDocumentAuditingForm accountingDocumentAuditingIdField(){
		return accountingDocumentAuditingIdField("accountingDocumentAuditingId","");
	}


	public AccountingDocumentAuditingForm whoField(String parameterName, String initValue){
		FormField field = whoFromAccountingDocumentAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public AccountingDocumentAuditingForm whoField(){
		return whoField("who","");
	}


	public AccountingDocumentAuditingForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromAccountingDocumentAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public AccountingDocumentAuditingForm commentsField(){
		return commentsField("comments","");
	}


	public AccountingDocumentAuditingForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromAccountingDocumentAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public AccountingDocumentAuditingForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public AccountingDocumentAuditingForm accountingDocumentIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm accountingDocumentIdFieldForAccountingDocument(String initValue){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingDocumentAuditingForm accountingDocumentIdFieldForAccountingDocument(){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId","");
	}


	public AccountingDocumentAuditingForm nameFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm nameFieldForAccountingDocument(String initValue){
		return nameFieldForAccountingDocument("name",initValue);
	}
	public AccountingDocumentAuditingForm nameFieldForAccountingDocument(){
		return nameFieldForAccountingDocument("name","");
	}


	public AccountingDocumentAuditingForm accountingDocumentDateFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm accountingDocumentDateFieldForAccountingDocument(String initValue){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingDocumentAuditingForm accountingDocumentDateFieldForAccountingDocument(){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate","");
	}


	public AccountingDocumentAuditingForm accountingPeriodIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm accountingPeriodIdFieldForAccountingDocument(String initValue){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingDocumentAuditingForm accountingPeriodIdFieldForAccountingDocument(){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId","");
	}


	public AccountingDocumentAuditingForm documentTypeIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm documentTypeIdFieldForAccountingDocument(String initValue){
		return documentTypeIdFieldForAccountingDocument("documentTypeId",initValue);
	}
	public AccountingDocumentAuditingForm documentTypeIdFieldForAccountingDocument(){
		return documentTypeIdFieldForAccountingDocument("documentTypeId","");
	}


	public AccountingDocumentAuditingForm creationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm creationIdFieldForAccountingDocument(String initValue){
		return creationIdFieldForAccountingDocument("creationId",initValue);
	}
	public AccountingDocumentAuditingForm creationIdFieldForAccountingDocument(){
		return creationIdFieldForAccountingDocument("creationId","");
	}


	public AccountingDocumentAuditingForm confirmationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm confirmationIdFieldForAccountingDocument(String initValue){
		return confirmationIdFieldForAccountingDocument("confirmationId",initValue);
	}
	public AccountingDocumentAuditingForm confirmationIdFieldForAccountingDocument(){
		return confirmationIdFieldForAccountingDocument("confirmationId","");
	}


	public AccountingDocumentAuditingForm auditingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm auditingIdFieldForAccountingDocument(String initValue){
		return auditingIdFieldForAccountingDocument("auditingId",initValue);
	}
	public AccountingDocumentAuditingForm auditingIdFieldForAccountingDocument(){
		return auditingIdFieldForAccountingDocument("auditingId","");
	}


	public AccountingDocumentAuditingForm postingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm postingIdFieldForAccountingDocument(String initValue){
		return postingIdFieldForAccountingDocument("postingId",initValue);
	}
	public AccountingDocumentAuditingForm postingIdFieldForAccountingDocument(){
		return postingIdFieldForAccountingDocument("postingId","");
	}


	public AccountingDocumentAuditingForm currentStatusFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentAuditingForm currentStatusFieldForAccountingDocument(String initValue){
		return currentStatusFieldForAccountingDocument("currentStatus",initValue);
	}
	public AccountingDocumentAuditingForm currentStatusFieldForAccountingDocument(){
		return currentStatusFieldForAccountingDocument("currentStatus","");
	}

	



	public AccountingDocumentAuditingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



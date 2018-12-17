package com.doublechaintech.retailscm.accountingdocumentposting;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentPostingForm extends BaseForm {
	
	
	public AccountingDocumentPostingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentPostingForm accountingDocumentPostingIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocumentPosting(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm accountingDocumentPostingIdField(String initValue){
		return accountingDocumentPostingIdField("accountingDocumentPostingId",initValue);
	}
	public AccountingDocumentPostingForm accountingDocumentPostingIdField(){
		return accountingDocumentPostingIdField("accountingDocumentPostingId","");
	}


	public AccountingDocumentPostingForm whoField(String parameterName, String initValue){
		FormField field = whoFromAccountingDocumentPosting(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public AccountingDocumentPostingForm whoField(){
		return whoField("who","");
	}


	public AccountingDocumentPostingForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromAccountingDocumentPosting(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public AccountingDocumentPostingForm commentsField(){
		return commentsField("comments","");
	}


	public AccountingDocumentPostingForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromAccountingDocumentPosting(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public AccountingDocumentPostingForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public AccountingDocumentPostingForm accountingDocumentIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm accountingDocumentIdFieldForAccountingDocument(String initValue){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId",initValue);
	}
	public AccountingDocumentPostingForm accountingDocumentIdFieldForAccountingDocument(){
		return accountingDocumentIdFieldForAccountingDocument("accountingDocumentId","");
	}


	public AccountingDocumentPostingForm nameFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm nameFieldForAccountingDocument(String initValue){
		return nameFieldForAccountingDocument("name",initValue);
	}
	public AccountingDocumentPostingForm nameFieldForAccountingDocument(){
		return nameFieldForAccountingDocument("name","");
	}


	public AccountingDocumentPostingForm accountingDocumentDateFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm accountingDocumentDateFieldForAccountingDocument(String initValue){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate",initValue);
	}
	public AccountingDocumentPostingForm accountingDocumentDateFieldForAccountingDocument(){
		return accountingDocumentDateFieldForAccountingDocument("accountingDocumentDate","");
	}


	public AccountingDocumentPostingForm accountingPeriodIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm accountingPeriodIdFieldForAccountingDocument(String initValue){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId",initValue);
	}
	public AccountingDocumentPostingForm accountingPeriodIdFieldForAccountingDocument(){
		return accountingPeriodIdFieldForAccountingDocument("accountingPeriodId","");
	}


	public AccountingDocumentPostingForm documentTypeIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm documentTypeIdFieldForAccountingDocument(String initValue){
		return documentTypeIdFieldForAccountingDocument("documentTypeId",initValue);
	}
	public AccountingDocumentPostingForm documentTypeIdFieldForAccountingDocument(){
		return documentTypeIdFieldForAccountingDocument("documentTypeId","");
	}


	public AccountingDocumentPostingForm creationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm creationIdFieldForAccountingDocument(String initValue){
		return creationIdFieldForAccountingDocument("creationId",initValue);
	}
	public AccountingDocumentPostingForm creationIdFieldForAccountingDocument(){
		return creationIdFieldForAccountingDocument("creationId","");
	}


	public AccountingDocumentPostingForm confirmationIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm confirmationIdFieldForAccountingDocument(String initValue){
		return confirmationIdFieldForAccountingDocument("confirmationId",initValue);
	}
	public AccountingDocumentPostingForm confirmationIdFieldForAccountingDocument(){
		return confirmationIdFieldForAccountingDocument("confirmationId","");
	}


	public AccountingDocumentPostingForm auditingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm auditingIdFieldForAccountingDocument(String initValue){
		return auditingIdFieldForAccountingDocument("auditingId",initValue);
	}
	public AccountingDocumentPostingForm auditingIdFieldForAccountingDocument(){
		return auditingIdFieldForAccountingDocument("auditingId","");
	}


	public AccountingDocumentPostingForm postingIdFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm postingIdFieldForAccountingDocument(String initValue){
		return postingIdFieldForAccountingDocument("postingId",initValue);
	}
	public AccountingDocumentPostingForm postingIdFieldForAccountingDocument(){
		return postingIdFieldForAccountingDocument("postingId","");
	}


	public AccountingDocumentPostingForm currentStatusFieldForAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentPostingForm currentStatusFieldForAccountingDocument(String initValue){
		return currentStatusFieldForAccountingDocument("currentStatus",initValue);
	}
	public AccountingDocumentPostingForm currentStatusFieldForAccountingDocument(){
		return currentStatusFieldForAccountingDocument("currentStatus","");
	}

	



	public AccountingDocumentPostingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



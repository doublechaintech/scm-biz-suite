package com.doublechaintech.retailscm.accountingdocument;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class AccountingDocumentForm extends BaseForm {
	
	
	public AccountingDocumentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AccountingDocumentForm accountingDocumentIdField(String parameterName, String initValue){
		FormField field = idFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentIdField(String initValue){
		return accountingDocumentIdField("accountingDocumentId",initValue);
	}
	public AccountingDocumentForm accountingDocumentIdField(){
		return accountingDocumentIdField("accountingDocumentId","");
	}


	public AccountingDocumentForm nameField(String parameterName, String initValue){
		FormField field = nameFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public AccountingDocumentForm nameField(){
		return nameField("name","");
	}


	public AccountingDocumentForm accountingDocumentDateField(String parameterName, String initValue){
		FormField field = accountingDocumentDateFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentDateField(String initValue){
		return accountingDocumentDateField("accountingDocumentDate",initValue);
	}
	public AccountingDocumentForm accountingDocumentDateField(){
		return accountingDocumentDateField("accountingDocumentDate","");
	}


	public AccountingDocumentForm accountingPeriodIdField(String parameterName, String initValue){
		FormField field = accountingPeriodIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm accountingPeriodIdField(String initValue){
		return accountingPeriodIdField("accountingPeriodId",initValue);
	}
	public AccountingDocumentForm accountingPeriodIdField(){
		return accountingPeriodIdField("accountingPeriodId","");
	}


	public AccountingDocumentForm documentTypeIdField(String parameterName, String initValue){
		FormField field = documentTypeIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm documentTypeIdField(String initValue){
		return documentTypeIdField("documentTypeId",initValue);
	}
	public AccountingDocumentForm documentTypeIdField(){
		return documentTypeIdField("documentTypeId","");
	}


	public AccountingDocumentForm creationIdField(String parameterName, String initValue){
		FormField field = creationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm creationIdField(String initValue){
		return creationIdField("creationId",initValue);
	}
	public AccountingDocumentForm creationIdField(){
		return creationIdField("creationId","");
	}


	public AccountingDocumentForm confirmationIdField(String parameterName, String initValue){
		FormField field = confirmationIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm confirmationIdField(String initValue){
		return confirmationIdField("confirmationId",initValue);
	}
	public AccountingDocumentForm confirmationIdField(){
		return confirmationIdField("confirmationId","");
	}


	public AccountingDocumentForm auditingIdField(String parameterName, String initValue){
		FormField field = auditingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm auditingIdField(String initValue){
		return auditingIdField("auditingId",initValue);
	}
	public AccountingDocumentForm auditingIdField(){
		return auditingIdField("auditingId","");
	}


	public AccountingDocumentForm postingIdField(String parameterName, String initValue){
		FormField field = postingIdFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm postingIdField(String initValue){
		return postingIdField("postingId",initValue);
	}
	public AccountingDocumentForm postingIdField(){
		return postingIdField("postingId","");
	}


	public AccountingDocumentForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromAccountingDocument(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public AccountingDocumentForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public AccountingDocumentForm accountingPeriodIdFieldOfAccountingPeriod(String parameterName, String initValue){
		FormField field =  idFromAccountingPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingPeriodIdFieldOfAccountingPeriod(String initValue){
		return accountingPeriodIdFieldOfAccountingPeriod("accountingPeriodId",initValue);
	}
	public AccountingDocumentForm accountingPeriodIdFieldOfAccountingPeriod(){
		return accountingPeriodIdFieldOfAccountingPeriod("accountingPeriodId","");
	}


	public AccountingDocumentForm nameFieldOfAccountingPeriod(String parameterName, String initValue){
		FormField field =  nameFromAccountingPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm nameFieldOfAccountingPeriod(String initValue){
		return nameFieldOfAccountingPeriod("name",initValue);
	}
	public AccountingDocumentForm nameFieldOfAccountingPeriod(){
		return nameFieldOfAccountingPeriod("name","");
	}


	public AccountingDocumentForm startDateFieldOfAccountingPeriod(String parameterName, String initValue){
		FormField field =  startDateFromAccountingPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm startDateFieldOfAccountingPeriod(String initValue){
		return startDateFieldOfAccountingPeriod("startDate",initValue);
	}
	public AccountingDocumentForm startDateFieldOfAccountingPeriod(){
		return startDateFieldOfAccountingPeriod("startDate","");
	}


	public AccountingDocumentForm endDateFieldOfAccountingPeriod(String parameterName, String initValue){
		FormField field =  endDateFromAccountingPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm endDateFieldOfAccountingPeriod(String initValue){
		return endDateFieldOfAccountingPeriod("endDate",initValue);
	}
	public AccountingDocumentForm endDateFieldOfAccountingPeriod(){
		return endDateFieldOfAccountingPeriod("endDate","");
	}


	public AccountingDocumentForm accountSetIdFieldOfAccountingPeriod(String parameterName, String initValue){
		FormField field =  accountSetIdFromAccountingPeriod(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountSetIdFieldOfAccountingPeriod(String initValue){
		return accountSetIdFieldOfAccountingPeriod("accountSetId",initValue);
	}
	public AccountingDocumentForm accountSetIdFieldOfAccountingPeriod(){
		return accountSetIdFieldOfAccountingPeriod("accountSetId","");
	}


	public AccountingDocumentForm accountingDocumentTypeIdFieldOfAccountingDocumentType(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentTypeIdFieldOfAccountingDocumentType(String initValue){
		return accountingDocumentTypeIdFieldOfAccountingDocumentType("accountingDocumentTypeId",initValue);
	}
	public AccountingDocumentForm accountingDocumentTypeIdFieldOfAccountingDocumentType(){
		return accountingDocumentTypeIdFieldOfAccountingDocumentType("accountingDocumentTypeId","");
	}


	public AccountingDocumentForm nameFieldOfAccountingDocumentType(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocumentType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm nameFieldOfAccountingDocumentType(String initValue){
		return nameFieldOfAccountingDocumentType("name",initValue);
	}
	public AccountingDocumentForm nameFieldOfAccountingDocumentType(){
		return nameFieldOfAccountingDocumentType("name","");
	}


	public AccountingDocumentForm descriptionFieldOfAccountingDocumentType(String parameterName, String initValue){
		FormField field =  descriptionFromAccountingDocumentType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm descriptionFieldOfAccountingDocumentType(String initValue){
		return descriptionFieldOfAccountingDocumentType("description",initValue);
	}
	public AccountingDocumentForm descriptionFieldOfAccountingDocumentType(){
		return descriptionFieldOfAccountingDocumentType("description","");
	}


	public AccountingDocumentForm accountingPeriodIdFieldOfAccountingDocumentType(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocumentType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingPeriodIdFieldOfAccountingDocumentType(String initValue){
		return accountingPeriodIdFieldOfAccountingDocumentType("accountingPeriodId",initValue);
	}
	public AccountingDocumentForm accountingPeriodIdFieldOfAccountingDocumentType(){
		return accountingPeriodIdFieldOfAccountingDocumentType("accountingPeriodId","");
	}


	public AccountingDocumentForm accountingDocumentCreationIdFieldOfAccountingDocumentCreation(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentCreationIdFieldOfAccountingDocumentCreation(String initValue){
		return accountingDocumentCreationIdFieldOfAccountingDocumentCreation("accountingDocumentCreationId",initValue);
	}
	public AccountingDocumentForm accountingDocumentCreationIdFieldOfAccountingDocumentCreation(){
		return accountingDocumentCreationIdFieldOfAccountingDocumentCreation("accountingDocumentCreationId","");
	}


	public AccountingDocumentForm whoFieldOfAccountingDocumentCreation(String parameterName, String initValue){
		FormField field =  whoFromAccountingDocumentCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm whoFieldOfAccountingDocumentCreation(String initValue){
		return whoFieldOfAccountingDocumentCreation("who",initValue);
	}
	public AccountingDocumentForm whoFieldOfAccountingDocumentCreation(){
		return whoFieldOfAccountingDocumentCreation("who","");
	}


	public AccountingDocumentForm commentsFieldOfAccountingDocumentCreation(String parameterName, String initValue){
		FormField field =  commentsFromAccountingDocumentCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm commentsFieldOfAccountingDocumentCreation(String initValue){
		return commentsFieldOfAccountingDocumentCreation("comments",initValue);
	}
	public AccountingDocumentForm commentsFieldOfAccountingDocumentCreation(){
		return commentsFieldOfAccountingDocumentCreation("comments","");
	}


	public AccountingDocumentForm makeDateFieldOfAccountingDocumentCreation(String parameterName, String initValue){
		FormField field =  makeDateFromAccountingDocumentCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentCreation(String initValue){
		return makeDateFieldOfAccountingDocumentCreation("makeDate",initValue);
	}
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentCreation(){
		return makeDateFieldOfAccountingDocumentCreation("makeDate","");
	}


	public AccountingDocumentForm accountingDocumentConfirmationIdFieldOfAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentConfirmationIdFieldOfAccountingDocumentConfirmation(String initValue){
		return accountingDocumentConfirmationIdFieldOfAccountingDocumentConfirmation("accountingDocumentConfirmationId",initValue);
	}
	public AccountingDocumentForm accountingDocumentConfirmationIdFieldOfAccountingDocumentConfirmation(){
		return accountingDocumentConfirmationIdFieldOfAccountingDocumentConfirmation("accountingDocumentConfirmationId","");
	}


	public AccountingDocumentForm whoFieldOfAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field =  whoFromAccountingDocumentConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm whoFieldOfAccountingDocumentConfirmation(String initValue){
		return whoFieldOfAccountingDocumentConfirmation("who",initValue);
	}
	public AccountingDocumentForm whoFieldOfAccountingDocumentConfirmation(){
		return whoFieldOfAccountingDocumentConfirmation("who","");
	}


	public AccountingDocumentForm commentsFieldOfAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field =  commentsFromAccountingDocumentConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm commentsFieldOfAccountingDocumentConfirmation(String initValue){
		return commentsFieldOfAccountingDocumentConfirmation("comments",initValue);
	}
	public AccountingDocumentForm commentsFieldOfAccountingDocumentConfirmation(){
		return commentsFieldOfAccountingDocumentConfirmation("comments","");
	}


	public AccountingDocumentForm makeDateFieldOfAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field =  makeDateFromAccountingDocumentConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentConfirmation(String initValue){
		return makeDateFieldOfAccountingDocumentConfirmation("makeDate",initValue);
	}
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentConfirmation(){
		return makeDateFieldOfAccountingDocumentConfirmation("makeDate","");
	}


	public AccountingDocumentForm accountingDocumentAuditingIdFieldOfAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentAuditingIdFieldOfAccountingDocumentAuditing(String initValue){
		return accountingDocumentAuditingIdFieldOfAccountingDocumentAuditing("accountingDocumentAuditingId",initValue);
	}
	public AccountingDocumentForm accountingDocumentAuditingIdFieldOfAccountingDocumentAuditing(){
		return accountingDocumentAuditingIdFieldOfAccountingDocumentAuditing("accountingDocumentAuditingId","");
	}


	public AccountingDocumentForm whoFieldOfAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field =  whoFromAccountingDocumentAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm whoFieldOfAccountingDocumentAuditing(String initValue){
		return whoFieldOfAccountingDocumentAuditing("who",initValue);
	}
	public AccountingDocumentForm whoFieldOfAccountingDocumentAuditing(){
		return whoFieldOfAccountingDocumentAuditing("who","");
	}


	public AccountingDocumentForm commentsFieldOfAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field =  commentsFromAccountingDocumentAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm commentsFieldOfAccountingDocumentAuditing(String initValue){
		return commentsFieldOfAccountingDocumentAuditing("comments",initValue);
	}
	public AccountingDocumentForm commentsFieldOfAccountingDocumentAuditing(){
		return commentsFieldOfAccountingDocumentAuditing("comments","");
	}


	public AccountingDocumentForm makeDateFieldOfAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field =  makeDateFromAccountingDocumentAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentAuditing(String initValue){
		return makeDateFieldOfAccountingDocumentAuditing("makeDate",initValue);
	}
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentAuditing(){
		return makeDateFieldOfAccountingDocumentAuditing("makeDate","");
	}


	public AccountingDocumentForm accountingDocumentPostingIdFieldOfAccountingDocumentPosting(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentPosting(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentPostingIdFieldOfAccountingDocumentPosting(String initValue){
		return accountingDocumentPostingIdFieldOfAccountingDocumentPosting("accountingDocumentPostingId",initValue);
	}
	public AccountingDocumentForm accountingDocumentPostingIdFieldOfAccountingDocumentPosting(){
		return accountingDocumentPostingIdFieldOfAccountingDocumentPosting("accountingDocumentPostingId","");
	}


	public AccountingDocumentForm whoFieldOfAccountingDocumentPosting(String parameterName, String initValue){
		FormField field =  whoFromAccountingDocumentPosting(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm whoFieldOfAccountingDocumentPosting(String initValue){
		return whoFieldOfAccountingDocumentPosting("who",initValue);
	}
	public AccountingDocumentForm whoFieldOfAccountingDocumentPosting(){
		return whoFieldOfAccountingDocumentPosting("who","");
	}


	public AccountingDocumentForm commentsFieldOfAccountingDocumentPosting(String parameterName, String initValue){
		FormField field =  commentsFromAccountingDocumentPosting(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm commentsFieldOfAccountingDocumentPosting(String initValue){
		return commentsFieldOfAccountingDocumentPosting("comments",initValue);
	}
	public AccountingDocumentForm commentsFieldOfAccountingDocumentPosting(){
		return commentsFieldOfAccountingDocumentPosting("comments","");
	}


	public AccountingDocumentForm makeDateFieldOfAccountingDocumentPosting(String parameterName, String initValue){
		FormField field =  makeDateFromAccountingDocumentPosting(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentPosting(String initValue){
		return makeDateFieldOfAccountingDocumentPosting("makeDate",initValue);
	}
	public AccountingDocumentForm makeDateFieldOfAccountingDocumentPosting(){
		return makeDateFieldOfAccountingDocumentPosting("makeDate","");
	}

	



	public AccountingDocumentForm originalVoucherIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm originalVoucherIdFieldForOriginalVoucher(String initValue){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId",initValue);
	}
	public AccountingDocumentForm originalVoucherIdFieldForOriginalVoucher(){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId","");
	}


	public AccountingDocumentForm titleFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  titleFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm titleFieldForOriginalVoucher(String initValue){
		return titleFieldForOriginalVoucher("title",initValue);
	}
	public AccountingDocumentForm titleFieldForOriginalVoucher(){
		return titleFieldForOriginalVoucher("title","");
	}


	public AccountingDocumentForm madeByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  madeByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm madeByFieldForOriginalVoucher(String initValue){
		return madeByFieldForOriginalVoucher("madeBy",initValue);
	}
	public AccountingDocumentForm madeByFieldForOriginalVoucher(){
		return madeByFieldForOriginalVoucher("madeBy","");
	}


	public AccountingDocumentForm receivedByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  receivedByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm receivedByFieldForOriginalVoucher(String initValue){
		return receivedByFieldForOriginalVoucher("receivedBy",initValue);
	}
	public AccountingDocumentForm receivedByFieldForOriginalVoucher(){
		return receivedByFieldForOriginalVoucher("receivedBy","");
	}


	public AccountingDocumentForm voucherTypeFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherTypeFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm voucherTypeFieldForOriginalVoucher(String initValue){
		return voucherTypeFieldForOriginalVoucher("voucherType",initValue);
	}
	public AccountingDocumentForm voucherTypeFieldForOriginalVoucher(){
		return voucherTypeFieldForOriginalVoucher("voucherType","");
	}


	public AccountingDocumentForm voucherImageFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherImageFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm voucherImageFieldForOriginalVoucher(String initValue){
		return voucherImageFieldForOriginalVoucher("voucherImage",initValue);
	}
	public AccountingDocumentForm voucherImageFieldForOriginalVoucher(){
		return voucherImageFieldForOriginalVoucher("voucherImage","");
	}


	public AccountingDocumentForm belongsToIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  belongsToIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm belongsToIdFieldForOriginalVoucher(String initValue){
		return belongsToIdFieldForOriginalVoucher("belongsToId",initValue);
	}
	public AccountingDocumentForm belongsToIdFieldForOriginalVoucher(){
		return belongsToIdFieldForOriginalVoucher("belongsToId","");
	}


	public AccountingDocumentForm creationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  creationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm creationIdFieldForOriginalVoucher(String initValue){
		return creationIdFieldForOriginalVoucher("creationId",initValue);
	}
	public AccountingDocumentForm creationIdFieldForOriginalVoucher(){
		return creationIdFieldForOriginalVoucher("creationId","");
	}


	public AccountingDocumentForm confirmationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  confirmationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm confirmationIdFieldForOriginalVoucher(String initValue){
		return confirmationIdFieldForOriginalVoucher("confirmationId",initValue);
	}
	public AccountingDocumentForm confirmationIdFieldForOriginalVoucher(){
		return confirmationIdFieldForOriginalVoucher("confirmationId","");
	}


	public AccountingDocumentForm auditingIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  auditingIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm auditingIdFieldForOriginalVoucher(String initValue){
		return auditingIdFieldForOriginalVoucher("auditingId",initValue);
	}
	public AccountingDocumentForm auditingIdFieldForOriginalVoucher(){
		return auditingIdFieldForOriginalVoucher("auditingId","");
	}


	public AccountingDocumentForm currentStatusFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  currentStatusFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm currentStatusFieldForOriginalVoucher(String initValue){
		return currentStatusFieldForOriginalVoucher("currentStatus",initValue);
	}
	public AccountingDocumentForm currentStatusFieldForOriginalVoucher(){
		return currentStatusFieldForOriginalVoucher("currentStatus","");
	}


	public AccountingDocumentForm accountingDocumentLineIdFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  idFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm accountingDocumentLineIdFieldForAccountingDocumentLine(String initValue){
		return accountingDocumentLineIdFieldForAccountingDocumentLine("accountingDocumentLineId",initValue);
	}
	public AccountingDocumentForm accountingDocumentLineIdFieldForAccountingDocumentLine(){
		return accountingDocumentLineIdFieldForAccountingDocumentLine("accountingDocumentLineId","");
	}


	public AccountingDocumentForm nameFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm nameFieldForAccountingDocumentLine(String initValue){
		return nameFieldForAccountingDocumentLine("name",initValue);
	}
	public AccountingDocumentForm nameFieldForAccountingDocumentLine(){
		return nameFieldForAccountingDocumentLine("name","");
	}


	public AccountingDocumentForm codeFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  codeFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm codeFieldForAccountingDocumentLine(String initValue){
		return codeFieldForAccountingDocumentLine("code",initValue);
	}
	public AccountingDocumentForm codeFieldForAccountingDocumentLine(){
		return codeFieldForAccountingDocumentLine("code","");
	}


	public AccountingDocumentForm directFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  directFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm directFieldForAccountingDocumentLine(String initValue){
		return directFieldForAccountingDocumentLine("direct",initValue);
	}
	public AccountingDocumentForm directFieldForAccountingDocumentLine(){
		return directFieldForAccountingDocumentLine("direct","");
	}


	public AccountingDocumentForm amountFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  amountFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm amountFieldForAccountingDocumentLine(String initValue){
		return amountFieldForAccountingDocumentLine("amount",initValue);
	}
	public AccountingDocumentForm amountFieldForAccountingDocumentLine(){
		return amountFieldForAccountingDocumentLine("amount","");
	}


	public AccountingDocumentForm belongsToIdFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  belongsToIdFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm belongsToIdFieldForAccountingDocumentLine(String initValue){
		return belongsToIdFieldForAccountingDocumentLine("belongsToId",initValue);
	}
	public AccountingDocumentForm belongsToIdFieldForAccountingDocumentLine(){
		return belongsToIdFieldForAccountingDocumentLine("belongsToId","");
	}


	public AccountingDocumentForm accountingSubjectIdFieldForAccountingDocumentLine(String parameterName, String initValue){
		FormField field =  accountingSubjectIdFromAccountingDocumentLine(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AccountingDocumentForm accountingSubjectIdFieldForAccountingDocumentLine(String initValue){
		return accountingSubjectIdFieldForAccountingDocumentLine("accountingSubjectId",initValue);
	}
	public AccountingDocumentForm accountingSubjectIdFieldForAccountingDocumentLine(){
		return accountingSubjectIdFieldForAccountingDocumentLine("accountingSubjectId","");
	}

	

	
 	public AccountingDocumentForm transferToAnotherAccountingPeriodAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherAccountingPeriod/accountingDocumentId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AccountingDocumentForm transferToAnotherDocumentTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDocumentType/accountingDocumentId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AccountingDocumentForm  createAction(){
		FormAction action = new FormAction();
		action.setLabel("创建");
		action.setLocaleKey("accounting_document.create");
		action.setUrl("accountingDocumentManager/create/accountingDocumentId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}	
 	public AccountingDocumentForm  confirmAction(){
		FormAction action = new FormAction();
		action.setLabel("确认");
		action.setLocaleKey("accounting_document.confirm");
		action.setUrl("accountingDocumentManager/confirm/accountingDocumentId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}	
 	public AccountingDocumentForm  auditAction(){
		FormAction action = new FormAction();
		action.setLabel("审计");
		action.setLocaleKey("accounting_document.audit");
		action.setUrl("accountingDocumentManager/audit/accountingDocumentId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}	
 	public AccountingDocumentForm  postAction(){
		FormAction action = new FormAction();
		action.setLabel("帖子");
		action.setLocaleKey("accounting_document.post");
		action.setUrl("accountingDocumentManager/post/accountingDocumentId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}

	public AccountingDocumentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.originalvoucher;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class OriginalVoucherForm extends BaseForm {
	
	
	public OriginalVoucherForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OriginalVoucherForm originalVoucherIdField(String parameterName, String initValue){
		FormField field = idFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm originalVoucherIdField(String initValue){
		return originalVoucherIdField("originalVoucherId",initValue);
	}
	public OriginalVoucherForm originalVoucherIdField(){
		return originalVoucherIdField("originalVoucherId","");
	}


	public OriginalVoucherForm titleField(String parameterName, String initValue){
		FormField field = titleFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public OriginalVoucherForm titleField(){
		return titleField("title","");
	}


	public OriginalVoucherForm madeByField(String parameterName, String initValue){
		FormField field = madeByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm madeByField(String initValue){
		return madeByField("madeBy",initValue);
	}
	public OriginalVoucherForm madeByField(){
		return madeByField("madeBy","");
	}


	public OriginalVoucherForm receivedByField(String parameterName, String initValue){
		FormField field = receivedByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm receivedByField(String initValue){
		return receivedByField("receivedBy",initValue);
	}
	public OriginalVoucherForm receivedByField(){
		return receivedByField("receivedBy","");
	}


	public OriginalVoucherForm voucherTypeField(String parameterName, String initValue){
		FormField field = voucherTypeFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm voucherTypeField(String initValue){
		return voucherTypeField("voucherType",initValue);
	}
	public OriginalVoucherForm voucherTypeField(){
		return voucherTypeField("voucherType","");
	}


	public OriginalVoucherForm voucherImageField(String parameterName, String initValue){
		FormField field = voucherImageFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm voucherImageField(String initValue){
		return voucherImageField("voucherImage",initValue);
	}
	public OriginalVoucherForm voucherImageField(){
		return voucherImageField("voucherImage","");
	}


	public OriginalVoucherForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public OriginalVoucherForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public OriginalVoucherForm creationIdField(String parameterName, String initValue){
		FormField field = creationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm creationIdField(String initValue){
		return creationIdField("creationId",initValue);
	}
	public OriginalVoucherForm creationIdField(){
		return creationIdField("creationId","");
	}


	public OriginalVoucherForm confirmationIdField(String parameterName, String initValue){
		FormField field = confirmationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm confirmationIdField(String initValue){
		return confirmationIdField("confirmationId",initValue);
	}
	public OriginalVoucherForm confirmationIdField(){
		return confirmationIdField("confirmationId","");
	}


	public OriginalVoucherForm auditingIdField(String parameterName, String initValue){
		FormField field = auditingIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm auditingIdField(String initValue){
		return auditingIdField("auditingId",initValue);
	}
	public OriginalVoucherForm auditingIdField(){
		return auditingIdField("auditingId","");
	}


	public OriginalVoucherForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public OriginalVoucherForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public OriginalVoucherForm accountingDocumentIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  idFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm accountingDocumentIdFieldOfAccountingDocument(String initValue){
		return accountingDocumentIdFieldOfAccountingDocument("accountingDocumentId",initValue);
	}
	public OriginalVoucherForm accountingDocumentIdFieldOfAccountingDocument(){
		return accountingDocumentIdFieldOfAccountingDocument("accountingDocumentId","");
	}


	public OriginalVoucherForm nameFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  nameFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm nameFieldOfAccountingDocument(String initValue){
		return nameFieldOfAccountingDocument("name",initValue);
	}
	public OriginalVoucherForm nameFieldOfAccountingDocument(){
		return nameFieldOfAccountingDocument("name","");
	}


	public OriginalVoucherForm accountingDocumentDateFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingDocumentDateFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm accountingDocumentDateFieldOfAccountingDocument(String initValue){
		return accountingDocumentDateFieldOfAccountingDocument("accountingDocumentDate",initValue);
	}
	public OriginalVoucherForm accountingDocumentDateFieldOfAccountingDocument(){
		return accountingDocumentDateFieldOfAccountingDocument("accountingDocumentDate","");
	}


	public OriginalVoucherForm accountingPeriodIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  accountingPeriodIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm accountingPeriodIdFieldOfAccountingDocument(String initValue){
		return accountingPeriodIdFieldOfAccountingDocument("accountingPeriodId",initValue);
	}
	public OriginalVoucherForm accountingPeriodIdFieldOfAccountingDocument(){
		return accountingPeriodIdFieldOfAccountingDocument("accountingPeriodId","");
	}


	public OriginalVoucherForm documentTypeIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  documentTypeIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm documentTypeIdFieldOfAccountingDocument(String initValue){
		return documentTypeIdFieldOfAccountingDocument("documentTypeId",initValue);
	}
	public OriginalVoucherForm documentTypeIdFieldOfAccountingDocument(){
		return documentTypeIdFieldOfAccountingDocument("documentTypeId","");
	}


	public OriginalVoucherForm creationIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  creationIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm creationIdFieldOfAccountingDocument(String initValue){
		return creationIdFieldOfAccountingDocument("creationId",initValue);
	}
	public OriginalVoucherForm creationIdFieldOfAccountingDocument(){
		return creationIdFieldOfAccountingDocument("creationId","");
	}


	public OriginalVoucherForm confirmationIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  confirmationIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm confirmationIdFieldOfAccountingDocument(String initValue){
		return confirmationIdFieldOfAccountingDocument("confirmationId",initValue);
	}
	public OriginalVoucherForm confirmationIdFieldOfAccountingDocument(){
		return confirmationIdFieldOfAccountingDocument("confirmationId","");
	}


	public OriginalVoucherForm auditingIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  auditingIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm auditingIdFieldOfAccountingDocument(String initValue){
		return auditingIdFieldOfAccountingDocument("auditingId",initValue);
	}
	public OriginalVoucherForm auditingIdFieldOfAccountingDocument(){
		return auditingIdFieldOfAccountingDocument("auditingId","");
	}


	public OriginalVoucherForm postingIdFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  postingIdFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm postingIdFieldOfAccountingDocument(String initValue){
		return postingIdFieldOfAccountingDocument("postingId",initValue);
	}
	public OriginalVoucherForm postingIdFieldOfAccountingDocument(){
		return postingIdFieldOfAccountingDocument("postingId","");
	}


	public OriginalVoucherForm currentStatusFieldOfAccountingDocument(String parameterName, String initValue){
		FormField field =  currentStatusFromAccountingDocument(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm currentStatusFieldOfAccountingDocument(String initValue){
		return currentStatusFieldOfAccountingDocument("currentStatus",initValue);
	}
	public OriginalVoucherForm currentStatusFieldOfAccountingDocument(){
		return currentStatusFieldOfAccountingDocument("currentStatus","");
	}


	public OriginalVoucherForm originalVoucherCreationIdFieldOfOriginalVoucherCreation(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucherCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm originalVoucherCreationIdFieldOfOriginalVoucherCreation(String initValue){
		return originalVoucherCreationIdFieldOfOriginalVoucherCreation("originalVoucherCreationId",initValue);
	}
	public OriginalVoucherForm originalVoucherCreationIdFieldOfOriginalVoucherCreation(){
		return originalVoucherCreationIdFieldOfOriginalVoucherCreation("originalVoucherCreationId","");
	}


	public OriginalVoucherForm whoFieldOfOriginalVoucherCreation(String parameterName, String initValue){
		FormField field =  whoFromOriginalVoucherCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm whoFieldOfOriginalVoucherCreation(String initValue){
		return whoFieldOfOriginalVoucherCreation("who",initValue);
	}
	public OriginalVoucherForm whoFieldOfOriginalVoucherCreation(){
		return whoFieldOfOriginalVoucherCreation("who","");
	}


	public OriginalVoucherForm commentsFieldOfOriginalVoucherCreation(String parameterName, String initValue){
		FormField field =  commentsFromOriginalVoucherCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm commentsFieldOfOriginalVoucherCreation(String initValue){
		return commentsFieldOfOriginalVoucherCreation("comments",initValue);
	}
	public OriginalVoucherForm commentsFieldOfOriginalVoucherCreation(){
		return commentsFieldOfOriginalVoucherCreation("comments","");
	}


	public OriginalVoucherForm makeDateFieldOfOriginalVoucherCreation(String parameterName, String initValue){
		FormField field =  makeDateFromOriginalVoucherCreation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm makeDateFieldOfOriginalVoucherCreation(String initValue){
		return makeDateFieldOfOriginalVoucherCreation("makeDate",initValue);
	}
	public OriginalVoucherForm makeDateFieldOfOriginalVoucherCreation(){
		return makeDateFieldOfOriginalVoucherCreation("makeDate","");
	}


	public OriginalVoucherForm originalVoucherConfirmationIdFieldOfOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucherConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm originalVoucherConfirmationIdFieldOfOriginalVoucherConfirmation(String initValue){
		return originalVoucherConfirmationIdFieldOfOriginalVoucherConfirmation("originalVoucherConfirmationId",initValue);
	}
	public OriginalVoucherForm originalVoucherConfirmationIdFieldOfOriginalVoucherConfirmation(){
		return originalVoucherConfirmationIdFieldOfOriginalVoucherConfirmation("originalVoucherConfirmationId","");
	}


	public OriginalVoucherForm whoFieldOfOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field =  whoFromOriginalVoucherConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm whoFieldOfOriginalVoucherConfirmation(String initValue){
		return whoFieldOfOriginalVoucherConfirmation("who",initValue);
	}
	public OriginalVoucherForm whoFieldOfOriginalVoucherConfirmation(){
		return whoFieldOfOriginalVoucherConfirmation("who","");
	}


	public OriginalVoucherForm commentsFieldOfOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field =  commentsFromOriginalVoucherConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm commentsFieldOfOriginalVoucherConfirmation(String initValue){
		return commentsFieldOfOriginalVoucherConfirmation("comments",initValue);
	}
	public OriginalVoucherForm commentsFieldOfOriginalVoucherConfirmation(){
		return commentsFieldOfOriginalVoucherConfirmation("comments","");
	}


	public OriginalVoucherForm makeDateFieldOfOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field =  makeDateFromOriginalVoucherConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm makeDateFieldOfOriginalVoucherConfirmation(String initValue){
		return makeDateFieldOfOriginalVoucherConfirmation("makeDate",initValue);
	}
	public OriginalVoucherForm makeDateFieldOfOriginalVoucherConfirmation(){
		return makeDateFieldOfOriginalVoucherConfirmation("makeDate","");
	}


	public OriginalVoucherForm originalVoucherAuditingIdFieldOfOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucherAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm originalVoucherAuditingIdFieldOfOriginalVoucherAuditing(String initValue){
		return originalVoucherAuditingIdFieldOfOriginalVoucherAuditing("originalVoucherAuditingId",initValue);
	}
	public OriginalVoucherForm originalVoucherAuditingIdFieldOfOriginalVoucherAuditing(){
		return originalVoucherAuditingIdFieldOfOriginalVoucherAuditing("originalVoucherAuditingId","");
	}


	public OriginalVoucherForm whoFieldOfOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field =  whoFromOriginalVoucherAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm whoFieldOfOriginalVoucherAuditing(String initValue){
		return whoFieldOfOriginalVoucherAuditing("who",initValue);
	}
	public OriginalVoucherForm whoFieldOfOriginalVoucherAuditing(){
		return whoFieldOfOriginalVoucherAuditing("who","");
	}


	public OriginalVoucherForm commentsFieldOfOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field =  commentsFromOriginalVoucherAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm commentsFieldOfOriginalVoucherAuditing(String initValue){
		return commentsFieldOfOriginalVoucherAuditing("comments",initValue);
	}
	public OriginalVoucherForm commentsFieldOfOriginalVoucherAuditing(){
		return commentsFieldOfOriginalVoucherAuditing("comments","");
	}


	public OriginalVoucherForm makeDateFieldOfOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field =  makeDateFromOriginalVoucherAuditing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OriginalVoucherForm makeDateFieldOfOriginalVoucherAuditing(String initValue){
		return makeDateFieldOfOriginalVoucherAuditing("makeDate",initValue);
	}
	public OriginalVoucherForm makeDateFieldOfOriginalVoucherAuditing(){
		return makeDateFieldOfOriginalVoucherAuditing("makeDate","");
	}

	


	

	
 	public OriginalVoucherForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/originalVoucherId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public OriginalVoucherForm  createAction(){
		FormAction action = new FormAction();
		action.setLabel("Create");
		action.setLocaleKey("original_voucher.create");
		action.setUrl("originalVoucherManager/create/originalVoucherId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}	
 	public OriginalVoucherForm  confirmAction(){
		FormAction action = new FormAction();
		action.setLabel("Confirm");
		action.setLocaleKey("original_voucher.confirm");
		action.setUrl("originalVoucherManager/confirm/originalVoucherId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}	
 	public OriginalVoucherForm  auditAction(){
		FormAction action = new FormAction();
		action.setLabel("Audit");
		action.setLocaleKey("original_voucher.audit");
		action.setUrl("originalVoucherManager/audit/originalVoucherId/who/comments/makeDate/");
		this.addFormAction(action);
		return this;
	}

	public OriginalVoucherForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



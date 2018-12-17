package com.doublechaintech.retailscm.originalvoucherauditing;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class OriginalVoucherAuditingForm extends BaseForm {
	
	
	public OriginalVoucherAuditingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OriginalVoucherAuditingForm originalVoucherAuditingIdField(String parameterName, String initValue){
		FormField field = idFromOriginalVoucherAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm originalVoucherAuditingIdField(String initValue){
		return originalVoucherAuditingIdField("originalVoucherAuditingId",initValue);
	}
	public OriginalVoucherAuditingForm originalVoucherAuditingIdField(){
		return originalVoucherAuditingIdField("originalVoucherAuditingId","");
	}


	public OriginalVoucherAuditingForm whoField(String parameterName, String initValue){
		FormField field = whoFromOriginalVoucherAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public OriginalVoucherAuditingForm whoField(){
		return whoField("who","");
	}


	public OriginalVoucherAuditingForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromOriginalVoucherAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public OriginalVoucherAuditingForm commentsField(){
		return commentsField("comments","");
	}


	public OriginalVoucherAuditingForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromOriginalVoucherAuditing(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public OriginalVoucherAuditingForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public OriginalVoucherAuditingForm originalVoucherIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm originalVoucherIdFieldForOriginalVoucher(String initValue){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId",initValue);
	}
	public OriginalVoucherAuditingForm originalVoucherIdFieldForOriginalVoucher(){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId","");
	}


	public OriginalVoucherAuditingForm titleFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  titleFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm titleFieldForOriginalVoucher(String initValue){
		return titleFieldForOriginalVoucher("title",initValue);
	}
	public OriginalVoucherAuditingForm titleFieldForOriginalVoucher(){
		return titleFieldForOriginalVoucher("title","");
	}


	public OriginalVoucherAuditingForm madeByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  madeByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm madeByFieldForOriginalVoucher(String initValue){
		return madeByFieldForOriginalVoucher("madeBy",initValue);
	}
	public OriginalVoucherAuditingForm madeByFieldForOriginalVoucher(){
		return madeByFieldForOriginalVoucher("madeBy","");
	}


	public OriginalVoucherAuditingForm receivedByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  receivedByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm receivedByFieldForOriginalVoucher(String initValue){
		return receivedByFieldForOriginalVoucher("receivedBy",initValue);
	}
	public OriginalVoucherAuditingForm receivedByFieldForOriginalVoucher(){
		return receivedByFieldForOriginalVoucher("receivedBy","");
	}


	public OriginalVoucherAuditingForm voucherTypeFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherTypeFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm voucherTypeFieldForOriginalVoucher(String initValue){
		return voucherTypeFieldForOriginalVoucher("voucherType",initValue);
	}
	public OriginalVoucherAuditingForm voucherTypeFieldForOriginalVoucher(){
		return voucherTypeFieldForOriginalVoucher("voucherType","");
	}


	public OriginalVoucherAuditingForm voucherImageFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherImageFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm voucherImageFieldForOriginalVoucher(String initValue){
		return voucherImageFieldForOriginalVoucher("voucherImage",initValue);
	}
	public OriginalVoucherAuditingForm voucherImageFieldForOriginalVoucher(){
		return voucherImageFieldForOriginalVoucher("voucherImage","");
	}


	public OriginalVoucherAuditingForm belongsToIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  belongsToIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm belongsToIdFieldForOriginalVoucher(String initValue){
		return belongsToIdFieldForOriginalVoucher("belongsToId",initValue);
	}
	public OriginalVoucherAuditingForm belongsToIdFieldForOriginalVoucher(){
		return belongsToIdFieldForOriginalVoucher("belongsToId","");
	}


	public OriginalVoucherAuditingForm creationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  creationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm creationIdFieldForOriginalVoucher(String initValue){
		return creationIdFieldForOriginalVoucher("creationId",initValue);
	}
	public OriginalVoucherAuditingForm creationIdFieldForOriginalVoucher(){
		return creationIdFieldForOriginalVoucher("creationId","");
	}


	public OriginalVoucherAuditingForm confirmationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  confirmationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm confirmationIdFieldForOriginalVoucher(String initValue){
		return confirmationIdFieldForOriginalVoucher("confirmationId",initValue);
	}
	public OriginalVoucherAuditingForm confirmationIdFieldForOriginalVoucher(){
		return confirmationIdFieldForOriginalVoucher("confirmationId","");
	}


	public OriginalVoucherAuditingForm auditingIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  auditingIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm auditingIdFieldForOriginalVoucher(String initValue){
		return auditingIdFieldForOriginalVoucher("auditingId",initValue);
	}
	public OriginalVoucherAuditingForm auditingIdFieldForOriginalVoucher(){
		return auditingIdFieldForOriginalVoucher("auditingId","");
	}


	public OriginalVoucherAuditingForm currentStatusFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  currentStatusFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherAuditingForm currentStatusFieldForOriginalVoucher(String initValue){
		return currentStatusFieldForOriginalVoucher("currentStatus",initValue);
	}
	public OriginalVoucherAuditingForm currentStatusFieldForOriginalVoucher(){
		return currentStatusFieldForOriginalVoucher("currentStatus","");
	}

	



	public OriginalVoucherAuditingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.originalvoucherconfirmation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class OriginalVoucherConfirmationForm extends BaseForm {
	
	
	public OriginalVoucherConfirmationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OriginalVoucherConfirmationForm originalVoucherConfirmationIdField(String parameterName, String initValue){
		FormField field = idFromOriginalVoucherConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm originalVoucherConfirmationIdField(String initValue){
		return originalVoucherConfirmationIdField("originalVoucherConfirmationId",initValue);
	}
	public OriginalVoucherConfirmationForm originalVoucherConfirmationIdField(){
		return originalVoucherConfirmationIdField("originalVoucherConfirmationId","");
	}


	public OriginalVoucherConfirmationForm whoField(String parameterName, String initValue){
		FormField field = whoFromOriginalVoucherConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public OriginalVoucherConfirmationForm whoField(){
		return whoField("who","");
	}


	public OriginalVoucherConfirmationForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromOriginalVoucherConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public OriginalVoucherConfirmationForm commentsField(){
		return commentsField("comments","");
	}


	public OriginalVoucherConfirmationForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromOriginalVoucherConfirmation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public OriginalVoucherConfirmationForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public OriginalVoucherConfirmationForm originalVoucherIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm originalVoucherIdFieldForOriginalVoucher(String initValue){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId",initValue);
	}
	public OriginalVoucherConfirmationForm originalVoucherIdFieldForOriginalVoucher(){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId","");
	}


	public OriginalVoucherConfirmationForm titleFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  titleFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm titleFieldForOriginalVoucher(String initValue){
		return titleFieldForOriginalVoucher("title",initValue);
	}
	public OriginalVoucherConfirmationForm titleFieldForOriginalVoucher(){
		return titleFieldForOriginalVoucher("title","");
	}


	public OriginalVoucherConfirmationForm madeByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  madeByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm madeByFieldForOriginalVoucher(String initValue){
		return madeByFieldForOriginalVoucher("madeBy",initValue);
	}
	public OriginalVoucherConfirmationForm madeByFieldForOriginalVoucher(){
		return madeByFieldForOriginalVoucher("madeBy","");
	}


	public OriginalVoucherConfirmationForm receivedByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  receivedByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm receivedByFieldForOriginalVoucher(String initValue){
		return receivedByFieldForOriginalVoucher("receivedBy",initValue);
	}
	public OriginalVoucherConfirmationForm receivedByFieldForOriginalVoucher(){
		return receivedByFieldForOriginalVoucher("receivedBy","");
	}


	public OriginalVoucherConfirmationForm voucherTypeFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherTypeFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm voucherTypeFieldForOriginalVoucher(String initValue){
		return voucherTypeFieldForOriginalVoucher("voucherType",initValue);
	}
	public OriginalVoucherConfirmationForm voucherTypeFieldForOriginalVoucher(){
		return voucherTypeFieldForOriginalVoucher("voucherType","");
	}


	public OriginalVoucherConfirmationForm voucherImageFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherImageFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm voucherImageFieldForOriginalVoucher(String initValue){
		return voucherImageFieldForOriginalVoucher("voucherImage",initValue);
	}
	public OriginalVoucherConfirmationForm voucherImageFieldForOriginalVoucher(){
		return voucherImageFieldForOriginalVoucher("voucherImage","");
	}


	public OriginalVoucherConfirmationForm belongsToIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  belongsToIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm belongsToIdFieldForOriginalVoucher(String initValue){
		return belongsToIdFieldForOriginalVoucher("belongsToId",initValue);
	}
	public OriginalVoucherConfirmationForm belongsToIdFieldForOriginalVoucher(){
		return belongsToIdFieldForOriginalVoucher("belongsToId","");
	}


	public OriginalVoucherConfirmationForm creationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  creationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm creationIdFieldForOriginalVoucher(String initValue){
		return creationIdFieldForOriginalVoucher("creationId",initValue);
	}
	public OriginalVoucherConfirmationForm creationIdFieldForOriginalVoucher(){
		return creationIdFieldForOriginalVoucher("creationId","");
	}


	public OriginalVoucherConfirmationForm confirmationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  confirmationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm confirmationIdFieldForOriginalVoucher(String initValue){
		return confirmationIdFieldForOriginalVoucher("confirmationId",initValue);
	}
	public OriginalVoucherConfirmationForm confirmationIdFieldForOriginalVoucher(){
		return confirmationIdFieldForOriginalVoucher("confirmationId","");
	}


	public OriginalVoucherConfirmationForm auditingIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  auditingIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm auditingIdFieldForOriginalVoucher(String initValue){
		return auditingIdFieldForOriginalVoucher("auditingId",initValue);
	}
	public OriginalVoucherConfirmationForm auditingIdFieldForOriginalVoucher(){
		return auditingIdFieldForOriginalVoucher("auditingId","");
	}


	public OriginalVoucherConfirmationForm currentStatusFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  currentStatusFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherConfirmationForm currentStatusFieldForOriginalVoucher(String initValue){
		return currentStatusFieldForOriginalVoucher("currentStatus",initValue);
	}
	public OriginalVoucherConfirmationForm currentStatusFieldForOriginalVoucher(){
		return currentStatusFieldForOriginalVoucher("currentStatus","");
	}

	



	public OriginalVoucherConfirmationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



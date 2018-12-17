package com.doublechaintech.retailscm.originalvouchercreation;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class OriginalVoucherCreationForm extends BaseForm {
	
	
	public OriginalVoucherCreationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OriginalVoucherCreationForm originalVoucherCreationIdField(String parameterName, String initValue){
		FormField field = idFromOriginalVoucherCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm originalVoucherCreationIdField(String initValue){
		return originalVoucherCreationIdField("originalVoucherCreationId",initValue);
	}
	public OriginalVoucherCreationForm originalVoucherCreationIdField(){
		return originalVoucherCreationIdField("originalVoucherCreationId","");
	}


	public OriginalVoucherCreationForm whoField(String parameterName, String initValue){
		FormField field = whoFromOriginalVoucherCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public OriginalVoucherCreationForm whoField(){
		return whoField("who","");
	}


	public OriginalVoucherCreationForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromOriginalVoucherCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public OriginalVoucherCreationForm commentsField(){
		return commentsField("comments","");
	}


	public OriginalVoucherCreationForm makeDateField(String parameterName, String initValue){
		FormField field = makeDateFromOriginalVoucherCreation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm makeDateField(String initValue){
		return makeDateField("makeDate",initValue);
	}
	public OriginalVoucherCreationForm makeDateField(){
		return makeDateField("makeDate","");
	}

	
	

	



	public OriginalVoucherCreationForm originalVoucherIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  idFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm originalVoucherIdFieldForOriginalVoucher(String initValue){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId",initValue);
	}
	public OriginalVoucherCreationForm originalVoucherIdFieldForOriginalVoucher(){
		return originalVoucherIdFieldForOriginalVoucher("originalVoucherId","");
	}


	public OriginalVoucherCreationForm titleFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  titleFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm titleFieldForOriginalVoucher(String initValue){
		return titleFieldForOriginalVoucher("title",initValue);
	}
	public OriginalVoucherCreationForm titleFieldForOriginalVoucher(){
		return titleFieldForOriginalVoucher("title","");
	}


	public OriginalVoucherCreationForm madeByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  madeByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm madeByFieldForOriginalVoucher(String initValue){
		return madeByFieldForOriginalVoucher("madeBy",initValue);
	}
	public OriginalVoucherCreationForm madeByFieldForOriginalVoucher(){
		return madeByFieldForOriginalVoucher("madeBy","");
	}


	public OriginalVoucherCreationForm receivedByFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  receivedByFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm receivedByFieldForOriginalVoucher(String initValue){
		return receivedByFieldForOriginalVoucher("receivedBy",initValue);
	}
	public OriginalVoucherCreationForm receivedByFieldForOriginalVoucher(){
		return receivedByFieldForOriginalVoucher("receivedBy","");
	}


	public OriginalVoucherCreationForm voucherTypeFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherTypeFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm voucherTypeFieldForOriginalVoucher(String initValue){
		return voucherTypeFieldForOriginalVoucher("voucherType",initValue);
	}
	public OriginalVoucherCreationForm voucherTypeFieldForOriginalVoucher(){
		return voucherTypeFieldForOriginalVoucher("voucherType","");
	}


	public OriginalVoucherCreationForm voucherImageFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  voucherImageFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm voucherImageFieldForOriginalVoucher(String initValue){
		return voucherImageFieldForOriginalVoucher("voucherImage",initValue);
	}
	public OriginalVoucherCreationForm voucherImageFieldForOriginalVoucher(){
		return voucherImageFieldForOriginalVoucher("voucherImage","");
	}


	public OriginalVoucherCreationForm belongsToIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  belongsToIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm belongsToIdFieldForOriginalVoucher(String initValue){
		return belongsToIdFieldForOriginalVoucher("belongsToId",initValue);
	}
	public OriginalVoucherCreationForm belongsToIdFieldForOriginalVoucher(){
		return belongsToIdFieldForOriginalVoucher("belongsToId","");
	}


	public OriginalVoucherCreationForm creationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  creationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm creationIdFieldForOriginalVoucher(String initValue){
		return creationIdFieldForOriginalVoucher("creationId",initValue);
	}
	public OriginalVoucherCreationForm creationIdFieldForOriginalVoucher(){
		return creationIdFieldForOriginalVoucher("creationId","");
	}


	public OriginalVoucherCreationForm confirmationIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  confirmationIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm confirmationIdFieldForOriginalVoucher(String initValue){
		return confirmationIdFieldForOriginalVoucher("confirmationId",initValue);
	}
	public OriginalVoucherCreationForm confirmationIdFieldForOriginalVoucher(){
		return confirmationIdFieldForOriginalVoucher("confirmationId","");
	}


	public OriginalVoucherCreationForm auditingIdFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  auditingIdFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm auditingIdFieldForOriginalVoucher(String initValue){
		return auditingIdFieldForOriginalVoucher("auditingId",initValue);
	}
	public OriginalVoucherCreationForm auditingIdFieldForOriginalVoucher(){
		return auditingIdFieldForOriginalVoucher("auditingId","");
	}


	public OriginalVoucherCreationForm currentStatusFieldForOriginalVoucher(String parameterName, String initValue){
		FormField field =  currentStatusFromOriginalVoucher(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OriginalVoucherCreationForm currentStatusFieldForOriginalVoucher(String initValue){
		return currentStatusFieldForOriginalVoucher("currentStatus",initValue);
	}
	public OriginalVoucherCreationForm currentStatusFieldForOriginalVoucher(){
		return currentStatusFieldForOriginalVoucher("currentStatus","");
	}

	



	public OriginalVoucherCreationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



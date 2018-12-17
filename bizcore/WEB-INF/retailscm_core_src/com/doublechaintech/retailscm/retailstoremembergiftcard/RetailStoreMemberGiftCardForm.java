package com.doublechaintech.retailscm.retailstoremembergiftcard;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreMemberGiftCardForm extends BaseForm {
	
	
	public RetailStoreMemberGiftCardForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreMemberGiftCardForm retailStoreMemberGiftCardIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm retailStoreMemberGiftCardIdField(String initValue){
		return retailStoreMemberGiftCardIdField("retailStoreMemberGiftCardId",initValue);
	}
	public RetailStoreMemberGiftCardForm retailStoreMemberGiftCardIdField(){
		return retailStoreMemberGiftCardIdField("retailStoreMemberGiftCardId","");
	}


	public RetailStoreMemberGiftCardForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreMemberGiftCardForm nameField(){
		return nameField("name","");
	}


	public RetailStoreMemberGiftCardForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public RetailStoreMemberGiftCardForm ownerIdField(){
		return ownerIdField("ownerId","");
	}


	public RetailStoreMemberGiftCardForm numberField(String parameterName, String initValue){
		FormField field = numberFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm numberField(String initValue){
		return numberField("number",initValue);
	}
	public RetailStoreMemberGiftCardForm numberField(){
		return numberField("number","");
	}


	public RetailStoreMemberGiftCardForm remainField(String parameterName, String initValue){
		FormField field = remainFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm remainField(String initValue){
		return remainField("remain",initValue);
	}
	public RetailStoreMemberGiftCardForm remainField(){
		return remainField("remain","");
	}

	
	


	public RetailStoreMemberGiftCardForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public RetailStoreMemberGiftCardForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public RetailStoreMemberGiftCardForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public RetailStoreMemberGiftCardForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public RetailStoreMemberGiftCardForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public RetailStoreMemberGiftCardForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public RetailStoreMemberGiftCardForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberGiftCardForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public RetailStoreMemberGiftCardForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}

	



	public RetailStoreMemberGiftCardForm retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord("retailStoreMemberGiftCardConsumeRecordId",initValue);
	}
	public RetailStoreMemberGiftCardForm retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return retailStoreMemberGiftCardConsumeRecordIdFieldForRetailStoreMemberGiftCardConsumeRecord("retailStoreMemberGiftCardConsumeRecordId","");
	}


	public RetailStoreMemberGiftCardForm occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  occureTimeFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord("occureTime",initValue);
	}
	public RetailStoreMemberGiftCardForm occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return occureTimeFieldForRetailStoreMemberGiftCardConsumeRecord("occureTime","");
	}


	public RetailStoreMemberGiftCardForm ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord("ownerId",initValue);
	}
	public RetailStoreMemberGiftCardForm ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return ownerIdFieldForRetailStoreMemberGiftCardConsumeRecord("ownerId","");
	}


	public RetailStoreMemberGiftCardForm bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  bizOrderIdFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord("bizOrderId",initValue);
	}
	public RetailStoreMemberGiftCardForm bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return bizOrderIdFieldForRetailStoreMemberGiftCardConsumeRecord("bizOrderId","");
	}


	public RetailStoreMemberGiftCardForm numberFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  numberFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm numberFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return numberFieldForRetailStoreMemberGiftCardConsumeRecord("number",initValue);
	}
	public RetailStoreMemberGiftCardForm numberFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return numberFieldForRetailStoreMemberGiftCardConsumeRecord("number","");
	}


	public RetailStoreMemberGiftCardForm amountFieldForRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field =  amountFromRetailStoreMemberGiftCardConsumeRecord(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberGiftCardForm amountFieldForRetailStoreMemberGiftCardConsumeRecord(String initValue){
		return amountFieldForRetailStoreMemberGiftCardConsumeRecord("amount",initValue);
	}
	public RetailStoreMemberGiftCardForm amountFieldForRetailStoreMemberGiftCardConsumeRecord(){
		return amountFieldForRetailStoreMemberGiftCardConsumeRecord("amount","");
	}

	

	
 	public RetailStoreMemberGiftCardForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/retailStoreMemberGiftCardId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreMemberGiftCardForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



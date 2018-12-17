package com.doublechaintech.retailscm.memberwishlist;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class MemberWishlistForm extends BaseForm {
	
	
	public MemberWishlistForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MemberWishlistForm memberWishlistIdField(String parameterName, String initValue){
		FormField field = idFromMemberWishlist(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistForm memberWishlistIdField(String initValue){
		return memberWishlistIdField("memberWishlistId",initValue);
	}
	public MemberWishlistForm memberWishlistIdField(){
		return memberWishlistIdField("memberWishlistId","");
	}


	public MemberWishlistForm nameField(String parameterName, String initValue){
		FormField field = nameFromMemberWishlist(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MemberWishlistForm nameField(){
		return nameField("name","");
	}


	public MemberWishlistForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromMemberWishlist(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public MemberWishlistForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public MemberWishlistForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public MemberWishlistForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public MemberWishlistForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public MemberWishlistForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public MemberWishlistForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public MemberWishlistForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public MemberWishlistForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public MemberWishlistForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}

	



	public MemberWishlistForm memberWishlistProductIdFieldForMemberWishlistProduct(String parameterName, String initValue){
		FormField field =  idFromMemberWishlistProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistForm memberWishlistProductIdFieldForMemberWishlistProduct(String initValue){
		return memberWishlistProductIdFieldForMemberWishlistProduct("memberWishlistProductId",initValue);
	}
	public MemberWishlistForm memberWishlistProductIdFieldForMemberWishlistProduct(){
		return memberWishlistProductIdFieldForMemberWishlistProduct("memberWishlistProductId","");
	}


	public MemberWishlistForm nameFieldForMemberWishlistProduct(String parameterName, String initValue){
		FormField field =  nameFromMemberWishlistProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistForm nameFieldForMemberWishlistProduct(String initValue){
		return nameFieldForMemberWishlistProduct("name",initValue);
	}
	public MemberWishlistForm nameFieldForMemberWishlistProduct(){
		return nameFieldForMemberWishlistProduct("name","");
	}


	public MemberWishlistForm ownerIdFieldForMemberWishlistProduct(String parameterName, String initValue){
		FormField field =  ownerIdFromMemberWishlistProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistForm ownerIdFieldForMemberWishlistProduct(String initValue){
		return ownerIdFieldForMemberWishlistProduct("ownerId",initValue);
	}
	public MemberWishlistForm ownerIdFieldForMemberWishlistProduct(){
		return ownerIdFieldForMemberWishlistProduct("ownerId","");
	}

	

	
 	public MemberWishlistForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/memberWishlistId/");
		this.addFormAction(action);
		return this;
	}

 

	public MemberWishlistForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



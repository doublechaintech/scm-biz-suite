package com.doublechaintech.retailscm.memberwishlistproduct;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class MemberWishlistProductForm extends BaseForm {
	
	
	public MemberWishlistProductForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MemberWishlistProductForm memberWishlistProductIdField(String parameterName, String initValue){
		FormField field = idFromMemberWishlistProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistProductForm memberWishlistProductIdField(String initValue){
		return memberWishlistProductIdField("memberWishlistProductId",initValue);
	}
	public MemberWishlistProductForm memberWishlistProductIdField(){
		return memberWishlistProductIdField("memberWishlistProductId","");
	}


	public MemberWishlistProductForm nameField(String parameterName, String initValue){
		FormField field = nameFromMemberWishlistProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistProductForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MemberWishlistProductForm nameField(){
		return nameField("name","");
	}


	public MemberWishlistProductForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromMemberWishlistProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberWishlistProductForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public MemberWishlistProductForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public MemberWishlistProductForm memberWishlistIdFieldOfMemberWishlist(String parameterName, String initValue){
		FormField field =  idFromMemberWishlist(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistProductForm memberWishlistIdFieldOfMemberWishlist(String initValue){
		return memberWishlistIdFieldOfMemberWishlist("memberWishlistId",initValue);
	}
	public MemberWishlistProductForm memberWishlistIdFieldOfMemberWishlist(){
		return memberWishlistIdFieldOfMemberWishlist("memberWishlistId","");
	}


	public MemberWishlistProductForm nameFieldOfMemberWishlist(String parameterName, String initValue){
		FormField field =  nameFromMemberWishlist(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistProductForm nameFieldOfMemberWishlist(String initValue){
		return nameFieldOfMemberWishlist("name",initValue);
	}
	public MemberWishlistProductForm nameFieldOfMemberWishlist(){
		return nameFieldOfMemberWishlist("name","");
	}


	public MemberWishlistProductForm ownerIdFieldOfMemberWishlist(String parameterName, String initValue){
		FormField field =  ownerIdFromMemberWishlist(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberWishlistProductForm ownerIdFieldOfMemberWishlist(String initValue){
		return ownerIdFieldOfMemberWishlist("ownerId",initValue);
	}
	public MemberWishlistProductForm ownerIdFieldOfMemberWishlist(){
		return ownerIdFieldOfMemberWishlist("ownerId","");
	}

	


	

	
 	public MemberWishlistProductForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/memberWishlistProductId/");
		this.addFormAction(action);
		return this;
	}

 

	public MemberWishlistProductForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



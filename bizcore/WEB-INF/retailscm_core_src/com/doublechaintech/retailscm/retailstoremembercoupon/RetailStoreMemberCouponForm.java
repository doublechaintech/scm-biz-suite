package com.doublechaintech.retailscm.retailstoremembercoupon;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreMemberCouponForm extends BaseForm {
	
	
	public RetailStoreMemberCouponForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreMemberCouponForm retailStoreMemberCouponIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberCouponForm retailStoreMemberCouponIdField(String initValue){
		return retailStoreMemberCouponIdField("retailStoreMemberCouponId",initValue);
	}
	public RetailStoreMemberCouponForm retailStoreMemberCouponIdField(){
		return retailStoreMemberCouponIdField("retailStoreMemberCouponId","");
	}


	public RetailStoreMemberCouponForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberCouponForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreMemberCouponForm nameField(){
		return nameField("name","");
	}


	public RetailStoreMemberCouponForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberCouponForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public RetailStoreMemberCouponForm ownerIdField(){
		return ownerIdField("ownerId","");
	}


	public RetailStoreMemberCouponForm numberField(String parameterName, String initValue){
		FormField field = numberFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberCouponForm numberField(String initValue){
		return numberField("number",initValue);
	}
	public RetailStoreMemberCouponForm numberField(){
		return numberField("number","");
	}


	public RetailStoreMemberCouponForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberCouponForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public RetailStoreMemberCouponForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public RetailStoreMemberCouponForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberCouponForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public RetailStoreMemberCouponForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public RetailStoreMemberCouponForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberCouponForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public RetailStoreMemberCouponForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public RetailStoreMemberCouponForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberCouponForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public RetailStoreMemberCouponForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public RetailStoreMemberCouponForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberCouponForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public RetailStoreMemberCouponForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}

	


	

	
 	public RetailStoreMemberCouponForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/retailStoreMemberCouponId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreMemberCouponForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



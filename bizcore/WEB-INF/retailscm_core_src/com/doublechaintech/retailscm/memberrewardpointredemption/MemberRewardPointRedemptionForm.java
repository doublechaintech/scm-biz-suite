package com.doublechaintech.retailscm.memberrewardpointredemption;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class MemberRewardPointRedemptionForm extends BaseForm {
	
	
	public MemberRewardPointRedemptionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MemberRewardPointRedemptionForm memberRewardPointRedemptionIdField(String parameterName, String initValue){
		FormField field = idFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointRedemptionForm memberRewardPointRedemptionIdField(String initValue){
		return memberRewardPointRedemptionIdField("memberRewardPointRedemptionId",initValue);
	}
	public MemberRewardPointRedemptionForm memberRewardPointRedemptionIdField(){
		return memberRewardPointRedemptionIdField("memberRewardPointRedemptionId","");
	}


	public MemberRewardPointRedemptionForm nameField(String parameterName, String initValue){
		FormField field = nameFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointRedemptionForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MemberRewardPointRedemptionForm nameField(){
		return nameField("name","");
	}


	public MemberRewardPointRedemptionForm pointField(String parameterName, String initValue){
		FormField field = pointFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointRedemptionForm pointField(String initValue){
		return pointField("point",initValue);
	}
	public MemberRewardPointRedemptionForm pointField(){
		return pointField("point","");
	}


	public MemberRewardPointRedemptionForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointRedemptionForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public MemberRewardPointRedemptionForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public MemberRewardPointRedemptionForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointRedemptionForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public MemberRewardPointRedemptionForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public MemberRewardPointRedemptionForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointRedemptionForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public MemberRewardPointRedemptionForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public MemberRewardPointRedemptionForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointRedemptionForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public MemberRewardPointRedemptionForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public MemberRewardPointRedemptionForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointRedemptionForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public MemberRewardPointRedemptionForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}

	


	

	
 	public MemberRewardPointRedemptionForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/memberRewardPointRedemptionId/");
		this.addFormAction(action);
		return this;
	}

 

	public MemberRewardPointRedemptionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



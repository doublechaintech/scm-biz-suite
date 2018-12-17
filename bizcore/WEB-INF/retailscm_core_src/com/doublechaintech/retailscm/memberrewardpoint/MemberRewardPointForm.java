package com.doublechaintech.retailscm.memberrewardpoint;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class MemberRewardPointForm extends BaseForm {
	
	
	public MemberRewardPointForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public MemberRewardPointForm memberRewardPointIdField(String parameterName, String initValue){
		FormField field = idFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointForm memberRewardPointIdField(String initValue){
		return memberRewardPointIdField("memberRewardPointId",initValue);
	}
	public MemberRewardPointForm memberRewardPointIdField(){
		return memberRewardPointIdField("memberRewardPointId","");
	}


	public MemberRewardPointForm nameField(String parameterName, String initValue){
		FormField field = nameFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public MemberRewardPointForm nameField(){
		return nameField("name","");
	}


	public MemberRewardPointForm pointField(String parameterName, String initValue){
		FormField field = pointFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointForm pointField(String initValue){
		return pointField("point",initValue);
	}
	public MemberRewardPointForm pointField(){
		return pointField("point","");
	}


	public MemberRewardPointForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public MemberRewardPointForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public MemberRewardPointForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public MemberRewardPointForm retailStoreMemberIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointForm retailStoreMemberIdFieldOfRetailStoreMember(String initValue){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId",initValue);
	}
	public MemberRewardPointForm retailStoreMemberIdFieldOfRetailStoreMember(){
		return retailStoreMemberIdFieldOfRetailStoreMember("retailStoreMemberId","");
	}


	public MemberRewardPointForm nameFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointForm nameFieldOfRetailStoreMember(String initValue){
		return nameFieldOfRetailStoreMember("name",initValue);
	}
	public MemberRewardPointForm nameFieldOfRetailStoreMember(){
		return nameFieldOfRetailStoreMember("name","");
	}


	public MemberRewardPointForm mobilePhoneFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointForm mobilePhoneFieldOfRetailStoreMember(String initValue){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone",initValue);
	}
	public MemberRewardPointForm mobilePhoneFieldOfRetailStoreMember(){
		return mobilePhoneFieldOfRetailStoreMember("mobilePhone","");
	}


	public MemberRewardPointForm ownerIdFieldOfRetailStoreMember(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMember(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public MemberRewardPointForm ownerIdFieldOfRetailStoreMember(String initValue){
		return ownerIdFieldOfRetailStoreMember("ownerId",initValue);
	}
	public MemberRewardPointForm ownerIdFieldOfRetailStoreMember(){
		return ownerIdFieldOfRetailStoreMember("ownerId","");
	}

	


	

	
 	public MemberRewardPointForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/memberRewardPointId/");
		this.addFormAction(action);
		return this;
	}

 

	public MemberRewardPointForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



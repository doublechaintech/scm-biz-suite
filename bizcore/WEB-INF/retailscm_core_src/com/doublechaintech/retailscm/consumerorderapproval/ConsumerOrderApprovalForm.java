package com.doublechaintech.retailscm.consumerorderapproval;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ConsumerOrderApprovalForm extends BaseForm {
	
	
	public ConsumerOrderApprovalForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ConsumerOrderApprovalForm consumerOrderApprovalIdField(String parameterName, String initValue){
		FormField field = idFromConsumerOrderApproval(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderApprovalForm consumerOrderApprovalIdField(String initValue){
		return consumerOrderApprovalIdField("consumerOrderApprovalId",initValue);
	}
	public ConsumerOrderApprovalForm consumerOrderApprovalIdField(){
		return consumerOrderApprovalIdField("consumerOrderApprovalId","");
	}


	public ConsumerOrderApprovalForm whoField(String parameterName, String initValue){
		FormField field = whoFromConsumerOrderApproval(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderApprovalForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ConsumerOrderApprovalForm whoField(){
		return whoField("who","");
	}


	public ConsumerOrderApprovalForm approveTimeField(String parameterName, String initValue){
		FormField field = approveTimeFromConsumerOrderApproval(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ConsumerOrderApprovalForm approveTimeField(String initValue){
		return approveTimeField("approveTime",initValue);
	}
	public ConsumerOrderApprovalForm approveTimeField(){
		return approveTimeField("approveTime","");
	}

	
	

	


	



	public ConsumerOrderApprovalForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



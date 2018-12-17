package com.doublechaintech.retailscm.view;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ViewForm extends BaseForm {
	
	
	public ViewForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ViewForm viewIdField(String parameterName, String initValue){
		FormField field = idFromView(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewForm viewIdField(String initValue){
		return viewIdField("viewId",initValue);
	}
	public ViewForm viewIdField(){
		return viewIdField("viewId","");
	}


	public ViewForm whoField(String parameterName, String initValue){
		FormField field = whoFromView(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ViewForm whoField(){
		return whoField("who","");
	}


	public ViewForm assessmentField(String parameterName, String initValue){
		FormField field = assessmentFromView(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewForm assessmentField(String initValue){
		return assessmentField("assessment",initValue);
	}
	public ViewForm assessmentField(){
		return assessmentField("assessment","");
	}


	public ViewForm interviewTimeField(String parameterName, String initValue){
		FormField field = interviewTimeFromView(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ViewForm interviewTimeField(String initValue){
		return interviewTimeField("interviewTime",initValue);
	}
	public ViewForm interviewTimeField(){
		return interviewTimeField("interviewTime","");
	}

	
	

	


	



	public ViewForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



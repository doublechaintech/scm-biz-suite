package com.doublechaintech.retailscm.scoring;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ScoringForm extends BaseForm {
	
	
	public ScoringForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ScoringForm scoringIdField(String parameterName, String initValue){
		FormField field = idFromScoring(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm scoringIdField(String initValue){
		return scoringIdField("scoringId",initValue);
	}
	public ScoringForm scoringIdField(){
		return scoringIdField("scoringId","");
	}


	public ScoringForm scoredByField(String parameterName, String initValue){
		FormField field = scoredByFromScoring(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm scoredByField(String initValue){
		return scoredByField("scoredBy",initValue);
	}
	public ScoringForm scoredByField(){
		return scoredByField("scoredBy","");
	}


	public ScoringForm scoreField(String parameterName, String initValue){
		FormField field = scoreFromScoring(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm scoreField(String initValue){
		return scoreField("score",initValue);
	}
	public ScoringForm scoreField(){
		return scoreField("score","");
	}


	public ScoringForm commentField(String parameterName, String initValue){
		FormField field = commentFromScoring(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm commentField(String initValue){
		return commentField("comment",initValue);
	}
	public ScoringForm commentField(){
		return commentField("comment","");
	}

	
	

	



	public ScoringForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(String initValue){
		return employeeCompanyTrainingIdFieldForEmployeeCompanyTraining("employeeCompanyTrainingId",initValue);
	}
	public ScoringForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(){
		return employeeCompanyTrainingIdFieldForEmployeeCompanyTraining("employeeCompanyTrainingId","");
	}


	public ScoringForm employeeIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm employeeIdFieldForEmployeeCompanyTraining(String initValue){
		return employeeIdFieldForEmployeeCompanyTraining("employeeId",initValue);
	}
	public ScoringForm employeeIdFieldForEmployeeCompanyTraining(){
		return employeeIdFieldForEmployeeCompanyTraining("employeeId","");
	}


	public ScoringForm trainingIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm trainingIdFieldForEmployeeCompanyTraining(String initValue){
		return trainingIdFieldForEmployeeCompanyTraining("trainingId",initValue);
	}
	public ScoringForm trainingIdFieldForEmployeeCompanyTraining(){
		return trainingIdFieldForEmployeeCompanyTraining("trainingId","");
	}


	public ScoringForm scoringIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  scoringIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm scoringIdFieldForEmployeeCompanyTraining(String initValue){
		return scoringIdFieldForEmployeeCompanyTraining("scoringId",initValue);
	}
	public ScoringForm scoringIdFieldForEmployeeCompanyTraining(){
		return scoringIdFieldForEmployeeCompanyTraining("scoringId","");
	}


	public ScoringForm currentStatusFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ScoringForm currentStatusFieldForEmployeeCompanyTraining(String initValue){
		return currentStatusFieldForEmployeeCompanyTraining("currentStatus",initValue);
	}
	public ScoringForm currentStatusFieldForEmployeeCompanyTraining(){
		return currentStatusFieldForEmployeeCompanyTraining("currentStatus","");
	}

	



	public ScoringForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.termination;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TerminationForm extends BaseForm {
	
	
	public TerminationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TerminationForm terminationIdField(String parameterName, String initValue){
		FormField field = idFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm terminationIdField(String initValue){
		return terminationIdField("terminationId",initValue);
	}
	public TerminationForm terminationIdField(){
		return terminationIdField("terminationId","");
	}


	public TerminationForm reasonIdField(String parameterName, String initValue){
		FormField field = reasonIdFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm reasonIdField(String initValue){
		return reasonIdField("reasonId",initValue);
	}
	public TerminationForm reasonIdField(){
		return reasonIdField("reasonId","");
	}


	public TerminationForm typeIdField(String parameterName, String initValue){
		FormField field = typeIdFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm typeIdField(String initValue){
		return typeIdField("typeId",initValue);
	}
	public TerminationForm typeIdField(){
		return typeIdField("typeId","");
	}


	public TerminationForm commentField(String parameterName, String initValue){
		FormField field = commentFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm commentField(String initValue){
		return commentField("comment",initValue);
	}
	public TerminationForm commentField(){
		return commentField("comment","");
	}

	
	


	public TerminationForm terminationReasonIdFieldOfTerminationReason(String parameterName, String initValue){
		FormField field =  idFromTerminationReason(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm terminationReasonIdFieldOfTerminationReason(String initValue){
		return terminationReasonIdFieldOfTerminationReason("terminationReasonId",initValue);
	}
	public TerminationForm terminationReasonIdFieldOfTerminationReason(){
		return terminationReasonIdFieldOfTerminationReason("terminationReasonId","");
	}


	public TerminationForm codeFieldOfTerminationReason(String parameterName, String initValue){
		FormField field =  codeFromTerminationReason(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm codeFieldOfTerminationReason(String initValue){
		return codeFieldOfTerminationReason("code",initValue);
	}
	public TerminationForm codeFieldOfTerminationReason(){
		return codeFieldOfTerminationReason("code","");
	}


	public TerminationForm companyIdFieldOfTerminationReason(String parameterName, String initValue){
		FormField field =  companyIdFromTerminationReason(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm companyIdFieldOfTerminationReason(String initValue){
		return companyIdFieldOfTerminationReason("companyId",initValue);
	}
	public TerminationForm companyIdFieldOfTerminationReason(){
		return companyIdFieldOfTerminationReason("companyId","");
	}


	public TerminationForm descriptionFieldOfTerminationReason(String parameterName, String initValue){
		FormField field =  descriptionFromTerminationReason(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm descriptionFieldOfTerminationReason(String initValue){
		return descriptionFieldOfTerminationReason("description",initValue);
	}
	public TerminationForm descriptionFieldOfTerminationReason(){
		return descriptionFieldOfTerminationReason("description","");
	}


	public TerminationForm terminationTypeIdFieldOfTerminationType(String parameterName, String initValue){
		FormField field =  idFromTerminationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm terminationTypeIdFieldOfTerminationType(String initValue){
		return terminationTypeIdFieldOfTerminationType("terminationTypeId",initValue);
	}
	public TerminationForm terminationTypeIdFieldOfTerminationType(){
		return terminationTypeIdFieldOfTerminationType("terminationTypeId","");
	}


	public TerminationForm codeFieldOfTerminationType(String parameterName, String initValue){
		FormField field =  codeFromTerminationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm codeFieldOfTerminationType(String initValue){
		return codeFieldOfTerminationType("code",initValue);
	}
	public TerminationForm codeFieldOfTerminationType(){
		return codeFieldOfTerminationType("code","");
	}


	public TerminationForm companyIdFieldOfTerminationType(String parameterName, String initValue){
		FormField field =  companyIdFromTerminationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm companyIdFieldOfTerminationType(String initValue){
		return companyIdFieldOfTerminationType("companyId",initValue);
	}
	public TerminationForm companyIdFieldOfTerminationType(){
		return companyIdFieldOfTerminationType("companyId","");
	}


	public TerminationForm baseDescriptionFieldOfTerminationType(String parameterName, String initValue){
		FormField field =  baseDescriptionFromTerminationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm baseDescriptionFieldOfTerminationType(String initValue){
		return baseDescriptionFieldOfTerminationType("baseDescription",initValue);
	}
	public TerminationForm baseDescriptionFieldOfTerminationType(){
		return baseDescriptionFieldOfTerminationType("baseDescription","");
	}


	public TerminationForm detailDescriptionFieldOfTerminationType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromTerminationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationForm detailDescriptionFieldOfTerminationType(String initValue){
		return detailDescriptionFieldOfTerminationType("detailDescription",initValue);
	}
	public TerminationForm detailDescriptionFieldOfTerminationType(){
		return detailDescriptionFieldOfTerminationType("detailDescription","");
	}

	



	public TerminationForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public TerminationForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public TerminationForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public TerminationForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public TerminationForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public TerminationForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public TerminationForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public TerminationForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public TerminationForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public TerminationForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public TerminationForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public TerminationForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public TerminationForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public TerminationForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public TerminationForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public TerminationForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public TerminationForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public TerminationForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public TerminationForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public TerminationForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public TerminationForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public TerminationForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public TerminationForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public TerminationForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public TerminationForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public TerminationForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public TerminationForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public TerminationForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public TerminationForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public TerminationForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public TerminationForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public TerminationForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public TerminationForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public TerminationForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public TerminationForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public TerminationForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public TerminationForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public TerminationForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public TerminationForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public TerminationForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public TerminationForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public TerminationForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public TerminationForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public TerminationForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public TerminationForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public TerminationForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	

	
 	public TerminationForm transferToAnotherReasonAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherReason/terminationId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public TerminationForm transferToAnotherTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherType/terminationId/");
		this.addFormAction(action);
		return this;
	}

 

	public TerminationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



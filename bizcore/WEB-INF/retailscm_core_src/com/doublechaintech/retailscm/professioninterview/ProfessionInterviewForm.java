package com.doublechaintech.retailscm.professioninterview;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ProfessionInterviewForm extends BaseForm {
	
	
	public ProfessionInterviewForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProfessionInterviewForm professionInterviewIdField(String parameterName, String initValue){
		FormField field = idFromProfessionInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm professionInterviewIdField(String initValue){
		return professionInterviewIdField("professionInterviewId",initValue);
	}
	public ProfessionInterviewForm professionInterviewIdField(){
		return professionInterviewIdField("professionInterviewId","");
	}


	public ProfessionInterviewForm whoField(String parameterName, String initValue){
		FormField field = whoFromProfessionInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public ProfessionInterviewForm whoField(){
		return whoField("who","");
	}


	public ProfessionInterviewForm interviewTimeField(String parameterName, String initValue){
		FormField field = interviewTimeFromProfessionInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm interviewTimeField(String initValue){
		return interviewTimeField("interviewTime",initValue);
	}
	public ProfessionInterviewForm interviewTimeField(){
		return interviewTimeField("interviewTime","");
	}


	public ProfessionInterviewForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromProfessionInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public ProfessionInterviewForm commentsField(){
		return commentsField("comments","");
	}

	
	

	



	public ProfessionInterviewForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public ProfessionInterviewForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public ProfessionInterviewForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public ProfessionInterviewForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public ProfessionInterviewForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public ProfessionInterviewForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public ProfessionInterviewForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public ProfessionInterviewForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public ProfessionInterviewForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public ProfessionInterviewForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public ProfessionInterviewForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public ProfessionInterviewForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public ProfessionInterviewForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public ProfessionInterviewForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public ProfessionInterviewForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public ProfessionInterviewForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public ProfessionInterviewForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public ProfessionInterviewForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public ProfessionInterviewForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public ProfessionInterviewForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public ProfessionInterviewForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public ProfessionInterviewForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public ProfessionInterviewForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public ProfessionInterviewForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public ProfessionInterviewForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public ProfessionInterviewForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public ProfessionInterviewForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public ProfessionInterviewForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public ProfessionInterviewForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public ProfessionInterviewForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public ProfessionInterviewForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public ProfessionInterviewForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public ProfessionInterviewForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public ProfessionInterviewForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public ProfessionInterviewForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public ProfessionInterviewForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public ProfessionInterviewForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public ProfessionInterviewForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public ProfessionInterviewForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public ProfessionInterviewForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public ProfessionInterviewForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public ProfessionInterviewForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public ProfessionInterviewForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public ProfessionInterviewForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public ProfessionInterviewForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProfessionInterviewForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public ProfessionInterviewForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	



	public ProfessionInterviewForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.jobapplication;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class JobApplicationForm extends BaseForm {
	
	
	public JobApplicationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public JobApplicationForm jobApplicationIdField(String parameterName, String initValue){
		FormField field = idFromJobApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm jobApplicationIdField(String initValue){
		return jobApplicationIdField("jobApplicationId",initValue);
	}
	public JobApplicationForm jobApplicationIdField(){
		return jobApplicationIdField("jobApplicationId","");
	}


	public JobApplicationForm applicationTimeField(String parameterName, String initValue){
		FormField field = applicationTimeFromJobApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm applicationTimeField(String initValue){
		return applicationTimeField("applicationTime",initValue);
	}
	public JobApplicationForm applicationTimeField(){
		return applicationTimeField("applicationTime","");
	}


	public JobApplicationForm whoField(String parameterName, String initValue){
		FormField field = whoFromJobApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public JobApplicationForm whoField(){
		return whoField("who","");
	}


	public JobApplicationForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromJobApplication(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public JobApplicationForm commentsField(){
		return commentsField("comments","");
	}

	
	

	



	public JobApplicationForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public JobApplicationForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public JobApplicationForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public JobApplicationForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public JobApplicationForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public JobApplicationForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public JobApplicationForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public JobApplicationForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public JobApplicationForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public JobApplicationForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public JobApplicationForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public JobApplicationForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public JobApplicationForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public JobApplicationForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public JobApplicationForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public JobApplicationForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public JobApplicationForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public JobApplicationForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public JobApplicationForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public JobApplicationForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public JobApplicationForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public JobApplicationForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public JobApplicationForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public JobApplicationForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public JobApplicationForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public JobApplicationForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public JobApplicationForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public JobApplicationForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public JobApplicationForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public JobApplicationForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public JobApplicationForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public JobApplicationForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public JobApplicationForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public JobApplicationForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public JobApplicationForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public JobApplicationForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public JobApplicationForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public JobApplicationForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public JobApplicationForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public JobApplicationForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public JobApplicationForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public JobApplicationForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public JobApplicationForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public JobApplicationForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public JobApplicationForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public JobApplicationForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public JobApplicationForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	



	public JobApplicationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



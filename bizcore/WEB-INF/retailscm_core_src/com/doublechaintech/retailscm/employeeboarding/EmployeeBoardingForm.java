package com.doublechaintech.retailscm.employeeboarding;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeBoardingForm extends BaseForm {
	
	
	public EmployeeBoardingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeBoardingForm employeeBoardingIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeBoarding(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm employeeBoardingIdField(String initValue){
		return employeeBoardingIdField("employeeBoardingId",initValue);
	}
	public EmployeeBoardingForm employeeBoardingIdField(){
		return employeeBoardingIdField("employeeBoardingId","");
	}


	public EmployeeBoardingForm whoField(String parameterName, String initValue){
		FormField field = whoFromEmployeeBoarding(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public EmployeeBoardingForm whoField(){
		return whoField("who","");
	}


	public EmployeeBoardingForm employTimeField(String parameterName, String initValue){
		FormField field = employTimeFromEmployeeBoarding(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm employTimeField(String initValue){
		return employTimeField("employTime",initValue);
	}
	public EmployeeBoardingForm employTimeField(){
		return employTimeField("employTime","");
	}


	public EmployeeBoardingForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromEmployeeBoarding(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public EmployeeBoardingForm commentsField(){
		return commentsField("comments","");
	}

	
	

	



	public EmployeeBoardingForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public EmployeeBoardingForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public EmployeeBoardingForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public EmployeeBoardingForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public EmployeeBoardingForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public EmployeeBoardingForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public EmployeeBoardingForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public EmployeeBoardingForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public EmployeeBoardingForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public EmployeeBoardingForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public EmployeeBoardingForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public EmployeeBoardingForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public EmployeeBoardingForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public EmployeeBoardingForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public EmployeeBoardingForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public EmployeeBoardingForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public EmployeeBoardingForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public EmployeeBoardingForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public EmployeeBoardingForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public EmployeeBoardingForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public EmployeeBoardingForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public EmployeeBoardingForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public EmployeeBoardingForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public EmployeeBoardingForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public EmployeeBoardingForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeBoardingForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public EmployeeBoardingForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public EmployeeBoardingForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public EmployeeBoardingForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public EmployeeBoardingForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public EmployeeBoardingForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public EmployeeBoardingForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public EmployeeBoardingForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public EmployeeBoardingForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public EmployeeBoardingForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public EmployeeBoardingForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public EmployeeBoardingForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeBoardingForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public EmployeeBoardingForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public EmployeeBoardingForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public EmployeeBoardingForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public EmployeeBoardingForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public EmployeeBoardingForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public EmployeeBoardingForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public EmployeeBoardingForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeBoardingForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public EmployeeBoardingForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	



	public EmployeeBoardingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



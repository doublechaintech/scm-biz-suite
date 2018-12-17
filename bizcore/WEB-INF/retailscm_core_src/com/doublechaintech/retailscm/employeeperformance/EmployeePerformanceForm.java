package com.doublechaintech.retailscm.employeeperformance;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeePerformanceForm extends BaseForm {
	
	
	public EmployeePerformanceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeePerformanceForm employeePerformanceIdField(String parameterName, String initValue){
		FormField field = idFromEmployeePerformance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeePerformanceForm employeePerformanceIdField(String initValue){
		return employeePerformanceIdField("employeePerformanceId",initValue);
	}
	public EmployeePerformanceForm employeePerformanceIdField(){
		return employeePerformanceIdField("employeePerformanceId","");
	}


	public EmployeePerformanceForm employeeIdField(String parameterName, String initValue){
		FormField field = employeeIdFromEmployeePerformance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeePerformanceForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeePerformanceForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeePerformanceForm performanceCommentField(String parameterName, String initValue){
		FormField field = performanceCommentFromEmployeePerformance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeePerformanceForm performanceCommentField(String initValue){
		return performanceCommentField("performanceComment",initValue);
	}
	public EmployeePerformanceForm performanceCommentField(){
		return performanceCommentField("performanceComment","");
	}

	
	


	public EmployeePerformanceForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeePerformanceForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeePerformanceForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeePerformanceForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeePerformanceForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeePerformanceForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeePerformanceForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeePerformanceForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeePerformanceForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeePerformanceForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeePerformanceForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeePerformanceForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeePerformanceForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeePerformanceForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeePerformanceForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeePerformanceForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeePerformanceForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeePerformanceForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeePerformanceForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeePerformanceForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeePerformanceForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeePerformanceForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeePerformanceForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeePerformanceForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeePerformanceForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeePerformanceForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeePerformanceForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeePerformanceForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeePerformanceForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeePerformanceForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeePerformanceForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeePerformanceForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeePerformanceForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeePerformanceForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeePerformanceForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeePerformanceForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeePerformanceForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeePerformanceForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeePerformanceForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeePerformanceForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeePerformanceForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeePerformanceForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeePerformanceForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeePerformanceForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeePerformanceForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeePerformanceForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeePerformanceForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}

	


	

	
 	public EmployeePerformanceForm transferToAnotherEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEmployee/employeePerformanceId/");
		this.addFormAction(action);
		return this;
	}

 

	public EmployeePerformanceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



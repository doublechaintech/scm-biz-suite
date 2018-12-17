package com.doublechaintech.retailscm.hrinterview;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class HrInterviewForm extends BaseForm {
	
	
	public HrInterviewForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public HrInterviewForm hrInterviewIdField(String parameterName, String initValue){
		FormField field = idFromHrInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm hrInterviewIdField(String initValue){
		return hrInterviewIdField("hrInterviewId",initValue);
	}
	public HrInterviewForm hrInterviewIdField(){
		return hrInterviewIdField("hrInterviewId","");
	}


	public HrInterviewForm whoField(String parameterName, String initValue){
		FormField field = whoFromHrInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public HrInterviewForm whoField(){
		return whoField("who","");
	}


	public HrInterviewForm interviewTimeField(String parameterName, String initValue){
		FormField field = interviewTimeFromHrInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm interviewTimeField(String initValue){
		return interviewTimeField("interviewTime",initValue);
	}
	public HrInterviewForm interviewTimeField(){
		return interviewTimeField("interviewTime","");
	}


	public HrInterviewForm commentsField(String parameterName, String initValue){
		FormField field = commentsFromHrInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm commentsField(String initValue){
		return commentsField("comments",initValue);
	}
	public HrInterviewForm commentsField(){
		return commentsField("comments","");
	}

	
	

	



	public HrInterviewForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public HrInterviewForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public HrInterviewForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public HrInterviewForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public HrInterviewForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public HrInterviewForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public HrInterviewForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public HrInterviewForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public HrInterviewForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public HrInterviewForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public HrInterviewForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public HrInterviewForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public HrInterviewForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public HrInterviewForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public HrInterviewForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public HrInterviewForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public HrInterviewForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public HrInterviewForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public HrInterviewForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public HrInterviewForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public HrInterviewForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public HrInterviewForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public HrInterviewForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public HrInterviewForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public HrInterviewForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public HrInterviewForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public HrInterviewForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public HrInterviewForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public HrInterviewForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public HrInterviewForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public HrInterviewForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public HrInterviewForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public HrInterviewForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public HrInterviewForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public HrInterviewForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public HrInterviewForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public HrInterviewForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public HrInterviewForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public HrInterviewForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public HrInterviewForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public HrInterviewForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public HrInterviewForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public HrInterviewForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public HrInterviewForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public HrInterviewForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public HrInterviewForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public HrInterviewForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	



	public HrInterviewForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



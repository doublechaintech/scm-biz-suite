package com.doublechaintech.retailscm.employeeinterview;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeInterviewForm extends BaseForm {
	
	
	public EmployeeInterviewForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeInterviewForm employeeInterviewIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeInterviewForm employeeInterviewIdField(String initValue){
		return employeeInterviewIdField("employeeInterviewId",initValue);
	}
	public EmployeeInterviewForm employeeInterviewIdField(){
		return employeeInterviewIdField("employeeInterviewId","");
	}


	public EmployeeInterviewForm employeeIdField(String parameterName, String initValue){
		FormField field = employeeIdFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeInterviewForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeeInterviewForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeeInterviewForm interviewTypeIdField(String parameterName, String initValue){
		FormField field = interviewTypeIdFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeInterviewForm interviewTypeIdField(String initValue){
		return interviewTypeIdField("interviewTypeId",initValue);
	}
	public EmployeeInterviewForm interviewTypeIdField(){
		return interviewTypeIdField("interviewTypeId","");
	}


	public EmployeeInterviewForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeInterviewForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public EmployeeInterviewForm remarkField(){
		return remarkField("remark","");
	}

	
	


	public EmployeeInterviewForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeeInterviewForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeeInterviewForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeeInterviewForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeeInterviewForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeeInterviewForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeeInterviewForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeeInterviewForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeeInterviewForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeeInterviewForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeeInterviewForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeeInterviewForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeeInterviewForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeeInterviewForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeeInterviewForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeeInterviewForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeeInterviewForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeeInterviewForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeeInterviewForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeeInterviewForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeeInterviewForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeeInterviewForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeeInterviewForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeeInterviewForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeeInterviewForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeInterviewForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeeInterviewForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeeInterviewForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeeInterviewForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeeInterviewForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeeInterviewForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeeInterviewForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeeInterviewForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeeInterviewForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeeInterviewForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeeInterviewForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeeInterviewForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeInterviewForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeeInterviewForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeeInterviewForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeeInterviewForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeeInterviewForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeeInterviewForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeeInterviewForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeeInterviewForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeeInterviewForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}


	public EmployeeInterviewForm interviewTypeIdFieldOfInterviewType(String parameterName, String initValue){
		FormField field =  idFromInterviewType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm interviewTypeIdFieldOfInterviewType(String initValue){
		return interviewTypeIdFieldOfInterviewType("interviewTypeId",initValue);
	}
	public EmployeeInterviewForm interviewTypeIdFieldOfInterviewType(){
		return interviewTypeIdFieldOfInterviewType("interviewTypeId","");
	}


	public EmployeeInterviewForm codeFieldOfInterviewType(String parameterName, String initValue){
		FormField field =  codeFromInterviewType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm codeFieldOfInterviewType(String initValue){
		return codeFieldOfInterviewType("code",initValue);
	}
	public EmployeeInterviewForm codeFieldOfInterviewType(){
		return codeFieldOfInterviewType("code","");
	}


	public EmployeeInterviewForm companyIdFieldOfInterviewType(String parameterName, String initValue){
		FormField field =  companyIdFromInterviewType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm companyIdFieldOfInterviewType(String initValue){
		return companyIdFieldOfInterviewType("companyId",initValue);
	}
	public EmployeeInterviewForm companyIdFieldOfInterviewType(){
		return companyIdFieldOfInterviewType("companyId","");
	}


	public EmployeeInterviewForm descriptionFieldOfInterviewType(String parameterName, String initValue){
		FormField field =  descriptionFromInterviewType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm descriptionFieldOfInterviewType(String initValue){
		return descriptionFieldOfInterviewType("description",initValue);
	}
	public EmployeeInterviewForm descriptionFieldOfInterviewType(){
		return descriptionFieldOfInterviewType("description","");
	}


	public EmployeeInterviewForm detailDescriptionFieldOfInterviewType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromInterviewType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeInterviewForm detailDescriptionFieldOfInterviewType(String initValue){
		return detailDescriptionFieldOfInterviewType("detailDescription",initValue);
	}
	public EmployeeInterviewForm detailDescriptionFieldOfInterviewType(){
		return detailDescriptionFieldOfInterviewType("detailDescription","");
	}

	


	

	
 	public EmployeeInterviewForm transferToAnotherEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEmployee/employeeInterviewId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeInterviewForm transferToAnotherInterviewTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherInterviewType/employeeInterviewId/");
		this.addFormAction(action);
		return this;
	}

 

	public EmployeeInterviewForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



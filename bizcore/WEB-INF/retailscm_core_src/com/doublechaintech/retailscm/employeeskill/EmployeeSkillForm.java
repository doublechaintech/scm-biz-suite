package com.doublechaintech.retailscm.employeeskill;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeSkillForm extends BaseForm {
	
	
	public EmployeeSkillForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeSkillForm employeeSkillIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSkillForm employeeSkillIdField(String initValue){
		return employeeSkillIdField("employeeSkillId",initValue);
	}
	public EmployeeSkillForm employeeSkillIdField(){
		return employeeSkillIdField("employeeSkillId","");
	}


	public EmployeeSkillForm employeeIdField(String parameterName, String initValue){
		FormField field = employeeIdFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSkillForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeeSkillForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeeSkillForm skillTypeIdField(String parameterName, String initValue){
		FormField field = skillTypeIdFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSkillForm skillTypeIdField(String initValue){
		return skillTypeIdField("skillTypeId",initValue);
	}
	public EmployeeSkillForm skillTypeIdField(){
		return skillTypeIdField("skillTypeId","");
	}


	public EmployeeSkillForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSkillForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public EmployeeSkillForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public EmployeeSkillForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeeSkillForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeeSkillForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeeSkillForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeeSkillForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeeSkillForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeeSkillForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeeSkillForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeeSkillForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeeSkillForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeeSkillForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeeSkillForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeeSkillForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeeSkillForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeeSkillForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeeSkillForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeeSkillForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeeSkillForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeeSkillForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeeSkillForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeeSkillForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeeSkillForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeeSkillForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeeSkillForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeeSkillForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeSkillForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeeSkillForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeeSkillForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeeSkillForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeeSkillForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeeSkillForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeeSkillForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeeSkillForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeeSkillForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeeSkillForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeeSkillForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeeSkillForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeSkillForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeeSkillForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeeSkillForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeeSkillForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeeSkillForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeeSkillForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeeSkillForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeeSkillForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeeSkillForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}


	public EmployeeSkillForm skillTypeIdFieldOfSkillType(String parameterName, String initValue){
		FormField field =  idFromSkillType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm skillTypeIdFieldOfSkillType(String initValue){
		return skillTypeIdFieldOfSkillType("skillTypeId",initValue);
	}
	public EmployeeSkillForm skillTypeIdFieldOfSkillType(){
		return skillTypeIdFieldOfSkillType("skillTypeId","");
	}


	public EmployeeSkillForm codeFieldOfSkillType(String parameterName, String initValue){
		FormField field =  codeFromSkillType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm codeFieldOfSkillType(String initValue){
		return codeFieldOfSkillType("code",initValue);
	}
	public EmployeeSkillForm codeFieldOfSkillType(){
		return codeFieldOfSkillType("code","");
	}


	public EmployeeSkillForm companyIdFieldOfSkillType(String parameterName, String initValue){
		FormField field =  companyIdFromSkillType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm companyIdFieldOfSkillType(String initValue){
		return companyIdFieldOfSkillType("companyId",initValue);
	}
	public EmployeeSkillForm companyIdFieldOfSkillType(){
		return companyIdFieldOfSkillType("companyId","");
	}


	public EmployeeSkillForm descriptionFieldOfSkillType(String parameterName, String initValue){
		FormField field =  descriptionFromSkillType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSkillForm descriptionFieldOfSkillType(String initValue){
		return descriptionFieldOfSkillType("description",initValue);
	}
	public EmployeeSkillForm descriptionFieldOfSkillType(){
		return descriptionFieldOfSkillType("description","");
	}

	


	

	
 	public EmployeeSkillForm transferToAnotherEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEmployee/employeeSkillId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeSkillForm transferToAnotherSkillTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSkillType/employeeSkillId/");
		this.addFormAction(action);
		return this;
	}

 

	public EmployeeSkillForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



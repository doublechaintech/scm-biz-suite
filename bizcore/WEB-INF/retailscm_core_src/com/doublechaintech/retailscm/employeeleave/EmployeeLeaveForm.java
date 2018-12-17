package com.doublechaintech.retailscm.employeeleave;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeLeaveForm extends BaseForm {
	
	
	public EmployeeLeaveForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeLeaveForm employeeLeaveIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeLeaveForm employeeLeaveIdField(String initValue){
		return employeeLeaveIdField("employeeLeaveId",initValue);
	}
	public EmployeeLeaveForm employeeLeaveIdField(){
		return employeeLeaveIdField("employeeLeaveId","");
	}


	public EmployeeLeaveForm whoIdField(String parameterName, String initValue){
		FormField field = whoIdFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeLeaveForm whoIdField(String initValue){
		return whoIdField("whoId",initValue);
	}
	public EmployeeLeaveForm whoIdField(){
		return whoIdField("whoId","");
	}


	public EmployeeLeaveForm typeIdField(String parameterName, String initValue){
		FormField field = typeIdFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeLeaveForm typeIdField(String initValue){
		return typeIdField("typeId",initValue);
	}
	public EmployeeLeaveForm typeIdField(){
		return typeIdField("typeId","");
	}


	public EmployeeLeaveForm leaveDurationHourField(String parameterName, String initValue){
		FormField field = leaveDurationHourFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeLeaveForm leaveDurationHourField(String initValue){
		return leaveDurationHourField("leaveDurationHour",initValue);
	}
	public EmployeeLeaveForm leaveDurationHourField(){
		return leaveDurationHourField("leaveDurationHour","");
	}


	public EmployeeLeaveForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeLeaveForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public EmployeeLeaveForm remarkField(){
		return remarkField("remark","");
	}

	
	


	public EmployeeLeaveForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeeLeaveForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeeLeaveForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeeLeaveForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeeLeaveForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeeLeaveForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeeLeaveForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeeLeaveForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeeLeaveForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeeLeaveForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeeLeaveForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeeLeaveForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeeLeaveForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeeLeaveForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeeLeaveForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeeLeaveForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeeLeaveForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeeLeaveForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeeLeaveForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeeLeaveForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeeLeaveForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeeLeaveForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeeLeaveForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeeLeaveForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeeLeaveForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeLeaveForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeeLeaveForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeeLeaveForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeeLeaveForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeeLeaveForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeeLeaveForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeeLeaveForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeeLeaveForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeeLeaveForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeeLeaveForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeeLeaveForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeeLeaveForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeLeaveForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeeLeaveForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeeLeaveForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeeLeaveForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeeLeaveForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeeLeaveForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeeLeaveForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeeLeaveForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeeLeaveForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}


	public EmployeeLeaveForm leaveTypeIdFieldOfLeaveType(String parameterName, String initValue){
		FormField field =  idFromLeaveType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm leaveTypeIdFieldOfLeaveType(String initValue){
		return leaveTypeIdFieldOfLeaveType("leaveTypeId",initValue);
	}
	public EmployeeLeaveForm leaveTypeIdFieldOfLeaveType(){
		return leaveTypeIdFieldOfLeaveType("leaveTypeId","");
	}


	public EmployeeLeaveForm codeFieldOfLeaveType(String parameterName, String initValue){
		FormField field =  codeFromLeaveType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm codeFieldOfLeaveType(String initValue){
		return codeFieldOfLeaveType("code",initValue);
	}
	public EmployeeLeaveForm codeFieldOfLeaveType(){
		return codeFieldOfLeaveType("code","");
	}


	public EmployeeLeaveForm companyIdFieldOfLeaveType(String parameterName, String initValue){
		FormField field =  companyIdFromLeaveType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm companyIdFieldOfLeaveType(String initValue){
		return companyIdFieldOfLeaveType("companyId",initValue);
	}
	public EmployeeLeaveForm companyIdFieldOfLeaveType(){
		return companyIdFieldOfLeaveType("companyId","");
	}


	public EmployeeLeaveForm descriptionFieldOfLeaveType(String parameterName, String initValue){
		FormField field =  descriptionFromLeaveType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm descriptionFieldOfLeaveType(String initValue){
		return descriptionFieldOfLeaveType("description",initValue);
	}
	public EmployeeLeaveForm descriptionFieldOfLeaveType(){
		return descriptionFieldOfLeaveType("description","");
	}


	public EmployeeLeaveForm detailDescriptionFieldOfLeaveType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromLeaveType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeLeaveForm detailDescriptionFieldOfLeaveType(String initValue){
		return detailDescriptionFieldOfLeaveType("detailDescription",initValue);
	}
	public EmployeeLeaveForm detailDescriptionFieldOfLeaveType(){
		return detailDescriptionFieldOfLeaveType("detailDescription","");
	}

	


	

	
 	public EmployeeLeaveForm transferToAnotherWhoAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWho/employeeLeaveId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeLeaveForm transferToAnotherTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherType/employeeLeaveId/");
		this.addFormAction(action);
		return this;
	}

 

	public EmployeeLeaveForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



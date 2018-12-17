package com.doublechaintech.retailscm.employeeattendance;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeAttendanceForm extends BaseForm {
	
	
	public EmployeeAttendanceForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeAttendanceForm employeeAttendanceIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeAttendanceForm employeeAttendanceIdField(String initValue){
		return employeeAttendanceIdField("employeeAttendanceId",initValue);
	}
	public EmployeeAttendanceForm employeeAttendanceIdField(){
		return employeeAttendanceIdField("employeeAttendanceId","");
	}


	public EmployeeAttendanceForm employeeIdField(String parameterName, String initValue){
		FormField field = employeeIdFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeAttendanceForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeeAttendanceForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeeAttendanceForm enterTimeField(String parameterName, String initValue){
		FormField field = enterTimeFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeAttendanceForm enterTimeField(String initValue){
		return enterTimeField("enterTime",initValue);
	}
	public EmployeeAttendanceForm enterTimeField(){
		return enterTimeField("enterTime","");
	}


	public EmployeeAttendanceForm leaveTimeField(String parameterName, String initValue){
		FormField field = leaveTimeFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeAttendanceForm leaveTimeField(String initValue){
		return leaveTimeField("leaveTime",initValue);
	}
	public EmployeeAttendanceForm leaveTimeField(){
		return leaveTimeField("leaveTime","");
	}


	public EmployeeAttendanceForm durationHoursField(String parameterName, String initValue){
		FormField field = durationHoursFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeAttendanceForm durationHoursField(String initValue){
		return durationHoursField("durationHours",initValue);
	}
	public EmployeeAttendanceForm durationHoursField(){
		return durationHoursField("durationHours","");
	}


	public EmployeeAttendanceForm remarkField(String parameterName, String initValue){
		FormField field = remarkFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeAttendanceForm remarkField(String initValue){
		return remarkField("remark",initValue);
	}
	public EmployeeAttendanceForm remarkField(){
		return remarkField("remark","");
	}

	
	


	public EmployeeAttendanceForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeeAttendanceForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeeAttendanceForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeeAttendanceForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeeAttendanceForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeeAttendanceForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeeAttendanceForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeeAttendanceForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeeAttendanceForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeeAttendanceForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeeAttendanceForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeeAttendanceForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeeAttendanceForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeeAttendanceForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeeAttendanceForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeeAttendanceForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeeAttendanceForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeeAttendanceForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeeAttendanceForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeeAttendanceForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeeAttendanceForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeeAttendanceForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeeAttendanceForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeeAttendanceForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeeAttendanceForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeAttendanceForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeeAttendanceForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeeAttendanceForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeeAttendanceForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeeAttendanceForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeeAttendanceForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeeAttendanceForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeeAttendanceForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeeAttendanceForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeeAttendanceForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeeAttendanceForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeeAttendanceForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeAttendanceForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeeAttendanceForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeeAttendanceForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeeAttendanceForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeeAttendanceForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeeAttendanceForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeeAttendanceForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeeAttendanceForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeAttendanceForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeeAttendanceForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}

	


	

	
 	public EmployeeAttendanceForm transferToAnotherEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEmployee/employeeAttendanceId/");
		this.addFormAction(action);
		return this;
	}

 

	public EmployeeAttendanceForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



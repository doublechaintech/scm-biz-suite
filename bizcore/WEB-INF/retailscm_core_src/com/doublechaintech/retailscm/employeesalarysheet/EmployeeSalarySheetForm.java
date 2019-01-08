package com.doublechaintech.retailscm.employeesalarysheet;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeSalarySheetForm extends BaseForm {
	
	
	public EmployeeSalarySheetForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeSalarySheetForm employeeSalarySheetIdField(String parameterName, String initValue){
		FormField field = idFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm employeeSalarySheetIdField(String initValue){
		return employeeSalarySheetIdField("employeeSalarySheetId",initValue);
	}
	public EmployeeSalarySheetForm employeeSalarySheetIdField(){
		return employeeSalarySheetIdField("employeeSalarySheetId","");
	}


	public EmployeeSalarySheetForm employeeIdField(String parameterName, String initValue){
		FormField field = employeeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeeSalarySheetForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeeSalarySheetForm currentSalaryGradeIdField(String parameterName, String initValue){
		FormField field = currentSalaryGradeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm currentSalaryGradeIdField(String initValue){
		return currentSalaryGradeIdField("currentSalaryGradeId",initValue);
	}
	public EmployeeSalarySheetForm currentSalaryGradeIdField(){
		return currentSalaryGradeIdField("currentSalaryGradeId","");
	}


	public EmployeeSalarySheetForm baseSalaryField(String parameterName, String initValue){
		FormField field = baseSalaryFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm baseSalaryField(String initValue){
		return baseSalaryField("baseSalary",initValue);
	}
	public EmployeeSalarySheetForm baseSalaryField(){
		return baseSalaryField("baseSalary","");
	}


	public EmployeeSalarySheetForm bonusField(String parameterName, String initValue){
		FormField field = bonusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm bonusField(String initValue){
		return bonusField("bonus",initValue);
	}
	public EmployeeSalarySheetForm bonusField(){
		return bonusField("bonus","");
	}


	public EmployeeSalarySheetForm rewardField(String parameterName, String initValue){
		FormField field = rewardFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm rewardField(String initValue){
		return rewardField("reward",initValue);
	}
	public EmployeeSalarySheetForm rewardField(){
		return rewardField("reward","");
	}


	public EmployeeSalarySheetForm personalTaxField(String parameterName, String initValue){
		FormField field = personalTaxFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm personalTaxField(String initValue){
		return personalTaxField("personalTax",initValue);
	}
	public EmployeeSalarySheetForm personalTaxField(){
		return personalTaxField("personalTax","");
	}


	public EmployeeSalarySheetForm socialSecurityField(String parameterName, String initValue){
		FormField field = socialSecurityFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm socialSecurityField(String initValue){
		return socialSecurityField("socialSecurity",initValue);
	}
	public EmployeeSalarySheetForm socialSecurityField(){
		return socialSecurityField("socialSecurity","");
	}


	public EmployeeSalarySheetForm housingFoundField(String parameterName, String initValue){
		FormField field = housingFoundFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm housingFoundField(String initValue){
		return housingFoundField("housingFound",initValue);
	}
	public EmployeeSalarySheetForm housingFoundField(){
		return housingFoundField("housingFound","");
	}


	public EmployeeSalarySheetForm jobInsuranceField(String parameterName, String initValue){
		FormField field = jobInsuranceFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm jobInsuranceField(String initValue){
		return jobInsuranceField("jobInsurance",initValue);
	}
	public EmployeeSalarySheetForm jobInsuranceField(){
		return jobInsuranceField("jobInsurance","");
	}


	public EmployeeSalarySheetForm payingOffIdField(String parameterName, String initValue){
		FormField field = payingOffIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm payingOffIdField(String initValue){
		return payingOffIdField("payingOffId",initValue);
	}
	public EmployeeSalarySheetForm payingOffIdField(){
		return payingOffIdField("payingOffId","");
	}


	public EmployeeSalarySheetForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeSalarySheetForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public EmployeeSalarySheetForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public EmployeeSalarySheetForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public EmployeeSalarySheetForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public EmployeeSalarySheetForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public EmployeeSalarySheetForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public EmployeeSalarySheetForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public EmployeeSalarySheetForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public EmployeeSalarySheetForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public EmployeeSalarySheetForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public EmployeeSalarySheetForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public EmployeeSalarySheetForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public EmployeeSalarySheetForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public EmployeeSalarySheetForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public EmployeeSalarySheetForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public EmployeeSalarySheetForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public EmployeeSalarySheetForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public EmployeeSalarySheetForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public EmployeeSalarySheetForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public EmployeeSalarySheetForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public EmployeeSalarySheetForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public EmployeeSalarySheetForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public EmployeeSalarySheetForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public EmployeeSalarySheetForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public EmployeeSalarySheetForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public EmployeeSalarySheetForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public EmployeeSalarySheetForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public EmployeeSalarySheetForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public EmployeeSalarySheetForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public EmployeeSalarySheetForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public EmployeeSalarySheetForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public EmployeeSalarySheetForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public EmployeeSalarySheetForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public EmployeeSalarySheetForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public EmployeeSalarySheetForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public EmployeeSalarySheetForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public EmployeeSalarySheetForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public EmployeeSalarySheetForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public EmployeeSalarySheetForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public EmployeeSalarySheetForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public EmployeeSalarySheetForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public EmployeeSalarySheetForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public EmployeeSalarySheetForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public EmployeeSalarySheetForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public EmployeeSalarySheetForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public EmployeeSalarySheetForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public EmployeeSalarySheetForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public EmployeeSalarySheetForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}


	public EmployeeSalarySheetForm salaryGradeIdFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  idFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm salaryGradeIdFieldOfSalaryGrade(String initValue){
		return salaryGradeIdFieldOfSalaryGrade("salaryGradeId",initValue);
	}
	public EmployeeSalarySheetForm salaryGradeIdFieldOfSalaryGrade(){
		return salaryGradeIdFieldOfSalaryGrade("salaryGradeId","");
	}


	public EmployeeSalarySheetForm codeFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  codeFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm codeFieldOfSalaryGrade(String initValue){
		return codeFieldOfSalaryGrade("code",initValue);
	}
	public EmployeeSalarySheetForm codeFieldOfSalaryGrade(){
		return codeFieldOfSalaryGrade("code","");
	}


	public EmployeeSalarySheetForm companyIdFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  companyIdFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm companyIdFieldOfSalaryGrade(String initValue){
		return companyIdFieldOfSalaryGrade("companyId",initValue);
	}
	public EmployeeSalarySheetForm companyIdFieldOfSalaryGrade(){
		return companyIdFieldOfSalaryGrade("companyId","");
	}


	public EmployeeSalarySheetForm nameFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  nameFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm nameFieldOfSalaryGrade(String initValue){
		return nameFieldOfSalaryGrade("name",initValue);
	}
	public EmployeeSalarySheetForm nameFieldOfSalaryGrade(){
		return nameFieldOfSalaryGrade("name","");
	}


	public EmployeeSalarySheetForm detailDescriptionFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  detailDescriptionFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm detailDescriptionFieldOfSalaryGrade(String initValue){
		return detailDescriptionFieldOfSalaryGrade("detailDescription",initValue);
	}
	public EmployeeSalarySheetForm detailDescriptionFieldOfSalaryGrade(){
		return detailDescriptionFieldOfSalaryGrade("detailDescription","");
	}


	public EmployeeSalarySheetForm payingOffIdFieldOfPayingOff(String parameterName, String initValue){
		FormField field =  idFromPayingOff(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm payingOffIdFieldOfPayingOff(String initValue){
		return payingOffIdFieldOfPayingOff("payingOffId",initValue);
	}
	public EmployeeSalarySheetForm payingOffIdFieldOfPayingOff(){
		return payingOffIdFieldOfPayingOff("payingOffId","");
	}


	public EmployeeSalarySheetForm whoFieldOfPayingOff(String parameterName, String initValue){
		FormField field =  whoFromPayingOff(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm whoFieldOfPayingOff(String initValue){
		return whoFieldOfPayingOff("who",initValue);
	}
	public EmployeeSalarySheetForm whoFieldOfPayingOff(){
		return whoFieldOfPayingOff("who","");
	}


	public EmployeeSalarySheetForm paidForIdFieldOfPayingOff(String parameterName, String initValue){
		FormField field =  paidForIdFromPayingOff(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm paidForIdFieldOfPayingOff(String initValue){
		return paidForIdFieldOfPayingOff("paidForId",initValue);
	}
	public EmployeeSalarySheetForm paidForIdFieldOfPayingOff(){
		return paidForIdFieldOfPayingOff("paidForId","");
	}


	public EmployeeSalarySheetForm paidTimeFieldOfPayingOff(String parameterName, String initValue){
		FormField field =  paidTimeFromPayingOff(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm paidTimeFieldOfPayingOff(String initValue){
		return paidTimeFieldOfPayingOff("paidTime",initValue);
	}
	public EmployeeSalarySheetForm paidTimeFieldOfPayingOff(){
		return paidTimeFieldOfPayingOff("paidTime","");
	}


	public EmployeeSalarySheetForm amountFieldOfPayingOff(String parameterName, String initValue){
		FormField field =  amountFromPayingOff(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeSalarySheetForm amountFieldOfPayingOff(String initValue){
		return amountFieldOfPayingOff("amount",initValue);
	}
	public EmployeeSalarySheetForm amountFieldOfPayingOff(){
		return amountFieldOfPayingOff("amount","");
	}

	


	

	
 	public EmployeeSalarySheetForm transferToAnotherEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherEmployee/employeeSalarySheetId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeSalarySheetForm transferToAnotherCurrentSalaryGradeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCurrentSalaryGrade/employeeSalarySheetId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeSalarySheetForm  payOffAction(){
		FormAction action = new FormAction();
		action.setLabel("PayOff");
		action.setLocaleKey("employee_salary_sheet.payOff");
		action.setUrl("employeeSalarySheetManager/payOff/employeeSalarySheetId/who/paidForIdpaidTime/amount/");
		this.addFormAction(action);
		return this;
	}

	public EmployeeSalarySheetForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



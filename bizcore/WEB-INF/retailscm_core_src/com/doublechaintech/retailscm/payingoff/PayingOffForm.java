package com.doublechaintech.retailscm.payingoff;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class PayingOffForm extends BaseForm {
	
	
	public PayingOffForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PayingOffForm payingOffIdField(String parameterName, String initValue){
		FormField field = idFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm payingOffIdField(String initValue){
		return payingOffIdField("payingOffId",initValue);
	}
	public PayingOffForm payingOffIdField(){
		return payingOffIdField("payingOffId","");
	}


	public PayingOffForm whoField(String parameterName, String initValue){
		FormField field = whoFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm whoField(String initValue){
		return whoField("who",initValue);
	}
	public PayingOffForm whoField(){
		return whoField("who","");
	}


	public PayingOffForm paidForIdField(String parameterName, String initValue){
		FormField field = paidForIdFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm paidForIdField(String initValue){
		return paidForIdField("paidForId",initValue);
	}
	public PayingOffForm paidForIdField(){
		return paidForIdField("paidForId","");
	}


	public PayingOffForm paidTimeField(String parameterName, String initValue){
		FormField field = paidTimeFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm paidTimeField(String initValue){
		return paidTimeField("paidTime",initValue);
	}
	public PayingOffForm paidTimeField(){
		return paidTimeField("paidTime","");
	}


	public PayingOffForm amountField(String parameterName, String initValue){
		FormField field = amountFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm amountField(String initValue){
		return amountField("amount",initValue);
	}
	public PayingOffForm amountField(){
		return amountField("amount","");
	}

	
	


	public PayingOffForm employeeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm employeeIdFieldOfEmployee(String initValue){
		return employeeIdFieldOfEmployee("employeeId",initValue);
	}
	public PayingOffForm employeeIdFieldOfEmployee(){
		return employeeIdFieldOfEmployee("employeeId","");
	}


	public PayingOffForm companyIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm companyIdFieldOfEmployee(String initValue){
		return companyIdFieldOfEmployee("companyId",initValue);
	}
	public PayingOffForm companyIdFieldOfEmployee(){
		return companyIdFieldOfEmployee("companyId","");
	}


	public PayingOffForm titleFieldOfEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm titleFieldOfEmployee(String initValue){
		return titleFieldOfEmployee("title",initValue);
	}
	public PayingOffForm titleFieldOfEmployee(){
		return titleFieldOfEmployee("title","");
	}


	public PayingOffForm departmentIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm departmentIdFieldOfEmployee(String initValue){
		return departmentIdFieldOfEmployee("departmentId",initValue);
	}
	public PayingOffForm departmentIdFieldOfEmployee(){
		return departmentIdFieldOfEmployee("departmentId","");
	}


	public PayingOffForm familyNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm familyNameFieldOfEmployee(String initValue){
		return familyNameFieldOfEmployee("familyName",initValue);
	}
	public PayingOffForm familyNameFieldOfEmployee(){
		return familyNameFieldOfEmployee("familyName","");
	}


	public PayingOffForm givenNameFieldOfEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm givenNameFieldOfEmployee(String initValue){
		return givenNameFieldOfEmployee("givenName",initValue);
	}
	public PayingOffForm givenNameFieldOfEmployee(){
		return givenNameFieldOfEmployee("givenName","");
	}


	public PayingOffForm emailFieldOfEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm emailFieldOfEmployee(String initValue){
		return emailFieldOfEmployee("email",initValue);
	}
	public PayingOffForm emailFieldOfEmployee(){
		return emailFieldOfEmployee("email","");
	}


	public PayingOffForm cityFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm cityFieldOfEmployee(String initValue){
		return cityFieldOfEmployee("city",initValue);
	}
	public PayingOffForm cityFieldOfEmployee(){
		return cityFieldOfEmployee("city","");
	}


	public PayingOffForm addressFieldOfEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm addressFieldOfEmployee(String initValue){
		return addressFieldOfEmployee("address",initValue);
	}
	public PayingOffForm addressFieldOfEmployee(){
		return addressFieldOfEmployee("address","");
	}


	public PayingOffForm cellPhoneFieldOfEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm cellPhoneFieldOfEmployee(String initValue){
		return cellPhoneFieldOfEmployee("cellPhone",initValue);
	}
	public PayingOffForm cellPhoneFieldOfEmployee(){
		return cellPhoneFieldOfEmployee("cellPhone","");
	}


	public PayingOffForm occupationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm occupationIdFieldOfEmployee(String initValue){
		return occupationIdFieldOfEmployee("occupationId",initValue);
	}
	public PayingOffForm occupationIdFieldOfEmployee(){
		return occupationIdFieldOfEmployee("occupationId","");
	}


	public PayingOffForm responsibleForIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm responsibleForIdFieldOfEmployee(String initValue){
		return responsibleForIdFieldOfEmployee("responsibleForId",initValue);
	}
	public PayingOffForm responsibleForIdFieldOfEmployee(){
		return responsibleForIdFieldOfEmployee("responsibleForId","");
	}


	public PayingOffForm currentSalaryGradeIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm currentSalaryGradeIdFieldOfEmployee(String initValue){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId",initValue);
	}
	public PayingOffForm currentSalaryGradeIdFieldOfEmployee(){
		return currentSalaryGradeIdFieldOfEmployee("currentSalaryGradeId","");
	}


	public PayingOffForm salaryAccountFieldOfEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm salaryAccountFieldOfEmployee(String initValue){
		return salaryAccountFieldOfEmployee("salaryAccount",initValue);
	}
	public PayingOffForm salaryAccountFieldOfEmployee(){
		return salaryAccountFieldOfEmployee("salaryAccount","");
	}


	public PayingOffForm jobApplicationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm jobApplicationIdFieldOfEmployee(String initValue){
		return jobApplicationIdFieldOfEmployee("jobApplicationId",initValue);
	}
	public PayingOffForm jobApplicationIdFieldOfEmployee(){
		return jobApplicationIdFieldOfEmployee("jobApplicationId","");
	}


	public PayingOffForm professionInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm professionInterviewIdFieldOfEmployee(String initValue){
		return professionInterviewIdFieldOfEmployee("professionInterviewId",initValue);
	}
	public PayingOffForm professionInterviewIdFieldOfEmployee(){
		return professionInterviewIdFieldOfEmployee("professionInterviewId","");
	}


	public PayingOffForm hrInterviewIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm hrInterviewIdFieldOfEmployee(String initValue){
		return hrInterviewIdFieldOfEmployee("hrInterviewId",initValue);
	}
	public PayingOffForm hrInterviewIdFieldOfEmployee(){
		return hrInterviewIdFieldOfEmployee("hrInterviewId","");
	}


	public PayingOffForm offerApprovalIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm offerApprovalIdFieldOfEmployee(String initValue){
		return offerApprovalIdFieldOfEmployee("offerApprovalId",initValue);
	}
	public PayingOffForm offerApprovalIdFieldOfEmployee(){
		return offerApprovalIdFieldOfEmployee("offerApprovalId","");
	}


	public PayingOffForm offerAcceptanceIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm offerAcceptanceIdFieldOfEmployee(String initValue){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId",initValue);
	}
	public PayingOffForm offerAcceptanceIdFieldOfEmployee(){
		return offerAcceptanceIdFieldOfEmployee("offerAcceptanceId","");
	}


	public PayingOffForm employeeBoardingIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm employeeBoardingIdFieldOfEmployee(String initValue){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId",initValue);
	}
	public PayingOffForm employeeBoardingIdFieldOfEmployee(){
		return employeeBoardingIdFieldOfEmployee("employeeBoardingId","");
	}


	public PayingOffForm terminationIdFieldOfEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm terminationIdFieldOfEmployee(String initValue){
		return terminationIdFieldOfEmployee("terminationId",initValue);
	}
	public PayingOffForm terminationIdFieldOfEmployee(){
		return terminationIdFieldOfEmployee("terminationId","");
	}


	public PayingOffForm lastUpdateTimeFieldOfEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm lastUpdateTimeFieldOfEmployee(String initValue){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime",initValue);
	}
	public PayingOffForm lastUpdateTimeFieldOfEmployee(){
		return lastUpdateTimeFieldOfEmployee("lastUpdateTime","");
	}


	public PayingOffForm currentStatusFieldOfEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PayingOffForm currentStatusFieldOfEmployee(String initValue){
		return currentStatusFieldOfEmployee("currentStatus",initValue);
	}
	public PayingOffForm currentStatusFieldOfEmployee(){
		return currentStatusFieldOfEmployee("currentStatus","");
	}

	



	public PayingOffForm employeeSalarySheetIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  idFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm employeeSalarySheetIdFieldForEmployeeSalarySheet(String initValue){
		return employeeSalarySheetIdFieldForEmployeeSalarySheet("employeeSalarySheetId",initValue);
	}
	public PayingOffForm employeeSalarySheetIdFieldForEmployeeSalarySheet(){
		return employeeSalarySheetIdFieldForEmployeeSalarySheet("employeeSalarySheetId","");
	}


	public PayingOffForm employeeIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm employeeIdFieldForEmployeeSalarySheet(String initValue){
		return employeeIdFieldForEmployeeSalarySheet("employeeId",initValue);
	}
	public PayingOffForm employeeIdFieldForEmployeeSalarySheet(){
		return employeeIdFieldForEmployeeSalarySheet("employeeId","");
	}


	public PayingOffForm currentSalaryGradeIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm currentSalaryGradeIdFieldForEmployeeSalarySheet(String initValue){
		return currentSalaryGradeIdFieldForEmployeeSalarySheet("currentSalaryGradeId",initValue);
	}
	public PayingOffForm currentSalaryGradeIdFieldForEmployeeSalarySheet(){
		return currentSalaryGradeIdFieldForEmployeeSalarySheet("currentSalaryGradeId","");
	}


	public PayingOffForm baseSalaryFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  baseSalaryFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm baseSalaryFieldForEmployeeSalarySheet(String initValue){
		return baseSalaryFieldForEmployeeSalarySheet("baseSalary",initValue);
	}
	public PayingOffForm baseSalaryFieldForEmployeeSalarySheet(){
		return baseSalaryFieldForEmployeeSalarySheet("baseSalary","");
	}


	public PayingOffForm bonusFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  bonusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm bonusFieldForEmployeeSalarySheet(String initValue){
		return bonusFieldForEmployeeSalarySheet("bonus",initValue);
	}
	public PayingOffForm bonusFieldForEmployeeSalarySheet(){
		return bonusFieldForEmployeeSalarySheet("bonus","");
	}


	public PayingOffForm rewardFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  rewardFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm rewardFieldForEmployeeSalarySheet(String initValue){
		return rewardFieldForEmployeeSalarySheet("reward",initValue);
	}
	public PayingOffForm rewardFieldForEmployeeSalarySheet(){
		return rewardFieldForEmployeeSalarySheet("reward","");
	}


	public PayingOffForm personalTaxFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  personalTaxFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm personalTaxFieldForEmployeeSalarySheet(String initValue){
		return personalTaxFieldForEmployeeSalarySheet("personalTax",initValue);
	}
	public PayingOffForm personalTaxFieldForEmployeeSalarySheet(){
		return personalTaxFieldForEmployeeSalarySheet("personalTax","");
	}


	public PayingOffForm socialSecurityFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  socialSecurityFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm socialSecurityFieldForEmployeeSalarySheet(String initValue){
		return socialSecurityFieldForEmployeeSalarySheet("socialSecurity",initValue);
	}
	public PayingOffForm socialSecurityFieldForEmployeeSalarySheet(){
		return socialSecurityFieldForEmployeeSalarySheet("socialSecurity","");
	}


	public PayingOffForm housingFoundFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  housingFoundFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm housingFoundFieldForEmployeeSalarySheet(String initValue){
		return housingFoundFieldForEmployeeSalarySheet("housingFound",initValue);
	}
	public PayingOffForm housingFoundFieldForEmployeeSalarySheet(){
		return housingFoundFieldForEmployeeSalarySheet("housingFound","");
	}


	public PayingOffForm jobInsuranceFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  jobInsuranceFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm jobInsuranceFieldForEmployeeSalarySheet(String initValue){
		return jobInsuranceFieldForEmployeeSalarySheet("jobInsurance",initValue);
	}
	public PayingOffForm jobInsuranceFieldForEmployeeSalarySheet(){
		return jobInsuranceFieldForEmployeeSalarySheet("jobInsurance","");
	}


	public PayingOffForm payingOffIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  payingOffIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm payingOffIdFieldForEmployeeSalarySheet(String initValue){
		return payingOffIdFieldForEmployeeSalarySheet("payingOffId",initValue);
	}
	public PayingOffForm payingOffIdFieldForEmployeeSalarySheet(){
		return payingOffIdFieldForEmployeeSalarySheet("payingOffId","");
	}


	public PayingOffForm currentStatusFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PayingOffForm currentStatusFieldForEmployeeSalarySheet(String initValue){
		return currentStatusFieldForEmployeeSalarySheet("currentStatus",initValue);
	}
	public PayingOffForm currentStatusFieldForEmployeeSalarySheet(){
		return currentStatusFieldForEmployeeSalarySheet("currentStatus","");
	}

	

	
 	public PayingOffForm transferToAnotherPaidForAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPaidFor/payingOffId/");
		this.addFormAction(action);
		return this;
	}

 

	public PayingOffForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



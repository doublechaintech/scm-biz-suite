package com.doublechaintech.retailscm.salarygrade;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SalaryGradeForm extends BaseForm {
	
	
	public SalaryGradeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SalaryGradeForm salaryGradeIdField(String parameterName, String initValue){
		FormField field = idFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm salaryGradeIdField(String initValue){
		return salaryGradeIdField("salaryGradeId",initValue);
	}
	public SalaryGradeForm salaryGradeIdField(){
		return salaryGradeIdField("salaryGradeId","");
	}


	public SalaryGradeForm codeField(String parameterName, String initValue){
		FormField field = codeFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public SalaryGradeForm codeField(){
		return codeField("code","");
	}


	public SalaryGradeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public SalaryGradeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public SalaryGradeForm nameField(String parameterName, String initValue){
		FormField field = nameFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public SalaryGradeForm nameField(){
		return nameField("name","");
	}


	public SalaryGradeForm detailDescriptionField(String parameterName, String initValue){
		FormField field = detailDescriptionFromSalaryGrade(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm detailDescriptionField(String initValue){
		return detailDescriptionField("detailDescription",initValue);
	}
	public SalaryGradeForm detailDescriptionField(){
		return detailDescriptionField("detailDescription","");
	}

	
	


	public SalaryGradeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public SalaryGradeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public SalaryGradeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public SalaryGradeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public SalaryGradeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public SalaryGradeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public SalaryGradeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public SalaryGradeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public SalaryGradeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public SalaryGradeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public SalaryGradeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public SalaryGradeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public SalaryGradeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public SalaryGradeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public SalaryGradeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public SalaryGradeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public SalaryGradeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SalaryGradeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public SalaryGradeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public SalaryGradeForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public SalaryGradeForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public SalaryGradeForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public SalaryGradeForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public SalaryGradeForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public SalaryGradeForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public SalaryGradeForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public SalaryGradeForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public SalaryGradeForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public SalaryGradeForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public SalaryGradeForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public SalaryGradeForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public SalaryGradeForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public SalaryGradeForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public SalaryGradeForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public SalaryGradeForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public SalaryGradeForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public SalaryGradeForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public SalaryGradeForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public SalaryGradeForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public SalaryGradeForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public SalaryGradeForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public SalaryGradeForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public SalaryGradeForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public SalaryGradeForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public SalaryGradeForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public SalaryGradeForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public SalaryGradeForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public SalaryGradeForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public SalaryGradeForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public SalaryGradeForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public SalaryGradeForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public SalaryGradeForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public SalaryGradeForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public SalaryGradeForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public SalaryGradeForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public SalaryGradeForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public SalaryGradeForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public SalaryGradeForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public SalaryGradeForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public SalaryGradeForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public SalaryGradeForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public SalaryGradeForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public SalaryGradeForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public SalaryGradeForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public SalaryGradeForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}


	public SalaryGradeForm employeeSalarySheetIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  idFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm employeeSalarySheetIdFieldForEmployeeSalarySheet(String initValue){
		return employeeSalarySheetIdFieldForEmployeeSalarySheet("employeeSalarySheetId",initValue);
	}
	public SalaryGradeForm employeeSalarySheetIdFieldForEmployeeSalarySheet(){
		return employeeSalarySheetIdFieldForEmployeeSalarySheet("employeeSalarySheetId","");
	}


	public SalaryGradeForm employeeIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm employeeIdFieldForEmployeeSalarySheet(String initValue){
		return employeeIdFieldForEmployeeSalarySheet("employeeId",initValue);
	}
	public SalaryGradeForm employeeIdFieldForEmployeeSalarySheet(){
		return employeeIdFieldForEmployeeSalarySheet("employeeId","");
	}


	public SalaryGradeForm currentSalaryGradeIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm currentSalaryGradeIdFieldForEmployeeSalarySheet(String initValue){
		return currentSalaryGradeIdFieldForEmployeeSalarySheet("currentSalaryGradeId",initValue);
	}
	public SalaryGradeForm currentSalaryGradeIdFieldForEmployeeSalarySheet(){
		return currentSalaryGradeIdFieldForEmployeeSalarySheet("currentSalaryGradeId","");
	}


	public SalaryGradeForm baseSalaryFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  baseSalaryFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm baseSalaryFieldForEmployeeSalarySheet(String initValue){
		return baseSalaryFieldForEmployeeSalarySheet("baseSalary",initValue);
	}
	public SalaryGradeForm baseSalaryFieldForEmployeeSalarySheet(){
		return baseSalaryFieldForEmployeeSalarySheet("baseSalary","");
	}


	public SalaryGradeForm bonusFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  bonusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm bonusFieldForEmployeeSalarySheet(String initValue){
		return bonusFieldForEmployeeSalarySheet("bonus",initValue);
	}
	public SalaryGradeForm bonusFieldForEmployeeSalarySheet(){
		return bonusFieldForEmployeeSalarySheet("bonus","");
	}


	public SalaryGradeForm rewardFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  rewardFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm rewardFieldForEmployeeSalarySheet(String initValue){
		return rewardFieldForEmployeeSalarySheet("reward",initValue);
	}
	public SalaryGradeForm rewardFieldForEmployeeSalarySheet(){
		return rewardFieldForEmployeeSalarySheet("reward","");
	}


	public SalaryGradeForm personalTaxFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  personalTaxFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm personalTaxFieldForEmployeeSalarySheet(String initValue){
		return personalTaxFieldForEmployeeSalarySheet("personalTax",initValue);
	}
	public SalaryGradeForm personalTaxFieldForEmployeeSalarySheet(){
		return personalTaxFieldForEmployeeSalarySheet("personalTax","");
	}


	public SalaryGradeForm socialSecurityFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  socialSecurityFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm socialSecurityFieldForEmployeeSalarySheet(String initValue){
		return socialSecurityFieldForEmployeeSalarySheet("socialSecurity",initValue);
	}
	public SalaryGradeForm socialSecurityFieldForEmployeeSalarySheet(){
		return socialSecurityFieldForEmployeeSalarySheet("socialSecurity","");
	}


	public SalaryGradeForm housingFoundFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  housingFoundFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm housingFoundFieldForEmployeeSalarySheet(String initValue){
		return housingFoundFieldForEmployeeSalarySheet("housingFound",initValue);
	}
	public SalaryGradeForm housingFoundFieldForEmployeeSalarySheet(){
		return housingFoundFieldForEmployeeSalarySheet("housingFound","");
	}


	public SalaryGradeForm jobInsuranceFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  jobInsuranceFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm jobInsuranceFieldForEmployeeSalarySheet(String initValue){
		return jobInsuranceFieldForEmployeeSalarySheet("jobInsurance",initValue);
	}
	public SalaryGradeForm jobInsuranceFieldForEmployeeSalarySheet(){
		return jobInsuranceFieldForEmployeeSalarySheet("jobInsurance","");
	}


	public SalaryGradeForm payingOffIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  payingOffIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm payingOffIdFieldForEmployeeSalarySheet(String initValue){
		return payingOffIdFieldForEmployeeSalarySheet("payingOffId",initValue);
	}
	public SalaryGradeForm payingOffIdFieldForEmployeeSalarySheet(){
		return payingOffIdFieldForEmployeeSalarySheet("payingOffId","");
	}


	public SalaryGradeForm currentStatusFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SalaryGradeForm currentStatusFieldForEmployeeSalarySheet(String initValue){
		return currentStatusFieldForEmployeeSalarySheet("currentStatus",initValue);
	}
	public SalaryGradeForm currentStatusFieldForEmployeeSalarySheet(){
		return currentStatusFieldForEmployeeSalarySheet("currentStatus","");
	}

	

	
 	public SalaryGradeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/salaryGradeId/");
		this.addFormAction(action);
		return this;
	}

 

	public SalaryGradeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



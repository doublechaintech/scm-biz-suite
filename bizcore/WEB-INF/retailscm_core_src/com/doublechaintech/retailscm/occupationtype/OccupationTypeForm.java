package com.doublechaintech.retailscm.occupationtype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class OccupationTypeForm extends BaseForm {
	
	
	public OccupationTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public OccupationTypeForm occupationTypeIdField(String parameterName, String initValue){
		FormField field = idFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm occupationTypeIdField(String initValue){
		return occupationTypeIdField("occupationTypeId",initValue);
	}
	public OccupationTypeForm occupationTypeIdField(){
		return occupationTypeIdField("occupationTypeId","");
	}


	public OccupationTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public OccupationTypeForm codeField(){
		return codeField("code","");
	}


	public OccupationTypeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public OccupationTypeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public OccupationTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public OccupationTypeForm descriptionField(){
		return descriptionField("description","");
	}


	public OccupationTypeForm detailDescriptionField(String parameterName, String initValue){
		FormField field = detailDescriptionFromOccupationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm detailDescriptionField(String initValue){
		return detailDescriptionField("detailDescription",initValue);
	}
	public OccupationTypeForm detailDescriptionField(){
		return detailDescriptionField("detailDescription","");
	}

	
	


	public OccupationTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public OccupationTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public OccupationTypeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public OccupationTypeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public OccupationTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public OccupationTypeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public OccupationTypeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public OccupationTypeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public OccupationTypeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public OccupationTypeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public OccupationTypeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public OccupationTypeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public OccupationTypeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public OccupationTypeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public OccupationTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public OccupationTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public OccupationTypeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public OccupationTypeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public OccupationTypeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public OccupationTypeForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public OccupationTypeForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public OccupationTypeForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public OccupationTypeForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public OccupationTypeForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public OccupationTypeForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public OccupationTypeForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public OccupationTypeForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public OccupationTypeForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public OccupationTypeForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public OccupationTypeForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public OccupationTypeForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public OccupationTypeForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public OccupationTypeForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public OccupationTypeForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public OccupationTypeForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public OccupationTypeForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public OccupationTypeForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public OccupationTypeForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public OccupationTypeForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public OccupationTypeForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public OccupationTypeForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public OccupationTypeForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public OccupationTypeForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public OccupationTypeForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public OccupationTypeForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public OccupationTypeForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public OccupationTypeForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public OccupationTypeForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public OccupationTypeForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public OccupationTypeForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public OccupationTypeForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public OccupationTypeForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public OccupationTypeForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public OccupationTypeForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public OccupationTypeForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public OccupationTypeForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public OccupationTypeForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public OccupationTypeForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public OccupationTypeForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public OccupationTypeForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public OccupationTypeForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public OccupationTypeForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public OccupationTypeForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public OccupationTypeForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public OccupationTypeForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public OccupationTypeForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	

	
 	public OccupationTypeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/occupationTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public OccupationTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



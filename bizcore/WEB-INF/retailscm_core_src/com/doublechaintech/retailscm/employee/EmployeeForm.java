package com.doublechaintech.retailscm.employee;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class EmployeeForm extends BaseForm {
	
	
	public EmployeeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public EmployeeForm employeeIdField(String parameterName, String initValue){
		FormField field = idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdField(String initValue){
		return employeeIdField("employeeId",initValue);
	}
	public EmployeeForm employeeIdField(){
		return employeeIdField("employeeId","");
	}


	public EmployeeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public EmployeeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public EmployeeForm titleField(String parameterName, String initValue){
		FormField field = titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public EmployeeForm titleField(){
		return titleField("title","");
	}


	public EmployeeForm departmentIdField(String parameterName, String initValue){
		FormField field = departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm departmentIdField(String initValue){
		return departmentIdField("departmentId",initValue);
	}
	public EmployeeForm departmentIdField(){
		return departmentIdField("departmentId","");
	}


	public EmployeeForm familyNameField(String parameterName, String initValue){
		FormField field = familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm familyNameField(String initValue){
		return familyNameField("familyName",initValue);
	}
	public EmployeeForm familyNameField(){
		return familyNameField("familyName","");
	}


	public EmployeeForm givenNameField(String parameterName, String initValue){
		FormField field = givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm givenNameField(String initValue){
		return givenNameField("givenName",initValue);
	}
	public EmployeeForm givenNameField(){
		return givenNameField("givenName","");
	}


	public EmployeeForm emailField(String parameterName, String initValue){
		FormField field = emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm emailField(String initValue){
		return emailField("email",initValue);
	}
	public EmployeeForm emailField(){
		return emailField("email","");
	}


	public EmployeeForm cityField(String parameterName, String initValue){
		FormField field = cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm cityField(String initValue){
		return cityField("city",initValue);
	}
	public EmployeeForm cityField(){
		return cityField("city","");
	}


	public EmployeeForm addressField(String parameterName, String initValue){
		FormField field = addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm addressField(String initValue){
		return addressField("address",initValue);
	}
	public EmployeeForm addressField(){
		return addressField("address","");
	}


	public EmployeeForm cellPhoneField(String parameterName, String initValue){
		FormField field = cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm cellPhoneField(String initValue){
		return cellPhoneField("cellPhone",initValue);
	}
	public EmployeeForm cellPhoneField(){
		return cellPhoneField("cellPhone","");
	}


	public EmployeeForm occupationIdField(String parameterName, String initValue){
		FormField field = occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm occupationIdField(String initValue){
		return occupationIdField("occupationId",initValue);
	}
	public EmployeeForm occupationIdField(){
		return occupationIdField("occupationId","");
	}


	public EmployeeForm responsibleForIdField(String parameterName, String initValue){
		FormField field = responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm responsibleForIdField(String initValue){
		return responsibleForIdField("responsibleForId",initValue);
	}
	public EmployeeForm responsibleForIdField(){
		return responsibleForIdField("responsibleForId","");
	}


	public EmployeeForm currentSalaryGradeIdField(String parameterName, String initValue){
		FormField field = currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm currentSalaryGradeIdField(String initValue){
		return currentSalaryGradeIdField("currentSalaryGradeId",initValue);
	}
	public EmployeeForm currentSalaryGradeIdField(){
		return currentSalaryGradeIdField("currentSalaryGradeId","");
	}


	public EmployeeForm salaryAccountField(String parameterName, String initValue){
		FormField field = salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm salaryAccountField(String initValue){
		return salaryAccountField("salaryAccount",initValue);
	}
	public EmployeeForm salaryAccountField(){
		return salaryAccountField("salaryAccount","");
	}


	public EmployeeForm jobApplicationIdField(String parameterName, String initValue){
		FormField field = jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm jobApplicationIdField(String initValue){
		return jobApplicationIdField("jobApplicationId",initValue);
	}
	public EmployeeForm jobApplicationIdField(){
		return jobApplicationIdField("jobApplicationId","");
	}


	public EmployeeForm professionInterviewIdField(String parameterName, String initValue){
		FormField field = professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm professionInterviewIdField(String initValue){
		return professionInterviewIdField("professionInterviewId",initValue);
	}
	public EmployeeForm professionInterviewIdField(){
		return professionInterviewIdField("professionInterviewId","");
	}


	public EmployeeForm hrInterviewIdField(String parameterName, String initValue){
		FormField field = hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm hrInterviewIdField(String initValue){
		return hrInterviewIdField("hrInterviewId",initValue);
	}
	public EmployeeForm hrInterviewIdField(){
		return hrInterviewIdField("hrInterviewId","");
	}


	public EmployeeForm offerApprovalIdField(String parameterName, String initValue){
		FormField field = offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm offerApprovalIdField(String initValue){
		return offerApprovalIdField("offerApprovalId",initValue);
	}
	public EmployeeForm offerApprovalIdField(){
		return offerApprovalIdField("offerApprovalId","");
	}


	public EmployeeForm offerAcceptanceIdField(String parameterName, String initValue){
		FormField field = offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm offerAcceptanceIdField(String initValue){
		return offerAcceptanceIdField("offerAcceptanceId",initValue);
	}
	public EmployeeForm offerAcceptanceIdField(){
		return offerAcceptanceIdField("offerAcceptanceId","");
	}


	public EmployeeForm employeeBoardingIdField(String parameterName, String initValue){
		FormField field = employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeBoardingIdField(String initValue){
		return employeeBoardingIdField("employeeBoardingId",initValue);
	}
	public EmployeeForm employeeBoardingIdField(){
		return employeeBoardingIdField("employeeBoardingId","");
	}


	public EmployeeForm terminationIdField(String parameterName, String initValue){
		FormField field = terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm terminationIdField(String initValue){
		return terminationIdField("terminationId",initValue);
	}
	public EmployeeForm terminationIdField(){
		return terminationIdField("terminationId","");
	}


	public EmployeeForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public EmployeeForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public EmployeeForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public EmployeeForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public EmployeeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public EmployeeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public EmployeeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public EmployeeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public EmployeeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public EmployeeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public EmployeeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public EmployeeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public EmployeeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public EmployeeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public EmployeeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public EmployeeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public EmployeeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public EmployeeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public EmployeeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public EmployeeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public EmployeeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public EmployeeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}


	public EmployeeForm levelThreeDepartmentIdFieldOfLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  idFromLevelThreeDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm levelThreeDepartmentIdFieldOfLevelThreeDepartment(String initValue){
		return levelThreeDepartmentIdFieldOfLevelThreeDepartment("levelThreeDepartmentId",initValue);
	}
	public EmployeeForm levelThreeDepartmentIdFieldOfLevelThreeDepartment(){
		return levelThreeDepartmentIdFieldOfLevelThreeDepartment("levelThreeDepartmentId","");
	}


	public EmployeeForm belongsToIdFieldOfLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  belongsToIdFromLevelThreeDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm belongsToIdFieldOfLevelThreeDepartment(String initValue){
		return belongsToIdFieldOfLevelThreeDepartment("belongsToId",initValue);
	}
	public EmployeeForm belongsToIdFieldOfLevelThreeDepartment(){
		return belongsToIdFieldOfLevelThreeDepartment("belongsToId","");
	}


	public EmployeeForm nameFieldOfLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  nameFromLevelThreeDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm nameFieldOfLevelThreeDepartment(String initValue){
		return nameFieldOfLevelThreeDepartment("name",initValue);
	}
	public EmployeeForm nameFieldOfLevelThreeDepartment(){
		return nameFieldOfLevelThreeDepartment("name","");
	}


	public EmployeeForm descriptionFieldOfLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  descriptionFromLevelThreeDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm descriptionFieldOfLevelThreeDepartment(String initValue){
		return descriptionFieldOfLevelThreeDepartment("description",initValue);
	}
	public EmployeeForm descriptionFieldOfLevelThreeDepartment(){
		return descriptionFieldOfLevelThreeDepartment("description","");
	}


	public EmployeeForm foundedFieldOfLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  foundedFromLevelThreeDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm foundedFieldOfLevelThreeDepartment(String initValue){
		return foundedFieldOfLevelThreeDepartment("founded",initValue);
	}
	public EmployeeForm foundedFieldOfLevelThreeDepartment(){
		return foundedFieldOfLevelThreeDepartment("founded","");
	}


	public EmployeeForm occupationTypeIdFieldOfOccupationType(String parameterName, String initValue){
		FormField field =  idFromOccupationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm occupationTypeIdFieldOfOccupationType(String initValue){
		return occupationTypeIdFieldOfOccupationType("occupationTypeId",initValue);
	}
	public EmployeeForm occupationTypeIdFieldOfOccupationType(){
		return occupationTypeIdFieldOfOccupationType("occupationTypeId","");
	}


	public EmployeeForm codeFieldOfOccupationType(String parameterName, String initValue){
		FormField field =  codeFromOccupationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm codeFieldOfOccupationType(String initValue){
		return codeFieldOfOccupationType("code",initValue);
	}
	public EmployeeForm codeFieldOfOccupationType(){
		return codeFieldOfOccupationType("code","");
	}


	public EmployeeForm companyIdFieldOfOccupationType(String parameterName, String initValue){
		FormField field =  companyIdFromOccupationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm companyIdFieldOfOccupationType(String initValue){
		return companyIdFieldOfOccupationType("companyId",initValue);
	}
	public EmployeeForm companyIdFieldOfOccupationType(){
		return companyIdFieldOfOccupationType("companyId","");
	}


	public EmployeeForm descriptionFieldOfOccupationType(String parameterName, String initValue){
		FormField field =  descriptionFromOccupationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm descriptionFieldOfOccupationType(String initValue){
		return descriptionFieldOfOccupationType("description",initValue);
	}
	public EmployeeForm descriptionFieldOfOccupationType(){
		return descriptionFieldOfOccupationType("description","");
	}


	public EmployeeForm detailDescriptionFieldOfOccupationType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromOccupationType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm detailDescriptionFieldOfOccupationType(String initValue){
		return detailDescriptionFieldOfOccupationType("detailDescription",initValue);
	}
	public EmployeeForm detailDescriptionFieldOfOccupationType(){
		return detailDescriptionFieldOfOccupationType("detailDescription","");
	}


	public EmployeeForm responsibilityTypeIdFieldOfResponsibilityType(String parameterName, String initValue){
		FormField field =  idFromResponsibilityType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm responsibilityTypeIdFieldOfResponsibilityType(String initValue){
		return responsibilityTypeIdFieldOfResponsibilityType("responsibilityTypeId",initValue);
	}
	public EmployeeForm responsibilityTypeIdFieldOfResponsibilityType(){
		return responsibilityTypeIdFieldOfResponsibilityType("responsibilityTypeId","");
	}


	public EmployeeForm codeFieldOfResponsibilityType(String parameterName, String initValue){
		FormField field =  codeFromResponsibilityType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm codeFieldOfResponsibilityType(String initValue){
		return codeFieldOfResponsibilityType("code",initValue);
	}
	public EmployeeForm codeFieldOfResponsibilityType(){
		return codeFieldOfResponsibilityType("code","");
	}


	public EmployeeForm companyIdFieldOfResponsibilityType(String parameterName, String initValue){
		FormField field =  companyIdFromResponsibilityType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm companyIdFieldOfResponsibilityType(String initValue){
		return companyIdFieldOfResponsibilityType("companyId",initValue);
	}
	public EmployeeForm companyIdFieldOfResponsibilityType(){
		return companyIdFieldOfResponsibilityType("companyId","");
	}


	public EmployeeForm baseDescriptionFieldOfResponsibilityType(String parameterName, String initValue){
		FormField field =  baseDescriptionFromResponsibilityType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm baseDescriptionFieldOfResponsibilityType(String initValue){
		return baseDescriptionFieldOfResponsibilityType("baseDescription",initValue);
	}
	public EmployeeForm baseDescriptionFieldOfResponsibilityType(){
		return baseDescriptionFieldOfResponsibilityType("baseDescription","");
	}


	public EmployeeForm detailDescriptionFieldOfResponsibilityType(String parameterName, String initValue){
		FormField field =  detailDescriptionFromResponsibilityType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm detailDescriptionFieldOfResponsibilityType(String initValue){
		return detailDescriptionFieldOfResponsibilityType("detailDescription",initValue);
	}
	public EmployeeForm detailDescriptionFieldOfResponsibilityType(){
		return detailDescriptionFieldOfResponsibilityType("detailDescription","");
	}


	public EmployeeForm salaryGradeIdFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  idFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm salaryGradeIdFieldOfSalaryGrade(String initValue){
		return salaryGradeIdFieldOfSalaryGrade("salaryGradeId",initValue);
	}
	public EmployeeForm salaryGradeIdFieldOfSalaryGrade(){
		return salaryGradeIdFieldOfSalaryGrade("salaryGradeId","");
	}


	public EmployeeForm codeFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  codeFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm codeFieldOfSalaryGrade(String initValue){
		return codeFieldOfSalaryGrade("code",initValue);
	}
	public EmployeeForm codeFieldOfSalaryGrade(){
		return codeFieldOfSalaryGrade("code","");
	}


	public EmployeeForm companyIdFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  companyIdFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm companyIdFieldOfSalaryGrade(String initValue){
		return companyIdFieldOfSalaryGrade("companyId",initValue);
	}
	public EmployeeForm companyIdFieldOfSalaryGrade(){
		return companyIdFieldOfSalaryGrade("companyId","");
	}


	public EmployeeForm nameFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  nameFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm nameFieldOfSalaryGrade(String initValue){
		return nameFieldOfSalaryGrade("name",initValue);
	}
	public EmployeeForm nameFieldOfSalaryGrade(){
		return nameFieldOfSalaryGrade("name","");
	}


	public EmployeeForm detailDescriptionFieldOfSalaryGrade(String parameterName, String initValue){
		FormField field =  detailDescriptionFromSalaryGrade(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm detailDescriptionFieldOfSalaryGrade(String initValue){
		return detailDescriptionFieldOfSalaryGrade("detailDescription",initValue);
	}
	public EmployeeForm detailDescriptionFieldOfSalaryGrade(){
		return detailDescriptionFieldOfSalaryGrade("detailDescription","");
	}


	public EmployeeForm jobApplicationIdFieldOfJobApplication(String parameterName, String initValue){
		FormField field =  idFromJobApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm jobApplicationIdFieldOfJobApplication(String initValue){
		return jobApplicationIdFieldOfJobApplication("jobApplicationId",initValue);
	}
	public EmployeeForm jobApplicationIdFieldOfJobApplication(){
		return jobApplicationIdFieldOfJobApplication("jobApplicationId","");
	}


	public EmployeeForm applicationTimeFieldOfJobApplication(String parameterName, String initValue){
		FormField field =  applicationTimeFromJobApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm applicationTimeFieldOfJobApplication(String initValue){
		return applicationTimeFieldOfJobApplication("applicationTime",initValue);
	}
	public EmployeeForm applicationTimeFieldOfJobApplication(){
		return applicationTimeFieldOfJobApplication("applicationTime","");
	}


	public EmployeeForm whoFieldOfJobApplication(String parameterName, String initValue){
		FormField field =  whoFromJobApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm whoFieldOfJobApplication(String initValue){
		return whoFieldOfJobApplication("who",initValue);
	}
	public EmployeeForm whoFieldOfJobApplication(){
		return whoFieldOfJobApplication("who","");
	}


	public EmployeeForm commentsFieldOfJobApplication(String parameterName, String initValue){
		FormField field =  commentsFromJobApplication(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentsFieldOfJobApplication(String initValue){
		return commentsFieldOfJobApplication("comments",initValue);
	}
	public EmployeeForm commentsFieldOfJobApplication(){
		return commentsFieldOfJobApplication("comments","");
	}


	public EmployeeForm professionInterviewIdFieldOfProfessionInterview(String parameterName, String initValue){
		FormField field =  idFromProfessionInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm professionInterviewIdFieldOfProfessionInterview(String initValue){
		return professionInterviewIdFieldOfProfessionInterview("professionInterviewId",initValue);
	}
	public EmployeeForm professionInterviewIdFieldOfProfessionInterview(){
		return professionInterviewIdFieldOfProfessionInterview("professionInterviewId","");
	}


	public EmployeeForm whoFieldOfProfessionInterview(String parameterName, String initValue){
		FormField field =  whoFromProfessionInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm whoFieldOfProfessionInterview(String initValue){
		return whoFieldOfProfessionInterview("who",initValue);
	}
	public EmployeeForm whoFieldOfProfessionInterview(){
		return whoFieldOfProfessionInterview("who","");
	}


	public EmployeeForm interviewTimeFieldOfProfessionInterview(String parameterName, String initValue){
		FormField field =  interviewTimeFromProfessionInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm interviewTimeFieldOfProfessionInterview(String initValue){
		return interviewTimeFieldOfProfessionInterview("interviewTime",initValue);
	}
	public EmployeeForm interviewTimeFieldOfProfessionInterview(){
		return interviewTimeFieldOfProfessionInterview("interviewTime","");
	}


	public EmployeeForm commentsFieldOfProfessionInterview(String parameterName, String initValue){
		FormField field =  commentsFromProfessionInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentsFieldOfProfessionInterview(String initValue){
		return commentsFieldOfProfessionInterview("comments",initValue);
	}
	public EmployeeForm commentsFieldOfProfessionInterview(){
		return commentsFieldOfProfessionInterview("comments","");
	}


	public EmployeeForm hrInterviewIdFieldOfHrInterview(String parameterName, String initValue){
		FormField field =  idFromHrInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm hrInterviewIdFieldOfHrInterview(String initValue){
		return hrInterviewIdFieldOfHrInterview("hrInterviewId",initValue);
	}
	public EmployeeForm hrInterviewIdFieldOfHrInterview(){
		return hrInterviewIdFieldOfHrInterview("hrInterviewId","");
	}


	public EmployeeForm whoFieldOfHrInterview(String parameterName, String initValue){
		FormField field =  whoFromHrInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm whoFieldOfHrInterview(String initValue){
		return whoFieldOfHrInterview("who",initValue);
	}
	public EmployeeForm whoFieldOfHrInterview(){
		return whoFieldOfHrInterview("who","");
	}


	public EmployeeForm interviewTimeFieldOfHrInterview(String parameterName, String initValue){
		FormField field =  interviewTimeFromHrInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm interviewTimeFieldOfHrInterview(String initValue){
		return interviewTimeFieldOfHrInterview("interviewTime",initValue);
	}
	public EmployeeForm interviewTimeFieldOfHrInterview(){
		return interviewTimeFieldOfHrInterview("interviewTime","");
	}


	public EmployeeForm commentsFieldOfHrInterview(String parameterName, String initValue){
		FormField field =  commentsFromHrInterview(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentsFieldOfHrInterview(String initValue){
		return commentsFieldOfHrInterview("comments",initValue);
	}
	public EmployeeForm commentsFieldOfHrInterview(){
		return commentsFieldOfHrInterview("comments","");
	}


	public EmployeeForm offerApprovalIdFieldOfOfferApproval(String parameterName, String initValue){
		FormField field =  idFromOfferApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm offerApprovalIdFieldOfOfferApproval(String initValue){
		return offerApprovalIdFieldOfOfferApproval("offerApprovalId",initValue);
	}
	public EmployeeForm offerApprovalIdFieldOfOfferApproval(){
		return offerApprovalIdFieldOfOfferApproval("offerApprovalId","");
	}


	public EmployeeForm whoFieldOfOfferApproval(String parameterName, String initValue){
		FormField field =  whoFromOfferApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm whoFieldOfOfferApproval(String initValue){
		return whoFieldOfOfferApproval("who",initValue);
	}
	public EmployeeForm whoFieldOfOfferApproval(){
		return whoFieldOfOfferApproval("who","");
	}


	public EmployeeForm approveTimeFieldOfOfferApproval(String parameterName, String initValue){
		FormField field =  approveTimeFromOfferApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm approveTimeFieldOfOfferApproval(String initValue){
		return approveTimeFieldOfOfferApproval("approveTime",initValue);
	}
	public EmployeeForm approveTimeFieldOfOfferApproval(){
		return approveTimeFieldOfOfferApproval("approveTime","");
	}


	public EmployeeForm commentsFieldOfOfferApproval(String parameterName, String initValue){
		FormField field =  commentsFromOfferApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentsFieldOfOfferApproval(String initValue){
		return commentsFieldOfOfferApproval("comments",initValue);
	}
	public EmployeeForm commentsFieldOfOfferApproval(){
		return commentsFieldOfOfferApproval("comments","");
	}


	public EmployeeForm offerAcceptanceIdFieldOfOfferAcceptance(String parameterName, String initValue){
		FormField field =  idFromOfferAcceptance(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm offerAcceptanceIdFieldOfOfferAcceptance(String initValue){
		return offerAcceptanceIdFieldOfOfferAcceptance("offerAcceptanceId",initValue);
	}
	public EmployeeForm offerAcceptanceIdFieldOfOfferAcceptance(){
		return offerAcceptanceIdFieldOfOfferAcceptance("offerAcceptanceId","");
	}


	public EmployeeForm whoFieldOfOfferAcceptance(String parameterName, String initValue){
		FormField field =  whoFromOfferAcceptance(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm whoFieldOfOfferAcceptance(String initValue){
		return whoFieldOfOfferAcceptance("who",initValue);
	}
	public EmployeeForm whoFieldOfOfferAcceptance(){
		return whoFieldOfOfferAcceptance("who","");
	}


	public EmployeeForm acceptTimeFieldOfOfferAcceptance(String parameterName, String initValue){
		FormField field =  acceptTimeFromOfferAcceptance(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm acceptTimeFieldOfOfferAcceptance(String initValue){
		return acceptTimeFieldOfOfferAcceptance("acceptTime",initValue);
	}
	public EmployeeForm acceptTimeFieldOfOfferAcceptance(){
		return acceptTimeFieldOfOfferAcceptance("acceptTime","");
	}


	public EmployeeForm commentsFieldOfOfferAcceptance(String parameterName, String initValue){
		FormField field =  commentsFromOfferAcceptance(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentsFieldOfOfferAcceptance(String initValue){
		return commentsFieldOfOfferAcceptance("comments",initValue);
	}
	public EmployeeForm commentsFieldOfOfferAcceptance(){
		return commentsFieldOfOfferAcceptance("comments","");
	}


	public EmployeeForm employeeBoardingIdFieldOfEmployeeBoarding(String parameterName, String initValue){
		FormField field =  idFromEmployeeBoarding(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm employeeBoardingIdFieldOfEmployeeBoarding(String initValue){
		return employeeBoardingIdFieldOfEmployeeBoarding("employeeBoardingId",initValue);
	}
	public EmployeeForm employeeBoardingIdFieldOfEmployeeBoarding(){
		return employeeBoardingIdFieldOfEmployeeBoarding("employeeBoardingId","");
	}


	public EmployeeForm whoFieldOfEmployeeBoarding(String parameterName, String initValue){
		FormField field =  whoFromEmployeeBoarding(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm whoFieldOfEmployeeBoarding(String initValue){
		return whoFieldOfEmployeeBoarding("who",initValue);
	}
	public EmployeeForm whoFieldOfEmployeeBoarding(){
		return whoFieldOfEmployeeBoarding("who","");
	}


	public EmployeeForm employTimeFieldOfEmployeeBoarding(String parameterName, String initValue){
		FormField field =  employTimeFromEmployeeBoarding(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm employTimeFieldOfEmployeeBoarding(String initValue){
		return employTimeFieldOfEmployeeBoarding("employTime",initValue);
	}
	public EmployeeForm employTimeFieldOfEmployeeBoarding(){
		return employTimeFieldOfEmployeeBoarding("employTime","");
	}


	public EmployeeForm commentsFieldOfEmployeeBoarding(String parameterName, String initValue){
		FormField field =  commentsFromEmployeeBoarding(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentsFieldOfEmployeeBoarding(String initValue){
		return commentsFieldOfEmployeeBoarding("comments",initValue);
	}
	public EmployeeForm commentsFieldOfEmployeeBoarding(){
		return commentsFieldOfEmployeeBoarding("comments","");
	}


	public EmployeeForm terminationIdFieldOfTermination(String parameterName, String initValue){
		FormField field =  idFromTermination(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm terminationIdFieldOfTermination(String initValue){
		return terminationIdFieldOfTermination("terminationId",initValue);
	}
	public EmployeeForm terminationIdFieldOfTermination(){
		return terminationIdFieldOfTermination("terminationId","");
	}


	public EmployeeForm reasonIdFieldOfTermination(String parameterName, String initValue){
		FormField field =  reasonIdFromTermination(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm reasonIdFieldOfTermination(String initValue){
		return reasonIdFieldOfTermination("reasonId",initValue);
	}
	public EmployeeForm reasonIdFieldOfTermination(){
		return reasonIdFieldOfTermination("reasonId","");
	}


	public EmployeeForm typeIdFieldOfTermination(String parameterName, String initValue){
		FormField field =  typeIdFromTermination(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm typeIdFieldOfTermination(String initValue){
		return typeIdFieldOfTermination("typeId",initValue);
	}
	public EmployeeForm typeIdFieldOfTermination(){
		return typeIdFieldOfTermination("typeId","");
	}


	public EmployeeForm commentFieldOfTermination(String parameterName, String initValue){
		FormField field =  commentFromTermination(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public EmployeeForm commentFieldOfTermination(String initValue){
		return commentFieldOfTermination("comment",initValue);
	}
	public EmployeeForm commentFieldOfTermination(){
		return commentFieldOfTermination("comment","");
	}

	



	public EmployeeForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(String initValue){
		return employeeCompanyTrainingIdFieldForEmployeeCompanyTraining("employeeCompanyTrainingId",initValue);
	}
	public EmployeeForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(){
		return employeeCompanyTrainingIdFieldForEmployeeCompanyTraining("employeeCompanyTrainingId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeCompanyTraining(String initValue){
		return employeeIdFieldForEmployeeCompanyTraining("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeCompanyTraining(){
		return employeeIdFieldForEmployeeCompanyTraining("employeeId","");
	}


	public EmployeeForm trainingIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm trainingIdFieldForEmployeeCompanyTraining(String initValue){
		return trainingIdFieldForEmployeeCompanyTraining("trainingId",initValue);
	}
	public EmployeeForm trainingIdFieldForEmployeeCompanyTraining(){
		return trainingIdFieldForEmployeeCompanyTraining("trainingId","");
	}


	public EmployeeForm scoringIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  scoringIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm scoringIdFieldForEmployeeCompanyTraining(String initValue){
		return scoringIdFieldForEmployeeCompanyTraining("scoringId",initValue);
	}
	public EmployeeForm scoringIdFieldForEmployeeCompanyTraining(){
		return scoringIdFieldForEmployeeCompanyTraining("scoringId","");
	}


	public EmployeeForm currentStatusFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm currentStatusFieldForEmployeeCompanyTraining(String initValue){
		return currentStatusFieldForEmployeeCompanyTraining("currentStatus",initValue);
	}
	public EmployeeForm currentStatusFieldForEmployeeCompanyTraining(){
		return currentStatusFieldForEmployeeCompanyTraining("currentStatus","");
	}


	public EmployeeForm employeeSkillIdFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  idFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeSkillIdFieldForEmployeeSkill(String initValue){
		return employeeSkillIdFieldForEmployeeSkill("employeeSkillId",initValue);
	}
	public EmployeeForm employeeSkillIdFieldForEmployeeSkill(){
		return employeeSkillIdFieldForEmployeeSkill("employeeSkillId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeSkill(String initValue){
		return employeeIdFieldForEmployeeSkill("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeSkill(){
		return employeeIdFieldForEmployeeSkill("employeeId","");
	}


	public EmployeeForm skillTypeIdFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  skillTypeIdFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm skillTypeIdFieldForEmployeeSkill(String initValue){
		return skillTypeIdFieldForEmployeeSkill("skillTypeId",initValue);
	}
	public EmployeeForm skillTypeIdFieldForEmployeeSkill(){
		return skillTypeIdFieldForEmployeeSkill("skillTypeId","");
	}


	public EmployeeForm descriptionFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  descriptionFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm descriptionFieldForEmployeeSkill(String initValue){
		return descriptionFieldForEmployeeSkill("description",initValue);
	}
	public EmployeeForm descriptionFieldForEmployeeSkill(){
		return descriptionFieldForEmployeeSkill("description","");
	}


	public EmployeeForm employeePerformanceIdFieldForEmployeePerformance(String parameterName, String initValue){
		FormField field =  idFromEmployeePerformance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeePerformanceIdFieldForEmployeePerformance(String initValue){
		return employeePerformanceIdFieldForEmployeePerformance("employeePerformanceId",initValue);
	}
	public EmployeeForm employeePerformanceIdFieldForEmployeePerformance(){
		return employeePerformanceIdFieldForEmployeePerformance("employeePerformanceId","");
	}


	public EmployeeForm employeeIdFieldForEmployeePerformance(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeePerformance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeePerformance(String initValue){
		return employeeIdFieldForEmployeePerformance("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeePerformance(){
		return employeeIdFieldForEmployeePerformance("employeeId","");
	}


	public EmployeeForm performanceCommentFieldForEmployeePerformance(String parameterName, String initValue){
		FormField field =  performanceCommentFromEmployeePerformance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm performanceCommentFieldForEmployeePerformance(String initValue){
		return performanceCommentFieldForEmployeePerformance("performanceComment",initValue);
	}
	public EmployeeForm performanceCommentFieldForEmployeePerformance(){
		return performanceCommentFieldForEmployeePerformance("performanceComment","");
	}


	public EmployeeForm employeeWorkExperienceIdFieldForEmployeeWorkExperience(String parameterName, String initValue){
		FormField field =  idFromEmployeeWorkExperience(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeWorkExperienceIdFieldForEmployeeWorkExperience(String initValue){
		return employeeWorkExperienceIdFieldForEmployeeWorkExperience("employeeWorkExperienceId",initValue);
	}
	public EmployeeForm employeeWorkExperienceIdFieldForEmployeeWorkExperience(){
		return employeeWorkExperienceIdFieldForEmployeeWorkExperience("employeeWorkExperienceId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeWorkExperience(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeWorkExperience(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeWorkExperience(String initValue){
		return employeeIdFieldForEmployeeWorkExperience("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeWorkExperience(){
		return employeeIdFieldForEmployeeWorkExperience("employeeId","");
	}


	public EmployeeForm startFieldForEmployeeWorkExperience(String parameterName, String initValue){
		FormField field =  startFromEmployeeWorkExperience(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm startFieldForEmployeeWorkExperience(String initValue){
		return startFieldForEmployeeWorkExperience("start",initValue);
	}
	public EmployeeForm startFieldForEmployeeWorkExperience(){
		return startFieldForEmployeeWorkExperience("start","");
	}


	public EmployeeForm endFieldForEmployeeWorkExperience(String parameterName, String initValue){
		FormField field =  endFromEmployeeWorkExperience(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm endFieldForEmployeeWorkExperience(String initValue){
		return endFieldForEmployeeWorkExperience("end",initValue);
	}
	public EmployeeForm endFieldForEmployeeWorkExperience(){
		return endFieldForEmployeeWorkExperience("end","");
	}


	public EmployeeForm companyFieldForEmployeeWorkExperience(String parameterName, String initValue){
		FormField field =  companyFromEmployeeWorkExperience(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm companyFieldForEmployeeWorkExperience(String initValue){
		return companyFieldForEmployeeWorkExperience("company",initValue);
	}
	public EmployeeForm companyFieldForEmployeeWorkExperience(){
		return companyFieldForEmployeeWorkExperience("company","");
	}


	public EmployeeForm descriptionFieldForEmployeeWorkExperience(String parameterName, String initValue){
		FormField field =  descriptionFromEmployeeWorkExperience(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm descriptionFieldForEmployeeWorkExperience(String initValue){
		return descriptionFieldForEmployeeWorkExperience("description",initValue);
	}
	public EmployeeForm descriptionFieldForEmployeeWorkExperience(){
		return descriptionFieldForEmployeeWorkExperience("description","");
	}


	public EmployeeForm employeeLeaveIdFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  idFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeLeaveIdFieldForEmployeeLeave(String initValue){
		return employeeLeaveIdFieldForEmployeeLeave("employeeLeaveId",initValue);
	}
	public EmployeeForm employeeLeaveIdFieldForEmployeeLeave(){
		return employeeLeaveIdFieldForEmployeeLeave("employeeLeaveId","");
	}


	public EmployeeForm whoIdFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  whoIdFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm whoIdFieldForEmployeeLeave(String initValue){
		return whoIdFieldForEmployeeLeave("whoId",initValue);
	}
	public EmployeeForm whoIdFieldForEmployeeLeave(){
		return whoIdFieldForEmployeeLeave("whoId","");
	}


	public EmployeeForm typeIdFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  typeIdFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm typeIdFieldForEmployeeLeave(String initValue){
		return typeIdFieldForEmployeeLeave("typeId",initValue);
	}
	public EmployeeForm typeIdFieldForEmployeeLeave(){
		return typeIdFieldForEmployeeLeave("typeId","");
	}


	public EmployeeForm leaveDurationHourFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  leaveDurationHourFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm leaveDurationHourFieldForEmployeeLeave(String initValue){
		return leaveDurationHourFieldForEmployeeLeave("leaveDurationHour",initValue);
	}
	public EmployeeForm leaveDurationHourFieldForEmployeeLeave(){
		return leaveDurationHourFieldForEmployeeLeave("leaveDurationHour","");
	}


	public EmployeeForm remarkFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm remarkFieldForEmployeeLeave(String initValue){
		return remarkFieldForEmployeeLeave("remark",initValue);
	}
	public EmployeeForm remarkFieldForEmployeeLeave(){
		return remarkFieldForEmployeeLeave("remark","");
	}


	public EmployeeForm employeeInterviewIdFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  idFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeInterviewIdFieldForEmployeeInterview(String initValue){
		return employeeInterviewIdFieldForEmployeeInterview("employeeInterviewId",initValue);
	}
	public EmployeeForm employeeInterviewIdFieldForEmployeeInterview(){
		return employeeInterviewIdFieldForEmployeeInterview("employeeInterviewId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeInterview(String initValue){
		return employeeIdFieldForEmployeeInterview("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeInterview(){
		return employeeIdFieldForEmployeeInterview("employeeId","");
	}


	public EmployeeForm interviewTypeIdFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  interviewTypeIdFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm interviewTypeIdFieldForEmployeeInterview(String initValue){
		return interviewTypeIdFieldForEmployeeInterview("interviewTypeId",initValue);
	}
	public EmployeeForm interviewTypeIdFieldForEmployeeInterview(){
		return interviewTypeIdFieldForEmployeeInterview("interviewTypeId","");
	}


	public EmployeeForm remarkFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm remarkFieldForEmployeeInterview(String initValue){
		return remarkFieldForEmployeeInterview("remark",initValue);
	}
	public EmployeeForm remarkFieldForEmployeeInterview(){
		return remarkFieldForEmployeeInterview("remark","");
	}


	public EmployeeForm employeeAttendanceIdFieldForEmployeeAttendance(String parameterName, String initValue){
		FormField field =  idFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeAttendanceIdFieldForEmployeeAttendance(String initValue){
		return employeeAttendanceIdFieldForEmployeeAttendance("employeeAttendanceId",initValue);
	}
	public EmployeeForm employeeAttendanceIdFieldForEmployeeAttendance(){
		return employeeAttendanceIdFieldForEmployeeAttendance("employeeAttendanceId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeAttendance(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeAttendance(String initValue){
		return employeeIdFieldForEmployeeAttendance("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeAttendance(){
		return employeeIdFieldForEmployeeAttendance("employeeId","");
	}


	public EmployeeForm enterTimeFieldForEmployeeAttendance(String parameterName, String initValue){
		FormField field =  enterTimeFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm enterTimeFieldForEmployeeAttendance(String initValue){
		return enterTimeFieldForEmployeeAttendance("enterTime",initValue);
	}
	public EmployeeForm enterTimeFieldForEmployeeAttendance(){
		return enterTimeFieldForEmployeeAttendance("enterTime","");
	}


	public EmployeeForm leaveTimeFieldForEmployeeAttendance(String parameterName, String initValue){
		FormField field =  leaveTimeFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm leaveTimeFieldForEmployeeAttendance(String initValue){
		return leaveTimeFieldForEmployeeAttendance("leaveTime",initValue);
	}
	public EmployeeForm leaveTimeFieldForEmployeeAttendance(){
		return leaveTimeFieldForEmployeeAttendance("leaveTime","");
	}


	public EmployeeForm durationHoursFieldForEmployeeAttendance(String parameterName, String initValue){
		FormField field =  durationHoursFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm durationHoursFieldForEmployeeAttendance(String initValue){
		return durationHoursFieldForEmployeeAttendance("durationHours",initValue);
	}
	public EmployeeForm durationHoursFieldForEmployeeAttendance(){
		return durationHoursFieldForEmployeeAttendance("durationHours","");
	}


	public EmployeeForm remarkFieldForEmployeeAttendance(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeAttendance(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm remarkFieldForEmployeeAttendance(String initValue){
		return remarkFieldForEmployeeAttendance("remark",initValue);
	}
	public EmployeeForm remarkFieldForEmployeeAttendance(){
		return remarkFieldForEmployeeAttendance("remark","");
	}


	public EmployeeForm employeeQualifierIdFieldForEmployeeQualifier(String parameterName, String initValue){
		FormField field =  idFromEmployeeQualifier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeQualifierIdFieldForEmployeeQualifier(String initValue){
		return employeeQualifierIdFieldForEmployeeQualifier("employeeQualifierId",initValue);
	}
	public EmployeeForm employeeQualifierIdFieldForEmployeeQualifier(){
		return employeeQualifierIdFieldForEmployeeQualifier("employeeQualifierId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeQualifier(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeQualifier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeQualifier(String initValue){
		return employeeIdFieldForEmployeeQualifier("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeQualifier(){
		return employeeIdFieldForEmployeeQualifier("employeeId","");
	}


	public EmployeeForm qualifiedTimeFieldForEmployeeQualifier(String parameterName, String initValue){
		FormField field =  qualifiedTimeFromEmployeeQualifier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm qualifiedTimeFieldForEmployeeQualifier(String initValue){
		return qualifiedTimeFieldForEmployeeQualifier("qualifiedTime",initValue);
	}
	public EmployeeForm qualifiedTimeFieldForEmployeeQualifier(){
		return qualifiedTimeFieldForEmployeeQualifier("qualifiedTime","");
	}


	public EmployeeForm typeFieldForEmployeeQualifier(String parameterName, String initValue){
		FormField field =  typeFromEmployeeQualifier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm typeFieldForEmployeeQualifier(String initValue){
		return typeFieldForEmployeeQualifier("type",initValue);
	}
	public EmployeeForm typeFieldForEmployeeQualifier(){
		return typeFieldForEmployeeQualifier("type","");
	}


	public EmployeeForm levelFieldForEmployeeQualifier(String parameterName, String initValue){
		FormField field =  levelFromEmployeeQualifier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm levelFieldForEmployeeQualifier(String initValue){
		return levelFieldForEmployeeQualifier("level",initValue);
	}
	public EmployeeForm levelFieldForEmployeeQualifier(){
		return levelFieldForEmployeeQualifier("level","");
	}


	public EmployeeForm remarkFieldForEmployeeQualifier(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeQualifier(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm remarkFieldForEmployeeQualifier(String initValue){
		return remarkFieldForEmployeeQualifier("remark",initValue);
	}
	public EmployeeForm remarkFieldForEmployeeQualifier(){
		return remarkFieldForEmployeeQualifier("remark","");
	}


	public EmployeeForm employeeEducationIdFieldForEmployeeEducation(String parameterName, String initValue){
		FormField field =  idFromEmployeeEducation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeEducationIdFieldForEmployeeEducation(String initValue){
		return employeeEducationIdFieldForEmployeeEducation("employeeEducationId",initValue);
	}
	public EmployeeForm employeeEducationIdFieldForEmployeeEducation(){
		return employeeEducationIdFieldForEmployeeEducation("employeeEducationId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeEducation(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeEducation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeEducation(String initValue){
		return employeeIdFieldForEmployeeEducation("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeEducation(){
		return employeeIdFieldForEmployeeEducation("employeeId","");
	}


	public EmployeeForm completeTimeFieldForEmployeeEducation(String parameterName, String initValue){
		FormField field =  completeTimeFromEmployeeEducation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm completeTimeFieldForEmployeeEducation(String initValue){
		return completeTimeFieldForEmployeeEducation("completeTime",initValue);
	}
	public EmployeeForm completeTimeFieldForEmployeeEducation(){
		return completeTimeFieldForEmployeeEducation("completeTime","");
	}


	public EmployeeForm typeFieldForEmployeeEducation(String parameterName, String initValue){
		FormField field =  typeFromEmployeeEducation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm typeFieldForEmployeeEducation(String initValue){
		return typeFieldForEmployeeEducation("type",initValue);
	}
	public EmployeeForm typeFieldForEmployeeEducation(){
		return typeFieldForEmployeeEducation("type","");
	}


	public EmployeeForm remarkFieldForEmployeeEducation(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeEducation(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm remarkFieldForEmployeeEducation(String initValue){
		return remarkFieldForEmployeeEducation("remark",initValue);
	}
	public EmployeeForm remarkFieldForEmployeeEducation(){
		return remarkFieldForEmployeeEducation("remark","");
	}


	public EmployeeForm employeeAwardIdFieldForEmployeeAward(String parameterName, String initValue){
		FormField field =  idFromEmployeeAward(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeAwardIdFieldForEmployeeAward(String initValue){
		return employeeAwardIdFieldForEmployeeAward("employeeAwardId",initValue);
	}
	public EmployeeForm employeeAwardIdFieldForEmployeeAward(){
		return employeeAwardIdFieldForEmployeeAward("employeeAwardId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeAward(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeAward(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeAward(String initValue){
		return employeeIdFieldForEmployeeAward("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeAward(){
		return employeeIdFieldForEmployeeAward("employeeId","");
	}


	public EmployeeForm completeTimeFieldForEmployeeAward(String parameterName, String initValue){
		FormField field =  completeTimeFromEmployeeAward(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm completeTimeFieldForEmployeeAward(String initValue){
		return completeTimeFieldForEmployeeAward("completeTime",initValue);
	}
	public EmployeeForm completeTimeFieldForEmployeeAward(){
		return completeTimeFieldForEmployeeAward("completeTime","");
	}


	public EmployeeForm typeFieldForEmployeeAward(String parameterName, String initValue){
		FormField field =  typeFromEmployeeAward(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm typeFieldForEmployeeAward(String initValue){
		return typeFieldForEmployeeAward("type",initValue);
	}
	public EmployeeForm typeFieldForEmployeeAward(){
		return typeFieldForEmployeeAward("type","");
	}


	public EmployeeForm remarkFieldForEmployeeAward(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeAward(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm remarkFieldForEmployeeAward(String initValue){
		return remarkFieldForEmployeeAward("remark",initValue);
	}
	public EmployeeForm remarkFieldForEmployeeAward(){
		return remarkFieldForEmployeeAward("remark","");
	}


	public EmployeeForm employeeSalarySheetIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  idFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeSalarySheetIdFieldForEmployeeSalarySheet(String initValue){
		return employeeSalarySheetIdFieldForEmployeeSalarySheet("employeeSalarySheetId",initValue);
	}
	public EmployeeForm employeeSalarySheetIdFieldForEmployeeSalarySheet(){
		return employeeSalarySheetIdFieldForEmployeeSalarySheet("employeeSalarySheetId","");
	}


	public EmployeeForm employeeIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm employeeIdFieldForEmployeeSalarySheet(String initValue){
		return employeeIdFieldForEmployeeSalarySheet("employeeId",initValue);
	}
	public EmployeeForm employeeIdFieldForEmployeeSalarySheet(){
		return employeeIdFieldForEmployeeSalarySheet("employeeId","");
	}


	public EmployeeForm currentSalaryGradeIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm currentSalaryGradeIdFieldForEmployeeSalarySheet(String initValue){
		return currentSalaryGradeIdFieldForEmployeeSalarySheet("currentSalaryGradeId",initValue);
	}
	public EmployeeForm currentSalaryGradeIdFieldForEmployeeSalarySheet(){
		return currentSalaryGradeIdFieldForEmployeeSalarySheet("currentSalaryGradeId","");
	}


	public EmployeeForm baseSalaryFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  baseSalaryFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm baseSalaryFieldForEmployeeSalarySheet(String initValue){
		return baseSalaryFieldForEmployeeSalarySheet("baseSalary",initValue);
	}
	public EmployeeForm baseSalaryFieldForEmployeeSalarySheet(){
		return baseSalaryFieldForEmployeeSalarySheet("baseSalary","");
	}


	public EmployeeForm bonusFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  bonusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm bonusFieldForEmployeeSalarySheet(String initValue){
		return bonusFieldForEmployeeSalarySheet("bonus",initValue);
	}
	public EmployeeForm bonusFieldForEmployeeSalarySheet(){
		return bonusFieldForEmployeeSalarySheet("bonus","");
	}


	public EmployeeForm rewardFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  rewardFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm rewardFieldForEmployeeSalarySheet(String initValue){
		return rewardFieldForEmployeeSalarySheet("reward",initValue);
	}
	public EmployeeForm rewardFieldForEmployeeSalarySheet(){
		return rewardFieldForEmployeeSalarySheet("reward","");
	}


	public EmployeeForm personalTaxFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  personalTaxFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm personalTaxFieldForEmployeeSalarySheet(String initValue){
		return personalTaxFieldForEmployeeSalarySheet("personalTax",initValue);
	}
	public EmployeeForm personalTaxFieldForEmployeeSalarySheet(){
		return personalTaxFieldForEmployeeSalarySheet("personalTax","");
	}


	public EmployeeForm socialSecurityFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  socialSecurityFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm socialSecurityFieldForEmployeeSalarySheet(String initValue){
		return socialSecurityFieldForEmployeeSalarySheet("socialSecurity",initValue);
	}
	public EmployeeForm socialSecurityFieldForEmployeeSalarySheet(){
		return socialSecurityFieldForEmployeeSalarySheet("socialSecurity","");
	}


	public EmployeeForm housingFoundFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  housingFoundFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm housingFoundFieldForEmployeeSalarySheet(String initValue){
		return housingFoundFieldForEmployeeSalarySheet("housingFound",initValue);
	}
	public EmployeeForm housingFoundFieldForEmployeeSalarySheet(){
		return housingFoundFieldForEmployeeSalarySheet("housingFound","");
	}


	public EmployeeForm jobInsuranceFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  jobInsuranceFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm jobInsuranceFieldForEmployeeSalarySheet(String initValue){
		return jobInsuranceFieldForEmployeeSalarySheet("jobInsurance",initValue);
	}
	public EmployeeForm jobInsuranceFieldForEmployeeSalarySheet(){
		return jobInsuranceFieldForEmployeeSalarySheet("jobInsurance","");
	}


	public EmployeeForm payingOffIdFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  payingOffIdFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm payingOffIdFieldForEmployeeSalarySheet(String initValue){
		return payingOffIdFieldForEmployeeSalarySheet("payingOffId",initValue);
	}
	public EmployeeForm payingOffIdFieldForEmployeeSalarySheet(){
		return payingOffIdFieldForEmployeeSalarySheet("payingOffId","");
	}


	public EmployeeForm currentStatusFieldForEmployeeSalarySheet(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployeeSalarySheet(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm currentStatusFieldForEmployeeSalarySheet(String initValue){
		return currentStatusFieldForEmployeeSalarySheet("currentStatus",initValue);
	}
	public EmployeeForm currentStatusFieldForEmployeeSalarySheet(){
		return currentStatusFieldForEmployeeSalarySheet("currentStatus","");
	}


	public EmployeeForm payingOffIdFieldForPayingOff(String parameterName, String initValue){
		FormField field =  idFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm payingOffIdFieldForPayingOff(String initValue){
		return payingOffIdFieldForPayingOff("payingOffId",initValue);
	}
	public EmployeeForm payingOffIdFieldForPayingOff(){
		return payingOffIdFieldForPayingOff("payingOffId","");
	}


	public EmployeeForm whoFieldForPayingOff(String parameterName, String initValue){
		FormField field =  whoFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm whoFieldForPayingOff(String initValue){
		return whoFieldForPayingOff("who",initValue);
	}
	public EmployeeForm whoFieldForPayingOff(){
		return whoFieldForPayingOff("who","");
	}


	public EmployeeForm paidForIdFieldForPayingOff(String parameterName, String initValue){
		FormField field =  paidForIdFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm paidForIdFieldForPayingOff(String initValue){
		return paidForIdFieldForPayingOff("paidForId",initValue);
	}
	public EmployeeForm paidForIdFieldForPayingOff(){
		return paidForIdFieldForPayingOff("paidForId","");
	}


	public EmployeeForm paidTimeFieldForPayingOff(String parameterName, String initValue){
		FormField field =  paidTimeFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm paidTimeFieldForPayingOff(String initValue){
		return paidTimeFieldForPayingOff("paidTime",initValue);
	}
	public EmployeeForm paidTimeFieldForPayingOff(){
		return paidTimeFieldForPayingOff("paidTime","");
	}


	public EmployeeForm amountFieldForPayingOff(String parameterName, String initValue){
		FormField field =  amountFromPayingOff(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public EmployeeForm amountFieldForPayingOff(String initValue){
		return amountFieldForPayingOff("amount",initValue);
	}
	public EmployeeForm amountFieldForPayingOff(){
		return amountFieldForPayingOff("amount","");
	}

	

	
 	public EmployeeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/employeeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeForm transferToAnotherDepartmentAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDepartment/employeeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeForm transferToAnotherOccupationAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOccupation/employeeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeForm transferToAnotherResponsibleForAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherResponsibleFor/employeeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeForm transferToAnotherCurrentSalaryGradeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCurrentSalaryGrade/employeeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public EmployeeForm  applyJobAction(){
		FormAction action = new FormAction();
		action.setLabel("Apply Job");
		action.setLocaleKey("employee.applyJob");
		action.setUrl("employeeManager/applyJob/employeeId/applicationTime/who/comments/");
		this.addFormAction(action);
		return this;
	}	
 	public EmployeeForm  interviewWithProfessionAction(){
		FormAction action = new FormAction();
		action.setLabel("Interview With Profession");
		action.setLocaleKey("employee.interviewWithProfession");
		action.setUrl("employeeManager/interviewWithProfession/employeeId/who/interviewTime/comments/");
		this.addFormAction(action);
		return this;
	}	
 	public EmployeeForm  interviewByHrAction(){
		FormAction action = new FormAction();
		action.setLabel("Interview By Hr");
		action.setLocaleKey("employee.interviewByHr");
		action.setUrl("employeeManager/interviewByHr/employeeId/who/interviewTime/comments/");
		this.addFormAction(action);
		return this;
	}	
 	public EmployeeForm  approveOfferAction(){
		FormAction action = new FormAction();
		action.setLabel("Approve Offer");
		action.setLocaleKey("employee.approveOffer");
		action.setUrl("employeeManager/approveOffer/employeeId/who/approveTime/comments/");
		this.addFormAction(action);
		return this;
	}	
 	public EmployeeForm  acceptOfferAction(){
		FormAction action = new FormAction();
		action.setLabel("Accept Offer");
		action.setLocaleKey("employee.acceptOffer");
		action.setUrl("employeeManager/acceptOffer/employeeId/who/acceptTime/comments/");
		this.addFormAction(action);
		return this;
	}	
 	public EmployeeForm  boardEmployeeAction(){
		FormAction action = new FormAction();
		action.setLabel("Board Employee");
		action.setLocaleKey("employee.boardEmployee");
		action.setUrl("employeeManager/boardEmployee/employeeId/who/employTime/comments/");
		this.addFormAction(action);
		return this;
	}	
 	public EmployeeForm  terminateAction(){
		FormAction action = new FormAction();
		action.setLabel("Terminate");
		action.setLocaleKey("employee.terminate");
		action.setUrl("employeeManager/terminate/employeeId/reasonIdtypeIdcomment/");
		this.addFormAction(action);
		return this;
	}

	public EmployeeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



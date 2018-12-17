package com.doublechaintech.retailscm.levelthreedepartment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LevelThreeDepartmentForm extends BaseForm {
	
	
	public LevelThreeDepartmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelThreeDepartmentForm levelThreeDepartmentIdField(String parameterName, String initValue){
		FormField field = idFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm levelThreeDepartmentIdField(String initValue){
		return levelThreeDepartmentIdField("levelThreeDepartmentId",initValue);
	}
	public LevelThreeDepartmentForm levelThreeDepartmentIdField(){
		return levelThreeDepartmentIdField("levelThreeDepartmentId","");
	}


	public LevelThreeDepartmentForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public LevelThreeDepartmentForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public LevelThreeDepartmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelThreeDepartmentForm nameField(){
		return nameField("name","");
	}


	public LevelThreeDepartmentForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public LevelThreeDepartmentForm descriptionField(){
		return descriptionField("description","");
	}


	public LevelThreeDepartmentForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public LevelThreeDepartmentForm foundedField(){
		return foundedField("founded","");
	}

	
	


	public LevelThreeDepartmentForm levelTwoDepartmentIdFieldOfLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  idFromLevelTwoDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeDepartmentForm levelTwoDepartmentIdFieldOfLevelTwoDepartment(String initValue){
		return levelTwoDepartmentIdFieldOfLevelTwoDepartment("levelTwoDepartmentId",initValue);
	}
	public LevelThreeDepartmentForm levelTwoDepartmentIdFieldOfLevelTwoDepartment(){
		return levelTwoDepartmentIdFieldOfLevelTwoDepartment("levelTwoDepartmentId","");
	}


	public LevelThreeDepartmentForm belongsToIdFieldOfLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  belongsToIdFromLevelTwoDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeDepartmentForm belongsToIdFieldOfLevelTwoDepartment(String initValue){
		return belongsToIdFieldOfLevelTwoDepartment("belongsToId",initValue);
	}
	public LevelThreeDepartmentForm belongsToIdFieldOfLevelTwoDepartment(){
		return belongsToIdFieldOfLevelTwoDepartment("belongsToId","");
	}


	public LevelThreeDepartmentForm nameFieldOfLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  nameFromLevelTwoDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeDepartmentForm nameFieldOfLevelTwoDepartment(String initValue){
		return nameFieldOfLevelTwoDepartment("name",initValue);
	}
	public LevelThreeDepartmentForm nameFieldOfLevelTwoDepartment(){
		return nameFieldOfLevelTwoDepartment("name","");
	}


	public LevelThreeDepartmentForm descriptionFieldOfLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  descriptionFromLevelTwoDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeDepartmentForm descriptionFieldOfLevelTwoDepartment(String initValue){
		return descriptionFieldOfLevelTwoDepartment("description",initValue);
	}
	public LevelThreeDepartmentForm descriptionFieldOfLevelTwoDepartment(){
		return descriptionFieldOfLevelTwoDepartment("description","");
	}


	public LevelThreeDepartmentForm foundedFieldOfLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  foundedFromLevelTwoDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeDepartmentForm foundedFieldOfLevelTwoDepartment(String initValue){
		return foundedFieldOfLevelTwoDepartment("founded",initValue);
	}
	public LevelThreeDepartmentForm foundedFieldOfLevelTwoDepartment(){
		return foundedFieldOfLevelTwoDepartment("founded","");
	}

	



	public LevelThreeDepartmentForm employeeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  idFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm employeeIdFieldForEmployee(String initValue){
		return employeeIdFieldForEmployee("employeeId",initValue);
	}
	public LevelThreeDepartmentForm employeeIdFieldForEmployee(){
		return employeeIdFieldForEmployee("employeeId","");
	}


	public LevelThreeDepartmentForm companyIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  companyIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm companyIdFieldForEmployee(String initValue){
		return companyIdFieldForEmployee("companyId",initValue);
	}
	public LevelThreeDepartmentForm companyIdFieldForEmployee(){
		return companyIdFieldForEmployee("companyId","");
	}


	public LevelThreeDepartmentForm titleFieldForEmployee(String parameterName, String initValue){
		FormField field =  titleFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm titleFieldForEmployee(String initValue){
		return titleFieldForEmployee("title",initValue);
	}
	public LevelThreeDepartmentForm titleFieldForEmployee(){
		return titleFieldForEmployee("title","");
	}


	public LevelThreeDepartmentForm departmentIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm departmentIdFieldForEmployee(String initValue){
		return departmentIdFieldForEmployee("departmentId",initValue);
	}
	public LevelThreeDepartmentForm departmentIdFieldForEmployee(){
		return departmentIdFieldForEmployee("departmentId","");
	}


	public LevelThreeDepartmentForm familyNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  familyNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm familyNameFieldForEmployee(String initValue){
		return familyNameFieldForEmployee("familyName",initValue);
	}
	public LevelThreeDepartmentForm familyNameFieldForEmployee(){
		return familyNameFieldForEmployee("familyName","");
	}


	public LevelThreeDepartmentForm givenNameFieldForEmployee(String parameterName, String initValue){
		FormField field =  givenNameFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm givenNameFieldForEmployee(String initValue){
		return givenNameFieldForEmployee("givenName",initValue);
	}
	public LevelThreeDepartmentForm givenNameFieldForEmployee(){
		return givenNameFieldForEmployee("givenName","");
	}


	public LevelThreeDepartmentForm emailFieldForEmployee(String parameterName, String initValue){
		FormField field =  emailFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm emailFieldForEmployee(String initValue){
		return emailFieldForEmployee("email",initValue);
	}
	public LevelThreeDepartmentForm emailFieldForEmployee(){
		return emailFieldForEmployee("email","");
	}


	public LevelThreeDepartmentForm cityFieldForEmployee(String parameterName, String initValue){
		FormField field =  cityFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm cityFieldForEmployee(String initValue){
		return cityFieldForEmployee("city",initValue);
	}
	public LevelThreeDepartmentForm cityFieldForEmployee(){
		return cityFieldForEmployee("city","");
	}


	public LevelThreeDepartmentForm addressFieldForEmployee(String parameterName, String initValue){
		FormField field =  addressFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm addressFieldForEmployee(String initValue){
		return addressFieldForEmployee("address",initValue);
	}
	public LevelThreeDepartmentForm addressFieldForEmployee(){
		return addressFieldForEmployee("address","");
	}


	public LevelThreeDepartmentForm cellPhoneFieldForEmployee(String parameterName, String initValue){
		FormField field =  cellPhoneFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm cellPhoneFieldForEmployee(String initValue){
		return cellPhoneFieldForEmployee("cellPhone",initValue);
	}
	public LevelThreeDepartmentForm cellPhoneFieldForEmployee(){
		return cellPhoneFieldForEmployee("cellPhone","");
	}


	public LevelThreeDepartmentForm occupationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  occupationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm occupationIdFieldForEmployee(String initValue){
		return occupationIdFieldForEmployee("occupationId",initValue);
	}
	public LevelThreeDepartmentForm occupationIdFieldForEmployee(){
		return occupationIdFieldForEmployee("occupationId","");
	}


	public LevelThreeDepartmentForm responsibleForIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  responsibleForIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm responsibleForIdFieldForEmployee(String initValue){
		return responsibleForIdFieldForEmployee("responsibleForId",initValue);
	}
	public LevelThreeDepartmentForm responsibleForIdFieldForEmployee(){
		return responsibleForIdFieldForEmployee("responsibleForId","");
	}


	public LevelThreeDepartmentForm currentSalaryGradeIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentSalaryGradeIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm currentSalaryGradeIdFieldForEmployee(String initValue){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId",initValue);
	}
	public LevelThreeDepartmentForm currentSalaryGradeIdFieldForEmployee(){
		return currentSalaryGradeIdFieldForEmployee("currentSalaryGradeId","");
	}


	public LevelThreeDepartmentForm salaryAccountFieldForEmployee(String parameterName, String initValue){
		FormField field =  salaryAccountFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm salaryAccountFieldForEmployee(String initValue){
		return salaryAccountFieldForEmployee("salaryAccount",initValue);
	}
	public LevelThreeDepartmentForm salaryAccountFieldForEmployee(){
		return salaryAccountFieldForEmployee("salaryAccount","");
	}


	public LevelThreeDepartmentForm jobApplicationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  jobApplicationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm jobApplicationIdFieldForEmployee(String initValue){
		return jobApplicationIdFieldForEmployee("jobApplicationId",initValue);
	}
	public LevelThreeDepartmentForm jobApplicationIdFieldForEmployee(){
		return jobApplicationIdFieldForEmployee("jobApplicationId","");
	}


	public LevelThreeDepartmentForm professionInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  professionInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm professionInterviewIdFieldForEmployee(String initValue){
		return professionInterviewIdFieldForEmployee("professionInterviewId",initValue);
	}
	public LevelThreeDepartmentForm professionInterviewIdFieldForEmployee(){
		return professionInterviewIdFieldForEmployee("professionInterviewId","");
	}


	public LevelThreeDepartmentForm hrInterviewIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  hrInterviewIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm hrInterviewIdFieldForEmployee(String initValue){
		return hrInterviewIdFieldForEmployee("hrInterviewId",initValue);
	}
	public LevelThreeDepartmentForm hrInterviewIdFieldForEmployee(){
		return hrInterviewIdFieldForEmployee("hrInterviewId","");
	}


	public LevelThreeDepartmentForm offerApprovalIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerApprovalIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm offerApprovalIdFieldForEmployee(String initValue){
		return offerApprovalIdFieldForEmployee("offerApprovalId",initValue);
	}
	public LevelThreeDepartmentForm offerApprovalIdFieldForEmployee(){
		return offerApprovalIdFieldForEmployee("offerApprovalId","");
	}


	public LevelThreeDepartmentForm offerAcceptanceIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  offerAcceptanceIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm offerAcceptanceIdFieldForEmployee(String initValue){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId",initValue);
	}
	public LevelThreeDepartmentForm offerAcceptanceIdFieldForEmployee(){
		return offerAcceptanceIdFieldForEmployee("offerAcceptanceId","");
	}


	public LevelThreeDepartmentForm employeeBoardingIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  employeeBoardingIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm employeeBoardingIdFieldForEmployee(String initValue){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId",initValue);
	}
	public LevelThreeDepartmentForm employeeBoardingIdFieldForEmployee(){
		return employeeBoardingIdFieldForEmployee("employeeBoardingId","");
	}


	public LevelThreeDepartmentForm terminationIdFieldForEmployee(String parameterName, String initValue){
		FormField field =  terminationIdFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm terminationIdFieldForEmployee(String initValue){
		return terminationIdFieldForEmployee("terminationId",initValue);
	}
	public LevelThreeDepartmentForm terminationIdFieldForEmployee(){
		return terminationIdFieldForEmployee("terminationId","");
	}


	public LevelThreeDepartmentForm lastUpdateTimeFieldForEmployee(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm lastUpdateTimeFieldForEmployee(String initValue){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime",initValue);
	}
	public LevelThreeDepartmentForm lastUpdateTimeFieldForEmployee(){
		return lastUpdateTimeFieldForEmployee("lastUpdateTime","");
	}


	public LevelThreeDepartmentForm currentStatusFieldForEmployee(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeDepartmentForm currentStatusFieldForEmployee(String initValue){
		return currentStatusFieldForEmployee("currentStatus",initValue);
	}
	public LevelThreeDepartmentForm currentStatusFieldForEmployee(){
		return currentStatusFieldForEmployee("currentStatus","");
	}

	

	
 	public LevelThreeDepartmentForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/levelThreeDepartmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelThreeDepartmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



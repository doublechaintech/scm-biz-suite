package com.doublechaintech.retailscm.companytraining;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class CompanyTrainingForm extends BaseForm {
	
	
	public CompanyTrainingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CompanyTrainingForm companyTrainingIdField(String parameterName, String initValue){
		FormField field = idFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm companyTrainingIdField(String initValue){
		return companyTrainingIdField("companyTrainingId",initValue);
	}
	public CompanyTrainingForm companyTrainingIdField(){
		return companyTrainingIdField("companyTrainingId","");
	}


	public CompanyTrainingForm titleField(String parameterName, String initValue){
		FormField field = titleFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public CompanyTrainingForm titleField(){
		return titleField("title","");
	}


	public CompanyTrainingForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public CompanyTrainingForm companyIdField(){
		return companyIdField("companyId","");
	}


	public CompanyTrainingForm instructorIdField(String parameterName, String initValue){
		FormField field = instructorIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm instructorIdField(String initValue){
		return instructorIdField("instructorId",initValue);
	}
	public CompanyTrainingForm instructorIdField(){
		return instructorIdField("instructorId","");
	}


	public CompanyTrainingForm trainingCourseTypeIdField(String parameterName, String initValue){
		FormField field = trainingCourseTypeIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm trainingCourseTypeIdField(String initValue){
		return trainingCourseTypeIdField("trainingCourseTypeId",initValue);
	}
	public CompanyTrainingForm trainingCourseTypeIdField(){
		return trainingCourseTypeIdField("trainingCourseTypeId","");
	}


	public CompanyTrainingForm timeStartField(String parameterName, String initValue){
		FormField field = timeStartFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm timeStartField(String initValue){
		return timeStartField("timeStart",initValue);
	}
	public CompanyTrainingForm timeStartField(){
		return timeStartField("timeStart","");
	}


	public CompanyTrainingForm durationHoursField(String parameterName, String initValue){
		FormField field = durationHoursFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm durationHoursField(String initValue){
		return durationHoursField("durationHours",initValue);
	}
	public CompanyTrainingForm durationHoursField(){
		return durationHoursField("durationHours","");
	}


	public CompanyTrainingForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public CompanyTrainingForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public CompanyTrainingForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public CompanyTrainingForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public CompanyTrainingForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public CompanyTrainingForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public CompanyTrainingForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public CompanyTrainingForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public CompanyTrainingForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public CompanyTrainingForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public CompanyTrainingForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public CompanyTrainingForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public CompanyTrainingForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public CompanyTrainingForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public CompanyTrainingForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public CompanyTrainingForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public CompanyTrainingForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public CompanyTrainingForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public CompanyTrainingForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public CompanyTrainingForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}


	public CompanyTrainingForm instructorIdFieldOfInstructor(String parameterName, String initValue){
		FormField field =  idFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm instructorIdFieldOfInstructor(String initValue){
		return instructorIdFieldOfInstructor("instructorId",initValue);
	}
	public CompanyTrainingForm instructorIdFieldOfInstructor(){
		return instructorIdFieldOfInstructor("instructorId","");
	}


	public CompanyTrainingForm titleFieldOfInstructor(String parameterName, String initValue){
		FormField field =  titleFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm titleFieldOfInstructor(String initValue){
		return titleFieldOfInstructor("title",initValue);
	}
	public CompanyTrainingForm titleFieldOfInstructor(){
		return titleFieldOfInstructor("title","");
	}


	public CompanyTrainingForm familyNameFieldOfInstructor(String parameterName, String initValue){
		FormField field =  familyNameFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm familyNameFieldOfInstructor(String initValue){
		return familyNameFieldOfInstructor("familyName",initValue);
	}
	public CompanyTrainingForm familyNameFieldOfInstructor(){
		return familyNameFieldOfInstructor("familyName","");
	}


	public CompanyTrainingForm givenNameFieldOfInstructor(String parameterName, String initValue){
		FormField field =  givenNameFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm givenNameFieldOfInstructor(String initValue){
		return givenNameFieldOfInstructor("givenName",initValue);
	}
	public CompanyTrainingForm givenNameFieldOfInstructor(){
		return givenNameFieldOfInstructor("givenName","");
	}


	public CompanyTrainingForm cellPhoneFieldOfInstructor(String parameterName, String initValue){
		FormField field =  cellPhoneFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm cellPhoneFieldOfInstructor(String initValue){
		return cellPhoneFieldOfInstructor("cellPhone",initValue);
	}
	public CompanyTrainingForm cellPhoneFieldOfInstructor(){
		return cellPhoneFieldOfInstructor("cellPhone","");
	}


	public CompanyTrainingForm emailFieldOfInstructor(String parameterName, String initValue){
		FormField field =  emailFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm emailFieldOfInstructor(String initValue){
		return emailFieldOfInstructor("email",initValue);
	}
	public CompanyTrainingForm emailFieldOfInstructor(){
		return emailFieldOfInstructor("email","");
	}


	public CompanyTrainingForm companyIdFieldOfInstructor(String parameterName, String initValue){
		FormField field =  companyIdFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm companyIdFieldOfInstructor(String initValue){
		return companyIdFieldOfInstructor("companyId",initValue);
	}
	public CompanyTrainingForm companyIdFieldOfInstructor(){
		return companyIdFieldOfInstructor("companyId","");
	}


	public CompanyTrainingForm introductionFieldOfInstructor(String parameterName, String initValue){
		FormField field =  introductionFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm introductionFieldOfInstructor(String initValue){
		return introductionFieldOfInstructor("introduction",initValue);
	}
	public CompanyTrainingForm introductionFieldOfInstructor(){
		return introductionFieldOfInstructor("introduction","");
	}


	public CompanyTrainingForm lastUpdateTimeFieldOfInstructor(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromInstructor(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm lastUpdateTimeFieldOfInstructor(String initValue){
		return lastUpdateTimeFieldOfInstructor("lastUpdateTime",initValue);
	}
	public CompanyTrainingForm lastUpdateTimeFieldOfInstructor(){
		return lastUpdateTimeFieldOfInstructor("lastUpdateTime","");
	}


	public CompanyTrainingForm trainingCourseTypeIdFieldOfTrainingCourseType(String parameterName, String initValue){
		FormField field =  idFromTrainingCourseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm trainingCourseTypeIdFieldOfTrainingCourseType(String initValue){
		return trainingCourseTypeIdFieldOfTrainingCourseType("trainingCourseTypeId",initValue);
	}
	public CompanyTrainingForm trainingCourseTypeIdFieldOfTrainingCourseType(){
		return trainingCourseTypeIdFieldOfTrainingCourseType("trainingCourseTypeId","");
	}


	public CompanyTrainingForm codeFieldOfTrainingCourseType(String parameterName, String initValue){
		FormField field =  codeFromTrainingCourseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm codeFieldOfTrainingCourseType(String initValue){
		return codeFieldOfTrainingCourseType("code",initValue);
	}
	public CompanyTrainingForm codeFieldOfTrainingCourseType(){
		return codeFieldOfTrainingCourseType("code","");
	}


	public CompanyTrainingForm companyIdFieldOfTrainingCourseType(String parameterName, String initValue){
		FormField field =  companyIdFromTrainingCourseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm companyIdFieldOfTrainingCourseType(String initValue){
		return companyIdFieldOfTrainingCourseType("companyId",initValue);
	}
	public CompanyTrainingForm companyIdFieldOfTrainingCourseType(){
		return companyIdFieldOfTrainingCourseType("companyId","");
	}


	public CompanyTrainingForm nameFieldOfTrainingCourseType(String parameterName, String initValue){
		FormField field =  nameFromTrainingCourseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm nameFieldOfTrainingCourseType(String initValue){
		return nameFieldOfTrainingCourseType("name",initValue);
	}
	public CompanyTrainingForm nameFieldOfTrainingCourseType(){
		return nameFieldOfTrainingCourseType("name","");
	}


	public CompanyTrainingForm descriptionFieldOfTrainingCourseType(String parameterName, String initValue){
		FormField field =  descriptionFromTrainingCourseType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CompanyTrainingForm descriptionFieldOfTrainingCourseType(String initValue){
		return descriptionFieldOfTrainingCourseType("description",initValue);
	}
	public CompanyTrainingForm descriptionFieldOfTrainingCourseType(){
		return descriptionFieldOfTrainingCourseType("description","");
	}

	



	public CompanyTrainingForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(String initValue){
		return employeeCompanyTrainingIdFieldForEmployeeCompanyTraining("employeeCompanyTrainingId",initValue);
	}
	public CompanyTrainingForm employeeCompanyTrainingIdFieldForEmployeeCompanyTraining(){
		return employeeCompanyTrainingIdFieldForEmployeeCompanyTraining("employeeCompanyTrainingId","");
	}


	public CompanyTrainingForm employeeIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm employeeIdFieldForEmployeeCompanyTraining(String initValue){
		return employeeIdFieldForEmployeeCompanyTraining("employeeId",initValue);
	}
	public CompanyTrainingForm employeeIdFieldForEmployeeCompanyTraining(){
		return employeeIdFieldForEmployeeCompanyTraining("employeeId","");
	}


	public CompanyTrainingForm trainingIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm trainingIdFieldForEmployeeCompanyTraining(String initValue){
		return trainingIdFieldForEmployeeCompanyTraining("trainingId",initValue);
	}
	public CompanyTrainingForm trainingIdFieldForEmployeeCompanyTraining(){
		return trainingIdFieldForEmployeeCompanyTraining("trainingId","");
	}


	public CompanyTrainingForm scoringIdFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  scoringIdFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm scoringIdFieldForEmployeeCompanyTraining(String initValue){
		return scoringIdFieldForEmployeeCompanyTraining("scoringId",initValue);
	}
	public CompanyTrainingForm scoringIdFieldForEmployeeCompanyTraining(){
		return scoringIdFieldForEmployeeCompanyTraining("scoringId","");
	}


	public CompanyTrainingForm currentStatusFieldForEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field =  currentStatusFromEmployeeCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CompanyTrainingForm currentStatusFieldForEmployeeCompanyTraining(String initValue){
		return currentStatusFieldForEmployeeCompanyTraining("currentStatus",initValue);
	}
	public CompanyTrainingForm currentStatusFieldForEmployeeCompanyTraining(){
		return currentStatusFieldForEmployeeCompanyTraining("currentStatus","");
	}

	

	
 	public CompanyTrainingForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/companyTrainingId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public CompanyTrainingForm transferToAnotherInstructorAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherInstructor/companyTrainingId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public CompanyTrainingForm transferToAnotherTrainingCourseTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherTrainingCourseType/companyTrainingId/");
		this.addFormAction(action);
		return this;
	}

 

	public CompanyTrainingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



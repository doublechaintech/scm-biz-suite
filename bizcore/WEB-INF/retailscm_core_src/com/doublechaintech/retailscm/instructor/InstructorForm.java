package com.doublechaintech.retailscm.instructor;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class InstructorForm extends BaseForm {
	
	
	public InstructorForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public InstructorForm instructorIdField(String parameterName, String initValue){
		FormField field = idFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm instructorIdField(String initValue){
		return instructorIdField("instructorId",initValue);
	}
	public InstructorForm instructorIdField(){
		return instructorIdField("instructorId","");
	}


	public InstructorForm titleField(String parameterName, String initValue){
		FormField field = titleFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public InstructorForm titleField(){
		return titleField("title","");
	}


	public InstructorForm familyNameField(String parameterName, String initValue){
		FormField field = familyNameFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm familyNameField(String initValue){
		return familyNameField("familyName",initValue);
	}
	public InstructorForm familyNameField(){
		return familyNameField("familyName","");
	}


	public InstructorForm givenNameField(String parameterName, String initValue){
		FormField field = givenNameFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm givenNameField(String initValue){
		return givenNameField("givenName",initValue);
	}
	public InstructorForm givenNameField(){
		return givenNameField("givenName","");
	}


	public InstructorForm cellPhoneField(String parameterName, String initValue){
		FormField field = cellPhoneFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm cellPhoneField(String initValue){
		return cellPhoneField("cellPhone",initValue);
	}
	public InstructorForm cellPhoneField(){
		return cellPhoneField("cellPhone","");
	}


	public InstructorForm emailField(String parameterName, String initValue){
		FormField field = emailFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm emailField(String initValue){
		return emailField("email",initValue);
	}
	public InstructorForm emailField(){
		return emailField("email","");
	}


	public InstructorForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public InstructorForm companyIdField(){
		return companyIdField("companyId","");
	}


	public InstructorForm introductionField(String parameterName, String initValue){
		FormField field = introductionFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm introductionField(String initValue){
		return introductionField("introduction",initValue);
	}
	public InstructorForm introductionField(){
		return introductionField("introduction","");
	}


	public InstructorForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromInstructor(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public InstructorForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public InstructorForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public InstructorForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public InstructorForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public InstructorForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public InstructorForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public InstructorForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public InstructorForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public InstructorForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public InstructorForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public InstructorForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public InstructorForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public InstructorForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public InstructorForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public InstructorForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public InstructorForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public InstructorForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public InstructorForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InstructorForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public InstructorForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public InstructorForm companyTrainingIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm companyTrainingIdFieldForCompanyTraining(String initValue){
		return companyTrainingIdFieldForCompanyTraining("companyTrainingId",initValue);
	}
	public InstructorForm companyTrainingIdFieldForCompanyTraining(){
		return companyTrainingIdFieldForCompanyTraining("companyTrainingId","");
	}


	public InstructorForm titleFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  titleFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm titleFieldForCompanyTraining(String initValue){
		return titleFieldForCompanyTraining("title",initValue);
	}
	public InstructorForm titleFieldForCompanyTraining(){
		return titleFieldForCompanyTraining("title","");
	}


	public InstructorForm companyIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  companyIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm companyIdFieldForCompanyTraining(String initValue){
		return companyIdFieldForCompanyTraining("companyId",initValue);
	}
	public InstructorForm companyIdFieldForCompanyTraining(){
		return companyIdFieldForCompanyTraining("companyId","");
	}


	public InstructorForm instructorIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  instructorIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm instructorIdFieldForCompanyTraining(String initValue){
		return instructorIdFieldForCompanyTraining("instructorId",initValue);
	}
	public InstructorForm instructorIdFieldForCompanyTraining(){
		return instructorIdFieldForCompanyTraining("instructorId","");
	}


	public InstructorForm trainingCourseTypeIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingCourseTypeIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm trainingCourseTypeIdFieldForCompanyTraining(String initValue){
		return trainingCourseTypeIdFieldForCompanyTraining("trainingCourseTypeId",initValue);
	}
	public InstructorForm trainingCourseTypeIdFieldForCompanyTraining(){
		return trainingCourseTypeIdFieldForCompanyTraining("trainingCourseTypeId","");
	}


	public InstructorForm timeStartFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  timeStartFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm timeStartFieldForCompanyTraining(String initValue){
		return timeStartFieldForCompanyTraining("timeStart",initValue);
	}
	public InstructorForm timeStartFieldForCompanyTraining(){
		return timeStartFieldForCompanyTraining("timeStart","");
	}


	public InstructorForm durationHoursFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  durationHoursFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm durationHoursFieldForCompanyTraining(String initValue){
		return durationHoursFieldForCompanyTraining("durationHours",initValue);
	}
	public InstructorForm durationHoursFieldForCompanyTraining(){
		return durationHoursFieldForCompanyTraining("durationHours","");
	}


	public InstructorForm lastUpdateTimeFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InstructorForm lastUpdateTimeFieldForCompanyTraining(String initValue){
		return lastUpdateTimeFieldForCompanyTraining("lastUpdateTime",initValue);
	}
	public InstructorForm lastUpdateTimeFieldForCompanyTraining(){
		return lastUpdateTimeFieldForCompanyTraining("lastUpdateTime","");
	}

	

	
 	public InstructorForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/instructorId/");
		this.addFormAction(action);
		return this;
	}

 

	public InstructorForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



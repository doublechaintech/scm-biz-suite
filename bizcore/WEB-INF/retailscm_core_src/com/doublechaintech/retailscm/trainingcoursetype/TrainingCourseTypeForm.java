package com.doublechaintech.retailscm.trainingcoursetype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TrainingCourseTypeForm extends BaseForm {
	
	
	public TrainingCourseTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TrainingCourseTypeForm trainingCourseTypeIdField(String parameterName, String initValue){
		FormField field = idFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm trainingCourseTypeIdField(String initValue){
		return trainingCourseTypeIdField("trainingCourseTypeId",initValue);
	}
	public TrainingCourseTypeForm trainingCourseTypeIdField(){
		return trainingCourseTypeIdField("trainingCourseTypeId","");
	}


	public TrainingCourseTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public TrainingCourseTypeForm codeField(){
		return codeField("code","");
	}


	public TrainingCourseTypeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public TrainingCourseTypeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public TrainingCourseTypeForm nameField(String parameterName, String initValue){
		FormField field = nameFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public TrainingCourseTypeForm nameField(){
		return nameField("name","");
	}


	public TrainingCourseTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromTrainingCourseType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public TrainingCourseTypeForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public TrainingCourseTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public TrainingCourseTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public TrainingCourseTypeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public TrainingCourseTypeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public TrainingCourseTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public TrainingCourseTypeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public TrainingCourseTypeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public TrainingCourseTypeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public TrainingCourseTypeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public TrainingCourseTypeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public TrainingCourseTypeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public TrainingCourseTypeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public TrainingCourseTypeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public TrainingCourseTypeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public TrainingCourseTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public TrainingCourseTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public TrainingCourseTypeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TrainingCourseTypeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public TrainingCourseTypeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public TrainingCourseTypeForm companyTrainingIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  idFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm companyTrainingIdFieldForCompanyTraining(String initValue){
		return companyTrainingIdFieldForCompanyTraining("companyTrainingId",initValue);
	}
	public TrainingCourseTypeForm companyTrainingIdFieldForCompanyTraining(){
		return companyTrainingIdFieldForCompanyTraining("companyTrainingId","");
	}


	public TrainingCourseTypeForm titleFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  titleFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm titleFieldForCompanyTraining(String initValue){
		return titleFieldForCompanyTraining("title",initValue);
	}
	public TrainingCourseTypeForm titleFieldForCompanyTraining(){
		return titleFieldForCompanyTraining("title","");
	}


	public TrainingCourseTypeForm companyIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  companyIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm companyIdFieldForCompanyTraining(String initValue){
		return companyIdFieldForCompanyTraining("companyId",initValue);
	}
	public TrainingCourseTypeForm companyIdFieldForCompanyTraining(){
		return companyIdFieldForCompanyTraining("companyId","");
	}


	public TrainingCourseTypeForm instructorIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  instructorIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm instructorIdFieldForCompanyTraining(String initValue){
		return instructorIdFieldForCompanyTraining("instructorId",initValue);
	}
	public TrainingCourseTypeForm instructorIdFieldForCompanyTraining(){
		return instructorIdFieldForCompanyTraining("instructorId","");
	}


	public TrainingCourseTypeForm trainingCourseTypeIdFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  trainingCourseTypeIdFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm trainingCourseTypeIdFieldForCompanyTraining(String initValue){
		return trainingCourseTypeIdFieldForCompanyTraining("trainingCourseTypeId",initValue);
	}
	public TrainingCourseTypeForm trainingCourseTypeIdFieldForCompanyTraining(){
		return trainingCourseTypeIdFieldForCompanyTraining("trainingCourseTypeId","");
	}


	public TrainingCourseTypeForm timeStartFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  timeStartFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm timeStartFieldForCompanyTraining(String initValue){
		return timeStartFieldForCompanyTraining("timeStart",initValue);
	}
	public TrainingCourseTypeForm timeStartFieldForCompanyTraining(){
		return timeStartFieldForCompanyTraining("timeStart","");
	}


	public TrainingCourseTypeForm durationHoursFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  durationHoursFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm durationHoursFieldForCompanyTraining(String initValue){
		return durationHoursFieldForCompanyTraining("durationHours",initValue);
	}
	public TrainingCourseTypeForm durationHoursFieldForCompanyTraining(){
		return durationHoursFieldForCompanyTraining("durationHours","");
	}


	public TrainingCourseTypeForm lastUpdateTimeFieldForCompanyTraining(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromCompanyTraining(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TrainingCourseTypeForm lastUpdateTimeFieldForCompanyTraining(String initValue){
		return lastUpdateTimeFieldForCompanyTraining("lastUpdateTime",initValue);
	}
	public TrainingCourseTypeForm lastUpdateTimeFieldForCompanyTraining(){
		return lastUpdateTimeFieldForCompanyTraining("lastUpdateTime","");
	}

	

	
 	public TrainingCourseTypeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/trainingCourseTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public TrainingCourseTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



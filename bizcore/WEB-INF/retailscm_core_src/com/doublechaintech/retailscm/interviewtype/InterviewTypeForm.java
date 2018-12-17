package com.doublechaintech.retailscm.interviewtype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class InterviewTypeForm extends BaseForm {
	
	
	public InterviewTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public InterviewTypeForm interviewTypeIdField(String parameterName, String initValue){
		FormField field = idFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm interviewTypeIdField(String initValue){
		return interviewTypeIdField("interviewTypeId",initValue);
	}
	public InterviewTypeForm interviewTypeIdField(){
		return interviewTypeIdField("interviewTypeId","");
	}


	public InterviewTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public InterviewTypeForm codeField(){
		return codeField("code","");
	}


	public InterviewTypeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public InterviewTypeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public InterviewTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public InterviewTypeForm descriptionField(){
		return descriptionField("description","");
	}


	public InterviewTypeForm detailDescriptionField(String parameterName, String initValue){
		FormField field = detailDescriptionFromInterviewType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm detailDescriptionField(String initValue){
		return detailDescriptionField("detailDescription",initValue);
	}
	public InterviewTypeForm detailDescriptionField(){
		return detailDescriptionField("detailDescription","");
	}

	
	


	public InterviewTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public InterviewTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public InterviewTypeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public InterviewTypeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public InterviewTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public InterviewTypeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public InterviewTypeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public InterviewTypeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public InterviewTypeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public InterviewTypeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public InterviewTypeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public InterviewTypeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public InterviewTypeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public InterviewTypeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public InterviewTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public InterviewTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public InterviewTypeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public InterviewTypeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public InterviewTypeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public InterviewTypeForm employeeInterviewIdFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  idFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm employeeInterviewIdFieldForEmployeeInterview(String initValue){
		return employeeInterviewIdFieldForEmployeeInterview("employeeInterviewId",initValue);
	}
	public InterviewTypeForm employeeInterviewIdFieldForEmployeeInterview(){
		return employeeInterviewIdFieldForEmployeeInterview("employeeInterviewId","");
	}


	public InterviewTypeForm employeeIdFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm employeeIdFieldForEmployeeInterview(String initValue){
		return employeeIdFieldForEmployeeInterview("employeeId",initValue);
	}
	public InterviewTypeForm employeeIdFieldForEmployeeInterview(){
		return employeeIdFieldForEmployeeInterview("employeeId","");
	}


	public InterviewTypeForm interviewTypeIdFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  interviewTypeIdFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm interviewTypeIdFieldForEmployeeInterview(String initValue){
		return interviewTypeIdFieldForEmployeeInterview("interviewTypeId",initValue);
	}
	public InterviewTypeForm interviewTypeIdFieldForEmployeeInterview(){
		return interviewTypeIdFieldForEmployeeInterview("interviewTypeId","");
	}


	public InterviewTypeForm remarkFieldForEmployeeInterview(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeInterview(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public InterviewTypeForm remarkFieldForEmployeeInterview(String initValue){
		return remarkFieldForEmployeeInterview("remark",initValue);
	}
	public InterviewTypeForm remarkFieldForEmployeeInterview(){
		return remarkFieldForEmployeeInterview("remark","");
	}

	

	
 	public InterviewTypeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/interviewTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public InterviewTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



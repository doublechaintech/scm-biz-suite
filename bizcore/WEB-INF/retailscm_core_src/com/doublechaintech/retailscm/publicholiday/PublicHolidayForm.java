package com.doublechaintech.retailscm.publicholiday;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class PublicHolidayForm extends BaseForm {
	
	
	public PublicHolidayForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PublicHolidayForm publicHolidayIdField(String parameterName, String initValue){
		FormField field = idFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PublicHolidayForm publicHolidayIdField(String initValue){
		return publicHolidayIdField("publicHolidayId",initValue);
	}
	public PublicHolidayForm publicHolidayIdField(){
		return publicHolidayIdField("publicHolidayId","");
	}


	public PublicHolidayForm codeField(String parameterName, String initValue){
		FormField field = codeFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PublicHolidayForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public PublicHolidayForm codeField(){
		return codeField("code","");
	}


	public PublicHolidayForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PublicHolidayForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public PublicHolidayForm companyIdField(){
		return companyIdField("companyId","");
	}


	public PublicHolidayForm nameField(String parameterName, String initValue){
		FormField field = nameFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PublicHolidayForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PublicHolidayForm nameField(){
		return nameField("name","");
	}


	public PublicHolidayForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromPublicHoliday(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PublicHolidayForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public PublicHolidayForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public PublicHolidayForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public PublicHolidayForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public PublicHolidayForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public PublicHolidayForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public PublicHolidayForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public PublicHolidayForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public PublicHolidayForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public PublicHolidayForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public PublicHolidayForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public PublicHolidayForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public PublicHolidayForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public PublicHolidayForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public PublicHolidayForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public PublicHolidayForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public PublicHolidayForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public PublicHolidayForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public PublicHolidayForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public PublicHolidayForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public PublicHolidayForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	


	

	
 	public PublicHolidayForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/publicHolidayId/");
		this.addFormAction(action);
		return this;
	}

 

	public PublicHolidayForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



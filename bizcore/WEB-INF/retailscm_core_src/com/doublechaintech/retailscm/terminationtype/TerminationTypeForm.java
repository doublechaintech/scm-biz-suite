package com.doublechaintech.retailscm.terminationtype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TerminationTypeForm extends BaseForm {
	
	
	public TerminationTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TerminationTypeForm terminationTypeIdField(String parameterName, String initValue){
		FormField field = idFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm terminationTypeIdField(String initValue){
		return terminationTypeIdField("terminationTypeId",initValue);
	}
	public TerminationTypeForm terminationTypeIdField(){
		return terminationTypeIdField("terminationTypeId","");
	}


	public TerminationTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public TerminationTypeForm codeField(){
		return codeField("code","");
	}


	public TerminationTypeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public TerminationTypeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public TerminationTypeForm baseDescriptionField(String parameterName, String initValue){
		FormField field = baseDescriptionFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm baseDescriptionField(String initValue){
		return baseDescriptionField("baseDescription",initValue);
	}
	public TerminationTypeForm baseDescriptionField(){
		return baseDescriptionField("baseDescription","");
	}


	public TerminationTypeForm detailDescriptionField(String parameterName, String initValue){
		FormField field = detailDescriptionFromTerminationType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm detailDescriptionField(String initValue){
		return detailDescriptionField("detailDescription",initValue);
	}
	public TerminationTypeForm detailDescriptionField(){
		return detailDescriptionField("detailDescription","");
	}

	
	


	public TerminationTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public TerminationTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public TerminationTypeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public TerminationTypeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public TerminationTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public TerminationTypeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public TerminationTypeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public TerminationTypeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public TerminationTypeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public TerminationTypeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public TerminationTypeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public TerminationTypeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public TerminationTypeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public TerminationTypeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public TerminationTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public TerminationTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public TerminationTypeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationTypeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public TerminationTypeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public TerminationTypeForm terminationIdFieldForTermination(String parameterName, String initValue){
		FormField field =  idFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm terminationIdFieldForTermination(String initValue){
		return terminationIdFieldForTermination("terminationId",initValue);
	}
	public TerminationTypeForm terminationIdFieldForTermination(){
		return terminationIdFieldForTermination("terminationId","");
	}


	public TerminationTypeForm reasonIdFieldForTermination(String parameterName, String initValue){
		FormField field =  reasonIdFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm reasonIdFieldForTermination(String initValue){
		return reasonIdFieldForTermination("reasonId",initValue);
	}
	public TerminationTypeForm reasonIdFieldForTermination(){
		return reasonIdFieldForTermination("reasonId","");
	}


	public TerminationTypeForm typeIdFieldForTermination(String parameterName, String initValue){
		FormField field =  typeIdFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm typeIdFieldForTermination(String initValue){
		return typeIdFieldForTermination("typeId",initValue);
	}
	public TerminationTypeForm typeIdFieldForTermination(){
		return typeIdFieldForTermination("typeId","");
	}


	public TerminationTypeForm commentFieldForTermination(String parameterName, String initValue){
		FormField field =  commentFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationTypeForm commentFieldForTermination(String initValue){
		return commentFieldForTermination("comment",initValue);
	}
	public TerminationTypeForm commentFieldForTermination(){
		return commentFieldForTermination("comment","");
	}

	

	
 	public TerminationTypeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/terminationTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public TerminationTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



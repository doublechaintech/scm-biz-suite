package com.doublechaintech.retailscm.terminationreason;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class TerminationReasonForm extends BaseForm {
	
	
	public TerminationReasonForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public TerminationReasonForm terminationReasonIdField(String parameterName, String initValue){
		FormField field = idFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm terminationReasonIdField(String initValue){
		return terminationReasonIdField("terminationReasonId",initValue);
	}
	public TerminationReasonForm terminationReasonIdField(){
		return terminationReasonIdField("terminationReasonId","");
	}


	public TerminationReasonForm codeField(String parameterName, String initValue){
		FormField field = codeFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public TerminationReasonForm codeField(){
		return codeField("code","");
	}


	public TerminationReasonForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public TerminationReasonForm companyIdField(){
		return companyIdField("companyId","");
	}


	public TerminationReasonForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromTerminationReason(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public TerminationReasonForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public TerminationReasonForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public TerminationReasonForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public TerminationReasonForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public TerminationReasonForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public TerminationReasonForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public TerminationReasonForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public TerminationReasonForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public TerminationReasonForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public TerminationReasonForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public TerminationReasonForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public TerminationReasonForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public TerminationReasonForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public TerminationReasonForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public TerminationReasonForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public TerminationReasonForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public TerminationReasonForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public TerminationReasonForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public TerminationReasonForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public TerminationReasonForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public TerminationReasonForm terminationIdFieldForTermination(String parameterName, String initValue){
		FormField field =  idFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm terminationIdFieldForTermination(String initValue){
		return terminationIdFieldForTermination("terminationId",initValue);
	}
	public TerminationReasonForm terminationIdFieldForTermination(){
		return terminationIdFieldForTermination("terminationId","");
	}


	public TerminationReasonForm reasonIdFieldForTermination(String parameterName, String initValue){
		FormField field =  reasonIdFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm reasonIdFieldForTermination(String initValue){
		return reasonIdFieldForTermination("reasonId",initValue);
	}
	public TerminationReasonForm reasonIdFieldForTermination(){
		return reasonIdFieldForTermination("reasonId","");
	}


	public TerminationReasonForm typeIdFieldForTermination(String parameterName, String initValue){
		FormField field =  typeIdFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm typeIdFieldForTermination(String initValue){
		return typeIdFieldForTermination("typeId",initValue);
	}
	public TerminationReasonForm typeIdFieldForTermination(){
		return typeIdFieldForTermination("typeId","");
	}


	public TerminationReasonForm commentFieldForTermination(String parameterName, String initValue){
		FormField field =  commentFromTermination(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public TerminationReasonForm commentFieldForTermination(String initValue){
		return commentFieldForTermination("comment",initValue);
	}
	public TerminationReasonForm commentFieldForTermination(){
		return commentFieldForTermination("comment","");
	}

	

	
 	public TerminationReasonForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/terminationReasonId/");
		this.addFormAction(action);
		return this;
	}

 

	public TerminationReasonForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



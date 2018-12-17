package com.doublechaintech.retailscm.skilltype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SkillTypeForm extends BaseForm {
	
	
	public SkillTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SkillTypeForm skillTypeIdField(String parameterName, String initValue){
		FormField field = idFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm skillTypeIdField(String initValue){
		return skillTypeIdField("skillTypeId",initValue);
	}
	public SkillTypeForm skillTypeIdField(){
		return skillTypeIdField("skillTypeId","");
	}


	public SkillTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public SkillTypeForm codeField(){
		return codeField("code","");
	}


	public SkillTypeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public SkillTypeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public SkillTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromSkillType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public SkillTypeForm descriptionField(){
		return descriptionField("description","");
	}

	
	


	public SkillTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public SkillTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public SkillTypeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public SkillTypeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public SkillTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public SkillTypeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public SkillTypeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public SkillTypeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public SkillTypeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public SkillTypeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public SkillTypeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public SkillTypeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public SkillTypeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public SkillTypeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public SkillTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public SkillTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public SkillTypeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SkillTypeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public SkillTypeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public SkillTypeForm employeeSkillIdFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  idFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm employeeSkillIdFieldForEmployeeSkill(String initValue){
		return employeeSkillIdFieldForEmployeeSkill("employeeSkillId",initValue);
	}
	public SkillTypeForm employeeSkillIdFieldForEmployeeSkill(){
		return employeeSkillIdFieldForEmployeeSkill("employeeSkillId","");
	}


	public SkillTypeForm employeeIdFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  employeeIdFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm employeeIdFieldForEmployeeSkill(String initValue){
		return employeeIdFieldForEmployeeSkill("employeeId",initValue);
	}
	public SkillTypeForm employeeIdFieldForEmployeeSkill(){
		return employeeIdFieldForEmployeeSkill("employeeId","");
	}


	public SkillTypeForm skillTypeIdFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  skillTypeIdFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm skillTypeIdFieldForEmployeeSkill(String initValue){
		return skillTypeIdFieldForEmployeeSkill("skillTypeId",initValue);
	}
	public SkillTypeForm skillTypeIdFieldForEmployeeSkill(){
		return skillTypeIdFieldForEmployeeSkill("skillTypeId","");
	}


	public SkillTypeForm descriptionFieldForEmployeeSkill(String parameterName, String initValue){
		FormField field =  descriptionFromEmployeeSkill(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SkillTypeForm descriptionFieldForEmployeeSkill(String initValue){
		return descriptionFieldForEmployeeSkill("description",initValue);
	}
	public SkillTypeForm descriptionFieldForEmployeeSkill(){
		return descriptionFieldForEmployeeSkill("description","");
	}

	

	
 	public SkillTypeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/skillTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public SkillTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



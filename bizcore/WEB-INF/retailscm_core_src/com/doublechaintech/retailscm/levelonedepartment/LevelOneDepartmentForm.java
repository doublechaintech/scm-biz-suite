package com.doublechaintech.retailscm.levelonedepartment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LevelOneDepartmentForm extends BaseForm {
	
	
	public LevelOneDepartmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelOneDepartmentForm levelOneDepartmentIdField(String parameterName, String initValue){
		FormField field = idFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm levelOneDepartmentIdField(String initValue){
		return levelOneDepartmentIdField("levelOneDepartmentId",initValue);
	}
	public LevelOneDepartmentForm levelOneDepartmentIdField(){
		return levelOneDepartmentIdField("levelOneDepartmentId","");
	}


	public LevelOneDepartmentForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public LevelOneDepartmentForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public LevelOneDepartmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelOneDepartmentForm nameField(){
		return nameField("name","");
	}


	public LevelOneDepartmentForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public LevelOneDepartmentForm descriptionField(){
		return descriptionField("description","");
	}


	public LevelOneDepartmentForm managerField(String parameterName, String initValue){
		FormField field = managerFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm managerField(String initValue){
		return managerField("manager",initValue);
	}
	public LevelOneDepartmentForm managerField(){
		return managerField("manager","");
	}


	public LevelOneDepartmentForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromLevelOneDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public LevelOneDepartmentForm foundedField(){
		return foundedField("founded","");
	}

	
	


	public LevelOneDepartmentForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public LevelOneDepartmentForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public LevelOneDepartmentForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public LevelOneDepartmentForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public LevelOneDepartmentForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public LevelOneDepartmentForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public LevelOneDepartmentForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public LevelOneDepartmentForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public LevelOneDepartmentForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public LevelOneDepartmentForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public LevelOneDepartmentForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public LevelOneDepartmentForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public LevelOneDepartmentForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public LevelOneDepartmentForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public LevelOneDepartmentForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public LevelOneDepartmentForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public LevelOneDepartmentForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneDepartmentForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public LevelOneDepartmentForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public LevelOneDepartmentForm levelTwoDepartmentIdFieldForLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  idFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm levelTwoDepartmentIdFieldForLevelTwoDepartment(String initValue){
		return levelTwoDepartmentIdFieldForLevelTwoDepartment("levelTwoDepartmentId",initValue);
	}
	public LevelOneDepartmentForm levelTwoDepartmentIdFieldForLevelTwoDepartment(){
		return levelTwoDepartmentIdFieldForLevelTwoDepartment("levelTwoDepartmentId","");
	}


	public LevelOneDepartmentForm belongsToIdFieldForLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  belongsToIdFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm belongsToIdFieldForLevelTwoDepartment(String initValue){
		return belongsToIdFieldForLevelTwoDepartment("belongsToId",initValue);
	}
	public LevelOneDepartmentForm belongsToIdFieldForLevelTwoDepartment(){
		return belongsToIdFieldForLevelTwoDepartment("belongsToId","");
	}


	public LevelOneDepartmentForm nameFieldForLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  nameFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm nameFieldForLevelTwoDepartment(String initValue){
		return nameFieldForLevelTwoDepartment("name",initValue);
	}
	public LevelOneDepartmentForm nameFieldForLevelTwoDepartment(){
		return nameFieldForLevelTwoDepartment("name","");
	}


	public LevelOneDepartmentForm descriptionFieldForLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  descriptionFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm descriptionFieldForLevelTwoDepartment(String initValue){
		return descriptionFieldForLevelTwoDepartment("description",initValue);
	}
	public LevelOneDepartmentForm descriptionFieldForLevelTwoDepartment(){
		return descriptionFieldForLevelTwoDepartment("description","");
	}


	public LevelOneDepartmentForm foundedFieldForLevelTwoDepartment(String parameterName, String initValue){
		FormField field =  foundedFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneDepartmentForm foundedFieldForLevelTwoDepartment(String initValue){
		return foundedFieldForLevelTwoDepartment("founded",initValue);
	}
	public LevelOneDepartmentForm foundedFieldForLevelTwoDepartment(){
		return foundedFieldForLevelTwoDepartment("founded","");
	}

	

	
 	public LevelOneDepartmentForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/levelOneDepartmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelOneDepartmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.catalog;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class CatalogForm extends BaseForm {
	
	
	public CatalogForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public CatalogForm catalogIdField(String parameterName, String initValue){
		FormField field = idFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public CatalogForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public CatalogForm nameField(String parameterName, String initValue){
		FormField field = nameFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public CatalogForm nameField(){
		return nameField("name","");
	}


	public CatalogForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromCatalog(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public CatalogForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public CatalogForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public CatalogForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public CatalogForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public CatalogForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public CatalogForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public CatalogForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public CatalogForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public CatalogForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public CatalogForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public CatalogForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public CatalogForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public CatalogForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public CatalogForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public CatalogForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public CatalogForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public CatalogForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public CatalogForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public CatalogForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public CatalogForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  idFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(String initValue){
		return levelOneCategoryIdFieldForLevelOneCategory("levelOneCategoryId",initValue);
	}
	public CatalogForm levelOneCategoryIdFieldForLevelOneCategory(){
		return levelOneCategoryIdFieldForLevelOneCategory("levelOneCategoryId","");
	}


	public CatalogForm catalogIdFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  catalogIdFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm catalogIdFieldForLevelOneCategory(String initValue){
		return catalogIdFieldForLevelOneCategory("catalogId",initValue);
	}
	public CatalogForm catalogIdFieldForLevelOneCategory(){
		return catalogIdFieldForLevelOneCategory("catalogId","");
	}


	public CatalogForm nameFieldForLevelOneCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public CatalogForm nameFieldForLevelOneCategory(String initValue){
		return nameFieldForLevelOneCategory("name",initValue);
	}
	public CatalogForm nameFieldForLevelOneCategory(){
		return nameFieldForLevelOneCategory("name","");
	}

	

	
 	public CatalogForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/catalogId/");
		this.addFormAction(action);
		return this;
	}

 

	public CatalogForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



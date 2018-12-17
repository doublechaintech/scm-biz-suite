package com.doublechaintech.retailscm.retailstoreprovincecenter;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreProvinceCenterForm extends BaseForm {
	
	
	public RetailStoreProvinceCenterForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreProvinceCenterForm retailStoreProvinceCenterIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm retailStoreProvinceCenterIdField(String initValue){
		return retailStoreProvinceCenterIdField("retailStoreProvinceCenterId",initValue);
	}
	public RetailStoreProvinceCenterForm retailStoreProvinceCenterIdField(){
		return retailStoreProvinceCenterIdField("retailStoreProvinceCenterId","");
	}


	public RetailStoreProvinceCenterForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreProvinceCenterForm nameField(){
		return nameField("name","");
	}


	public RetailStoreProvinceCenterForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public RetailStoreProvinceCenterForm foundedField(){
		return foundedField("founded","");
	}


	public RetailStoreProvinceCenterForm countryIdField(String parameterName, String initValue){
		FormField field = countryIdFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm countryIdField(String initValue){
		return countryIdField("countryId",initValue);
	}
	public RetailStoreProvinceCenterForm countryIdField(){
		return countryIdField("countryId","");
	}


	public RetailStoreProvinceCenterForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromRetailStoreProvinceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public RetailStoreProvinceCenterForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public RetailStoreProvinceCenterForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreProvinceCenterForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public RetailStoreProvinceCenterForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public RetailStoreProvinceCenterForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public RetailStoreProvinceCenterForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public RetailStoreProvinceCenterForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public RetailStoreProvinceCenterForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public RetailStoreProvinceCenterForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public RetailStoreProvinceCenterForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public RetailStoreProvinceCenterForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public RetailStoreProvinceCenterForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public RetailStoreProvinceCenterForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public RetailStoreProvinceCenterForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public RetailStoreProvinceCenterForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public RetailStoreProvinceCenterForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public RetailStoreProvinceCenterForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public RetailStoreProvinceCenterForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreProvinceCenterForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public RetailStoreProvinceCenterForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public RetailStoreProvinceCenterForm provinceCenterDepartmentIdFieldForProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  idFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm provinceCenterDepartmentIdFieldForProvinceCenterDepartment(String initValue){
		return provinceCenterDepartmentIdFieldForProvinceCenterDepartment("provinceCenterDepartmentId",initValue);
	}
	public RetailStoreProvinceCenterForm provinceCenterDepartmentIdFieldForProvinceCenterDepartment(){
		return provinceCenterDepartmentIdFieldForProvinceCenterDepartment("provinceCenterDepartmentId","");
	}


	public RetailStoreProvinceCenterForm nameFieldForProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  nameFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm nameFieldForProvinceCenterDepartment(String initValue){
		return nameFieldForProvinceCenterDepartment("name",initValue);
	}
	public RetailStoreProvinceCenterForm nameFieldForProvinceCenterDepartment(){
		return nameFieldForProvinceCenterDepartment("name","");
	}


	public RetailStoreProvinceCenterForm foundedFieldForProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  foundedFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm foundedFieldForProvinceCenterDepartment(String initValue){
		return foundedFieldForProvinceCenterDepartment("founded",initValue);
	}
	public RetailStoreProvinceCenterForm foundedFieldForProvinceCenterDepartment(){
		return foundedFieldForProvinceCenterDepartment("founded","");
	}


	public RetailStoreProvinceCenterForm provinceCenterIdFieldForProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  provinceCenterIdFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm provinceCenterIdFieldForProvinceCenterDepartment(String initValue){
		return provinceCenterIdFieldForProvinceCenterDepartment("provinceCenterId",initValue);
	}
	public RetailStoreProvinceCenterForm provinceCenterIdFieldForProvinceCenterDepartment(){
		return provinceCenterIdFieldForProvinceCenterDepartment("provinceCenterId","");
	}


	public RetailStoreProvinceCenterForm managerFieldForProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  managerFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm managerFieldForProvinceCenterDepartment(String initValue){
		return managerFieldForProvinceCenterDepartment("manager",initValue);
	}
	public RetailStoreProvinceCenterForm managerFieldForProvinceCenterDepartment(){
		return managerFieldForProvinceCenterDepartment("manager","");
	}


	public RetailStoreProvinceCenterForm provinceCenterEmployeeIdFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  idFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm provinceCenterEmployeeIdFieldForProvinceCenterEmployee(String initValue){
		return provinceCenterEmployeeIdFieldForProvinceCenterEmployee("provinceCenterEmployeeId",initValue);
	}
	public RetailStoreProvinceCenterForm provinceCenterEmployeeIdFieldForProvinceCenterEmployee(){
		return provinceCenterEmployeeIdFieldForProvinceCenterEmployee("provinceCenterEmployeeId","");
	}


	public RetailStoreProvinceCenterForm nameFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  nameFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm nameFieldForProvinceCenterEmployee(String initValue){
		return nameFieldForProvinceCenterEmployee("name",initValue);
	}
	public RetailStoreProvinceCenterForm nameFieldForProvinceCenterEmployee(){
		return nameFieldForProvinceCenterEmployee("name","");
	}


	public RetailStoreProvinceCenterForm mobileFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  mobileFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm mobileFieldForProvinceCenterEmployee(String initValue){
		return mobileFieldForProvinceCenterEmployee("mobile",initValue);
	}
	public RetailStoreProvinceCenterForm mobileFieldForProvinceCenterEmployee(){
		return mobileFieldForProvinceCenterEmployee("mobile","");
	}


	public RetailStoreProvinceCenterForm emailFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  emailFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm emailFieldForProvinceCenterEmployee(String initValue){
		return emailFieldForProvinceCenterEmployee("email",initValue);
	}
	public RetailStoreProvinceCenterForm emailFieldForProvinceCenterEmployee(){
		return emailFieldForProvinceCenterEmployee("email","");
	}


	public RetailStoreProvinceCenterForm foundedFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  foundedFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm foundedFieldForProvinceCenterEmployee(String initValue){
		return foundedFieldForProvinceCenterEmployee("founded",initValue);
	}
	public RetailStoreProvinceCenterForm foundedFieldForProvinceCenterEmployee(){
		return foundedFieldForProvinceCenterEmployee("founded","");
	}


	public RetailStoreProvinceCenterForm departmentIdFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm departmentIdFieldForProvinceCenterEmployee(String initValue){
		return departmentIdFieldForProvinceCenterEmployee("departmentId",initValue);
	}
	public RetailStoreProvinceCenterForm departmentIdFieldForProvinceCenterEmployee(){
		return departmentIdFieldForProvinceCenterEmployee("departmentId","");
	}


	public RetailStoreProvinceCenterForm provinceCenterIdFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  provinceCenterIdFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm provinceCenterIdFieldForProvinceCenterEmployee(String initValue){
		return provinceCenterIdFieldForProvinceCenterEmployee("provinceCenterId",initValue);
	}
	public RetailStoreProvinceCenterForm provinceCenterIdFieldForProvinceCenterEmployee(){
		return provinceCenterIdFieldForProvinceCenterEmployee("provinceCenterId","");
	}


	public RetailStoreProvinceCenterForm retailStoreCityServiceCenterIdFieldForRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm retailStoreCityServiceCenterIdFieldForRetailStoreCityServiceCenter(String initValue){
		return retailStoreCityServiceCenterIdFieldForRetailStoreCityServiceCenter("retailStoreCityServiceCenterId",initValue);
	}
	public RetailStoreProvinceCenterForm retailStoreCityServiceCenterIdFieldForRetailStoreCityServiceCenter(){
		return retailStoreCityServiceCenterIdFieldForRetailStoreCityServiceCenter("retailStoreCityServiceCenterId","");
	}


	public RetailStoreProvinceCenterForm nameFieldForRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm nameFieldForRetailStoreCityServiceCenter(String initValue){
		return nameFieldForRetailStoreCityServiceCenter("name",initValue);
	}
	public RetailStoreProvinceCenterForm nameFieldForRetailStoreCityServiceCenter(){
		return nameFieldForRetailStoreCityServiceCenter("name","");
	}


	public RetailStoreProvinceCenterForm foundedFieldForRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm foundedFieldForRetailStoreCityServiceCenter(String initValue){
		return foundedFieldForRetailStoreCityServiceCenter("founded",initValue);
	}
	public RetailStoreProvinceCenterForm foundedFieldForRetailStoreCityServiceCenter(){
		return foundedFieldForRetailStoreCityServiceCenter("founded","");
	}


	public RetailStoreProvinceCenterForm belongsToIdFieldForRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  belongsToIdFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm belongsToIdFieldForRetailStoreCityServiceCenter(String initValue){
		return belongsToIdFieldForRetailStoreCityServiceCenter("belongsToId",initValue);
	}
	public RetailStoreProvinceCenterForm belongsToIdFieldForRetailStoreCityServiceCenter(){
		return belongsToIdFieldForRetailStoreCityServiceCenter("belongsToId","");
	}


	public RetailStoreProvinceCenterForm lastUpdateTimeFieldForRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreCityServiceCenter(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreProvinceCenterForm lastUpdateTimeFieldForRetailStoreCityServiceCenter(String initValue){
		return lastUpdateTimeFieldForRetailStoreCityServiceCenter("lastUpdateTime",initValue);
	}
	public RetailStoreProvinceCenterForm lastUpdateTimeFieldForRetailStoreCityServiceCenter(){
		return lastUpdateTimeFieldForRetailStoreCityServiceCenter("lastUpdateTime","");
	}

	

	
 	public RetailStoreProvinceCenterForm transferToAnotherCountryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCountry/retailStoreProvinceCenterId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreProvinceCenterForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



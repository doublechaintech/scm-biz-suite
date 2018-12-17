package com.doublechaintech.retailscm.leavetype;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LeaveTypeForm extends BaseForm {
	
	
	public LeaveTypeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LeaveTypeForm leaveTypeIdField(String parameterName, String initValue){
		FormField field = idFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm leaveTypeIdField(String initValue){
		return leaveTypeIdField("leaveTypeId",initValue);
	}
	public LeaveTypeForm leaveTypeIdField(){
		return leaveTypeIdField("leaveTypeId","");
	}


	public LeaveTypeForm codeField(String parameterName, String initValue){
		FormField field = codeFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public LeaveTypeForm codeField(){
		return codeField("code","");
	}


	public LeaveTypeForm companyIdField(String parameterName, String initValue){
		FormField field = companyIdFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm companyIdField(String initValue){
		return companyIdField("companyId",initValue);
	}
	public LeaveTypeForm companyIdField(){
		return companyIdField("companyId","");
	}


	public LeaveTypeForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public LeaveTypeForm descriptionField(){
		return descriptionField("description","");
	}


	public LeaveTypeForm detailDescriptionField(String parameterName, String initValue){
		FormField field = detailDescriptionFromLeaveType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm detailDescriptionField(String initValue){
		return detailDescriptionField("detailDescription",initValue);
	}
	public LeaveTypeForm detailDescriptionField(){
		return detailDescriptionField("detailDescription","");
	}

	
	


	public LeaveTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public LeaveTypeForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public LeaveTypeForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public LeaveTypeForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public LeaveTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public LeaveTypeForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public LeaveTypeForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public LeaveTypeForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public LeaveTypeForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public LeaveTypeForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public LeaveTypeForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public LeaveTypeForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public LeaveTypeForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public LeaveTypeForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public LeaveTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public LeaveTypeForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public LeaveTypeForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LeaveTypeForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public LeaveTypeForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public LeaveTypeForm employeeLeaveIdFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  idFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm employeeLeaveIdFieldForEmployeeLeave(String initValue){
		return employeeLeaveIdFieldForEmployeeLeave("employeeLeaveId",initValue);
	}
	public LeaveTypeForm employeeLeaveIdFieldForEmployeeLeave(){
		return employeeLeaveIdFieldForEmployeeLeave("employeeLeaveId","");
	}


	public LeaveTypeForm whoIdFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  whoIdFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm whoIdFieldForEmployeeLeave(String initValue){
		return whoIdFieldForEmployeeLeave("whoId",initValue);
	}
	public LeaveTypeForm whoIdFieldForEmployeeLeave(){
		return whoIdFieldForEmployeeLeave("whoId","");
	}


	public LeaveTypeForm typeIdFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  typeIdFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm typeIdFieldForEmployeeLeave(String initValue){
		return typeIdFieldForEmployeeLeave("typeId",initValue);
	}
	public LeaveTypeForm typeIdFieldForEmployeeLeave(){
		return typeIdFieldForEmployeeLeave("typeId","");
	}


	public LeaveTypeForm leaveDurationHourFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  leaveDurationHourFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm leaveDurationHourFieldForEmployeeLeave(String initValue){
		return leaveDurationHourFieldForEmployeeLeave("leaveDurationHour",initValue);
	}
	public LeaveTypeForm leaveDurationHourFieldForEmployeeLeave(){
		return leaveDurationHourFieldForEmployeeLeave("leaveDurationHour","");
	}


	public LeaveTypeForm remarkFieldForEmployeeLeave(String parameterName, String initValue){
		FormField field =  remarkFromEmployeeLeave(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LeaveTypeForm remarkFieldForEmployeeLeave(String initValue){
		return remarkFieldForEmployeeLeave("remark",initValue);
	}
	public LeaveTypeForm remarkFieldForEmployeeLeave(){
		return remarkFieldForEmployeeLeave("remark","");
	}

	

	
 	public LeaveTypeForm transferToAnotherCompanyAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCompany/leaveTypeId/");
		this.addFormAction(action);
		return this;
	}

 

	public LeaveTypeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



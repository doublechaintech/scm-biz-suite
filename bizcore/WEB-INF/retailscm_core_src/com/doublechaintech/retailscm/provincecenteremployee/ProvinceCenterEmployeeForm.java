package com.doublechaintech.retailscm.provincecenteremployee;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ProvinceCenterEmployeeForm extends BaseForm {
	
	
	public ProvinceCenterEmployeeForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProvinceCenterEmployeeForm provinceCenterEmployeeIdField(String parameterName, String initValue){
		FormField field = idFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm provinceCenterEmployeeIdField(String initValue){
		return provinceCenterEmployeeIdField("provinceCenterEmployeeId",initValue);
	}
	public ProvinceCenterEmployeeForm provinceCenterEmployeeIdField(){
		return provinceCenterEmployeeIdField("provinceCenterEmployeeId","");
	}


	public ProvinceCenterEmployeeForm nameField(String parameterName, String initValue){
		FormField field = nameFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProvinceCenterEmployeeForm nameField(){
		return nameField("name","");
	}


	public ProvinceCenterEmployeeForm mobileField(String parameterName, String initValue){
		FormField field = mobileFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm mobileField(String initValue){
		return mobileField("mobile",initValue);
	}
	public ProvinceCenterEmployeeForm mobileField(){
		return mobileField("mobile","");
	}


	public ProvinceCenterEmployeeForm emailField(String parameterName, String initValue){
		FormField field = emailFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm emailField(String initValue){
		return emailField("email",initValue);
	}
	public ProvinceCenterEmployeeForm emailField(){
		return emailField("email","");
	}


	public ProvinceCenterEmployeeForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public ProvinceCenterEmployeeForm foundedField(){
		return foundedField("founded","");
	}


	public ProvinceCenterEmployeeForm departmentIdField(String parameterName, String initValue){
		FormField field = departmentIdFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm departmentIdField(String initValue){
		return departmentIdField("departmentId",initValue);
	}
	public ProvinceCenterEmployeeForm departmentIdField(){
		return departmentIdField("departmentId","");
	}


	public ProvinceCenterEmployeeForm provinceCenterIdField(String parameterName, String initValue){
		FormField field = provinceCenterIdFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterEmployeeForm provinceCenterIdField(String initValue){
		return provinceCenterIdField("provinceCenterId",initValue);
	}
	public ProvinceCenterEmployeeForm provinceCenterIdField(){
		return provinceCenterIdField("provinceCenterId","");
	}

	
	


	public ProvinceCenterEmployeeForm provinceCenterDepartmentIdFieldOfProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  idFromProvinceCenterDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm provinceCenterDepartmentIdFieldOfProvinceCenterDepartment(String initValue){
		return provinceCenterDepartmentIdFieldOfProvinceCenterDepartment("provinceCenterDepartmentId",initValue);
	}
	public ProvinceCenterEmployeeForm provinceCenterDepartmentIdFieldOfProvinceCenterDepartment(){
		return provinceCenterDepartmentIdFieldOfProvinceCenterDepartment("provinceCenterDepartmentId","");
	}


	public ProvinceCenterEmployeeForm nameFieldOfProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  nameFromProvinceCenterDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm nameFieldOfProvinceCenterDepartment(String initValue){
		return nameFieldOfProvinceCenterDepartment("name",initValue);
	}
	public ProvinceCenterEmployeeForm nameFieldOfProvinceCenterDepartment(){
		return nameFieldOfProvinceCenterDepartment("name","");
	}


	public ProvinceCenterEmployeeForm foundedFieldOfProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  foundedFromProvinceCenterDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm foundedFieldOfProvinceCenterDepartment(String initValue){
		return foundedFieldOfProvinceCenterDepartment("founded",initValue);
	}
	public ProvinceCenterEmployeeForm foundedFieldOfProvinceCenterDepartment(){
		return foundedFieldOfProvinceCenterDepartment("founded","");
	}


	public ProvinceCenterEmployeeForm provinceCenterIdFieldOfProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  provinceCenterIdFromProvinceCenterDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm provinceCenterIdFieldOfProvinceCenterDepartment(String initValue){
		return provinceCenterIdFieldOfProvinceCenterDepartment("provinceCenterId",initValue);
	}
	public ProvinceCenterEmployeeForm provinceCenterIdFieldOfProvinceCenterDepartment(){
		return provinceCenterIdFieldOfProvinceCenterDepartment("provinceCenterId","");
	}


	public ProvinceCenterEmployeeForm managerFieldOfProvinceCenterDepartment(String parameterName, String initValue){
		FormField field =  managerFromProvinceCenterDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm managerFieldOfProvinceCenterDepartment(String initValue){
		return managerFieldOfProvinceCenterDepartment("manager",initValue);
	}
	public ProvinceCenterEmployeeForm managerFieldOfProvinceCenterDepartment(){
		return managerFieldOfProvinceCenterDepartment("manager","");
	}


	public ProvinceCenterEmployeeForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(String initValue){
		return retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter("retailStoreProvinceCenterId",initValue);
	}
	public ProvinceCenterEmployeeForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(){
		return retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter("retailStoreProvinceCenterId","");
	}


	public ProvinceCenterEmployeeForm nameFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm nameFieldOfRetailStoreProvinceCenter(String initValue){
		return nameFieldOfRetailStoreProvinceCenter("name",initValue);
	}
	public ProvinceCenterEmployeeForm nameFieldOfRetailStoreProvinceCenter(){
		return nameFieldOfRetailStoreProvinceCenter("name","");
	}


	public ProvinceCenterEmployeeForm foundedFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm foundedFieldOfRetailStoreProvinceCenter(String initValue){
		return foundedFieldOfRetailStoreProvinceCenter("founded",initValue);
	}
	public ProvinceCenterEmployeeForm foundedFieldOfRetailStoreProvinceCenter(){
		return foundedFieldOfRetailStoreProvinceCenter("founded","");
	}


	public ProvinceCenterEmployeeForm countryIdFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  countryIdFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm countryIdFieldOfRetailStoreProvinceCenter(String initValue){
		return countryIdFieldOfRetailStoreProvinceCenter("countryId",initValue);
	}
	public ProvinceCenterEmployeeForm countryIdFieldOfRetailStoreProvinceCenter(){
		return countryIdFieldOfRetailStoreProvinceCenter("countryId","");
	}


	public ProvinceCenterEmployeeForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterEmployeeForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreProvinceCenter("lastUpdateTime",initValue);
	}
	public ProvinceCenterEmployeeForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(){
		return lastUpdateTimeFieldOfRetailStoreProvinceCenter("lastUpdateTime","");
	}

	


	

	
 	public ProvinceCenterEmployeeForm transferToAnotherDepartmentAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherDepartment/provinceCenterEmployeeId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ProvinceCenterEmployeeForm transferToAnotherProvinceCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProvinceCenter/provinceCenterEmployeeId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProvinceCenterEmployeeForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



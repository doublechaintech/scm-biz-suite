package com.doublechaintech.retailscm.provincecenterdepartment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class ProvinceCenterDepartmentForm extends BaseForm {
	
	
	public ProvinceCenterDepartmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ProvinceCenterDepartmentForm provinceCenterDepartmentIdField(String parameterName, String initValue){
		FormField field = idFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm provinceCenterDepartmentIdField(String initValue){
		return provinceCenterDepartmentIdField("provinceCenterDepartmentId",initValue);
	}
	public ProvinceCenterDepartmentForm provinceCenterDepartmentIdField(){
		return provinceCenterDepartmentIdField("provinceCenterDepartmentId","");
	}


	public ProvinceCenterDepartmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ProvinceCenterDepartmentForm nameField(){
		return nameField("name","");
	}


	public ProvinceCenterDepartmentForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public ProvinceCenterDepartmentForm foundedField(){
		return foundedField("founded","");
	}


	public ProvinceCenterDepartmentForm provinceCenterIdField(String parameterName, String initValue){
		FormField field = provinceCenterIdFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm provinceCenterIdField(String initValue){
		return provinceCenterIdField("provinceCenterId",initValue);
	}
	public ProvinceCenterDepartmentForm provinceCenterIdField(){
		return provinceCenterIdField("provinceCenterId","");
	}


	public ProvinceCenterDepartmentForm managerField(String parameterName, String initValue){
		FormField field = managerFromProvinceCenterDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm managerField(String initValue){
		return managerField("manager",initValue);
	}
	public ProvinceCenterDepartmentForm managerField(){
		return managerField("manager","");
	}

	
	


	public ProvinceCenterDepartmentForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterDepartmentForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(String initValue){
		return retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter("retailStoreProvinceCenterId",initValue);
	}
	public ProvinceCenterDepartmentForm retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter(){
		return retailStoreProvinceCenterIdFieldOfRetailStoreProvinceCenter("retailStoreProvinceCenterId","");
	}


	public ProvinceCenterDepartmentForm nameFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterDepartmentForm nameFieldOfRetailStoreProvinceCenter(String initValue){
		return nameFieldOfRetailStoreProvinceCenter("name",initValue);
	}
	public ProvinceCenterDepartmentForm nameFieldOfRetailStoreProvinceCenter(){
		return nameFieldOfRetailStoreProvinceCenter("name","");
	}


	public ProvinceCenterDepartmentForm foundedFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterDepartmentForm foundedFieldOfRetailStoreProvinceCenter(String initValue){
		return foundedFieldOfRetailStoreProvinceCenter("founded",initValue);
	}
	public ProvinceCenterDepartmentForm foundedFieldOfRetailStoreProvinceCenter(){
		return foundedFieldOfRetailStoreProvinceCenter("founded","");
	}


	public ProvinceCenterDepartmentForm countryIdFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  countryIdFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterDepartmentForm countryIdFieldOfRetailStoreProvinceCenter(String initValue){
		return countryIdFieldOfRetailStoreProvinceCenter("countryId",initValue);
	}
	public ProvinceCenterDepartmentForm countryIdFieldOfRetailStoreProvinceCenter(){
		return countryIdFieldOfRetailStoreProvinceCenter("countryId","");
	}


	public ProvinceCenterDepartmentForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreProvinceCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ProvinceCenterDepartmentForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(String initValue){
		return lastUpdateTimeFieldOfRetailStoreProvinceCenter("lastUpdateTime",initValue);
	}
	public ProvinceCenterDepartmentForm lastUpdateTimeFieldOfRetailStoreProvinceCenter(){
		return lastUpdateTimeFieldOfRetailStoreProvinceCenter("lastUpdateTime","");
	}

	



	public ProvinceCenterDepartmentForm provinceCenterEmployeeIdFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  idFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm provinceCenterEmployeeIdFieldForProvinceCenterEmployee(String initValue){
		return provinceCenterEmployeeIdFieldForProvinceCenterEmployee("provinceCenterEmployeeId",initValue);
	}
	public ProvinceCenterDepartmentForm provinceCenterEmployeeIdFieldForProvinceCenterEmployee(){
		return provinceCenterEmployeeIdFieldForProvinceCenterEmployee("provinceCenterEmployeeId","");
	}


	public ProvinceCenterDepartmentForm nameFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  nameFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm nameFieldForProvinceCenterEmployee(String initValue){
		return nameFieldForProvinceCenterEmployee("name",initValue);
	}
	public ProvinceCenterDepartmentForm nameFieldForProvinceCenterEmployee(){
		return nameFieldForProvinceCenterEmployee("name","");
	}


	public ProvinceCenterDepartmentForm mobileFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  mobileFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm mobileFieldForProvinceCenterEmployee(String initValue){
		return mobileFieldForProvinceCenterEmployee("mobile",initValue);
	}
	public ProvinceCenterDepartmentForm mobileFieldForProvinceCenterEmployee(){
		return mobileFieldForProvinceCenterEmployee("mobile","");
	}


	public ProvinceCenterDepartmentForm emailFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  emailFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm emailFieldForProvinceCenterEmployee(String initValue){
		return emailFieldForProvinceCenterEmployee("email",initValue);
	}
	public ProvinceCenterDepartmentForm emailFieldForProvinceCenterEmployee(){
		return emailFieldForProvinceCenterEmployee("email","");
	}


	public ProvinceCenterDepartmentForm foundedFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  foundedFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm foundedFieldForProvinceCenterEmployee(String initValue){
		return foundedFieldForProvinceCenterEmployee("founded",initValue);
	}
	public ProvinceCenterDepartmentForm foundedFieldForProvinceCenterEmployee(){
		return foundedFieldForProvinceCenterEmployee("founded","");
	}


	public ProvinceCenterDepartmentForm departmentIdFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  departmentIdFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm departmentIdFieldForProvinceCenterEmployee(String initValue){
		return departmentIdFieldForProvinceCenterEmployee("departmentId",initValue);
	}
	public ProvinceCenterDepartmentForm departmentIdFieldForProvinceCenterEmployee(){
		return departmentIdFieldForProvinceCenterEmployee("departmentId","");
	}


	public ProvinceCenterDepartmentForm provinceCenterIdFieldForProvinceCenterEmployee(String parameterName, String initValue){
		FormField field =  provinceCenterIdFromProvinceCenterEmployee(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ProvinceCenterDepartmentForm provinceCenterIdFieldForProvinceCenterEmployee(String initValue){
		return provinceCenterIdFieldForProvinceCenterEmployee("provinceCenterId",initValue);
	}
	public ProvinceCenterDepartmentForm provinceCenterIdFieldForProvinceCenterEmployee(){
		return provinceCenterIdFieldForProvinceCenterEmployee("provinceCenterId","");
	}

	

	
 	public ProvinceCenterDepartmentForm transferToAnotherProvinceCenterAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProvinceCenter/provinceCenterDepartmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public ProvinceCenterDepartmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



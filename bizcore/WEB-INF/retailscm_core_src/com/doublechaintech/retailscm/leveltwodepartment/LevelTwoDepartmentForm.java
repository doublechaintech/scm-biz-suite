package com.doublechaintech.retailscm.leveltwodepartment;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LevelTwoDepartmentForm extends BaseForm {
	
	
	public LevelTwoDepartmentForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelTwoDepartmentForm levelTwoDepartmentIdField(String parameterName, String initValue){
		FormField field = idFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm levelTwoDepartmentIdField(String initValue){
		return levelTwoDepartmentIdField("levelTwoDepartmentId",initValue);
	}
	public LevelTwoDepartmentForm levelTwoDepartmentIdField(){
		return levelTwoDepartmentIdField("levelTwoDepartmentId","");
	}


	public LevelTwoDepartmentForm belongsToIdField(String parameterName, String initValue){
		FormField field = belongsToIdFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm belongsToIdField(String initValue){
		return belongsToIdField("belongsToId",initValue);
	}
	public LevelTwoDepartmentForm belongsToIdField(){
		return belongsToIdField("belongsToId","");
	}


	public LevelTwoDepartmentForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelTwoDepartmentForm nameField(){
		return nameField("name","");
	}


	public LevelTwoDepartmentForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public LevelTwoDepartmentForm descriptionField(){
		return descriptionField("description","");
	}


	public LevelTwoDepartmentForm foundedField(String parameterName, String initValue){
		FormField field = foundedFromLevelTwoDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm foundedField(String initValue){
		return foundedField("founded",initValue);
	}
	public LevelTwoDepartmentForm foundedField(){
		return foundedField("founded","");
	}

	
	


	public LevelTwoDepartmentForm levelOneDepartmentIdFieldOfLevelOneDepartment(String parameterName, String initValue){
		FormField field =  idFromLevelOneDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoDepartmentForm levelOneDepartmentIdFieldOfLevelOneDepartment(String initValue){
		return levelOneDepartmentIdFieldOfLevelOneDepartment("levelOneDepartmentId",initValue);
	}
	public LevelTwoDepartmentForm levelOneDepartmentIdFieldOfLevelOneDepartment(){
		return levelOneDepartmentIdFieldOfLevelOneDepartment("levelOneDepartmentId","");
	}


	public LevelTwoDepartmentForm belongsToIdFieldOfLevelOneDepartment(String parameterName, String initValue){
		FormField field =  belongsToIdFromLevelOneDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoDepartmentForm belongsToIdFieldOfLevelOneDepartment(String initValue){
		return belongsToIdFieldOfLevelOneDepartment("belongsToId",initValue);
	}
	public LevelTwoDepartmentForm belongsToIdFieldOfLevelOneDepartment(){
		return belongsToIdFieldOfLevelOneDepartment("belongsToId","");
	}


	public LevelTwoDepartmentForm nameFieldOfLevelOneDepartment(String parameterName, String initValue){
		FormField field =  nameFromLevelOneDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoDepartmentForm nameFieldOfLevelOneDepartment(String initValue){
		return nameFieldOfLevelOneDepartment("name",initValue);
	}
	public LevelTwoDepartmentForm nameFieldOfLevelOneDepartment(){
		return nameFieldOfLevelOneDepartment("name","");
	}


	public LevelTwoDepartmentForm descriptionFieldOfLevelOneDepartment(String parameterName, String initValue){
		FormField field =  descriptionFromLevelOneDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoDepartmentForm descriptionFieldOfLevelOneDepartment(String initValue){
		return descriptionFieldOfLevelOneDepartment("description",initValue);
	}
	public LevelTwoDepartmentForm descriptionFieldOfLevelOneDepartment(){
		return descriptionFieldOfLevelOneDepartment("description","");
	}


	public LevelTwoDepartmentForm managerFieldOfLevelOneDepartment(String parameterName, String initValue){
		FormField field =  managerFromLevelOneDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoDepartmentForm managerFieldOfLevelOneDepartment(String initValue){
		return managerFieldOfLevelOneDepartment("manager",initValue);
	}
	public LevelTwoDepartmentForm managerFieldOfLevelOneDepartment(){
		return managerFieldOfLevelOneDepartment("manager","");
	}


	public LevelTwoDepartmentForm foundedFieldOfLevelOneDepartment(String parameterName, String initValue){
		FormField field =  foundedFromLevelOneDepartment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoDepartmentForm foundedFieldOfLevelOneDepartment(String initValue){
		return foundedFieldOfLevelOneDepartment("founded",initValue);
	}
	public LevelTwoDepartmentForm foundedFieldOfLevelOneDepartment(){
		return foundedFieldOfLevelOneDepartment("founded","");
	}

	



	public LevelTwoDepartmentForm levelThreeDepartmentIdFieldForLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  idFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm levelThreeDepartmentIdFieldForLevelThreeDepartment(String initValue){
		return levelThreeDepartmentIdFieldForLevelThreeDepartment("levelThreeDepartmentId",initValue);
	}
	public LevelTwoDepartmentForm levelThreeDepartmentIdFieldForLevelThreeDepartment(){
		return levelThreeDepartmentIdFieldForLevelThreeDepartment("levelThreeDepartmentId","");
	}


	public LevelTwoDepartmentForm belongsToIdFieldForLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  belongsToIdFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm belongsToIdFieldForLevelThreeDepartment(String initValue){
		return belongsToIdFieldForLevelThreeDepartment("belongsToId",initValue);
	}
	public LevelTwoDepartmentForm belongsToIdFieldForLevelThreeDepartment(){
		return belongsToIdFieldForLevelThreeDepartment("belongsToId","");
	}


	public LevelTwoDepartmentForm nameFieldForLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  nameFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm nameFieldForLevelThreeDepartment(String initValue){
		return nameFieldForLevelThreeDepartment("name",initValue);
	}
	public LevelTwoDepartmentForm nameFieldForLevelThreeDepartment(){
		return nameFieldForLevelThreeDepartment("name","");
	}


	public LevelTwoDepartmentForm descriptionFieldForLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  descriptionFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm descriptionFieldForLevelThreeDepartment(String initValue){
		return descriptionFieldForLevelThreeDepartment("description",initValue);
	}
	public LevelTwoDepartmentForm descriptionFieldForLevelThreeDepartment(){
		return descriptionFieldForLevelThreeDepartment("description","");
	}


	public LevelTwoDepartmentForm foundedFieldForLevelThreeDepartment(String parameterName, String initValue){
		FormField field =  foundedFromLevelThreeDepartment(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoDepartmentForm foundedFieldForLevelThreeDepartment(String initValue){
		return foundedFieldForLevelThreeDepartment("founded",initValue);
	}
	public LevelTwoDepartmentForm foundedFieldForLevelThreeDepartment(){
		return foundedFieldForLevelThreeDepartment("founded","");
	}

	

	
 	public LevelTwoDepartmentForm transferToAnotherBelongsToAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBelongsTo/levelTwoDepartmentId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelTwoDepartmentForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.levelonecategory;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LevelOneCategoryForm extends BaseForm {
	
	
	public LevelOneCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelOneCategoryForm levelOneCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm levelOneCategoryIdField(String initValue){
		return levelOneCategoryIdField("levelOneCategoryId",initValue);
	}
	public LevelOneCategoryForm levelOneCategoryIdField(){
		return levelOneCategoryIdField("levelOneCategoryId","");
	}


	public LevelOneCategoryForm catalogIdField(String parameterName, String initValue){
		FormField field = catalogIdFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm catalogIdField(String initValue){
		return catalogIdField("catalogId",initValue);
	}
	public LevelOneCategoryForm catalogIdField(){
		return catalogIdField("catalogId","");
	}


	public LevelOneCategoryForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelOneCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelOneCategoryForm nameField(){
		return nameField("name","");
	}

	
	


	public LevelOneCategoryForm catalogIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  idFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm catalogIdFieldOfCatalog(String initValue){
		return catalogIdFieldOfCatalog("catalogId",initValue);
	}
	public LevelOneCategoryForm catalogIdFieldOfCatalog(){
		return catalogIdFieldOfCatalog("catalogId","");
	}


	public LevelOneCategoryForm nameFieldOfCatalog(String parameterName, String initValue){
		FormField field =  nameFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm nameFieldOfCatalog(String initValue){
		return nameFieldOfCatalog("name",initValue);
	}
	public LevelOneCategoryForm nameFieldOfCatalog(){
		return nameFieldOfCatalog("name","");
	}


	public LevelOneCategoryForm ownerIdFieldOfCatalog(String parameterName, String initValue){
		FormField field =  ownerIdFromCatalog(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelOneCategoryForm ownerIdFieldOfCatalog(String initValue){
		return ownerIdFieldOfCatalog("ownerId",initValue);
	}
	public LevelOneCategoryForm ownerIdFieldOfCatalog(){
		return ownerIdFieldOfCatalog("ownerId","");
	}

	



	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  idFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(String initValue){
		return levelTwoCategoryIdFieldForLevelTwoCategory("levelTwoCategoryId",initValue);
	}
	public LevelOneCategoryForm levelTwoCategoryIdFieldForLevelTwoCategory(){
		return levelTwoCategoryIdFieldForLevelTwoCategory("levelTwoCategoryId","");
	}


	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(String initValue){
		return parentCategoryIdFieldForLevelTwoCategory("parentCategoryId",initValue);
	}
	public LevelOneCategoryForm parentCategoryIdFieldForLevelTwoCategory(){
		return parentCategoryIdFieldForLevelTwoCategory("parentCategoryId","");
	}


	public LevelOneCategoryForm nameFieldForLevelTwoCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelOneCategoryForm nameFieldForLevelTwoCategory(String initValue){
		return nameFieldForLevelTwoCategory("name",initValue);
	}
	public LevelOneCategoryForm nameFieldForLevelTwoCategory(){
		return nameFieldForLevelTwoCategory("name","");
	}

	

	
 	public LevelOneCategoryForm transferToAnotherCatalogAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherCatalog/levelOneCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelOneCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



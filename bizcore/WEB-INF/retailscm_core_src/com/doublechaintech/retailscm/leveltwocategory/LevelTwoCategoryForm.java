package com.doublechaintech.retailscm.leveltwocategory;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LevelTwoCategoryForm extends BaseForm {
	
	
	public LevelTwoCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelTwoCategoryForm levelTwoCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm levelTwoCategoryIdField(String initValue){
		return levelTwoCategoryIdField("levelTwoCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelTwoCategoryIdField(){
		return levelTwoCategoryIdField("levelTwoCategoryId","");
	}


	public LevelTwoCategoryForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public LevelTwoCategoryForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public LevelTwoCategoryForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelTwoCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelTwoCategoryForm nameField(){
		return nameField("name","");
	}

	
	


	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  idFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(String initValue){
		return levelOneCategoryIdFieldOfLevelOneCategory("levelOneCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelOneCategoryIdFieldOfLevelOneCategory(){
		return levelOneCategoryIdFieldOfLevelOneCategory("levelOneCategoryId","");
	}


	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  catalogIdFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(String initValue){
		return catalogIdFieldOfLevelOneCategory("catalogId",initValue);
	}
	public LevelTwoCategoryForm catalogIdFieldOfLevelOneCategory(){
		return catalogIdFieldOfLevelOneCategory("catalogId","");
	}


	public LevelTwoCategoryForm nameFieldOfLevelOneCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelOneCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelTwoCategoryForm nameFieldOfLevelOneCategory(String initValue){
		return nameFieldOfLevelOneCategory("name",initValue);
	}
	public LevelTwoCategoryForm nameFieldOfLevelOneCategory(){
		return nameFieldOfLevelOneCategory("name","");
	}

	



	public LevelTwoCategoryForm levelThreeCategoryIdFieldForLevelThreeCategory(String parameterName, String initValue){
		FormField field =  idFromLevelThreeCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm levelThreeCategoryIdFieldForLevelThreeCategory(String initValue){
		return levelThreeCategoryIdFieldForLevelThreeCategory("levelThreeCategoryId",initValue);
	}
	public LevelTwoCategoryForm levelThreeCategoryIdFieldForLevelThreeCategory(){
		return levelThreeCategoryIdFieldForLevelThreeCategory("levelThreeCategoryId","");
	}


	public LevelTwoCategoryForm parentCategoryIdFieldForLevelThreeCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelThreeCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm parentCategoryIdFieldForLevelThreeCategory(String initValue){
		return parentCategoryIdFieldForLevelThreeCategory("parentCategoryId",initValue);
	}
	public LevelTwoCategoryForm parentCategoryIdFieldForLevelThreeCategory(){
		return parentCategoryIdFieldForLevelThreeCategory("parentCategoryId","");
	}


	public LevelTwoCategoryForm nameFieldForLevelThreeCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelThreeCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelTwoCategoryForm nameFieldForLevelThreeCategory(String initValue){
		return nameFieldForLevelThreeCategory("name",initValue);
	}
	public LevelTwoCategoryForm nameFieldForLevelThreeCategory(){
		return nameFieldForLevelThreeCategory("name","");
	}

	

	
 	public LevelTwoCategoryForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/levelTwoCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelTwoCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



package com.doublechaintech.retailscm.levelthreecategory;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class LevelThreeCategoryForm extends BaseForm {
	
	
	public LevelThreeCategoryForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public LevelThreeCategoryForm levelThreeCategoryIdField(String parameterName, String initValue){
		FormField field = idFromLevelThreeCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm levelThreeCategoryIdField(String initValue){
		return levelThreeCategoryIdField("levelThreeCategoryId",initValue);
	}
	public LevelThreeCategoryForm levelThreeCategoryIdField(){
		return levelThreeCategoryIdField("levelThreeCategoryId","");
	}


	public LevelThreeCategoryForm parentCategoryIdField(String parameterName, String initValue){
		FormField field = parentCategoryIdFromLevelThreeCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm parentCategoryIdField(String initValue){
		return parentCategoryIdField("parentCategoryId",initValue);
	}
	public LevelThreeCategoryForm parentCategoryIdField(){
		return parentCategoryIdField("parentCategoryId","");
	}


	public LevelThreeCategoryForm nameField(String parameterName, String initValue){
		FormField field = nameFromLevelThreeCategory(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public LevelThreeCategoryForm nameField(){
		return nameField("name","");
	}

	
	


	public LevelThreeCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  idFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(String initValue){
		return levelTwoCategoryIdFieldOfLevelTwoCategory("levelTwoCategoryId",initValue);
	}
	public LevelThreeCategoryForm levelTwoCategoryIdFieldOfLevelTwoCategory(){
		return levelTwoCategoryIdFieldOfLevelTwoCategory("levelTwoCategoryId","");
	}


	public LevelThreeCategoryForm parentCategoryIdFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeCategoryForm parentCategoryIdFieldOfLevelTwoCategory(String initValue){
		return parentCategoryIdFieldOfLevelTwoCategory("parentCategoryId",initValue);
	}
	public LevelThreeCategoryForm parentCategoryIdFieldOfLevelTwoCategory(){
		return parentCategoryIdFieldOfLevelTwoCategory("parentCategoryId","");
	}


	public LevelThreeCategoryForm nameFieldOfLevelTwoCategory(String parameterName, String initValue){
		FormField field =  nameFromLevelTwoCategory(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public LevelThreeCategoryForm nameFieldOfLevelTwoCategory(String initValue){
		return nameFieldOfLevelTwoCategory("name",initValue);
	}
	public LevelThreeCategoryForm nameFieldOfLevelTwoCategory(){
		return nameFieldOfLevelTwoCategory("name","");
	}

	



	public LevelThreeCategoryForm productIdFieldForProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm productIdFieldForProduct(String initValue){
		return productIdFieldForProduct("productId",initValue);
	}
	public LevelThreeCategoryForm productIdFieldForProduct(){
		return productIdFieldForProduct("productId","");
	}


	public LevelThreeCategoryForm nameFieldForProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm nameFieldForProduct(String initValue){
		return nameFieldForProduct("name",initValue);
	}
	public LevelThreeCategoryForm nameFieldForProduct(){
		return nameFieldForProduct("name","");
	}


	public LevelThreeCategoryForm parentCategoryIdFieldForProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm parentCategoryIdFieldForProduct(String initValue){
		return parentCategoryIdFieldForProduct("parentCategoryId",initValue);
	}
	public LevelThreeCategoryForm parentCategoryIdFieldForProduct(){
		return parentCategoryIdFieldForProduct("parentCategoryId","");
	}


	public LevelThreeCategoryForm originFieldForProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm originFieldForProduct(String initValue){
		return originFieldForProduct("origin",initValue);
	}
	public LevelThreeCategoryForm originFieldForProduct(){
		return originFieldForProduct("origin","");
	}


	public LevelThreeCategoryForm remarkFieldForProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm remarkFieldForProduct(String initValue){
		return remarkFieldForProduct("remark",initValue);
	}
	public LevelThreeCategoryForm remarkFieldForProduct(){
		return remarkFieldForProduct("remark","");
	}


	public LevelThreeCategoryForm brandFieldForProduct(String parameterName, String initValue){
		FormField field =  brandFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm brandFieldForProduct(String initValue){
		return brandFieldForProduct("brand",initValue);
	}
	public LevelThreeCategoryForm brandFieldForProduct(){
		return brandFieldForProduct("brand","");
	}


	public LevelThreeCategoryForm pictureFieldForProduct(String parameterName, String initValue){
		FormField field =  pictureFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm pictureFieldForProduct(String initValue){
		return pictureFieldForProduct("picture",initValue);
	}
	public LevelThreeCategoryForm pictureFieldForProduct(){
		return pictureFieldForProduct("picture","");
	}


	public LevelThreeCategoryForm lastUpdateTimeFieldForProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public LevelThreeCategoryForm lastUpdateTimeFieldForProduct(String initValue){
		return lastUpdateTimeFieldForProduct("lastUpdateTime",initValue);
	}
	public LevelThreeCategoryForm lastUpdateTimeFieldForProduct(){
		return lastUpdateTimeFieldForProduct("lastUpdateTime","");
	}

	

	
 	public LevelThreeCategoryForm transferToAnotherParentCategoryAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherParentCategory/levelThreeCategoryId/");
		this.addFormAction(action);
		return this;
	}

 

	public LevelThreeCategoryForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}



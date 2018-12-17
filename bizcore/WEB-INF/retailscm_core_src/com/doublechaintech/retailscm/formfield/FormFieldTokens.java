
package com.doublechaintech.retailscm.formfield;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class FormFieldTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="formField";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected FormFieldTokens(){
		//ensure not initialized outside the class
	}
	
	public FormFieldTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FormFieldTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FormFieldTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static FormFieldTokens start(){
		return new FormFieldTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static FormFieldTokens allTokens(){
		
		return start()
			.withForm();
	
	}
	public static FormFieldTokens withoutListsTokens(){
		
		return start()
			.withForm();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String FORM = "form";
	public String getForm(){
		return FORM;
	}
	public FormFieldTokens withForm(){		
		addSimpleOptions(FORM);
		return this;
	}
	
	
	
	public  FormFieldTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


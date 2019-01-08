
package com.doublechaintech.retailscm.formaction;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class FormActionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="formAction";
	
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
	protected FormActionTokens(){
		//ensure not initialized outside the class
	}
	
	public FormActionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FormActionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FormActionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static FormActionTokens start(){
		return new FormActionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static FormActionTokens allTokens(){
		
		return start()
			.withForm();
	
	}
	public static FormActionTokens withoutListsTokens(){
		
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
	public FormActionTokens withForm(){		
		addSimpleOptions(FORM);
		return this;
	}
	
	
	
	public  FormActionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}










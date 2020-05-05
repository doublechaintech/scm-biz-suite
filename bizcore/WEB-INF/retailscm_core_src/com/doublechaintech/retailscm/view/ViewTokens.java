
package com.doublechaintech.retailscm.view;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ViewTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="view";
	
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
	protected ViewTokens(){
		//ensure not initialized outside the class
	}
	public  static  ViewTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ViewTokens tokens = new ViewTokens(options);
		return tokens;
		
	}
	protected ViewTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ViewTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ViewTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ViewTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static ViewTokens start(){
		return new ViewTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public ViewTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static ViewTokens allTokens(){
		
		return start();
	
	}
	public static ViewTokens withoutListsTokens(){
		
		return start();
	
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
	
	public ViewTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	
	public  ViewTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


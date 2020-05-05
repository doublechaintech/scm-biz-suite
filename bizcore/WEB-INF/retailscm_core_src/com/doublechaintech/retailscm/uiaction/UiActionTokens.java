
package com.doublechaintech.retailscm.uiaction;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class UiActionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="uiAction";
	
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
	protected UiActionTokens(){
		//ensure not initialized outside the class
	}
	public  static  UiActionTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UiActionTokens tokens = new UiActionTokens(options);
		return tokens;
		
	}
	protected UiActionTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public UiActionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UiActionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UiActionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static UiActionTokens start(){
		return new UiActionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public UiActionTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static UiActionTokens allTokens(){
		
		return start()
			.withPage();
	
	}
	public static UiActionTokens withoutListsTokens(){
		
		return start()
			.withPage();
	
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
	
	public UiActionTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PAGE = "page";
	public String getPage(){
		return PAGE;
	}
	public UiActionTokens withPage(){		
		addSimpleOptions(PAGE);
		return this;
	}
	
	
	
	public  UiActionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


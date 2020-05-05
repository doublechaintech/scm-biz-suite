
package com.doublechaintech.retailscm.slide;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class SlideTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="slide";
	
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
	protected SlideTokens(){
		//ensure not initialized outside the class
	}
	public  static  SlideTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SlideTokens tokens = new SlideTokens(options);
		return tokens;
		
	}
	protected SlideTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public SlideTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SlideTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SlideTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static SlideTokens start(){
		return new SlideTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public SlideTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static SlideTokens allTokens(){
		
		return start()
			.withPage();
	
	}
	public static SlideTokens withoutListsTokens(){
		
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
	
	public SlideTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PAGE = "page";
	public String getPage(){
		return PAGE;
	}
	public SlideTokens withPage(){		
		addSimpleOptions(PAGE);
		return this;
	}
	
	
	
	public  SlideTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


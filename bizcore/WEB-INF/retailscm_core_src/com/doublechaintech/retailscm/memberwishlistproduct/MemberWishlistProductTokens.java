
package com.doublechaintech.retailscm.memberwishlistproduct;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class MemberWishlistProductTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="memberWishlistProduct";
	
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
	protected MemberWishlistProductTokens(){
		//ensure not initialized outside the class
	}
	public  static  MemberWishlistProductTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		MemberWishlistProductTokens tokens = new MemberWishlistProductTokens(options);
		return tokens;
		
	}
	protected MemberWishlistProductTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public MemberWishlistProductTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static MemberWishlistProductTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected MemberWishlistProductTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static MemberWishlistProductTokens start(){
		return new MemberWishlistProductTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public MemberWishlistProductTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static MemberWishlistProductTokens allTokens(){
		
		return start()
			.withOwner();
	
	}
	public static MemberWishlistProductTokens withoutListsTokens(){
		
		return start()
			.withOwner();
	
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
	
	public MemberWishlistProductTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public MemberWishlistProductTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	
	public  MemberWishlistProductTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


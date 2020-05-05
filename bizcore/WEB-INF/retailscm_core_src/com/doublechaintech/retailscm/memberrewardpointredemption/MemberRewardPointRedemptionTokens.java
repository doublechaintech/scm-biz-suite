
package com.doublechaintech.retailscm.memberrewardpointredemption;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class MemberRewardPointRedemptionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="memberRewardPointRedemption";
	
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
	protected MemberRewardPointRedemptionTokens(){
		//ensure not initialized outside the class
	}
	public  static  MemberRewardPointRedemptionTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		MemberRewardPointRedemptionTokens tokens = new MemberRewardPointRedemptionTokens(options);
		return tokens;
		
	}
	protected MemberRewardPointRedemptionTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public MemberRewardPointRedemptionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static MemberRewardPointRedemptionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected MemberRewardPointRedemptionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static MemberRewardPointRedemptionTokens start(){
		return new MemberRewardPointRedemptionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public MemberRewardPointRedemptionTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static MemberRewardPointRedemptionTokens allTokens(){
		
		return start()
			.withOwner();
	
	}
	public static MemberRewardPointRedemptionTokens withoutListsTokens(){
		
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
	
	public MemberRewardPointRedemptionTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public MemberRewardPointRedemptionTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	
	public  MemberRewardPointRedemptionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


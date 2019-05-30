
package com.doublechaintech.retailscm.consumerorderdelivery;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ConsumerOrderDeliveryTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="consumerOrderDelivery";
	
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
	protected ConsumerOrderDeliveryTokens(){
		//ensure not initialized outside the class
	}
	public  static  ConsumerOrderDeliveryTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ConsumerOrderDeliveryTokens tokens = new ConsumerOrderDeliveryTokens(options);
		return tokens;
		
	}
	protected ConsumerOrderDeliveryTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ConsumerOrderDeliveryTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ConsumerOrderDeliveryTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ConsumerOrderDeliveryTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ConsumerOrderDeliveryTokens start(){
		return new ConsumerOrderDeliveryTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ConsumerOrderDeliveryTokens allTokens(){
		
		return start();
	
	}
	public static ConsumerOrderDeliveryTokens withoutListsTokens(){
		
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
	
	public ConsumerOrderDeliveryTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	
	public  ConsumerOrderDeliveryTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

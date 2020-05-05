
package com.doublechaintech.retailscm.consumerorderlineitem;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ConsumerOrderLineItemTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="consumerOrderLineItem";
	
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
	protected ConsumerOrderLineItemTokens(){
		//ensure not initialized outside the class
	}
	public  static  ConsumerOrderLineItemTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ConsumerOrderLineItemTokens tokens = new ConsumerOrderLineItemTokens(options);
		return tokens;
		
	}
	protected ConsumerOrderLineItemTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ConsumerOrderLineItemTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ConsumerOrderLineItemTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ConsumerOrderLineItemTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static ConsumerOrderLineItemTokens start(){
		return new ConsumerOrderLineItemTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public ConsumerOrderLineItemTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static ConsumerOrderLineItemTokens allTokens(){
		
		return start()
			.withBizOrder();
	
	}
	public static ConsumerOrderLineItemTokens withoutListsTokens(){
		
		return start()
			.withBizOrder();
	
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
	
	public ConsumerOrderLineItemTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public ConsumerOrderLineItemTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	
	public  ConsumerOrderLineItemTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


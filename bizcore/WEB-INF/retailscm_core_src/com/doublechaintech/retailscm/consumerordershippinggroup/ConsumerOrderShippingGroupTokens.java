
package com.doublechaintech.retailscm.consumerordershippinggroup;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class ConsumerOrderShippingGroupTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="consumerOrderShippingGroup";
	
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
	protected ConsumerOrderShippingGroupTokens(){
		//ensure not initialized outside the class
	}
	public  static  ConsumerOrderShippingGroupTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ConsumerOrderShippingGroupTokens tokens = new ConsumerOrderShippingGroupTokens(options);
		return tokens;
		
	}
	protected ConsumerOrderShippingGroupTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ConsumerOrderShippingGroupTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ConsumerOrderShippingGroupTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ConsumerOrderShippingGroupTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static ConsumerOrderShippingGroupTokens start(){
		return new ConsumerOrderShippingGroupTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public ConsumerOrderShippingGroupTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static ConsumerOrderShippingGroupTokens allTokens(){
		
		return start()
			.withBizOrder();
	
	}
	public static ConsumerOrderShippingGroupTokens withoutListsTokens(){
		
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
	
	public ConsumerOrderShippingGroupTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public ConsumerOrderShippingGroupTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	
	public  ConsumerOrderShippingGroupTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


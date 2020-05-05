
package com.doublechaintech.retailscm.supplyordershippinggroup;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class SupplyOrderShippingGroupTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderShippingGroup";
	
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
	protected SupplyOrderShippingGroupTokens(){
		//ensure not initialized outside the class
	}
	public  static  SupplyOrderShippingGroupTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SupplyOrderShippingGroupTokens tokens = new SupplyOrderShippingGroupTokens(options);
		return tokens;
		
	}
	protected SupplyOrderShippingGroupTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public SupplyOrderShippingGroupTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static SupplyOrderShippingGroupTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected SupplyOrderShippingGroupTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static SupplyOrderShippingGroupTokens start(){
		return new SupplyOrderShippingGroupTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public SupplyOrderShippingGroupTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static SupplyOrderShippingGroupTokens allTokens(){
		
		return start()
			.withBizOrder();
	
	}
	public static SupplyOrderShippingGroupTokens withoutListsTokens(){
		
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
	
	public SupplyOrderShippingGroupTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	public SupplyOrderShippingGroupTokens withBizOrder(){		
		addSimpleOptions(BIZORDER);
		return this;
	}
	
	
	
	public  SupplyOrderShippingGroupTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}



package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderTokens;





public class RetailStoreOrderPaymentGroupTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreOrderPaymentGroup";

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
	protected RetailStoreOrderPaymentGroupTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreOrderPaymentGroupTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreOrderPaymentGroupTokens tokens = new RetailStoreOrderPaymentGroupTokens(options);
		return tokens;

	}
	protected RetailStoreOrderPaymentGroupTokens(Map<String,Object> options){
		this.options = options;
	}

	public RetailStoreOrderPaymentGroupTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static RetailStoreOrderPaymentGroupTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected RetailStoreOrderPaymentGroupTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static RetailStoreOrderPaymentGroupTokens start(){
		return new RetailStoreOrderPaymentGroupTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public RetailStoreOrderPaymentGroupTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static RetailStoreOrderPaymentGroupTokens loadGroupTokens(String... groupNames){
    RetailStoreOrderPaymentGroupTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, BIZORDER, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(RetailStoreOrderPaymentGroupTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static RetailStoreOrderPaymentGroupTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withBizOrder();

	}

	public static RetailStoreOrderPaymentGroupTokens allTokens(){

		return start()
			.withBizOrder();

	}
	public static RetailStoreOrderPaymentGroupTokens withoutListsTokens(){

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

	public RetailStoreOrderPaymentGroupTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	//
	public RetailStoreOrderPaymentGroupTokens withBizOrder(){
		addSimpleOptions(BIZORDER);
		return this;
	}

	public RetailStoreOrderTokens withBizOrderTokens(){
		//addSimpleOptions(BIZORDER);
		return RetailStoreOrderTokens.start();
	}

	

	public  RetailStoreOrderPaymentGroupTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


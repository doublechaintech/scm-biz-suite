
package com.doublechaintech.retailscm.supplyorderlineitem;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.supplyorder.SupplyOrderTokens;





public class SupplyOrderLineItemTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="supplyOrderLineItem";

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
	protected SupplyOrderLineItemTokens(){
		//ensure not initialized outside the class
	}
	public  static  SupplyOrderLineItemTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		SupplyOrderLineItemTokens tokens = new SupplyOrderLineItemTokens(options);
		return tokens;

	}
	protected SupplyOrderLineItemTokens(Map<String,Object> options){
		this.options = options;
	}

	public SupplyOrderLineItemTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static SupplyOrderLineItemTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected SupplyOrderLineItemTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static SupplyOrderLineItemTokens start(){
		return new SupplyOrderLineItemTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public SupplyOrderLineItemTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static SupplyOrderLineItemTokens loadGroupTokens(String... groupNames){
    SupplyOrderLineItemTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, BIZORDER, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(SupplyOrderLineItemTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static SupplyOrderLineItemTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withBizOrder();

	}

	public static SupplyOrderLineItemTokens allTokens(){

		return start()
			.withBizOrder();

	}
	public static SupplyOrderLineItemTokens withoutListsTokens(){

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

	public SupplyOrderLineItemTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BIZORDER = "bizOrder";
	public String getBizOrder(){
		return BIZORDER;
	}
	//
	public SupplyOrderLineItemTokens withBizOrder(){
		addSimpleOptions(BIZORDER);
		return this;
	}

	public SupplyOrderTokens withBizOrderTokens(){
		//addSimpleOptions(BIZORDER);
		return SupplyOrderTokens.start();
	}

	

	public  SupplyOrderLineItemTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


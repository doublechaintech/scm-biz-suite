
package com.doublechaintech.retailscm.productsupplyduration;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.supplierproduct.SupplierProductTokens;





public class ProductSupplyDurationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="productSupplyDuration";

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
	protected ProductSupplyDurationTokens(){
		//ensure not initialized outside the class
	}
	public  static  ProductSupplyDurationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ProductSupplyDurationTokens tokens = new ProductSupplyDurationTokens(options);
		return tokens;

	}
	protected ProductSupplyDurationTokens(Map<String,Object> options){
		this.options = options;
	}

	public ProductSupplyDurationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static ProductSupplyDurationTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected ProductSupplyDurationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static ProductSupplyDurationTokens start(){
		return new ProductSupplyDurationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public ProductSupplyDurationTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static ProductSupplyDurationTokens loadGroupTokens(String... groupNames){
    ProductSupplyDurationTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, PRODUCT, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(ProductSupplyDurationTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static ProductSupplyDurationTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withProduct();

	}

	public static ProductSupplyDurationTokens allTokens(){

		return start()
			.withProduct();

	}
	public static ProductSupplyDurationTokens withoutListsTokens(){

		return start()
			.withProduct();

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

	public ProductSupplyDurationTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PRODUCT = "product";
	public String getProduct(){
		return PRODUCT;
	}
	//
	public ProductSupplyDurationTokens withProduct(){
		addSimpleOptions(PRODUCT);
		return this;
	}

	public SupplierProductTokens withProductTokens(){
		//addSimpleOptions(PRODUCT);
		return SupplierProductTokens.start();
	}

	

	public  ProductSupplyDurationTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


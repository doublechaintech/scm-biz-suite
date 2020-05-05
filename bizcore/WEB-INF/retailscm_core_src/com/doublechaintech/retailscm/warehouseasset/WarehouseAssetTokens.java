
package com.doublechaintech.retailscm.warehouseasset;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class WarehouseAssetTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="warehouseAsset";
	
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
	protected WarehouseAssetTokens(){
		//ensure not initialized outside the class
	}
	public  static  WarehouseAssetTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WarehouseAssetTokens tokens = new WarehouseAssetTokens(options);
		return tokens;
		
	}
	protected WarehouseAssetTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public WarehouseAssetTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WarehouseAssetTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WarehouseAssetTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static WarehouseAssetTokens start(){
		return new WarehouseAssetTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public WarehouseAssetTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static WarehouseAssetTokens allTokens(){
		
		return start()
			.withOwner();
	
	}
	public static WarehouseAssetTokens withoutListsTokens(){
		
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
	
	public WarehouseAssetTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public WarehouseAssetTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	
	public  WarehouseAssetTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


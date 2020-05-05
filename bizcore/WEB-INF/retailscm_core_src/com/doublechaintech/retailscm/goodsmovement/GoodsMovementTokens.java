
package com.doublechaintech.retailscm.goodsmovement;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class GoodsMovementTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsMovement";
	
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
	protected GoodsMovementTokens(){
		//ensure not initialized outside the class
	}
	public  static  GoodsMovementTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GoodsMovementTokens tokens = new GoodsMovementTokens(options);
		return tokens;
		
	}
	protected GoodsMovementTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public GoodsMovementTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsMovementTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsMovementTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static GoodsMovementTokens start(){
		return new GoodsMovementTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public GoodsMovementTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static GoodsMovementTokens allTokens(){
		
		return start()
			.withGoods();
	
	}
	public static GoodsMovementTokens withoutListsTokens(){
		
		return start()
			.withGoods();
	
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
	
	public GoodsMovementTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String GOODS = "goods";
	public String getGoods(){
		return GOODS;
	}
	public GoodsMovementTokens withGoods(){		
		addSimpleOptions(GOODS);
		return this;
	}
	
	
	
	public  GoodsMovementTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


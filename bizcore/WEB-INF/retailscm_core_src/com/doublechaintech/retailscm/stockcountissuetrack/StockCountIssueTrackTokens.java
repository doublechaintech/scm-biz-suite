
package com.doublechaintech.retailscm.stockcountissuetrack;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class StockCountIssueTrackTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="stockCountIssueTrack";
	
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
	protected StockCountIssueTrackTokens(){
		//ensure not initialized outside the class
	}
	public  static  StockCountIssueTrackTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		StockCountIssueTrackTokens tokens = new StockCountIssueTrackTokens(options);
		return tokens;
		
	}
	protected StockCountIssueTrackTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public StockCountIssueTrackTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static StockCountIssueTrackTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected StockCountIssueTrackTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static StockCountIssueTrackTokens start(){
		return new StockCountIssueTrackTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public StockCountIssueTrackTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static StockCountIssueTrackTokens allTokens(){
		
		return start()
			.withStockCount();
	
	}
	public static StockCountIssueTrackTokens withoutListsTokens(){
		
		return start()
			.withStockCount();
	
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
	
	public StockCountIssueTrackTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String STOCKCOUNT = "stockCount";
	public String getStockCount(){
		return STOCKCOUNT;
	}
	public StockCountIssueTrackTokens withStockCount(){		
		addSimpleOptions(STOCKCOUNT);
		return this;
	}
	
	
	
	public  StockCountIssueTrackTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


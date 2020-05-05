
package com.doublechaintech.retailscm.goodsshelfstockcount;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class GoodsShelfStockCountTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="goodsShelfStockCount";
	
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
	protected GoodsShelfStockCountTokens(){
		//ensure not initialized outside the class
	}
	public  static  GoodsShelfStockCountTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		GoodsShelfStockCountTokens tokens = new GoodsShelfStockCountTokens(options);
		return tokens;
		
	}
	protected GoodsShelfStockCountTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public GoodsShelfStockCountTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static GoodsShelfStockCountTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected GoodsShelfStockCountTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static GoodsShelfStockCountTokens start(){
		return new GoodsShelfStockCountTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public GoodsShelfStockCountTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static GoodsShelfStockCountTokens allTokens(){
		
		return start()
			.withShelf()
			.withStockCountIssueTrackList();
	
	}
	public static GoodsShelfStockCountTokens withoutListsTokens(){
		
		return start()
			.withShelf();
	
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
	
	public GoodsShelfStockCountTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String SHELF = "shelf";
	public String getShelf(){
		return SHELF;
	}
	public GoodsShelfStockCountTokens withShelf(){		
		addSimpleOptions(SHELF);
		return this;
	}
	
	
	protected static final String STOCK_COUNT_ISSUE_TRACK_LIST = "stockCountIssueTrackList";
	public String getStockCountIssueTrackList(){
		return STOCK_COUNT_ISSUE_TRACK_LIST;
	}
	public GoodsShelfStockCountTokens withStockCountIssueTrackList(){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST);
		return this;
	}
	public GoodsShelfStockCountTokens analyzeStockCountIssueTrackList(){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeStockCountIssueTrackListEnabled(){		
		
		if(checkOptions(this.options(), STOCK_COUNT_ISSUE_TRACK_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public GoodsShelfStockCountTokens extractMoreFromStockCountIssueTrackList(String idsSeperatedWithComma){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int stockCountIssueTrackListSortCounter = 0;
	public GoodsShelfStockCountTokens sortStockCountIssueTrackListWith(String field, String descOrAsc){		
		addSortMoreOptions(STOCK_COUNT_ISSUE_TRACK_LIST,stockCountIssueTrackListSortCounter++, field, descOrAsc);
		return this;
	}
	private int stockCountIssueTrackListSearchCounter = 0;
	public GoodsShelfStockCountTokens searchStockCountIssueTrackListWith(String field, String verb, String value){		
		
		withStockCountIssueTrackList();
		addSearchMoreOptions(STOCK_COUNT_ISSUE_TRACK_LIST,stockCountIssueTrackListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsShelfStockCountTokens searchAllTextOfStockCountIssueTrackList(String verb, String value){	
		String field = "id|title|summary";
		addSearchMoreOptions(STOCK_COUNT_ISSUE_TRACK_LIST,stockCountIssueTrackListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public GoodsShelfStockCountTokens rowsPerPageOfStockCountIssueTrackList(int rowsPerPage){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public GoodsShelfStockCountTokens currentPageNumberOfStockCountIssueTrackList(int currentPageNumber){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public GoodsShelfStockCountTokens retainColumnsOfStockCountIssueTrackList(String[] columns){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST+"RetainColumns",columns);
		return this;
	}
	public GoodsShelfStockCountTokens excludeColumnsOfStockCountIssueTrackList(String[] columns){		
		addSimpleOptions(STOCK_COUNT_ISSUE_TRACK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  GoodsShelfStockCountTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfStockCountIssueTrackList(verb, value);	
		return this;
	}
}


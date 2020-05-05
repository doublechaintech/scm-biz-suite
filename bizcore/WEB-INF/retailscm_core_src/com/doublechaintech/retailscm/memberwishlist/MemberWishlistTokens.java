
package com.doublechaintech.retailscm.memberwishlist;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class MemberWishlistTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="memberWishlist";
	
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
	protected MemberWishlistTokens(){
		//ensure not initialized outside the class
	}
	public  static  MemberWishlistTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		MemberWishlistTokens tokens = new MemberWishlistTokens(options);
		return tokens;
		
	}
	protected MemberWishlistTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public MemberWishlistTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static MemberWishlistTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected MemberWishlistTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static MemberWishlistTokens start(){
		return new MemberWishlistTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public MemberWishlistTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static MemberWishlistTokens allTokens(){
		
		return start()
			.withOwner()
			.withMemberWishlistProductList();
	
	}
	public static MemberWishlistTokens withoutListsTokens(){
		
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
	
	public MemberWishlistTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public MemberWishlistTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	protected static final String MEMBER_WISHLIST_PRODUCT_LIST = "memberWishlistProductList";
	public String getMemberWishlistProductList(){
		return MEMBER_WISHLIST_PRODUCT_LIST;
	}
	public MemberWishlistTokens withMemberWishlistProductList(){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST);
		return this;
	}
	public MemberWishlistTokens analyzeMemberWishlistProductList(){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeMemberWishlistProductListEnabled(){		
		
		if(checkOptions(this.options(), MEMBER_WISHLIST_PRODUCT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public MemberWishlistTokens extractMoreFromMemberWishlistProductList(String idsSeperatedWithComma){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int memberWishlistProductListSortCounter = 0;
	public MemberWishlistTokens sortMemberWishlistProductListWith(String field, String descOrAsc){		
		addSortMoreOptions(MEMBER_WISHLIST_PRODUCT_LIST,memberWishlistProductListSortCounter++, field, descOrAsc);
		return this;
	}
	private int memberWishlistProductListSearchCounter = 0;
	public MemberWishlistTokens searchMemberWishlistProductListWith(String field, String verb, String value){		
		
		withMemberWishlistProductList();
		addSearchMoreOptions(MEMBER_WISHLIST_PRODUCT_LIST,memberWishlistProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MemberWishlistTokens searchAllTextOfMemberWishlistProductList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(MEMBER_WISHLIST_PRODUCT_LIST,memberWishlistProductListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public MemberWishlistTokens rowsPerPageOfMemberWishlistProductList(int rowsPerPage){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public MemberWishlistTokens currentPageNumberOfMemberWishlistProductList(int currentPageNumber){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public MemberWishlistTokens retainColumnsOfMemberWishlistProductList(String[] columns){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST+"RetainColumns",columns);
		return this;
	}
	public MemberWishlistTokens excludeColumnsOfMemberWishlistProductList(String[] columns){		
		addSimpleOptions(MEMBER_WISHLIST_PRODUCT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  MemberWishlistTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfMemberWishlistProductList(verb, value);	
		return this;
	}
}


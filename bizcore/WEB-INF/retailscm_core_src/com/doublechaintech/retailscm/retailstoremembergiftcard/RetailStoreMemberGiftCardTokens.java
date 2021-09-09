
package com.doublechaintech.retailscm.retailstoremembergiftcard;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberTokens;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTokens;





public class RetailStoreMemberGiftCardTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreMemberGiftCard";

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
	protected RetailStoreMemberGiftCardTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreMemberGiftCardTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreMemberGiftCardTokens tokens = new RetailStoreMemberGiftCardTokens(options);
		return tokens;

	}
	protected RetailStoreMemberGiftCardTokens(Map<String,Object> options){
		this.options = options;
	}

	public RetailStoreMemberGiftCardTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static RetailStoreMemberGiftCardTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected RetailStoreMemberGiftCardTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static RetailStoreMemberGiftCardTokens start(){
		return new RetailStoreMemberGiftCardTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public RetailStoreMemberGiftCardTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static RetailStoreMemberGiftCardTokens loadGroupTokens(String... groupNames){
    RetailStoreMemberGiftCardTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, OWNER, groupNames, new String[]{"default"});

  
     addToken(tokens, RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(RetailStoreMemberGiftCardTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static RetailStoreMemberGiftCardTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withOwner()
			.withRetailStoreMemberGiftCardConsumeRecordListIfViewGroupInclude(viewGroups);

	}

	public static RetailStoreMemberGiftCardTokens allTokens(){

		return start()
			.withOwner()
			.withRetailStoreMemberGiftCardConsumeRecordList();

	}
	public static RetailStoreMemberGiftCardTokens withoutListsTokens(){

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

	public RetailStoreMemberGiftCardTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	//
	public RetailStoreMemberGiftCardTokens withOwner(){
		addSimpleOptions(OWNER);
		return this;
	}

	public RetailStoreMemberTokens withOwnerTokens(){
		//addSimpleOptions(OWNER);
		return RetailStoreMemberTokens.start();
	}

	
	protected static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";
	public String getRetailStoreMemberGiftCardConsumeRecordList(){
		return RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST;
	}



	public RetailStoreMemberGiftCardTokens withRetailStoreMemberGiftCardConsumeRecordListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		}
		return this;
	}


	public RetailStoreMemberGiftCardTokens withRetailStoreMemberGiftCardConsumeRecordList(){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		return this;
	}

	public RetailStoreMemberGiftCardConsumeRecordTokens withRetailStoreMemberGiftCardConsumeRecordListTokens(){
		//addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
		return RetailStoreMemberGiftCardConsumeRecordTokens.start();
	}

	public RetailStoreMemberGiftCardTokens analyzeRetailStoreMemberGiftCardConsumeRecordList(){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreMemberGiftCardConsumeRecordListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreMemberGiftCardTokens extractMoreFromRetailStoreMemberGiftCardConsumeRecordList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreMemberGiftCardConsumeRecordListSortCounter = 0;
	public RetailStoreMemberGiftCardTokens sortRetailStoreMemberGiftCardConsumeRecordListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,retailStoreMemberGiftCardConsumeRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreMemberGiftCardConsumeRecordListSearchCounter = 0;
	public RetailStoreMemberGiftCardTokens searchRetailStoreMemberGiftCardConsumeRecordListWith(String field, String verb, String value){

		withRetailStoreMemberGiftCardConsumeRecordList();
		addSearchMoreOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,retailStoreMemberGiftCardConsumeRecordListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreMemberGiftCardTokens searchAllTextOfRetailStoreMemberGiftCardConsumeRecordList(String verb, String value){
		String field = "id|number";
		addSearchMoreOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST,retailStoreMemberGiftCardConsumeRecordListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreMemberGiftCardTokens rowsPerPageOfRetailStoreMemberGiftCardConsumeRecordList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreMemberGiftCardTokens currentPageNumberOfRetailStoreMemberGiftCardConsumeRecordList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreMemberGiftCardTokens retainColumnsOfRetailStoreMemberGiftCardConsumeRecordList(String[] columns){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreMemberGiftCardTokens excludeColumnsOfRetailStoreMemberGiftCardConsumeRecordList(String[] columns){
		addSimpleOptions(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  RetailStoreMemberGiftCardTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfRetailStoreMemberGiftCardConsumeRecordList(verb, value);
		return this;
	}
}



package com.doublechaintech.retailscm.originalvoucher;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentTokens;





public class OriginalVoucherTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="originalVoucher";

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
	protected OriginalVoucherTokens(){
		//ensure not initialized outside the class
	}
	public  static  OriginalVoucherTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		OriginalVoucherTokens tokens = new OriginalVoucherTokens(options);
		return tokens;

	}
	protected OriginalVoucherTokens(Map<String,Object> options){
		this.options = options;
	}

	public OriginalVoucherTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static OriginalVoucherTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected OriginalVoucherTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static OriginalVoucherTokens start(){
		return new OriginalVoucherTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public OriginalVoucherTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static OriginalVoucherTokens loadGroupTokens(String... groupNames){
    OriginalVoucherTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, BELONGSTO, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(OriginalVoucherTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static OriginalVoucherTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withBelongsTo();

	}

	public static OriginalVoucherTokens allTokens(){

		return start()
			.withBelongsTo();

	}
	public static OriginalVoucherTokens withoutListsTokens(){

		return start()
			.withBelongsTo();

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

	public OriginalVoucherTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	//
	public OriginalVoucherTokens withBelongsTo(){
		addSimpleOptions(BELONGSTO);
		return this;
	}

	public AccountingDocumentTokens withBelongsToTokens(){
		//addSimpleOptions(BELONGSTO);
		return AccountingDocumentTokens.start();
	}

	

	public  OriginalVoucherTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


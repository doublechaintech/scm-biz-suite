
package com.doublechaintech.retailscm.pagetype;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.mobileapp.MobileAppTokens;





public class PageTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="pageType";

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
	protected PageTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  PageTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PageTypeTokens tokens = new PageTypeTokens(options);
		return tokens;

	}
	protected PageTypeTokens(Map<String,Object> options){
		this.options = options;
	}

	public PageTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static PageTypeTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected PageTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static PageTypeTokens start(){
		return new PageTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public PageTypeTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static PageTypeTokens loadGroupTokens(String... groupNames){
    PageTypeTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, MOBILEAPP, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(PageTypeTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static PageTypeTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withMobileApp();

	}

	public static PageTypeTokens allTokens(){

		return start()
			.withMobileApp();

	}
	public static PageTypeTokens withoutListsTokens(){

		return start()
			.withMobileApp();

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

	public PageTypeTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String MOBILEAPP = "mobileApp";
	public String getMobileApp(){
		return MOBILEAPP;
	}
	//
	public PageTypeTokens withMobileApp(){
		addSimpleOptions(MOBILEAPP);
		return this;
	}

	public MobileAppTokens withMobileAppTokens(){
		//addSimpleOptions(MOBILEAPP);
		return MobileAppTokens.start();
	}

	

	public  PageTypeTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


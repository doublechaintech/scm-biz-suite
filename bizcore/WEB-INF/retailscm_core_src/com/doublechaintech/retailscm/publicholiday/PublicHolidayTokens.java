
package com.doublechaintech.retailscm.publicholiday;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;





public class PublicHolidayTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="publicHoliday";

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
	protected PublicHolidayTokens(){
		//ensure not initialized outside the class
	}
	public  static  PublicHolidayTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PublicHolidayTokens tokens = new PublicHolidayTokens(options);
		return tokens;

	}
	protected PublicHolidayTokens(Map<String,Object> options){
		this.options = options;
	}

	public PublicHolidayTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static PublicHolidayTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected PublicHolidayTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static PublicHolidayTokens start(){
		return new PublicHolidayTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public PublicHolidayTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static PublicHolidayTokens loadGroupTokens(String... groupNames){
    PublicHolidayTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, COMPANY, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(PublicHolidayTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static PublicHolidayTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCompany();

	}

	public static PublicHolidayTokens allTokens(){

		return start()
			.withCompany();

	}
	public static PublicHolidayTokens withoutListsTokens(){

		return start()
			.withCompany();

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

	public PublicHolidayTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String COMPANY = "company";
	public String getCompany(){
		return COMPANY;
	}
	//
	public PublicHolidayTokens withCompany(){
		addSimpleOptions(COMPANY);
		return this;
	}

	public RetailStoreCountryCenterTokens withCompanyTokens(){
		//addSimpleOptions(COMPANY);
		return RetailStoreCountryCenterTokens.start();
	}

	

	public  PublicHolidayTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


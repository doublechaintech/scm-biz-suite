
package com.doublechaintech.retailscm.citypartner;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTokens;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerTokens;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactTokens;





public class CityPartnerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="cityPartner";

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
	protected CityPartnerTokens(){
		//ensure not initialized outside the class
	}
	public  static  CityPartnerTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		CityPartnerTokens tokens = new CityPartnerTokens(options);
		return tokens;

	}
	protected CityPartnerTokens(Map<String,Object> options){
		this.options = options;
	}

	public CityPartnerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static CityPartnerTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected CityPartnerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static CityPartnerTokens start(){
		return new CityPartnerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public CityPartnerTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static CityPartnerTokens loadGroupTokens(String... groupNames){
    CityPartnerTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, CITYSERVICECENTER, groupNames, new String[]{"default"});

  
     addToken(tokens, POTENTIAL_CUSTOMER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, POTENTIAL_CUSTOMER_CONTACT_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(CityPartnerTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static CityPartnerTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCityServiceCenter()
			.withPotentialCustomerListIfViewGroupInclude(viewGroups)
			.withPotentialCustomerContactListIfViewGroupInclude(viewGroups);

	}

	public static CityPartnerTokens allTokens(){

		return start()
			.withCityServiceCenter()
			.withPotentialCustomerList()
			.withPotentialCustomerContactList();

	}
	public static CityPartnerTokens withoutListsTokens(){

		return start()
			.withCityServiceCenter();

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

	public CityPartnerTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CITYSERVICECENTER = "cityServiceCenter";
	public String getCityServiceCenter(){
		return CITYSERVICECENTER;
	}
	//
	public CityPartnerTokens withCityServiceCenter(){
		addSimpleOptions(CITYSERVICECENTER);
		return this;
	}

	public RetailStoreCityServiceCenterTokens withCityServiceCenterTokens(){
		//addSimpleOptions(CITYSERVICECENTER);
		return RetailStoreCityServiceCenterTokens.start();
	}

	
	protected static final String POTENTIAL_CUSTOMER_LIST = "potentialCustomerList";
	public String getPotentialCustomerList(){
		return POTENTIAL_CUSTOMER_LIST;
	}



	public CityPartnerTokens withPotentialCustomerListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		}
		return this;
	}


	public CityPartnerTokens withPotentialCustomerList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return this;
	}

	public PotentialCustomerTokens withPotentialCustomerListTokens(){
		//addSimpleOptions(POTENTIAL_CUSTOMER_LIST);
		return PotentialCustomerTokens.start();
	}

	public CityPartnerTokens analyzePotentialCustomerList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+".anaylze");
		return this;
	}
	public boolean analyzePotentialCustomerListEnabled(){

		if(checkOptions(this.options(), POTENTIAL_CUSTOMER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public CityPartnerTokens extractMoreFromPotentialCustomerList(String idsSeperatedWithComma){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int potentialCustomerListSortCounter = 0;
	public CityPartnerTokens sortPotentialCustomerListWith(String field, String descOrAsc){
		addSortMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int potentialCustomerListSearchCounter = 0;
	public CityPartnerTokens searchPotentialCustomerListWith(String field, String verb, String value){

		withPotentialCustomerList();
		addSearchMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSearchCounter++, field, verb, value);
		return this;
	}



	public CityPartnerTokens searchAllTextOfPotentialCustomerList(String verb, String value){
		String field = "id|name|mobile|description";
		addSearchMoreOptions(POTENTIAL_CUSTOMER_LIST,potentialCustomerListSearchCounter++, field, verb, value);
		return this;
	}



	public CityPartnerTokens rowsPerPageOfPotentialCustomerList(int rowsPerPage){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CityPartnerTokens currentPageNumberOfPotentialCustomerList(int currentPageNumber){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CityPartnerTokens retainColumnsOfPotentialCustomerList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"RetainColumns",columns);
		return this;
	}
	public CityPartnerTokens excludeColumnsOfPotentialCustomerList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	public String getPotentialCustomerContactList(){
		return POTENTIAL_CUSTOMER_CONTACT_LIST;
	}



	public CityPartnerTokens withPotentialCustomerContactListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		}
		return this;
	}


	public CityPartnerTokens withPotentialCustomerContactList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		return this;
	}

	public PotentialCustomerContactTokens withPotentialCustomerContactListTokens(){
		//addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		return PotentialCustomerContactTokens.start();
	}

	public CityPartnerTokens analyzePotentialCustomerContactList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+".anaylze");
		return this;
	}
	public boolean analyzePotentialCustomerContactListEnabled(){

		if(checkOptions(this.options(), POTENTIAL_CUSTOMER_CONTACT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public CityPartnerTokens extractMoreFromPotentialCustomerContactList(String idsSeperatedWithComma){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int potentialCustomerContactListSortCounter = 0;
	public CityPartnerTokens sortPotentialCustomerContactListWith(String field, String descOrAsc){
		addSortMoreOptions(POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactListSortCounter++, field, descOrAsc);
		return this;
	}
	private int potentialCustomerContactListSearchCounter = 0;
	public CityPartnerTokens searchPotentialCustomerContactListWith(String field, String verb, String value){

		withPotentialCustomerContactList();
		addSearchMoreOptions(POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactListSearchCounter++, field, verb, value);
		return this;
	}



	public CityPartnerTokens searchAllTextOfPotentialCustomerContactList(String verb, String value){
		String field = "id|name|contactMethod|description";
		addSearchMoreOptions(POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactListSearchCounter++, field, verb, value);
		return this;
	}



	public CityPartnerTokens rowsPerPageOfPotentialCustomerContactList(int rowsPerPage){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CityPartnerTokens currentPageNumberOfPotentialCustomerContactList(int currentPageNumber){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CityPartnerTokens retainColumnsOfPotentialCustomerContactList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"RetainColumns",columns);
		return this;
	}
	public CityPartnerTokens excludeColumnsOfPotentialCustomerContactList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  CityPartnerTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfPotentialCustomerList(verb, value);
		searchAllTextOfPotentialCustomerContactList(verb, value);
		return this;
	}
}


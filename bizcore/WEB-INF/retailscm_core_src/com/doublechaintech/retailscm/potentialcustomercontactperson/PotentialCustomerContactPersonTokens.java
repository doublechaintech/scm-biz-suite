
package com.doublechaintech.retailscm.potentialcustomercontactperson;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerTokens;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactTokens;





public class PotentialCustomerContactPersonTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="potentialCustomerContactPerson";

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
	protected PotentialCustomerContactPersonTokens(){
		//ensure not initialized outside the class
	}
	public  static  PotentialCustomerContactPersonTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PotentialCustomerContactPersonTokens tokens = new PotentialCustomerContactPersonTokens(options);
		return tokens;

	}
	protected PotentialCustomerContactPersonTokens(Map<String,Object> options){
		this.options = options;
	}

	public PotentialCustomerContactPersonTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static PotentialCustomerContactPersonTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected PotentialCustomerContactPersonTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static PotentialCustomerContactPersonTokens start(){
		return new PotentialCustomerContactPersonTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public PotentialCustomerContactPersonTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static PotentialCustomerContactPersonTokens loadGroupTokens(String... groupNames){
    PotentialCustomerContactPersonTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, POTENTIALCUSTOMER, groupNames, new String[]{"default"});

  
     addToken(tokens, POTENTIAL_CUSTOMER_CONTACT_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(PotentialCustomerContactPersonTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static PotentialCustomerContactPersonTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withPotentialCustomer()
			.withPotentialCustomerContactListIfViewGroupInclude(viewGroups);

	}

	public static PotentialCustomerContactPersonTokens allTokens(){

		return start()
			.withPotentialCustomer()
			.withPotentialCustomerContactList();

	}
	public static PotentialCustomerContactPersonTokens withoutListsTokens(){

		return start()
			.withPotentialCustomer();

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

	public PotentialCustomerContactPersonTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String POTENTIALCUSTOMER = "potentialCustomer";
	public String getPotentialCustomer(){
		return POTENTIALCUSTOMER;
	}
	//
	public PotentialCustomerContactPersonTokens withPotentialCustomer(){
		addSimpleOptions(POTENTIALCUSTOMER);
		return this;
	}

	public PotentialCustomerTokens withPotentialCustomerTokens(){
		//addSimpleOptions(POTENTIALCUSTOMER);
		return PotentialCustomerTokens.start();
	}

	
	protected static final String POTENTIAL_CUSTOMER_CONTACT_LIST = "potentialCustomerContactList";
	public String getPotentialCustomerContactList(){
		return POTENTIAL_CUSTOMER_CONTACT_LIST;
	}



	public PotentialCustomerContactPersonTokens withPotentialCustomerContactListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		}
		return this;
	}


	public PotentialCustomerContactPersonTokens withPotentialCustomerContactList(){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		return this;
	}

	public PotentialCustomerContactTokens withPotentialCustomerContactListTokens(){
		//addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST);
		return PotentialCustomerContactTokens.start();
	}

	public PotentialCustomerContactPersonTokens analyzePotentialCustomerContactList(){
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
	public PotentialCustomerContactPersonTokens extractMoreFromPotentialCustomerContactList(String idsSeperatedWithComma){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int potentialCustomerContactListSortCounter = 0;
	public PotentialCustomerContactPersonTokens sortPotentialCustomerContactListWith(String field, String descOrAsc){
		addSortMoreOptions(POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactListSortCounter++, field, descOrAsc);
		return this;
	}
	private int potentialCustomerContactListSearchCounter = 0;
	public PotentialCustomerContactPersonTokens searchPotentialCustomerContactListWith(String field, String verb, String value){

		withPotentialCustomerContactList();
		addSearchMoreOptions(POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactListSearchCounter++, field, verb, value);
		return this;
	}



	public PotentialCustomerContactPersonTokens searchAllTextOfPotentialCustomerContactList(String verb, String value){
		String field = "id|name|contactMethod|description";
		addSearchMoreOptions(POTENTIAL_CUSTOMER_CONTACT_LIST,potentialCustomerContactListSearchCounter++, field, verb, value);
		return this;
	}



	public PotentialCustomerContactPersonTokens rowsPerPageOfPotentialCustomerContactList(int rowsPerPage){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PotentialCustomerContactPersonTokens currentPageNumberOfPotentialCustomerContactList(int currentPageNumber){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PotentialCustomerContactPersonTokens retainColumnsOfPotentialCustomerContactList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"RetainColumns",columns);
		return this;
	}
	public PotentialCustomerContactPersonTokens excludeColumnsOfPotentialCustomerContactList(String[] columns){
		addSimpleOptions(POTENTIAL_CUSTOMER_CONTACT_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  PotentialCustomerContactPersonTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfPotentialCustomerContactList(verb, value);
		return this;
	}
}


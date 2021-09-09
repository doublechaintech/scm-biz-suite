
package com.doublechaintech.retailscm.potentialcustomercontact;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerTokens;
import com.doublechaintech.retailscm.citypartner.CityPartnerTokens;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTokens;





public class PotentialCustomerContactTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="potentialCustomerContact";

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
	protected PotentialCustomerContactTokens(){
		//ensure not initialized outside the class
	}
	public  static  PotentialCustomerContactTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PotentialCustomerContactTokens tokens = new PotentialCustomerContactTokens(options);
		return tokens;

	}
	protected PotentialCustomerContactTokens(Map<String,Object> options){
		this.options = options;
	}

	public PotentialCustomerContactTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static PotentialCustomerContactTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected PotentialCustomerContactTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static PotentialCustomerContactTokens start(){
		return new PotentialCustomerContactTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public PotentialCustomerContactTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static PotentialCustomerContactTokens loadGroupTokens(String... groupNames){
    PotentialCustomerContactTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, POTENTIALCUSTOMER, groupNames, new String[]{"default"});addToken(tokens, CITYPARTNER, groupNames, new String[]{"default"});addToken(tokens, CONTACTTO, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(PotentialCustomerContactTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static PotentialCustomerContactTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withPotentialCustomer()
			.withCityPartner()
			.withContactTo();

	}

	public static PotentialCustomerContactTokens allTokens(){

		return start()
			.withPotentialCustomer()
			.withCityPartner()
			.withContactTo();

	}
	public static PotentialCustomerContactTokens withoutListsTokens(){

		return start()
			.withPotentialCustomer()
			.withCityPartner()
			.withContactTo();

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

	public PotentialCustomerContactTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String POTENTIALCUSTOMER = "potentialCustomer";
	public String getPotentialCustomer(){
		return POTENTIALCUSTOMER;
	}
	//
	public PotentialCustomerContactTokens withPotentialCustomer(){
		addSimpleOptions(POTENTIALCUSTOMER);
		return this;
	}

	public PotentialCustomerTokens withPotentialCustomerTokens(){
		//addSimpleOptions(POTENTIALCUSTOMER);
		return PotentialCustomerTokens.start();
	}

	
	protected static final String CITYPARTNER = "cityPartner";
	public String getCityPartner(){
		return CITYPARTNER;
	}
	//
	public PotentialCustomerContactTokens withCityPartner(){
		addSimpleOptions(CITYPARTNER);
		return this;
	}

	public CityPartnerTokens withCityPartnerTokens(){
		//addSimpleOptions(CITYPARTNER);
		return CityPartnerTokens.start();
	}

	
	protected static final String CONTACTTO = "contactTo";
	public String getContactTo(){
		return CONTACTTO;
	}
	//
	public PotentialCustomerContactTokens withContactTo(){
		addSimpleOptions(CONTACTTO);
		return this;
	}

	public PotentialCustomerContactPersonTokens withContactToTokens(){
		//addSimpleOptions(CONTACTTO);
		return PotentialCustomerContactPersonTokens.start();
	}

	

	public  PotentialCustomerContactTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}


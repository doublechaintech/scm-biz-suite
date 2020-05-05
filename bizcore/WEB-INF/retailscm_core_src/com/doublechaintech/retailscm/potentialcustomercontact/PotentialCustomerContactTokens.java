
package com.doublechaintech.retailscm.potentialcustomercontact;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
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
	
	protected static PotentialCustomerContactTokens allTokens(){
		
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
	public PotentialCustomerContactTokens withPotentialCustomer(){		
		addSimpleOptions(POTENTIALCUSTOMER);
		return this;
	}
	
	
	protected static final String CITYPARTNER = "cityPartner";
	public String getCityPartner(){
		return CITYPARTNER;
	}
	public PotentialCustomerContactTokens withCityPartner(){		
		addSimpleOptions(CITYPARTNER);
		return this;
	}
	
	
	protected static final String CONTACTTO = "contactTo";
	public String getContactTo(){
		return CONTACTTO;
	}
	public PotentialCustomerContactTokens withContactTo(){		
		addSimpleOptions(CONTACTTO);
		return this;
	}
	
	
	
	public  PotentialCustomerContactTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


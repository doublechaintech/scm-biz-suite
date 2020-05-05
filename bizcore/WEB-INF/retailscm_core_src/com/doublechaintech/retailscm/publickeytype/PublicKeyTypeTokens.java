
package com.doublechaintech.retailscm.publickeytype;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class PublicKeyTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="publicKeyType";
	
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
	protected PublicKeyTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  PublicKeyTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PublicKeyTypeTokens tokens = new PublicKeyTypeTokens(options);
		return tokens;
		
	}
	protected PublicKeyTypeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PublicKeyTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PublicKeyTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PublicKeyTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static PublicKeyTypeTokens start(){
		return new PublicKeyTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public PublicKeyTypeTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static PublicKeyTypeTokens allTokens(){
		
		return start()
			.withDomain()
			.withKeypairIdentifyList();
	
	}
	public static PublicKeyTypeTokens withoutListsTokens(){
		
		return start()
			.withDomain();
	
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
	
	public PublicKeyTypeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DOMAIN = "domain";
	public String getDomain(){
		return DOMAIN;
	}
	public PublicKeyTypeTokens withDomain(){		
		addSimpleOptions(DOMAIN);
		return this;
	}
	
	
	protected static final String KEYPAIR_IDENTIFY_LIST = "keypairIdentifyList";
	public String getKeypairIdentifyList(){
		return KEYPAIR_IDENTIFY_LIST;
	}
	public PublicKeyTypeTokens withKeypairIdentifyList(){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST);
		return this;
	}
	public PublicKeyTypeTokens analyzeKeypairIdentifyList(){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeKeypairIdentifyListEnabled(){		
		
		if(checkOptions(this.options(), KEYPAIR_IDENTIFY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PublicKeyTypeTokens extractMoreFromKeypairIdentifyList(String idsSeperatedWithComma){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int keypairIdentifyListSortCounter = 0;
	public PublicKeyTypeTokens sortKeypairIdentifyListWith(String field, String descOrAsc){		
		addSortMoreOptions(KEYPAIR_IDENTIFY_LIST,keypairIdentifyListSortCounter++, field, descOrAsc);
		return this;
	}
	private int keypairIdentifyListSearchCounter = 0;
	public PublicKeyTypeTokens searchKeypairIdentifyListWith(String field, String verb, String value){		
		
		withKeypairIdentifyList();
		addSearchMoreOptions(KEYPAIR_IDENTIFY_LIST,keypairIdentifyListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PublicKeyTypeTokens searchAllTextOfKeypairIdentifyList(String verb, String value){	
		String field = "id|publicKey";
		addSearchMoreOptions(KEYPAIR_IDENTIFY_LIST,keypairIdentifyListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PublicKeyTypeTokens rowsPerPageOfKeypairIdentifyList(int rowsPerPage){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PublicKeyTypeTokens currentPageNumberOfKeypairIdentifyList(int currentPageNumber){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PublicKeyTypeTokens retainColumnsOfKeypairIdentifyList(String[] columns){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST+"RetainColumns",columns);
		return this;
	}
	public PublicKeyTypeTokens excludeColumnsOfKeypairIdentifyList(String[] columns){		
		addSimpleOptions(KEYPAIR_IDENTIFY_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PublicKeyTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfKeypairIdentifyList(verb, value);	
		return this;
	}
}


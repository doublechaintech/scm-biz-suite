
package com.doublechaintech.retailscm.originalvoucherauditing;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class OriginalVoucherAuditingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="originalVoucherAuditing";
	
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
	protected OriginalVoucherAuditingTokens(){
		//ensure not initialized outside the class
	}
	
	public OriginalVoucherAuditingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static OriginalVoucherAuditingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected OriginalVoucherAuditingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static OriginalVoucherAuditingTokens start(){
		return new OriginalVoucherAuditingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static OriginalVoucherAuditingTokens allTokens(){
		
		return start()
			.withOriginalVoucherList();
	
	}
	public static OriginalVoucherAuditingTokens withoutListsTokens(){
		
		return start();
	
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

	protected static final String ORIGINAL_VOUCHER_LIST = "originalVoucherList";
	public String getOriginalVoucherList(){
		return ORIGINAL_VOUCHER_LIST;
	}
	public OriginalVoucherAuditingTokens withOriginalVoucherList(){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST);
		return this;
	}
	public OriginalVoucherAuditingTokens analyzeOriginalVoucherList(){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeOriginalVoucherListEnabled(){		
		
		return checkOptions(this.options(), ORIGINAL_VOUCHER_LIST+".anaylze");
	}
	public OriginalVoucherAuditingTokens extractMoreFromOriginalVoucherList(String idsSeperatedWithComma){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int originalVoucherListSortCounter = 0;
	public OriginalVoucherAuditingTokens sortOriginalVoucherListWith(String field, String descOrAsc){		
		addSortMoreOptions(ORIGINAL_VOUCHER_LIST,originalVoucherListSortCounter++, field, descOrAsc);
		return this;
	}
	private int originalVoucherListSearchCounter = 0;
	public OriginalVoucherAuditingTokens searchOriginalVoucherListWith(String field, String verb, String value){		
		addSearchMoreOptions(ORIGINAL_VOUCHER_LIST,originalVoucherListSearchCounter++, field, verb, value);
		return this;
	}
	
	public OriginalVoucherAuditingTokens searchAllTextOfOriginalVoucherList(String verb, String value){	
		String field = "id|title|madeBy|receivedBy|voucherType|currentStatus";
		addSearchMoreOptions(ORIGINAL_VOUCHER_LIST,originalVoucherListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public OriginalVoucherAuditingTokens rowsPerPageOfOriginalVoucherList(int rowsPerPage){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public OriginalVoucherAuditingTokens currentPageNumberOfOriginalVoucherList(int currentPageNumber){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public OriginalVoucherAuditingTokens retainColumnsOfOriginalVoucherList(String[] columns){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST+"RetainColumns",columns);
		return this;
	}
	public OriginalVoucherAuditingTokens excludeColumnsOfOriginalVoucherList(String[] columns){		
		addSimpleOptions(ORIGINAL_VOUCHER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  OriginalVoucherAuditingTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfOriginalVoucherList(verb, value);	
		return this;
	}
}


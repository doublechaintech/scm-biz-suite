
package com.doublechaintech.retailscm.originalvoucher;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
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
	
	protected static OriginalVoucherTokens allTokens(){
		
		return start()
			.withBelongsTo()
			.withCreation()
			.withConfirmation()
			.withAuditing();
	
	}
	public static OriginalVoucherTokens withoutListsTokens(){
		
		return start()
			.withBelongsTo()
			.withCreation()
			.withConfirmation()
			.withAuditing();
	
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

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	public OriginalVoucherTokens withBelongsTo(){		
		addSimpleOptions(BELONGSTO);
		return this;
	}
	
	
	protected static final String CREATION = "creation";
	public String getCreation(){
		return CREATION;
	}
	public OriginalVoucherTokens withCreation(){		
		addSimpleOptions(CREATION);
		return this;
	}
	
	
	protected static final String CONFIRMATION = "confirmation";
	public String getConfirmation(){
		return CONFIRMATION;
	}
	public OriginalVoucherTokens withConfirmation(){		
		addSimpleOptions(CONFIRMATION);
		return this;
	}
	
	
	protected static final String AUDITING = "auditing";
	public String getAuditing(){
		return AUDITING;
	}
	public OriginalVoucherTokens withAuditing(){		
		addSimpleOptions(AUDITING);
		return this;
	}
	
	
	
	public  OriginalVoucherTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


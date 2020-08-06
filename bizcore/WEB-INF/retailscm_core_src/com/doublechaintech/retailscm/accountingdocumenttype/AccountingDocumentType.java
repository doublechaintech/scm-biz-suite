
package com.doublechaintech.retailscm.accountingdocumenttype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;









@JsonSerialize(using = AccountingDocumentTypeSerializer.class)
public class AccountingDocumentType extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String ACCOUNTING_PERIOD_PROPERTY     = "accountingPeriod"  ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LIST                 = "accountingDocumentList";

	public static final String INTERNAL_TYPE="AccountingDocumentType";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		AccountSet          	mAccountingPeriod   ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocument>	mAccountingDocumentList;

	
		
	public 	AccountingDocumentType(){
		// lazy load for all the properties
	}
	public 	static AccountingDocumentType withId(String id){
		AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
		accountingDocumentType.setId(id);
		accountingDocumentType.setVersion(Integer.MAX_VALUE);
		return accountingDocumentType;
	}
	public 	static AccountingDocumentType refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAccountingPeriod( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
	
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(ACCOUNTING_PERIOD_PROPERTY.equals(property)){
			return getAccountingPeriod();
		}
		if(ACCOUNTING_DOCUMENT_LIST.equals(property)){
			List<BaseEntity> list = getAccountingDocumentList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public AccountingDocumentType updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public AccountingDocumentType updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public AccountingDocumentType updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setAccountingPeriod(AccountSet accountingPeriod){
		this.mAccountingPeriod = accountingPeriod;;
	}
	public AccountSet getAccountingPeriod(){
		return this.mAccountingPeriod;
	}
	public AccountingDocumentType updateAccountingPeriod(AccountSet accountingPeriod){
		this.mAccountingPeriod = accountingPeriod;;
		this.changed = true;
		return this;
	}
	public void mergeAccountingPeriod(AccountSet accountingPeriod){
		if(accountingPeriod != null) { setAccountingPeriod(accountingPeriod);}
	}
	
	
	public void clearAccountingPeriod(){
		setAccountingPeriod ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public AccountingDocumentType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<AccountingDocument> getAccountingDocumentList(){
		if(this.mAccountingDocumentList == null){
			this.mAccountingDocumentList = new SmartList<AccountingDocument>();
			this.mAccountingDocumentList.setListInternalName (ACCOUNTING_DOCUMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountingDocumentList;	
	}
	public  void setAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setDocumentType(this);
		}

		this.mAccountingDocumentList = accountingDocumentList;
		this.mAccountingDocumentList.setListInternalName (ACCOUNTING_DOCUMENT_LIST );
		
	}
	
	public  void addAccountingDocument(AccountingDocument accountingDocument){
		accountingDocument.setDocumentType(this);
		getAccountingDocumentList().add(accountingDocument);
	}
	public  void addAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setDocumentType(this);
		}
		getAccountingDocumentList().addAll(accountingDocumentList);
	}
	public  void mergeAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		if(accountingDocumentList==null){
			return;
		}
		if(accountingDocumentList.isEmpty()){
			return;
		}
		addAccountingDocumentList( accountingDocumentList );
		
	}
	public  AccountingDocument removeAccountingDocument(AccountingDocument accountingDocumentIndex){
		
		int index = getAccountingDocumentList().indexOf(accountingDocumentIndex);
        if(index < 0){
        	String message = "AccountingDocument("+accountingDocumentIndex.getId()+") with version='"+accountingDocumentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountingDocument accountingDocument = getAccountingDocumentList().get(index);        
        // accountingDocument.clearDocumentType(); //disconnect with DocumentType
        accountingDocument.clearFromAll(); //disconnect with DocumentType
		
		boolean result = getAccountingDocumentList().planToRemove(accountingDocument);
        if(!result){
        	String message = "AccountingDocument("+accountingDocumentIndex.getId()+") with version='"+accountingDocumentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountingDocument;
        
	
	}
	//断舍离
	public  void breakWithAccountingDocument(AccountingDocument accountingDocument){
		
		if(accountingDocument == null){
			return;
		}
		accountingDocument.setDocumentType(null);
		//getAccountingDocumentList().remove();
	
	}
	
	public  boolean hasAccountingDocument(AccountingDocument accountingDocument){
	
		return getAccountingDocumentList().contains(accountingDocument);
  
	}
	
	public void copyAccountingDocumentFrom(AccountingDocument accountingDocument) {

		AccountingDocument accountingDocumentInList = findTheAccountingDocument(accountingDocument);
		AccountingDocument newAccountingDocument = new AccountingDocument();
		accountingDocumentInList.copyTo(newAccountingDocument);
		newAccountingDocument.setVersion(0);//will trigger copy
		getAccountingDocumentList().add(newAccountingDocument);
		addItemToFlexiableObject(COPIED_CHILD, newAccountingDocument);
	}
	
	public  AccountingDocument findTheAccountingDocument(AccountingDocument accountingDocument){
		
		int index =  getAccountingDocumentList().indexOf(accountingDocument);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountingDocument("+accountingDocument.getId()+") with version='"+accountingDocument.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountingDocumentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingDocumentList(){
		getAccountingDocumentList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getAccountingPeriod(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getAccountingDocumentList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getAccountingDocumentList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriod());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ACCOUNTING_DOCUMENT_LIST, getAccountingDocumentList());
		if(!getAccountingDocumentList().isEmpty()){
			appendKeyValuePair(result, "accountingDocumentCount", getAccountingDocumentList().getTotalCount());
			appendKeyValuePair(result, "accountingDocumentCurrentPageNumber", getAccountingDocumentList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocumentType){
		
		
			AccountingDocumentType dest =(AccountingDocumentType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setAccountingPeriod(getAccountingPeriod());
			dest.setVersion(getVersion());
			dest.setAccountingDocumentList(getAccountingDocumentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocumentType){
		
			
			AccountingDocumentType dest =(AccountingDocumentType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeAccountingPeriod(getAccountingPeriod());
			dest.mergeVersion(getVersion());
			dest.mergeAccountingDocumentList(getAccountingDocumentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocumentType){
		
			
			AccountingDocumentType dest =(AccountingDocumentType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getDescription(), getAccountingPeriod(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AccountingDocumentType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		if(getAccountingPeriod() != null ){
 			stringBuilder.append("\taccountingPeriod='AccountSet("+getAccountingPeriod().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


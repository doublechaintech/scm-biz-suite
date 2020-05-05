
package com.doublechaintech.retailscm.accountingperiod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

@JsonSerialize(using = AccountingPeriodSerializer.class)
public class AccountingPeriod extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String START_DATE_PROPERTY            = "startDate"         ;
	public static final String END_DATE_PROPERTY              = "endDate"           ;
	public static final String ACCOUNT_SET_PROPERTY           = "accountSet"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LIST                 = "accountingDocumentList";

	public static final String INTERNAL_TYPE="AccountingPeriod";
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
	protected		Date                	mStartDate          ;
	protected		Date                	mEndDate            ;
	protected		AccountSet          	mAccountSet         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocument>	mAccountingDocumentList;

	
		
	public 	AccountingPeriod(){
		// lazy load for all the properties
	}
	public 	static AccountingPeriod withId(String id){
		AccountingPeriod accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(id);
		accountingPeriod.setVersion(Integer.MAX_VALUE);
		return accountingPeriod;
	}
	public 	static AccountingPeriod refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAccountSet( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(START_DATE_PROPERTY.equals(property)){
			changeStartDateProperty(newValueExpr);
		}
		if(END_DATE_PROPERTY.equals(property)){
			changeEndDateProperty(newValueExpr);
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
			
			
			
	protected void changeStartDateProperty(String newValueExpr){
	
		Date oldValue = getStartDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateStartDate(newValue);
		this.onChangeProperty(START_DATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEndDateProperty(String newValueExpr){
	
		Date oldValue = getEndDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEndDate(newValue);
		this.onChangeProperty(END_DATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(START_DATE_PROPERTY.equals(property)){
			return getStartDate();
		}
		if(END_DATE_PROPERTY.equals(property)){
			return getEndDate();
		}
		if(ACCOUNT_SET_PROPERTY.equals(property)){
			return getAccountSet();
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
	public AccountingPeriod updateId(String id){
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
	public AccountingPeriod updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setStartDate(Date startDate){
		this.mStartDate = startDate;;
	}
	public Date getStartDate(){
		return this.mStartDate;
	}
	public AccountingPeriod updateStartDate(Date startDate){
		this.mStartDate = startDate;;
		this.changed = true;
		return this;
	}
	public void mergeStartDate(Date startDate){
		setStartDate(startDate);
	}
	
	
	public void setEndDate(Date endDate){
		this.mEndDate = endDate;;
	}
	public Date getEndDate(){
		return this.mEndDate;
	}
	public AccountingPeriod updateEndDate(Date endDate){
		this.mEndDate = endDate;;
		this.changed = true;
		return this;
	}
	public void mergeEndDate(Date endDate){
		setEndDate(endDate);
	}
	
	
	public void setAccountSet(AccountSet accountSet){
		this.mAccountSet = accountSet;;
	}
	public AccountSet getAccountSet(){
		return this.mAccountSet;
	}
	public AccountingPeriod updateAccountSet(AccountSet accountSet){
		this.mAccountSet = accountSet;;
		this.changed = true;
		return this;
	}
	public void mergeAccountSet(AccountSet accountSet){
		if(accountSet != null) { setAccountSet(accountSet);}
	}
	
	
	public void clearAccountSet(){
		setAccountSet ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public AccountingPeriod updateVersion(int version){
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
			accountingDocument.setAccountingPeriod(this);
		}

		this.mAccountingDocumentList = accountingDocumentList;
		this.mAccountingDocumentList.setListInternalName (ACCOUNTING_DOCUMENT_LIST );
		
	}
	
	public  void addAccountingDocument(AccountingDocument accountingDocument){
		accountingDocument.setAccountingPeriod(this);
		getAccountingDocumentList().add(accountingDocument);
	}
	public  void addAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setAccountingPeriod(this);
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
        // accountingDocument.clearAccountingPeriod(); //disconnect with AccountingPeriod
        accountingDocument.clearFromAll(); //disconnect with AccountingPeriod
		
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
		accountingDocument.setAccountingPeriod(null);
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

		addToEntityList(this, entityList, getAccountSet(), internalType);

		
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
		appendKeyValuePair(result, START_DATE_PROPERTY, getStartDate());
		appendKeyValuePair(result, END_DATE_PROPERTY, getEndDate());
		appendKeyValuePair(result, ACCOUNT_SET_PROPERTY, getAccountSet());
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
		
		
		if(baseDest instanceof AccountingPeriod){
		
		
			AccountingPeriod dest =(AccountingPeriod)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setStartDate(getStartDate());
			dest.setEndDate(getEndDate());
			dest.setAccountSet(getAccountSet());
			dest.setVersion(getVersion());
			dest.setAccountingDocumentList(getAccountingDocumentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingPeriod){
		
			
			AccountingPeriod dest =(AccountingPeriod)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeStartDate(getStartDate());
			dest.mergeEndDate(getEndDate());
			dest.mergeAccountSet(getAccountSet());
			dest.mergeVersion(getVersion());
			dest.mergeAccountingDocumentList(getAccountingDocumentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingPeriod){
		
			
			AccountingPeriod dest =(AccountingPeriod)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeStartDate(getStartDate());
			dest.mergeEndDate(getEndDate());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getStartDate(), getEndDate(), getAccountSet(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AccountingPeriod{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tstartDate='"+getStartDate()+"';");
		stringBuilder.append("\tendDate='"+getEndDate()+"';");
		if(getAccountSet() != null ){
 			stringBuilder.append("\taccountSet='AccountSet("+getAccountSet().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


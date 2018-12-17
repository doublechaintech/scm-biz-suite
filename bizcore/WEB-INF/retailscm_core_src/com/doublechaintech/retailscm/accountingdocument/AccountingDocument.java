
package com.doublechaintech.retailscm.accountingdocument;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

@JsonSerialize(using = AccountingDocumentSerializer.class)
public class AccountingDocument extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String ACCOUNTING_DOCUMENT_DATE_PROPERTY = "accountingDocumentDate";
	public static final String ACCOUNTING_PERIOD_PROPERTY     = "accountingPeriod"  ;
	public static final String DOCUMENT_TYPE_PROPERTY         = "documentType"      ;
	public static final String CREATION_PROPERTY              = "creation"          ;
	public static final String CONFIRMATION_PROPERTY          = "confirmation"      ;
	public static final String AUDITING_PROPERTY              = "auditing"          ;
	public static final String POSTING_PROPERTY               = "posting"           ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORIGINAL_VOUCHER_LIST                    = "originalVoucherList";
	public static final String ACCOUNTING_DOCUMENT_LINE_LIST            = "accountingDocumentLineList";

	public static final String INTERNAL_TYPE="AccountingDocument";
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
	protected		Date                	mAccountingDocumentDate;
	protected		AccountingPeriod    	mAccountingPeriod   ;
	protected		AccountingDocumentType	mDocumentType       ;
	protected		AccountingDocumentCreation	mCreation           ;
	protected		AccountingDocumentConfirmation	mConfirmation       ;
	protected		AccountingDocumentAuditing	mAuditing           ;
	protected		AccountingDocumentPosting	mPosting            ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<OriginalVoucher>	mOriginalVoucherList;
	protected		SmartList<AccountingDocumentLine>	mAccountingDocumentLineList;
	
		
	public 	AccountingDocument(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAccountingPeriod( null );
		setDocumentType( null );
		setCreation( null );
		setConfirmation( null );
		setAuditing( null );
		setPosting( null );

		this.changed = true;
	}
	
	public 	AccountingDocument(String name, Date accountingDocumentDate, AccountingPeriod accountingPeriod, AccountingDocumentType documentType, String currentStatus)
	{
		setName(name);
		setAccountingDocumentDate(accountingDocumentDate);
		setAccountingPeriod(accountingPeriod);
		setDocumentType(documentType);
		setCurrentStatus(currentStatus);

		this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
		this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			changeAccountingDocumentDateProperty(newValueExpr);
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
			
			
			
	protected void changeAccountingDocumentDateProperty(String newValueExpr){
		Date oldValue = getAccountingDocumentDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountingDocumentDate(newValue);
		this.onChangeProperty(ACCOUNTING_DOCUMENT_DATE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public AccountingDocument updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public AccountingDocument updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setAccountingDocumentDate(Date accountingDocumentDate){
		this.mAccountingDocumentDate = accountingDocumentDate;;
	}
	public Date getAccountingDocumentDate(){
		return this.mAccountingDocumentDate;
	}
	public AccountingDocument updateAccountingDocumentDate(Date accountingDocumentDate){
		this.mAccountingDocumentDate = accountingDocumentDate;;
		this.changed = true;
		return this;
	}
	
	
	public void setAccountingPeriod(AccountingPeriod accountingPeriod){
		this.mAccountingPeriod = accountingPeriod;;
	}
	public AccountingPeriod getAccountingPeriod(){
		return this.mAccountingPeriod;
	}
	public AccountingDocument updateAccountingPeriod(AccountingPeriod accountingPeriod){
		this.mAccountingPeriod = accountingPeriod;;
		this.changed = true;
		return this;
	}
	
	
	public void clearAccountingPeriod(){
		setAccountingPeriod ( null );
		this.changed = true;
	}
	
	public void setDocumentType(AccountingDocumentType documentType){
		this.mDocumentType = documentType;;
	}
	public AccountingDocumentType getDocumentType(){
		return this.mDocumentType;
	}
	public AccountingDocument updateDocumentType(AccountingDocumentType documentType){
		this.mDocumentType = documentType;;
		this.changed = true;
		return this;
	}
	
	
	public void clearDocumentType(){
		setDocumentType ( null );
		this.changed = true;
	}
	
	public void setCreation(AccountingDocumentCreation creation){
		this.mCreation = creation;;
	}
	public AccountingDocumentCreation getCreation(){
		return this.mCreation;
	}
	public AccountingDocument updateCreation(AccountingDocumentCreation creation){
		this.mCreation = creation;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCreation(){
		setCreation ( null );
		this.changed = true;
	}
	
	public void setConfirmation(AccountingDocumentConfirmation confirmation){
		this.mConfirmation = confirmation;;
	}
	public AccountingDocumentConfirmation getConfirmation(){
		return this.mConfirmation;
	}
	public AccountingDocument updateConfirmation(AccountingDocumentConfirmation confirmation){
		this.mConfirmation = confirmation;;
		this.changed = true;
		return this;
	}
	
	
	public void clearConfirmation(){
		setConfirmation ( null );
		this.changed = true;
	}
	
	public void setAuditing(AccountingDocumentAuditing auditing){
		this.mAuditing = auditing;;
	}
	public AccountingDocumentAuditing getAuditing(){
		return this.mAuditing;
	}
	public AccountingDocument updateAuditing(AccountingDocumentAuditing auditing){
		this.mAuditing = auditing;;
		this.changed = true;
		return this;
	}
	
	
	public void clearAuditing(){
		setAuditing ( null );
		this.changed = true;
	}
	
	public void setPosting(AccountingDocumentPosting posting){
		this.mPosting = posting;;
	}
	public AccountingDocumentPosting getPosting(){
		return this.mPosting;
	}
	public AccountingDocument updatePosting(AccountingDocumentPosting posting){
		this.mPosting = posting;;
		this.changed = true;
		return this;
	}
	
	
	public void clearPosting(){
		setPosting ( null );
		this.changed = true;
	}
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	public AccountingDocument updateCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public AccountingDocument updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<OriginalVoucher> getOriginalVoucherList(){
		if(this.mOriginalVoucherList == null){
			this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
			this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mOriginalVoucherList;	
	}
	public  void setOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setBelongsTo(this);
		}

		this.mOriginalVoucherList = originalVoucherList;
		this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
		
	}
	
	public  void addOriginalVoucher(OriginalVoucher originalVoucher){
		originalVoucher.setBelongsTo(this);
		getOriginalVoucherList().add(originalVoucher);
	}
	public  void addOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setBelongsTo(this);
		}
		getOriginalVoucherList().addAll(originalVoucherList);
	}
	
	public  OriginalVoucher removeOriginalVoucher(OriginalVoucher originalVoucherIndex){
		
		int index = getOriginalVoucherList().indexOf(originalVoucherIndex);
        if(index < 0){
        	String message = "OriginalVoucher("+originalVoucherIndex.getId()+") with version='"+originalVoucherIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        OriginalVoucher originalVoucher = getOriginalVoucherList().get(index);        
        // originalVoucher.clearBelongsTo(); //disconnect with BelongsTo
        originalVoucher.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getOriginalVoucherList().planToRemove(originalVoucher);
        if(!result){
        	String message = "OriginalVoucher("+originalVoucherIndex.getId()+") with version='"+originalVoucherIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return originalVoucher;
        
	
	}
	//断舍离
	public  void breakWithOriginalVoucher(OriginalVoucher originalVoucher){
		
		if(originalVoucher == null){
			return;
		}
		originalVoucher.setBelongsTo(null);
		//getOriginalVoucherList().remove();
	
	}
	
	public  boolean hasOriginalVoucher(OriginalVoucher originalVoucher){
	
		return getOriginalVoucherList().contains(originalVoucher);
  
	}
	
	public void copyOriginalVoucherFrom(OriginalVoucher originalVoucher) {

		OriginalVoucher originalVoucherInList = findTheOriginalVoucher(originalVoucher);
		OriginalVoucher newOriginalVoucher = new OriginalVoucher();
		originalVoucherInList.copyTo(newOriginalVoucher);
		newOriginalVoucher.setVersion(0);//will trigger copy
		getOriginalVoucherList().add(newOriginalVoucher);
		addItemToFlexiableObject(COPIED_CHILD, newOriginalVoucher);
	}
	
	public  OriginalVoucher findTheOriginalVoucher(OriginalVoucher originalVoucher){
		
		int index =  getOriginalVoucherList().indexOf(originalVoucher);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "OriginalVoucher("+originalVoucher.getId()+") with version='"+originalVoucher.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getOriginalVoucherList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOriginalVoucherList(){
		getOriginalVoucherList().clear();
	}
	
	
	


	public  SmartList<AccountingDocumentLine> getAccountingDocumentLineList(){
		if(this.mAccountingDocumentLineList == null){
			this.mAccountingDocumentLineList = new SmartList<AccountingDocumentLine>();
			this.mAccountingDocumentLineList.setListInternalName (ACCOUNTING_DOCUMENT_LINE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountingDocumentLineList;	
	}
	public  void setAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setBelongsTo(this);
		}

		this.mAccountingDocumentLineList = accountingDocumentLineList;
		this.mAccountingDocumentLineList.setListInternalName (ACCOUNTING_DOCUMENT_LINE_LIST );
		
	}
	
	public  void addAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		accountingDocumentLine.setBelongsTo(this);
		getAccountingDocumentLineList().add(accountingDocumentLine);
	}
	public  void addAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setBelongsTo(this);
		}
		getAccountingDocumentLineList().addAll(accountingDocumentLineList);
	}
	
	public  AccountingDocumentLine removeAccountingDocumentLine(AccountingDocumentLine accountingDocumentLineIndex){
		
		int index = getAccountingDocumentLineList().indexOf(accountingDocumentLineIndex);
        if(index < 0){
        	String message = "AccountingDocumentLine("+accountingDocumentLineIndex.getId()+") with version='"+accountingDocumentLineIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountingDocumentLine accountingDocumentLine = getAccountingDocumentLineList().get(index);        
        // accountingDocumentLine.clearBelongsTo(); //disconnect with BelongsTo
        accountingDocumentLine.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getAccountingDocumentLineList().planToRemove(accountingDocumentLine);
        if(!result){
        	String message = "AccountingDocumentLine("+accountingDocumentLineIndex.getId()+") with version='"+accountingDocumentLineIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountingDocumentLine;
        
	
	}
	//断舍离
	public  void breakWithAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		
		if(accountingDocumentLine == null){
			return;
		}
		accountingDocumentLine.setBelongsTo(null);
		//getAccountingDocumentLineList().remove();
	
	}
	
	public  boolean hasAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
	
		return getAccountingDocumentLineList().contains(accountingDocumentLine);
  
	}
	
	public void copyAccountingDocumentLineFrom(AccountingDocumentLine accountingDocumentLine) {

		AccountingDocumentLine accountingDocumentLineInList = findTheAccountingDocumentLine(accountingDocumentLine);
		AccountingDocumentLine newAccountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLineInList.copyTo(newAccountingDocumentLine);
		newAccountingDocumentLine.setVersion(0);//will trigger copy
		getAccountingDocumentLineList().add(newAccountingDocumentLine);
		addItemToFlexiableObject(COPIED_CHILD, newAccountingDocumentLine);
	}
	
	public  AccountingDocumentLine findTheAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		
		int index =  getAccountingDocumentLineList().indexOf(accountingDocumentLine);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountingDocumentLine("+accountingDocumentLine.getId()+") with version='"+accountingDocumentLine.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountingDocumentLineList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingDocumentLineList(){
		getAccountingDocumentLineList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getAccountingPeriod(), internalType);
		addToEntityList(this, entityList, getDocumentType(), internalType);
		addToEntityList(this, entityList, getCreation(), internalType);
		addToEntityList(this, entityList, getConfirmation(), internalType);
		addToEntityList(this, entityList, getAuditing(), internalType);
		addToEntityList(this, entityList, getPosting(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getOriginalVoucherList(), internalType);
		collectFromList(this, entityList, getAccountingDocumentLineList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getOriginalVoucherList());
		listOfList.add( getAccountingDocumentLineList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, ACCOUNTING_DOCUMENT_DATE_PROPERTY, getAccountingDocumentDate());
		appendKeyValuePair(result, ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriod());
		appendKeyValuePair(result, DOCUMENT_TYPE_PROPERTY, getDocumentType());
		appendKeyValuePair(result, CREATION_PROPERTY, getCreation());
		appendKeyValuePair(result, CONFIRMATION_PROPERTY, getConfirmation());
		appendKeyValuePair(result, AUDITING_PROPERTY, getAuditing());
		appendKeyValuePair(result, POSTING_PROPERTY, getPosting());
		appendKeyValuePair(result, CURRENT_STATUS_PROPERTY, getCurrentStatus());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ORIGINAL_VOUCHER_LIST, getOriginalVoucherList());
		if(!getOriginalVoucherList().isEmpty()){
			appendKeyValuePair(result, "originalVoucherCount", getOriginalVoucherList().getTotalCount());
			appendKeyValuePair(result, "originalVoucherCurrentPageNumber", getOriginalVoucherList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ACCOUNTING_DOCUMENT_LINE_LIST, getAccountingDocumentLineList());
		if(!getAccountingDocumentLineList().isEmpty()){
			appendKeyValuePair(result, "accountingDocumentLineCount", getAccountingDocumentLineList().getTotalCount());
			appendKeyValuePair(result, "accountingDocumentLineCurrentPageNumber", getAccountingDocumentLineList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocument){
		
		
			AccountingDocument dest =(AccountingDocument)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAccountingDocumentDate(getAccountingDocumentDate());
			dest.setAccountingPeriod(getAccountingPeriod());
			dest.setDocumentType(getDocumentType());
			dest.setCreation(getCreation());
			dest.setConfirmation(getConfirmation());
			dest.setAuditing(getAuditing());
			dest.setPosting(getPosting());
			dest.setCurrentStatus(getCurrentStatus());
			dest.setVersion(getVersion());
			dest.setOriginalVoucherList(getOriginalVoucherList());
			dest.setAccountingDocumentLineList(getAccountingDocumentLineList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AccountingDocument{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\taccountingDocumentDate='"+getAccountingDocumentDate()+"';");
		if(getAccountingPeriod() != null ){
 			stringBuilder.append("\taccountingPeriod='AccountingPeriod("+getAccountingPeriod().getId()+")';");
 		}
		if(getDocumentType() != null ){
 			stringBuilder.append("\tdocumentType='AccountingDocumentType("+getDocumentType().getId()+")';");
 		}
		if(getCreation() != null ){
 			stringBuilder.append("\tcreation='AccountingDocumentCreation("+getCreation().getId()+")';");
 		}
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='AccountingDocumentConfirmation("+getConfirmation().getId()+")';");
 		}
		if(getAuditing() != null ){
 			stringBuilder.append("\tauditing='AccountingDocumentAuditing("+getAuditing().getId()+")';");
 		}
		if(getPosting() != null ){
 			stringBuilder.append("\tposting='AccountingDocumentPosting("+getPosting().getId()+")';");
 		}
		stringBuilder.append("\tcurrentStatus='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


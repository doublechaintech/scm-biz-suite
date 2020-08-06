
package com.doublechaintech.retailscm.accountset;

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
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;









@JsonSerialize(using = AccountSetSerializer.class)
public class AccountSet extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String YEAR_SET_PROPERTY              = "yearSet"           ;
	public static final String EFFECTIVE_DATE_PROPERTY        = "effectiveDate"     ;
	public static final String ACCOUNTING_SYSTEM_PROPERTY     = "accountingSystem"  ;
	public static final String DOMESTIC_CURRENCY_CODE_PROPERTY = "domesticCurrencyCode";
	public static final String DOMESTIC_CURRENCY_NAME_PROPERTY = "domesticCurrencyName";
	public static final String OPENING_BANK_PROPERTY          = "openingBank"       ;
	public static final String ACCOUNT_NUMBER_PROPERTY        = "accountNumber"     ;
	public static final String COUNTRY_CENTER_PROPERTY        = "countryCenter"     ;
	public static final String RETAIL_STORE_PROPERTY          = "retailStore"       ;
	public static final String GOODS_SUPPLIER_PROPERTY        = "goodsSupplier"     ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_SUBJECT_LIST                  = "accountingSubjectList";
	public static final String ACCOUNTING_PERIOD_LIST                   = "accountingPeriodList";
	public static final String ACCOUNTING_DOCUMENT_TYPE_LIST            = "accountingDocumentTypeList";

	public static final String INTERNAL_TYPE="AccountSet";
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
	protected		String              	mYearSet            ;
	protected		Date                	mEffectiveDate      ;
	protected		String              	mAccountingSystem   ;
	protected		String              	mDomesticCurrencyCode;
	protected		String              	mDomesticCurrencyName;
	protected		String              	mOpeningBank        ;
	protected		String              	mAccountNumber      ;
	protected		RetailStoreCountryCenter	mCountryCenter      ;
	protected		RetailStore         	mRetailStore        ;
	protected		GoodsSupplier       	mGoodsSupplier      ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingSubject>	mAccountingSubjectList;
	protected		SmartList<AccountingPeriod>	mAccountingPeriodList;
	protected		SmartList<AccountingDocumentType>	mAccountingDocumentTypeList;

	
		
	public 	AccountSet(){
		// lazy load for all the properties
	}
	public 	static AccountSet withId(String id){
		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(Integer.MAX_VALUE);
		return accountSet;
	}
	public 	static AccountSet refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCountryCenter( null );
		setRetailStore( null );
		setGoodsSupplier( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(YEAR_SET_PROPERTY.equals(property)){
			changeYearSetProperty(newValueExpr);
		}
		if(EFFECTIVE_DATE_PROPERTY.equals(property)){
			changeEffectiveDateProperty(newValueExpr);
		}
		if(ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			changeAccountingSystemProperty(newValueExpr);
		}
		if(DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			changeDomesticCurrencyCodeProperty(newValueExpr);
		}
		if(DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			changeDomesticCurrencyNameProperty(newValueExpr);
		}
		if(OPENING_BANK_PROPERTY.equals(property)){
			changeOpeningBankProperty(newValueExpr);
		}
		if(ACCOUNT_NUMBER_PROPERTY.equals(property)){
			changeAccountNumberProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeYearSetProperty(String newValueExpr){
	
		String oldValue = getYearSet();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateYearSet(newValue);
		this.onChangeProperty(YEAR_SET_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEffectiveDateProperty(String newValueExpr){
	
		Date oldValue = getEffectiveDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEffectiveDate(newValue);
		this.onChangeProperty(EFFECTIVE_DATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAccountingSystemProperty(String newValueExpr){
	
		String oldValue = getAccountingSystem();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountingSystem(newValue);
		this.onChangeProperty(ACCOUNTING_SYSTEM_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDomesticCurrencyCodeProperty(String newValueExpr){
	
		String oldValue = getDomesticCurrencyCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDomesticCurrencyCode(newValue);
		this.onChangeProperty(DOMESTIC_CURRENCY_CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDomesticCurrencyNameProperty(String newValueExpr){
	
		String oldValue = getDomesticCurrencyName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDomesticCurrencyName(newValue);
		this.onChangeProperty(DOMESTIC_CURRENCY_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeOpeningBankProperty(String newValueExpr){
	
		String oldValue = getOpeningBank();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOpeningBank(newValue);
		this.onChangeProperty(OPENING_BANK_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAccountNumberProperty(String newValueExpr){
	
		String oldValue = getAccountNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountNumber(newValue);
		this.onChangeProperty(ACCOUNT_NUMBER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(YEAR_SET_PROPERTY.equals(property)){
			return getYearSet();
		}
		if(EFFECTIVE_DATE_PROPERTY.equals(property)){
			return getEffectiveDate();
		}
		if(ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			return getAccountingSystem();
		}
		if(DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			return getDomesticCurrencyCode();
		}
		if(DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			return getDomesticCurrencyName();
		}
		if(OPENING_BANK_PROPERTY.equals(property)){
			return getOpeningBank();
		}
		if(ACCOUNT_NUMBER_PROPERTY.equals(property)){
			return getAccountNumber();
		}
		if(COUNTRY_CENTER_PROPERTY.equals(property)){
			return getCountryCenter();
		}
		if(RETAIL_STORE_PROPERTY.equals(property)){
			return getRetailStore();
		}
		if(GOODS_SUPPLIER_PROPERTY.equals(property)){
			return getGoodsSupplier();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(ACCOUNTING_SUBJECT_LIST.equals(property)){
			List<BaseEntity> list = getAccountingSubjectList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ACCOUNTING_PERIOD_LIST.equals(property)){
			List<BaseEntity> list = getAccountingPeriodList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ACCOUNTING_DOCUMENT_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getAccountingDocumentTypeList().stream().map(item->item).collect(Collectors.toList());
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
	public AccountSet updateId(String id){
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
	public AccountSet updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setYearSet(String yearSet){
		this.mYearSet = trimString(yearSet);;
	}
	public String getYearSet(){
		return this.mYearSet;
	}
	public AccountSet updateYearSet(String yearSet){
		this.mYearSet = trimString(yearSet);;
		this.changed = true;
		return this;
	}
	public void mergeYearSet(String yearSet){
		if(yearSet != null) { setYearSet(yearSet);}
	}
	
	
	public void setEffectiveDate(Date effectiveDate){
		this.mEffectiveDate = effectiveDate;;
	}
	public Date getEffectiveDate(){
		return this.mEffectiveDate;
	}
	public AccountSet updateEffectiveDate(Date effectiveDate){
		this.mEffectiveDate = effectiveDate;;
		this.changed = true;
		return this;
	}
	public void mergeEffectiveDate(Date effectiveDate){
		setEffectiveDate(effectiveDate);
	}
	
	
	public void setAccountingSystem(String accountingSystem){
		this.mAccountingSystem = trimString(accountingSystem);;
	}
	public String getAccountingSystem(){
		return this.mAccountingSystem;
	}
	public AccountSet updateAccountingSystem(String accountingSystem){
		this.mAccountingSystem = trimString(accountingSystem);;
		this.changed = true;
		return this;
	}
	public void mergeAccountingSystem(String accountingSystem){
		if(accountingSystem != null) { setAccountingSystem(accountingSystem);}
	}
	
	
	public void setDomesticCurrencyCode(String domesticCurrencyCode){
		this.mDomesticCurrencyCode = trimString(domesticCurrencyCode);;
	}
	public String getDomesticCurrencyCode(){
		return this.mDomesticCurrencyCode;
	}
	public AccountSet updateDomesticCurrencyCode(String domesticCurrencyCode){
		this.mDomesticCurrencyCode = trimString(domesticCurrencyCode);;
		this.changed = true;
		return this;
	}
	public void mergeDomesticCurrencyCode(String domesticCurrencyCode){
		if(domesticCurrencyCode != null) { setDomesticCurrencyCode(domesticCurrencyCode);}
	}
	
	
	public void setDomesticCurrencyName(String domesticCurrencyName){
		this.mDomesticCurrencyName = trimString(domesticCurrencyName);;
	}
	public String getDomesticCurrencyName(){
		return this.mDomesticCurrencyName;
	}
	public AccountSet updateDomesticCurrencyName(String domesticCurrencyName){
		this.mDomesticCurrencyName = trimString(domesticCurrencyName);;
		this.changed = true;
		return this;
	}
	public void mergeDomesticCurrencyName(String domesticCurrencyName){
		if(domesticCurrencyName != null) { setDomesticCurrencyName(domesticCurrencyName);}
	}
	
	
	public void setOpeningBank(String openingBank){
		this.mOpeningBank = trimString(openingBank);;
	}
	public String getOpeningBank(){
		return this.mOpeningBank;
	}
	public AccountSet updateOpeningBank(String openingBank){
		this.mOpeningBank = trimString(openingBank);;
		this.changed = true;
		return this;
	}
	public void mergeOpeningBank(String openingBank){
		if(openingBank != null) { setOpeningBank(openingBank);}
	}
	
	
	public void setAccountNumber(String accountNumber){
		this.mAccountNumber = trimString(accountNumber);;
	}
	public String getAccountNumber(){
		return this.mAccountNumber;
	}
	public AccountSet updateAccountNumber(String accountNumber){
		this.mAccountNumber = trimString(accountNumber);;
		this.changed = true;
		return this;
	}
	public void mergeAccountNumber(String accountNumber){
		if(accountNumber != null) { setAccountNumber(accountNumber);}
	}
	
	
	public void setCountryCenter(RetailStoreCountryCenter countryCenter){
		this.mCountryCenter = countryCenter;;
	}
	public RetailStoreCountryCenter getCountryCenter(){
		return this.mCountryCenter;
	}
	public AccountSet updateCountryCenter(RetailStoreCountryCenter countryCenter){
		this.mCountryCenter = countryCenter;;
		this.changed = true;
		return this;
	}
	public void mergeCountryCenter(RetailStoreCountryCenter countryCenter){
		if(countryCenter != null) { setCountryCenter(countryCenter);}
	}
	
	
	public void clearCountryCenter(){
		setCountryCenter ( null );
		this.changed = true;
	}
	
	public void setRetailStore(RetailStore retailStore){
		this.mRetailStore = retailStore;;
	}
	public RetailStore getRetailStore(){
		return this.mRetailStore;
	}
	public AccountSet updateRetailStore(RetailStore retailStore){
		this.mRetailStore = retailStore;;
		this.changed = true;
		return this;
	}
	public void mergeRetailStore(RetailStore retailStore){
		if(retailStore != null) { setRetailStore(retailStore);}
	}
	
	
	public void clearRetailStore(){
		setRetailStore ( null );
		this.changed = true;
	}
	
	public void setGoodsSupplier(GoodsSupplier goodsSupplier){
		this.mGoodsSupplier = goodsSupplier;;
	}
	public GoodsSupplier getGoodsSupplier(){
		return this.mGoodsSupplier;
	}
	public AccountSet updateGoodsSupplier(GoodsSupplier goodsSupplier){
		this.mGoodsSupplier = goodsSupplier;;
		this.changed = true;
		return this;
	}
	public void mergeGoodsSupplier(GoodsSupplier goodsSupplier){
		if(goodsSupplier != null) { setGoodsSupplier(goodsSupplier);}
	}
	
	
	public void clearGoodsSupplier(){
		setGoodsSupplier ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public AccountSet updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public AccountSet updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<AccountingSubject> getAccountingSubjectList(){
		if(this.mAccountingSubjectList == null){
			this.mAccountingSubjectList = new SmartList<AccountingSubject>();
			this.mAccountingSubjectList.setListInternalName (ACCOUNTING_SUBJECT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountingSubjectList;	
	}
	public  void setAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList){
		for( AccountingSubject accountingSubject:accountingSubjectList){
			accountingSubject.setAccountSet(this);
		}

		this.mAccountingSubjectList = accountingSubjectList;
		this.mAccountingSubjectList.setListInternalName (ACCOUNTING_SUBJECT_LIST );
		
	}
	
	public  void addAccountingSubject(AccountingSubject accountingSubject){
		accountingSubject.setAccountSet(this);
		getAccountingSubjectList().add(accountingSubject);
	}
	public  void addAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList){
		for( AccountingSubject accountingSubject:accountingSubjectList){
			accountingSubject.setAccountSet(this);
		}
		getAccountingSubjectList().addAll(accountingSubjectList);
	}
	public  void mergeAccountingSubjectList(SmartList<AccountingSubject> accountingSubjectList){
		if(accountingSubjectList==null){
			return;
		}
		if(accountingSubjectList.isEmpty()){
			return;
		}
		addAccountingSubjectList( accountingSubjectList );
		
	}
	public  AccountingSubject removeAccountingSubject(AccountingSubject accountingSubjectIndex){
		
		int index = getAccountingSubjectList().indexOf(accountingSubjectIndex);
        if(index < 0){
        	String message = "AccountingSubject("+accountingSubjectIndex.getId()+") with version='"+accountingSubjectIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountingSubject accountingSubject = getAccountingSubjectList().get(index);        
        // accountingSubject.clearAccountSet(); //disconnect with AccountSet
        accountingSubject.clearFromAll(); //disconnect with AccountSet
		
		boolean result = getAccountingSubjectList().planToRemove(accountingSubject);
        if(!result){
        	String message = "AccountingSubject("+accountingSubjectIndex.getId()+") with version='"+accountingSubjectIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountingSubject;
        
	
	}
	//断舍离
	public  void breakWithAccountingSubject(AccountingSubject accountingSubject){
		
		if(accountingSubject == null){
			return;
		}
		accountingSubject.setAccountSet(null);
		//getAccountingSubjectList().remove();
	
	}
	
	public  boolean hasAccountingSubject(AccountingSubject accountingSubject){
	
		return getAccountingSubjectList().contains(accountingSubject);
  
	}
	
	public void copyAccountingSubjectFrom(AccountingSubject accountingSubject) {

		AccountingSubject accountingSubjectInList = findTheAccountingSubject(accountingSubject);
		AccountingSubject newAccountingSubject = new AccountingSubject();
		accountingSubjectInList.copyTo(newAccountingSubject);
		newAccountingSubject.setVersion(0);//will trigger copy
		getAccountingSubjectList().add(newAccountingSubject);
		addItemToFlexiableObject(COPIED_CHILD, newAccountingSubject);
	}
	
	public  AccountingSubject findTheAccountingSubject(AccountingSubject accountingSubject){
		
		int index =  getAccountingSubjectList().indexOf(accountingSubject);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountingSubject("+accountingSubject.getId()+") with version='"+accountingSubject.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountingSubjectList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingSubjectList(){
		getAccountingSubjectList().clear();
	}
	
	
	


	public  SmartList<AccountingPeriod> getAccountingPeriodList(){
		if(this.mAccountingPeriodList == null){
			this.mAccountingPeriodList = new SmartList<AccountingPeriod>();
			this.mAccountingPeriodList.setListInternalName (ACCOUNTING_PERIOD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountingPeriodList;	
	}
	public  void setAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList){
		for( AccountingPeriod accountingPeriod:accountingPeriodList){
			accountingPeriod.setAccountSet(this);
		}

		this.mAccountingPeriodList = accountingPeriodList;
		this.mAccountingPeriodList.setListInternalName (ACCOUNTING_PERIOD_LIST );
		
	}
	
	public  void addAccountingPeriod(AccountingPeriod accountingPeriod){
		accountingPeriod.setAccountSet(this);
		getAccountingPeriodList().add(accountingPeriod);
	}
	public  void addAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList){
		for( AccountingPeriod accountingPeriod:accountingPeriodList){
			accountingPeriod.setAccountSet(this);
		}
		getAccountingPeriodList().addAll(accountingPeriodList);
	}
	public  void mergeAccountingPeriodList(SmartList<AccountingPeriod> accountingPeriodList){
		if(accountingPeriodList==null){
			return;
		}
		if(accountingPeriodList.isEmpty()){
			return;
		}
		addAccountingPeriodList( accountingPeriodList );
		
	}
	public  AccountingPeriod removeAccountingPeriod(AccountingPeriod accountingPeriodIndex){
		
		int index = getAccountingPeriodList().indexOf(accountingPeriodIndex);
        if(index < 0){
        	String message = "AccountingPeriod("+accountingPeriodIndex.getId()+") with version='"+accountingPeriodIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountingPeriod accountingPeriod = getAccountingPeriodList().get(index);        
        // accountingPeriod.clearAccountSet(); //disconnect with AccountSet
        accountingPeriod.clearFromAll(); //disconnect with AccountSet
		
		boolean result = getAccountingPeriodList().planToRemove(accountingPeriod);
        if(!result){
        	String message = "AccountingPeriod("+accountingPeriodIndex.getId()+") with version='"+accountingPeriodIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountingPeriod;
        
	
	}
	//断舍离
	public  void breakWithAccountingPeriod(AccountingPeriod accountingPeriod){
		
		if(accountingPeriod == null){
			return;
		}
		accountingPeriod.setAccountSet(null);
		//getAccountingPeriodList().remove();
	
	}
	
	public  boolean hasAccountingPeriod(AccountingPeriod accountingPeriod){
	
		return getAccountingPeriodList().contains(accountingPeriod);
  
	}
	
	public void copyAccountingPeriodFrom(AccountingPeriod accountingPeriod) {

		AccountingPeriod accountingPeriodInList = findTheAccountingPeriod(accountingPeriod);
		AccountingPeriod newAccountingPeriod = new AccountingPeriod();
		accountingPeriodInList.copyTo(newAccountingPeriod);
		newAccountingPeriod.setVersion(0);//will trigger copy
		getAccountingPeriodList().add(newAccountingPeriod);
		addItemToFlexiableObject(COPIED_CHILD, newAccountingPeriod);
	}
	
	public  AccountingPeriod findTheAccountingPeriod(AccountingPeriod accountingPeriod){
		
		int index =  getAccountingPeriodList().indexOf(accountingPeriod);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountingPeriod("+accountingPeriod.getId()+") with version='"+accountingPeriod.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountingPeriodList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingPeriodList(){
		getAccountingPeriodList().clear();
	}
	
	
	


	public  SmartList<AccountingDocumentType> getAccountingDocumentTypeList(){
		if(this.mAccountingDocumentTypeList == null){
			this.mAccountingDocumentTypeList = new SmartList<AccountingDocumentType>();
			this.mAccountingDocumentTypeList.setListInternalName (ACCOUNTING_DOCUMENT_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountingDocumentTypeList;	
	}
	public  void setAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList){
		for( AccountingDocumentType accountingDocumentType:accountingDocumentTypeList){
			accountingDocumentType.setAccountingPeriod(this);
		}

		this.mAccountingDocumentTypeList = accountingDocumentTypeList;
		this.mAccountingDocumentTypeList.setListInternalName (ACCOUNTING_DOCUMENT_TYPE_LIST );
		
	}
	
	public  void addAccountingDocumentType(AccountingDocumentType accountingDocumentType){
		accountingDocumentType.setAccountingPeriod(this);
		getAccountingDocumentTypeList().add(accountingDocumentType);
	}
	public  void addAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList){
		for( AccountingDocumentType accountingDocumentType:accountingDocumentTypeList){
			accountingDocumentType.setAccountingPeriod(this);
		}
		getAccountingDocumentTypeList().addAll(accountingDocumentTypeList);
	}
	public  void mergeAccountingDocumentTypeList(SmartList<AccountingDocumentType> accountingDocumentTypeList){
		if(accountingDocumentTypeList==null){
			return;
		}
		if(accountingDocumentTypeList.isEmpty()){
			return;
		}
		addAccountingDocumentTypeList( accountingDocumentTypeList );
		
	}
	public  AccountingDocumentType removeAccountingDocumentType(AccountingDocumentType accountingDocumentTypeIndex){
		
		int index = getAccountingDocumentTypeList().indexOf(accountingDocumentTypeIndex);
        if(index < 0){
        	String message = "AccountingDocumentType("+accountingDocumentTypeIndex.getId()+") with version='"+accountingDocumentTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountingDocumentType accountingDocumentType = getAccountingDocumentTypeList().get(index);        
        // accountingDocumentType.clearAccountingPeriod(); //disconnect with AccountingPeriod
        accountingDocumentType.clearFromAll(); //disconnect with AccountingPeriod
		
		boolean result = getAccountingDocumentTypeList().planToRemove(accountingDocumentType);
        if(!result){
        	String message = "AccountingDocumentType("+accountingDocumentTypeIndex.getId()+") with version='"+accountingDocumentTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountingDocumentType;
        
	
	}
	//断舍离
	public  void breakWithAccountingDocumentType(AccountingDocumentType accountingDocumentType){
		
		if(accountingDocumentType == null){
			return;
		}
		accountingDocumentType.setAccountingPeriod(null);
		//getAccountingDocumentTypeList().remove();
	
	}
	
	public  boolean hasAccountingDocumentType(AccountingDocumentType accountingDocumentType){
	
		return getAccountingDocumentTypeList().contains(accountingDocumentType);
  
	}
	
	public void copyAccountingDocumentTypeFrom(AccountingDocumentType accountingDocumentType) {

		AccountingDocumentType accountingDocumentTypeInList = findTheAccountingDocumentType(accountingDocumentType);
		AccountingDocumentType newAccountingDocumentType = new AccountingDocumentType();
		accountingDocumentTypeInList.copyTo(newAccountingDocumentType);
		newAccountingDocumentType.setVersion(0);//will trigger copy
		getAccountingDocumentTypeList().add(newAccountingDocumentType);
		addItemToFlexiableObject(COPIED_CHILD, newAccountingDocumentType);
	}
	
	public  AccountingDocumentType findTheAccountingDocumentType(AccountingDocumentType accountingDocumentType){
		
		int index =  getAccountingDocumentTypeList().indexOf(accountingDocumentType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountingDocumentType("+accountingDocumentType.getId()+") with version='"+accountingDocumentType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountingDocumentTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountingDocumentTypeList(){
		getAccountingDocumentTypeList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCountryCenter(), internalType);
		addToEntityList(this, entityList, getRetailStore(), internalType);
		addToEntityList(this, entityList, getGoodsSupplier(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getAccountingSubjectList(), internalType);
		collectFromList(this, entityList, getAccountingPeriodList(), internalType);
		collectFromList(this, entityList, getAccountingDocumentTypeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getAccountingSubjectList());
		listOfList.add( getAccountingPeriodList());
		listOfList.add( getAccountingDocumentTypeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, YEAR_SET_PROPERTY, getYearSet());
		appendKeyValuePair(result, EFFECTIVE_DATE_PROPERTY, getEffectiveDate());
		appendKeyValuePair(result, ACCOUNTING_SYSTEM_PROPERTY, getAccountingSystem());
		appendKeyValuePair(result, DOMESTIC_CURRENCY_CODE_PROPERTY, getDomesticCurrencyCode());
		appendKeyValuePair(result, DOMESTIC_CURRENCY_NAME_PROPERTY, getDomesticCurrencyName());
		appendKeyValuePair(result, OPENING_BANK_PROPERTY, getOpeningBank());
		appendKeyValuePair(result, ACCOUNT_NUMBER_PROPERTY, getAccountNumber());
		appendKeyValuePair(result, COUNTRY_CENTER_PROPERTY, getCountryCenter());
		appendKeyValuePair(result, RETAIL_STORE_PROPERTY, getRetailStore());
		appendKeyValuePair(result, GOODS_SUPPLIER_PROPERTY, getGoodsSupplier());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ACCOUNTING_SUBJECT_LIST, getAccountingSubjectList());
		if(!getAccountingSubjectList().isEmpty()){
			appendKeyValuePair(result, "accountingSubjectCount", getAccountingSubjectList().getTotalCount());
			appendKeyValuePair(result, "accountingSubjectCurrentPageNumber", getAccountingSubjectList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ACCOUNTING_PERIOD_LIST, getAccountingPeriodList());
		if(!getAccountingPeriodList().isEmpty()){
			appendKeyValuePair(result, "accountingPeriodCount", getAccountingPeriodList().getTotalCount());
			appendKeyValuePair(result, "accountingPeriodCurrentPageNumber", getAccountingPeriodList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ACCOUNTING_DOCUMENT_TYPE_LIST, getAccountingDocumentTypeList());
		if(!getAccountingDocumentTypeList().isEmpty()){
			appendKeyValuePair(result, "accountingDocumentTypeCount", getAccountingDocumentTypeList().getTotalCount());
			appendKeyValuePair(result, "accountingDocumentTypeCurrentPageNumber", getAccountingDocumentTypeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountSet){
		
		
			AccountSet dest =(AccountSet)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setYearSet(getYearSet());
			dest.setEffectiveDate(getEffectiveDate());
			dest.setAccountingSystem(getAccountingSystem());
			dest.setDomesticCurrencyCode(getDomesticCurrencyCode());
			dest.setDomesticCurrencyName(getDomesticCurrencyName());
			dest.setOpeningBank(getOpeningBank());
			dest.setAccountNumber(getAccountNumber());
			dest.setCountryCenter(getCountryCenter());
			dest.setRetailStore(getRetailStore());
			dest.setGoodsSupplier(getGoodsSupplier());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setAccountingSubjectList(getAccountingSubjectList());
			dest.setAccountingPeriodList(getAccountingPeriodList());
			dest.setAccountingDocumentTypeList(getAccountingDocumentTypeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountSet){
		
			
			AccountSet dest =(AccountSet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeYearSet(getYearSet());
			dest.mergeEffectiveDate(getEffectiveDate());
			dest.mergeAccountingSystem(getAccountingSystem());
			dest.mergeDomesticCurrencyCode(getDomesticCurrencyCode());
			dest.mergeDomesticCurrencyName(getDomesticCurrencyName());
			dest.mergeOpeningBank(getOpeningBank());
			dest.mergeAccountNumber(getAccountNumber());
			dest.mergeCountryCenter(getCountryCenter());
			dest.mergeRetailStore(getRetailStore());
			dest.mergeGoodsSupplier(getGoodsSupplier());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeAccountingSubjectList(getAccountingSubjectList());
			dest.mergeAccountingPeriodList(getAccountingPeriodList());
			dest.mergeAccountingDocumentTypeList(getAccountingDocumentTypeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountSet){
		
			
			AccountSet dest =(AccountSet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeYearSet(getYearSet());
			dest.mergeEffectiveDate(getEffectiveDate());
			dest.mergeAccountingSystem(getAccountingSystem());
			dest.mergeDomesticCurrencyCode(getDomesticCurrencyCode());
			dest.mergeDomesticCurrencyName(getDomesticCurrencyName());
			dest.mergeOpeningBank(getOpeningBank());
			dest.mergeAccountNumber(getAccountNumber());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getYearSet(), getEffectiveDate(), getAccountingSystem(), getDomesticCurrencyCode(), getDomesticCurrencyName(), getOpeningBank(), getAccountNumber(), getCountryCenter(), getRetailStore(), getGoodsSupplier(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AccountSet{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tyearSet='"+getYearSet()+"';");
		stringBuilder.append("\teffectiveDate='"+getEffectiveDate()+"';");
		stringBuilder.append("\taccountingSystem='"+getAccountingSystem()+"';");
		stringBuilder.append("\tdomesticCurrencyCode='"+getDomesticCurrencyCode()+"';");
		stringBuilder.append("\tdomesticCurrencyName='"+getDomesticCurrencyName()+"';");
		stringBuilder.append("\topeningBank='"+getOpeningBank()+"';");
		stringBuilder.append("\taccountNumber='"+getAccountNumber()+"';");
		if(getCountryCenter() != null ){
 			stringBuilder.append("\tcountryCenter='RetailStoreCountryCenter("+getCountryCenter().getId()+")';");
 		}
		if(getRetailStore() != null ){
 			stringBuilder.append("\tretailStore='RetailStore("+getRetailStore().getId()+")';");
 		}
		if(getGoodsSupplier() != null ){
 			stringBuilder.append("\tgoodsSupplier='GoodsSupplier("+getGoodsSupplier().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


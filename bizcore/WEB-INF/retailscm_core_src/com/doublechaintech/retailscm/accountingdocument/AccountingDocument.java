
package com.doublechaintech.retailscm.accountingdocument;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
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
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ORIGINAL_VOUCHER_LIST                    = "originalVoucherList";
	public static final String ACCOUNTING_DOCUMENT_LINE_LIST            = "accountingDocumentLineList";

	public static final String INTERNAL_TYPE="AccountingDocument";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ACCOUNTING_DOCUMENT_DATE_PROPERTY, "accounting_document_date", "会计凭证日期")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ACCOUNTING_PERIOD_PROPERTY, "accounting_period", "会计期间")
        .withType("accounting_period", AccountingPeriod.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DOCUMENT_TYPE_PROPERTY, "accounting_document_type", "文档类型")
        .withType("accounting_document_type", AccountingDocumentType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(ORIGINAL_VOUCHER_LIST, "belongsTo", "原始凭证列表")
        .withType("original_voucher", OriginalVoucher.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(ACCOUNTING_DOCUMENT_LINE_LIST, "belongsTo", "会计文件行表")
        .withType("accounting_document_line", AccountingDocumentLine.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,ACCOUNTING_DOCUMENT_DATE_PROPERTY ,ACCOUNTING_PERIOD_PROPERTY ,DOCUMENT_TYPE_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(ORIGINAL_VOUCHER_LIST, "belongsTo");
    	
    	    refers.put(ACCOUNTING_DOCUMENT_LINE_LIST, "belongsTo");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(ORIGINAL_VOUCHER_LIST, OriginalVoucher.class);
        	
        	    refers.put(ACCOUNTING_DOCUMENT_LINE_LIST, AccountingDocumentLine.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(ACCOUNTING_PERIOD_PROPERTY, AccountingPeriod.class);
parents.put(DOCUMENT_TYPE_PROPERTY, AccountingDocumentType.class);

    return parents;
  }

  public AccountingDocument want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public AccountingDocument wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	name                ;
	protected		Date                	accountingDocumentDate;
	protected		AccountingPeriod    	accountingPeriod    ;
	protected		AccountingDocumentType	documentType        ;
	protected		int                 	version             ;

	
	protected		SmartList<OriginalVoucher>	mOriginalVoucherList;
	protected		SmartList<AccountingDocumentLine>	mAccountingDocumentLineList;



	public 	AccountingDocument(){
		// lazy load for all the properties
	}
	public 	static AccountingDocument withId(String id){
		AccountingDocument accountingDocument = new AccountingDocument();
		accountingDocument.setId(id);
		accountingDocument.setVersion(Integer.MAX_VALUE);
		accountingDocument.setChecked(true);
		return accountingDocument;
	}
	public 	static AccountingDocument refById(String id){
		return withId(id);
	}

  public AccountingDocument limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public AccountingDocument limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static AccountingDocument searchExample(){
    AccountingDocument accountingDocument = new AccountingDocument();
    		accountingDocument.setVersion(UNSET_INT);

    return accountingDocument;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAccountingPeriod( null );
		setDocumentType( null );

		this.changed = true;
		setChecked(false);
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
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(ACCOUNTING_DOCUMENT_DATE_PROPERTY.equals(property)){
			return getAccountingDocumentDate();
		}
		if(ACCOUNTING_PERIOD_PROPERTY.equals(property)){
			return getAccountingPeriod();
		}
		if(DOCUMENT_TYPE_PROPERTY.equals(property)){
			return getDocumentType();
		}
		if(ORIGINAL_VOUCHER_LIST.equals(property)){
			List<BaseEntity> list = getOriginalVoucherList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ACCOUNTING_DOCUMENT_LINE_LIST.equals(property)){
			List<BaseEntity> list = getAccountingDocumentLineList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public AccountingDocument updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public AccountingDocument orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public AccountingDocument ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public AccountingDocument addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public AccountingDocument updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public AccountingDocument orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public AccountingDocument ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public AccountingDocument addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setAccountingDocumentDate(Date accountingDocumentDate){Date oldAccountingDocumentDate = this.accountingDocumentDate;Date newAccountingDocumentDate = accountingDocumentDate;this.accountingDocumentDate = newAccountingDocumentDate;}
	public Date accountingDocumentDate(){
doLoad();
return getAccountingDocumentDate();
}
	public Date getAccountingDocumentDate(){
		return this.accountingDocumentDate;
	}
	public AccountingDocument updateAccountingDocumentDate(Date accountingDocumentDate){Date oldAccountingDocumentDate = this.accountingDocumentDate;Date newAccountingDocumentDate = accountingDocumentDate;if(!shouldReplaceBy(newAccountingDocumentDate, oldAccountingDocumentDate)){return this;}this.accountingDocumentDate = newAccountingDocumentDate;addPropertyChange(ACCOUNTING_DOCUMENT_DATE_PROPERTY, oldAccountingDocumentDate, newAccountingDocumentDate);this.changed = true;setChecked(false);return this;}
	public AccountingDocument orderByAccountingDocumentDate(boolean asc){
doAddOrderBy(ACCOUNTING_DOCUMENT_DATE_PROPERTY, asc);
return this;
}
	public SearchCriteria createAccountingDocumentDateCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ACCOUNTING_DOCUMENT_DATE_PROPERTY, operator, parameters);
}
	public AccountingDocument ignoreAccountingDocumentDateCriteria(){super.ignoreSearchProperty(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
return this;
}
	public AccountingDocument addAccountingDocumentDateCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAccountingDocumentDateCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAccountingDocumentDate(Date accountingDocumentDate){
		setAccountingDocumentDate(accountingDocumentDate);
	}

	
	public void setAccountingPeriod(AccountingPeriod accountingPeriod){AccountingPeriod oldAccountingPeriod = this.accountingPeriod;AccountingPeriod newAccountingPeriod = accountingPeriod;this.accountingPeriod = newAccountingPeriod;}
	public AccountingPeriod accountingPeriod(){
doLoad();
return getAccountingPeriod();
}
	public AccountingPeriod getAccountingPeriod(){
		return this.accountingPeriod;
	}
	public AccountingDocument updateAccountingPeriod(AccountingPeriod accountingPeriod){AccountingPeriod oldAccountingPeriod = this.accountingPeriod;AccountingPeriod newAccountingPeriod = accountingPeriod;if(!shouldReplaceBy(newAccountingPeriod, oldAccountingPeriod)){return this;}this.accountingPeriod = newAccountingPeriod;addPropertyChange(ACCOUNTING_PERIOD_PROPERTY, oldAccountingPeriod, newAccountingPeriod);this.changed = true;setChecked(false);return this;}
	public AccountingDocument orderByAccountingPeriod(boolean asc){
doAddOrderBy(ACCOUNTING_PERIOD_PROPERTY, asc);
return this;
}
	public SearchCriteria createAccountingPeriodCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ACCOUNTING_PERIOD_PROPERTY, operator, parameters);
}
	public AccountingDocument ignoreAccountingPeriodCriteria(){super.ignoreSearchProperty(ACCOUNTING_PERIOD_PROPERTY);
return this;
}
	public AccountingDocument addAccountingPeriodCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAccountingPeriodCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAccountingPeriod(AccountingPeriod accountingPeriod){
		if(accountingPeriod != null) { setAccountingPeriod(accountingPeriod);}
	}

	
	public void clearAccountingPeriod(){
		setAccountingPeriod ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setDocumentType(AccountingDocumentType documentType){AccountingDocumentType oldDocumentType = this.documentType;AccountingDocumentType newDocumentType = documentType;this.documentType = newDocumentType;}
	public AccountingDocumentType documentType(){
doLoad();
return getDocumentType();
}
	public AccountingDocumentType getDocumentType(){
		return this.documentType;
	}
	public AccountingDocument updateDocumentType(AccountingDocumentType documentType){AccountingDocumentType oldDocumentType = this.documentType;AccountingDocumentType newDocumentType = documentType;if(!shouldReplaceBy(newDocumentType, oldDocumentType)){return this;}this.documentType = newDocumentType;addPropertyChange(DOCUMENT_TYPE_PROPERTY, oldDocumentType, newDocumentType);this.changed = true;setChecked(false);return this;}
	public AccountingDocument orderByDocumentType(boolean asc){
doAddOrderBy(DOCUMENT_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createDocumentTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DOCUMENT_TYPE_PROPERTY, operator, parameters);
}
	public AccountingDocument ignoreDocumentTypeCriteria(){super.ignoreSearchProperty(DOCUMENT_TYPE_PROPERTY);
return this;
}
	public AccountingDocument addDocumentTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDocumentTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDocumentType(AccountingDocumentType documentType){
		if(documentType != null) { setDocumentType(documentType);}
	}

	
	public void clearDocumentType(){
		setDocumentType ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public AccountingDocument updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public AccountingDocument orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public AccountingDocument ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public AccountingDocument addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<OriginalVoucher> getOriginalVoucherList(){
		if(this.mOriginalVoucherList == null){
			this.mOriginalVoucherList = new SmartList<OriginalVoucher>();
			this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );
			//有名字，便于做权限控制
		}

		return this.mOriginalVoucherList;
	}

  public  SmartList<OriginalVoucher> originalVoucherList(){
    
    doLoadChild(ORIGINAL_VOUCHER_LIST);
    
    return getOriginalVoucherList();
  }


	public  void setOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setBelongsTo(this);
		}

		this.mOriginalVoucherList = originalVoucherList;
		this.mOriginalVoucherList.setListInternalName (ORIGINAL_VOUCHER_LIST );

	}

	public  AccountingDocument addOriginalVoucher(OriginalVoucher originalVoucher){
		originalVoucher.setBelongsTo(this);
		getOriginalVoucherList().add(originalVoucher);
		return this;
	}
	public  AccountingDocument addOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		for( OriginalVoucher originalVoucher:originalVoucherList){
			originalVoucher.setBelongsTo(this);
		}
		getOriginalVoucherList().addAll(originalVoucherList);
		return this;
	}
	public  void mergeOriginalVoucherList(SmartList<OriginalVoucher> originalVoucherList){
		if(originalVoucherList==null){
			return;
		}
		if(originalVoucherList.isEmpty()){
			return;
		}
		addOriginalVoucherList( originalVoucherList );

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

  public  SmartList<AccountingDocumentLine> accountingDocumentLineList(){
    
    doLoadChild(ACCOUNTING_DOCUMENT_LINE_LIST);
    
    return getAccountingDocumentLineList();
  }


	public  void setAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setBelongsTo(this);
		}

		this.mAccountingDocumentLineList = accountingDocumentLineList;
		this.mAccountingDocumentLineList.setListInternalName (ACCOUNTING_DOCUMENT_LINE_LIST );

	}

	public  AccountingDocument addAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		accountingDocumentLine.setBelongsTo(this);
		getAccountingDocumentLineList().add(accountingDocumentLine);
		return this;
	}
	public  AccountingDocument addAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setBelongsTo(this);
		}
		getAccountingDocumentLineList().addAll(accountingDocumentLineList);
		return this;
	}
	public  void mergeAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		if(accountingDocumentLineList==null){
			return;
		}
		if(accountingDocumentLineList.isEmpty()){
			return;
		}
		addAccountingDocumentLineList( accountingDocumentLineList );

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

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
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
			dest.setVersion(getVersion());
			dest.setOriginalVoucherList(getOriginalVoucherList());
			dest.setAccountingDocumentLineList(getAccountingDocumentLineList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof AccountingDocument){


			AccountingDocument dest =(AccountingDocument)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAccountingDocumentDate(getAccountingDocumentDate());
			dest.mergeAccountingPeriod(getAccountingPeriod());
			dest.mergeDocumentType(getDocumentType());
			dest.mergeVersion(getVersion());
			dest.mergeOriginalVoucherList(getOriginalVoucherList());
			dest.mergeAccountingDocumentLineList(getAccountingDocumentLineList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof AccountingDocument){


			AccountingDocument dest =(AccountingDocument)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAccountingDocumentDate(getAccountingDocumentDate());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getAccountingDocumentDate(), getAccountingPeriod(), getDocumentType(), getVersion()};
	}


	public static AccountingDocument createWith(RetailscmUserContext userContext, ThrowingFunction<AccountingDocument,AccountingDocument,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<AccountingDocument> customCreator = mapper.findCustomCreator(AccountingDocument.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    AccountingDocument result = new AccountingDocument();
    result.setName(mapper.tryToGet(AccountingDocument.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));
    result.setAccountingDocumentDate(mapper.tryToGet(AccountingDocument.class, ACCOUNTING_DOCUMENT_DATE_PROPERTY, Date.class,
        0, true, result.getAccountingDocumentDate(), params));
    result.setAccountingPeriod(mapper.tryToGet(AccountingDocument.class, ACCOUNTING_PERIOD_PROPERTY, AccountingPeriod.class,
        0, true, result.getAccountingPeriod(), params));
    result.setDocumentType(mapper.tryToGet(AccountingDocument.class, DOCUMENT_TYPE_PROPERTY, AccountingDocumentType.class,
        0, true, result.getDocumentType(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixAccountingDocument(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      AccountingDocumentTokens tokens = mapper.findParamByClass(params, AccountingDocumentTokens.class);
      if (tokens == null) {
        tokens = AccountingDocumentTokens.start();
      }
      result = userContext.getManagerGroup().getAccountingDocumentManager().internalSaveAccountingDocument(userContext, result, tokens.done());
      
    }
    return result;
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
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}


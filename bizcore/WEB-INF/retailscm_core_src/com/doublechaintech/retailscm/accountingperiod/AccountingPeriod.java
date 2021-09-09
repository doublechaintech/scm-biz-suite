
package com.doublechaintech.retailscm.accountingperiod;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(START_DATE_PROPERTY, "start_date", "开始日期")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(END_DATE_PROPERTY, "end_date", "结束日期")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ACCOUNT_SET_PROPERTY, "account_set", "账套")
        .withType("account_set", AccountSet.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(ACCOUNTING_DOCUMENT_LIST, "accountingPeriod", "会计文档列表")
        .withType("accounting_document", AccountingDocument.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,START_DATE_PROPERTY ,END_DATE_PROPERTY ,ACCOUNT_SET_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(ACCOUNTING_DOCUMENT_LIST, "accountingPeriod");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(ACCOUNTING_DOCUMENT_LIST, AccountingDocument.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(ACCOUNT_SET_PROPERTY, AccountSet.class);

    return parents;
  }

  public AccountingPeriod want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public AccountingPeriod wants(Class<? extends BaseEntity>... classes) {
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
	protected		Date                	startDate           ;
	protected		Date                	endDate             ;
	protected		AccountSet          	accountSet          ;
	protected		int                 	version             ;

	
	protected		SmartList<AccountingDocument>	mAccountingDocumentList;



	public 	AccountingPeriod(){
		// lazy load for all the properties
	}
	public 	static AccountingPeriod withId(String id){
		AccountingPeriod accountingPeriod = new AccountingPeriod();
		accountingPeriod.setId(id);
		accountingPeriod.setVersion(Integer.MAX_VALUE);
		accountingPeriod.setChecked(true);
		return accountingPeriod;
	}
	public 	static AccountingPeriod refById(String id){
		return withId(id);
	}

  public AccountingPeriod limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public AccountingPeriod limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static AccountingPeriod searchExample(){
    AccountingPeriod accountingPeriod = new AccountingPeriod();
    		accountingPeriod.setVersion(UNSET_INT);

    return accountingPeriod;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAccountSet( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public AccountingPeriod updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public AccountingPeriod orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public AccountingPeriod ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public AccountingPeriod addIdCriteria(QueryOperator operator, Object... parameters){
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
	public AccountingPeriod updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public AccountingPeriod orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public AccountingPeriod ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public AccountingPeriod addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setStartDate(Date startDate){Date oldStartDate = this.startDate;Date newStartDate = startDate;this.startDate = newStartDate;}
	public Date startDate(){
doLoad();
return getStartDate();
}
	public Date getStartDate(){
		return this.startDate;
	}
	public AccountingPeriod updateStartDate(Date startDate){Date oldStartDate = this.startDate;Date newStartDate = startDate;if(!shouldReplaceBy(newStartDate, oldStartDate)){return this;}this.startDate = newStartDate;addPropertyChange(START_DATE_PROPERTY, oldStartDate, newStartDate);this.changed = true;setChecked(false);return this;}
	public AccountingPeriod orderByStartDate(boolean asc){
doAddOrderBy(START_DATE_PROPERTY, asc);
return this;
}
	public SearchCriteria createStartDateCriteria(QueryOperator operator, Object... parameters){
return createCriteria(START_DATE_PROPERTY, operator, parameters);
}
	public AccountingPeriod ignoreStartDateCriteria(){super.ignoreSearchProperty(START_DATE_PROPERTY);
return this;
}
	public AccountingPeriod addStartDateCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createStartDateCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeStartDate(Date startDate){
		setStartDate(startDate);
	}

	
	public void setEndDate(Date endDate){Date oldEndDate = this.endDate;Date newEndDate = endDate;this.endDate = newEndDate;}
	public Date endDate(){
doLoad();
return getEndDate();
}
	public Date getEndDate(){
		return this.endDate;
	}
	public AccountingPeriod updateEndDate(Date endDate){Date oldEndDate = this.endDate;Date newEndDate = endDate;if(!shouldReplaceBy(newEndDate, oldEndDate)){return this;}this.endDate = newEndDate;addPropertyChange(END_DATE_PROPERTY, oldEndDate, newEndDate);this.changed = true;setChecked(false);return this;}
	public AccountingPeriod orderByEndDate(boolean asc){
doAddOrderBy(END_DATE_PROPERTY, asc);
return this;
}
	public SearchCriteria createEndDateCriteria(QueryOperator operator, Object... parameters){
return createCriteria(END_DATE_PROPERTY, operator, parameters);
}
	public AccountingPeriod ignoreEndDateCriteria(){super.ignoreSearchProperty(END_DATE_PROPERTY);
return this;
}
	public AccountingPeriod addEndDateCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createEndDateCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeEndDate(Date endDate){
		setEndDate(endDate);
	}

	
	public void setAccountSet(AccountSet accountSet){AccountSet oldAccountSet = this.accountSet;AccountSet newAccountSet = accountSet;this.accountSet = newAccountSet;}
	public AccountSet accountSet(){
doLoad();
return getAccountSet();
}
	public AccountSet getAccountSet(){
		return this.accountSet;
	}
	public AccountingPeriod updateAccountSet(AccountSet accountSet){AccountSet oldAccountSet = this.accountSet;AccountSet newAccountSet = accountSet;if(!shouldReplaceBy(newAccountSet, oldAccountSet)){return this;}this.accountSet = newAccountSet;addPropertyChange(ACCOUNT_SET_PROPERTY, oldAccountSet, newAccountSet);this.changed = true;setChecked(false);return this;}
	public AccountingPeriod orderByAccountSet(boolean asc){
doAddOrderBy(ACCOUNT_SET_PROPERTY, asc);
return this;
}
	public SearchCriteria createAccountSetCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ACCOUNT_SET_PROPERTY, operator, parameters);
}
	public AccountingPeriod ignoreAccountSetCriteria(){super.ignoreSearchProperty(ACCOUNT_SET_PROPERTY);
return this;
}
	public AccountingPeriod addAccountSetCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAccountSetCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAccountSet(AccountSet accountSet){
		if(accountSet != null) { setAccountSet(accountSet);}
	}

	
	public void clearAccountSet(){
		setAccountSet ( null );
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
	public AccountingPeriod updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public AccountingPeriod orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public AccountingPeriod ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public AccountingPeriod addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<AccountingDocument> accountingDocumentList(){
    
    doLoadChild(ACCOUNTING_DOCUMENT_LIST);
    
    return getAccountingDocumentList();
  }


	public  void setAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setAccountingPeriod(this);
		}

		this.mAccountingDocumentList = accountingDocumentList;
		this.mAccountingDocumentList.setListInternalName (ACCOUNTING_DOCUMENT_LIST );

	}

	public  AccountingPeriod addAccountingDocument(AccountingDocument accountingDocument){
		accountingDocument.setAccountingPeriod(this);
		getAccountingDocumentList().add(accountingDocument);
		return this;
	}
	public  AccountingPeriod addAccountingDocumentList(SmartList<AccountingDocument> accountingDocumentList){
		for( AccountingDocument accountingDocument:accountingDocumentList){
			accountingDocument.setAccountingPeriod(this);
		}
		getAccountingDocumentList().addAll(accountingDocumentList);
		return this;
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


	public static AccountingPeriod createWith(RetailscmUserContext userContext, ThrowingFunction<AccountingPeriod,AccountingPeriod,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<AccountingPeriod> customCreator = mapper.findCustomCreator(AccountingPeriod.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    AccountingPeriod result = new AccountingPeriod();
    result.setName(mapper.tryToGet(AccountingPeriod.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));
    result.setStartDate(mapper.tryToGet(AccountingPeriod.class, START_DATE_PROPERTY, Date.class,
        0, false, result.getStartDate(), params));
    result.setEndDate(mapper.tryToGet(AccountingPeriod.class, END_DATE_PROPERTY, Date.class,
        1, false, result.getEndDate(), params));
    result.setAccountSet(mapper.tryToGet(AccountingPeriod.class, ACCOUNT_SET_PROPERTY, AccountSet.class,
        0, true, result.getAccountSet(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixAccountingPeriod(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      AccountingPeriodTokens tokens = mapper.findParamByClass(params, AccountingPeriodTokens.class);
      if (tokens == null) {
        tokens = AccountingPeriodTokens.start();
      }
      result = userContext.getManagerGroup().getAccountingPeriodManager().internalSaveAccountingPeriod(userContext, result, tokens.done());
      
    }
    return result;
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


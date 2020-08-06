
package com.doublechaintech.retailscm.accountingsubject;

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
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountset.AccountSet;









@JsonSerialize(using = AccountingSubjectSerializer.class)
public class AccountingSubject extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String ACCOUNTING_SUBJECT_CODE_PROPERTY = "accountingSubjectCode";
	public static final String ACCOUNTING_SUBJECT_NAME_PROPERTY = "accountingSubjectName";
	public static final String ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY = "accountingSubjectClassCode";
	public static final String ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY = "accountingSubjectClassName";
	public static final String ACCOUNT_SET_PROPERTY           = "accountSet"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ACCOUNTING_DOCUMENT_LINE_LIST            = "accountingDocumentLineList";

	public static final String INTERNAL_TYPE="AccountingSubject";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getAccountingSubjectCode();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mAccountingSubjectCode;
	protected		String              	mAccountingSubjectName;
	protected		int                 	mAccountingSubjectClassCode;
	protected		String              	mAccountingSubjectClassName;
	protected		AccountSet          	mAccountSet         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AccountingDocumentLine>	mAccountingDocumentLineList;

	
		
	public 	AccountingSubject(){
		// lazy load for all the properties
	}
	public 	static AccountingSubject withId(String id){
		AccountingSubject accountingSubject = new AccountingSubject();
		accountingSubject.setId(id);
		accountingSubject.setVersion(Integer.MAX_VALUE);
		return accountingSubject;
	}
	public 	static AccountingSubject refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setAccountSet( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)){
			changeAccountingSubjectCodeProperty(newValueExpr);
		}
		if(ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)){
			changeAccountingSubjectNameProperty(newValueExpr);
		}
		if(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)){
			changeAccountingSubjectClassCodeProperty(newValueExpr);
		}
		if(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)){
			changeAccountingSubjectClassNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeAccountingSubjectCodeProperty(String newValueExpr){
	
		String oldValue = getAccountingSubjectCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountingSubjectCode(newValue);
		this.onChangeProperty(ACCOUNTING_SUBJECT_CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAccountingSubjectNameProperty(String newValueExpr){
	
		String oldValue = getAccountingSubjectName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountingSubjectName(newValue);
		this.onChangeProperty(ACCOUNTING_SUBJECT_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAccountingSubjectClassCodeProperty(String newValueExpr){
	
		int oldValue = getAccountingSubjectClassCode();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountingSubjectClassCode(newValue);
		this.onChangeProperty(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAccountingSubjectClassNameProperty(String newValueExpr){
	
		String oldValue = getAccountingSubjectClassName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccountingSubjectClassName(newValue);
		this.onChangeProperty(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(ACCOUNTING_SUBJECT_CODE_PROPERTY.equals(property)){
			return getAccountingSubjectCode();
		}
		if(ACCOUNTING_SUBJECT_NAME_PROPERTY.equals(property)){
			return getAccountingSubjectName();
		}
		if(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY.equals(property)){
			return getAccountingSubjectClassCode();
		}
		if(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY.equals(property)){
			return getAccountingSubjectClassName();
		}
		if(ACCOUNT_SET_PROPERTY.equals(property)){
			return getAccountSet();
		}
		if(ACCOUNTING_DOCUMENT_LINE_LIST.equals(property)){
			List<BaseEntity> list = getAccountingDocumentLineList().stream().map(item->item).collect(Collectors.toList());
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
	public AccountingSubject updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setAccountingSubjectCode(String accountingSubjectCode){
		this.mAccountingSubjectCode = trimString(accountingSubjectCode);;
	}
	public String getAccountingSubjectCode(){
		return this.mAccountingSubjectCode;
	}
	public AccountingSubject updateAccountingSubjectCode(String accountingSubjectCode){
		this.mAccountingSubjectCode = trimString(accountingSubjectCode);;
		this.changed = true;
		return this;
	}
	public void mergeAccountingSubjectCode(String accountingSubjectCode){
		if(accountingSubjectCode != null) { setAccountingSubjectCode(accountingSubjectCode);}
	}
	
	
	public void setAccountingSubjectName(String accountingSubjectName){
		this.mAccountingSubjectName = trimString(accountingSubjectName);;
	}
	public String getAccountingSubjectName(){
		return this.mAccountingSubjectName;
	}
	public AccountingSubject updateAccountingSubjectName(String accountingSubjectName){
		this.mAccountingSubjectName = trimString(accountingSubjectName);;
		this.changed = true;
		return this;
	}
	public void mergeAccountingSubjectName(String accountingSubjectName){
		if(accountingSubjectName != null) { setAccountingSubjectName(accountingSubjectName);}
	}
	
	
	public void setAccountingSubjectClassCode(int accountingSubjectClassCode){
		this.mAccountingSubjectClassCode = accountingSubjectClassCode;;
	}
	public int getAccountingSubjectClassCode(){
		return this.mAccountingSubjectClassCode;
	}
	public AccountingSubject updateAccountingSubjectClassCode(int accountingSubjectClassCode){
		this.mAccountingSubjectClassCode = accountingSubjectClassCode;;
		this.changed = true;
		return this;
	}
	public void mergeAccountingSubjectClassCode(int accountingSubjectClassCode){
		setAccountingSubjectClassCode(accountingSubjectClassCode);
	}
	
	
	public void setAccountingSubjectClassName(String accountingSubjectClassName){
		this.mAccountingSubjectClassName = trimString(accountingSubjectClassName);;
	}
	public String getAccountingSubjectClassName(){
		return this.mAccountingSubjectClassName;
	}
	public AccountingSubject updateAccountingSubjectClassName(String accountingSubjectClassName){
		this.mAccountingSubjectClassName = trimString(accountingSubjectClassName);;
		this.changed = true;
		return this;
	}
	public void mergeAccountingSubjectClassName(String accountingSubjectClassName){
		if(accountingSubjectClassName != null) { setAccountingSubjectClassName(accountingSubjectClassName);}
	}
	
	
	public void setAccountSet(AccountSet accountSet){
		this.mAccountSet = accountSet;;
	}
	public AccountSet getAccountSet(){
		return this.mAccountSet;
	}
	public AccountingSubject updateAccountSet(AccountSet accountSet){
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
	public AccountingSubject updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			accountingDocumentLine.setAccountingSubject(this);
		}

		this.mAccountingDocumentLineList = accountingDocumentLineList;
		this.mAccountingDocumentLineList.setListInternalName (ACCOUNTING_DOCUMENT_LINE_LIST );
		
	}
	
	public  void addAccountingDocumentLine(AccountingDocumentLine accountingDocumentLine){
		accountingDocumentLine.setAccountingSubject(this);
		getAccountingDocumentLineList().add(accountingDocumentLine);
	}
	public  void addAccountingDocumentLineList(SmartList<AccountingDocumentLine> accountingDocumentLineList){
		for( AccountingDocumentLine accountingDocumentLine:accountingDocumentLineList){
			accountingDocumentLine.setAccountingSubject(this);
		}
		getAccountingDocumentLineList().addAll(accountingDocumentLineList);
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
        // accountingDocumentLine.clearAccountingSubject(); //disconnect with AccountingSubject
        accountingDocumentLine.clearFromAll(); //disconnect with AccountingSubject
		
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
		accountingDocumentLine.setAccountingSubject(null);
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

		addToEntityList(this, entityList, getAccountSet(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getAccountingDocumentLineList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getAccountingDocumentLineList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, ACCOUNTING_SUBJECT_CODE_PROPERTY, getAccountingSubjectCode());
		appendKeyValuePair(result, ACCOUNTING_SUBJECT_NAME_PROPERTY, getAccountingSubjectName());
		appendKeyValuePair(result, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, getAccountingSubjectClassCode());
		appendKeyValuePair(result, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, getAccountingSubjectClassName());
		appendKeyValuePair(result, ACCOUNT_SET_PROPERTY, getAccountSet());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof AccountingSubject){
		
		
			AccountingSubject dest =(AccountingSubject)baseDest;
		
			dest.setId(getId());
			dest.setAccountingSubjectCode(getAccountingSubjectCode());
			dest.setAccountingSubjectName(getAccountingSubjectName());
			dest.setAccountingSubjectClassCode(getAccountingSubjectClassCode());
			dest.setAccountingSubjectClassName(getAccountingSubjectClassName());
			dest.setAccountSet(getAccountSet());
			dest.setVersion(getVersion());
			dest.setAccountingDocumentLineList(getAccountingDocumentLineList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingSubject){
		
			
			AccountingSubject dest =(AccountingSubject)baseDest;
		
			dest.mergeId(getId());
			dest.mergeAccountingSubjectCode(getAccountingSubjectCode());
			dest.mergeAccountingSubjectName(getAccountingSubjectName());
			dest.mergeAccountingSubjectClassCode(getAccountingSubjectClassCode());
			dest.mergeAccountingSubjectClassName(getAccountingSubjectClassName());
			dest.mergeAccountSet(getAccountSet());
			dest.mergeVersion(getVersion());
			dest.mergeAccountingDocumentLineList(getAccountingDocumentLineList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingSubject){
		
			
			AccountingSubject dest =(AccountingSubject)baseDest;
		
			dest.mergeId(getId());
			dest.mergeAccountingSubjectCode(getAccountingSubjectCode());
			dest.mergeAccountingSubjectName(getAccountingSubjectName());
			dest.mergeAccountingSubjectClassCode(getAccountingSubjectClassCode());
			dest.mergeAccountingSubjectClassName(getAccountingSubjectClassName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getAccountingSubjectCode(), getAccountingSubjectName(), getAccountingSubjectClassCode(), getAccountingSubjectClassName(), getAccountSet(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AccountingSubject{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\taccountingSubjectCode='"+getAccountingSubjectCode()+"';");
		stringBuilder.append("\taccountingSubjectName='"+getAccountingSubjectName()+"';");
		stringBuilder.append("\taccountingSubjectClassCode='"+getAccountingSubjectClassCode()+"';");
		stringBuilder.append("\taccountingSubjectClassName='"+getAccountingSubjectClassName()+"';");
		if(getAccountSet() != null ){
 			stringBuilder.append("\taccountSet='AccountSet("+getAccountSet().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseAccountingSubjectClassCode(int incAccountingSubjectClassCode){
		updateAccountingSubjectClassCode(this.mAccountingSubjectClassCode +  incAccountingSubjectClassCode);
	}
	public void decreaseAccountingSubjectClassCode(int decAccountingSubjectClassCode){
		updateAccountingSubjectClassCode(this.mAccountingSubjectClassCode - decAccountingSubjectClassCode);
	}
	

}


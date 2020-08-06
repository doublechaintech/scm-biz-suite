
package com.doublechaintech.retailscm.accountingdocumentline;

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
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;









@JsonSerialize(using = AccountingDocumentLineSerializer.class)
public class AccountingDocumentLine extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String DIRECT_PROPERTY                = "direct"            ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String ACCOUNTING_SUBJECT_PROPERTY    = "accountingSubject" ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="AccountingDocumentLine";
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
	protected		String              	mCode               ;
	protected		String              	mDirect             ;
	protected		BigDecimal          	mAmount             ;
	protected		AccountingDocument  	mBelongsTo          ;
	protected		AccountingSubject   	mAccountingSubject  ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	AccountingDocumentLine(){
		// lazy load for all the properties
	}
	public 	static AccountingDocumentLine withId(String id){
		AccountingDocumentLine accountingDocumentLine = new AccountingDocumentLine();
		accountingDocumentLine.setId(id);
		accountingDocumentLine.setVersion(Integer.MAX_VALUE);
		return accountingDocumentLine;
	}
	public 	static AccountingDocumentLine refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );
		setAccountingSubject( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DIRECT_PROPERTY.equals(property)){
			changeDirectProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changeCodeProperty(String newValueExpr){
	
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDirectProperty(String newValueExpr){
	
		String oldValue = getDirect();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDirect(newValue);
		this.onChangeProperty(DIRECT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAmountProperty(String newValueExpr){
	
		BigDecimal oldValue = getAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAmount(newValue);
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(DIRECT_PROPERTY.equals(property)){
			return getDirect();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
		}
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
		}
		if(ACCOUNTING_SUBJECT_PROPERTY.equals(property)){
			return getAccountingSubject();
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
	public AccountingDocumentLine updateId(String id){
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
	public AccountingDocumentLine updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public AccountingDocumentLine updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setDirect(String direct){
		this.mDirect = trimString(direct);;
	}
	public String getDirect(){
		return this.mDirect;
	}
	public AccountingDocumentLine updateDirect(String direct){
		this.mDirect = trimString(direct);;
		this.changed = true;
		return this;
	}
	public void mergeDirect(String direct){
		if(direct != null) { setDirect(direct);}
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public AccountingDocumentLine updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}
	
	
	public void setBelongsTo(AccountingDocument belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public AccountingDocument getBelongsTo(){
		return this.mBelongsTo;
	}
	public AccountingDocumentLine updateBelongsTo(AccountingDocument belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongsTo(AccountingDocument belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}
	
	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
	}
	
	public void setAccountingSubject(AccountingSubject accountingSubject){
		this.mAccountingSubject = accountingSubject;;
	}
	public AccountingSubject getAccountingSubject(){
		return this.mAccountingSubject;
	}
	public AccountingDocumentLine updateAccountingSubject(AccountingSubject accountingSubject){
		this.mAccountingSubject = accountingSubject;;
		this.changed = true;
		return this;
	}
	public void mergeAccountingSubject(AccountingSubject accountingSubject){
		if(accountingSubject != null) { setAccountingSubject(accountingSubject);}
	}
	
	
	public void clearAccountingSubject(){
		setAccountingSubject ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public AccountingDocumentLine updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBelongsTo(), internalType);
		addToEntityList(this, entityList, getAccountingSubject(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, DIRECT_PROPERTY, getDirect());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, ACCOUNTING_SUBJECT_PROPERTY, getAccountingSubject());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocumentLine){
		
		
			AccountingDocumentLine dest =(AccountingDocumentLine)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setDirect(getDirect());
			dest.setAmount(getAmount());
			dest.setBelongsTo(getBelongsTo());
			dest.setAccountingSubject(getAccountingSubject());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocumentLine){
		
			
			AccountingDocumentLine dest =(AccountingDocumentLine)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeDirect(getDirect());
			dest.mergeAmount(getAmount());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeAccountingSubject(getAccountingSubject());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AccountingDocumentLine){
		
			
			AccountingDocumentLine dest =(AccountingDocumentLine)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeDirect(getDirect());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getCode(), getDirect(), getAmount(), getBelongsTo(), getAccountingSubject(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AccountingDocumentLine{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		stringBuilder.append("\tdirect='"+getDirect()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='AccountingDocument("+getBelongsTo().getId()+")';");
 		}
		if(getAccountingSubject() != null ){
 			stringBuilder.append("\taccountingSubject='AccountingSubject("+getAccountingSubject().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


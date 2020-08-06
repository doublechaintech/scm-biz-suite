
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

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
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;









@JsonSerialize(using = RetailStoreMemberGiftCardConsumeRecordSerializer.class)
public class RetailStoreMemberGiftCardConsumeRecord extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String OCCURE_TIME_PROPERTY           = "occureTime"        ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="RetailStoreMemberGiftCardConsumeRecord";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getNumber();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Date                	mOccureTime         ;
	protected		RetailStoreMemberGiftCard	mOwner              ;
	protected		ConsumerOrder       	mBizOrder           ;
	protected		String              	mNumber             ;
	protected		BigDecimal          	mAmount             ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	RetailStoreMemberGiftCardConsumeRecord(){
		// lazy load for all the properties
	}
	public 	static RetailStoreMemberGiftCardConsumeRecord withId(String id){
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecord.setId(id);
		retailStoreMemberGiftCardConsumeRecord.setVersion(Integer.MAX_VALUE);
		return retailStoreMemberGiftCardConsumeRecord;
	}
	public 	static RetailStoreMemberGiftCardConsumeRecord refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );
		setBizOrder( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(OCCURE_TIME_PROPERTY.equals(property)){
			changeOccureTimeProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeOccureTimeProperty(String newValueExpr){
	
		Date oldValue = getOccureTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOccureTime(newValue);
		this.onChangeProperty(OCCURE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeNumberProperty(String newValueExpr){
	
		String oldValue = getNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNumber(newValue);
		this.onChangeProperty(NUMBER_PROPERTY, oldValue, newValue);
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
     	
		if(OCCURE_TIME_PROPERTY.equals(property)){
			return getOccureTime();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(NUMBER_PROPERTY.equals(property)){
			return getNumber();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
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
	public RetailStoreMemberGiftCardConsumeRecord updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setOccureTime(Date occureTime){
		this.mOccureTime = occureTime;;
	}
	public Date getOccureTime(){
		return this.mOccureTime;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateOccureTime(Date occureTime){
		this.mOccureTime = occureTime;;
		this.changed = true;
		return this;
	}
	public void mergeOccureTime(Date occureTime){
		setOccureTime(occureTime);
	}
	
	
	public void setOwner(RetailStoreMemberGiftCard owner){
		this.mOwner = owner;;
	}
	public RetailStoreMemberGiftCard getOwner(){
		return this.mOwner;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateOwner(RetailStoreMemberGiftCard owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	public void mergeOwner(RetailStoreMemberGiftCard owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public ConsumerOrder getBizOrder(){
		return this.mBizOrder;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
		this.changed = true;
		return this;
	}
	public void mergeBizOrder(ConsumerOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}
	
	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
	}
	
	public void setNumber(String number){
		this.mNumber = trimString(number);;
	}
	public String getNumber(){
		return this.mNumber;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateNumber(String number){
		this.mNumber = trimString(number);;
		this.changed = true;
		return this;
	}
	public void mergeNumber(String number){
		if(number != null) { setNumber(number);}
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);
		addToEntityList(this, entityList, getBizOrder(), internalType);

		
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
		appendKeyValuePair(result, OCCURE_TIME_PROPERTY, getOccureTime());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
		appendKeyValuePair(result, NUMBER_PROPERTY, getNumber());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberGiftCardConsumeRecord){
		
		
			RetailStoreMemberGiftCardConsumeRecord dest =(RetailStoreMemberGiftCardConsumeRecord)baseDest;
		
			dest.setId(getId());
			dest.setOccureTime(getOccureTime());
			dest.setOwner(getOwner());
			dest.setBizOrder(getBizOrder());
			dest.setNumber(getNumber());
			dest.setAmount(getAmount());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberGiftCardConsumeRecord){
		
			
			RetailStoreMemberGiftCardConsumeRecord dest =(RetailStoreMemberGiftCardConsumeRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeOccureTime(getOccureTime());
			dest.mergeOwner(getOwner());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeNumber(getNumber());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberGiftCardConsumeRecord){
		
			
			RetailStoreMemberGiftCardConsumeRecord dest =(RetailStoreMemberGiftCardConsumeRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeOccureTime(getOccureTime());
			dest.mergeNumber(getNumber());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getOccureTime(), getOwner(), getBizOrder(), getNumber(), getAmount(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMemberGiftCardConsumeRecord{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\toccureTime='"+getOccureTime()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMemberGiftCard("+getOwner().getId()+")';");
 		}
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='ConsumerOrder("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


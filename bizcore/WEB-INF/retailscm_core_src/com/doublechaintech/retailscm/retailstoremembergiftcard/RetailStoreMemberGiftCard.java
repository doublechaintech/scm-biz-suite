
package com.doublechaintech.retailscm.retailstoremembergiftcard;

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
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

@JsonSerialize(using = RetailStoreMemberGiftCardSerializer.class)
public class RetailStoreMemberGiftCard extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String REMAIN_PROPERTY                = "remain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";

	public static final String INTERNAL_TYPE="RetailStoreMemberGiftCard";
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
	protected		RetailStoreMember   	mOwner              ;
	protected		String              	mNumber             ;
	protected		BigDecimal          	mRemain             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStoreMemberGiftCardConsumeRecord>	mRetailStoreMemberGiftCardConsumeRecordList;

	
		
	public 	RetailStoreMemberGiftCard(){
		// lazy load for all the properties
	}
	public 	static RetailStoreMemberGiftCard withId(String id){
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCard.setId(id);
		retailStoreMemberGiftCard.setVersion(Integer.MAX_VALUE);
		return retailStoreMemberGiftCard;
	}
	public 	static RetailStoreMemberGiftCard refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(REMAIN_PROPERTY.equals(property)){
			changeRemainProperty(newValueExpr);
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
			
			
			
	protected void changeRemainProperty(String newValueExpr){
	
		BigDecimal oldValue = getRemain();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemain(newValue);
		this.onChangeProperty(REMAIN_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(NUMBER_PROPERTY.equals(property)){
			return getNumber();
		}
		if(REMAIN_PROPERTY.equals(property)){
			return getRemain();
		}
		if(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberGiftCardConsumeRecordList().stream().map(item->item).collect(Collectors.toList());
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
	public RetailStoreMemberGiftCard updateId(String id){
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
	public RetailStoreMemberGiftCard updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setOwner(RetailStoreMember owner){
		this.mOwner = owner;;
	}
	public RetailStoreMember getOwner(){
		return this.mOwner;
	}
	public RetailStoreMemberGiftCard updateOwner(RetailStoreMember owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	public void mergeOwner(RetailStoreMember owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setNumber(String number){
		this.mNumber = trimString(number);;
	}
	public String getNumber(){
		return this.mNumber;
	}
	public RetailStoreMemberGiftCard updateNumber(String number){
		this.mNumber = trimString(number);;
		this.changed = true;
		return this;
	}
	public void mergeNumber(String number){
		if(number != null) { setNumber(number);}
	}
	
	
	public void setRemain(BigDecimal remain){
		this.mRemain = remain;;
	}
	public BigDecimal getRemain(){
		return this.mRemain;
	}
	public RetailStoreMemberGiftCard updateRemain(BigDecimal remain){
		this.mRemain = remain;;
		this.changed = true;
		return this;
	}
	public void mergeRemain(BigDecimal remain){
		setRemain(remain);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreMemberGiftCard updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<RetailStoreMemberGiftCardConsumeRecord> getRetailStoreMemberGiftCardConsumeRecordList(){
		if(this.mRetailStoreMemberGiftCardConsumeRecordList == null){
			this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();
			this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreMemberGiftCardConsumeRecordList;	
	}
	public  void setRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		}

		this.mRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList;
		this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );
		
	}
	
	public  void addRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		getRetailStoreMemberGiftCardConsumeRecordList().add(retailStoreMemberGiftCardConsumeRecord);
	}
	public  void addRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		}
		getRetailStoreMemberGiftCardConsumeRecordList().addAll(retailStoreMemberGiftCardConsumeRecordList);
	}
	public  void mergeRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		if(retailStoreMemberGiftCardConsumeRecordList==null){
			return;
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return;
		}
		addRetailStoreMemberGiftCardConsumeRecordList( retailStoreMemberGiftCardConsumeRecordList );
		
	}
	public  RetailStoreMemberGiftCardConsumeRecord removeRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex){
		
		int index = getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecordIndex);
        if(index < 0){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordIndex.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = getRetailStoreMemberGiftCardConsumeRecordList().get(index);        
        // retailStoreMemberGiftCardConsumeRecord.clearOwner(); //disconnect with Owner
        retailStoreMemberGiftCardConsumeRecord.clearFromAll(); //disconnect with Owner
		
		boolean result = getRetailStoreMemberGiftCardConsumeRecordList().planToRemove(retailStoreMemberGiftCardConsumeRecord);
        if(!result){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordIndex.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMemberGiftCardConsumeRecord;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		
		if(retailStoreMemberGiftCardConsumeRecord == null){
			return;
		}
		retailStoreMemberGiftCardConsumeRecord.setOwner(null);
		//getRetailStoreMemberGiftCardConsumeRecordList().remove();
	
	}
	
	public  boolean hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
	
		return getRetailStoreMemberGiftCardConsumeRecordList().contains(retailStoreMemberGiftCardConsumeRecord);
  
	}
	
	public void copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordInList = findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
		RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecordInList.copyTo(newRetailStoreMemberGiftCardConsumeRecord);
		newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);//will trigger copy
		getRetailStoreMemberGiftCardConsumeRecordList().add(newRetailStoreMemberGiftCardConsumeRecord);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMemberGiftCardConsumeRecord);
	}
	
	public  RetailStoreMemberGiftCardConsumeRecord findTheRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		
		int index =  getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecord);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreMemberGiftCardConsumeRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberGiftCardConsumeRecordList(){
		getRetailStoreMemberGiftCardConsumeRecordList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRetailStoreMemberGiftCardConsumeRecordList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRetailStoreMemberGiftCardConsumeRecordList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, NUMBER_PROPERTY, getNumber());
		appendKeyValuePair(result, REMAIN_PROPERTY, getRemain());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordList());
		if(!getRetailStoreMemberGiftCardConsumeRecordList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberGiftCardConsumeRecordCount", getRetailStoreMemberGiftCardConsumeRecordList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberGiftCardConsumeRecordCurrentPageNumber", getRetailStoreMemberGiftCardConsumeRecordList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberGiftCard){
		
		
			RetailStoreMemberGiftCard dest =(RetailStoreMemberGiftCard)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setOwner(getOwner());
			dest.setNumber(getNumber());
			dest.setRemain(getRemain());
			dest.setVersion(getVersion());
			dest.setRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberGiftCard){
		
			
			RetailStoreMemberGiftCard dest =(RetailStoreMemberGiftCard)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeOwner(getOwner());
			dest.mergeNumber(getNumber());
			dest.mergeRemain(getRemain());
			dest.mergeVersion(getVersion());
			dest.mergeRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberGiftCard){
		
			
			RetailStoreMemberGiftCard dest =(RetailStoreMemberGiftCard)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeNumber(getNumber());
			dest.mergeRemain(getRemain());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getOwner(), getNumber(), getRemain(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMemberGiftCard{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMember("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tremain='"+getRemain()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


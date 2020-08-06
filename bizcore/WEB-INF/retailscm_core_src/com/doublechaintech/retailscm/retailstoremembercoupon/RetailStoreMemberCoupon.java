
package com.doublechaintech.retailscm.retailstoremembercoupon;

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
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;









@JsonSerialize(using = RetailStoreMemberCouponSerializer.class)
public class RetailStoreMemberCoupon extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="RetailStoreMemberCoupon";
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
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	RetailStoreMemberCoupon(){
		// lazy load for all the properties
	}
	public 	static RetailStoreMemberCoupon withId(String id){
		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		retailStoreMemberCoupon.setId(id);
		retailStoreMemberCoupon.setVersion(Integer.MAX_VALUE);
		return retailStoreMemberCoupon;
	}
	public 	static RetailStoreMemberCoupon refById(String id){
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
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(NUMBER_PROPERTY.equals(property)){
			return getNumber();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
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
	public RetailStoreMemberCoupon updateId(String id){
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
	public RetailStoreMemberCoupon updateName(String name){
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
	public RetailStoreMemberCoupon updateOwner(RetailStoreMember owner){
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
	public RetailStoreMemberCoupon updateNumber(String number){
		this.mNumber = trimString(number);;
		this.changed = true;
		return this;
	}
	public void mergeNumber(String number){
		if(number != null) { setNumber(number);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public RetailStoreMemberCoupon updateLastUpdateTime(DateTime lastUpdateTime){
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
	public RetailStoreMemberCoupon updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);

		
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
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, NUMBER_PROPERTY, getNumber());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberCoupon){
		
		
			RetailStoreMemberCoupon dest =(RetailStoreMemberCoupon)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setOwner(getOwner());
			dest.setNumber(getNumber());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberCoupon){
		
			
			RetailStoreMemberCoupon dest =(RetailStoreMemberCoupon)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeOwner(getOwner());
			dest.mergeNumber(getNumber());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberCoupon){
		
			
			RetailStoreMemberCoupon dest =(RetailStoreMemberCoupon)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeNumber(getNumber());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getOwner(), getNumber(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMemberCoupon{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMember("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


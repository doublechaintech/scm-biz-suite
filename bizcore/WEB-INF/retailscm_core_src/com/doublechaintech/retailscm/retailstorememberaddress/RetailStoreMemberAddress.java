
package com.doublechaintech.retailscm.retailstorememberaddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

@JsonSerialize(using = RetailStoreMemberAddressSerializer.class)
public class RetailStoreMemberAddress extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String MOBILE_PHONE_PROPERTY          = "mobilePhone"       ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="RetailStoreMemberAddress";
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
	protected		String              	mMobilePhone        ;
	protected		String              	mAddress            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	RetailStoreMemberAddress(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
	}
	
	public 	RetailStoreMemberAddress(String name, RetailStoreMember owner, String mobilePhone, String address)
	{
		setName(name);
		setOwner(owner);
		setMobilePhone(mobilePhone);
		setAddress(address);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PHONE_PROPERTY.equals(property)){
			changeMobilePhoneProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
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
			
			
			
	protected void changeMobilePhoneProperty(String newValueExpr){
		String oldValue = getMobilePhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobilePhone(newValue);
		this.onChangeProperty(MOBILE_PHONE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddress(newValue);
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public RetailStoreMemberAddress updateId(String id){
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
	public RetailStoreMemberAddress updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setOwner(RetailStoreMember owner){
		this.mOwner = owner;;
	}
	public RetailStoreMember getOwner(){
		return this.mOwner;
	}
	public RetailStoreMemberAddress updateOwner(RetailStoreMember owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setMobilePhone(String mobilePhone){
		this.mMobilePhone = trimString(mobilePhone);;
	}
	public String getMobilePhone(){
		return this.mMobilePhone;
	}
	public RetailStoreMemberAddress updateMobilePhone(String mobilePhone){
		this.mMobilePhone = trimString(mobilePhone);;
		this.changed = true;
		return this;
	}
	
	
	
	public String getMaskedMobilePhone(){
		String mobilePhoneNumber = getMobilePhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	public RetailStoreMemberAddress updateAddress(String address){
		this.mAddress = trimString(address);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreMemberAddress updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
		appendKeyValuePair(result, MOBILE_PHONE_PROPERTY, getMaskedMobilePhone());
		appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMemberAddress){
		
		
			RetailStoreMemberAddress dest =(RetailStoreMemberAddress)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setOwner(getOwner());
			dest.setMobilePhone(getMobilePhone());
			dest.setAddress(getAddress());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMemberAddress{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMember("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tmobilePhone='"+getMobilePhone()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


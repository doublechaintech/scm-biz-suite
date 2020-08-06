
package com.doublechaintech.retailscm.userallowlist;

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
import com.doublechaintech.retailscm.userdomain.UserDomain;









@JsonSerialize(using = UserAllowListSerializer.class)
public class UserAllowList extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String USER_IDENTITY_PROPERTY         = "userIdentity"      ;
	public static final String USER_SPECIAL_FUNCTIONS_PROPERTY = "userSpecialFunctions";
	public static final String DOMAIN_PROPERTY                = "domain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="UserAllowList";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getUserIdentity();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mUserIdentity       ;
	protected		String              	mUserSpecialFunctions;
	protected		UserDomain          	mDomain             ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	UserAllowList(){
		// lazy load for all the properties
	}
	public 	static UserAllowList withId(String id){
		UserAllowList userAllowList = new UserAllowList();
		userAllowList.setId(id);
		userAllowList.setVersion(Integer.MAX_VALUE);
		return userAllowList;
	}
	public 	static UserAllowList refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDomain( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(USER_IDENTITY_PROPERTY.equals(property)){
			changeUserIdentityProperty(newValueExpr);
		}
		if(USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			changeUserSpecialFunctionsProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeUserIdentityProperty(String newValueExpr){
	
		String oldValue = getUserIdentity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserIdentity(newValue);
		this.onChangeProperty(USER_IDENTITY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeUserSpecialFunctionsProperty(String newValueExpr){
	
		String oldValue = getUserSpecialFunctions();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserSpecialFunctions(newValue);
		this.onChangeProperty(USER_SPECIAL_FUNCTIONS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(USER_IDENTITY_PROPERTY.equals(property)){
			return getUserIdentity();
		}
		if(USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			return getUserSpecialFunctions();
		}
		if(DOMAIN_PROPERTY.equals(property)){
			return getDomain();
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
	public UserAllowList updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setUserIdentity(String userIdentity){
		this.mUserIdentity = trimString(userIdentity);;
	}
	public String getUserIdentity(){
		return this.mUserIdentity;
	}
	public UserAllowList updateUserIdentity(String userIdentity){
		this.mUserIdentity = trimString(userIdentity);;
		this.changed = true;
		return this;
	}
	public void mergeUserIdentity(String userIdentity){
		if(userIdentity != null) { setUserIdentity(userIdentity);}
	}
	
	
	public void setUserSpecialFunctions(String userSpecialFunctions){
		this.mUserSpecialFunctions = trimString(userSpecialFunctions);;
	}
	public String getUserSpecialFunctions(){
		return this.mUserSpecialFunctions;
	}
	public UserAllowList updateUserSpecialFunctions(String userSpecialFunctions){
		this.mUserSpecialFunctions = trimString(userSpecialFunctions);;
		this.changed = true;
		return this;
	}
	public void mergeUserSpecialFunctions(String userSpecialFunctions){
		if(userSpecialFunctions != null) { setUserSpecialFunctions(userSpecialFunctions);}
	}
	
	
	public void setDomain(UserDomain domain){
		this.mDomain = domain;;
	}
	public UserDomain getDomain(){
		return this.mDomain;
	}
	public UserAllowList updateDomain(UserDomain domain){
		this.mDomain = domain;;
		this.changed = true;
		return this;
	}
	public void mergeDomain(UserDomain domain){
		if(domain != null) { setDomain(domain);}
	}
	
	
	public void clearDomain(){
		setDomain ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public UserAllowList updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDomain(), internalType);

		
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
		appendKeyValuePair(result, USER_IDENTITY_PROPERTY, getUserIdentity());
		appendKeyValuePair(result, USER_SPECIAL_FUNCTIONS_PROPERTY, getUserSpecialFunctions());
		appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAllowList){
		
		
			UserAllowList dest =(UserAllowList)baseDest;
		
			dest.setId(getId());
			dest.setUserIdentity(getUserIdentity());
			dest.setUserSpecialFunctions(getUserSpecialFunctions());
			dest.setDomain(getDomain());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAllowList){
		
			
			UserAllowList dest =(UserAllowList)baseDest;
		
			dest.mergeId(getId());
			dest.mergeUserIdentity(getUserIdentity());
			dest.mergeUserSpecialFunctions(getUserSpecialFunctions());
			dest.mergeDomain(getDomain());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAllowList){
		
			
			UserAllowList dest =(UserAllowList)baseDest;
		
			dest.mergeId(getId());
			dest.mergeUserIdentity(getUserIdentity());
			dest.mergeUserSpecialFunctions(getUserSpecialFunctions());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getUserIdentity(), getUserSpecialFunctions(), getDomain(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserAllowList{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tuserIdentity='"+getUserIdentity()+"';");
		stringBuilder.append("\tuserSpecialFunctions='"+getUserSpecialFunctions()+"';");
		if(getDomain() != null ){
 			stringBuilder.append("\tdomain='UserDomain("+getDomain().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


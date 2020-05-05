
package com.doublechaintech.retailscm.userdomain;

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
import com.doublechaintech.retailscm.userwhitelist.UserWhiteList;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

@JsonSerialize(using = UserDomainSerializer.class)
public class UserDomain extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_WHITE_LIST_LIST                     = "userWhiteListList" ;
	public static final String SEC_USER_LIST                            = "secUserList"       ;
	public static final String PUBLIC_KEY_TYPE_LIST                     = "publicKeyTypeList" ;

	public static final String INTERNAL_TYPE="UserDomain";
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
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserWhiteList>	mUserWhiteListList  ;
	protected		SmartList<SecUser>  	mSecUserList        ;
	protected		SmartList<PublicKeyType>	mPublicKeyTypeList  ;

	
		
	public 	UserDomain(){
		// lazy load for all the properties
	}
	public 	static UserDomain withId(String id){
		UserDomain userDomain = new UserDomain();
		userDomain.setId(id);
		userDomain.setVersion(Integer.MAX_VALUE);
		return userDomain;
	}
	public 	static UserDomain refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(USER_WHITE_LIST_LIST.equals(property)){
			List<BaseEntity> list = getUserWhiteListList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SEC_USER_LIST.equals(property)){
			List<BaseEntity> list = getSecUserList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(PUBLIC_KEY_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getPublicKeyTypeList().stream().map(item->item).collect(Collectors.toList());
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
	public UserDomain updateId(String id){
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
	public UserDomain updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public UserDomain updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<UserWhiteList> getUserWhiteListList(){
		if(this.mUserWhiteListList == null){
			this.mUserWhiteListList = new SmartList<UserWhiteList>();
			this.mUserWhiteListList.setListInternalName (USER_WHITE_LIST_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserWhiteListList;	
	}
	public  void setUserWhiteListList(SmartList<UserWhiteList> userWhiteListList){
		for( UserWhiteList userWhiteList:userWhiteListList){
			userWhiteList.setDomain(this);
		}

		this.mUserWhiteListList = userWhiteListList;
		this.mUserWhiteListList.setListInternalName (USER_WHITE_LIST_LIST );
		
	}
	
	public  void addUserWhiteList(UserWhiteList userWhiteList){
		userWhiteList.setDomain(this);
		getUserWhiteListList().add(userWhiteList);
	}
	public  void addUserWhiteListList(SmartList<UserWhiteList> userWhiteListList){
		for( UserWhiteList userWhiteList:userWhiteListList){
			userWhiteList.setDomain(this);
		}
		getUserWhiteListList().addAll(userWhiteListList);
	}
	public  void mergeUserWhiteListList(SmartList<UserWhiteList> userWhiteListList){
		if(userWhiteListList==null){
			return;
		}
		if(userWhiteListList.isEmpty()){
			return;
		}
		addUserWhiteListList( userWhiteListList );
		
	}
	public  UserWhiteList removeUserWhiteList(UserWhiteList userWhiteListIndex){
		
		int index = getUserWhiteListList().indexOf(userWhiteListIndex);
        if(index < 0){
        	String message = "UserWhiteList("+userWhiteListIndex.getId()+") with version='"+userWhiteListIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UserWhiteList userWhiteList = getUserWhiteListList().get(index);        
        // userWhiteList.clearDomain(); //disconnect with Domain
        userWhiteList.clearFromAll(); //disconnect with Domain
		
		boolean result = getUserWhiteListList().planToRemove(userWhiteList);
        if(!result){
        	String message = "UserWhiteList("+userWhiteListIndex.getId()+") with version='"+userWhiteListIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return userWhiteList;
        
	
	}
	//断舍离
	public  void breakWithUserWhiteList(UserWhiteList userWhiteList){
		
		if(userWhiteList == null){
			return;
		}
		userWhiteList.setDomain(null);
		//getUserWhiteListList().remove();
	
	}
	
	public  boolean hasUserWhiteList(UserWhiteList userWhiteList){
	
		return getUserWhiteListList().contains(userWhiteList);
  
	}
	
	public void copyUserWhiteListFrom(UserWhiteList userWhiteList) {

		UserWhiteList userWhiteListInList = findTheUserWhiteList(userWhiteList);
		UserWhiteList newUserWhiteList = new UserWhiteList();
		userWhiteListInList.copyTo(newUserWhiteList);
		newUserWhiteList.setVersion(0);//will trigger copy
		getUserWhiteListList().add(newUserWhiteList);
		addItemToFlexiableObject(COPIED_CHILD, newUserWhiteList);
	}
	
	public  UserWhiteList findTheUserWhiteList(UserWhiteList userWhiteList){
		
		int index =  getUserWhiteListList().indexOf(userWhiteList);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UserWhiteList("+userWhiteList.getId()+") with version='"+userWhiteList.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserWhiteListList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserWhiteListList(){
		getUserWhiteListList().clear();
	}
	
	
	


	public  SmartList<SecUser> getSecUserList(){
		if(this.mSecUserList == null){
			this.mSecUserList = new SmartList<SecUser>();
			this.mSecUserList.setListInternalName (SEC_USER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSecUserList;	
	}
	public  void setSecUserList(SmartList<SecUser> secUserList){
		for( SecUser secUser:secUserList){
			secUser.setDomain(this);
		}

		this.mSecUserList = secUserList;
		this.mSecUserList.setListInternalName (SEC_USER_LIST );
		
	}
	
	public  void addSecUser(SecUser secUser){
		secUser.setDomain(this);
		getSecUserList().add(secUser);
	}
	public  void addSecUserList(SmartList<SecUser> secUserList){
		for( SecUser secUser:secUserList){
			secUser.setDomain(this);
		}
		getSecUserList().addAll(secUserList);
	}
	public  void mergeSecUserList(SmartList<SecUser> secUserList){
		if(secUserList==null){
			return;
		}
		if(secUserList.isEmpty()){
			return;
		}
		addSecUserList( secUserList );
		
	}
	public  SecUser removeSecUser(SecUser secUserIndex){
		
		int index = getSecUserList().indexOf(secUserIndex);
        if(index < 0){
        	String message = "SecUser("+secUserIndex.getId()+") with version='"+secUserIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SecUser secUser = getSecUserList().get(index);        
        // secUser.clearDomain(); //disconnect with Domain
        secUser.clearFromAll(); //disconnect with Domain
		
		boolean result = getSecUserList().planToRemove(secUser);
        if(!result){
        	String message = "SecUser("+secUserIndex.getId()+") with version='"+secUserIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return secUser;
        
	
	}
	//断舍离
	public  void breakWithSecUser(SecUser secUser){
		
		if(secUser == null){
			return;
		}
		secUser.setDomain(null);
		//getSecUserList().remove();
	
	}
	
	public  boolean hasSecUser(SecUser secUser){
	
		return getSecUserList().contains(secUser);
  
	}
	
	public void copySecUserFrom(SecUser secUser) {

		SecUser secUserInList = findTheSecUser(secUser);
		SecUser newSecUser = new SecUser();
		secUserInList.copyTo(newSecUser);
		newSecUser.setVersion(0);//will trigger copy
		getSecUserList().add(newSecUser);
		addItemToFlexiableObject(COPIED_CHILD, newSecUser);
	}
	
	public  SecUser findTheSecUser(SecUser secUser){
		
		int index =  getSecUserList().indexOf(secUser);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SecUser("+secUser.getId()+") with version='"+secUser.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSecUserList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSecUserList(){
		getSecUserList().clear();
	}
	
	
	


	public  SmartList<PublicKeyType> getPublicKeyTypeList(){
		if(this.mPublicKeyTypeList == null){
			this.mPublicKeyTypeList = new SmartList<PublicKeyType>();
			this.mPublicKeyTypeList.setListInternalName (PUBLIC_KEY_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPublicKeyTypeList;	
	}
	public  void setPublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList){
		for( PublicKeyType publicKeyType:publicKeyTypeList){
			publicKeyType.setDomain(this);
		}

		this.mPublicKeyTypeList = publicKeyTypeList;
		this.mPublicKeyTypeList.setListInternalName (PUBLIC_KEY_TYPE_LIST );
		
	}
	
	public  void addPublicKeyType(PublicKeyType publicKeyType){
		publicKeyType.setDomain(this);
		getPublicKeyTypeList().add(publicKeyType);
	}
	public  void addPublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList){
		for( PublicKeyType publicKeyType:publicKeyTypeList){
			publicKeyType.setDomain(this);
		}
		getPublicKeyTypeList().addAll(publicKeyTypeList);
	}
	public  void mergePublicKeyTypeList(SmartList<PublicKeyType> publicKeyTypeList){
		if(publicKeyTypeList==null){
			return;
		}
		if(publicKeyTypeList.isEmpty()){
			return;
		}
		addPublicKeyTypeList( publicKeyTypeList );
		
	}
	public  PublicKeyType removePublicKeyType(PublicKeyType publicKeyTypeIndex){
		
		int index = getPublicKeyTypeList().indexOf(publicKeyTypeIndex);
        if(index < 0){
        	String message = "PublicKeyType("+publicKeyTypeIndex.getId()+") with version='"+publicKeyTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PublicKeyType publicKeyType = getPublicKeyTypeList().get(index);        
        // publicKeyType.clearDomain(); //disconnect with Domain
        publicKeyType.clearFromAll(); //disconnect with Domain
		
		boolean result = getPublicKeyTypeList().planToRemove(publicKeyType);
        if(!result){
        	String message = "PublicKeyType("+publicKeyTypeIndex.getId()+") with version='"+publicKeyTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return publicKeyType;
        
	
	}
	//断舍离
	public  void breakWithPublicKeyType(PublicKeyType publicKeyType){
		
		if(publicKeyType == null){
			return;
		}
		publicKeyType.setDomain(null);
		//getPublicKeyTypeList().remove();
	
	}
	
	public  boolean hasPublicKeyType(PublicKeyType publicKeyType){
	
		return getPublicKeyTypeList().contains(publicKeyType);
  
	}
	
	public void copyPublicKeyTypeFrom(PublicKeyType publicKeyType) {

		PublicKeyType publicKeyTypeInList = findThePublicKeyType(publicKeyType);
		PublicKeyType newPublicKeyType = new PublicKeyType();
		publicKeyTypeInList.copyTo(newPublicKeyType);
		newPublicKeyType.setVersion(0);//will trigger copy
		getPublicKeyTypeList().add(newPublicKeyType);
		addItemToFlexiableObject(COPIED_CHILD, newPublicKeyType);
	}
	
	public  PublicKeyType findThePublicKeyType(PublicKeyType publicKeyType){
		
		int index =  getPublicKeyTypeList().indexOf(publicKeyType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PublicKeyType("+publicKeyType.getId()+") with version='"+publicKeyType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPublicKeyTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPublicKeyTypeList(){
		getPublicKeyTypeList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserWhiteListList(), internalType);
		collectFromList(this, entityList, getSecUserList(), internalType);
		collectFromList(this, entityList, getPublicKeyTypeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserWhiteListList());
		listOfList.add( getSecUserList());
		listOfList.add( getPublicKeyTypeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_WHITE_LIST_LIST, getUserWhiteListList());
		if(!getUserWhiteListList().isEmpty()){
			appendKeyValuePair(result, "userWhiteListCount", getUserWhiteListList().getTotalCount());
			appendKeyValuePair(result, "userWhiteListCurrentPageNumber", getUserWhiteListList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SEC_USER_LIST, getSecUserList());
		if(!getSecUserList().isEmpty()){
			appendKeyValuePair(result, "secUserCount", getSecUserList().getTotalCount());
			appendKeyValuePair(result, "secUserCurrentPageNumber", getSecUserList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PUBLIC_KEY_TYPE_LIST, getPublicKeyTypeList());
		if(!getPublicKeyTypeList().isEmpty()){
			appendKeyValuePair(result, "publicKeyTypeCount", getPublicKeyTypeList().getTotalCount());
			appendKeyValuePair(result, "publicKeyTypeCurrentPageNumber", getPublicKeyTypeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserDomain){
		
		
			UserDomain dest =(UserDomain)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setUserWhiteListList(getUserWhiteListList());
			dest.setSecUserList(getSecUserList());
			dest.setPublicKeyTypeList(getPublicKeyTypeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserDomain){
		
			
			UserDomain dest =(UserDomain)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());
			dest.mergeUserWhiteListList(getUserWhiteListList());
			dest.mergeSecUserList(getSecUserList());
			dest.mergePublicKeyTypeList(getPublicKeyTypeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserDomain){
		
			
			UserDomain dest =(UserDomain)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserDomain{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


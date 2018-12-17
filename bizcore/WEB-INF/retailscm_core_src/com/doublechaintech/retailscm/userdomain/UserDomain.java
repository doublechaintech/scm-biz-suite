
package com.doublechaintech.retailscm.userdomain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.userwhitelist.UserWhiteList;
import com.doublechaintech.retailscm.secuser.SecUser;

@JsonSerialize(using = UserDomainSerializer.class)
public class UserDomain extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_WHITE_LIST_LIST                     = "userWhiteListList" ;
	public static final String SEC_USER_LIST                            = "secUserList"       ;

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
	
		
	public 	UserDomain(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	UserDomain(String name)
	{
		setName(name);

		this.mUserWhiteListList = new SmartList<UserWhiteList>();
		this.mSecUserList = new SmartList<SecUser>();	
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserWhiteListList(), internalType);
		collectFromList(this, entityList, getSecUserList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserWhiteListList());
		listOfList.add( getSecUserList());
			

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

		}
		super.copyTo(baseDest);
		return baseDest;
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


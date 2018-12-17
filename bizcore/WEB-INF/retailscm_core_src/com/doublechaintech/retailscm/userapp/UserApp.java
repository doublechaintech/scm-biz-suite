
package com.doublechaintech.retailscm.userapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.objectaccess.ObjectAccess;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.secuser.SecUser;

@JsonSerialize(using = UserAppSerializer.class)
public class UserApp extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String APP_ICON_PROPERTY              = "appIcon"           ;
	public static final String FULL_ACCESS_PROPERTY           = "fullAccess"        ;
	public static final String PERMISSION_PROPERTY            = "permission"        ;
	public static final String OBJECT_TYPE_PROPERTY           = "objectType"        ;
	public static final String OBJECT_ID_PROPERTY             = "objectId"          ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LIST_ACCESS_LIST                         = "listAccessList"    ;
	public static final String OBJECT_ACCESS_LIST                       = "objectAccessList"  ;

	public static final String INTERNAL_TYPE="UserApp";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		SecUser             	mSecUser            ;
	protected		String              	mAppIcon            ;
	protected		boolean             	mFullAccess         ;
	protected		String              	mPermission         ;
	protected		String              	mObjectType         ;
	protected		String              	mObjectId           ;
	protected		String              	mLocation           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ListAccess>	mListAccessList     ;
	protected		SmartList<ObjectAccess>	mObjectAccessList   ;
	
		
	public 	UserApp(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSecUser( null );

		this.changed = true;
	}
	
	public 	UserApp(String title, SecUser secUser, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location)
	{
		setTitle(title);
		setSecUser(secUser);
		setAppIcon(appIcon);
		setFullAccess(fullAccess);
		setPermission(permission);
		setObjectType(objectType);
		setObjectId(objectId);
		setLocation(location);

		this.mListAccessList = new SmartList<ListAccess>();
		this.mObjectAccessList = new SmartList<ObjectAccess>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(APP_ICON_PROPERTY.equals(property)){
			changeAppIconProperty(newValueExpr);
		}
		if(FULL_ACCESS_PROPERTY.equals(property)){
			changeFullAccessProperty(newValueExpr);
		}
		if(PERMISSION_PROPERTY.equals(property)){
			changePermissionProperty(newValueExpr);
		}
		if(OBJECT_TYPE_PROPERTY.equals(property)){
			changeObjectTypeProperty(newValueExpr);
		}
		if(OBJECT_ID_PROPERTY.equals(property)){
			changeObjectIdProperty(newValueExpr);
		}
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAppIconProperty(String newValueExpr){
		String oldValue = getAppIcon();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAppIcon(newValue);
		this.onChangeProperty(APP_ICON_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeFullAccessProperty(String newValueExpr){
		boolean oldValue = getFullAccess();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFullAccess(newValue);
		this.onChangeProperty(FULL_ACCESS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePermissionProperty(String newValueExpr){
		String oldValue = getPermission();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePermission(newValue);
		this.onChangeProperty(PERMISSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeObjectTypeProperty(String newValueExpr){
		String oldValue = getObjectType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateObjectType(newValue);
		this.onChangeProperty(OBJECT_TYPE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeObjectIdProperty(String newValueExpr){
		String oldValue = getObjectId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateObjectId(newValue);
		this.onChangeProperty(OBJECT_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLocationProperty(String newValueExpr){
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLocation(newValue);
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public UserApp updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public UserApp updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setSecUser(SecUser secUser){
		this.mSecUser = secUser;;
	}
	public SecUser getSecUser(){
		return this.mSecUser;
	}
	public UserApp updateSecUser(SecUser secUser){
		this.mSecUser = secUser;;
		this.changed = true;
		return this;
	}
	
	
	public void clearSecUser(){
		setSecUser ( null );
		this.changed = true;
	}
	
	public void setAppIcon(String appIcon){
		this.mAppIcon = trimString(appIcon);;
	}
	public String getAppIcon(){
		return this.mAppIcon;
	}
	public UserApp updateAppIcon(String appIcon){
		this.mAppIcon = trimString(appIcon);;
		this.changed = true;
		return this;
	}
	
	
	public void setFullAccess(boolean fullAccess){
		this.mFullAccess = fullAccess;;
	}
	public boolean getFullAccess(){
		return this.mFullAccess;
	}
	public UserApp updateFullAccess(boolean fullAccess){
		this.mFullAccess = fullAccess;;
		this.changed = true;
		return this;
	}
	
	
	public void setPermission(String permission){
		this.mPermission = trimString(permission);;
	}
	public String getPermission(){
		return this.mPermission;
	}
	public UserApp updatePermission(String permission){
		this.mPermission = trimString(permission);;
		this.changed = true;
		return this;
	}
	
	
	public void setObjectType(String objectType){
		this.mObjectType = trimString(objectType);;
	}
	public String getObjectType(){
		return this.mObjectType;
	}
	public UserApp updateObjectType(String objectType){
		this.mObjectType = trimString(objectType);;
		this.changed = true;
		return this;
	}
	
	
	public void setObjectId(String objectId){
		this.mObjectId = trimString(objectId);;
	}
	public String getObjectId(){
		return this.mObjectId;
	}
	public UserApp updateObjectId(String objectId){
		this.mObjectId = trimString(objectId);;
		this.changed = true;
		return this;
	}
	
	
	public void clearObjectId(){
		setObjectId ( null );
		this.changed = true;
	}
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	public UserApp updateLocation(String location){
		this.mLocation = trimString(location);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public UserApp updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<ListAccess> getListAccessList(){
		if(this.mListAccessList == null){
			this.mListAccessList = new SmartList<ListAccess>();
			this.mListAccessList.setListInternalName (LIST_ACCESS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mListAccessList;	
	}
	public  void setListAccessList(SmartList<ListAccess> listAccessList){
		for( ListAccess listAccess:listAccessList){
			listAccess.setApp(this);
		}

		this.mListAccessList = listAccessList;
		this.mListAccessList.setListInternalName (LIST_ACCESS_LIST );
		
	}
	
	public  void addListAccess(ListAccess listAccess){
		listAccess.setApp(this);
		getListAccessList().add(listAccess);
	}
	public  void addListAccessList(SmartList<ListAccess> listAccessList){
		for( ListAccess listAccess:listAccessList){
			listAccess.setApp(this);
		}
		getListAccessList().addAll(listAccessList);
	}
	
	public  ListAccess removeListAccess(ListAccess listAccessIndex){
		
		int index = getListAccessList().indexOf(listAccessIndex);
        if(index < 0){
        	String message = "ListAccess("+listAccessIndex.getId()+") with version='"+listAccessIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ListAccess listAccess = getListAccessList().get(index);        
        // listAccess.clearApp(); //disconnect with App
        listAccess.clearFromAll(); //disconnect with App
		
		boolean result = getListAccessList().planToRemove(listAccess);
        if(!result){
        	String message = "ListAccess("+listAccessIndex.getId()+") with version='"+listAccessIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return listAccess;
        
	
	}
	//断舍离
	public  void breakWithListAccess(ListAccess listAccess){
		
		if(listAccess == null){
			return;
		}
		listAccess.setApp(null);
		//getListAccessList().remove();
	
	}
	
	public  boolean hasListAccess(ListAccess listAccess){
	
		return getListAccessList().contains(listAccess);
  
	}
	
	public void copyListAccessFrom(ListAccess listAccess) {

		ListAccess listAccessInList = findTheListAccess(listAccess);
		ListAccess newListAccess = new ListAccess();
		listAccessInList.copyTo(newListAccess);
		newListAccess.setVersion(0);//will trigger copy
		getListAccessList().add(newListAccess);
		addItemToFlexiableObject(COPIED_CHILD, newListAccess);
	}
	
	public  ListAccess findTheListAccess(ListAccess listAccess){
		
		int index =  getListAccessList().indexOf(listAccess);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ListAccess("+listAccess.getId()+") with version='"+listAccess.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getListAccessList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpListAccessList(){
		getListAccessList().clear();
	}
	
	
	


	public  SmartList<ObjectAccess> getObjectAccessList(){
		if(this.mObjectAccessList == null){
			this.mObjectAccessList = new SmartList<ObjectAccess>();
			this.mObjectAccessList.setListInternalName (OBJECT_ACCESS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mObjectAccessList;	
	}
	public  void setObjectAccessList(SmartList<ObjectAccess> objectAccessList){
		for( ObjectAccess objectAccess:objectAccessList){
			objectAccess.setApp(this);
		}

		this.mObjectAccessList = objectAccessList;
		this.mObjectAccessList.setListInternalName (OBJECT_ACCESS_LIST );
		
	}
	
	public  void addObjectAccess(ObjectAccess objectAccess){
		objectAccess.setApp(this);
		getObjectAccessList().add(objectAccess);
	}
	public  void addObjectAccessList(SmartList<ObjectAccess> objectAccessList){
		for( ObjectAccess objectAccess:objectAccessList){
			objectAccess.setApp(this);
		}
		getObjectAccessList().addAll(objectAccessList);
	}
	
	public  ObjectAccess removeObjectAccess(ObjectAccess objectAccessIndex){
		
		int index = getObjectAccessList().indexOf(objectAccessIndex);
        if(index < 0){
        	String message = "ObjectAccess("+objectAccessIndex.getId()+") with version='"+objectAccessIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ObjectAccess objectAccess = getObjectAccessList().get(index);        
        // objectAccess.clearApp(); //disconnect with App
        objectAccess.clearFromAll(); //disconnect with App
		
		boolean result = getObjectAccessList().planToRemove(objectAccess);
        if(!result){
        	String message = "ObjectAccess("+objectAccessIndex.getId()+") with version='"+objectAccessIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return objectAccess;
        
	
	}
	//断舍离
	public  void breakWithObjectAccess(ObjectAccess objectAccess){
		
		if(objectAccess == null){
			return;
		}
		objectAccess.setApp(null);
		//getObjectAccessList().remove();
	
	}
	
	public  boolean hasObjectAccess(ObjectAccess objectAccess){
	
		return getObjectAccessList().contains(objectAccess);
  
	}
	
	public void copyObjectAccessFrom(ObjectAccess objectAccess) {

		ObjectAccess objectAccessInList = findTheObjectAccess(objectAccess);
		ObjectAccess newObjectAccess = new ObjectAccess();
		objectAccessInList.copyTo(newObjectAccess);
		newObjectAccess.setVersion(0);//will trigger copy
		getObjectAccessList().add(newObjectAccess);
		addItemToFlexiableObject(COPIED_CHILD, newObjectAccess);
	}
	
	public  ObjectAccess findTheObjectAccess(ObjectAccess objectAccess){
		
		int index =  getObjectAccessList().indexOf(objectAccess);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ObjectAccess("+objectAccess.getId()+") with version='"+objectAccess.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getObjectAccessList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpObjectAccessList(){
		getObjectAccessList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSecUser(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getListAccessList(), internalType);
		collectFromList(this, entityList, getObjectAccessList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getListAccessList());
		listOfList.add( getObjectAccessList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
		appendKeyValuePair(result, APP_ICON_PROPERTY, getAppIcon());
		appendKeyValuePair(result, FULL_ACCESS_PROPERTY, getFullAccess());
		appendKeyValuePair(result, PERMISSION_PROPERTY, getPermission());
		appendKeyValuePair(result, OBJECT_TYPE_PROPERTY, getObjectType());
		appendKeyValuePair(result, OBJECT_ID_PROPERTY, getObjectId());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LIST_ACCESS_LIST, getListAccessList());
		if(!getListAccessList().isEmpty()){
			appendKeyValuePair(result, "listAccessCount", getListAccessList().getTotalCount());
			appendKeyValuePair(result, "listAccessCurrentPageNumber", getListAccessList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, OBJECT_ACCESS_LIST, getObjectAccessList());
		if(!getObjectAccessList().isEmpty()){
			appendKeyValuePair(result, "objectAccessCount", getObjectAccessList().getTotalCount());
			appendKeyValuePair(result, "objectAccessCurrentPageNumber", getObjectAccessList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserApp){
		
		
			UserApp dest =(UserApp)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setSecUser(getSecUser());
			dest.setAppIcon(getAppIcon());
			dest.setFullAccess(getFullAccess());
			dest.setPermission(getPermission());
			dest.setObjectType(getObjectType());
			dest.setObjectId(getObjectId());
			dest.setLocation(getLocation());
			dest.setVersion(getVersion());
			dest.setListAccessList(getListAccessList());
			dest.setObjectAccessList(getObjectAccessList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserApp{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getSecUser() != null ){
 			stringBuilder.append("\tsecUser='SecUser("+getSecUser().getId()+")';");
 		}
		stringBuilder.append("\tappIcon='"+getAppIcon()+"';");
		stringBuilder.append("\tfullAccess='"+getFullAccess()+"';");
		stringBuilder.append("\tpermission='"+getPermission()+"';");
		stringBuilder.append("\tobjectType='"+getObjectType()+"';");
		stringBuilder.append("\tobjectId='"+getObjectId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


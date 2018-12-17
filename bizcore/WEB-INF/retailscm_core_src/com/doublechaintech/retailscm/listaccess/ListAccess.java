
package com.doublechaintech.retailscm.listaccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.userapp.UserApp;

@JsonSerialize(using = ListAccessSerializer.class)
public class ListAccess extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTERNAL_NAME_PROPERTY         = "internalName"      ;
	public static final String READ_PERMISSION_PROPERTY       = "readPermission"    ;
	public static final String CREATE_PERMISSION_PROPERTY     = "createPermission"  ;
	public static final String DELETE_PERMISSION_PROPERTY     = "deletePermission"  ;
	public static final String UPDATE_PERMISSION_PROPERTY     = "updatePermission"  ;
	public static final String EXECUTION_PERMISSION_PROPERTY  = "executionPermission";
	public static final String APP_PROPERTY                   = "app"               ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ListAccess";
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
	protected		String              	mInternalName       ;
	protected		boolean             	mReadPermission     ;
	protected		boolean             	mCreatePermission   ;
	protected		boolean             	mDeletePermission   ;
	protected		boolean             	mUpdatePermission   ;
	protected		boolean             	mExecutionPermission;
	protected		UserApp             	mApp                ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ListAccess(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setApp( null );

		this.changed = true;
	}
	
	public 	ListAccess(String name, String internalName, boolean readPermission, boolean createPermission, boolean deletePermission, boolean updatePermission, boolean executionPermission, UserApp app)
	{
		setName(name);
		setInternalName(internalName);
		setReadPermission(readPermission);
		setCreatePermission(createPermission);
		setDeletePermission(deletePermission);
		setUpdatePermission(updatePermission);
		setExecutionPermission(executionPermission);
		setApp(app);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTERNAL_NAME_PROPERTY.equals(property)){
			changeInternalNameProperty(newValueExpr);
		}
		if(READ_PERMISSION_PROPERTY.equals(property)){
			changeReadPermissionProperty(newValueExpr);
		}
		if(CREATE_PERMISSION_PROPERTY.equals(property)){
			changeCreatePermissionProperty(newValueExpr);
		}
		if(DELETE_PERMISSION_PROPERTY.equals(property)){
			changeDeletePermissionProperty(newValueExpr);
		}
		if(UPDATE_PERMISSION_PROPERTY.equals(property)){
			changeUpdatePermissionProperty(newValueExpr);
		}
		if(EXECUTION_PERMISSION_PROPERTY.equals(property)){
			changeExecutionPermissionProperty(newValueExpr);
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
			
			
			
	protected void changeInternalNameProperty(String newValueExpr){
		String oldValue = getInternalName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateInternalName(newValue);
		this.onChangeProperty(INTERNAL_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeReadPermissionProperty(String newValueExpr){
		boolean oldValue = getReadPermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateReadPermission(newValue);
		this.onChangeProperty(READ_PERMISSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCreatePermissionProperty(String newValueExpr){
		boolean oldValue = getCreatePermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreatePermission(newValue);
		this.onChangeProperty(CREATE_PERMISSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDeletePermissionProperty(String newValueExpr){
		boolean oldValue = getDeletePermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDeletePermission(newValue);
		this.onChangeProperty(DELETE_PERMISSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeUpdatePermissionProperty(String newValueExpr){
		boolean oldValue = getUpdatePermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUpdatePermission(newValue);
		this.onChangeProperty(UPDATE_PERMISSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeExecutionPermissionProperty(String newValueExpr){
		boolean oldValue = getExecutionPermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateExecutionPermission(newValue);
		this.onChangeProperty(EXECUTION_PERMISSION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ListAccess updateId(String id){
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
	public ListAccess updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setInternalName(String internalName){
		this.mInternalName = trimString(internalName);;
	}
	public String getInternalName(){
		return this.mInternalName;
	}
	public ListAccess updateInternalName(String internalName){
		this.mInternalName = trimString(internalName);;
		this.changed = true;
		return this;
	}
	
	
	public void setReadPermission(boolean readPermission){
		this.mReadPermission = readPermission;;
	}
	public boolean getReadPermission(){
		return this.mReadPermission;
	}
	public ListAccess updateReadPermission(boolean readPermission){
		this.mReadPermission = readPermission;;
		this.changed = true;
		return this;
	}
	
	
	public void setCreatePermission(boolean createPermission){
		this.mCreatePermission = createPermission;;
	}
	public boolean getCreatePermission(){
		return this.mCreatePermission;
	}
	public ListAccess updateCreatePermission(boolean createPermission){
		this.mCreatePermission = createPermission;;
		this.changed = true;
		return this;
	}
	
	
	public void setDeletePermission(boolean deletePermission){
		this.mDeletePermission = deletePermission;;
	}
	public boolean getDeletePermission(){
		return this.mDeletePermission;
	}
	public ListAccess updateDeletePermission(boolean deletePermission){
		this.mDeletePermission = deletePermission;;
		this.changed = true;
		return this;
	}
	
	
	public void setUpdatePermission(boolean updatePermission){
		this.mUpdatePermission = updatePermission;;
	}
	public boolean getUpdatePermission(){
		return this.mUpdatePermission;
	}
	public ListAccess updateUpdatePermission(boolean updatePermission){
		this.mUpdatePermission = updatePermission;;
		this.changed = true;
		return this;
	}
	
	
	public void setExecutionPermission(boolean executionPermission){
		this.mExecutionPermission = executionPermission;;
	}
	public boolean getExecutionPermission(){
		return this.mExecutionPermission;
	}
	public ListAccess updateExecutionPermission(boolean executionPermission){
		this.mExecutionPermission = executionPermission;;
		this.changed = true;
		return this;
	}
	
	
	public void setApp(UserApp app){
		this.mApp = app;;
	}
	public UserApp getApp(){
		return this.mApp;
	}
	public ListAccess updateApp(UserApp app){
		this.mApp = app;;
		this.changed = true;
		return this;
	}
	
	
	public void clearApp(){
		setApp ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ListAccess updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getApp(), internalType);

		
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
		appendKeyValuePair(result, INTERNAL_NAME_PROPERTY, getInternalName());
		appendKeyValuePair(result, READ_PERMISSION_PROPERTY, getReadPermission());
		appendKeyValuePair(result, CREATE_PERMISSION_PROPERTY, getCreatePermission());
		appendKeyValuePair(result, DELETE_PERMISSION_PROPERTY, getDeletePermission());
		appendKeyValuePair(result, UPDATE_PERMISSION_PROPERTY, getUpdatePermission());
		appendKeyValuePair(result, EXECUTION_PERMISSION_PROPERTY, getExecutionPermission());
		appendKeyValuePair(result, APP_PROPERTY, getApp());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ListAccess){
		
		
			ListAccess dest =(ListAccess)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setInternalName(getInternalName());
			dest.setReadPermission(getReadPermission());
			dest.setCreatePermission(getCreatePermission());
			dest.setDeletePermission(getDeletePermission());
			dest.setUpdatePermission(getUpdatePermission());
			dest.setExecutionPermission(getExecutionPermission());
			dest.setApp(getApp());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ListAccess{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tinternalName='"+getInternalName()+"';");
		stringBuilder.append("\treadPermission='"+getReadPermission()+"';");
		stringBuilder.append("\tcreatePermission='"+getCreatePermission()+"';");
		stringBuilder.append("\tdeletePermission='"+getDeletePermission()+"';");
		stringBuilder.append("\tupdatePermission='"+getUpdatePermission()+"';");
		stringBuilder.append("\texecutionPermission='"+getExecutionPermission()+"';");
		if(getApp() != null ){
 			stringBuilder.append("\tapp='UserApp("+getApp().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


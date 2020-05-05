
package com.doublechaintech.retailscm.listaccess;

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
		// lazy load for all the properties
	}
	public 	static ListAccess withId(String id){
		ListAccess listAccess = new ListAccess();
		listAccess.setId(id);
		listAccess.setVersion(Integer.MAX_VALUE);
		return listAccess;
	}
	public 	static ListAccess refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setApp( null );

		this.changed = true;
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(INTERNAL_NAME_PROPERTY.equals(property)){
			return getInternalName();
		}
		if(READ_PERMISSION_PROPERTY.equals(property)){
			return getReadPermission();
		}
		if(CREATE_PERMISSION_PROPERTY.equals(property)){
			return getCreatePermission();
		}
		if(DELETE_PERMISSION_PROPERTY.equals(property)){
			return getDeletePermission();
		}
		if(UPDATE_PERMISSION_PROPERTY.equals(property)){
			return getUpdatePermission();
		}
		if(EXECUTION_PERMISSION_PROPERTY.equals(property)){
			return getExecutionPermission();
		}
		if(APP_PROPERTY.equals(property)){
			return getApp();
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
	public ListAccess updateId(String id){
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
	public ListAccess updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
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
	public void mergeInternalName(String internalName){
		if(internalName != null) { setInternalName(internalName);}
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
	public void mergeReadPermission(boolean readPermission){
		setReadPermission(readPermission);
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
	public void mergeCreatePermission(boolean createPermission){
		setCreatePermission(createPermission);
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
	public void mergeDeletePermission(boolean deletePermission){
		setDeletePermission(deletePermission);
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
	public void mergeUpdatePermission(boolean updatePermission){
		setUpdatePermission(updatePermission);
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
	public void mergeExecutionPermission(boolean executionPermission){
		setExecutionPermission(executionPermission);
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
	public void mergeApp(UserApp app){
		if(app != null) { setApp(app);}
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
	public void mergeVersion(int version){
		setVersion(version);
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

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
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
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ListAccess){
		
			
			ListAccess dest =(ListAccess)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeInternalName(getInternalName());
			dest.mergeReadPermission(getReadPermission());
			dest.mergeCreatePermission(getCreatePermission());
			dest.mergeDeletePermission(getDeletePermission());
			dest.mergeUpdatePermission(getUpdatePermission());
			dest.mergeExecutionPermission(getExecutionPermission());
			dest.mergeApp(getApp());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ListAccess){
		
			
			ListAccess dest =(ListAccess)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeInternalName(getInternalName());
			dest.mergeReadPermission(getReadPermission());
			dest.mergeCreatePermission(getCreatePermission());
			dest.mergeDeletePermission(getDeletePermission());
			dest.mergeUpdatePermission(getUpdatePermission());
			dest.mergeExecutionPermission(getExecutionPermission());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getInternalName(), getReadPermission(), getCreatePermission(), getDeletePermission(), getUpdatePermission(), getExecutionPermission(), getApp(), getVersion()};
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


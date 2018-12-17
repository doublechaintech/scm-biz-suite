package com.doublechaintech.retailscm;

import java.util.List;

public class AccessInfo extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	

	
	
	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mInternalName       ;
	protected		boolean             	mReadPermission     ;
	protected		boolean             	mCreatePermission   ;
	protected		boolean             	mDeletePermission   ;
	protected		boolean             	mUpdatePermission   ;
	protected		boolean             	mExecutionPermission;
	
	protected		int                 	mVersion            ;
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	
	
	
	public void setInternalName(String internalName){
		this.mInternalName = trimString(internalName);;
	}
	public String getInternalName(){
		return this.mInternalName;
	}
	
	
	
	public void setReadPermission(boolean readPermission){
		this.mReadPermission = readPermission;;
	}
	public boolean getReadPermission(){
		return this.mReadPermission;
	}
	
	
	
	public void setCreatePermission(boolean createPermission){
		this.mCreatePermission = createPermission;;
	}
	public boolean getCreatePermission(){
		return this.mCreatePermission;
	}
	
	
	
	public void setDeletePermission(boolean deletePermission){
		this.mDeletePermission = deletePermission;;
	}
	public boolean getDeletePermission(){
		return this.mDeletePermission;
	}
	
	
	
	public void setUpdatePermission(boolean updatePermission){
		this.mUpdatePermission = updatePermission;;
	}
	public boolean getUpdatePermission(){
		return this.mUpdatePermission;
	}
	
	
	
	public void setExecutionPermission(boolean executionPermission){
		this.mExecutionPermission = executionPermission;;
	}
	public boolean getExecutionPermission(){
		return this.mExecutionPermission;
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
		
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}

	
	
}



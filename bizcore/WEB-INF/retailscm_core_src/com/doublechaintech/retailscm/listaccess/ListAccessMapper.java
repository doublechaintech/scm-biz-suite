
package com.doublechaintech.retailscm.listaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userapp.UserApp;

public class ListAccessMapper extends BaseRowMapper<ListAccess>{
	
	protected ListAccess internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ListAccess listAccess = getListAccess();		
		 		
 		setId(listAccess, rs, rowNumber); 		
 		setName(listAccess, rs, rowNumber); 		
 		setInternalName(listAccess, rs, rowNumber); 		
 		setReadPermission(listAccess, rs, rowNumber); 		
 		setCreatePermission(listAccess, rs, rowNumber); 		
 		setDeletePermission(listAccess, rs, rowNumber); 		
 		setUpdatePermission(listAccess, rs, rowNumber); 		
 		setExecutionPermission(listAccess, rs, rowNumber); 		
 		setApp(listAccess, rs, rowNumber); 		
 		setVersion(listAccess, rs, rowNumber);

		return listAccess;
	}
	
	protected ListAccess getListAccess(){
		return new ListAccess();
	}		
		
	protected void setId(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ListAccessTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setId(id);
	}
		
	protected void setName(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ListAccessTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setName(name);
	}
		
	protected void setInternalName(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String internalName = rs.getString(ListAccessTable.COLUMN_INTERNAL_NAME);
		
		if(internalName == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setInternalName(internalName);
	}
		
	protected void setReadPermission(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean readPermission = rs.getBoolean(ListAccessTable.COLUMN_READ_PERMISSION);
		
		if(readPermission == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setReadPermission(readPermission);
	}
		
	protected void setCreatePermission(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean createPermission = rs.getBoolean(ListAccessTable.COLUMN_CREATE_PERMISSION);
		
		if(createPermission == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setCreatePermission(createPermission);
	}
		
	protected void setDeletePermission(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean deletePermission = rs.getBoolean(ListAccessTable.COLUMN_DELETE_PERMISSION);
		
		if(deletePermission == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setDeletePermission(deletePermission);
	}
		
	protected void setUpdatePermission(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean updatePermission = rs.getBoolean(ListAccessTable.COLUMN_UPDATE_PERMISSION);
		
		if(updatePermission == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setUpdatePermission(updatePermission);
	}
		
	protected void setExecutionPermission(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean executionPermission = rs.getBoolean(ListAccessTable.COLUMN_EXECUTION_PERMISSION);
		
		if(executionPermission == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setExecutionPermission(executionPermission);
	}
		 		
 	protected void setApp(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
 		String userAppId = rs.getString(ListAccessTable.COLUMN_APP);
 		if( userAppId == null){
 			return;
 		}
 		if( userAppId.isEmpty()){
 			return;
 		}
 		UserApp userApp = listAccess.getApp();
 		if( userApp != null ){
 			//if the root object 'listAccess' already have the property, just set the id for it;
 			userApp.setId(userAppId);
 			
 			return;
 		}
 		listAccess.setApp(createEmptyApp(userAppId));
 	}
 	
	protected void setVersion(ListAccess listAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ListAccessTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		listAccess.setVersion(version);
	}
		
		

 	protected UserApp  createEmptyApp(String userAppId){
 		UserApp userApp = new UserApp();
 		userApp.setId(userAppId);
 		userApp.setVersion(Integer.MAX_VALUE);
 		return userApp;
 	}
 	
}



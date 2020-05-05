
package com.doublechaintech.retailscm.userapp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class UserAppMapper extends BaseRowMapper<UserApp>{
	
	protected UserApp internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserApp userApp = getUserApp();		
		 		
 		setId(userApp, rs, rowNumber); 		
 		setTitle(userApp, rs, rowNumber); 		
 		setSecUser(userApp, rs, rowNumber); 		
 		setAppIcon(userApp, rs, rowNumber); 		
 		setFullAccess(userApp, rs, rowNumber); 		
 		setPermission(userApp, rs, rowNumber); 		
 		setObjectType(userApp, rs, rowNumber); 		
 		setObjectId(userApp, rs, rowNumber); 		
 		setLocation(userApp, rs, rowNumber); 		
 		setVersion(userApp, rs, rowNumber);

		return userApp;
	}
	
	protected UserApp getUserApp(){
		return new UserApp();
	}		
		
	protected void setId(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(UserAppTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setId(id);
	}
		
	protected void setTitle(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(UserAppTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setTitle(title);
	}
		 		
 	protected void setSecUser(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(UserAppTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = userApp.getSecUser();
 		if( secUser != null ){
 			//if the root object 'userApp' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		userApp.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setAppIcon(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String appIcon = rs.getString(UserAppTable.COLUMN_APP_ICON);
		
		if(appIcon == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setAppIcon(appIcon);
	}
		
	protected void setFullAccess(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean fullAccess = rs.getBoolean(UserAppTable.COLUMN_FULL_ACCESS);
		
		if(fullAccess == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setFullAccess(fullAccess);
	}
		
	protected void setPermission(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String permission = rs.getString(UserAppTable.COLUMN_PERMISSION);
		
		if(permission == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setPermission(permission);
	}
		
	protected void setObjectType(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String objectType = rs.getString(UserAppTable.COLUMN_OBJECT_TYPE);
		
		if(objectType == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setObjectType(objectType);
	}
		
	protected void setObjectId(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String objectId = rs.getString(UserAppTable.COLUMN_OBJECT_ID);
		
		if(objectId == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setObjectId(objectId);
	}
		
	protected void setLocation(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(UserAppTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setLocation(location);
	}
		
	protected void setVersion(UserApp userApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(UserAppTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userApp.setVersion(version);
	}
		
		

 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}



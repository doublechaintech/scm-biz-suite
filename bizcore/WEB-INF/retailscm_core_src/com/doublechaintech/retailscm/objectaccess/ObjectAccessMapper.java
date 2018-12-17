
package com.doublechaintech.retailscm.objectaccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userapp.UserApp;

public class ObjectAccessMapper extends BaseRowMapper<ObjectAccess>{
	
	protected ObjectAccess internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ObjectAccess objectAccess = getObjectAccess();		
		 		
 		setId(objectAccess, rs, rowNumber); 		
 		setName(objectAccess, rs, rowNumber); 		
 		setObjectType(objectAccess, rs, rowNumber); 		
 		setList1(objectAccess, rs, rowNumber); 		
 		setList2(objectAccess, rs, rowNumber); 		
 		setList3(objectAccess, rs, rowNumber); 		
 		setList4(objectAccess, rs, rowNumber); 		
 		setList5(objectAccess, rs, rowNumber); 		
 		setList6(objectAccess, rs, rowNumber); 		
 		setList7(objectAccess, rs, rowNumber); 		
 		setList8(objectAccess, rs, rowNumber); 		
 		setList9(objectAccess, rs, rowNumber); 		
 		setApp(objectAccess, rs, rowNumber); 		
 		setVersion(objectAccess, rs, rowNumber);

		return objectAccess;
	}
	
	protected ObjectAccess getObjectAccess(){
		return new ObjectAccess();
	}		
		
	protected void setId(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ObjectAccessTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setId(id);
	}
		
	protected void setName(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ObjectAccessTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setName(name);
	}
		
	protected void setObjectType(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String objectType = rs.getString(ObjectAccessTable.COLUMN_OBJECT_TYPE);
		if(objectType == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setObjectType(objectType);
	}
		
	protected void setList1(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list1 = rs.getString(ObjectAccessTable.COLUMN_LIST1);
		if(list1 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList1(list1);
	}
		
	protected void setList2(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list2 = rs.getString(ObjectAccessTable.COLUMN_LIST2);
		if(list2 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList2(list2);
	}
		
	protected void setList3(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list3 = rs.getString(ObjectAccessTable.COLUMN_LIST3);
		if(list3 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList3(list3);
	}
		
	protected void setList4(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list4 = rs.getString(ObjectAccessTable.COLUMN_LIST4);
		if(list4 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList4(list4);
	}
		
	protected void setList5(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list5 = rs.getString(ObjectAccessTable.COLUMN_LIST5);
		if(list5 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList5(list5);
	}
		
	protected void setList6(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list6 = rs.getString(ObjectAccessTable.COLUMN_LIST6);
		if(list6 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList6(list6);
	}
		
	protected void setList7(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list7 = rs.getString(ObjectAccessTable.COLUMN_LIST7);
		if(list7 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList7(list7);
	}
		
	protected void setList8(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list8 = rs.getString(ObjectAccessTable.COLUMN_LIST8);
		if(list8 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList8(list8);
	}
		
	protected void setList9(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String list9 = rs.getString(ObjectAccessTable.COLUMN_LIST9);
		if(list9 == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setList9(list9);
	}
		 		
 	protected void setApp(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
 		String userAppId = rs.getString(ObjectAccessTable.COLUMN_APP);
 		if( userAppId == null){
 			return;
 		}
 		if( userAppId.isEmpty()){
 			return;
 		}
 		UserApp userApp = objectAccess.getApp();
 		if( userApp != null ){
 			//if the root object 'objectAccess' already have the property, just set the id for it;
 			userApp.setId(userAppId);
 			
 			return;
 		}
 		objectAccess.setApp(createEmptyApp(userAppId));
 	}
 	
	protected void setVersion(ObjectAccess objectAccess, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ObjectAccessTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		objectAccess.setVersion(version);
	}
		
		

 	protected UserApp  createEmptyApp(String userAppId){
 		UserApp userApp = new UserApp();
 		userApp.setId(userAppId);
 		userApp.setVersion(Integer.MAX_VALUE);
 		return userApp;
 	}
 	
}



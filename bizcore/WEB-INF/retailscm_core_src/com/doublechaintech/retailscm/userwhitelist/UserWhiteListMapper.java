
package com.doublechaintech.retailscm.userwhitelist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userdomain.UserDomain;

public class UserWhiteListMapper extends BaseRowMapper<UserWhiteList>{
	
	protected UserWhiteList internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserWhiteList userWhiteList = getUserWhiteList();		
		 		
 		setId(userWhiteList, rs, rowNumber); 		
 		setUserIdentity(userWhiteList, rs, rowNumber); 		
 		setUserSpecialFunctions(userWhiteList, rs, rowNumber); 		
 		setDomain(userWhiteList, rs, rowNumber); 		
 		setVersion(userWhiteList, rs, rowNumber);

		return userWhiteList;
	}
	
	protected UserWhiteList getUserWhiteList(){
		return new UserWhiteList();
	}		
		
	protected void setId(UserWhiteList userWhiteList, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(UserWhiteListTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userWhiteList.setId(id);
	}
		
	protected void setUserIdentity(UserWhiteList userWhiteList, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String userIdentity = rs.getString(UserWhiteListTable.COLUMN_USER_IDENTITY);
		
		if(userIdentity == null){
			//do nothing when nothing found in database
			return;
		}
		
		userWhiteList.setUserIdentity(userIdentity);
	}
		
	protected void setUserSpecialFunctions(UserWhiteList userWhiteList, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String userSpecialFunctions = rs.getString(UserWhiteListTable.COLUMN_USER_SPECIAL_FUNCTIONS);
		
		if(userSpecialFunctions == null){
			//do nothing when nothing found in database
			return;
		}
		
		userWhiteList.setUserSpecialFunctions(userSpecialFunctions);
	}
		 		
 	protected void setDomain(UserWhiteList userWhiteList, ResultSet rs, int rowNumber) throws SQLException{
 		String userDomainId = rs.getString(UserWhiteListTable.COLUMN_DOMAIN);
 		if( userDomainId == null){
 			return;
 		}
 		if( userDomainId.isEmpty()){
 			return;
 		}
 		UserDomain userDomain = userWhiteList.getDomain();
 		if( userDomain != null ){
 			//if the root object 'userWhiteList' already have the property, just set the id for it;
 			userDomain.setId(userDomainId);
 			
 			return;
 		}
 		userWhiteList.setDomain(createEmptyDomain(userDomainId));
 	}
 	
	protected void setVersion(UserWhiteList userWhiteList, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(UserWhiteListTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userWhiteList.setVersion(version);
	}
		
		

 	protected UserDomain  createEmptyDomain(String userDomainId){
 		UserDomain userDomain = new UserDomain();
 		userDomain.setId(userDomainId);
 		userDomain.setVersion(Integer.MAX_VALUE);
 		return userDomain;
 	}
 	
}



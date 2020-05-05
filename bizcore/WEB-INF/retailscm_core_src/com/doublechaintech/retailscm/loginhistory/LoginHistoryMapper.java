
package com.doublechaintech.retailscm.loginhistory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class LoginHistoryMapper extends BaseRowMapper<LoginHistory>{
	
	protected LoginHistory internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LoginHistory loginHistory = getLoginHistory();		
		 		
 		setId(loginHistory, rs, rowNumber); 		
 		setLoginTime(loginHistory, rs, rowNumber); 		
 		setFromIp(loginHistory, rs, rowNumber); 		
 		setDescription(loginHistory, rs, rowNumber); 		
 		setSecUser(loginHistory, rs, rowNumber); 		
 		setVersion(loginHistory, rs, rowNumber);

		return loginHistory;
	}
	
	protected LoginHistory getLoginHistory(){
		return new LoginHistory();
	}		
		
	protected void setId(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LoginHistoryTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		loginHistory.setId(id);
	}
		
	protected void setLoginTime(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date loginTime = rs.getTimestamp(LoginHistoryTable.COLUMN_LOGIN_TIME);
		
		if(loginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		loginHistory.setLoginTime(convertToDateTime(loginTime));
	}
		
	protected void setFromIp(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String fromIp = rs.getString(LoginHistoryTable.COLUMN_FROM_IP);
		
		if(fromIp == null){
			//do nothing when nothing found in database
			return;
		}
		
		loginHistory.setFromIp(fromIp);
	}
		
	protected void setDescription(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(LoginHistoryTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		loginHistory.setDescription(description);
	}
		 		
 	protected void setSecUser(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(LoginHistoryTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = loginHistory.getSecUser();
 		if( secUser != null ){
 			//if the root object 'loginHistory' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		loginHistory.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setVersion(LoginHistory loginHistory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LoginHistoryTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		loginHistory.setVersion(version);
	}
		
		

 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}



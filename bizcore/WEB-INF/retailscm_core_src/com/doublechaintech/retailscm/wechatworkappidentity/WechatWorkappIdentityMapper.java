
package com.doublechaintech.retailscm.wechatworkappidentity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class WechatWorkappIdentityMapper extends BaseRowMapper<WechatWorkappIdentity>{
	
	protected WechatWorkappIdentity internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WechatWorkappIdentity wechatWorkappIdentity = getWechatWorkappIdentity();		
		 		
 		setId(wechatWorkappIdentity, rs, rowNumber); 		
 		setCorpId(wechatWorkappIdentity, rs, rowNumber); 		
 		setUserId(wechatWorkappIdentity, rs, rowNumber); 		
 		setSecUser(wechatWorkappIdentity, rs, rowNumber); 		
 		setCreateTime(wechatWorkappIdentity, rs, rowNumber); 		
 		setLastLoginTime(wechatWorkappIdentity, rs, rowNumber); 		
 		setVersion(wechatWorkappIdentity, rs, rowNumber);

		return wechatWorkappIdentity;
	}
	
	protected WechatWorkappIdentity getWechatWorkappIdentity(){
		return new WechatWorkappIdentity();
	}		
		
	protected void setId(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(WechatWorkappIdentityTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentity.setId(id);
	}
		
	protected void setCorpId(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String corpId = rs.getString(WechatWorkappIdentityTable.COLUMN_CORP_ID);
		
		if(corpId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentity.setCorpId(corpId);
	}
		
	protected void setUserId(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String userId = rs.getString(WechatWorkappIdentityTable.COLUMN_USER_ID);
		
		if(userId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentity.setUserId(userId);
	}
		 		
 	protected void setSecUser(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(WechatWorkappIdentityTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = wechatWorkappIdentity.getSecUser();
 		if( secUser != null ){
 			//if the root object 'wechatWorkappIdentity' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		wechatWorkappIdentity.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(WechatWorkappIdentityTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentity.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setLastLoginTime(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastLoginTime = rs.getTimestamp(WechatWorkappIdentityTable.COLUMN_LAST_LOGIN_TIME);
		
		if(lastLoginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentity.setLastLoginTime(convertToDateTime(lastLoginTime));
	}
		
	protected void setVersion(WechatWorkappIdentity wechatWorkappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(WechatWorkappIdentityTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentity.setVersion(version);
	}
		
		

 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}




package com.doublechaintech.retailscm.wechatminiappidentity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class WechatMiniappIdentityMapper extends BaseRowMapper<WechatMiniappIdentity>{
	
	protected WechatMiniappIdentity internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WechatMiniappIdentity wechatMiniappIdentity = getWechatMiniappIdentity();		
		 		
 		setId(wechatMiniappIdentity, rs, rowNumber); 		
 		setOpenId(wechatMiniappIdentity, rs, rowNumber); 		
 		setAppId(wechatMiniappIdentity, rs, rowNumber); 		
 		setSecUser(wechatMiniappIdentity, rs, rowNumber); 		
 		setCreateTime(wechatMiniappIdentity, rs, rowNumber); 		
 		setLastLoginTime(wechatMiniappIdentity, rs, rowNumber); 		
 		setVersion(wechatMiniappIdentity, rs, rowNumber);

		return wechatMiniappIdentity;
	}
	
	protected WechatMiniappIdentity getWechatMiniappIdentity(){
		return new WechatMiniappIdentity();
	}		
		
	protected void setId(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(WechatMiniappIdentityTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentity.setId(id);
	}
		
	protected void setOpenId(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String openId = rs.getString(WechatMiniappIdentityTable.COLUMN_OPEN_ID);
		
		if(openId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentity.setOpenId(openId);
	}
		
	protected void setAppId(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String appId = rs.getString(WechatMiniappIdentityTable.COLUMN_APP_ID);
		
		if(appId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentity.setAppId(appId);
	}
		 		
 	protected void setSecUser(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(WechatMiniappIdentityTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = wechatMiniappIdentity.getSecUser();
 		if( secUser != null ){
 			//if the root object 'wechatMiniappIdentity' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		wechatMiniappIdentity.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(WechatMiniappIdentityTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentity.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setLastLoginTime(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastLoginTime = rs.getTimestamp(WechatMiniappIdentityTable.COLUMN_LAST_LOGIN_TIME);
		
		if(lastLoginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentity.setLastLoginTime(convertToDateTime(lastLoginTime));
	}
		
	protected void setVersion(WechatMiniappIdentity wechatMiniappIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(WechatMiniappIdentityTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentity.setVersion(version);
	}
		
		

 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}



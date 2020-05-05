
package com.doublechaintech.retailscm.wechatminiappidentify;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class WechatMiniappIdentifyMapper extends BaseRowMapper<WechatMiniappIdentify>{
	
	protected WechatMiniappIdentify internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WechatMiniappIdentify wechatMiniappIdentify = getWechatMiniappIdentify();		
		 		
 		setId(wechatMiniappIdentify, rs, rowNumber); 		
 		setOpenId(wechatMiniappIdentify, rs, rowNumber); 		
 		setAppId(wechatMiniappIdentify, rs, rowNumber); 		
 		setSecUser(wechatMiniappIdentify, rs, rowNumber); 		
 		setCreateTime(wechatMiniappIdentify, rs, rowNumber); 		
 		setLastLoginTime(wechatMiniappIdentify, rs, rowNumber); 		
 		setVersion(wechatMiniappIdentify, rs, rowNumber);

		return wechatMiniappIdentify;
	}
	
	protected WechatMiniappIdentify getWechatMiniappIdentify(){
		return new WechatMiniappIdentify();
	}		
		
	protected void setId(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(WechatMiniappIdentifyTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentify.setId(id);
	}
		
	protected void setOpenId(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String openId = rs.getString(WechatMiniappIdentifyTable.COLUMN_OPEN_ID);
		
		if(openId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentify.setOpenId(openId);
	}
		
	protected void setAppId(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String appId = rs.getString(WechatMiniappIdentifyTable.COLUMN_APP_ID);
		
		if(appId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentify.setAppId(appId);
	}
		 		
 	protected void setSecUser(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(WechatMiniappIdentifyTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = wechatMiniappIdentify.getSecUser();
 		if( secUser != null ){
 			//if the root object 'wechatMiniappIdentify' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		wechatMiniappIdentify.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(WechatMiniappIdentifyTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentify.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setLastLoginTime(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastLoginTime = rs.getTimestamp(WechatMiniappIdentifyTable.COLUMN_LAST_LOGIN_TIME);
		
		if(lastLoginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentify.setLastLoginTime(convertToDateTime(lastLoginTime));
	}
		
	protected void setVersion(WechatMiniappIdentify wechatMiniappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(WechatMiniappIdentifyTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatMiniappIdentify.setVersion(version);
	}
		
		

 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}



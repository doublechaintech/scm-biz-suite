
package com.doublechaintech.retailscm.wechatworkappidentify;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;

public class WechatWorkappIdentifyMapper extends BaseRowMapper<WechatWorkappIdentify>{
	
	protected WechatWorkappIdentify internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WechatWorkappIdentify wechatWorkappIdentify = getWechatWorkappIdentify();		
		 		
 		setId(wechatWorkappIdentify, rs, rowNumber); 		
 		setCorpId(wechatWorkappIdentify, rs, rowNumber); 		
 		setUserId(wechatWorkappIdentify, rs, rowNumber); 		
 		setSecUser(wechatWorkappIdentify, rs, rowNumber); 		
 		setCreateTime(wechatWorkappIdentify, rs, rowNumber); 		
 		setLastLoginTime(wechatWorkappIdentify, rs, rowNumber); 		
 		setVersion(wechatWorkappIdentify, rs, rowNumber);

		return wechatWorkappIdentify;
	}
	
	protected WechatWorkappIdentify getWechatWorkappIdentify(){
		return new WechatWorkappIdentify();
	}		
		
	protected void setId(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(WechatWorkappIdentifyTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentify.setId(id);
	}
		
	protected void setCorpId(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String corpId = rs.getString(WechatWorkappIdentifyTable.COLUMN_CORP_ID);
		
		if(corpId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentify.setCorpId(corpId);
	}
		
	protected void setUserId(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String userId = rs.getString(WechatWorkappIdentifyTable.COLUMN_USER_ID);
		
		if(userId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentify.setUserId(userId);
	}
		 		
 	protected void setSecUser(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(WechatWorkappIdentifyTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = wechatWorkappIdentify.getSecUser();
 		if( secUser != null ){
 			//if the root object 'wechatWorkappIdentify' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		wechatWorkappIdentify.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(WechatWorkappIdentifyTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentify.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setLastLoginTime(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastLoginTime = rs.getTimestamp(WechatWorkappIdentifyTable.COLUMN_LAST_LOGIN_TIME);
		
		if(lastLoginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentify.setLastLoginTime(convertToDateTime(lastLoginTime));
	}
		
	protected void setVersion(WechatWorkappIdentify wechatWorkappIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(WechatWorkappIdentifyTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatWorkappIdentify.setVersion(version);
	}
		
		

 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}



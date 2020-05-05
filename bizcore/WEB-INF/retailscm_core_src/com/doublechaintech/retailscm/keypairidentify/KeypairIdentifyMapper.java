
package com.doublechaintech.retailscm.keypairidentify;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

public class KeypairIdentifyMapper extends BaseRowMapper<KeypairIdentify>{
	
	protected KeypairIdentify internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		KeypairIdentify keypairIdentify = getKeypairIdentify();		
		 		
 		setId(keypairIdentify, rs, rowNumber); 		
 		setPublicKey(keypairIdentify, rs, rowNumber); 		
 		setKeyType(keypairIdentify, rs, rowNumber); 		
 		setSecUser(keypairIdentify, rs, rowNumber); 		
 		setCreateTime(keypairIdentify, rs, rowNumber); 		
 		setVersion(keypairIdentify, rs, rowNumber);

		return keypairIdentify;
	}
	
	protected KeypairIdentify getKeypairIdentify(){
		return new KeypairIdentify();
	}		
		
	protected void setId(KeypairIdentify keypairIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(KeypairIdentifyTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentify.setId(id);
	}
		
	protected void setPublicKey(KeypairIdentify keypairIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String publicKey = rs.getString(KeypairIdentifyTable.COLUMN_PUBLIC_KEY);
		
		if(publicKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentify.setPublicKey(publicKey);
	}
		 		
 	protected void setKeyType(KeypairIdentify keypairIdentify, ResultSet rs, int rowNumber) throws SQLException{
 		String publicKeyTypeId = rs.getString(KeypairIdentifyTable.COLUMN_KEY_TYPE);
 		if( publicKeyTypeId == null){
 			return;
 		}
 		if( publicKeyTypeId.isEmpty()){
 			return;
 		}
 		PublicKeyType publicKeyType = keypairIdentify.getKeyType();
 		if( publicKeyType != null ){
 			//if the root object 'keypairIdentify' already have the property, just set the id for it;
 			publicKeyType.setId(publicKeyTypeId);
 			
 			return;
 		}
 		keypairIdentify.setKeyType(createEmptyKeyType(publicKeyTypeId));
 	}
 	 		
 	protected void setSecUser(KeypairIdentify keypairIdentify, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(KeypairIdentifyTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = keypairIdentify.getSecUser();
 		if( secUser != null ){
 			//if the root object 'keypairIdentify' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		keypairIdentify.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(KeypairIdentify keypairIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(KeypairIdentifyTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentify.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setVersion(KeypairIdentify keypairIdentify, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(KeypairIdentifyTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentify.setVersion(version);
	}
		
		

 	protected PublicKeyType  createEmptyKeyType(String publicKeyTypeId){
 		PublicKeyType publicKeyType = new PublicKeyType();
 		publicKeyType.setId(publicKeyTypeId);
 		publicKeyType.setVersion(Integer.MAX_VALUE);
 		return publicKeyType;
 	}
 	
 	protected SecUser  createEmptySecUser(String secUserId){
 		SecUser secUser = new SecUser();
 		secUser.setId(secUserId);
 		secUser.setVersion(Integer.MAX_VALUE);
 		return secUser;
 	}
 	
}



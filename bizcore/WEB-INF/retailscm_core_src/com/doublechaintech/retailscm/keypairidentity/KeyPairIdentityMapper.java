
package com.doublechaintech.retailscm.keypairidentity;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

public class KeyPairIdentityMapper extends BaseRowMapper<KeyPairIdentity>{

	protected KeyPairIdentity internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		KeyPairIdentity keyPairIdentity = getKeyPairIdentity();
		
 		setId(keyPairIdentity, rs, rowNumber);
 		setPublicKey(keyPairIdentity, rs, rowNumber);
 		setKeyType(keyPairIdentity, rs, rowNumber);
 		setSecUser(keyPairIdentity, rs, rowNumber);
 		setCreateTime(keyPairIdentity, rs, rowNumber);
 		setVersion(keyPairIdentity, rs, rowNumber);

    
		return keyPairIdentity;
	}

	protected KeyPairIdentity getKeyPairIdentity(){
	  KeyPairIdentity entity = new KeyPairIdentity();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(KeyPairIdentity keyPairIdentity, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(KeyPairIdentityTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		keyPairIdentity.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setPublicKey(KeyPairIdentity keyPairIdentity, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String publicKey = rs.getString(KeyPairIdentityTable.COLUMN_PUBLIC_KEY);
		
		if(publicKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		keyPairIdentity.setPublicKey(publicKey);
		}catch (SQLException e){

    }
	}
		
 	protected void setKeyType(KeyPairIdentity keyPairIdentity, ResultSet rs, int rowNumber) throws SQLException{
 		String publicKeyTypeId;
 		try{
 		  publicKeyTypeId = rs.getString(KeyPairIdentityTable.COLUMN_KEY_TYPE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( publicKeyTypeId == null){
 			return;
 		}
 		if( publicKeyTypeId.isEmpty()){
 			return;
 		}
 		PublicKeyType publicKeyType = keyPairIdentity.getKeyType();
 		if( publicKeyType != null ){
 			//if the root object 'keyPairIdentity' already have the property, just set the id for it;
 			publicKeyType.setId(publicKeyTypeId);

 			return;
 		}
 		keyPairIdentity.setKeyType(createEmptyKeyType(publicKeyTypeId));
 	}
 	
 	protected void setSecUser(KeyPairIdentity keyPairIdentity, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId;
 		try{
 		  secUserId = rs.getString(KeyPairIdentityTable.COLUMN_SEC_USER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = keyPairIdentity.getSecUser();
 		if( secUser != null ){
 			//if the root object 'keyPairIdentity' already have the property, just set the id for it;
 			secUser.setId(secUserId);

 			return;
 		}
 		keyPairIdentity.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(KeyPairIdentity keyPairIdentity, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(KeyPairIdentityTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		keyPairIdentity.setCreateTime(convertToDateTime(createTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(KeyPairIdentity keyPairIdentity, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(KeyPairIdentityTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		keyPairIdentity.setVersion(version);
		}catch (SQLException e){

    }
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



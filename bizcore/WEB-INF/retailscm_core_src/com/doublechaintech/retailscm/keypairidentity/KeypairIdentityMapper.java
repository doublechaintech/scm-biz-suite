
package com.doublechaintech.retailscm.keypairidentity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

public class KeypairIdentityMapper extends BaseRowMapper<KeypairIdentity>{
	
	protected KeypairIdentity internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		KeypairIdentity keypairIdentity = getKeypairIdentity();		
		 		
 		setId(keypairIdentity, rs, rowNumber); 		
 		setPublicKey(keypairIdentity, rs, rowNumber); 		
 		setKeyType(keypairIdentity, rs, rowNumber); 		
 		setSecUser(keypairIdentity, rs, rowNumber); 		
 		setCreateTime(keypairIdentity, rs, rowNumber); 		
 		setVersion(keypairIdentity, rs, rowNumber);

		return keypairIdentity;
	}
	
	protected KeypairIdentity getKeypairIdentity(){
		return new KeypairIdentity();
	}		
		
	protected void setId(KeypairIdentity keypairIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(KeypairIdentityTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentity.setId(id);
	}
		
	protected void setPublicKey(KeypairIdentity keypairIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String publicKey = rs.getString(KeypairIdentityTable.COLUMN_PUBLIC_KEY);
		
		if(publicKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentity.setPublicKey(publicKey);
	}
		 		
 	protected void setKeyType(KeypairIdentity keypairIdentity, ResultSet rs, int rowNumber) throws SQLException{
 		String publicKeyTypeId = rs.getString(KeypairIdentityTable.COLUMN_KEY_TYPE);
 		if( publicKeyTypeId == null){
 			return;
 		}
 		if( publicKeyTypeId.isEmpty()){
 			return;
 		}
 		PublicKeyType publicKeyType = keypairIdentity.getKeyType();
 		if( publicKeyType != null ){
 			//if the root object 'keypairIdentity' already have the property, just set the id for it;
 			publicKeyType.setId(publicKeyTypeId);
 			
 			return;
 		}
 		keypairIdentity.setKeyType(createEmptyKeyType(publicKeyTypeId));
 	}
 	 		
 	protected void setSecUser(KeypairIdentity keypairIdentity, ResultSet rs, int rowNumber) throws SQLException{
 		String secUserId = rs.getString(KeypairIdentityTable.COLUMN_SEC_USER);
 		if( secUserId == null){
 			return;
 		}
 		if( secUserId.isEmpty()){
 			return;
 		}
 		SecUser secUser = keypairIdentity.getSecUser();
 		if( secUser != null ){
 			//if the root object 'keypairIdentity' already have the property, just set the id for it;
 			secUser.setId(secUserId);
 			
 			return;
 		}
 		keypairIdentity.setSecUser(createEmptySecUser(secUserId));
 	}
 	
	protected void setCreateTime(KeypairIdentity keypairIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date createTime = rs.getTimestamp(KeypairIdentityTable.COLUMN_CREATE_TIME);
		
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentity.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setVersion(KeypairIdentity keypairIdentity, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(KeypairIdentityTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		keypairIdentity.setVersion(version);
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



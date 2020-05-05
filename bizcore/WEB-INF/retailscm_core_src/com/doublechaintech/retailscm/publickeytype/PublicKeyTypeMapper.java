
package com.doublechaintech.retailscm.publickeytype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.userdomain.UserDomain;

public class PublicKeyTypeMapper extends BaseRowMapper<PublicKeyType>{
	
	protected PublicKeyType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PublicKeyType publicKeyType = getPublicKeyType();		
		 		
 		setId(publicKeyType, rs, rowNumber); 		
 		setName(publicKeyType, rs, rowNumber); 		
 		setCode(publicKeyType, rs, rowNumber); 		
 		setDomain(publicKeyType, rs, rowNumber); 		
 		setVersion(publicKeyType, rs, rowNumber);

		return publicKeyType;
	}
	
	protected PublicKeyType getPublicKeyType(){
		return new PublicKeyType();
	}		
		
	protected void setId(PublicKeyType publicKeyType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PublicKeyTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicKeyType.setId(id);
	}
		
	protected void setName(PublicKeyType publicKeyType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(PublicKeyTypeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicKeyType.setName(name);
	}
		
	protected void setCode(PublicKeyType publicKeyType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(PublicKeyTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicKeyType.setCode(code);
	}
		 		
 	protected void setDomain(PublicKeyType publicKeyType, ResultSet rs, int rowNumber) throws SQLException{
 		String userDomainId = rs.getString(PublicKeyTypeTable.COLUMN_DOMAIN);
 		if( userDomainId == null){
 			return;
 		}
 		if( userDomainId.isEmpty()){
 			return;
 		}
 		UserDomain userDomain = publicKeyType.getDomain();
 		if( userDomain != null ){
 			//if the root object 'publicKeyType' already have the property, just set the id for it;
 			userDomain.setId(userDomainId);
 			
 			return;
 		}
 		publicKeyType.setDomain(createEmptyDomain(userDomainId));
 	}
 	
	protected void setVersion(PublicKeyType publicKeyType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PublicKeyTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicKeyType.setVersion(version);
	}
		
		

 	protected UserDomain  createEmptyDomain(String userDomainId){
 		UserDomain userDomain = new UserDomain();
 		userDomain.setId(userDomainId);
 		userDomain.setVersion(Integer.MAX_VALUE);
 		return userDomain;
 	}
 	
}



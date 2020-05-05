
package com.doublechaintech.retailscm.userdomain;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class UserDomainMapper extends BaseRowMapper<UserDomain>{
	
	protected UserDomain internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserDomain userDomain = getUserDomain();		
		 		
 		setId(userDomain, rs, rowNumber); 		
 		setName(userDomain, rs, rowNumber); 		
 		setVersion(userDomain, rs, rowNumber);

		return userDomain;
	}
	
	protected UserDomain getUserDomain(){
		return new UserDomain();
	}		
		
	protected void setId(UserDomain userDomain, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(UserDomainTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userDomain.setId(id);
	}
		
	protected void setName(UserDomain userDomain, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(UserDomainTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		userDomain.setName(name);
	}
		
	protected void setVersion(UserDomain userDomain, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(UserDomainTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userDomain.setVersion(version);
	}
		
		

}



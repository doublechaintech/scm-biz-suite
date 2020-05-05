
package com.doublechaintech.retailscm.mobileapp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class MobileAppMapper extends BaseRowMapper<MobileApp>{
	
	protected MobileApp internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		MobileApp mobileApp = getMobileApp();		
		 		
 		setId(mobileApp, rs, rowNumber); 		
 		setName(mobileApp, rs, rowNumber); 		
 		setVersion(mobileApp, rs, rowNumber);

		return mobileApp;
	}
	
	protected MobileApp getMobileApp(){
		return new MobileApp();
	}		
		
	protected void setId(MobileApp mobileApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(MobileAppTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		mobileApp.setId(id);
	}
		
	protected void setName(MobileApp mobileApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(MobileAppTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		mobileApp.setName(name);
	}
		
	protected void setVersion(MobileApp mobileApp, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(MobileAppTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		mobileApp.setVersion(version);
	}
		
		

}



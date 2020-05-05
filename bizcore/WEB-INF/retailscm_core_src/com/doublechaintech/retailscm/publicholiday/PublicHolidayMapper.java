
package com.doublechaintech.retailscm.publicholiday;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class PublicHolidayMapper extends BaseRowMapper<PublicHoliday>{
	
	protected PublicHoliday internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PublicHoliday publicHoliday = getPublicHoliday();		
		 		
 		setId(publicHoliday, rs, rowNumber); 		
 		setCode(publicHoliday, rs, rowNumber); 		
 		setCompany(publicHoliday, rs, rowNumber); 		
 		setName(publicHoliday, rs, rowNumber); 		
 		setDescription(publicHoliday, rs, rowNumber); 		
 		setVersion(publicHoliday, rs, rowNumber);

		return publicHoliday;
	}
	
	protected PublicHoliday getPublicHoliday(){
		return new PublicHoliday();
	}		
		
	protected void setId(PublicHoliday publicHoliday, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PublicHolidayTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicHoliday.setId(id);
	}
		
	protected void setCode(PublicHoliday publicHoliday, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(PublicHolidayTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicHoliday.setCode(code);
	}
		 		
 	protected void setCompany(PublicHoliday publicHoliday, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(PublicHolidayTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = publicHoliday.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'publicHoliday' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		publicHoliday.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setName(PublicHoliday publicHoliday, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(PublicHolidayTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicHoliday.setName(name);
	}
		
	protected void setDescription(PublicHoliday publicHoliday, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(PublicHolidayTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicHoliday.setDescription(description);
	}
		
	protected void setVersion(PublicHoliday publicHoliday, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PublicHolidayTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		publicHoliday.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}



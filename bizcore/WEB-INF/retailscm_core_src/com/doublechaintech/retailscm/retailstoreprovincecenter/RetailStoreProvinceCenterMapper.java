
package com.doublechaintech.retailscm.retailstoreprovincecenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class RetailStoreProvinceCenterMapper extends BaseRowMapper<RetailStoreProvinceCenter>{
	
	protected RetailStoreProvinceCenter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreProvinceCenter retailStoreProvinceCenter = getRetailStoreProvinceCenter();		
		 		
 		setId(retailStoreProvinceCenter, rs, rowNumber); 		
 		setName(retailStoreProvinceCenter, rs, rowNumber); 		
 		setFounded(retailStoreProvinceCenter, rs, rowNumber); 		
 		setCountry(retailStoreProvinceCenter, rs, rowNumber); 		
 		setLastUpdateTime(retailStoreProvinceCenter, rs, rowNumber); 		
 		setVersion(retailStoreProvinceCenter, rs, rowNumber);

		return retailStoreProvinceCenter;
	}
	
	protected RetailStoreProvinceCenter getRetailStoreProvinceCenter(){
		return new RetailStoreProvinceCenter();
	}		
		
	protected void setId(RetailStoreProvinceCenter retailStoreProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreProvinceCenterTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreProvinceCenter.setId(id);
	}
		
	protected void setName(RetailStoreProvinceCenter retailStoreProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreProvinceCenterTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreProvinceCenter.setName(name);
	}
		
	protected void setFounded(RetailStoreProvinceCenter retailStoreProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(RetailStoreProvinceCenterTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreProvinceCenter.setFounded(founded);
	}
		 		
 	protected void setCountry(RetailStoreProvinceCenter retailStoreProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(RetailStoreProvinceCenterTable.COLUMN_COUNTRY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = retailStoreProvinceCenter.getCountry();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'retailStoreProvinceCenter' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		retailStoreProvinceCenter.setCountry(createEmptyCountry(retailStoreCountryCenterId));
 	}
 	
	protected void setLastUpdateTime(RetailStoreProvinceCenter retailStoreProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(RetailStoreProvinceCenterTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreProvinceCenter.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(RetailStoreProvinceCenter retailStoreProvinceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreProvinceCenterTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreProvinceCenter.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCountry(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}



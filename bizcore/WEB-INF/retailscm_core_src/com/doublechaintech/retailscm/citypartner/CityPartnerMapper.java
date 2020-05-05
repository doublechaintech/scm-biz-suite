
package com.doublechaintech.retailscm.citypartner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

public class CityPartnerMapper extends BaseRowMapper<CityPartner>{
	
	protected CityPartner internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CityPartner cityPartner = getCityPartner();		
		 		
 		setId(cityPartner, rs, rowNumber); 		
 		setName(cityPartner, rs, rowNumber); 		
 		setMobile(cityPartner, rs, rowNumber); 		
 		setCityServiceCenter(cityPartner, rs, rowNumber); 		
 		setDescription(cityPartner, rs, rowNumber); 		
 		setLastUpdateTime(cityPartner, rs, rowNumber); 		
 		setVersion(cityPartner, rs, rowNumber);

		return cityPartner;
	}
	
	protected CityPartner getCityPartner(){
		return new CityPartner();
	}		
		
	protected void setId(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CityPartnerTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityPartner.setId(id);
	}
		
	protected void setName(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CityPartnerTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityPartner.setName(name);
	}
		
	protected void setMobile(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(CityPartnerTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityPartner.setMobile(mobile);
	}
		 		
 	protected void setCityServiceCenter(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCityServiceCenterId = rs.getString(CityPartnerTable.COLUMN_CITY_SERVICE_CENTER);
 		if( retailStoreCityServiceCenterId == null){
 			return;
 		}
 		if( retailStoreCityServiceCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = cityPartner.getCityServiceCenter();
 		if( retailStoreCityServiceCenter != null ){
 			//if the root object 'cityPartner' already have the property, just set the id for it;
 			retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);
 			
 			return;
 		}
 		cityPartner.setCityServiceCenter(createEmptyCityServiceCenter(retailStoreCityServiceCenterId));
 	}
 	
	protected void setDescription(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(CityPartnerTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityPartner.setDescription(description);
	}
		
	protected void setLastUpdateTime(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(CityPartnerTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityPartner.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(CityPartner cityPartner, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CityPartnerTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityPartner.setVersion(version);
	}
		
		

 	protected RetailStoreCityServiceCenter  createEmptyCityServiceCenter(String retailStoreCityServiceCenterId){
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
 		retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);
 		retailStoreCityServiceCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCityServiceCenter;
 	}
 	
}



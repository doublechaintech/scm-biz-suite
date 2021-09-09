
package com.doublechaintech.retailscm.cityevent;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

public class CityEventMapper extends BaseRowMapper<CityEvent>{

	protected CityEvent internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CityEvent cityEvent = getCityEvent();
		
 		setId(cityEvent, rs, rowNumber);
 		setName(cityEvent, rs, rowNumber);
 		setMobile(cityEvent, rs, rowNumber);
 		setCityServiceCenter(cityEvent, rs, rowNumber);
 		setDescription(cityEvent, rs, rowNumber);
 		setLastUpdateTime(cityEvent, rs, rowNumber);
 		setVersion(cityEvent, rs, rowNumber);

    
		return cityEvent;
	}

	protected CityEvent getCityEvent(){
	  CityEvent entity = new CityEvent();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CityEventTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityEvent.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CityEventTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityEvent.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setMobile(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(CityEventTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityEvent.setMobile(mobile);
		}catch (SQLException e){

    }
	}
		
 	protected void setCityServiceCenter(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCityServiceCenterId;
 		try{
 		  retailStoreCityServiceCenterId = rs.getString(CityEventTable.COLUMN_CITY_SERVICE_CENTER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCityServiceCenterId == null){
 			return;
 		}
 		if( retailStoreCityServiceCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = cityEvent.getCityServiceCenter();
 		if( retailStoreCityServiceCenter != null ){
 			//if the root object 'cityEvent' already have the property, just set the id for it;
 			retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);

 			return;
 		}
 		cityEvent.setCityServiceCenter(createEmptyCityServiceCenter(retailStoreCityServiceCenterId));
 	}
 	
	protected void setDescription(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(CityEventTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityEvent.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(CityEventTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityEvent.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(CityEvent cityEvent, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CityEventTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		cityEvent.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCityServiceCenter  createEmptyCityServiceCenter(String retailStoreCityServiceCenterId){
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
 		retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);
 		retailStoreCityServiceCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCityServiceCenter;
 	}
 	
}



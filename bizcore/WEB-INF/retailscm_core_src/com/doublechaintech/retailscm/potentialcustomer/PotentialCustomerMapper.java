
package com.doublechaintech.retailscm.potentialcustomer;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

public class PotentialCustomerMapper extends BaseRowMapper<PotentialCustomer>{

	protected PotentialCustomer internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PotentialCustomer potentialCustomer = getPotentialCustomer();
		
 		setId(potentialCustomer, rs, rowNumber);
 		setName(potentialCustomer, rs, rowNumber);
 		setMobile(potentialCustomer, rs, rowNumber);
 		setCityServiceCenter(potentialCustomer, rs, rowNumber);
 		setCityPartner(potentialCustomer, rs, rowNumber);
 		setDescription(potentialCustomer, rs, rowNumber);
 		setLastUpdateTime(potentialCustomer, rs, rowNumber);
 		setVersion(potentialCustomer, rs, rowNumber);

    
		return potentialCustomer;
	}

	protected PotentialCustomer getPotentialCustomer(){
	  PotentialCustomer entity = new PotentialCustomer();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PotentialCustomerTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(PotentialCustomerTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setMobile(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(PotentialCustomerTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setMobile(mobile);
		}catch (SQLException e){

    }
	}
		
 	protected void setCityServiceCenter(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCityServiceCenterId;
 		try{
 		  retailStoreCityServiceCenterId = rs.getString(PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCityServiceCenterId == null){
 			return;
 		}
 		if( retailStoreCityServiceCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = potentialCustomer.getCityServiceCenter();
 		if( retailStoreCityServiceCenter != null ){
 			//if the root object 'potentialCustomer' already have the property, just set the id for it;
 			retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);

 			return;
 		}
 		potentialCustomer.setCityServiceCenter(createEmptyCityServiceCenter(retailStoreCityServiceCenterId));
 	}
 	
 	protected void setCityPartner(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
 		String cityPartnerId;
 		try{
 		  cityPartnerId = rs.getString(PotentialCustomerTable.COLUMN_CITY_PARTNER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( cityPartnerId == null){
 			return;
 		}
 		if( cityPartnerId.isEmpty()){
 			return;
 		}
 		CityPartner cityPartner = potentialCustomer.getCityPartner();
 		if( cityPartner != null ){
 			//if the root object 'potentialCustomer' already have the property, just set the id for it;
 			cityPartner.setId(cityPartnerId);

 			return;
 		}
 		potentialCustomer.setCityPartner(createEmptyCityPartner(cityPartnerId));
 	}
 	
	protected void setDescription(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(PotentialCustomerTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(PotentialCustomerTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PotentialCustomerTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCityServiceCenter  createEmptyCityServiceCenter(String retailStoreCityServiceCenterId){
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
 		retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);
 		retailStoreCityServiceCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCityServiceCenter;
 	}
 	
 	protected CityPartner  createEmptyCityPartner(String cityPartnerId){
 		CityPartner cityPartner = new CityPartner();
 		cityPartner.setId(cityPartnerId);
 		cityPartner.setVersion(Integer.MAX_VALUE);
 		return cityPartner;
 	}
 	
}



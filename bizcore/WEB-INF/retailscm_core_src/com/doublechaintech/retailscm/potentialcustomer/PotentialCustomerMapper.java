
package com.doublechaintech.retailscm.potentialcustomer;
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
		return new PotentialCustomer();
	}		
		
	protected void setId(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PotentialCustomerTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setId(id);
	}
		
	protected void setName(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(PotentialCustomerTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setName(name);
	}
		
	protected void setMobile(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(PotentialCustomerTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setMobile(mobile);
	}
		 		
 	protected void setCityServiceCenter(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCityServiceCenterId = rs.getString(PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER);
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
 		String cityPartnerId = rs.getString(PotentialCustomerTable.COLUMN_CITY_PARTNER);
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
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(PotentialCustomerTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setDescription(description);
	}
		
	protected void setLastUpdateTime(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(PotentialCustomerTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(PotentialCustomer potentialCustomer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PotentialCustomerTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		potentialCustomer.setVersion(version);
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



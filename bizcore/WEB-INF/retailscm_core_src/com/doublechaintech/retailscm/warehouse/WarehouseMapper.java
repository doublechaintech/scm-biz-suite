
package com.doublechaintech.retailscm.warehouse;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class WarehouseMapper extends BaseRowMapper<Warehouse>{

	protected Warehouse internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Warehouse warehouse = getWarehouse();
		
 		setId(warehouse, rs, rowNumber);
 		setLocation(warehouse, rs, rowNumber);
 		setContactNumber(warehouse, rs, rowNumber);
 		setTotalArea(warehouse, rs, rowNumber);
 		setOwner(warehouse, rs, rowNumber);
 		setLatitude(warehouse, rs, rowNumber);
 		setLongitude(warehouse, rs, rowNumber);
 		setLastUpdateTime(warehouse, rs, rowNumber);
 		setVersion(warehouse, rs, rowNumber);

    
		return warehouse;
	}

	protected Warehouse getWarehouse(){
	  Warehouse entity = new Warehouse();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(WarehouseTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setLocation(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(WarehouseTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setLocation(location);
		}catch (SQLException e){

    }
	}
		
	protected void setContactNumber(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(WarehouseTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setContactNumber(contactNumber);
		}catch (SQLException e){

    }
	}
		
	protected void setTotalArea(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String totalArea = rs.getString(WarehouseTable.COLUMN_TOTAL_AREA);
		
		if(totalArea == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setTotalArea(totalArea);
		}catch (SQLException e){

    }
	}
		
 	protected void setOwner(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(WarehouseTable.COLUMN_OWNER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = warehouse.getOwner();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'warehouse' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		warehouse.setOwner(createEmptyOwner(retailStoreCountryCenterId));
 	}
 	
	protected void setLatitude(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(WarehouseTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setLatitude(latitude);
		}catch (SQLException e){

    }
	}
		
	protected void setLongitude(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(WarehouseTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setLongitude(longitude);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(WarehouseTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(Warehouse warehouse, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(WarehouseTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouse.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyOwner(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}



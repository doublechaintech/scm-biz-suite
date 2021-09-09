
package com.doublechaintech.retailscm.smartpallet;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.warehouse.Warehouse;

public class SmartPalletMapper extends BaseRowMapper<SmartPallet>{

	protected SmartPallet internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SmartPallet smartPallet = getSmartPallet();
		
 		setId(smartPallet, rs, rowNumber);
 		setLocation(smartPallet, rs, rowNumber);
 		setContactNumber(smartPallet, rs, rowNumber);
 		setTotalArea(smartPallet, rs, rowNumber);
 		setLatitude(smartPallet, rs, rowNumber);
 		setLongitude(smartPallet, rs, rowNumber);
 		setWarehouse(smartPallet, rs, rowNumber);
 		setLastUpdateTime(smartPallet, rs, rowNumber);
 		setVersion(smartPallet, rs, rowNumber);

    
		return smartPallet;
	}

	protected SmartPallet getSmartPallet(){
	  SmartPallet entity = new SmartPallet();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SmartPalletTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setLocation(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(SmartPalletTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setLocation(location);
		}catch (SQLException e){

    }
	}
		
	protected void setContactNumber(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(SmartPalletTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setContactNumber(contactNumber);
		}catch (SQLException e){

    }
	}
		
	protected void setTotalArea(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String totalArea = rs.getString(SmartPalletTable.COLUMN_TOTAL_AREA);
		
		if(totalArea == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setTotalArea(totalArea);
		}catch (SQLException e){

    }
	}
		
	protected void setLatitude(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(SmartPalletTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setLatitude(latitude);
		}catch (SQLException e){

    }
	}
		
	protected void setLongitude(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(SmartPalletTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setLongitude(longitude);
		}catch (SQLException e){

    }
	}
		
 	protected void setWarehouse(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
 		String warehouseId;
 		try{
 		  warehouseId = rs.getString(SmartPalletTable.COLUMN_WAREHOUSE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( warehouseId == null){
 			return;
 		}
 		if( warehouseId.isEmpty()){
 			return;
 		}
 		Warehouse warehouse = smartPallet.getWarehouse();
 		if( warehouse != null ){
 			//if the root object 'smartPallet' already have the property, just set the id for it;
 			warehouse.setId(warehouseId);

 			return;
 		}
 		smartPallet.setWarehouse(createEmptyWarehouse(warehouseId));
 	}
 	
	protected void setLastUpdateTime(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(SmartPalletTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(SmartPallet smartPallet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SmartPalletTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		smartPallet.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected Warehouse  createEmptyWarehouse(String warehouseId){
 		Warehouse warehouse = new Warehouse();
 		warehouse.setId(warehouseId);
 		warehouse.setVersion(Integer.MAX_VALUE);
 		return warehouse;
 	}
 	
}



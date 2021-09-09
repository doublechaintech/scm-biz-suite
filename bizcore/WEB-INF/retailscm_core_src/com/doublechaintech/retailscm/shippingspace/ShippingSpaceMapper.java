
package com.doublechaintech.retailscm.shippingspace;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.warehouse.Warehouse;

public class ShippingSpaceMapper extends BaseRowMapper<ShippingSpace>{

	protected ShippingSpace internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ShippingSpace shippingSpace = getShippingSpace();
		
 		setId(shippingSpace, rs, rowNumber);
 		setLocation(shippingSpace, rs, rowNumber);
 		setContactNumber(shippingSpace, rs, rowNumber);
 		setTotalArea(shippingSpace, rs, rowNumber);
 		setWarehouse(shippingSpace, rs, rowNumber);
 		setLatitude(shippingSpace, rs, rowNumber);
 		setLongitude(shippingSpace, rs, rowNumber);
 		setDescription(shippingSpace, rs, rowNumber);
 		setLastUpdateTime(shippingSpace, rs, rowNumber);
 		setVersion(shippingSpace, rs, rowNumber);

    
		return shippingSpace;
	}

	protected ShippingSpace getShippingSpace(){
	  ShippingSpace entity = new ShippingSpace();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ShippingSpaceTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setLocation(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(ShippingSpaceTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setLocation(location);
		}catch (SQLException e){

    }
	}
		
	protected void setContactNumber(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(ShippingSpaceTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setContactNumber(contactNumber);
		}catch (SQLException e){

    }
	}
		
	protected void setTotalArea(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String totalArea = rs.getString(ShippingSpaceTable.COLUMN_TOTAL_AREA);
		
		if(totalArea == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setTotalArea(totalArea);
		}catch (SQLException e){

    }
	}
		
 	protected void setWarehouse(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
 		String warehouseId;
 		try{
 		  warehouseId = rs.getString(ShippingSpaceTable.COLUMN_WAREHOUSE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( warehouseId == null){
 			return;
 		}
 		if( warehouseId.isEmpty()){
 			return;
 		}
 		Warehouse warehouse = shippingSpace.getWarehouse();
 		if( warehouse != null ){
 			//if the root object 'shippingSpace' already have the property, just set the id for it;
 			warehouse.setId(warehouseId);

 			return;
 		}
 		shippingSpace.setWarehouse(createEmptyWarehouse(warehouseId));
 	}
 	
	protected void setLatitude(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(ShippingSpaceTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setLatitude(latitude);
		}catch (SQLException e){

    }
	}
		
	protected void setLongitude(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(ShippingSpaceTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setLongitude(longitude);
		}catch (SQLException e){

    }
	}
		
	protected void setDescription(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(ShippingSpaceTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(ShippingSpaceTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(ShippingSpace shippingSpace, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ShippingSpaceTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		shippingSpace.setVersion(version);
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




package com.doublechaintech.retailscm.receivingspace;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.warehouse.Warehouse;

public class ReceivingSpaceMapper extends BaseRowMapper<ReceivingSpace>{
	
	protected ReceivingSpace internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ReceivingSpace receivingSpace = getReceivingSpace();		
		 		
 		setId(receivingSpace, rs, rowNumber); 		
 		setLocation(receivingSpace, rs, rowNumber); 		
 		setContactNumber(receivingSpace, rs, rowNumber); 		
 		setDescription(receivingSpace, rs, rowNumber); 		
 		setTotalArea(receivingSpace, rs, rowNumber); 		
 		setWarehouse(receivingSpace, rs, rowNumber); 		
 		setLatitude(receivingSpace, rs, rowNumber); 		
 		setLongitude(receivingSpace, rs, rowNumber); 		
 		setLastUpdateTime(receivingSpace, rs, rowNumber); 		
 		setVersion(receivingSpace, rs, rowNumber);

		return receivingSpace;
	}
	
	protected ReceivingSpace getReceivingSpace(){
		return new ReceivingSpace();
	}		
		
	protected void setId(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ReceivingSpaceTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setId(id);
	}
		
	protected void setLocation(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(ReceivingSpaceTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setLocation(location);
	}
		
	protected void setContactNumber(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(ReceivingSpaceTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setContactNumber(contactNumber);
	}
		
	protected void setDescription(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(ReceivingSpaceTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setDescription(description);
	}
		
	protected void setTotalArea(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String totalArea = rs.getString(ReceivingSpaceTable.COLUMN_TOTAL_AREA);
		
		if(totalArea == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setTotalArea(totalArea);
	}
		 		
 	protected void setWarehouse(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
 		String warehouseId = rs.getString(ReceivingSpaceTable.COLUMN_WAREHOUSE);
 		if( warehouseId == null){
 			return;
 		}
 		if( warehouseId.isEmpty()){
 			return;
 		}
 		Warehouse warehouse = receivingSpace.getWarehouse();
 		if( warehouse != null ){
 			//if the root object 'receivingSpace' already have the property, just set the id for it;
 			warehouse.setId(warehouseId);
 			
 			return;
 		}
 		receivingSpace.setWarehouse(createEmptyWarehouse(warehouseId));
 	}
 	
	protected void setLatitude(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(ReceivingSpaceTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setLatitude(latitude);
	}
		
	protected void setLongitude(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(ReceivingSpaceTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setLongitude(longitude);
	}
		
	protected void setLastUpdateTime(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(ReceivingSpaceTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(ReceivingSpace receivingSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ReceivingSpaceTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		receivingSpace.setVersion(version);
	}
		
		

 	protected Warehouse  createEmptyWarehouse(String warehouseId){
 		Warehouse warehouse = new Warehouse();
 		warehouse.setId(warehouseId);
 		warehouse.setVersion(Integer.MAX_VALUE);
 		return warehouse;
 	}
 	
}



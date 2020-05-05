
package com.doublechaintech.retailscm.supplierspace;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.warehouse.Warehouse;

public class SupplierSpaceMapper extends BaseRowMapper<SupplierSpace>{
	
	protected SupplierSpace internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplierSpace supplierSpace = getSupplierSpace();		
		 		
 		setId(supplierSpace, rs, rowNumber); 		
 		setLocation(supplierSpace, rs, rowNumber); 		
 		setContactNumber(supplierSpace, rs, rowNumber); 		
 		setTotalArea(supplierSpace, rs, rowNumber); 		
 		setWarehouse(supplierSpace, rs, rowNumber); 		
 		setLatitude(supplierSpace, rs, rowNumber); 		
 		setLongitude(supplierSpace, rs, rowNumber); 		
 		setLastUpdateTime(supplierSpace, rs, rowNumber); 		
 		setVersion(supplierSpace, rs, rowNumber);

		return supplierSpace;
	}
	
	protected SupplierSpace getSupplierSpace(){
		return new SupplierSpace();
	}		
		
	protected void setId(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SupplierSpaceTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setId(id);
	}
		
	protected void setLocation(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(SupplierSpaceTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setLocation(location);
	}
		
	protected void setContactNumber(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(SupplierSpaceTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setContactNumber(contactNumber);
	}
		
	protected void setTotalArea(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String totalArea = rs.getString(SupplierSpaceTable.COLUMN_TOTAL_AREA);
		
		if(totalArea == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setTotalArea(totalArea);
	}
		 		
 	protected void setWarehouse(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
 		String warehouseId = rs.getString(SupplierSpaceTable.COLUMN_WAREHOUSE);
 		if( warehouseId == null){
 			return;
 		}
 		if( warehouseId.isEmpty()){
 			return;
 		}
 		Warehouse warehouse = supplierSpace.getWarehouse();
 		if( warehouse != null ){
 			//if the root object 'supplierSpace' already have the property, just set the id for it;
 			warehouse.setId(warehouseId);
 			
 			return;
 		}
 		supplierSpace.setWarehouse(createEmptyWarehouse(warehouseId));
 	}
 	
	protected void setLatitude(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(SupplierSpaceTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setLatitude(latitude);
	}
		
	protected void setLongitude(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(SupplierSpaceTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setLongitude(longitude);
	}
		
	protected void setLastUpdateTime(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(SupplierSpaceTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(SupplierSpace supplierSpace, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SupplierSpaceTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplierSpace.setVersion(version);
	}
		
		

 	protected Warehouse  createEmptyWarehouse(String warehouseId){
 		Warehouse warehouse = new Warehouse();
 		warehouse.setId(warehouseId);
 		warehouse.setVersion(Integer.MAX_VALUE);
 		return warehouse;
 	}
 	
}



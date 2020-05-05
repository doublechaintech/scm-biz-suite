
package com.doublechaintech.retailscm.warehouseasset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.warehouse.Warehouse;

public class WarehouseAssetMapper extends BaseRowMapper<WarehouseAsset>{
	
	protected WarehouseAsset internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WarehouseAsset warehouseAsset = getWarehouseAsset();		
		 		
 		setId(warehouseAsset, rs, rowNumber); 		
 		setName(warehouseAsset, rs, rowNumber); 		
 		setPosition(warehouseAsset, rs, rowNumber); 		
 		setOwner(warehouseAsset, rs, rowNumber); 		
 		setLastUpdateTime(warehouseAsset, rs, rowNumber); 		
 		setVersion(warehouseAsset, rs, rowNumber);

		return warehouseAsset;
	}
	
	protected WarehouseAsset getWarehouseAsset(){
		return new WarehouseAsset();
	}		
		
	protected void setId(WarehouseAsset warehouseAsset, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(WarehouseAssetTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouseAsset.setId(id);
	}
		
	protected void setName(WarehouseAsset warehouseAsset, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(WarehouseAssetTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouseAsset.setName(name);
	}
		
	protected void setPosition(WarehouseAsset warehouseAsset, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String position = rs.getString(WarehouseAssetTable.COLUMN_POSITION);
		
		if(position == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouseAsset.setPosition(position);
	}
		 		
 	protected void setOwner(WarehouseAsset warehouseAsset, ResultSet rs, int rowNumber) throws SQLException{
 		String warehouseId = rs.getString(WarehouseAssetTable.COLUMN_OWNER);
 		if( warehouseId == null){
 			return;
 		}
 		if( warehouseId.isEmpty()){
 			return;
 		}
 		Warehouse warehouse = warehouseAsset.getOwner();
 		if( warehouse != null ){
 			//if the root object 'warehouseAsset' already have the property, just set the id for it;
 			warehouse.setId(warehouseId);
 			
 			return;
 		}
 		warehouseAsset.setOwner(createEmptyOwner(warehouseId));
 	}
 	
	protected void setLastUpdateTime(WarehouseAsset warehouseAsset, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(WarehouseAssetTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouseAsset.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(WarehouseAsset warehouseAsset, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(WarehouseAssetTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		warehouseAsset.setVersion(version);
	}
		
		

 	protected Warehouse  createEmptyOwner(String warehouseId){
 		Warehouse warehouse = new Warehouse();
 		warehouse.setId(warehouseId);
 		warehouse.setVersion(Integer.MAX_VALUE);
 		return warehouse;
 	}
 	
}



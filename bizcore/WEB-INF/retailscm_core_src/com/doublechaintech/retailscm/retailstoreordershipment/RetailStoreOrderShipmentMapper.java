
package com.doublechaintech.retailscm.retailstoreordershipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOrderShipmentMapper extends BaseRowMapper<RetailStoreOrderShipment>{
	
	protected RetailStoreOrderShipment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderShipment retailStoreOrderShipment = getRetailStoreOrderShipment();		
		 		
 		setId(retailStoreOrderShipment, rs, rowNumber); 		
 		setWho(retailStoreOrderShipment, rs, rowNumber); 		
 		setShipTime(retailStoreOrderShipment, rs, rowNumber); 		
 		setVersion(retailStoreOrderShipment, rs, rowNumber);

		return retailStoreOrderShipment;
	}
	
	protected RetailStoreOrderShipment getRetailStoreOrderShipment(){
		return new RetailStoreOrderShipment();
	}		
		
	protected void setId(RetailStoreOrderShipment retailStoreOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderShipmentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShipment.setId(id);
	}
		
	protected void setWho(RetailStoreOrderShipment retailStoreOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(RetailStoreOrderShipmentTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShipment.setWho(who);
	}
		
	protected void setShipTime(RetailStoreOrderShipment retailStoreOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date shipTime = rs.getDate(RetailStoreOrderShipmentTable.COLUMN_SHIP_TIME);
		if(shipTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShipment.setShipTime(shipTime);
	}
		
	protected void setVersion(RetailStoreOrderShipment retailStoreOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderShipmentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShipment.setVersion(version);
	}
		
		

}




package com.doublechaintech.retailscm.supplyordershipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SupplyOrderShipmentMapper extends BaseRowMapper<SupplyOrderShipment>{
	
	protected SupplyOrderShipment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderShipment supplyOrderShipment = getSupplyOrderShipment();		
		 		
 		setId(supplyOrderShipment, rs, rowNumber); 		
 		setWho(supplyOrderShipment, rs, rowNumber); 		
 		setShipTime(supplyOrderShipment, rs, rowNumber); 		
 		setVersion(supplyOrderShipment, rs, rowNumber);

		return supplyOrderShipment;
	}
	
	protected SupplyOrderShipment getSupplyOrderShipment(){
		return new SupplyOrderShipment();
	}		
		
	protected void setId(SupplyOrderShipment supplyOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderShipmentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShipment.setId(id);
	}
		
	protected void setWho(SupplyOrderShipment supplyOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SupplyOrderShipmentTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShipment.setWho(who);
	}
		
	protected void setShipTime(SupplyOrderShipment supplyOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date shipTime = rs.getDate(SupplyOrderShipmentTable.COLUMN_SHIP_TIME);
		if(shipTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShipment.setShipTime(shipTime);
	}
		
	protected void setVersion(SupplyOrderShipment supplyOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderShipmentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShipment.setVersion(version);
	}
		
		

}



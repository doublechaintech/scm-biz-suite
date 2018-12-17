
package com.doublechaintech.retailscm.supplyorderdelivery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SupplyOrderDeliveryMapper extends BaseRowMapper<SupplyOrderDelivery>{
	
	protected SupplyOrderDelivery internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderDelivery supplyOrderDelivery = getSupplyOrderDelivery();		
		 		
 		setId(supplyOrderDelivery, rs, rowNumber); 		
 		setWho(supplyOrderDelivery, rs, rowNumber); 		
 		setDeliveryTime(supplyOrderDelivery, rs, rowNumber); 		
 		setVersion(supplyOrderDelivery, rs, rowNumber);

		return supplyOrderDelivery;
	}
	
	protected SupplyOrderDelivery getSupplyOrderDelivery(){
		return new SupplyOrderDelivery();
	}		
		
	protected void setId(SupplyOrderDelivery supplyOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderDeliveryTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderDelivery.setId(id);
	}
		
	protected void setWho(SupplyOrderDelivery supplyOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SupplyOrderDeliveryTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderDelivery.setWho(who);
	}
		
	protected void setDeliveryTime(SupplyOrderDelivery supplyOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date deliveryTime = rs.getDate(SupplyOrderDeliveryTable.COLUMN_DELIVERY_TIME);
		if(deliveryTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderDelivery.setDeliveryTime(deliveryTime);
	}
		
	protected void setVersion(SupplyOrderDelivery supplyOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderDeliveryTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderDelivery.setVersion(version);
	}
		
		

}



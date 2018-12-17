
package com.doublechaintech.retailscm.retailstoreorderdelivery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOrderDeliveryMapper extends BaseRowMapper<RetailStoreOrderDelivery>{
	
	protected RetailStoreOrderDelivery internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderDelivery retailStoreOrderDelivery = getRetailStoreOrderDelivery();		
		 		
 		setId(retailStoreOrderDelivery, rs, rowNumber); 		
 		setWho(retailStoreOrderDelivery, rs, rowNumber); 		
 		setDeliveryTime(retailStoreOrderDelivery, rs, rowNumber); 		
 		setVersion(retailStoreOrderDelivery, rs, rowNumber);

		return retailStoreOrderDelivery;
	}
	
	protected RetailStoreOrderDelivery getRetailStoreOrderDelivery(){
		return new RetailStoreOrderDelivery();
	}		
		
	protected void setId(RetailStoreOrderDelivery retailStoreOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderDeliveryTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderDelivery.setId(id);
	}
		
	protected void setWho(RetailStoreOrderDelivery retailStoreOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(RetailStoreOrderDeliveryTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderDelivery.setWho(who);
	}
		
	protected void setDeliveryTime(RetailStoreOrderDelivery retailStoreOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date deliveryTime = rs.getDate(RetailStoreOrderDeliveryTable.COLUMN_DELIVERY_TIME);
		if(deliveryTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderDelivery.setDeliveryTime(deliveryTime);
	}
		
	protected void setVersion(RetailStoreOrderDelivery retailStoreOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderDeliveryTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderDelivery.setVersion(version);
	}
		
		

}



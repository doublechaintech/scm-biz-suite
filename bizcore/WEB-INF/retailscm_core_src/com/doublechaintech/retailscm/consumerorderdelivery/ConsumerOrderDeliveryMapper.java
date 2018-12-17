
package com.doublechaintech.retailscm.consumerorderdelivery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ConsumerOrderDeliveryMapper extends BaseRowMapper<ConsumerOrderDelivery>{
	
	protected ConsumerOrderDelivery internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderDelivery consumerOrderDelivery = getConsumerOrderDelivery();		
		 		
 		setId(consumerOrderDelivery, rs, rowNumber); 		
 		setWho(consumerOrderDelivery, rs, rowNumber); 		
 		setDeliveryTime(consumerOrderDelivery, rs, rowNumber); 		
 		setVersion(consumerOrderDelivery, rs, rowNumber);

		return consumerOrderDelivery;
	}
	
	protected ConsumerOrderDelivery getConsumerOrderDelivery(){
		return new ConsumerOrderDelivery();
	}		
		
	protected void setId(ConsumerOrderDelivery consumerOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ConsumerOrderDeliveryTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderDelivery.setId(id);
	}
		
	protected void setWho(ConsumerOrderDelivery consumerOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(ConsumerOrderDeliveryTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderDelivery.setWho(who);
	}
		
	protected void setDeliveryTime(ConsumerOrderDelivery consumerOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date deliveryTime = rs.getDate(ConsumerOrderDeliveryTable.COLUMN_DELIVERY_TIME);
		if(deliveryTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderDelivery.setDeliveryTime(deliveryTime);
	}
		
	protected void setVersion(ConsumerOrderDelivery consumerOrderDelivery, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ConsumerOrderDeliveryTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderDelivery.setVersion(version);
	}
		
		

}




package com.doublechaintech.retailscm.consumerordershipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ConsumerOrderShipmentMapper extends BaseRowMapper<ConsumerOrderShipment>{
	
	protected ConsumerOrderShipment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderShipment consumerOrderShipment = getConsumerOrderShipment();		
		 		
 		setId(consumerOrderShipment, rs, rowNumber); 		
 		setWho(consumerOrderShipment, rs, rowNumber); 		
 		setShipTime(consumerOrderShipment, rs, rowNumber); 		
 		setVersion(consumerOrderShipment, rs, rowNumber);

		return consumerOrderShipment;
	}
	
	protected ConsumerOrderShipment getConsumerOrderShipment(){
		return new ConsumerOrderShipment();
	}		
		
	protected void setId(ConsumerOrderShipment consumerOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ConsumerOrderShipmentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShipment.setId(id);
	}
		
	protected void setWho(ConsumerOrderShipment consumerOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(ConsumerOrderShipmentTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShipment.setWho(who);
	}
		
	protected void setShipTime(ConsumerOrderShipment consumerOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date shipTime = rs.getDate(ConsumerOrderShipmentTable.COLUMN_SHIP_TIME);
		if(shipTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShipment.setShipTime(shipTime);
	}
		
	protected void setVersion(ConsumerOrderShipment consumerOrderShipment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ConsumerOrderShipmentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShipment.setVersion(version);
	}
		
		

}



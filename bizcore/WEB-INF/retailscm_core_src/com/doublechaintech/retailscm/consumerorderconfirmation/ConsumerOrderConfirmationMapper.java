
package com.doublechaintech.retailscm.consumerorderconfirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ConsumerOrderConfirmationMapper extends BaseRowMapper<ConsumerOrderConfirmation>{
	
	protected ConsumerOrderConfirmation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderConfirmation consumerOrderConfirmation = getConsumerOrderConfirmation();		
		 		
 		setId(consumerOrderConfirmation, rs, rowNumber); 		
 		setWho(consumerOrderConfirmation, rs, rowNumber); 		
 		setConfirmTime(consumerOrderConfirmation, rs, rowNumber); 		
 		setVersion(consumerOrderConfirmation, rs, rowNumber);

		return consumerOrderConfirmation;
	}
	
	protected ConsumerOrderConfirmation getConsumerOrderConfirmation(){
		return new ConsumerOrderConfirmation();
	}		
		
	protected void setId(ConsumerOrderConfirmation consumerOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ConsumerOrderConfirmationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderConfirmation.setId(id);
	}
		
	protected void setWho(ConsumerOrderConfirmation consumerOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(ConsumerOrderConfirmationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderConfirmation.setWho(who);
	}
		
	protected void setConfirmTime(ConsumerOrderConfirmation consumerOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date confirmTime = rs.getDate(ConsumerOrderConfirmationTable.COLUMN_CONFIRM_TIME);
		if(confirmTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderConfirmation.setConfirmTime(confirmTime);
	}
		
	protected void setVersion(ConsumerOrderConfirmation consumerOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ConsumerOrderConfirmationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderConfirmation.setVersion(version);
	}
		
		

}



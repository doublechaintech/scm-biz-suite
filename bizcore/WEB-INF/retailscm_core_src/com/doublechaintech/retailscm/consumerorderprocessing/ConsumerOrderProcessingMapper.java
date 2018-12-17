
package com.doublechaintech.retailscm.consumerorderprocessing;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ConsumerOrderProcessingMapper extends BaseRowMapper<ConsumerOrderProcessing>{
	
	protected ConsumerOrderProcessing internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderProcessing consumerOrderProcessing = getConsumerOrderProcessing();		
		 		
 		setId(consumerOrderProcessing, rs, rowNumber); 		
 		setWho(consumerOrderProcessing, rs, rowNumber); 		
 		setProcessTime(consumerOrderProcessing, rs, rowNumber); 		
 		setVersion(consumerOrderProcessing, rs, rowNumber);

		return consumerOrderProcessing;
	}
	
	protected ConsumerOrderProcessing getConsumerOrderProcessing(){
		return new ConsumerOrderProcessing();
	}		
		
	protected void setId(ConsumerOrderProcessing consumerOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ConsumerOrderProcessingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderProcessing.setId(id);
	}
		
	protected void setWho(ConsumerOrderProcessing consumerOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(ConsumerOrderProcessingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderProcessing.setWho(who);
	}
		
	protected void setProcessTime(ConsumerOrderProcessing consumerOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date processTime = rs.getDate(ConsumerOrderProcessingTable.COLUMN_PROCESS_TIME);
		if(processTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderProcessing.setProcessTime(processTime);
	}
		
	protected void setVersion(ConsumerOrderProcessing consumerOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ConsumerOrderProcessingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderProcessing.setVersion(version);
	}
		
		

}



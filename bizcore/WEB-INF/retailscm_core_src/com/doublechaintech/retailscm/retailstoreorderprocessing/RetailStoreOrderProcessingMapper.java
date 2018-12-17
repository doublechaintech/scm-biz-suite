
package com.doublechaintech.retailscm.retailstoreorderprocessing;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOrderProcessingMapper extends BaseRowMapper<RetailStoreOrderProcessing>{
	
	protected RetailStoreOrderProcessing internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderProcessing retailStoreOrderProcessing = getRetailStoreOrderProcessing();		
		 		
 		setId(retailStoreOrderProcessing, rs, rowNumber); 		
 		setWho(retailStoreOrderProcessing, rs, rowNumber); 		
 		setProcessTime(retailStoreOrderProcessing, rs, rowNumber); 		
 		setVersion(retailStoreOrderProcessing, rs, rowNumber);

		return retailStoreOrderProcessing;
	}
	
	protected RetailStoreOrderProcessing getRetailStoreOrderProcessing(){
		return new RetailStoreOrderProcessing();
	}		
		
	protected void setId(RetailStoreOrderProcessing retailStoreOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderProcessingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderProcessing.setId(id);
	}
		
	protected void setWho(RetailStoreOrderProcessing retailStoreOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(RetailStoreOrderProcessingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderProcessing.setWho(who);
	}
		
	protected void setProcessTime(RetailStoreOrderProcessing retailStoreOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date processTime = rs.getDate(RetailStoreOrderProcessingTable.COLUMN_PROCESS_TIME);
		if(processTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderProcessing.setProcessTime(processTime);
	}
		
	protected void setVersion(RetailStoreOrderProcessing retailStoreOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderProcessingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderProcessing.setVersion(version);
	}
		
		

}



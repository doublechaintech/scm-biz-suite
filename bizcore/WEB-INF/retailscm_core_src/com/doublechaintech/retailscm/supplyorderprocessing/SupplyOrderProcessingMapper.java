
package com.doublechaintech.retailscm.supplyorderprocessing;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SupplyOrderProcessingMapper extends BaseRowMapper<SupplyOrderProcessing>{
	
	protected SupplyOrderProcessing internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderProcessing supplyOrderProcessing = getSupplyOrderProcessing();		
		 		
 		setId(supplyOrderProcessing, rs, rowNumber); 		
 		setWho(supplyOrderProcessing, rs, rowNumber); 		
 		setProcessTime(supplyOrderProcessing, rs, rowNumber); 		
 		setVersion(supplyOrderProcessing, rs, rowNumber);

		return supplyOrderProcessing;
	}
	
	protected SupplyOrderProcessing getSupplyOrderProcessing(){
		return new SupplyOrderProcessing();
	}		
		
	protected void setId(SupplyOrderProcessing supplyOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderProcessingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderProcessing.setId(id);
	}
		
	protected void setWho(SupplyOrderProcessing supplyOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SupplyOrderProcessingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderProcessing.setWho(who);
	}
		
	protected void setProcessTime(SupplyOrderProcessing supplyOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date processTime = rs.getDate(SupplyOrderProcessingTable.COLUMN_PROCESS_TIME);
		if(processTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderProcessing.setProcessTime(processTime);
	}
		
	protected void setVersion(SupplyOrderProcessing supplyOrderProcessing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderProcessingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderProcessing.setVersion(version);
	}
		
		

}



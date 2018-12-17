
package com.doublechaintech.retailscm.supplyorderconfirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SupplyOrderConfirmationMapper extends BaseRowMapper<SupplyOrderConfirmation>{
	
	protected SupplyOrderConfirmation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderConfirmation supplyOrderConfirmation = getSupplyOrderConfirmation();		
		 		
 		setId(supplyOrderConfirmation, rs, rowNumber); 		
 		setWho(supplyOrderConfirmation, rs, rowNumber); 		
 		setConfirmTime(supplyOrderConfirmation, rs, rowNumber); 		
 		setVersion(supplyOrderConfirmation, rs, rowNumber);

		return supplyOrderConfirmation;
	}
	
	protected SupplyOrderConfirmation getSupplyOrderConfirmation(){
		return new SupplyOrderConfirmation();
	}		
		
	protected void setId(SupplyOrderConfirmation supplyOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderConfirmationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderConfirmation.setId(id);
	}
		
	protected void setWho(SupplyOrderConfirmation supplyOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SupplyOrderConfirmationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderConfirmation.setWho(who);
	}
		
	protected void setConfirmTime(SupplyOrderConfirmation supplyOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date confirmTime = rs.getDate(SupplyOrderConfirmationTable.COLUMN_CONFIRM_TIME);
		if(confirmTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderConfirmation.setConfirmTime(confirmTime);
	}
		
	protected void setVersion(SupplyOrderConfirmation supplyOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderConfirmationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderConfirmation.setVersion(version);
	}
		
		

}



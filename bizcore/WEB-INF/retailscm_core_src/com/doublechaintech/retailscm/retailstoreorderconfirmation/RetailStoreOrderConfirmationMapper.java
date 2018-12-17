
package com.doublechaintech.retailscm.retailstoreorderconfirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOrderConfirmationMapper extends BaseRowMapper<RetailStoreOrderConfirmation>{
	
	protected RetailStoreOrderConfirmation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderConfirmation retailStoreOrderConfirmation = getRetailStoreOrderConfirmation();		
		 		
 		setId(retailStoreOrderConfirmation, rs, rowNumber); 		
 		setWho(retailStoreOrderConfirmation, rs, rowNumber); 		
 		setConfirmTime(retailStoreOrderConfirmation, rs, rowNumber); 		
 		setVersion(retailStoreOrderConfirmation, rs, rowNumber);

		return retailStoreOrderConfirmation;
	}
	
	protected RetailStoreOrderConfirmation getRetailStoreOrderConfirmation(){
		return new RetailStoreOrderConfirmation();
	}		
		
	protected void setId(RetailStoreOrderConfirmation retailStoreOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderConfirmationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderConfirmation.setId(id);
	}
		
	protected void setWho(RetailStoreOrderConfirmation retailStoreOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(RetailStoreOrderConfirmationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderConfirmation.setWho(who);
	}
		
	protected void setConfirmTime(RetailStoreOrderConfirmation retailStoreOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date confirmTime = rs.getDate(RetailStoreOrderConfirmationTable.COLUMN_CONFIRM_TIME);
		if(confirmTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderConfirmation.setConfirmTime(confirmTime);
	}
		
	protected void setVersion(RetailStoreOrderConfirmation retailStoreOrderConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderConfirmationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderConfirmation.setVersion(version);
	}
		
		

}



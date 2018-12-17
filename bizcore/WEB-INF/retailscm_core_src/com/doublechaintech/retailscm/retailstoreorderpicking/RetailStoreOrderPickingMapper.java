
package com.doublechaintech.retailscm.retailstoreorderpicking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOrderPickingMapper extends BaseRowMapper<RetailStoreOrderPicking>{
	
	protected RetailStoreOrderPicking internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderPicking retailStoreOrderPicking = getRetailStoreOrderPicking();		
		 		
 		setId(retailStoreOrderPicking, rs, rowNumber); 		
 		setWho(retailStoreOrderPicking, rs, rowNumber); 		
 		setProcessTime(retailStoreOrderPicking, rs, rowNumber); 		
 		setVersion(retailStoreOrderPicking, rs, rowNumber);

		return retailStoreOrderPicking;
	}
	
	protected RetailStoreOrderPicking getRetailStoreOrderPicking(){
		return new RetailStoreOrderPicking();
	}		
		
	protected void setId(RetailStoreOrderPicking retailStoreOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderPickingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPicking.setId(id);
	}
		
	protected void setWho(RetailStoreOrderPicking retailStoreOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(RetailStoreOrderPickingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPicking.setWho(who);
	}
		
	protected void setProcessTime(RetailStoreOrderPicking retailStoreOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date processTime = rs.getDate(RetailStoreOrderPickingTable.COLUMN_PROCESS_TIME);
		if(processTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPicking.setProcessTime(processTime);
	}
		
	protected void setVersion(RetailStoreOrderPicking retailStoreOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderPickingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPicking.setVersion(version);
	}
		
		

}



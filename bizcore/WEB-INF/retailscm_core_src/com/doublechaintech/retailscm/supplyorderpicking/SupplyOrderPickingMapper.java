
package com.doublechaintech.retailscm.supplyorderpicking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SupplyOrderPickingMapper extends BaseRowMapper<SupplyOrderPicking>{
	
	protected SupplyOrderPicking internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderPicking supplyOrderPicking = getSupplyOrderPicking();		
		 		
 		setId(supplyOrderPicking, rs, rowNumber); 		
 		setWho(supplyOrderPicking, rs, rowNumber); 		
 		setProcessTime(supplyOrderPicking, rs, rowNumber); 		
 		setVersion(supplyOrderPicking, rs, rowNumber);

		return supplyOrderPicking;
	}
	
	protected SupplyOrderPicking getSupplyOrderPicking(){
		return new SupplyOrderPicking();
	}		
		
	protected void setId(SupplyOrderPicking supplyOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderPickingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPicking.setId(id);
	}
		
	protected void setWho(SupplyOrderPicking supplyOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SupplyOrderPickingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPicking.setWho(who);
	}
		
	protected void setProcessTime(SupplyOrderPicking supplyOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date processTime = rs.getDate(SupplyOrderPickingTable.COLUMN_PROCESS_TIME);
		if(processTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPicking.setProcessTime(processTime);
	}
		
	protected void setVersion(SupplyOrderPicking supplyOrderPicking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderPickingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPicking.setVersion(version);
	}
		
		

}



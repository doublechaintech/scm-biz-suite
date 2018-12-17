
package com.doublechaintech.retailscm.supplyorderapproval;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SupplyOrderApprovalMapper extends BaseRowMapper<SupplyOrderApproval>{
	
	protected SupplyOrderApproval internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderApproval supplyOrderApproval = getSupplyOrderApproval();		
		 		
 		setId(supplyOrderApproval, rs, rowNumber); 		
 		setWho(supplyOrderApproval, rs, rowNumber); 		
 		setApproveTime(supplyOrderApproval, rs, rowNumber); 		
 		setVersion(supplyOrderApproval, rs, rowNumber);

		return supplyOrderApproval;
	}
	
	protected SupplyOrderApproval getSupplyOrderApproval(){
		return new SupplyOrderApproval();
	}		
		
	protected void setId(SupplyOrderApproval supplyOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderApprovalTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderApproval.setId(id);
	}
		
	protected void setWho(SupplyOrderApproval supplyOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SupplyOrderApprovalTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderApproval.setWho(who);
	}
		
	protected void setApproveTime(SupplyOrderApproval supplyOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date approveTime = rs.getDate(SupplyOrderApprovalTable.COLUMN_APPROVE_TIME);
		if(approveTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderApproval.setApproveTime(approveTime);
	}
		
	protected void setVersion(SupplyOrderApproval supplyOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderApprovalTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderApproval.setVersion(version);
	}
		
		

}



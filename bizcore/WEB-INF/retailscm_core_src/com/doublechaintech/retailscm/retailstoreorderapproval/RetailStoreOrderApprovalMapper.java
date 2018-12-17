
package com.doublechaintech.retailscm.retailstoreorderapproval;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOrderApprovalMapper extends BaseRowMapper<RetailStoreOrderApproval>{
	
	protected RetailStoreOrderApproval internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderApproval retailStoreOrderApproval = getRetailStoreOrderApproval();		
		 		
 		setId(retailStoreOrderApproval, rs, rowNumber); 		
 		setWho(retailStoreOrderApproval, rs, rowNumber); 		
 		setApproveTime(retailStoreOrderApproval, rs, rowNumber); 		
 		setVersion(retailStoreOrderApproval, rs, rowNumber);

		return retailStoreOrderApproval;
	}
	
	protected RetailStoreOrderApproval getRetailStoreOrderApproval(){
		return new RetailStoreOrderApproval();
	}		
		
	protected void setId(RetailStoreOrderApproval retailStoreOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderApprovalTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderApproval.setId(id);
	}
		
	protected void setWho(RetailStoreOrderApproval retailStoreOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(RetailStoreOrderApprovalTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderApproval.setWho(who);
	}
		
	protected void setApproveTime(RetailStoreOrderApproval retailStoreOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date approveTime = rs.getDate(RetailStoreOrderApprovalTable.COLUMN_APPROVE_TIME);
		if(approveTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderApproval.setApproveTime(approveTime);
	}
		
	protected void setVersion(RetailStoreOrderApproval retailStoreOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderApprovalTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderApproval.setVersion(version);
	}
		
		

}



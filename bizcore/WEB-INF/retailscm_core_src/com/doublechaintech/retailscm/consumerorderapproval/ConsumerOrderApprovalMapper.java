
package com.doublechaintech.retailscm.consumerorderapproval;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ConsumerOrderApprovalMapper extends BaseRowMapper<ConsumerOrderApproval>{
	
	protected ConsumerOrderApproval internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderApproval consumerOrderApproval = getConsumerOrderApproval();		
		 		
 		setId(consumerOrderApproval, rs, rowNumber); 		
 		setWho(consumerOrderApproval, rs, rowNumber); 		
 		setApproveTime(consumerOrderApproval, rs, rowNumber); 		
 		setVersion(consumerOrderApproval, rs, rowNumber);

		return consumerOrderApproval;
	}
	
	protected ConsumerOrderApproval getConsumerOrderApproval(){
		return new ConsumerOrderApproval();
	}		
		
	protected void setId(ConsumerOrderApproval consumerOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ConsumerOrderApprovalTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderApproval.setId(id);
	}
		
	protected void setWho(ConsumerOrderApproval consumerOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(ConsumerOrderApprovalTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderApproval.setWho(who);
	}
		
	protected void setApproveTime(ConsumerOrderApproval consumerOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date approveTime = rs.getDate(ConsumerOrderApprovalTable.COLUMN_APPROVE_TIME);
		if(approveTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderApproval.setApproveTime(approveTime);
	}
		
	protected void setVersion(ConsumerOrderApproval consumerOrderApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ConsumerOrderApprovalTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderApproval.setVersion(version);
	}
		
		

}



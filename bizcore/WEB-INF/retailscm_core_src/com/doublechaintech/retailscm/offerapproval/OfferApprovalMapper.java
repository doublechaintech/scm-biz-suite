
package com.doublechaintech.retailscm.offerapproval;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class OfferApprovalMapper extends BaseRowMapper<OfferApproval>{
	
	protected OfferApproval internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OfferApproval offerApproval = getOfferApproval();		
		 		
 		setId(offerApproval, rs, rowNumber); 		
 		setWho(offerApproval, rs, rowNumber); 		
 		setApproveTime(offerApproval, rs, rowNumber); 		
 		setComments(offerApproval, rs, rowNumber); 		
 		setVersion(offerApproval, rs, rowNumber);

		return offerApproval;
	}
	
	protected OfferApproval getOfferApproval(){
		return new OfferApproval();
	}		
		
	protected void setId(OfferApproval offerApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OfferApprovalTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerApproval.setId(id);
	}
		
	protected void setWho(OfferApproval offerApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(OfferApprovalTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerApproval.setWho(who);
	}
		
	protected void setApproveTime(OfferApproval offerApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date approveTime = rs.getDate(OfferApprovalTable.COLUMN_APPROVE_TIME);
		if(approveTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerApproval.setApproveTime(approveTime);
	}
		
	protected void setComments(OfferApproval offerApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(OfferApprovalTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerApproval.setComments(comments);
	}
		
	protected void setVersion(OfferApproval offerApproval, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OfferApprovalTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerApproval.setVersion(version);
	}
		
		

}



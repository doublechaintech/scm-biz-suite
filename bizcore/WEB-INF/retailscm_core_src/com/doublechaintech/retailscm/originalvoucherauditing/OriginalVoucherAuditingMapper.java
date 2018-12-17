
package com.doublechaintech.retailscm.originalvoucherauditing;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class OriginalVoucherAuditingMapper extends BaseRowMapper<OriginalVoucherAuditing>{
	
	protected OriginalVoucherAuditing internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OriginalVoucherAuditing originalVoucherAuditing = getOriginalVoucherAuditing();		
		 		
 		setId(originalVoucherAuditing, rs, rowNumber); 		
 		setWho(originalVoucherAuditing, rs, rowNumber); 		
 		setComments(originalVoucherAuditing, rs, rowNumber); 		
 		setMakeDate(originalVoucherAuditing, rs, rowNumber); 		
 		setVersion(originalVoucherAuditing, rs, rowNumber);

		return originalVoucherAuditing;
	}
	
	protected OriginalVoucherAuditing getOriginalVoucherAuditing(){
		return new OriginalVoucherAuditing();
	}		
		
	protected void setId(OriginalVoucherAuditing originalVoucherAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OriginalVoucherAuditingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherAuditing.setId(id);
	}
		
	protected void setWho(OriginalVoucherAuditing originalVoucherAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(OriginalVoucherAuditingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherAuditing.setWho(who);
	}
		
	protected void setComments(OriginalVoucherAuditing originalVoucherAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(OriginalVoucherAuditingTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherAuditing.setComments(comments);
	}
		
	protected void setMakeDate(OriginalVoucherAuditing originalVoucherAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(OriginalVoucherAuditingTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherAuditing.setMakeDate(makeDate);
	}
		
	protected void setVersion(OriginalVoucherAuditing originalVoucherAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OriginalVoucherAuditingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherAuditing.setVersion(version);
	}
		
		

}



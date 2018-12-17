
package com.doublechaintech.retailscm.originalvoucherconfirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class OriginalVoucherConfirmationMapper extends BaseRowMapper<OriginalVoucherConfirmation>{
	
	protected OriginalVoucherConfirmation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OriginalVoucherConfirmation originalVoucherConfirmation = getOriginalVoucherConfirmation();		
		 		
 		setId(originalVoucherConfirmation, rs, rowNumber); 		
 		setWho(originalVoucherConfirmation, rs, rowNumber); 		
 		setComments(originalVoucherConfirmation, rs, rowNumber); 		
 		setMakeDate(originalVoucherConfirmation, rs, rowNumber); 		
 		setVersion(originalVoucherConfirmation, rs, rowNumber);

		return originalVoucherConfirmation;
	}
	
	protected OriginalVoucherConfirmation getOriginalVoucherConfirmation(){
		return new OriginalVoucherConfirmation();
	}		
		
	protected void setId(OriginalVoucherConfirmation originalVoucherConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OriginalVoucherConfirmationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherConfirmation.setId(id);
	}
		
	protected void setWho(OriginalVoucherConfirmation originalVoucherConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(OriginalVoucherConfirmationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherConfirmation.setWho(who);
	}
		
	protected void setComments(OriginalVoucherConfirmation originalVoucherConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(OriginalVoucherConfirmationTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherConfirmation.setComments(comments);
	}
		
	protected void setMakeDate(OriginalVoucherConfirmation originalVoucherConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(OriginalVoucherConfirmationTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherConfirmation.setMakeDate(makeDate);
	}
		
	protected void setVersion(OriginalVoucherConfirmation originalVoucherConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OriginalVoucherConfirmationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherConfirmation.setVersion(version);
	}
		
		

}



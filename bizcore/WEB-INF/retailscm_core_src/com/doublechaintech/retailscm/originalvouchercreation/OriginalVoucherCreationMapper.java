
package com.doublechaintech.retailscm.originalvouchercreation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class OriginalVoucherCreationMapper extends BaseRowMapper<OriginalVoucherCreation>{
	
	protected OriginalVoucherCreation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OriginalVoucherCreation originalVoucherCreation = getOriginalVoucherCreation();		
		 		
 		setId(originalVoucherCreation, rs, rowNumber); 		
 		setWho(originalVoucherCreation, rs, rowNumber); 		
 		setComments(originalVoucherCreation, rs, rowNumber); 		
 		setMakeDate(originalVoucherCreation, rs, rowNumber); 		
 		setVersion(originalVoucherCreation, rs, rowNumber);

		return originalVoucherCreation;
	}
	
	protected OriginalVoucherCreation getOriginalVoucherCreation(){
		return new OriginalVoucherCreation();
	}		
		
	protected void setId(OriginalVoucherCreation originalVoucherCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OriginalVoucherCreationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherCreation.setId(id);
	}
		
	protected void setWho(OriginalVoucherCreation originalVoucherCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(OriginalVoucherCreationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherCreation.setWho(who);
	}
		
	protected void setComments(OriginalVoucherCreation originalVoucherCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(OriginalVoucherCreationTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherCreation.setComments(comments);
	}
		
	protected void setMakeDate(OriginalVoucherCreation originalVoucherCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(OriginalVoucherCreationTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherCreation.setMakeDate(makeDate);
	}
		
	protected void setVersion(OriginalVoucherCreation originalVoucherCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OriginalVoucherCreationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucherCreation.setVersion(version);
	}
		
		

}



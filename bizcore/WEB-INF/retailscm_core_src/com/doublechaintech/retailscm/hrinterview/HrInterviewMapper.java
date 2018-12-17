
package com.doublechaintech.retailscm.hrinterview;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class HrInterviewMapper extends BaseRowMapper<HrInterview>{
	
	protected HrInterview internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		HrInterview hrInterview = getHrInterview();		
		 		
 		setId(hrInterview, rs, rowNumber); 		
 		setWho(hrInterview, rs, rowNumber); 		
 		setInterviewTime(hrInterview, rs, rowNumber); 		
 		setComments(hrInterview, rs, rowNumber); 		
 		setVersion(hrInterview, rs, rowNumber);

		return hrInterview;
	}
	
	protected HrInterview getHrInterview(){
		return new HrInterview();
	}		
		
	protected void setId(HrInterview hrInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(HrInterviewTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		hrInterview.setId(id);
	}
		
	protected void setWho(HrInterview hrInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(HrInterviewTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		hrInterview.setWho(who);
	}
		
	protected void setInterviewTime(HrInterview hrInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date interviewTime = rs.getDate(HrInterviewTable.COLUMN_INTERVIEW_TIME);
		if(interviewTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		hrInterview.setInterviewTime(interviewTime);
	}
		
	protected void setComments(HrInterview hrInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(HrInterviewTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		hrInterview.setComments(comments);
	}
		
	protected void setVersion(HrInterview hrInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(HrInterviewTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		hrInterview.setVersion(version);
	}
		
		

}




package com.doublechaintech.retailscm.professioninterview;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ProfessionInterviewMapper extends BaseRowMapper<ProfessionInterview>{
	
	protected ProfessionInterview internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ProfessionInterview professionInterview = getProfessionInterview();		
		 		
 		setId(professionInterview, rs, rowNumber); 		
 		setWho(professionInterview, rs, rowNumber); 		
 		setInterviewTime(professionInterview, rs, rowNumber); 		
 		setComments(professionInterview, rs, rowNumber); 		
 		setVersion(professionInterview, rs, rowNumber);

		return professionInterview;
	}
	
	protected ProfessionInterview getProfessionInterview(){
		return new ProfessionInterview();
	}		
		
	protected void setId(ProfessionInterview professionInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ProfessionInterviewTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		professionInterview.setId(id);
	}
		
	protected void setWho(ProfessionInterview professionInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(ProfessionInterviewTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		professionInterview.setWho(who);
	}
		
	protected void setInterviewTime(ProfessionInterview professionInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date interviewTime = rs.getDate(ProfessionInterviewTable.COLUMN_INTERVIEW_TIME);
		if(interviewTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		professionInterview.setInterviewTime(interviewTime);
	}
		
	protected void setComments(ProfessionInterview professionInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(ProfessionInterviewTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		professionInterview.setComments(comments);
	}
		
	protected void setVersion(ProfessionInterview professionInterview, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ProfessionInterviewTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		professionInterview.setVersion(version);
	}
		
		

}



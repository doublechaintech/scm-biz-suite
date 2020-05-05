
package com.doublechaintech.retailscm.view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ViewMapper extends BaseRowMapper<View>{
	
	protected View internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		View view = getView();		
		 		
 		setId(view, rs, rowNumber); 		
 		setWho(view, rs, rowNumber); 		
 		setAssessment(view, rs, rowNumber); 		
 		setInterviewTime(view, rs, rowNumber); 		
 		setVersion(view, rs, rowNumber);

		return view;
	}
	
	protected View getView(){
		return new View();
	}		
		
	protected void setId(View view, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ViewTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		view.setId(id);
	}
		
	protected void setWho(View view, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String who = rs.getString(ViewTable.COLUMN_WHO);
		
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		view.setWho(who);
	}
		
	protected void setAssessment(View view, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String assessment = rs.getString(ViewTable.COLUMN_ASSESSMENT);
		
		if(assessment == null){
			//do nothing when nothing found in database
			return;
		}
		
		view.setAssessment(assessment);
	}
		
	protected void setInterviewTime(View view, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date interviewTime = rs.getDate(ViewTable.COLUMN_INTERVIEW_TIME);
		
		if(interviewTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		view.setInterviewTime(interviewTime);
	}
		
	protected void setVersion(View view, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ViewTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		view.setVersion(version);
	}
		
		

}



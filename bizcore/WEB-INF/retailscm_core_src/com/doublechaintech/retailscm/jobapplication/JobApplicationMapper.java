
package com.doublechaintech.retailscm.jobapplication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class JobApplicationMapper extends BaseRowMapper<JobApplication>{
	
	protected JobApplication internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		JobApplication jobApplication = getJobApplication();		
		 		
 		setId(jobApplication, rs, rowNumber); 		
 		setApplicationTime(jobApplication, rs, rowNumber); 		
 		setWho(jobApplication, rs, rowNumber); 		
 		setComments(jobApplication, rs, rowNumber); 		
 		setVersion(jobApplication, rs, rowNumber);

		return jobApplication;
	}
	
	protected JobApplication getJobApplication(){
		return new JobApplication();
	}		
		
	protected void setId(JobApplication jobApplication, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(JobApplicationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		jobApplication.setId(id);
	}
		
	protected void setApplicationTime(JobApplication jobApplication, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date applicationTime = rs.getDate(JobApplicationTable.COLUMN_APPLICATION_TIME);
		if(applicationTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		jobApplication.setApplicationTime(applicationTime);
	}
		
	protected void setWho(JobApplication jobApplication, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(JobApplicationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		jobApplication.setWho(who);
	}
		
	protected void setComments(JobApplication jobApplication, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(JobApplicationTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		jobApplication.setComments(comments);
	}
		
	protected void setVersion(JobApplication jobApplication, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(JobApplicationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		jobApplication.setVersion(version);
	}
		
		

}



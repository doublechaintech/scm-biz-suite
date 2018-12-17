
package com.doublechaintech.retailscm.employeeboarding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class EmployeeBoardingMapper extends BaseRowMapper<EmployeeBoarding>{
	
	protected EmployeeBoarding internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EmployeeBoarding employeeBoarding = getEmployeeBoarding();		
		 		
 		setId(employeeBoarding, rs, rowNumber); 		
 		setWho(employeeBoarding, rs, rowNumber); 		
 		setEmployTime(employeeBoarding, rs, rowNumber); 		
 		setComments(employeeBoarding, rs, rowNumber); 		
 		setVersion(employeeBoarding, rs, rowNumber);

		return employeeBoarding;
	}
	
	protected EmployeeBoarding getEmployeeBoarding(){
		return new EmployeeBoarding();
	}		
		
	protected void setId(EmployeeBoarding employeeBoarding, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(EmployeeBoardingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeBoarding.setId(id);
	}
		
	protected void setWho(EmployeeBoarding employeeBoarding, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(EmployeeBoardingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeBoarding.setWho(who);
	}
		
	protected void setEmployTime(EmployeeBoarding employeeBoarding, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date employTime = rs.getDate(EmployeeBoardingTable.COLUMN_EMPLOY_TIME);
		if(employTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeBoarding.setEmployTime(employTime);
	}
		
	protected void setComments(EmployeeBoarding employeeBoarding, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(EmployeeBoardingTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeBoarding.setComments(comments);
	}
		
	protected void setVersion(EmployeeBoarding employeeBoarding, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(EmployeeBoardingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeBoarding.setVersion(version);
	}
		
		

}



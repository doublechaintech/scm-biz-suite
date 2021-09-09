
package com.doublechaintech.retailscm.employeeworkexperience;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;

public class EmployeeWorkExperienceMapper extends BaseRowMapper<EmployeeWorkExperience>{

	protected EmployeeWorkExperience internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EmployeeWorkExperience employeeWorkExperience = getEmployeeWorkExperience();
		
 		setId(employeeWorkExperience, rs, rowNumber);
 		setEmployee(employeeWorkExperience, rs, rowNumber);
 		setStart(employeeWorkExperience, rs, rowNumber);
 		setEnd(employeeWorkExperience, rs, rowNumber);
 		setCompany(employeeWorkExperience, rs, rowNumber);
 		setDescription(employeeWorkExperience, rs, rowNumber);
 		setVersion(employeeWorkExperience, rs, rowNumber);

    
		return employeeWorkExperience;
	}

	protected EmployeeWorkExperience getEmployeeWorkExperience(){
	  EmployeeWorkExperience entity = new EmployeeWorkExperience();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(EmployeeWorkExperienceTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeWorkExperience.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setEmployee(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId;
 		try{
 		  employeeId = rs.getString(EmployeeWorkExperienceTable.COLUMN_EMPLOYEE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = employeeWorkExperience.getEmployee();
 		if( employee != null ){
 			//if the root object 'employeeWorkExperience' already have the property, just set the id for it;
 			employee.setId(employeeId);

 			return;
 		}
 		employeeWorkExperience.setEmployee(createEmptyEmployee(employeeId));
 	}
 	
	protected void setStart(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date start = rs.getDate(EmployeeWorkExperienceTable.COLUMN_START);
		
		if(start == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeWorkExperience.setStart(start);
		}catch (SQLException e){

    }
	}
		
	protected void setEnd(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date end = rs.getDate(EmployeeWorkExperienceTable.COLUMN_END);
		
		if(end == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeWorkExperience.setEnd(end);
		}catch (SQLException e){

    }
	}
		
	protected void setCompany(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String company = rs.getString(EmployeeWorkExperienceTable.COLUMN_COMPANY);
		
		if(company == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeWorkExperience.setCompany(company);
		}catch (SQLException e){

    }
	}
		
	protected void setDescription(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(EmployeeWorkExperienceTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeWorkExperience.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(EmployeeWorkExperience employeeWorkExperience, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(EmployeeWorkExperienceTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeWorkExperience.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected Employee  createEmptyEmployee(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		employee.setVersion(Integer.MAX_VALUE);
 		return employee;
 	}
 	
}



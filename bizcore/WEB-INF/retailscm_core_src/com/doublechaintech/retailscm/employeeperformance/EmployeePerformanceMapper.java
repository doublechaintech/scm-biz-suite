
package com.doublechaintech.retailscm.employeeperformance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;

public class EmployeePerformanceMapper extends BaseRowMapper<EmployeePerformance>{
	
	protected EmployeePerformance internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EmployeePerformance employeePerformance = getEmployeePerformance();		
		 		
 		setId(employeePerformance, rs, rowNumber); 		
 		setEmployee(employeePerformance, rs, rowNumber); 		
 		setPerformanceComment(employeePerformance, rs, rowNumber); 		
 		setVersion(employeePerformance, rs, rowNumber);

		return employeePerformance;
	}
	
	protected EmployeePerformance getEmployeePerformance(){
		return new EmployeePerformance();
	}		
		
	protected void setId(EmployeePerformance employeePerformance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(EmployeePerformanceTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeePerformance.setId(id);
	}
		 		
 	protected void setEmployee(EmployeePerformance employeePerformance, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId = rs.getString(EmployeePerformanceTable.COLUMN_EMPLOYEE);
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = employeePerformance.getEmployee();
 		if( employee != null ){
 			//if the root object 'employeePerformance' already have the property, just set the id for it;
 			employee.setId(employeeId);
 			
 			return;
 		}
 		employeePerformance.setEmployee(createEmptyEmployee(employeeId));
 	}
 	
	protected void setPerformanceComment(EmployeePerformance employeePerformance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String performanceComment = rs.getString(EmployeePerformanceTable.COLUMN_PERFORMANCE_COMMENT);
		
		if(performanceComment == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeePerformance.setPerformanceComment(performanceComment);
	}
		
	protected void setVersion(EmployeePerformance employeePerformance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(EmployeePerformanceTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeePerformance.setVersion(version);
	}
		
		

 	protected Employee  createEmptyEmployee(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		employee.setVersion(Integer.MAX_VALUE);
 		return employee;
 	}
 	
}



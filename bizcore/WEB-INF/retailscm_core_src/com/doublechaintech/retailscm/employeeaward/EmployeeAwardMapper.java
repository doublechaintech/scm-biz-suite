
package com.doublechaintech.retailscm.employeeaward;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;

public class EmployeeAwardMapper extends BaseRowMapper<EmployeeAward>{
	
	protected EmployeeAward internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EmployeeAward employeeAward = getEmployeeAward();		
		 		
 		setId(employeeAward, rs, rowNumber); 		
 		setEmployee(employeeAward, rs, rowNumber); 		
 		setCompleteTime(employeeAward, rs, rowNumber); 		
 		setType(employeeAward, rs, rowNumber); 		
 		setRemark(employeeAward, rs, rowNumber); 		
 		setVersion(employeeAward, rs, rowNumber);

		return employeeAward;
	}
	
	protected EmployeeAward getEmployeeAward(){
		return new EmployeeAward();
	}		
		
	protected void setId(EmployeeAward employeeAward, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(EmployeeAwardTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeAward.setId(id);
	}
		 		
 	protected void setEmployee(EmployeeAward employeeAward, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId = rs.getString(EmployeeAwardTable.COLUMN_EMPLOYEE);
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = employeeAward.getEmployee();
 		if( employee != null ){
 			//if the root object 'employeeAward' already have the property, just set the id for it;
 			employee.setId(employeeId);
 			
 			return;
 		}
 		employeeAward.setEmployee(createEmptyEmployee(employeeId));
 	}
 	
	protected void setCompleteTime(EmployeeAward employeeAward, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date completeTime = rs.getDate(EmployeeAwardTable.COLUMN_COMPLETE_TIME);
		
		if(completeTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeAward.setCompleteTime(completeTime);
	}
		
	protected void setType(EmployeeAward employeeAward, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String type = rs.getString(EmployeeAwardTable.COLUMN_TYPE);
		
		if(type == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeAward.setType(type);
	}
		
	protected void setRemark(EmployeeAward employeeAward, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String remark = rs.getString(EmployeeAwardTable.COLUMN_REMARK);
		
		if(remark == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeAward.setRemark(remark);
	}
		
	protected void setVersion(EmployeeAward employeeAward, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(EmployeeAwardTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeAward.setVersion(version);
	}
		
		

 	protected Employee  createEmptyEmployee(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		employee.setVersion(Integer.MAX_VALUE);
 		return employee;
 	}
 	
}



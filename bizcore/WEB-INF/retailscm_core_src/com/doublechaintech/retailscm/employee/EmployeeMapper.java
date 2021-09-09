
package com.doublechaintech.retailscm.employee;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

public class EmployeeMapper extends BaseRowMapper<Employee>{

	protected Employee internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Employee employee = getEmployee();
		
 		setId(employee, rs, rowNumber);
 		setCompany(employee, rs, rowNumber);
 		setTitle(employee, rs, rowNumber);
 		setDepartment(employee, rs, rowNumber);
 		setFamilyName(employee, rs, rowNumber);
 		setGivenName(employee, rs, rowNumber);
 		setEmail(employee, rs, rowNumber);
 		setCity(employee, rs, rowNumber);
 		setAddress(employee, rs, rowNumber);
 		setCellPhone(employee, rs, rowNumber);
 		setOccupation(employee, rs, rowNumber);
 		setResponsibleFor(employee, rs, rowNumber);
 		setCurrentSalaryGrade(employee, rs, rowNumber);
 		setSalaryAccount(employee, rs, rowNumber);
 		setLastUpdateTime(employee, rs, rowNumber);
 		setVersion(employee, rs, rowNumber);

    
		return employee;
	}

	protected Employee getEmployee(){
	  Employee entity = new Employee();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(EmployeeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setCompany(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(EmployeeTable.COLUMN_COMPANY);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = employee.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		employee.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setTitle(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(EmployeeTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setTitle(title);
		}catch (SQLException e){

    }
	}
		
 	protected void setDepartment(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String levelThreeDepartmentId;
 		try{
 		  levelThreeDepartmentId = rs.getString(EmployeeTable.COLUMN_DEPARTMENT);
 		}catch(SQLException e){
 		  return;
 		}
 		if( levelThreeDepartmentId == null){
 			return;
 		}
 		if( levelThreeDepartmentId.isEmpty()){
 			return;
 		}
 		LevelThreeDepartment levelThreeDepartment = employee.getDepartment();
 		if( levelThreeDepartment != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			levelThreeDepartment.setId(levelThreeDepartmentId);

 			return;
 		}
 		employee.setDepartment(createEmptyDepartment(levelThreeDepartmentId));
 	}
 	
	protected void setFamilyName(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String familyName = rs.getString(EmployeeTable.COLUMN_FAMILY_NAME);
		
		if(familyName == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setFamilyName(familyName);
		}catch (SQLException e){

    }
	}
		
	protected void setGivenName(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String givenName = rs.getString(EmployeeTable.COLUMN_GIVEN_NAME);
		
		if(givenName == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setGivenName(givenName);
		}catch (SQLException e){

    }
	}
		
	protected void setEmail(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String email = rs.getString(EmployeeTable.COLUMN_EMAIL);
		
		if(email == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setEmail(email);
		}catch (SQLException e){

    }
	}
		
	protected void setCity(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String city = rs.getString(EmployeeTable.COLUMN_CITY);
		
		if(city == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setCity(city);
		}catch (SQLException e){

    }
	}
		
	protected void setAddress(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String address = rs.getString(EmployeeTable.COLUMN_ADDRESS);
		
		if(address == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setAddress(address);
		}catch (SQLException e){

    }
	}
		
	protected void setCellPhone(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String cellPhone = rs.getString(EmployeeTable.COLUMN_CELL_PHONE);
		
		if(cellPhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setCellPhone(cellPhone);
		}catch (SQLException e){

    }
	}
		
 	protected void setOccupation(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String occupationTypeId;
 		try{
 		  occupationTypeId = rs.getString(EmployeeTable.COLUMN_OCCUPATION);
 		}catch(SQLException e){
 		  return;
 		}
 		if( occupationTypeId == null){
 			return;
 		}
 		if( occupationTypeId.isEmpty()){
 			return;
 		}
 		OccupationType occupationType = employee.getOccupation();
 		if( occupationType != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			occupationType.setId(occupationTypeId);

 			return;
 		}
 		employee.setOccupation(createEmptyOccupation(occupationTypeId));
 	}
 	
 	protected void setResponsibleFor(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String responsibilityTypeId;
 		try{
 		  responsibilityTypeId = rs.getString(EmployeeTable.COLUMN_RESPONSIBLE_FOR);
 		}catch(SQLException e){
 		  return;
 		}
 		if( responsibilityTypeId == null){
 			return;
 		}
 		if( responsibilityTypeId.isEmpty()){
 			return;
 		}
 		ResponsibilityType responsibilityType = employee.getResponsibleFor();
 		if( responsibilityType != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			responsibilityType.setId(responsibilityTypeId);

 			return;
 		}
 		employee.setResponsibleFor(createEmptyResponsibleFor(responsibilityTypeId));
 	}
 	
 	protected void setCurrentSalaryGrade(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String salaryGradeId;
 		try{
 		  salaryGradeId = rs.getString(EmployeeTable.COLUMN_CURRENT_SALARY_GRADE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( salaryGradeId == null){
 			return;
 		}
 		if( salaryGradeId.isEmpty()){
 			return;
 		}
 		SalaryGrade salaryGrade = employee.getCurrentSalaryGrade();
 		if( salaryGrade != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			salaryGrade.setId(salaryGradeId);

 			return;
 		}
 		employee.setCurrentSalaryGrade(createEmptyCurrentSalaryGrade(salaryGradeId));
 	}
 	
	protected void setSalaryAccount(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String salaryAccount = rs.getString(EmployeeTable.COLUMN_SALARY_ACCOUNT);
		
		if(salaryAccount == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setSalaryAccount(salaryAccount);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(EmployeeTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(EmployeeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected LevelThreeDepartment  createEmptyDepartment(String levelThreeDepartmentId){
 		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
 		levelThreeDepartment.setId(levelThreeDepartmentId);
 		levelThreeDepartment.setVersion(Integer.MAX_VALUE);
 		return levelThreeDepartment;
 	}
 	
 	protected OccupationType  createEmptyOccupation(String occupationTypeId){
 		OccupationType occupationType = new OccupationType();
 		occupationType.setId(occupationTypeId);
 		occupationType.setVersion(Integer.MAX_VALUE);
 		return occupationType;
 	}
 	
 	protected ResponsibilityType  createEmptyResponsibleFor(String responsibilityTypeId){
 		ResponsibilityType responsibilityType = new ResponsibilityType();
 		responsibilityType.setId(responsibilityTypeId);
 		responsibilityType.setVersion(Integer.MAX_VALUE);
 		return responsibilityType;
 	}
 	
 	protected SalaryGrade  createEmptyCurrentSalaryGrade(String salaryGradeId){
 		SalaryGrade salaryGrade = new SalaryGrade();
 		salaryGrade.setId(salaryGradeId);
 		salaryGrade.setVersion(Integer.MAX_VALUE);
 		return salaryGrade;
 	}
 	
}


